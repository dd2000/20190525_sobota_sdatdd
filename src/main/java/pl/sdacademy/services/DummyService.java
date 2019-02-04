package pl.sdacademy.services;

public class DummyService {

    private TransformationService transformationService;

    public DummyService(final TransformationService transformationService) {
        this.transformationService = transformationService;
    }

    public String dummifyString(final String value) {
        final String tranformed = transformationService.beautifyValue(value);

        return transformationService.dunderValue(tranformed);
    }
}
