package com.Assetmanagement.onetomanywebservice.service;

import com.Assetmanagement.onetomanywebservice.model.Assets;
import com.Assetmanagement.onetomanywebservice.repository.AssetRepository;
import com.Assetmanagement.onetomanywebservice.model.exception.AssetNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AssetService {

    private final AssetRepository assetRepository;

    @Autowired
    public AssetService(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public Assets addItem(Assets assets){
        return assetRepository.save(assets);
    }

    public List<Assets> getItems(){
        return StreamSupport
                .stream(assetRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Assets getItem(Long id){
        return assetRepository.findById(id).orElseThrow(() ->
                new AssetNotFoundException(id));
    }

    public Assets deleteItem(Long id){
        Assets assets = getItem(id);
        assetRepository.delete(assets);
        return assets;
    }

    @Transactional
    public Assets editItem(Long id, Assets assets){
        Assets assetsToEdit = getItem(id);
        assetsToEdit.setSerialNumber(assets.getSerialNumber());
        return assetsToEdit;
    }
}
