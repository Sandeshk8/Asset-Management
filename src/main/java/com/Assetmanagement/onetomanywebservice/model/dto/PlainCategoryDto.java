package com.Assetmanagement.onetomanywebservice.model.dto;

import com.Assetmanagement.onetomanywebservice.model.Categories;
import lombok.Data;

@Data
public class PlainCategoryDto {
    private Long id;
    private String name;
    private String description;

    public static PlainCategoryDto from(Categories categories){
        PlainCategoryDto plainCategoryDto = new PlainCategoryDto();
        plainCategoryDto.setId(categories.getId());
        plainCategoryDto.setName(categories.getName());
        plainCategoryDto.setDescription(categories.getDescription());
        return plainCategoryDto;
    }
}
