package com.bin.spring.preparer;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.PreparerException;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;

public class PageViewPreparer implements ViewPreparer {

    public void execute(Request request, AttributeContext attributeContext)
    throws PreparerException {
    	
    	request.getContext(Request.REQUEST_SCOPE).put("test", "This is menu");
    	
    }
}
