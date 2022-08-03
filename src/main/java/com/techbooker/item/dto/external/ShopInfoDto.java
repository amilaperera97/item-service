package com.techbooker.item.dto.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.techbooker.item.dto.ShopName;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopInfoDto {
    private Long id;
    private ShopName name;
}
