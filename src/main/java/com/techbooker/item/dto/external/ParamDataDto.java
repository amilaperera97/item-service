package com.techbooker.item.dto.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ParamDataDto {
    private String name;
    private String value;
    private ParamType paramType;
}
