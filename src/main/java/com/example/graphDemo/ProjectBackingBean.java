package com.example.graphDemo;

import org.primefaces.PrimeFaces;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;
import java.util.List;

@Named("ProjectBB")
@RequestScoped
public class ProjectBackingBean {

    @Inject ProjectCache projectCache;
    @Inject ProjectEJB projectEJB;



    private List<Project> projects;


    //Create Page variables
    int projectID;
    String projectName;
    String assignedEMP;
    Date startDate;
    Date endDate;
    String projectDescription;
    String status;


    @PostConstruct
    public void load(){
        if (hasCurrentProject()){
            // sett all backing bean fields from project cache current projects.
            this.projectID = projectCache.getCurrentProject().getProject_ID();
            this.projectName = projectCache.getCurrentProject().getProject_name();
            this.assignedEMP = projectCache.getCurrentProject().getAssigned_emp();
            this.startDate = projectCache.getCurrentProject().getStart_date();
            this.endDate = projectCache.getCurrentProject().getEnd_date();
            this.projectDescription = projectCache.getCurrentProject().getProject_discription();
            this.status = projectCache.getCurrentProject().getStatus();

        }
    }


    public boolean hasCurrentProject(){
        return null!=getCurrentProject();
    }

    private Project getCurrentProject() {
        return projectCache.getCurrentProject();
    }

    public String update() {

      if (hasCurrentProject()){
          System.out.println("updating");
          //System.out.println(projectName);

          // re assigning the cached project values
          projectCache.getCurrentProject().setProject_name(projectName);
          projectCache.getCurrentProject().setAssigned_emp(assignedEMP);
          projectCache.getCurrentProject().setStart_date(startDate);
          projectCache.getCurrentProject().setEnd_date(endDate);
          projectCache.getCurrentProject().setStatus(status);
          projectCache.getCurrentProject().setProject_discription(projectDescription);

          projectEJB.updateProject(projectCache.getCurrentProject());

      }else {
          System.out.println("creating");
          projectEJB.createProject(projectName,assignedEMP,startDate,endDate,projectDescription,status);
      }

        return "projects?faces-redirect=true";

    }





    public List<Project> getProjects(){
        return projectEJB.tableQuery();
    }


    public String create(){
        //projectEJB.createProject(ProjectName,AssignedEMP,StartDate,EndDate,ProjectDescription,Status);

        return "projects?faces-redirect=true";
    }

    public String delete(Project project){
        //System.out.println(project.getProject_ID());
        int id = project.getProject_ID();
        projectEJB.deleteInstance(id);
        return "projects?faces-redirect=true";
    }


    public String toForm(Project project) {


        if (null != project){
            System.out.println("not null");
            projectCache.setCurrentProject(project);


        }else {
            System.out.println("null");
            projectCache.setCurrentProject(null);
        }

        return "create?faces-redirect=true";

    }




    public String redirectUpdate(){
        return "update2?faces-redirect=true";
    }
    public String redirectProjects(){
        return "projects?faces-redirect=true";
    }
    public String redirectCreate(){
        return "create?faces-redirect=true";
    }








    //Getters and Setters

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getAssignedEMP() {
        return assignedEMP;
    }

    public void setAssignedEMP(String assignedEMP) {
        this.assignedEMP = assignedEMP;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}
