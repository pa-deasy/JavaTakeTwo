package fileinterface;

import java.util.Arrays;

public class SizeLessThanFilter implements IFilter {
    int size;

    public SizeLessThanFilter(int s) {
        size = s;
    }

    public File[] filter(File[] files) {
        return Arrays.stream(files).filter(f -> f.size < size).toArray(File[]::new);
    }
}
