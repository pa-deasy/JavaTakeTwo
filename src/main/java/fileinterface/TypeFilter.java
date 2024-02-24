package fileinterface;

import java.util.Arrays;

public class TypeFilter implements IFilter {
    String type;

    public TypeFilter(String t) {
        type = t;
    }

    public File[] filter(File[] files) {
        return Arrays.stream(files).filter(f -> f.type.equals(type)).toArray(File[]::new);
    }
}
