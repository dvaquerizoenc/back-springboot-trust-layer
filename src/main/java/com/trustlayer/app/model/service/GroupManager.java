package com.trustlayer.app.model.service;

import com.trustlayer.app.model.entities.Group;
import com.trustlayer.app.model.persistence.GroupDao;
import org.springframework.stereotype.Service;

@Service
public class GroupManager {
    private GroupDao groupDao;

    public void saveGroup(Group group) {
        if (group.getName() == null || group.getName().isBlank()) {
            throw new IllegalArgumentException("Group name cannot be null or empty");
        }
        group.setName(group.getName().trim());
        groupDao.save(group);
    }
}
