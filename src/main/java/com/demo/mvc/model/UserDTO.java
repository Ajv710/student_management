package com.demo.mvc.model;

import java.io.Serializable;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_table")
public class UserDTO implements Serializable {
	
	
	@Id
	private int id;
	private String name;
	private int age;
	
	public UserDTO() {
		System.out.println(this.getClass().getName()+" UserDto obj created");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}
