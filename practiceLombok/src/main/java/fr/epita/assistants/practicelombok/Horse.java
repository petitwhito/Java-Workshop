package fr.epita.assistants.practicelombok;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(of = {"name","nickname"})
public class Horse {
    @Setter @ToString.Include private String name = "toto";
    @Setter private String nickname;
    @ToString.Include private int speed = 0;
}
