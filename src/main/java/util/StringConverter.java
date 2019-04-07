package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringConverter {
    private final static String SPLITTER = ",";

    public static List<Integer> stringToIntegerList(String src) {
        String[] srcArr = src
                .replace(" ", "")
                .split(SPLITTER);

        return Arrays.stream(srcArr)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
