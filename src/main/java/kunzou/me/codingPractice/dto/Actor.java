
package kunzou.me.codingPractice.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Actor {

    private Long actorId;
    private String firstName;
    private String lastName;

}
