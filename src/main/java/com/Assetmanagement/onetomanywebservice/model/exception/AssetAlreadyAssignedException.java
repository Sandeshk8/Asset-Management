package com.Assetmanagement.onetomanywebservice.model.exception;

import java.text.MessageFormat;

public class AssetAlreadyAssignedException extends RuntimeException{
    public AssetAlreadyAssignedException(final Long itemId, final Long cartId){
        super(MessageFormat.format("Assets: {0} is already assigned to cart: {1}", itemId, cartId));
    }
}
