package com.mrizkisaputra;

public interface TodoListService {

    public void displayTodolist();
    public void addTodo(TodoList todo, Integer position);

    public void deleteTodo(Integer position);

    public void updateTodo(Integer position, TodoList newTodo);

}
