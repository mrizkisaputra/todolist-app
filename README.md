# Todolist App
this is an application that runs in the console terminal

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
    * this is class representation data
    ````java
  public class TodoList {
      private final String todo;
      private final LocalDateTime dateTime;
  
      public TodoList(String todo, LocalDateTime dateTime) {
          this.todo = todo;
          this.dateTime = dateTime;
      }
  
      public String getTodo() {
          return this.todo;
      }
  
      public String getDateTime() {
          var formatted = DateTimeFormatter.ofPattern("MMMM/dd/yyyy HH:mm");
          return dateTime.format(formatted);
      }
  }

* todolist-repository 
  * this is logic data
  ````java
  public interface TodoListRepository {

    public TodoList[] getAll();

    public void addTodo(TodoList todo, Integer position);

    public Boolean deleteTodo(Integer position);

    public Boolean updateTodo(Integer position, TodoList newTodo);
  }


* todolist-service 
  * this is business data
  ````java
  public interface TodoListService {

    public void displayTodolist();
    public void addTodo(TodoList todo, Integer position);

    public void deleteTodo(Integer position);

    public void updateTodo(Integer position, TodoList newTodo);

  }


* todolist-utils 
  * this is input scanner
  ```java
  public class TextInput {
    private static Scanner scanner = new Scanner(System.in);
    public static String textInput() {
        return scanner.nextLine();
    }
  }

* todolist-view
  * this view
  ```java
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