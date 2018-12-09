/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.component;
import com.metropolitan.model.Todo;
import com.metropolitan.service.TodoService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 *
 * @author Vlada
 */
@Component
class TodoInitializer {

    private final TodoService messageBoardService;

    TodoInitializer(TodoService messageBoardService) {
        this.messageBoardService = messageBoardService;
    }

    @PostConstruct
    public void setup() {

        Todo todo = new Todo();
        todo.setOwner("vlada@email.net");
        todo.setDescription("IT355 - Lekcija Spring Security");

        messageBoardService.save(todo);

        todo = new Todo();
        todo.setOwner("vlada@email.net");
        todo.setDescription("Dobro procitaj lekciju!!!");
        todo.setCompleted(true);
        messageBoardService.save(todo);

        todo = new Todo();
        todo.setOwner("vlada@email.net");
        todo.setDescription("Pitaj ako ne znas!!!");

        messageBoardService.save(todo);

    }
}
