package pl.sdacademy.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ListUtil {

    public static List<String> createSingletonListWithRandomElement(final List<String> source) {
        if (source.isEmpty()) {
            return Collections.emptyList();
        }

        final int size = source.size();
        final int index = new Random().nextInt(size);

        return Collections.singletonList(source.get(index));
    }

    public static List<String> getReversedList(final List<String> source) {
        final List<String> copiedList = new ArrayList<>(source);
        Collections.reverse(copiedList);
        return copiedList;
    }
}
