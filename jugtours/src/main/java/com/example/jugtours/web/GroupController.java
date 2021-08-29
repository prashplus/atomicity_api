package com.example.jugtours.web;


import com.example.jugtours.model.Group;
import com.example.jugtours.model.GroupRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class GroupController {

    private final Logger log = LoggerFactory.getLogger(GroupController.class);
    private GroupRespository groupRespository;

    public GroupController(GroupRespository groupRespository){
        this.groupRespository = groupRespository;
    }

    @GetMapping("/groups")
    Collection<Group> groups(){
        return groupRespository.findAll();
    }
}
