package dbaccessinterface;

public class ReadOnlyUser implements IReadAccess {
    public String read() {
        return "Read only read";
    }
}
