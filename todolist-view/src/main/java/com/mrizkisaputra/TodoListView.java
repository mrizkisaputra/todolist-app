package com.mrizkisaputra;


import java.time.LocalDateTime;

public class TodoListView {

    private TodoListRepository repository;
    private TodoListService service;

    public TodoListView(TodoListRepository repository, TodoListService service) {
        this.repository = repository;
        this.service = service;
    }

    public void root() {
        while (true) {
            System.out.println("\n\n-----------------+ TODO LIST +-----------------");
            service.displayTodolist();
            System.out.println("-----------------------------------------------");
            System.out.println("-------------+ Menu +--------------");
            System.out.print("[1]. Add TodoList\n" +
                    "[2]. Delete TodoList\n" +
                    "[3]. Update TodoList\n" +
                    "[x]. Exit\n");
            System.out.println("-----------------------------------");
            System.out.print("pick one : ");
            var selected = TextInput.textInput();

            switch (selected) {
                case "1" -> {
                    addTodo();
                }
                case "2" -> {
                    deleteTodo();
                }
                case "3" -> {
                    updateTodo();
                }
                case "x" -> {
                    System.exit(1);
                }
                default -> {
                    System.err.println("chooice 1 or 0");
                }
            }
        }
    }

    public void addTodo() {
        var position = 0;
        System.out.print("enter todo: ");
        String textInput = TextInput.textInput();

        TodoList todo = new TodoList(textInput, LocalDateTime.now());
        service.addTodo(todo, position++);
    }

    public void deleteTodo() {
        System.out.print("enter number position : ");
        String position = TextInput.textInput();

        service.deleteTodo(Integer.valueOf(position));
    }

    public void updateTodo() {
        System.out.print("enter number for update : ");
        String position = TextInput.textInput();
        System.out.print("enter new todo : ");
        String todo = TextInput.textInput();

        TodoList newTodo = new TodoList(todo, LocalDateTime.now());
        service.updateTodo(Integer.valueOf(position), newTodo);
    }


}
