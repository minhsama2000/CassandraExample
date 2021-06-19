package com.minh.todoList.model;

import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoListResponse {
	private UUID id;
	private String name;
	private String description;
	private List<Todo> todoList;
	
	public void setTodos(List<Todo> todos) {
		this.todoList = todos;
	}
}
