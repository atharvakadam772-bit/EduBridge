package com.edubridge.portfolio.controller;

import com.edubridge.portfolio.model.JobRole;
import com.edubridge.portfolio.repository.JobRoleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class JobRoleController {

    private final JobRoleRepository jobRoleRepository;

    public JobRoleController(JobRoleRepository jobRoleRepository) {
        this.jobRoleRepository = jobRoleRepository;
    }

    @GetMapping
    public List<JobRole> getAllRoles() {
        return jobRoleRepository.findAll();
    }

    @PostMapping
    public JobRole createRole(@RequestBody JobRole role) {
        return jobRoleRepository.save(role);
    }
}