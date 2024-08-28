package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInform() {
        System.out.println("Активность: " + active);
        System.out.println("Статус: " + status);
        System.out.println("Сообщение: " + message);
    }

    public static void main(String[] args) {
        Error error1 = new Error(true, 1, "Hello");
        error1.printInform();
        Error error2 = new Error(false, 1, "Bye");
        error2.printInform();
        Error error3 = new Error();
        error3.printInform();
    }

}
