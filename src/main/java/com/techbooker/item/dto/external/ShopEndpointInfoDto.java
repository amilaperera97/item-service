package com.techbooker.item.dto.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.techbooker.sm.util.dto.Features;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpMethod;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class ShopEndpointInfoDto {
    private String endpoint;
    private Features featureName;
    private String wsType;
    private String requestBodyType;
    private String requestBody;
    private String responseBodyType;
    private String responseBody;
    private ShopInfoDto shop;
    private HttpMethod httpMethod;
    private List<ParamDataDto> paramData;
}
