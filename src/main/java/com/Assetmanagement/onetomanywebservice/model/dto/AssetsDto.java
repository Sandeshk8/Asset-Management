package com.Assetmanagement.onetomanywebservice.model.dto;

import com.Assetmanagement.onetomanywebservice.model.Assets;
import lombok.Data;

import java.util.Date;
import java.util.Objects;

@Data
public class AssetsDto {
    private Long id;
    private String serialNumber;
    private Date purchasedate;
    private String condition;
    private String assignmentstatus;
    private PlainCategoryDto plainCategoryDto;

    public static AssetsDto from(Assets assets){
        AssetsDto assetsDto = new AssetsDto();
        assetsDto.setId(assets.getId());
        assetsDto.setSerialNumber(assets.getSerialNumber());
        assetsDto.setPurchasedate(assets.getPurchasedate());
        assetsDto.setCondition(assets.getCondition());
        assetsDto.setAssignmentstatus(assets.getAssignmentstatus());
        if(Objects.nonNull(assets.getCategories())){
            assetsDto.setPlainCategoryDto(PlainCategoryDto.from(assets.getCategories()));
        }
        return assetsDto;
    }
}
