package com.ap.porfolio.backend.services;

import com.ap.porfolio.backend.exceptions.ResourceNotFoundException;
import com.ap.porfolio.backend.model.Profile;
import com.ap.porfolio.backend.model.Project;
import com.ap.porfolio.backend.repository.ProfileRepository;
import com.ap.porfolio.backend.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProjectService {
    private final ProfileRepository profileRepository;
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProfileRepository profileRepository, ProjectRepository projectRepository) {
        this.profileRepository = profileRepository;
        this.projectRepository = projectRepository;
    }

    public Project addProject(Project project, Long profileId){
        Profile profile = profileRepository.findById(profileId).orElseThrow(() -> new ResourceNotFoundException("Id not found."));
        project.setProfile(profile);
        return projectRepository.save(project);
    }

    public Project getProject(Long id){
        return projectRepository.getReferenceById(id);
    }

    public List<Project> getProjects(){
        return projectRepository.findAll();
    }

    public Project updateProject(Project updatedProject, Long id){
        Project project = projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found."));
        project.setProfile(updatedProject.getProfile());
        project.setImg(updatedProject.getImg());
        project.setDesc(updatedProject.getDesc());
        project.setName(updatedProject.getName());
        project.setRepo(updatedProject.getRepo());
        return updatedProject;
    }

    public String deleteProject(Long id){
        Optional<Project> optionalProject = projectRepository.findById(id);
        if (optionalProject.isPresent()) {
            projectRepository.deleteById(id);
            return "Project deleted successfully.";
        } else {
            return "Id not found.";
        }
    }
}
