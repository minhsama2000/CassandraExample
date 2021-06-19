package com.minh.todoList.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.minh.todoList.model.Todo;

public interface TodoRepository extends CassandraRepository<Todo,UUID>{
}
