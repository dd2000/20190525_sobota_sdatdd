package pl.sdacademy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import pl.sdacademy.calculations.Operation;

public class SourceTest {

    @ParameterizedTest
    @EnumSource(Operation.class)
    void shouldDisplayOperationName(final Operation operation) {
        System.out.println(operation.name());
    }

    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvSource({
            "PL, 38, 0",
            "EN, 22, 1",
            "FR, 59, 2"
    })
    void csvInputTest(final String countryCode, final int numOfResidentsInMillions, final int index) {
        System.out.println(index + ". In " + countryCode + " lives " + numOfResidentsInMillions + " millions of people");
    }

    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvFileSource(resources = "/source.csv", numLinesToSkip = 0)
    void csvFromFileTest(final String countryCode, final int numOfResidentsInMillions, final int index) {
        System.out.println(index + ". In " + countryCode + " lives " + numOfResidentsInMillions + " millions of people");
    }

    @ParameterizedTest
    @ArgumentsSource(CustomArgumentsProvider.class)
    void argumentsSourceTest(final double arg) {
        System.out.println(arg);
    }
}
