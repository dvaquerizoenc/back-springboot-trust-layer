package com.trustlayer.app.model.persistence;

import com.trustlayer.app.model.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupDao extends JpaRepository<Group, Long> {

}
