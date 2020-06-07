
package kunzou.me.codingPractice.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Rental {

    private Long filmId;
    private String filmTitle;
    private List<Payment> payments;
    private LocalDateTime rentalDate;
    private Long rentalId;
    private LocalDateTime returnDate;
    private Long staffId;

  public List<Payment> getPayments() {
    if(payments == null) {
      payments =  new ArrayList<>();
    }
    return payments;
  }
}
