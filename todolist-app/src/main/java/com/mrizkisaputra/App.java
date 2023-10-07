package com.mrizkisaputra;


public class App {
    public static void main(String[] args) {

        TodoListRepository repository = new TodoListRepositoryImpl();
        TodoListService service = new TodoListServiceImpl(repository);

        TodoListView view = new TodoListView(repository, service);

        view.root();
    }
}
