package com.techbooker.item.util;

import com.google.gson.Gson;
import com.sun.codemodel.JCodeModel;
import com.techbooker.item.dto.external.ShopEndpointInfoDto;
import com.techbooker.item.dto.external.ShopInfoDto;
import com.techbooker.item.service.ShopService;
import com.techbooker.sm.util.CommonUtil;
import com.techbooker.sm.util.dto.Features;
import com.techbooker.sm.util.dto.ResponseDto;
import feign.RetryableException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import netscape.javascript.JSObject;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.*;

@AllArgsConstructor
@Component
@Slf4j
public class ExternalDataUtil {

    private final ShopService shopService;
    public static Map<Long, Map<Features, List<ShopEndpointInfoDto>>> ALL_ENDPOINT_DATA;
    public static Map<Long, ShopInfoDto> SHOP_INFO;

    final static String BASE_PATH = "src/main/java";
    final static String BASE_PACKAGE_NAME = "com.techbooker.item.dto.external.endpoint.";
    final static String SHOP_DATA_PACKAGE_NAME = "com.techbooker.item.dto";
    static File outputPojoDirectory = new File(BASE_PATH + File.separator);

    static {
        outputPojoDirectory.mkdirs();
    }

    public void initializeData() {
        try {
            ResponseDto<List<ShopEndpointInfoDto>> response = shopService.findAllEndpoints();
            if (response != null) {
                assignEndpointData(response.getData());
                assignShopData(response.getData());
            }
        } catch (RetryableException re) {
            log.error("Error while calling endpoint data : {}", re.getMessage());
        }
    }

    @Async("itemServiceAsyncExecutor")
    void assignEndpointData(List<ShopEndpointInfoDto> data) {
        if (ALL_ENDPOINT_DATA == null) {
            ALL_ENDPOINT_DATA = new HashMap<>();
        }

        data.forEach(shopEndpointInfoDto -> {
            List<ShopEndpointInfoDto> shopEndpointInfoList = null;
            Map<Features, List<ShopEndpointInfoDto>> shopEndpointInfoMap =
                    ALL_ENDPOINT_DATA.get(shopEndpointInfoDto.getShop().getId());
            //Check map is empty or not
            if (shopEndpointInfoMap == null) {
                shopEndpointInfoMap = new HashMap<>();
            }
            if (shopEndpointInfoMap.get(shopEndpointInfoDto.getFeatureName()) == null) {
                shopEndpointInfoList = new LinkedList<>();
            } else {
                shopEndpointInfoList = shopEndpointInfoMap.get(shopEndpointInfoDto.getFeatureName());
            }
            shopEndpointInfoList.add(shopEndpointInfoDto);
            shopEndpointInfoMap.put(shopEndpointInfoDto.getFeatureName(), shopEndpointInfoList);

            ALL_ENDPOINT_DATA.put(shopEndpointInfoDto.getShop().getId(), shopEndpointInfoMap);

            if (HttpMethod.POST == shopEndpointInfoDto.getHttpMethod()) {
                generateEndpointDto(shopEndpointInfoDto);
            }
        });
    }

    @Async("itemServiceAsyncExecutor")
    void assignShopData(List<ShopEndpointInfoDto> data) {
        if (SHOP_INFO == null) {
            SHOP_INFO = new HashMap<>();
        }

        for (ShopEndpointInfoDto shopEndpointInfo : data) {
            SHOP_INFO.put(shopEndpointInfo.getShop().getId(), shopEndpointInfo.getShop());
        }
    }

    private void generateEndpointDto(ShopEndpointInfoDto shopEndpointInfoDto) {
        if (shopEndpointInfoDto.getRequestBody() != null || shopEndpointInfoDto.getResponseBody() != null) {
            final StringBuffer packageName = new StringBuffer(BASE_PACKAGE_NAME);
            packageName.append(String.valueOf(shopEndpointInfoDto.getShop().getName()).toLowerCase());
            packageName.append(".");
            packageName.append(String.valueOf(shopEndpointInfoDto.getFeatureName()).toLowerCase());
            packageName.append(".");

            //Generate request dtos
            if (shopEndpointInfoDto.getRequestBody() != null) {
                String finalPackageName = packageName + "request";

                CommonUtl.convertJsonToPojoClass(shopEndpointInfoDto.getRequestBody(),
                        finalPackageName, "Root", outputPojoDirectory);
            }

            //Generate response dtos
            if (shopEndpointInfoDto.getResponseBody() != null) {
                String finalPackageName = packageName + "response";

                CommonUtl.convertJsonToPojoClass(shopEndpointInfoDto.getResponseBody(),
                        finalPackageName, "Root", outputPojoDirectory);
            }
        }
    }

    public void refreshData() {
        Map<Long, Map<Features, List<ShopEndpointInfoDto>>> endpointTemp = ALL_ENDPOINT_DATA;
        ALL_ENDPOINT_DATA = null;
        initializeData();

        if (ALL_ENDPOINT_DATA == null && endpointTemp != null) {
            log.info("Load all data size: {}", endpointTemp.size());
            ALL_ENDPOINT_DATA = endpointTemp;
        }
    }
}
