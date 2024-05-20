package com.experimental.stringtemplate.group.web;

import java.util.List;

import com.experimental.stringtemplate.view.BaseModel;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
class GroupsModel implements BaseModel {
    

    private List<GroupCardModel> groupModels;


    @SuppressWarnings("preview")
    public String toString() {

		return STR."""
			<section hx-target="this" hx-swap="outerHTML">

			<h2>Your Groups</h2>
			<p><a href="/group/new">Create a new group</a></p>
			<div class="holder">
		\{LIST(groupModels)}
			</div>
			</section>
		""";
    }

}
