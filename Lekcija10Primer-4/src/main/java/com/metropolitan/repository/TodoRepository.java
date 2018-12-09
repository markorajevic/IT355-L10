/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.repository;
import com.metropolitan.model.Todo;
import java.util.List;
/**
 *
 * @author Vlada
 */


public interface TodoRepository {

    List<Todo> findAll();

    Todo findOne(long id);

    void remove(long id);

    Todo save(Todo todo);

    List<Todo> findByOwner(String author);

}
