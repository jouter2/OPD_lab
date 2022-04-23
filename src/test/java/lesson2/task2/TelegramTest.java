package lesson2.task2;

import lesson1.task2.Telegram;
import lesson1.task2.User;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static junit.framework.TestCase.assertEquals;

public class TelegramTest {

    private final User user1 = new User("Nikita");
    private final User user2 = new User("Kolya");
    private final User user3 = new User("Borya");

    @Before
    public void cleanUp() {
        Telegram.delUser(user1);
        Telegram.delUser(user2);
        Telegram.delUser(user3);
    }

    @Test
    public void regUserTest() throws Exception {
        Telegram.regUser(user1);
        Telegram.regUser(user2);
        Telegram.regUser(user3);
        final Set<User> users = Telegram.users;
        assertEquals(3, users.size());
    }

    @Test
    public void delUserTest() throws Exception {
        Telegram.regUser(user1);
        Telegram.regUser(user2);
        Telegram.delUser(user3);
        assertEquals(2, Telegram.users.size());
    }

    @Test(expected = Exception.class)
    public void regUserErrorTest() throws Exception {
        final User user4 = new User("Nikita");
        Telegram.regUser(user1);
        Telegram.regUser(user4);
    }

    @Test(expected = Exception.class)
    public void sendMessageErrorTest() throws Exception {
        Telegram.sendM("userName",0, "Message");
    }
}
