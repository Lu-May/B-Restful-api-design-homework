package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.service.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/v1/groups")
    public List<Group> getGroups() {
        return groupService.getGroups();
    }

    @PatchMapping("/v1/groups/{id}")
    public Group updateGroupName(@PathVariable int id, @RequestBody String groupName) {
        return groupService.updateGroupName(id, groupName);
    }

    @GetMapping("/v1/groups/{id}")
    public Group getGroupById(@PathVariable int id) {
        return groupService.getGroupById(id);
    }
}
