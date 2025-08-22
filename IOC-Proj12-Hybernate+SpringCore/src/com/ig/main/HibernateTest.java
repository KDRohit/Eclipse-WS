package com.ig.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ig.cfgs.HibernateUtil;
import com.ig.cfgs.User;

public class HibernateTest {

	public static void main(String[] args) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

        // Create and save a User
        User user = new User();
        user.setName("Alice");
        user.setEmail("alice@example.com");
        session.persist(user);

        tx.commit();
        session.close();

        System.out.println("✅ User saved successfully!");
	}

}
