package com.Assetmanagement.onetomanywebservice.repository;

import com.Assetmanagement.onetomanywebservice.model.Categories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends CrudRepository<Categories, Long> {
}
