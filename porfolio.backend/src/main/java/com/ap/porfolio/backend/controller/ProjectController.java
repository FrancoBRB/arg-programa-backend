package com.ap.porfolio.backend.controller;

import com.ap.porfolio.backend.model.Project;
import com.ap.porfolio.backend.services.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/{profileId}")
    public ResponseEntity<Project> addProject(@PathVariable Long profileId, @RequestBody Project project){
        projectService.addProject(project, profileId);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Project>> getProjects(){
        List<Project> projects = projectService.getProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping("/list/{profileId}")
    public ResponseEntity<List<Project>> getProjectsByProfileId(@PathVariable Long profileId){
        List<Project> projects = projectService.getProjectsByProfileId(profileId);
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project updatedProject){
        Project project = projectService.updateProject(updatedProject, id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteProject(@PathVariable Long id){
        return projectService.deleteProject(id);
    }
}
