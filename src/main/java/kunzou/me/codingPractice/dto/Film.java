
package kunzou.me.codingPractice.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Film {

    private Long id;
    private List<Actor> actors;
    private String category;
    private String description;
    private Integer length;
    private String rating;
    private Integer rentalDuration;
    private Double replacementCost;
    private String specialFeatures;
    private String title;

  public List<Actor> getActors() {
    if(actors == null) {
      actors = new ArrayList<>();
    }
    return actors;
  }
}
