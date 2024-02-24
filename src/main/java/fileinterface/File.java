package fileinterface;

public class File {
    public final String name;
    public final String location;
    public final int size;
    public final String type;

    public File(String n, String l, int s, String t) {
        name = n;
        location = l;
        size = s;
        type = t;
    }
}
