package com.kavish.tutorials.dao;

import com.kavish.tutorials.entity.UserInformation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PerformOperation implements Operations {

    @Override
    public List<UserInformation> getUsers() throws Exception {
        /**Create a session and then open it**/
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        //HQL
        Query query = session.createQuery("from UserInformation ");
        List<UserInformation> usersList = query.list();

        sessionFactory.close();
        return usersList;
    }

    @Override
    public List<UserInformation> getUserDetail(Integer userId) throws Exception {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        UserInformation user = new UserInformation();
        //HQL
        Query query = session.createQuery("from UserInformation where userId =" + userId);
        List<UserInformation> usersList = query.list();
        sessionFactory.close();
        return usersList;
    }

    @Override
    public String addUser(UserInformation userInformation) throws Exception {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(userInformation);
        session.getTransaction().commit();//use annotation instead
        session.close();
        return "User Added Successfully";
    }

    /*@Override
    public String addUser(UserRequest request) throws Exception {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        UserInformation user = new UserInformation();

        *//*user.setLastName(request.getLastName());
        user.setFirstName(request.getFirstName());
        user.setAddress(request.getAddress());
        user.setCity(request.getCity());*//*
        user.setLastName("X");
        user.setFirstName("Malcolm");
        user.setAddress("BEML Layout");
        user.setCity("Benagaluru");

        session.beginTransaction();
        try {
            session.save(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        session.getTransaction().commit();
        sessionFactory.close();
        return "User Added Successfully";
    }*/
}
