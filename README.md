# Todolist App

## how to run app
- download and install [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- setup _environment_ and check java version installation on terminal
    - ```shell
      java --version
- download this _repository_ or download _**todolist-app.jar**_ in the repository
- open terminal and go to file **todolist-app.jar** run the program
  - ````shell
    C:\Users\YourComputer\Downloads\todolist> java -jar todolist-app.jar

## Prototype Todolist App
![prototype](prototype%20todolist.jpg)

## Explanation
this project uses the Apache Maven build automation tool.

this project has several modules.
* todolist-app
    * this is main program
    ````java
    public class App {
    public static void main(String[] args) {

        TodoListRepository repository = new TodoListRepositoryImpl();
        TodoListService service = new TodoListServiceImpl(repository);

        TodoListView view = new TodoListView(repository, service);

        view.root();
    }
}
  

* todolist-entity
    * 

* todolist-repository 
* todolist-service 
* todolist-utils 
* todolist-view