package com.techbooker.item.shop.feature;

import org.springframework.util.MultiValueMap;

import java.util.Map;
import java.util.Optional;

public interface FindItemPriceInfoFeature {

    <R, T> R find(Long shopId, T body, Map<String, ?> uriVariables);
}
