package pl.sdacademy.database;

import pl.sdacademy.exceptions.DatabaseConnectionException;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DatabaseStore {

    private Set<String> savedValues;

    public DatabaseStore(final DatabaseConnection databaseConnection) {
        if (!databaseConnection.isOpen()) {
            throw new DatabaseConnectionException("Database store has to be initialized with an opened connection");
        }
        savedValues = new HashSet<>();
    }

    public void clear() {
        savedValues.clear();
    }

    public void addData(final String... newData) {
        savedValues.addAll(Stream.of(newData).collect(Collectors.toSet()));
    }

    public void removeData(final String... dataToRemove) {
        savedValues.removeAll(Stream.of(dataToRemove).collect(Collectors.toSet()));
    }

    public Set<String> getData() {
        return Collections.unmodifiableSet(savedValues);
    }
}
