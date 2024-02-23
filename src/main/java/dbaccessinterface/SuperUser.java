package dbaccessinterface;

public class SuperUser implements IReadAccess, IWriteAccess, IDeleteAccess {
    public String read() {
        return "Super read";
    }

    public String write(String record) {
        return String.format("Super write %s", record);
    }

    public String delete(int id) {
        return String.format("Super delete %d", id);
    }
}
