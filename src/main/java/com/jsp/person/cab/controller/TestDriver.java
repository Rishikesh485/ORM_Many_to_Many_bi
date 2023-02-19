package com.jsp.person.cab.controller;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.person.cab.dto.Cab;
import com.jsp.person.cab.dto.Person;

public class TestDriver {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("advaith");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Person p1 = new Person();
		p1.setName("XYZ");
		p1.setEmail("xyz@gmail.com");
		p1.setCno(1234567890L);

		Person p2 = new Person();
		p2.setName("ABC");
		p2.setEmail("abc@gmail.com");
		p2.setCno(4710254863L);

		Person p3 = new Person();
		p3.setName("WTF");
		p3.setEmail("wtf@gmail.com");
		p3.setCno(6987451230L);

		ArrayList<Person> al = new ArrayList<Person>();
		al.add(p1);
		al.add(p2);
		al.add(p3);

		Cab c1 = new Cab();
		c1.setName("Mahindra");
		c1.setType("SUV");

		Cab c2 = new Cab();
		c2.setName("TOYOTA");
		c2.setType("XUV");

		Cab c3 = new Cab();
		c3.setName("FORD");
		c3.setType("SEDAN");

		ArrayList<Cab> al1 = new ArrayList<Cab>();
		al1.add(c1);
		al1.add(c2);
		al1.add(c3);

		p1.setCabs(al1);
		p2.setCabs(al1);
		p3.setCabs(al1);
		c1.setPersons(al);
		c2.setPersons(al);
		c3.setPersons(al);

		entityTransaction.begin();
		entityManager.persist(p1);
		entityManager.persist(p2);
		entityManager.persist(p3);
		entityManager.persist(c1);
		entityManager.persist(c2);
		entityManager.persist(c3);
		entityTransaction.commit();

	}
}
