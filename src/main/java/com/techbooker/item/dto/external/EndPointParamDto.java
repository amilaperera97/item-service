package com.techbooker.item.dto.external;

import com.techbooker.item.dto.ExternalParamDataDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EndPointParamDto {
//    private String internalParamName;
//    private ExternalParamDataDto externalParamData;
    private String paramName;
    private ParamDataType dataType;
    private String value;
    private InternalParamDto internalParam;
    private ParamType paramType;
}
