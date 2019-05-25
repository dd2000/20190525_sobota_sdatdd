package pl.sdacademy.database;

import org.junit.jupiter.api.*;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseStoreTest {
    private static DatabaseConnection databaseConnection;
    private DatabaseStore databaseStore;

    @BeforeAll
    static void setUpTestCase(){
        databaseConnection = new DatabaseConnection();
        databaseConnection.open(); // otwarcie połączenia z bazą danych
    } //setUpTestCase()

    @BeforeEach
    static void setUp(){
        databaseStore = new DatabaseStore(databaseConnection);
        System.out.println("Starting next test...");
    } //setUpTestCase()

    // po każdym teście: wyczyćś bazę danych
    @AfterEach
    void tearDown(){
        databaseStore.clean();
    }

    // po wszystkich testach
    @AfterAll
    static void tearDownTestCase(){
        databaseConnection.close();
    }

    // test1
    @Test
    void shouldAddData(){
        final String data = "someData";

        databaseStore.addData(data);

        //asercja
        assertIterableEquals(Collections.singletonList(data), databaseStore.getData());
    } // test1 shouldAddData()


}