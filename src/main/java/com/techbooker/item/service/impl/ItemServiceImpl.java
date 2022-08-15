package com.techbooker.item.service.impl;

import com.techbooker.item.dto.internal.InternalParam;
import com.techbooker.item.dto.ItemInfoResponseDto;
import com.techbooker.item.dto.ItemRequestDto;


import com.techbooker.item.dto.ParamDataDto;
import com.techbooker.item.dto.external.*;
import com.techbooker.item.dto.internal.InternalParamNamesDto;
import com.techbooker.item.http.ClientMethod;
import com.techbooker.item.service.ItemService;
import com.techbooker.item.service.ShopService;

import com.techbooker.item.util.CommonUtl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static com.techbooker.item.dto.external.ParamType.*;

@Service
@Slf4j
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ClientMethod clientMethod;
    private final ShopService shopService;
    private final CommonUtl commonUtl;

    @Override
    public ItemInfoResponseDto searchInfo(ItemRequestDto itemRequest) {
        List<EndpointDataDto> endpointDataDtoList = shopService.findAllEndpoints().getData();
        InternalParamNamesDto internalParamNames = new InternalParamNamesDto();

        List<EndpointDataDto> scanItemEndpoints = endpointDataDtoList.stream()
                .filter(endpointData -> endpointData.getOperation() == Operations.SCAN_ITEM).collect(Collectors.toList());

        for (EndpointDataDto endpointData : scanItemEndpoints) {
            Map<ParamType, Map<String, ParamDataDto>> dataMap = dataParameterBuilder(endpointData, itemRequest);
            String uri = endpointData.getHost() + endpointData.getEndpointUrl();
            Object response = null;

            Map<String, String> uriVariables = new HashMap<>();

            dataMap.get(PATH_PARAM).forEach((paramName, paramValue) -> uriVariables.put(paramName, paramValue.getParamValue()));
            dataMap.get(QUERY_PARAM).forEach((paramName, paramValue) -> uriVariables.put(paramName, paramValue.getParamValue()));

            if (HttpMethod.GET == endpointData.getHttpMethod()) {
                response = clientMethod.getForEntity(Object.class, uri, uriVariables, Optional.empty());
            } else if (HttpMethod.POST == endpointData.getHttpMethod()) {
                JSONObject requestBody = requestBodyCreator(dataMap.get(REQUEST_BODY));
                response = clientMethod.postForEntity(Object.class, uri, requestBody, uriVariables, Optional.empty());
            }
            JSONObject jsonResponse = new JSONObject(((LinkedHashMap) response));
            commonUtl.responseReader(internalParamNames, jsonResponse, dataMap.get(RESPONSE_BODY));
        }
        return ItemInfoResponseDto.builder()
                .price(internalParamNames.getPrice())
                .barcode(internalParamNames.getBarcode())
                .build();
    }


    private JSONObject requestBodyCreator(Map<String, ParamDataDto> requestBodyData) {
        JSONObject requestBody = new JSONObject();

        requestBodyData.forEach((paramName, value) -> {
            try {
                if (DataTypes.LIST.name().equalsIgnoreCase(value.getDataTypeName())) {
                    JSONArray values = new JSONArray();
                    values.put(value.getParamValue());
                    requestBody.put(paramName, values);
                } else if (DataTypes.OBJECT.name().equalsIgnoreCase(value.getDataTypeName())) {
                    JSONObject values = new JSONObject();
                    values.put("", "");
                    requestBody.put(paramName, values);
                } else {
                    requestBody.put(paramName, value.getParamValue());
                }
            } catch (JSONException e) {
                log.error("Unable to add param to request body : {} | param name : {} | data type : {}", e.getMessage(), paramName, value.getDataTypeName());
            }
        });
        return requestBody;
    }

    private Map<ParamType, Map<String, ParamDataDto>> dataParameterBuilder(EndpointDataDto endpointData, ItemRequestDto itemRequest) {
        EnumMap<ParamType, Map<String, ParamDataDto>> dataMap = new EnumMap<>(ParamType.class);
        dataMap.put(PATH_PARAM, new HashMap<>());
        dataMap.put(QUERY_PARAM, new HashMap<>());
        dataMap.put(HEADER, new HashMap<>());
        dataMap.put(REQUEST_BODY, new HashMap<>());
        dataMap.put(RESPONSE_BODY, new HashMap<>());

        endpointData.getEndPointParams()
                .stream()
                .forEach(params -> {
                    InternalParam param = InternalParam.valueOf(params.getInternalParam().getParamName().toUpperCase());
                    String value = null;

                    switch (param) {
                        case BARCODE:
                            value = itemRequest.getBarcode();
                            break;
                        case USERNAME:
                            value = itemRequest.getUser().getUsername();
                            break;
                        case ROLE:
                            value = itemRequest.getUser().getRole().name();
                            break;
                        case PRICE:
                            break;
                    }
                    Map<String, ParamDataDto> mapInfo = dataMap.get(params.getParamType());
                    if (mapInfo != null) {
                        mapInfo.put(params.getParamName(), new ParamDataDto(value, params.getParamName(), params.getDataType().getName(), params.getInternalParam()));
                    }
                });
        return dataMap;
    }
}