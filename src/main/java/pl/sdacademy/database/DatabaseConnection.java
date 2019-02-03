package pl.sdacademy.database;

import pl.sdacademy.exceptions.DatabaseConnectionException;

public class DatabaseConnection {

    private boolean isOpen;

    public boolean isOpen() {
        return isOpen;
    }

    public void open() {
        if (isOpen) {
            throw new DatabaseConnectionException("DatabaseStore connection is already opened");
        }

        isOpen = true;
    }

    public void close() throws InterruptedException {
        if (!isOpen) {
            throw new DatabaseConnectionException("DatabaseStore connection is already closed");
        }
        System.out.println("Closing database connection");
        Thread.sleep(1000L);
        System.out.println("Database connection close");
    }


}
