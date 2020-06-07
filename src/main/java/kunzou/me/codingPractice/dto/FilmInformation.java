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
public class FilmInformation {
  private List<CustomerInformation> customers;
  private Film film;

  public List<CustomerInformation> getCustomers() {
    if(customers == null) {
      customers = new ArrayList<>();
    }
    return customers;
  }
}
