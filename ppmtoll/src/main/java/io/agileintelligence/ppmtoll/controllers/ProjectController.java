package io.agileintelligence.ppmtoll.controllers;

import io.agileintelligence.ppmtoll.domain.Project;
import io.agileintelligence.ppmtoll.services.MapValidationErrorService;
import io.agileintelligence.ppmtoll.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/project1")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("/add")
    public ResponseEntity<?> createNew(@Valid @RequestBody Project project, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!=null)
            return errorMap;
        Project p1 = projectService.save(project);
        return new ResponseEntity<Project>(p1, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    private ResponseEntity<?> findById(@PathVariable Long id){
        Project project = projectService.findById(id);
        return new ResponseEntity<Project>(project, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    private List<Project> findAll(){
        return projectService.findAll();
    }
}
