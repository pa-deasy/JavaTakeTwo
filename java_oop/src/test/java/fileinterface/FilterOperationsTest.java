package fileinterface;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FilterOperationsTest {
    @Test
    public void GivenApplyFiltersWhenAppliedThenFiltersFilesCorrectly() {
        File[] files = {
            new File("image1", "/home/images", 10, ".png"),
            new File("vid1", "/home/images/videos", 100, ".mov"),
            new File("image2", "/home/images", 3, ".png"),
            new File("vid2", "/home/images/videos", 2, ".mov"),
        };
        IFilter[] filters = {
            new SizeLessThanFilter(5),
            new TypeFilter(".png"),
        };

        File[] filtered = FilterOperations.applyFilters(files, filters);

        assertEquals(files[2], filtered[0]);
    }
    
}
