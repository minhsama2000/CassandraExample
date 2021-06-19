package com.minh.todoList.service;

import java.util.List;
import java.util.UUID;

import com.minh.todoList.model.Todo;

public interface TodoService {
	List<Todo> getAll();
	  Todo create(Todo todo);
	  Todo update(Todo todo);
	  void delete(UUID id);
}
