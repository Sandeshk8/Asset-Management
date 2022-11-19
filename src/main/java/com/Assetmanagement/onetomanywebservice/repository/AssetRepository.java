package com.Assetmanagement.onetomanywebservice.repository;

import com.Assetmanagement.onetomanywebservice.model.Assets;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends CrudRepository<Assets, Long> {
}
