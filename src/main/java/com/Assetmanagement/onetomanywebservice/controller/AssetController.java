package com.Assetmanagement.onetomanywebservice.controller;

import com.Assetmanagement.onetomanywebservice.model.Assets;
import com.Assetmanagement.onetomanywebservice.model.dto.AssetsDto;
import com.Assetmanagement.onetomanywebservice.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/items")
public class
AssetController {

    private final AssetService assetService;

    @Autowired
    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @PostMapping
    public ResponseEntity<AssetsDto> addItem(@RequestBody final AssetsDto assetsDto){
        Assets assets = assetService.addItem(Assets.from(assetsDto));
        return new ResponseEntity<>(AssetsDto.from(assets), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AssetsDto>> getItems(){
        List<Assets> assets = assetService.getItems();
        List<AssetsDto> itemsDto = assets.stream().map(AssetsDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(itemsDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<AssetsDto> getItem(@PathVariable final Long id){
        Assets assets = assetService.getItem(id);
        return new ResponseEntity<>(AssetsDto.from(assets), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<AssetsDto> deleteItem(@PathVariable final Long id){
        Assets assets = assetService.deleteItem(id);
        return new ResponseEntity<>(AssetsDto.from(assets), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<AssetsDto> editItem(@PathVariable final Long id,
                                              @RequestBody final AssetsDto assetsDto){
        Assets editedAssets = assetService.editItem(id, Assets.from(assetsDto));
        return new ResponseEntity<>(AssetsDto.from(editedAssets), HttpStatus.OK);
    }
}
