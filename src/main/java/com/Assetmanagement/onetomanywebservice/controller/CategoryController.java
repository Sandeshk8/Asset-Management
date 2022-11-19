package com.Assetmanagement.onetomanywebservice.controller;

import com.Assetmanagement.onetomanywebservice.model.dto.CategoriesDto;
import com.Assetmanagement.onetomanywebservice.service.CategoriesService;
import com.Assetmanagement.onetomanywebservice.model.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoriesService categoriesService;

    @Autowired
    public CategoryController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @PostMapping
    public ResponseEntity<CategoriesDto> addCategory(@RequestBody final CategoriesDto categoriesDto){
        Categories categories = categoriesService.addCart(Categories.from(categoriesDto));
        return new ResponseEntity<>(CategoriesDto.from(categories), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CategoriesDto>> getCategories(){
        List<Categories> categories = categoriesService.getCarts();
        List<CategoriesDto> cartsDto = categories.stream().map(CategoriesDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(cartsDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<CategoriesDto> getCategories(@PathVariable final Long id){
        Categories categories = categoriesService.getCart(id);
        return new ResponseEntity<>(CategoriesDto.from(categories), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<CategoriesDto> deleteCategories(@PathVariable final Long id){
        Categories categories = categoriesService.deleteCart(id);
        return new ResponseEntity<>(CategoriesDto.from(categories), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<CategoriesDto> editCategories(@PathVariable final Long id,
                                                  @RequestBody final CategoriesDto categoriesDto){
        Categories categories = categoriesService.editCart(id, Categories.from(categoriesDto));
        return new ResponseEntity<>(CategoriesDto.from(categories), HttpStatus.OK);
    }

    @PostMapping(value = "{CategoriesId}/Assets/{AssetId}/add")
    public ResponseEntity<CategoriesDto> addItemToCategories(@PathVariable final Long CategoriesId,
                                                       @PathVariable final Long AssetId){
        Categories categories = categoriesService.addItemToCart(CategoriesId, AssetId);
        return new ResponseEntity<>(CategoriesDto.from(categories), HttpStatus.OK);
    }

    @DeleteMapping(value = "{CategoriesId}/Assets/{AssetId}/remove")
    public ResponseEntity<CategoriesDto> removeItemFromCategories(@PathVariable final Long CategoriesId,
                                                            @PathVariable final Long AssetId){
        Categories categories = categoriesService.removeItemFromCart(CategoriesId, AssetId);
        return new ResponseEntity<>(CategoriesDto.from(categories), HttpStatus.OK);
    }
}
