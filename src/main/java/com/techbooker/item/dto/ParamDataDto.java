package com.techbooker.item.dto;

import com.techbooker.item.dto.external.InternalParamDto;
import com.techbooker.item.dto.external.ParamType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParamDataDto {
    private String paramValue;
    private String externalParamName;
    private InternalParamDto internalParam;
    private String dataTypeName;
    private ParamType paramType;

    public ParamDataDto(String paramValue, String externalParamName, String dataTypeName, InternalParamDto internalParam) {
        this.paramValue = paramValue;
        this.externalParamName = externalParamName;
        this.dataTypeName = dataTypeName;
        this.internalParam = internalParam;
    }
}