package com.mrizkisaputra;

public class TodoListServiceImpl implements TodoListService {
    private final TodoListRepository repository;

    public TodoListServiceImpl(TodoListRepository repository) {
        this.repository = repository;
    }

    @Override
    public void displayTodolist() {
        TodoList[] listTodo = repository.getAll();
        var number = 0;
        for (var i = 0; i < listTodo.length; i++) {
            ++number;
            if (listTodo[i] != null) {
                System.out.println(
                        number+". "+ listTodo[i].getTodo() +
                                " : created at "+listTodo[i].getDateTime()
                );
            }
        }
    }

    @Override
    public void addTodo(TodoList todo, Integer position) {
        repository.addTodo(todo, position);
    }

    @Override
    public void deleteTodo(Integer position) {
        var delete = repository.deleteTodo(position);

        var result = (delete) ? "success delete" : "delete failed";
        System.out.println(result);

    }

    @Override
    public void updateTodo(Integer position, TodoList todo) {
        var update = repository.updateTodo(position, todo);

        String result = (update) ? "update success" : "update failed";
        System.out.println(result);
    }
}
