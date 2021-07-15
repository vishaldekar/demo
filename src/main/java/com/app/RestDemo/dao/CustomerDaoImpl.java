package com.app.RestDemo.dao;

import com.app.RestDemo.entity.Customer;
import com.app.RestDemo.service.CustomerService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDAO {

    private EntityManager entityManager;

    @Autowired
    public CustomerDaoImpl(EntityManager theEntityManager) {

        entityManager = theEntityManager;
    }

    @Override
    public List<Customer> getCustomers() {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Customer> theQuery = currentSession.createQuery("from Customer",Customer.class);

        List<Customer> customers = theQuery.getResultList();

        return customers;

    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(theCustomer);

    }

    @Override
    public Customer getCustomer(String theId) {
        Session currentSession = entityManager.unwrap(Session.class);

        Customer theCustomer = currentSession.get(Customer.class, theId);

        if (theCustomer==null)
            throw new RuntimeException("id cannot be  null ");

        return theCustomer;
    }

    @Override
    public void deleteCustomer(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
        theQuery.setParameter("customerId", theId);

        theQuery.executeUpdate();

    }
}

