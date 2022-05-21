package com.techbooker.item.service;

import com.techbooker.item.dto.external.ValidateBranchInfoDto;
import com.techbooker.sm.util.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name = "shopService",url = "${url.external.uk-address-finder}")
public interface ShopService {

//    @PostMapping(value = )
//    ResponseDto isValidBranch(@RequestBody ValidateBranchInfoDto validateBranchInfo);
}
