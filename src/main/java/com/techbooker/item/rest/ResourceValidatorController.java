package com.techbooker.item.rest;

//import com.techbooker.item.util.ExternalDataUtil;
//import com.techbooker.sm.util.dto.ResponseDto;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.*;
//
//import static com.techbooker.item.util.constance.ControllerConstance.API_V1;
//import static com.techbooker.item.util.constance.ControllerConstance.REFRESH;
//
//@RequestMapping(API_V1)
//@RestController
//@Slf4j
//public class ResourceValidatorController {
//
//    private final ExternalDataUtil externalDataUtil;
//
//    public ResourceValidatorController(ExternalDataUtil externalDataUtil) {
//        this.externalDataUtil = externalDataUtil;
//        externalDataUtil.initializeData();
//    }
//
//    @GetMapping(value = REFRESH)
//    public ResponseDto<Void> refreshData() {
//        externalDataUtil.refreshData();
//        return new ResponseDto<Void>().buildSuccessMsg();
//    }
//}
