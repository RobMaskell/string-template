package com.experimental.stringtemplate.group.web;

import com.experimental.stringtemplate.group.Group;
import com.experimental.stringtemplate.view.BaseModel;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
class GroupCardModel implements BaseModel {
    

    private boolean isSummaryPage;
    private Group group;


    @SuppressWarnings("preview")
    public String toString() {

		return STR."""
				<div class="card">
					<p><a href="#" hx-get="/group/\{group.getId()}" hx-push-url="true">\{group.getTitle()}</a></p>
					<p>\{group.getHook()}</p>
					<p><a href="#" hx-get="/group/edit/\{group.getId()}" hx-push-url="true">Edit group</a></p>
					<p><a href="#" hx-delete="/group/delete/\{group.getId()}">Delete</a></p>
					\{IF(isSummaryPage, "", """
					<p><a href="#" hx-get="/groups" hx-push-url="true">Back to Groups</a></p>
					""")}
				</div>
			""";
    }

}
