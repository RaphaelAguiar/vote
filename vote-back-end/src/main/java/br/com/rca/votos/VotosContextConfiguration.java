package br.com.rca.votos;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VotosContextConfiguration {

  @Bean
  public MongoClient mongoClient() {
    return new MongoClient("localhost",27017);
  }
}
