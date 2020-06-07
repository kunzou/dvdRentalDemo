package kunzou.me.codingPractice.service;

import kunzou.me.codingPractice.dto.AvailableFilm;
import kunzou.me.codingPractice.dto.Customer;
import kunzou.me.codingPractice.dto.CustomerInformation;
import kunzou.me.codingPractice.dto.FilmInformation;

import java.util.List;
import java.util.Optional;

public interface RestCommunicationService {
  List<Customer> getAllCustomers();
  Optional<CustomerInformation> getCustomer(Long id);
  List<AvailableFilm> getAvailableFilms();
  Optional<FilmInformation> getFilm(Long id);
  void clearAllCache();
  void clearCustomerCache(Long id);
  void clearFilmCache(Long id);
}
