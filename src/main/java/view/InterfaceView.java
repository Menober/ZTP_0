package view;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class InterfaceView {

    public static void printOptions() {
        System.out.println();
        System.out.println("<? MVC Village Manager ?>");
        System.out.println("What do you want to do?");
        System.out.println("[1] Create village");
        System.out.println("[2] Read village");
        System.out.println("[3] Update village");
        System.out.println("[4] Delete village");
        System.out.println("[5] Load villages");
        System.out.println("[6] Save villages");
        System.out.println("[7] Sort villages by ID");
        System.out.println("[bye] Exit");
        System.out.print("Command: ");
    }

    public static void invalidCommand() {
        System.out.println("Invalid command.");
    }


    public static void exitMessage() {
        System.out.println("Goodbye then.");
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void tryToSaveMessage() {
        System.out.println("Saving...");
    }

    public static void successSaveMessage() {
        System.out.println("Saved successful!");
    }

    public static void exceptionMessage(FileNotFoundException e) {
        System.out.println("Error: " + e.toString());
    }


    public static String readKeyboard() {
        Scanner io = new Scanner(System.in);
        String message = io.next();
        InterfaceView.printNewLine();
        return message;
    }
}
