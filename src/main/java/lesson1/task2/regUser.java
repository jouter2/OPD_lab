package lesson1.task2;

public class regUser {

    public static void main(String[] args) throws Exception {
        final User user1 = new User("Nikita");
        final User user2 = new User("Kolya");
        final User user3 = new User("Borya");
        Telegram.regUser(user1);
        Telegram.regUser(user2);
        Telegram.regUser(user3);
        Telegram.sendM("Nikita", 2000, "пам-пам-пам");
    }
}
