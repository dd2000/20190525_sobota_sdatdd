package pl.sdacademy.database;

public class DatabaseConnection {

    private boolean opened;

    public void open() {
        opened = true;
    }

    public void close() {
        opened = false;
    }

    public boolean isOpened() {
        return opened;
    }
}
