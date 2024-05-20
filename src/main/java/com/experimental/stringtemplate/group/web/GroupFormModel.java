package com.experimental.stringtemplate.group.web;

import com.experimental.stringtemplate.group.Group;
import com.experimental.stringtemplate.view.BaseModel;
import com.experimental.stringtemplate.view.templates.FormErrorsModel;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class GroupFormModel implements BaseModel {
    
    private Group group;
    private FormErrorsModel formErrors;
    // private boolean isPartial;


    @SuppressWarnings("preview")
	public String toString() {

        return STR."""
            <section hx-target="this" hx-swap="outerHTML">

            <h2>Add Group</h2>

            <form \{IFNULL(group.getId()) ? "hx-post=/group/new" : "hx-put='/group/edit/"+group.getId()+"'"}>
                \{IF(formErrors)}

                <div class="control">
                    <label for="title">Title</label>
                    <input type="text" name="title" value="\{group.getTitle()}" id="title" placeholder="Title of Group">
                </div>
                <div class="control">
                    <label for="hook">Hook</label>
                    <textarea type="text" name="hook" xxxvalue="" id="hook" placeholder="Hook / Description of group">\{group.getHook()}</textarea>
                </div>
                <div class="control">
                    <button type="submit">\{IFNULL(group.getId()) ? "Add" : "Save"} group</button>
                </div>   
            </form>

            </section>
        """;
    }


}
