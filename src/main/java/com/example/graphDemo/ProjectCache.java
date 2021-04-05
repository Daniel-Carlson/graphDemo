package com.example.graphDemo;

import com.example.graphDemo.Project;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;


@SessionScoped
public class ProjectCache implements Serializable {



    Project currentProject;







    public Project getCurrentProject() {
        return currentProject;
    }

    public void setCurrentProject(Project currentProject) {
        this.currentProject = currentProject;
    }
}
