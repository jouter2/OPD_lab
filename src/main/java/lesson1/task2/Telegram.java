package lesson1.task2;

import lombok.Getter;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Telegram {

    public static final Set<User> users = new HashSet<>();

    public static void delUser(final User user) {
        users.removeIf(curUser -> curUser.getName().equals(user.getName()));
    }

    private static boolean exUser(final String username) {
        return users.stream()
                .map(User::getName)
                .anyMatch(username::equals);
    }

    public static void regUser(final User user) throws Exception {
        if (user == null || user.getName() == null
                || user.getName().isEmpty() || exUser(user.getName())) {
            throw new Exception("User with this name is exist");
        }
        users.add(user);
    }

    public static void sendM(@Nullable String username, final long mills, final String message) throws Exception {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        if (username == null || username.isEmpty()) {
            System.out.printf("Message for all users: %s", message);
        } else {
            if (exUser(username)) {
                System.out.printf("Message send to %s: %s", username, message);
            } else {
                throw new Exception("User don't exist");
            }
        }
    }

}
