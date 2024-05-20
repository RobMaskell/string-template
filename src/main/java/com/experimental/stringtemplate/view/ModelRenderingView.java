package com.experimental.stringtemplate.view;

import java.io.PrintWriter;
import java.util.Map;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.View;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ModelRenderingView implements View {

    
    private BaseModel templateModel;


    public ModelRenderingView(BaseModel templateModel) {
        this.templateModel = templateModel;
    }


    @Override
    public void render(@Nullable Map<String, ?> model, @NonNull HttpServletRequest request, @NonNull HttpServletResponse response)
            throws Exception {
        
        PrintWriter pw = response.getWriter();
		pw.write(templateModel.toString());
        
    }
    
}
