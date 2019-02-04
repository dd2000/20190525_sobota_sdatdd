package pl.sdacademy.services;

public class TransformationService {

    public String beautifyValue(final String value) {
        return "*" + value + "*";
    }

    public String dunderValue(final String value) {
        return "__" + value + "__";
    }
}
