package com.techbooker.item.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.util.MultiValueMap;

import java.util.Map;
import java.util.Optional;

@Data
@AllArgsConstructor
@Builder
public class ShopFeignDataDto<T> {
    private T body;
    private String url;
    private Map<String, ?> uriVariables;
    private Optional<MultiValueMap<String, String>> headers;
}
