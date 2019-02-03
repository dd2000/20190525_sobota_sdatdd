package pl.sdacademy.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class IntegerFilters {

    public List<Integer> filter(int toFilter, final List<Integer> filters) {
        return toFilteredDigitsList(toFilter, digit -> !filters.contains(digit));
    }

    public List<Integer> filterDigitsGreaterThan(int toFilter, final int lowerBoundExclusive) {
        return toFilteredDigitsList(toFilter, digit -> digit > lowerBoundExclusive);
    }

    private List<Integer> toDigitsList(int number) {
        final List<Integer> digits = new ArrayList<>();
        while (number > 10) {
            digits.add(number % 10);
            number = number / 10;
        }
        digits.add(number);
        return digits;
    }

    private List<Integer> toFilteredDigitsList(int number, final Predicate<? super Integer> filterPredicate) {
        return toDigitsList(number).stream()
                .filter(filterPredicate)
                .collect(Collectors.toList());
    }
}
