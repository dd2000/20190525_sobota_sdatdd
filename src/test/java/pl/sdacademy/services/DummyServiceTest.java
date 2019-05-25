package pl.sdacademy.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DummyServiceTest {

    private static final String TEST_STR = "hello";
    private static final String RES_STR = "result";

    @Mock
    private BeatifyService beatifyService;

    @Mock DunderService dunderService;

    @InjectMocks
    private DummyService dummyService;

    @Captor
    private ArgumentCaptor<String> argumentCaptor;

    @Test
    void fullMockitoDemo() {
        when(beatifyService.beautifyValue(TEST_STR)).thenReturn(TEST_STR);
        when(dunderService.dunderValue(TEST_STR)).thenReturn(RES_STR);

        dummyService.dummifyString(TEST_STR);

        verify(dunderService).dunderValue(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue()).isEqualTo(TEST_STR);
    }
}