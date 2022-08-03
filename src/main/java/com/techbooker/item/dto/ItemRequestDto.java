package com.techbooker.item.dto;

import com.techbooker.sm.util.dto.CommonDataDto;
import lombok.Data;

@Data
public class ItemRequestDto extends CommonDataDto {
    private String barcode;
    private ContactInfoDto contactInfoDto;
    private int branchId;
    private String branchName;
    private int shopId;
    private String shopName;
}