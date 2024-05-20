package com.experimental.stringtemplate.view;

import java.util.Map;

import org.springframework.http.HttpStatusCode;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.View;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RedirectingView implements View {

    
    private String redirectUrl;
    private HttpStatusCode httpStatusCode;


    public RedirectingView(String redirectUrl, HttpStatusCode httpStatusCode) {
        this.redirectUrl = redirectUrl;
        this.httpStatusCode = httpStatusCode;
    }




    @Override
    public void render(@Nullable Map<String, ?> model, @NonNull HttpServletRequest request, @NonNull HttpServletResponse response)
            throws Exception {
        
        response.setStatus(this.httpStatusCode.value());
        response.addHeader("HX-Redirect", this.redirectUrl);
        
    }
    
}

