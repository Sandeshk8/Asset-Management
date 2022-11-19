package com.Assetmanagement.onetomanywebservice.model.exception;

import java.text.MessageFormat;

public class AssetNotFoundException extends RuntimeException {

    public AssetNotFoundException(final Long id){
        super(MessageFormat.format("Could not find item with id: {0}", id));
    }
}
