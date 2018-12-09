/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.service;

import com.metropolitan.model.Todo;
import java.util.List;

/**
 *
 * @author Vlada
 */
public interface TodoService {

    List<Todo> listTodos();

    void save(Todo todo);

    void complete(long id);

    void remove(long id);

    Todo findById(long id);
}
