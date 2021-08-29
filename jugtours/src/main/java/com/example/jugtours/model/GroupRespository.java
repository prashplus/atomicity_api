package com.example.jugtours.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRespository extends JpaRepository<Group, Long> {
    Group findByName(String name);
}
