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
public class CustomerInformation {

  private Long id;
  private String address;
  private String city;
  private String country;
  private String district;
  private String firstName;
  private String lastName;
  private String phone;

  private List<CustomerRental> customerRentalList;

  public List<CustomerRental> getCustomerRentalList() {
    if(customerRentalList == null) {
      customerRentalList = new ArrayList<>();
    }
    return customerRentalList;
  }

}
