package com.minh.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.minh.todoList.model.Todo;
import com.minh.todoList.model.TodoListResponse;
import com.minh.todoList.service.TodoService;

@RestController
@RequestMapping("/todos")
@CrossOrigin()
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	 @RequestMapping(method = RequestMethod.GET)
	  public TodoListResponse todos (){
	    List<Todo> todoList = todoService.getAll();
	    TodoListResponse todoListResponse = new TodoListResponse();
	    todoListResponse.setTodos(todoList);
	    return todoListResponse;
	  }

	  @RequestMapping(method = RequestMethod.POST)
	  public Todo addtodo (@RequestBody Todo todo){
	    return todoService.create(todo);
	  }

	  @RequestMapping(method = RequestMethod.PUT)
	  public Todo updateTodo (@RequestBody Todo todo){
	    return todoService.update(todo);
	  }

	  @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	  public void deleteTodo (@PathVariable("id") UUID id){
	    todoService.delete(id);
	  }
}
