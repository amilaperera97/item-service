package com.techbooker.item.service.impl;

import com.techbooker.item.dto.ItemInfoResponseDto;
import com.techbooker.item.dto.ItemRequestDto;
import com.techbooker.item.http.RestClient;
import com.techbooker.item.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ItemServiceImpl implements ItemService {
    @Override
    public ItemInfoResponseDto find(ItemRequestDto itemRequest) {
        //TODO
        //call shop api with barcode
        //set data


        return null;
    }
}
