package com.techbooker.item.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemInfoResponseDto {
    private String barcode;
    private String name;
    private String price;
    private String currencyType;
    private String imageUrl;
    private String size;
    private String nutritionInformation;
    private String manufacturer;
    private String storageInstruction;
}
