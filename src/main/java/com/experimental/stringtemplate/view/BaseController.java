package com.experimental.stringtemplate.view;

import jakarta.servlet.http.HttpServletRequest;

public class BaseController {
	
	protected boolean isHtmx(String htmx) {
        //String htmx = request.getHeader("HX-Request");
        return htmx != null && htmx.equalsIgnoreCase("true");
    }


    protected boolean isHtmx(HttpServletRequest request) {
        String htmx = request.getHeader("HX-Request");
        return htmx != null && htmx.equalsIgnoreCase("true");
    }

}
