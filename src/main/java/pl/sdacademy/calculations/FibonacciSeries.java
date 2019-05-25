package pl.sdacademy.calculations;

public class FibonacciSeries {

    public Long compute(final int index) {
        if (index <= 0) {
            throw new IllegalArgumentException("Index has to be positive");
        }

        if (index == 1 || index == 2) {
            return 1L;
        }

        return compute(index - 1) + compute(index - 2);
    }
}
