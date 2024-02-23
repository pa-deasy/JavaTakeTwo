package dbaccessinterface;

public class AdminUser implements IReadAccess, IWriteAccess {
    public String read() {
        return "Admin read";
    }

    public String write(String record) {
        return String.format("Admin write %s", record);
    }
}
