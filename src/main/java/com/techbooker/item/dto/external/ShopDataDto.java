package com.techbooker.item.dto.external;

import com.techbooker.item.dto.ContactInfoDto;
import com.techbooker.sm.util.dto.CommonDataDto;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ShopDataDto extends CommonDataDto {
    private Long id;
    private String name;
    private ContactInfoDto contactInfo;
}
