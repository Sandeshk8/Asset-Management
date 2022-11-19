package com.Assetmanagement.onetomanywebservice.model.exception;

import java.text.MessageFormat;

public class CategoriesNotFoundException extends RuntimeException {

    public CategoriesNotFoundException(final Long id){
        super(MessageFormat.format("Could not find cart with id: {0}", id));
    }

}
