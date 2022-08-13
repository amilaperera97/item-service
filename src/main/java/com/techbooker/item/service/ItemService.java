package com.techbooker.item.service;

import com.techbooker.item.dto.ItemInfoResponseDto;
import com.techbooker.item.dto.ItemRequestDto;

public interface ItemService {
    ItemInfoResponseDto searchInfo(ItemRequestDto itemRequest);
}
