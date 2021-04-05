package com.example.graphDemo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;

@Stateless
public class ProjectEJB {

    @PersistenceContext
    EntityManager em;


    //Create
    public boolean createProject(String projectname, String AssignedEMP, Date startDate, Date EndDate, String Productdiscript, String status){
        Project create = new Project(projectname,AssignedEMP,startDate,EndDate,Productdiscript,status);
        em.persist(create);
        return em.contains(create);
    }


    // Reading the rows in the database to a list of objects
    public List<Project> tableQuery(){

        String sqlQuery = "Select * From Project";
        Query q = em.createNativeQuery(sqlQuery,Project.class);
        return q.getResultList();
    }

    // Update
    public Project updateProject(Project project){
        return  em.merge(project);
    }

    //Delete
    public void deleteInstance(int projectID){

        Project instance = em.find(Project.class, projectID);
        em.remove(instance);
    }


}
