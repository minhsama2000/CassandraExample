package com.minh.todoList.model;

import java.util.UUID;


import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Table(value="todo")
@Getter
@Setter
public class Todo {
	
	@PrimaryKey
	  private UUID id;
	  private String name;
	  private String description;

	  public Todo() {
	  }

	  public Todo(UUID id, String name, String description) {
	    this.id = id;
	    this.name = name;
	    this.description = description;
	  }
}
