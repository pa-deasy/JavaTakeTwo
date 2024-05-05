package dbaccessinterface;

public class DB {
    public String read(IReadAccess readAccess) {
        return readAccess.read();
    }

    public String write(IWriteAccess writeAccess, String record) {
        return writeAccess.write(record);
    }

    public String delete(IDeleteAccess deleteAccess, int id) {
        return deleteAccess.delete(id);
    }
}
