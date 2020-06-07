package kunzou.me.codingPractice.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CustomerRental {
  private String filmTitle;
  private LocalDateTime dateOfRental;
  private Integer durationOfRental;
  private Double costOfRental;
}
