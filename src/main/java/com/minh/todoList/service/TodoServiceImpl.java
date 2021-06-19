package com.minh.todoList.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.minh.todoList.model.Todo;
import com.minh.todoList.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService{
	
	@Autowired
	TodoRepository todoRepository;
	
	 public List<Todo> getAll(){
		    List<Todo> todoList = new ArrayList<Todo>();
		    todoRepository.findAll().forEach(todo -> todoList.add(todo));
		    return todoList;
		  }

		  public Todo create(Todo todo)
		  {
		    return todoRepository.save(new Todo(UUID.randomUUID(), todo.getName(), todo.getDescription()));
		  }
		  
		  public Todo update(Todo todo)
		  {
		    return todoRepository.save(todo);
		  }

		  public void delete(UUID id)
		  {
		    todoRepository.deleteById(id);
		  }

}
