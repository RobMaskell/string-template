package com.experimental.stringtemplate.group.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.servlet.View;

import com.experimental.stringtemplate.group.Group;
import com.experimental.stringtemplate.group.GroupService;
import com.experimental.stringtemplate.view.BaseController;
import com.experimental.stringtemplate.view.ModelRenderingView;
import com.experimental.stringtemplate.view.RedirectingView;
import com.experimental.stringtemplate.view.templates.FormErrorsModel;
import com.experimental.stringtemplate.view.templates.PageTemplateModel;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class GroupController extends BaseController {
    

    private GroupService groupService;
    
    
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }


    @GetMapping(value = {"/", "/groups"}, produces = MediaType.TEXT_HTML_VALUE)
    public View getGroups(HttpServletRequest request) {

        List<GroupCardModel> groupModels = groupService.findAll().stream().map(g -> new GroupCardModel(true, g)).collect(Collectors.toList());

        return new ModelRenderingView(
            new PageTemplateModel(
                isHtmx(request),
                "Groups Page",
                new GroupsModel(
                    groupModels
                )
            )
        );
    }


    @GetMapping(value = "/group/{id}", produces = MediaType.TEXT_HTML_VALUE)
    public View getGroupRead(@PathVariable(name = "id") long id, @RequestHeader() HttpHeaders headers) {
        return new ModelRenderingView(
            new PageTemplateModel(
                isHtmx(headers.getFirst("HX-Request")),
                "Single Group Page",
                new GroupSectionModel(
                    new GroupCardModel(
                        false,
                        groupService.findById(id)
                    
                    )
                )
            )
        );
    }


    @GetMapping(value = "/group/new", produces = MediaType.TEXT_HTML_VALUE)
    public View getGroupBlankForm(@RequestHeader() HttpHeaders headers) {
        return new ModelRenderingView(
            new PageTemplateModel(
				isHtmx(headers.getFirst("HX-Request")),
                "New Group Page",
                new GroupFormModel(
                    new Group(null, "", ""), 
                    null
                )
            )
        );
    }

    
    @PostMapping(value="/group/new", produces = MediaType.TEXT_HTML_VALUE)
    public View addGroup(@Valid Group group, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return new ModelRenderingView(
                new GroupFormModel(group, new FormErrorsModel(result)));
        }
        
        groupService.save(group);
        return new RedirectingView("/groups", HttpStatus.CREATED);
    }


    @GetMapping(value = "/group/edit/{id}", produces = MediaType.TEXT_HTML_VALUE)
    public View getGroupEditForm(@PathVariable(name = "id") long id, @RequestHeader() HttpHeaders headers) {
        return new ModelRenderingView(
            new PageTemplateModel(
				isHtmx(headers.getFirst("HX-Request")),
                "Edit Group Page",
                new GroupFormModel(
                    groupService.findById(id), 
                    null
                )
            )
        );
    }


    @PutMapping("/group/edit/{id}")
    public View updateGroup(@PathVariable("id") long id, @Valid Group group, BindingResult result, Model model) {
        
        if (result.hasErrors()) {
            group.setId(id);
            return new ModelRenderingView(
                new GroupFormModel(group, new FormErrorsModel(result)));
        }
            
        groupService.update(group);

        return new RedirectingView("/groups", HttpStatus.NO_CONTENT);

    }


    @DeleteMapping("/group/delete/{id}")
    public View deleteGroup(@PathVariable("id") long id) {
        Group group = groupService.findById(id);
        groupService.delete(group);

        return new RedirectingView("/groups", HttpStatus.NO_CONTENT);
    }
	
}
