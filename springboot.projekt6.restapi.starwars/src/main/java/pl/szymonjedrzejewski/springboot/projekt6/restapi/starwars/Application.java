package pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.entity.SWCharacter;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.service.SWCharacterService;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
//	@Bean
//	CommandLineRunner runner(SWCharacterService swCharacterService) {
//
//		return args -> {
//
//			// read JSON and write to DB
//			ObjectMapper mapper = new ObjectMapper();
//			TypeReference<List<SWCharacter>> typeReference = new TypeReference <List <SWCharacter>>(){};
//			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/charactersData.json");
//
//			try {
//				List <SWCharacter> swCharacters = mapper.readValue(inputStream, typeReference);
//				swCharacterService.save(swCharacters);
//				System.out.println("SWCharacters Saved!");
//			} catch (Exception e) {
//				System.out.println("Unable to save SWCharacters: " + e.getMessage());
//			}
//		};
//	}
	
//	@Bean
//	CommandLineRunner runner1(PlanetService planetService) {
//		
//		return args -> {
//			
//			// read JSON and write to DB
//			ObjectMapper mapper = new ObjectMapper();
//			TypeReference <List <Planet>> typeReference = new TypeReference <List <Planet>>(){};
//			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/planetsData.json");
//			
//			try {
//				List <Planet> planets = mapper.readValue(inputStream, typeReference);
//				planetService.save(planets);
//				System.out.println("Planets Saved!");
//			} catch (Exception e) {
//				System.out.println("Unable to save Planets: " + e.getMessage());
//			}
//		};
//	}
	
//	@Bean
//	CommandLineRunner runner1(FilmService filmService) {
//		
//		return args -> {
//			
//			// read JSON and write to DB
//			ObjectMapper mapper = new ObjectMapper();
//			TypeReference <List <Film>> typeReference = new TypeReference <List <Film>>(){};
//			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/filmsData.json");
//			
//			try {
//				List <Film> films = mapper.readValue(inputStream, typeReference);
//				filmService.save(films);
//				System.out.println("Films Saved!");
//			} catch (Exception e) {
//				System.out.println("Unable to save Films: " + e.getMessage());
//			}
//		};
//	}
	
//	@Bean
//	CommandLineRunner runner1(SpeciesService speciesService) {
//		
//		return args -> {
//			
//			// read JSON and write to DB
//			ObjectMapper mapper = new ObjectMapper();
//			TypeReference <List <Species>> typeReference = new TypeReference <List <Species>>(){};
//			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/speciesData.json");
//			
//			try {
//				List <Species> species = mapper.readValue(inputStream, typeReference);
//				speciesService.save(species);
//				System.out.println("Species Saved!");
//			} catch (Exception e) {
//				System.out.println("Unable to save Species: " + e.getMessage());
//			}
//		};
//	}
	
//	@Bean
//	CommandLineRunner runner1(VehicleService vehicleService) {
//		
//		return args -> {
//			
//			// read JSON and write to DB
//			ObjectMapper mapper = new ObjectMapper();
//			TypeReference <List <Vehicle>> typeReference = new TypeReference <List <Vehicle>>(){};
//			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/vehiclesData.json");
//			
//			try {
//				List <Vehicle> vehicles = mapper.readValue(inputStream, typeReference);
//				vehicleService.save(vehicles);
//				System.out.println("Vehicles Saved!");
//			} catch (Exception e) {
//				System.out.println("Unable to save Vehicles: " + e.getMessage());
//			}
//		};
//	}
	
//	@Bean
//	CommandLineRunner runner1(StarshipService starshipService) {
//		
//		return args -> {
//			
//			// read JSON and write to DB
//			ObjectMapper mapper = new ObjectMapper();
//			TypeReference <List <Starship>> typeReference = new TypeReference <List <Starship>>(){};
//			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/starshipsData.json");
//			
//			try {
//				List <Starship> starships = mapper.readValue(inputStream, typeReference);
//				starshipService.save(starships);
//				System.out.println("Starships Saved!");
//			} catch (Exception e) {
//				System.out.println("Unable to save Starships: " + e.getMessage());
//			}
//		};
//	}
}
