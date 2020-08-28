package com.example.pg_db;

import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface ProjRepo extends CrudRepository<Project, Long> {
    public List<Project> all();

}
