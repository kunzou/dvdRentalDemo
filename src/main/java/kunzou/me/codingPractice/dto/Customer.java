
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
public class Customer {
  public static final String DATE_FORMATTER= "yyyy-MM-dd HH:mm:ss.S";

  private Long id;
  private String address;
  private String city;
  private String country;
  private String district;
  private String firstName;
  private String lastName;
  private String phone;
  private List<Rental> rentals;

  public List<Rental> getRentals() {
    if(rentals == null) {
      rentals = new ArrayList<>();
    }
    return rentals;
  }
}
