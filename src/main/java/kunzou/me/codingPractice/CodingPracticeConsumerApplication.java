package kunzou.me.codingPractice;

import kunzou.me.codingPractice.dto.*;
import kunzou.me.codingPractice.service.RestCommunicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class CodingPracticeConsumerApplication {
  private static final Logger logger = LoggerFactory.getLogger(CodingPracticeConsumerApplication.class);
  private RestCommunicationService restCommunicationService;

  public CodingPracticeConsumerApplication(RestCommunicationService restCommunicationService) {
    this.restCommunicationService = restCommunicationService;
  }

  public static void main(String[] args) {
		SpringApplication.run(CodingPracticeConsumerApplication.class, args);
	}

  @Bean
  public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
    return args -> {
      long startTime = System.currentTimeMillis();
      logger.info("Requesting all customers");
      List<Customer> customerList = restCommunicationService.getAllCustomers();
      long endTime = System.currentTimeMillis();
      logger.info(String.format("%d customers received.", customerList.size()));
      logger.info(String.format("Runtime: %d ms without cache", endTime - startTime));

      startTime = System.currentTimeMillis();
      logger.info("Requesting all customers again");
      customerList = restCommunicationService.getAllCustomers();
      endTime = System.currentTimeMillis();
      logger.info(String.format("%d customers received.", customerList.size()));
      logger.info(String.format("Runtime: %d ms with cache", endTime - startTime));

      restCommunicationService.clearAllCache();

      startTime = System.currentTimeMillis();
      logger.info("Requesting all customers again");
      customerList = restCommunicationService.getAllCustomers();
      endTime = System.currentTimeMillis();
      logger.info(String.format("%d customers received.", customerList.size()));
      logger.info(String.format("Runtime: %d ms with no cache", endTime - startTime));

      logger.info("Requesting customer with id 4");
      Optional<CustomerInformation> customer = restCommunicationService.getCustomer(4L);
      logger.info(String.format("Customer %s %s received", customer.map(CustomerInformation::getFirstName), customer.map(CustomerInformation::getLastName)));

      logger.info("Requesting customer with id -4");
      restCommunicationService.getCustomer(-4L);

      startTime = System.currentTimeMillis();
      logger.info("Requesting all available films");
      List<AvailableFilm> availableFilms = restCommunicationService.getAvailableFilms();
      endTime = System.currentTimeMillis();
      logger.info(String.format("%d films available.", availableFilms.size()));
      logger.info(String.format("Runtime: %d ms without cache", endTime - startTime));

      startTime = System.currentTimeMillis();
      logger.info("Requesting all available films");
      availableFilms = restCommunicationService.getAvailableFilms();
      endTime = System.currentTimeMillis();
      logger.info(String.format("%d films available.", availableFilms.size()));
      logger.info(String.format("Runtime: %d ms with cache", endTime - startTime));

      restCommunicationService.clearAllCache();

      startTime = System.currentTimeMillis();
      logger.info("Requesting all available films");
      availableFilms = restCommunicationService.getAvailableFilms();
      endTime = System.currentTimeMillis();
      logger.info(String.format("%d films available.", availableFilms.size()));
      logger.info(String.format("Runtime: %d ms with no cache", endTime - startTime));

      logger.info("Requesting film with id 20");
      Optional<FilmInformation> filmInformation = restCommunicationService.getFilm(20L);
      logger.info(String.format("Film %s received", filmInformation.map(FilmInformation::getFilm).map(Film::getTitle).orElse(null)));
      logger.info("Requesting film with id -20");
      restCommunicationService.getFilm(-20L);

      logger.info("Clearing customer cache with id 4");
      restCommunicationService.clearCustomerCache(4L);

      logger.info("Clearing film cache with id 20");
      restCommunicationService.clearFilmCache(20L);

      logger.info("ALL DONE");
    };
  }

}


