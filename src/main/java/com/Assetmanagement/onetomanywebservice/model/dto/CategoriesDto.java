package com.Assetmanagement.onetomanywebservice.model.dto;

import com.Assetmanagement.onetomanywebservice.model.Categories;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CategoriesDto {
    private Long id;
    private String name;
    private String description;
    private List<AssetsDto> itemsDto = new ArrayList<>();

    public static CategoriesDto from(Categories categories){
        CategoriesDto categoriesDto = new CategoriesDto();
        categoriesDto.setId(categories.getId());
        categoriesDto.setName(categories.getName());
        categoriesDto.setDescription(categories.getDescription());
        categoriesDto.setItemsDto(categories.getAssets().stream().map(AssetsDto::from).collect(Collectors.toList()));
        return categoriesDto;
    }
}
