package fileinterface;

public class FilterOperations {
    public static File[] applyFilters(File[] files, IFilter[] filters) {
        for (IFilter f : filters) {
            files = f.filter(files);
        }

        return files;
    }
}
