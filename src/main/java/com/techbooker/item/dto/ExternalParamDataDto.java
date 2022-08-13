package com.techbooker.item.dto;

import com.techbooker.item.dto.external.ParamType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExternalParamDataDto {
    private String paramName;
    private Long dataType;
    private String dataTypeName;
    private ParamType paramType;
}