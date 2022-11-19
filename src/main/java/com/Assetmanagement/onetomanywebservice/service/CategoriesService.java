package com.Assetmanagement.onetomanywebservice.service;

import com.Assetmanagement.onetomanywebservice.model.Categories;
import com.Assetmanagement.onetomanywebservice.repository.CategoriesRepository;
import com.Assetmanagement.onetomanywebservice.model.Assets;
import com.Assetmanagement.onetomanywebservice.model.exception.CategoriesNotFoundException;
import com.Assetmanagement.onetomanywebservice.model.exception.AssetAlreadyAssignedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CategoriesService {

    private final CategoriesRepository categoriesRepository;
    private final AssetService assetService;

    @Autowired
    public CategoriesService(CategoriesRepository categoriesRepository, AssetService assetService) {
        this.categoriesRepository = categoriesRepository;
        this.assetService = assetService;
    }

    public Categories addCart(Categories categories){
        return categoriesRepository.save(categories);
    }

    public List<Categories> getCarts(){
        return StreamSupport
                .stream(categoriesRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Categories getCart(Long id){
        return categoriesRepository.findById(id).orElseThrow(() ->
                new CategoriesNotFoundException(id));
    }

    public Categories deleteCart(Long id){
        Categories categories = getCart(id);
        categoriesRepository.delete(categories);
        return categories;
    }

    @Transactional
    public Categories editCart(Long id, Categories categories){
        Categories categoriesToEdit = getCart(id);
        categoriesToEdit.setName(categories.getName());
        return categoriesToEdit;
    }

    @Transactional
    public Categories addItemToCart(Long cartId, Long itemId){
        Categories categories = getCart(cartId);
        Assets assets = assetService.getItem(itemId);
        if(Objects.nonNull(assets.getCategories())){
            throw new AssetAlreadyAssignedException(itemId,
                    assets.getCategories().getId());
        }
        categories.addItem(assets);
        assets.setCategories(categories);
        return categories;
    }

    @Transactional
    public Categories removeItemFromCart(Long cartId, Long itemId){
        Categories categories = getCart(cartId);
        Assets assets = assetService.getItem(itemId);
        categories.removeItem(assets);
        return categories;
    }
}
