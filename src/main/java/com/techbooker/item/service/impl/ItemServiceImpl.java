package com.techbooker.item.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techbooker.item.dto.ItemInfoResponseDto;
import com.techbooker.item.dto.ItemRequestDto;
import com.techbooker.item.dto.external.ParamType;
import com.techbooker.item.dto.external.ShopEndpointInfoDto;


import com.techbooker.item.dto.external.endpoint.aldi.find_item_price_info.request.Root;
import com.techbooker.item.factory.ShopFactory;
import com.techbooker.item.http.ClientMethod;
import com.techbooker.item.service.ItemService;
import com.techbooker.sm.util.dto.Features;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.*;
import java.util.stream.Collectors;

import static com.techbooker.item.util.ExternalDataUtil.ALL_ENDPOINT_DATA;

@Service
@Slf4j
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ClientMethod clientMethod;
    private final ObjectMapper objectMapper;
    private final ShopFactory featureFactory;

    @Override
    public ItemInfoResponseDto find(ItemRequestDto itemRequest) {
        return itemInfoFetch(itemRequest);
    }

    private ItemInfoResponseDto itemInfoFetch(ItemRequestDto itemRequest) {
        final ItemInfoResponseDto itemInfoResponse = ItemInfoResponseDto.builder()
                .barcode(itemRequest.getBarcode())
                .build();
        final Map<Features, List<ShopEndpointInfoDto>> endpointMap = ALL_ENDPOINT_DATA.get(itemRequest.getShopId());

//        for (Map.Entry<Features, List<ShopEndpointInfoDto>> entry : endpointMap.entrySet()) {
////            final Shop shop = featureFactory.findFeature(entry.getKey());
////
////            entry.getValue().forEach(shopEndpointInfo -> {
////                MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
////                shopEndpointInfo.getParamData().stream().filter(paramDataDto -> paramDataDto.getParamType() == ParamType.HEADER)
////                        .collect(Collectors.toList()).forEach(paramDataDto -> {
////                            headers.put(paramDataDto.getName(), Collections.singletonList(paramDataDto.getValue()));
////                        });
////
////                switch (shopEndpointInfo.getShop().getName()) {
////                    case ALDI:
////                        Root root = new Root();
////                        List<String> products = new ArrayList<>();
////                        products.add(itemRequest.getBarcode());
////                        root.setProducts(Collections.singletonList(products));
////
////                        com.techbooker.item.dto.external.endpoint.aldi.find_item_price_info.response.Root response =
////                                shop.aldi(root, shopEndpointInfo.getEndpoint(), new HashMap<>(), Optional.of(headers));
////                        break;
////                    case LIDL:
////                        break;
////                }
//
//            });
//        }
//        return itemInfoResponse;
        return null;
    }

}