package dbaccessinterface;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DBTest {
    DB db = new DB();

    @Test
    public void GivenDBWhenReadOnlyThenCanRead() {
        ReadOnlyUser user = new ReadOnlyUser();
        
        assertEquals("Read only read", db.read(user));
    }

    @Test
    public void GivenDBWhenAdminUserThenCanReadAndWrite() {
        AdminUser user = new AdminUser();

        assertEquals("Admin read", db.read(user));
        assertEquals("Admin write record", db.write(user, "record"));
    }

    @Test
    public void GivenDBWhenSuperUserThenCanReadAndWriteAndDelete() {
        SuperUser user = new SuperUser();

        assertEquals("Super read", db.read(user));
        assertEquals("Super write record", db.write(user, "record"));
        assertEquals("Super delete 9", db.delete(user, 9));
    }
    
}