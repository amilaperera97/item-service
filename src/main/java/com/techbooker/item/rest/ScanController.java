package com.techbooker.item.rest;

import com.techbooker.item.dto.ItemInfoResponseDto;
import com.techbooker.item.dto.ItemRequestDto;
import com.techbooker.item.service.ItemService;
import com.techbooker.sm.util.dto.ResponseDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.techbooker.item.util.constance.ControllerConstance.*;

@RequestMapping(API_V1)
@RestController
@AllArgsConstructor
@Slf4j
public class ScanController {
    private final ItemService itemService;

    @PostMapping(value = ITEM, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<ItemInfoResponseDto> find(@RequestBody ItemRequestDto itemRequest) {
        log.info("Item info validation : {}", itemRequest);
     /*   try {
            //Invalid check
            //Shop validation done when log into app
            ResponseDto response = shopService.isValidBranch(ValidateBranchInfoDto.builder()
                    .shopId(itemRequest.getShopId())
                    .branchId(itemRequest.getBranchId())
                    .shopName(itemRequest.getShopName())
                    .branchName(itemRequest.getBranchName())
                    .branchContactInfo(ContactInfoDto.builder()
                            .city(itemRequest.getContactInfoDto().getCity())
                            .country(itemRequest.getContactInfoDto().getCountry())
                            .postCode(itemRequest.getContactInfoDto().getPostCode())
                            .build())
                    .build());
            log.info("External validation info : {}", response);
            if (Boolean.TRUE.toString().equalsIgnoreCase(String.valueOf(response.getData()))) {
                return new ResponseDto<ItemInfoResponseDto>().buildSuccessMsgWithData(itemService.find(itemRequest));
            }
        } catch (Exception e) {
            log.error("Error while validating data with external service : {}", e.getMessage());
            return new ResponseDto<ItemInfoResponseDto>().buildFailureMsg(e);
        }*/
        return new ResponseDto<ItemInfoResponseDto>().buildSuccessMsgWithData(itemService.searchInfo(itemRequest));
    }
}
