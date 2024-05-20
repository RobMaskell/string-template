package com.experimental.stringtemplate.view.templates;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.experimental.stringtemplate.view.BaseModel;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class FormErrorsModel implements BaseModel {
    
    private BindingResult result;

    @SuppressWarnings("preview")
    public String toString() {
        if (result.hasErrors()) {
            return STR."""
                <article>
                    <div>
                        <p>There are issues with your save</p>
                        \{ERRORLIST(result.getAllErrors())}
                    </div> 
                </article> 
            """;
        } else {
            return "";
        }
    }

    @SuppressWarnings("preview")
    public static <E> String ERRORLIST(List<ObjectError> list) {

        return list != null && list.size() > 0 ? list.stream()
        .map((oe) -> STR."""
            <p>\{oe.getDefaultMessage()}</p>
            """)
        .collect(Collectors.joining("\n")) : "";
    }

}
