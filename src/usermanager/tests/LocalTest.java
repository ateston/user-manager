package usermanager.tests;

import org.junit.BeforeClass;
import org.junit.Test;

import usermanager.UserManager;
import usermanager.model.User;

public class LocalTest {

    static UserManager userManager;
    static User user;

    @BeforeClass
    public static void setUp() {
        userManager = UserManager.getInstance();
        user = userManager.getCurrentUser();
    }
    
    @Test
    public void testSuite(){
        assert(true);
    }

    @Test
    public void testUserExists() {
        assert(user != null);
    }

}
