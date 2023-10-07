package com.mrizkisaputra;

import java.util.Scanner;

public class TextInput {
    private static Scanner scanner = new Scanner(System.in);

    public static String textInput() {
        return scanner.nextLine();
    }
}
