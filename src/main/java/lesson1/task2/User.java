package lesson1.task2;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class User {

    public User(final String name) {
        this.name = name;
    }

    private String name;

}
