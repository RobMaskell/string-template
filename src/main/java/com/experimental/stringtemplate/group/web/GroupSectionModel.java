package com.experimental.stringtemplate.group.web;

import com.experimental.stringtemplate.view.BaseModel;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
class GroupSectionModel implements BaseModel {
    

    private GroupCardModel groupModel;


    @SuppressWarnings("preview")
    public String toString() {

        return STR."""
            <section hx-target="this" hx-swap="outerHTML">
            \{groupModel}
            </section>
        """;
    }

}
