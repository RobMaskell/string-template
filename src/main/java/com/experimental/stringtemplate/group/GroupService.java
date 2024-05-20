package com.experimental.stringtemplate.group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GroupService {
    
    private final Map<Long, Group> groups;
    private int ids = 0;
    

    public GroupService() {
        this.groups = new HashMap<>();
        if(groups.size() == 0) {
            groups.put(0l, new Group(0l, "MotW", "Classic MotW game"));
            groups.put(1l, new Group(1l, "Descent into Avernus", "5e splatt book game"));
            groups.put(2l, new Group(2l, "Apocalypse World", "The original PbtA game"));
            ids=3;
        }
    }


    public Group findById(long id) {
        return groups.get(id);
    }


    public List<Group> findAll() {
        return new ArrayList<>(groups.values());
    }


    public Group save(Group game) {
        log.info("Group", game);
        this.ids++;
        game.setId(Long.valueOf(this.ids));
        groups.put(game.getId(), game);
        return game;
    }

    public void update(Group group) {
        groups.replace(group.getId(), group);
    }
    

    public void delete(Group group) {
        groups.remove(group.getId());
    }

}
