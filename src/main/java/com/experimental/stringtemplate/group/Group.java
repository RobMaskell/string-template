package com.experimental.stringtemplate.group;

import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class Group {

    private Long id;
    
    @NotBlank(message = "Title is mandatory")
    private String title;
    
    @NotBlank(message = "Description/Hook is mandatory")
    private String hook;

    public Group(Long id, String title, String hook) {
        super();
        this.id = id;
        this.title = title;
        this.hook = hook;
    }

}