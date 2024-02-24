package fr.epita.assistants.practicelombok;

import lombok.*;

@AllArgsConstructor
@Value
@EqualsAndHashCode(of = {"name","nickname","speed"})
public class Shark {
         String name;
    String nickname;
    int speed;
}
