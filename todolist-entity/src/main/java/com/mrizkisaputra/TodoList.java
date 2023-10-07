package com.mrizkisaputra;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
