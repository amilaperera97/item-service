package com.techbooker.item.dto.external;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InternalParamDto {
    private String paramName;
    private ParamDataType dataType;
    private String value;
}
