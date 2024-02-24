package fr.epita.assistants.practicelombok;

import lombok.*;
import lombok.experimental.FieldDefaults;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
public class Falcon {
    String name;
    String nickname;
    int speed;
}
