package kunzou.me.codingPractice.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class AvailableFilm {
  private Long id;
  private String title;
  private String category;
  private String description;
  private String rating;
  private Integer rentalDuration;
}
