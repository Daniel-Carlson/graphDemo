package com.example.graphDemo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CoordinateEJB {

   @PersistenceContext
    EntityManager em;

    //Create
    public boolean createCoordinate(int Y_value){
        Coordinate new_coord = new Coordinate(Y_value);
        em.persist(new_coord);
        return em.contains(new_coord);
    }

    // Read
    public ArrayList<Coordinate> tableQuery(){

        String sqlQuery = "Select * From coordinate";
        Query q = em.createNativeQuery(sqlQuery,Coordinate.class);
        return (ArrayList<Coordinate>) q.getResultList();
    }


    // Delete
//    public ArrayList<Coordinate> deleteQuery(){
//
//        String sqlQuery = "DELETE From coordinate";
//        Query q = em.createNativeQuery(sqlQuery,Coordinate.class);
//        return (ArrayList<Coordinate>) q.getResultList();
//
//    }

    public void deleteQuery(){

        String sqlQuery = "DELETE From coordinate";
        Query q = em.createNativeQuery(sqlQuery,Coordinate.class);
        q.executeUpdate();

    }
}
