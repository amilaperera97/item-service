package com.techbooker.item.service;

import com.techbooker.item.dto.external.ShopEndpointInfoDto;
import com.techbooker.sm.util.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "shopService", url = "${external-service.shop-service.base-url}")
public interface ShopService {
    @GetMapping(value = "${external-service.shop-service.find-endpoints}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseDto<List<ShopEndpointInfoDto>> findAllEndpoints();
}
