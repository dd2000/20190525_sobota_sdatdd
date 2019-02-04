package pl.sdacademy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.sdacademy.database.DatabaseConnection;
import pl.sdacademy.database.DatabaseStore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockitoDemo {

    @Mock
    private DatabaseConnection databaseConnection;

    private DatabaseStore databaseStore;

    @Test
    void shouldGetDatabaseStore() {
        when(databaseConnection.isOpen()).thenReturn(true);

        databaseStore = new DatabaseStore(databaseConnection);

        assertThat(databaseStore.getData()).isEmpty();
        verify(databaseConnection).isOpen();
    }
}
