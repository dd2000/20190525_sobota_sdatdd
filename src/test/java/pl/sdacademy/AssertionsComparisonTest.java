package pl.sdacademy;

import org.junit.jupiter.api.Test;
import pl.sdacademy.util.ListUtil;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertionsComparisonTest {

    private final String EXPECTED = "I_love_sda";

    @Test
    void junitAssertions() {
        final String actual = "I_love_sda";

        assertEquals(EXPECTED, actual);
    }

    @Test
    void assertjAssertions() {
        final String actual = "I_love_sda";

        assertThat(actual).isEqualTo(EXPECTED);
    }

    @Test
    void shouldReverseOrderAndCopyList() {
        final List<String> testedList = Arrays.asList("raz", "dwa", "trzy");

        final List<String> reversed = ListUtil.getReversedList(testedList);

        assertThat(reversed)
                .isNotEmpty()
                .isNotSameAs(testedList)
                .containsExactly("trzy", "dwa", "raz");
    }
}
