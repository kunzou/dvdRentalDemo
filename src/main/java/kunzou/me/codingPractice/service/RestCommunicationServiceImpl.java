package kunzou.me.codingPractice.service;

import kunzou.me.codingPractice.dto.*;
import kunzou.me.codingPractice.handler.RestTemplateResponseErrorHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestCommunicationServiceImpl implements RestCommunicationService {
  private static final Logger logger = LoggerFactory.getLogger(RestCommunicationServiceImpl.class);
  public static final String API_URL = "http://localhost:8080/api/";

  private RestTemplate restTemplate;

  public RestCommunicationServiceImpl(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  public List<Customer> getAllCustomers() {
    String url = String.format("%s/%s", API_URL, "customers");
    List<Customer> customers = new ArrayList<>();
    try {
      ResponseEntity<List<Customer>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Customer>>() {});

      if(response.hasBody()) {
        customers = response.getBody();
      }

    } catch (RestClientException e) {
      /*handle error*/
      logger.error(e.getMessage(), e);
    }

    return customers;
  }

  @Override
  public Optional<CustomerInformation> getCustomer(Long id) {
    String url = String.format("%s/%s/%d", API_URL, "customer/", id);

    CustomerInformation customerInformation = null;

    try {
      ResponseEntity<CustomerInformation> response = restTemplate.getForEntity(url, CustomerInformation.class);

      if(response.getStatusCode() != HttpStatus.OK || !response.hasBody()) {
        /*handle error*/
      }

      customerInformation = response.getBody();
    } catch (RestClientException e) {
      /*handle error*/
      logger.error(e.getMessage(), e);
    }

    return Optional.ofNullable(customerInformation);
  }

  @Override
  public Optional<FilmInformation> getFilm(Long id) {
    String url = String.format("%s/%s/%d", API_URL, "film/", id);

    FilmInformation filmInformation = null;

    try {
      ResponseEntity<FilmInformation> response = restTemplate.getForEntity(url, FilmInformation.class);

      if(response.getStatusCode() != HttpStatus.OK || !response.hasBody()) {
        /*handle error*/
      }
      filmInformation = response.getBody();
    } catch (RestClientException e) {
      /*handle error*/
      logger.error(e.getMessage(), e);
    }

    return Optional.ofNullable(filmInformation);
  }

  @Override
  public List<AvailableFilm> getAvailableFilms() {
    String url = String.format("%s/%s", API_URL, "availableFilms");
    List<AvailableFilm> films = new ArrayList<>();
    try {
      ResponseEntity<List<AvailableFilm>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<AvailableFilm>>() {});

      if(response.hasBody()) {
        films = response.getBody();
      }

    } catch (RestClientException e) {
      /*handle error*/
      logger.error(e.getMessage(), e);
    }

    return films;
  }

  @Override
  public void clearAllCache() {
    String url = String.format("%s/%s", API_URL, "cache/reset/all");
    try {
      restTemplate.getForEntity(url, Object.class);
      logger.info("Cache cleared");
    } catch (RestClientException e) {
      /*handle error*/
      logger.error(e.getMessage(), e);
    }
  }

  public void clearCustomerCache(Long id) {
    String url = String.format("%s/%s/%s", API_URL, "cache/reset/customer", id);
    try {
      restTemplate.getForEntity(url, Object.class);
      logger.info("Cache cleared");
    } catch (RestClientException e) {
      /*handle error*/
      logger.error(e.getMessage(), e);
    }
  }

  public void clearFilmCache(Long id) {
    String url = String.format("%s/%s/%s", API_URL, "cache/reset/film", id);
    try {
      restTemplate.getForEntity(url, Object.class);
      logger.info("Cache cleared");
    } catch (RestClientException e) {
      /*handle error*/
      logger.error(e.getMessage(), e);
    }
  }

}
