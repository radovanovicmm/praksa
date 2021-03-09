package io.agileintelligence.ppmtoll.services;

import io.agileintelligence.ppmtoll.domain.Project;
import io.agileintelligence.ppmtoll.exceptions.ProjectIdException;
import io.agileintelligence.ppmtoll.repositrories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project save(Project project){

        try{
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        } catch(Exception e){
            throw new ProjectIdException("Project Id '" + project.getProjectIdentifier().toUpperCase() + "' already exist");
        }
    }

    public Project findById(Long id){
        Project project = projectRepository.findById(id).orElse(null);
        if(project == null){
            throw new ProjectIdException("Project Id "+id+" doenst exist");
        }
        return project;
    }

    public List<Project> findAll(){
        return projectRepository.findAll();
    }
}
