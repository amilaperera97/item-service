package com.techbooker.item.shop;

import com.techbooker.item.dto.external.ShopEndpointInfoDto;
import com.techbooker.item.dto.external.endpoint.aldi.find_item_price_info.response.Root;
import com.techbooker.item.http.ClientMethod;
import com.techbooker.item.shop.feature.FindItemPriceInfoFeature;
import com.techbooker.sm.util.dto.Features;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.techbooker.item.util.ExternalDataUtil.ALL_ENDPOINT_DATA;

@AllArgsConstructor
public class AldiImpl {
}
