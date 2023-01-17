package com.quinbay.springtask;

import com.quinbay.springtask.models.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringtaskApplication {

	public void loadData(){

	}

	public static void main(String[] args) {
		System.out.println("\nworking");
		SpringApplication.run(SpringtaskApplication.class, args);
	}

}
