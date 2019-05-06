package com.curso.demo;

import com.curso.demo.model.clases.ClienteWeb;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.RollbackException;

@SpringBootApplication
public class DemoApplication extends Exception{

	public static void main(String[] args) {
		try{
			SpringApplication.run(DemoApplication.class, args);
		} catch (RollbackException e){
			System.out.println(e.getLocalizedMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
