package com.mrizkisaputra;

public class TodoListRepositoryImpl implements TodoListRepository {
    private TodoList[] listTodo = new TodoList[10];

    private void resizeLength(TodoList todo) {
        // simpan dulu todo sebelumnya yang sudah ditambahkan sebelum di resize
        TodoList[] temp = listTodo;

        // perbesar ukuran penyimpanan listTodo
        listTodo = new TodoList[listTodo.length * 2];

        // masukkan kembali todo yang sebelumnya sudah ditambahkan
        for (int i = 0; i < temp.length; i++) {
            listTodo[i] = temp[i];
        }

        // masukkan todo yang baru, di listTodo yang sudah diresize
        for (var i = temp.length; i < listTodo.length; i++) {
            if (listTodo[i] != null) {
                continue;
            } else {
                listTodo[i] = todo;
                break;
            }
        }
    }

    @Override
    public TodoList[] getAll() {
        return listTodo;
    }

    @Override
    public void addTodo(TodoList todo, Integer position) {
        if (todo != null) {
            if (position >= listTodo.length) {
                resizeLength(todo);
            } else {
                for (var i = 0; i < listTodo.length; i++) {
                    if (listTodo[i] != null) {
                        continue;
                    } else {
                        listTodo[i] = todo;
                        break;
                    }
                }
            }
        }
    }

    @Override
    public Boolean deleteTodo(Integer position) {
        // jika posisi yang dihapus bukan 0 dan tidak lebih dari panjang listTodo
        if (position >= 1 && (position - 1) < listTodo.length) {
            if (listTodo[position - 1] != null) {
                // menghapus todo
                listTodo[position - 1] = null;

                // menggeser todo mulai dari todo yang dihapus
                for (int i = position - 1; i < listTodo.length; i++) {
                    if (i == listTodo.length - 1) {
                        listTodo[i] = null;
                    } else {
                        listTodo[i] = listTodo[i+1];
                    }
                }

                return true;
            }
        }

        return false;
    }

    @Override
    public Boolean updateTodo(Integer position, TodoList newTodo) {
        if ((position - 1) >= listTodo.length || listTodo[position-1] == null) {
            return false;
        }

        if (listTodo[position - 1] != null) {
            listTodo[position - 1] = newTodo;
        }
        return true;
    }
}
