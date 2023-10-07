package com.mrizkisaputra;

public interface TodoListRepository {

    public TodoList[] getAll();

    public void addTodo(TodoList todo, Integer position);

    public Boolean deleteTodo(Integer position);

    public Boolean updateTodo(Integer position, TodoList newTodo);
}
