package pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.entity.Film;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.entity.Planet;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.entity.SWCharacter;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.entity.Species;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.entity.Starship;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.entity.Vehicle;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.service.FilmService;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.service.PlanetService;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.service.SWCharacterService;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.service.SpeciesService;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.service.StarshipService;
import pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.service.VehicleService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/starwars")
public class RestController {
	
	private SWCharacterService swCharacterService;
	private PlanetService planetService;
	private FilmService filmService;
	private SpeciesService speciesService;
	private VehicleService vehicleService;
	private StarshipService starshipService;
	
	@Autowired
	public RestController(SWCharacterService theCharacterService, PlanetService thePlanetService, FilmService filmService,
			SpeciesService speciesService, VehicleService vehicleService, StarshipService starshipService) {
		this.swCharacterService = theCharacterService;
		this.planetService = thePlanetService;
		this.filmService = filmService;
		this.speciesService = speciesService;
		this.vehicleService = vehicleService;
		this.starshipService = starshipService;
	}
	
	@GetMapping("/swstarships/list")
	public ModelAndView findAllStarshipsList (Model theModel) {
		
		Iterable <Starship> starships = starshipService.findAll();
		
		theModel.addAttribute("starships", starships);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("list-starships");
		
		return modelAndView;
	}
	
	@GetMapping("/swstarships/add")
	public ModelAndView addStarship (Model theModel) {
		
		Starship theStarship = new Starship();
		
		theModel.addAttribute("starship", theStarship);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("starship-form");
		
		return modelAndView;
	}
	
	@GetMapping("/swstarships/delete")
	public ModelAndView deleteSWStarship (@RequestParam("starshipId") int theId) {
		
		starshipService.deleteById(theId);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("redirect:/starwars/swstarships/list");
		
		return modelAndView;
	}
	
	@GetMapping("/swstarships/update")
	public ModelAndView updateStarship (@RequestParam("starshipId") int theId, Model theModel) {
		
		Starship theStarship = starshipService.findById(theId);
		
		theModel.addAttribute("starship", theStarship);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("starship-form");
		
		return modelAndView;	
	}
	
	@PostMapping("/swstarships/save")
	public ModelAndView saveSWStarship (@ModelAttribute("starship") Starship theStarship) {
		
		starshipService.save(theStarship);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("redirect:/starwars/swstarships/list");
		
		return modelAndView;
	}
	
	@GetMapping("/swstarships/search")
	public ModelAndView searchStarship (@RequestParam("starshipName") String theName, Model theModel) {
		
		List <Starship> starships = starshipService.searchBy(theName);
		
		theModel.addAttribute("starships", starships);
		 
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("list-starships");
		
		return modelAndView;
	}
	
	@GetMapping("/swvehicles/list")
	public ModelAndView findAllVehiclesList (Model theModel) {
		
		Iterable <Vehicle> vehicles = vehicleService.findAll();
		
		theModel.addAttribute("vehicles", vehicles);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("list-vehicles");
		
		return modelAndView;
	}
	
	@GetMapping("/swvehicles/add")
	public ModelAndView addVehicle(Model theModel) {
		
		Vehicle theVehicle = new Vehicle();
		
		theModel.addAttribute("vehicle", theVehicle);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("vehicle-form");
		
		return modelAndView;
	}
	
	@GetMapping("/swvehicles/delete")
	public ModelAndView deleteSWVehicle(@RequestParam("vehicleId") int theId) {
		
		vehicleService.deleteById(theId);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("redirect:/starwars/swvehicles/list");
		
		return modelAndView;
	}
	
	@GetMapping("/swvehicles/update")
	public ModelAndView updateVehicle (@RequestParam("vehicleId") int theId, Model theModel) {
		
		Vehicle theVehicle = vehicleService.findById(theId);
		
		theModel.addAttribute("vehicle", theVehicle);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("vehicle-form");
		
		return modelAndView;	
	}
	
	@PostMapping("/swvehicles/save")
	public ModelAndView saveSWVehicle(@ModelAttribute("vehicle") Vehicle theVehicle) {
		
		vehicleService.save(theVehicle);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("redirect:/starwars/swvehicles/list");
		
		return modelAndView;
	}
	
	@GetMapping("/swvehicles/search")
	public ModelAndView searchVehicle(@RequestParam("vehicleName") String theName, Model theModel) {
		
		List <Vehicle> vehicles = vehicleService.searchBy(theName);
		
		theModel.addAttribute("vehicles", vehicles);
		 
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("list-vehicles");
		
		return modelAndView;
	}
	
	@GetMapping("/swspecies/list")
	public ModelAndView findAllSpeciesList (Model theModel) {
		
		Iterable <Species> species = speciesService.findAll();
		
		theModel.addAttribute("species", species);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("list-species");
		
		return modelAndView;
	}
	
	@GetMapping("/swspecies/add")
	public ModelAndView addSpecies(Model theModel) {
		
		Species theSpecies = new Species();
		
		theModel.addAttribute("species", theSpecies);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("species-form");
		
		return modelAndView;
	}
	
	@GetMapping("/swspecies/delete")
	public ModelAndView deleteSWSpecies(@RequestParam("speciesId") int theId) {
		
		speciesService.deleteById(theId);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("redirect:/starwars/swspecies/list");
		
		return modelAndView;
	}
	
	@GetMapping("/swspecies/update")
	public ModelAndView updateSpecies (@RequestParam("speciesId") int theId, Model theModel) {
		
		Species theSpecies = speciesService.findById(theId);
		
		theModel.addAttribute("species", theSpecies);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("species-form");
		
		return modelAndView;	
	}
	
	@PostMapping("/swspecies/save")
	public ModelAndView saveSWSpecies(@ModelAttribute("species") Species theSpecies) {
		
		speciesService.save(theSpecies);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("redirect:/starwars/swspecies/list");
		
		return modelAndView;
	}
	
	@GetMapping("/swspecies/search")
	public ModelAndView searchSpecies(@RequestParam("speciesName") String theName, Model theModel) {
		
		List <Species> species = speciesService.searchBy(theName);
		
		theModel.addAttribute("species", species);
		 
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("list-species");
		
		return modelAndView;
	}
	
	@GetMapping("/swfilms/list")
	public ModelAndView findAllFilmsList (Model theModel) {
		
		Iterable <Film> films = filmService.findAll();
		
		theModel.addAttribute("films", films);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("list-films");
		
		return modelAndView;
	}
	
	@GetMapping("/swfilms/add")
	public ModelAndView addFilm(Model theModel) {
		
		Film theFilm = new Film();
		
		theModel.addAttribute("film", theFilm);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("film-form");
		
		return modelAndView;
	}
	
	@GetMapping("/swfilms/delete")
	public ModelAndView deleteSWFilm(@RequestParam("filmId") int theId) {
		
		filmService.deleteById(theId);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("redirect:/starwars/swfilms/list");
		
		return modelAndView;
	}
	
	@GetMapping("/swfilms/update")
	public ModelAndView updateFilm (@RequestParam("filmId") int theId, Model theModel) {
		
		Film theFilm = filmService.findById(theId);
		
		theModel.addAttribute("film", theFilm);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("film-form");
		
		return modelAndView;	
	}
	
	@PostMapping("/swfilms/save")
	public ModelAndView saveSWFilm(@ModelAttribute("film") Film theFilm) {
		
		filmService.save(theFilm);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("redirect:/starwars/swfilms/list");
		
		return modelAndView;
	}
	
	@GetMapping("/swfilms/search")
	public ModelAndView searchFilm(@RequestParam("filmName") String theName, Model theModel) {
		
		List <Film> films = filmService.searchBy(theName);
		
		theModel.addAttribute("films", films);
		 
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("list-films");
		
		return modelAndView;
	}
	
	@GetMapping("/swplanets/list")
	public ModelAndView findAllPlanetsList (Model theModel) {
		
		Iterable <Planet> planets = planetService.findAll();
		
		theModel.addAttribute("planets", planets);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("list-planets");
		
		return modelAndView;
	}
	
	@GetMapping("/swplanets/add")
	public ModelAndView addPlanet(Model theModel) {
		
		Planet thePlanet = new Planet();
		
		theModel.addAttribute("planet", thePlanet);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("planet-form");
		
		return modelAndView;
	}
	
	@GetMapping("/swplanets/delete")
	public ModelAndView deleteSWPlanet(@RequestParam("planetId") int theId) {
		
		planetService.deleteById(theId);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("redirect:/starwars/swplanets/list");
		
		return modelAndView;
	}
	
	@GetMapping("/swplanets/update")
	public ModelAndView updatePlanet (@RequestParam("planetId") int theId,
									Model theModel) {
		
		Planet thePlanet = planetService.findById(theId);
		
		theModel.addAttribute("planet", thePlanet);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("planet-form");
		
		return modelAndView;	
	}
	
	@PostMapping("/swplanets/save")
	public ModelAndView saveSWPlanet(@ModelAttribute("planet") Planet thePlanet) {
		
		planetService.save(thePlanet);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("redirect:/starwars/swplanets/list");
		
		return modelAndView;
	}
	
	@GetMapping("/swplanets/search")
	public ModelAndView searchPlanet(@RequestParam("planetName") String theName, Model theModel) {
		
		List <Planet> planets = planetService.searchBy(theName);
		
		theModel.addAttribute("planets", planets);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("list-planets");
		
		return modelAndView;
	}
	
	@GetMapping("/swcharacters/list")
	public ModelAndView findAllSWCharactersList (Model theModel) {
		
		Iterable <SWCharacter> swCharacters = swCharacterService.findAll();
		
		theModel.addAttribute("swcharacters", swCharacters);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("list-characters");
		
		return modelAndView;
	}
	
	@GetMapping("/swcharacters/add")
	public ModelAndView addCharacter(Model theModel) {
		
		SWCharacter theSwCharacter = new SWCharacter();
		
		theModel.addAttribute("swcharacter", theSwCharacter);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("character-form");
		
		return modelAndView;
	}
	
	@GetMapping("/swcharacters/delete")
	public ModelAndView deleteCharacter(@RequestParam("swcharacterId") int theId) {
		
		swCharacterService.deleteById(theId);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("redirect:/starwars/swcharacters/list");
		
		return modelAndView;
	}
	
	@GetMapping("/swcharacters/update")
	public ModelAndView updateCharacter (@RequestParam("swcharacterId") int theId,
									Model theModel) {
		
		SWCharacter theSwCharacter = swCharacterService.findById(theId);
		
		theModel.addAttribute("swcharacter", theSwCharacter);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("character-form");
		
		return modelAndView;	
	}
	
	@PostMapping("/swcharacters/save")
	public ModelAndView saveCharacter(@ModelAttribute("swcharacter") SWCharacter theSwCharacter) {
		
		swCharacterService.save(theSwCharacter);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("redirect:/starwars/swcharacters/list");
		
		return modelAndView;
	}
	
	@GetMapping("/swcharacters/search")
	public ModelAndView searchCharacter(@RequestParam("characterName") String theName, Model theModel) {
		
		List <SWCharacter> theSwCharacters = swCharacterService.searchBy(theName);
		
		theModel.addAttribute("swcharacters", theSwCharacters);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("list-characters");
		
		return modelAndView;
	}
	
	@GetMapping("/swstarships")
	public Iterable <Starship> findAllStarships(Model theModel) {
		
		return starshipService.findAll();
	}
	
	@GetMapping("/swstarships/{theId}")
	public Starship findStarshipById (@PathVariable int theId) {
		
		Starship theStarship = starshipService.findById(theId);
		
		if (theStarship == null) {
			throw new RuntimeException("Starship not found with id - " + theId);
		}
		
		return theStarship;
	}
	
	@PostMapping("/swstarships")
	public Starship saveStarship (@RequestBody Starship starship) {
		
		starship.setId(0);
		
		starshipService.save(starship);
		
		return starship;
	}
	
	@PutMapping("/swstarships")
	public Starship updateStarship (@RequestBody Starship starship) {
		
		starshipService.save(starship);
		
		return starship;
	}
	
	@DeleteMapping("/swstarships/{theId}")
	public String deleteStarship (@PathVariable int theId) {
		
		Starship theStarship = starshipService.findById(theId);
		
		if (theStarship == null) {
			throw new RuntimeException("Starship not found with id - " + theId);
		}
		
		starshipService.deleteById(theId);
		
		return "Starship deleted with id - " + theId;
	}
	
	@GetMapping("/swvehicles")
	public Iterable <Vehicle> findAllVehicles() {
		
		return vehicleService.findAll();
	}
	
	@GetMapping("/swvehicles/{theId}")
	public Vehicle findVehicleById (@PathVariable int theId) {
		
		Vehicle theVehicle = vehicleService.findById(theId);
		
		if (theVehicle == null) {
			throw new RuntimeException("Vehicle not found with id - " + theId);
		}
		
		return theVehicle;
	}
	
	@PostMapping("/swvehicles")
	public Vehicle saveVehicle (@RequestBody Vehicle vehicle) {
		
		vehicle.setId(0);
		
		vehicleService.save(vehicle);
		
		return vehicle;
	}
	
	@PutMapping("/swvehicles")
	public Vehicle updateVehicle (@RequestBody Vehicle vehicle) {
		
		vehicleService.save(vehicle);
		
		return vehicle;
	}
	
	@DeleteMapping("/swvehicles/{theId}")
	public String deleteVehicle (@PathVariable int theId) {
		
		Vehicle theVehicle = vehicleService.findById(theId);
		
		if (theVehicle == null) {
			throw new RuntimeException("Vehicle not found with id - " + theId);
		}
		
		vehicleService.deleteById(theId);
		
		return "Vehicle deleted with id - " + theId;
	}
	
	@GetMapping("/swspecies")
	public Iterable <Species> findAllSpecies() {
		
		return speciesService.findAll();
	}
	
	@GetMapping("/swspecies/{theId}")
	public Species findSpeciesById (@PathVariable int theId) {
		
		Species theSpecies = speciesService.findById(theId);
		
		if (theSpecies == null) {
			throw new RuntimeException("Species not found with id - " + theId);
		}
		
		return theSpecies;
	}
	
	@PostMapping("/swspecies")
	public Species saveSpecies (@RequestBody Species species) {
		
		species.setId(0);
		
		speciesService.save(species);
		
		return species;
	}
	
	@PutMapping("/swspecies")
	public Species updateSpecies (@RequestBody Species species) {
		
		speciesService.save(species);
		
		return species;
	}
	
	@DeleteMapping("/swspecies/{theId}")
	public String deleteSpecies (@PathVariable int theId) {
		
		Species theSpecies = speciesService.findById(theId);
		
		if (theSpecies == null) {
			throw new RuntimeException("Species not found with id - " + theId);
		}
		
		speciesService.deleteById(theId);
		
		return "Species deleted with id - " + theId;
	}
	
	@GetMapping("/swfilms")
	public Iterable <Film> findAllFilms() {
		
		return filmService.findAll();
	}
	
	@GetMapping("/swfilms/{theId}")
	public Film findFilmById (@PathVariable int theId) {
		
		Film theFilm = filmService.findById(theId);
		
		if (theFilm == null) {
			throw new RuntimeException("Film not found with id - " + theId);
		}
		
		return theFilm;
	}
	
	@PostMapping("/swfilms")
	public Film saveFilm (@RequestBody Film film) {
		
		film.setId(0);
		
		filmService.save(film);
		
		return film;
	}
	
	@PutMapping("/swfilms")
	public Film updateFilm (@RequestBody Film film) {
		
		filmService.save(film);
		
		return film;
	}
	
	@DeleteMapping("/swfilms/{theId}")
	public String deleteFilm (@PathVariable int theId) {
		
		Film theFilm = filmService.findById(theId);
		
		if (theFilm == null) {
			throw new RuntimeException("Film not found with id - " + theId);
		}
		
		filmService.deleteById(theId);
		
		return "Film deleted with id - " + theId;
	}
	
	@GetMapping("/swplanets")
	public Iterable <Planet> findAllPlanets() {
		
		return planetService.findAll();
	}
	
	@GetMapping("/swplanets/{theId}")
	public Planet findPlanetById (@PathVariable int theId) {
		
		Planet thePlanet = planetService.findById(theId);
		
		if (thePlanet == null) {
			throw new RuntimeException("Planet not found with id - " + theId);
		}
		
		return thePlanet;
	}
	
	@PostMapping("/swplanets")
	public Planet savePlanet (@RequestBody Planet planet) {
		
		planet.setId(0);
		
		planetService.save(planet);
		
		return planet;
	}
	
	@PutMapping("/swplanets")
	public Planet updatePlanet (@RequestBody Planet planet) {
		
		planetService.save(planet);
		
		return planet;
	}
	
	@DeleteMapping("/swplanets/{theId}")
	public String deletePlanet (@PathVariable int theId) {
		
		Planet planet = planetService.findById(theId);
		
		if (planet == null) {
			throw new RuntimeException("Planet not found with id - " + theId);
		}
		
		planetService.deleteById(theId);
		
		return "Planet deleted with id - " + theId;
	}
	
	@GetMapping("/swcharacters")
	public Iterable <SWCharacter> findAll() {
		
		return swCharacterService.findAll();
	}
	
	@GetMapping("/swcharacters/{theId}")
	public SWCharacter findSWCharacterById (@PathVariable int theId) {
		
		SWCharacter theCharacter = swCharacterService.findById(theId);
		
		if (theCharacter == null) {
			throw new RuntimeException("SWCharacter not found with id - " + theId);
		}
		
		return theCharacter;
	}
	
	@PostMapping("/swcharacters")
	public SWCharacter saveSWCharacter (@RequestBody SWCharacter swCharacter) {
		
		swCharacter.setId(0);
		
		swCharacterService.save(swCharacter);
		
		return swCharacter;
	}
	
	@PutMapping("/swcharacters")
	public SWCharacter updateSWCharacter (@RequestBody SWCharacter swCharacter) {
		
		swCharacterService.save(swCharacter);
		
		return swCharacter;
	}
	
	@DeleteMapping("/swcharacters/{theId}")
	public String deleteSWCharacter (@PathVariable int theId) {
		
		SWCharacter swCharacter = swCharacterService.findById(theId);
		
		if (swCharacter == null) {
			throw new RuntimeException("SWCharacter not found with id - " + theId);
		}
		
		swCharacterService.deleteById(theId);
		
		return "SWCharacter deleted with id - " + theId;
	}

	@GetMapping
	public ModelAndView helloStarWars(Model theModel) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("helloworld");
		
		theModel.addAttribute("theDate", new java.util.Date());
		
		return modelAndView;
	}
	
	@GetMapping("/menu")
	public ModelAndView getStarWarsMenu(Model theModel) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("menu");
		
		theModel.addAttribute("theDate", new java.util.Date());
		
		return modelAndView;
	}
	
	@GetMapping("/characters/menu")
	public Object getStarWarsCharactersMenu(Model theModel) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("charactersmenu");
		
		theModel.addAttribute("theDate", new java.util.Date());
		
		return modelAndView;
	}

	@GetMapping("/characters")
	public Object getStarWarsCharacters() {
		
		String url = "https://swapi.dev/api/people";
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object SWpeople = restTemplate.getForObject(url, Object.class);
		
		return SWpeople;
	}
	
	@GetMapping("/characters/page/{pageId}")
	public Object getStarWarsCharactersSelectPage(@PathVariable int pageId)  {
		
		String url = "https://swapi.dev/api/people/?page=";
		
		String url1 = url.concat(Integer.toString(pageId));
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object SWpeople = restTemplate.getForObject(url1, Object.class);
		
		return SWpeople;
	}
	
	@GetMapping("/characters/page")
	public Object getStarWarsCharactersSelectPageHTML(@RequestParam(name = "page") int pageId)  {
		
		String url = "https://swapi.dev/api/people/?page=";
		
		String url1 = url.concat(Integer.toString(pageId));
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object SWpeople = restTemplate.getForObject(url1, Object.class);
		
		return SWpeople;
	}
	
	@GetMapping("/characters/{characterId}")
	public Object getStarWarsCharacterById(@PathVariable int characterId) {
		
		String url = "https://swapi.dev/api/people";
		
		String url1 = url.concat("/" + Integer.toString(characterId));
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object SWCharacter = restTemplate.getForObject(url1, Object.class);
		
		return SWCharacter;
	}
	
	@GetMapping("/characters/id")
	public Object getStarWarsCharacterByIdHTML(@RequestParam(name = "id") int characterId) {
		
		String url = "https://swapi.dev/api/people";
		
		String url1 = url.concat("/" + Integer.toString(characterId));
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object SWCharacter = restTemplate.getForObject(url1, Object.class);
		
		return SWCharacter;
	}
	
	@GetMapping("/characters/search/{characterName}")
	public Object getSearchStarWarsCharacters(@PathVariable String characterName) {
		
		String url = "https://swapi.dev/api/people/?search=";
		
		String url1 = url.concat(characterName);
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object searchCharacter = restTemplate.getForObject(url1, Object.class);
		
		return searchCharacter;
	}
	
	@GetMapping("/characters/search")
	public Object getSearchStarWarsCharactersHTML(@RequestParam (name = "name") String characterName) {
		
		String url = "https://swapi.dev/api/people/?search=";
		
		String url1 = url.concat(characterName);
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object searchCharacter = restTemplate.getForObject(url1, Object.class);
		
		return searchCharacter;
	}
	
	@GetMapping("/planets/menu")
	public Object getStarWarsPlanetsMenu(Model theModel) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("planetsmenu");
		
		theModel.addAttribute("theDate", new java.util.Date());
		
		return modelAndView;
	}
	
	@GetMapping("/planets")
	public Object getStarWarsPlanets() {
		
		String url = "https://swapi.dev/api/planets";
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object SWplanets = restTemplate.getForObject(url, Object.class);
		
		return SWplanets;
	}
	
	@GetMapping("/planets/page/{pageId}")
	public Object getStarWarsPlanetsSelectPage(@PathVariable int pageId)  {
		
		String url = "https://swapi.dev/api/planets/?page=";
		
		String url1 = url.concat(Integer.toString(pageId));
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object SWplanets = restTemplate.getForObject(url1, Object.class);
		
		return SWplanets;
	}
	
	@GetMapping("/planets/page")
	public Object getStarWarsPlanetsSelectPageHTML(@RequestParam(name = "page") int pageId)  {
		
		String url = "https://swapi.dev/api/planets/?page=";
		
		String url1 = url.concat(Integer.toString(pageId));
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object SWplanets = restTemplate.getForObject(url1, Object.class);
		
		return SWplanets;
	}
	
	@GetMapping("/planets/{planetId}")
	public Object getStarWarsPlanetsById(@PathVariable int planetId) {
		
		String url = "https://swapi.dev/api/planets";
		
		String url1 = url.concat("/" + Integer.toString(planetId));
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object SWplanet = restTemplate.getForObject(url1, Object.class);
		
		return SWplanet;
	}
	
	@GetMapping("/planets/id")
	public Object getStarWarsPlanetsByIdHTML(@RequestParam(name = "id") int planetId) {
		
		String url = "https://swapi.dev/api/planets";
		
		String url1 = url.concat("/" + Integer.toString(planetId));
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object SWplanet = restTemplate.getForObject(url1, Object.class);
		
		return SWplanet;
	}
	
	@GetMapping("/planets/search/{planetName}")
	public Object getSearchStarWarsPlanets(@PathVariable String planetName) {
		
		String url = "https://swapi.dev/api/planets/?search=";
		
		String url1 = url.concat(planetName);
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object searchPlanet = restTemplate.getForObject(url1, Object.class);
		
		return searchPlanet;
	}
	
	@GetMapping("/planets/search")
	public Object getSearchStarWarsPlanetsHTML(@RequestParam (name = "name") String planetName) {
		
		String url = "https://swapi.dev/api/planets/?search=";
		
		String url1 = url.concat(planetName);
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object searchPlanet = restTemplate.getForObject(url1, Object.class);
		
		return searchPlanet;
	}
	
	@GetMapping("/films/menu")
	public Object getStarWarsFilmsMenu(Model theModel) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("filmsmenu");
		
		theModel.addAttribute("theDate", new java.util.Date());
		
		return modelAndView;
	}
	
	@GetMapping("/films")
	public Object getStarWarsFilms() {
		
		String url = "https://swapi.dev/api/films";
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object SWFilms = restTemplate.getForObject(url, Object.class);
		
		return SWFilms;
	}
	
	@GetMapping("/films/{filmId}")
	public Object getStarWarsFilmsById(@PathVariable int filmId) {
		
		String url = "https://swapi.dev/api/films";
		
		String url1 = url.concat("/" + Integer.toString(filmId));
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object SWFilm = restTemplate.getForObject(url1, Object.class);
		
		return SWFilm;
	}
	
	@GetMapping("/films/id")
	public Object getStarWarsFilmsByIdHTML(@RequestParam(name = "id") int filmId) {
		
		String url = "https://swapi.dev/api/films";
		
		String url1 = url.concat("/" + Integer.toString(filmId));
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object SWFilm = restTemplate.getForObject(url1, Object.class);
		
		return SWFilm;
	}
	
	@GetMapping("/films/search/{filmName}")
	public Object getSearchStarWarsFilms(@PathVariable String filmName) {
		
		String url = "https://swapi.dev/api/films/?search=";
		
		String url1 = url.concat(filmName);
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object searchFilm = restTemplate.getForObject(url1, Object.class);
		
		return searchFilm;
	}
	
	@GetMapping("/films/search")
	public Object getSearchStarWarsFilmsHTML(@RequestParam (name = "name") String filmName) {
		
		String url = "https://swapi.dev/api/films/?search=";
		
		String url1 = url.concat(filmName);
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object searchFilm = restTemplate.getForObject(url1, Object.class);
		
		return searchFilm;
	}
	
	@GetMapping("/species/menu")
	public Object getStarWarsSpeciesMenu(Model theModel) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("speciesmenu");
		
		theModel.addAttribute("theDate", new java.util.Date());
		
		return modelAndView;
	}
	
	@GetMapping("/species")
	public Object getStarWarsSpecies() {
		
		String url = "https://swapi.dev/api/species";
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object SWSpecies = restTemplate.getForObject(url, Object.class);
		
		return SWSpecies;
	}
	
	@GetMapping("/species/page/{pageId}")
	public Object getStarWarsSpeciesSelectPage(@PathVariable int pageId)  {
		
		String url = "https://swapi.dev/api/species/?page=";
		
		String url1 = url.concat(Integer.toString(pageId));
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object SWSpecies = restTemplate.getForObject(url1, Object.class);
		
		return SWSpecies;
	}
	
	@GetMapping("/species/page")
	public Object getStarWarsSpeciesSelectPageHTML(@RequestParam(name = "page") int pageId)  {
		
		String url = "https://swapi.dev/api/species/?page=";
		
		String url1 = url.concat(Integer.toString(pageId));
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object SWSpecies = restTemplate.getForObject(url1, Object.class);
		
		return SWSpecies;
	}
	
	@GetMapping("/species/{speciesId}")
	public Object getStarWarsSpeciesById(@PathVariable int speciesId) {
		
		String url = "https://swapi.dev/api/species";
		
		String url1 = url.concat("/" + Integer.toString(speciesId));
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object SWSpecies = restTemplate.getForObject(url1, Object.class);
		
		return SWSpecies;
	}
	
	@GetMapping("/species/id")
	public Object getStarWarsSpeciesByIdHTML(@RequestParam(name = "id") int speciesId) {
		
		String url = "https://swapi.dev/api/species";
		
		String url1 = url.concat("/" + Integer.toString(speciesId));
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object SWSpecies = restTemplate.getForObject(url1, Object.class);
		
		return SWSpecies;
	}
	
	@GetMapping("/species/search/{speciesName}")
	public Object getSearchStarWarsSpecies(@PathVariable String speciesName) {
		
		String url = "https://swapi.dev/api/species/?search=";
		
		String url1 = url.concat(speciesName);
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object searchSpecies = restTemplate.getForObject(url1, Object.class);
		
		return searchSpecies;
	}
	
	@GetMapping("/species/search")
	public Object getSearchStarWarsSpeciesHTML(@RequestParam (name = "name") String speciesName) {
		
		String url = "https://swapi.dev/api/species/?search=";
		
		String url1 = url.concat(speciesName);
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object searchSpecies = restTemplate.getForObject(url1, Object.class);
		
		return searchSpecies;
	}
	
	@GetMapping("/vehicles/menu")
	public Object getStarWarsVehiclesMenu(Model theModel) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("vehiclesmenu");
		
		theModel.addAttribute("theDate", new java.util.Date());
		
		return modelAndView;
	}
	
	@GetMapping("/vehicles")
	public Object getStarWarsVehicles() {
		
		String url = "https://swapi.dev/api/vehicles";
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object SWVehicles = restTemplate.getForObject(url, Object.class);
		
		return SWVehicles;
	}
	
	@GetMapping("/vehicles/page/{pageId}")
	public Object getStarWarsVehiclesSelectPage(@PathVariable int pageId)  {
		
		String url = "https://swapi.dev/api/vehicles/?page=";
		
		String url1 = url.concat(Integer.toString(pageId));
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object SWVehicles = restTemplate.getForObject(url1, Object.class);
		
		return SWVehicles;
	}
	
	@GetMapping("/vehicles/page")
	public Object getStarWarsVehiclesSelectPageHTML(@RequestParam(name = "page") int pageId)  {
		
		String url = "https://swapi.dev/api/vehicles/?page=";
		
		String url1 = url.concat(Integer.toString(pageId));
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object SWVehicles = restTemplate.getForObject(url1, Object.class);
		
		return SWVehicles;
	}
	
	@GetMapping("/vehicles/{vehicleId}")
	public Object getStarWarsVehiclesById(@PathVariable int vehicleId) {
		
		String url = "https://swapi.dev/api/vehicles";
		
		String url1 = url.concat("/" + Integer.toString(vehicleId));
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object SWVehicle = restTemplate.getForObject(url1, Object.class);
		
		return SWVehicle;
	}
	
	@GetMapping("/vehicles/id")
	public Object getStarWarsVehiclesByIdHTML(@RequestParam(name = "id") int vehicleId) {
		
		String url = "https://swapi.dev/api/vehicles";
		
		String url1 = url.concat("/" + Integer.toString(vehicleId));
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object SWVehicle = restTemplate.getForObject(url1, Object.class);
		
		return SWVehicle;
	}
	
	@GetMapping("/vehicles/search/{vehicleName}")
	public Object getSearchStarWarsVehicles(@PathVariable String vehicleName) {
		
		String url = "https://swapi.dev/api/vehicles/?search=";
		
		String url1 = url.concat(vehicleName);
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object searchVehicles = restTemplate.getForObject(url1, Object.class);
		
		return searchVehicles;
	}
	
	@GetMapping("/vehicles/search")
	public Object getSearchStarWarsVehiclesHTML(@RequestParam (name = "name") String vehicleName) {
		
		String url = "https://swapi.dev/api/vehicles/?search=";
		
		String url1 = url.concat(vehicleName);
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object searchVehicles = restTemplate.getForObject(url1, Object.class);
		
		return searchVehicles;
	}
	
	@GetMapping("/starships/menu")
	public Object getStarWarsStarshipsMenu(Model theModel) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("starshipsmenu");
		
		theModel.addAttribute("theDate", new java.util.Date());
		
		return modelAndView;
	}
	
	@GetMapping("/starships")
	public Object getStarWarsStarships() {
		
		String url = "https://swapi.dev/api/starships";
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object SWStarships = restTemplate.getForObject(url, Object.class);
		
		return SWStarships;
	}
	
	@GetMapping("/starships/page/{pageId}")
	public Object getStarWarsStarshipsSelectPage(@PathVariable int pageId)  {
		
		String url = "https://swapi.dev/api/starships/?page=";
		
		String url1 = url.concat(Integer.toString(pageId));
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object SWStarships = restTemplate.getForObject(url1, Object.class);
		
		return SWStarships;
	}
	
	@GetMapping("/starships/page")
	public Object getStarWarsStarshipsSelectPageHTML(@RequestParam(name = "page") int pageId)  {
		
		String url = "https://swapi.dev/api/starships/?page=";
		
		String url1 = url.concat(Integer.toString(pageId));
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object SWStarships = restTemplate.getForObject(url1, Object.class);
		
		return SWStarships;
	}
	
	@GetMapping("/starships/{starshipId}")
	public Object getStarWarsStarshipsById(@PathVariable int starshipId) {
		
		String url = "https://swapi.dev/api/starships";
		
		String url1 = url.concat("/" + Integer.toString(starshipId));
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object SWStarship = restTemplate.getForObject(url1, Object.class);
		
		return SWStarship;
	}
	
	@GetMapping("/starships/id")
	public Object getStarWarsStarshipsByIdHTML(@RequestParam(name = "id") int starshipId) {
		
		String url = "https://swapi.dev/api/starships";
		
		String url1 = url.concat("/" + Integer.toString(starshipId));
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object SWStarship = restTemplate.getForObject(url1, Object.class);
		
		return SWStarship;
	}
	
	@GetMapping("/starships/search/{starshipName}")
	public Object getSearchStarWarsStarships(@PathVariable String starshipName) {
		
		String url = "https://swapi.dev/api/starships/?search=";
		
		String url1 = url.concat(starshipName);
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object searchStarships = restTemplate.getForObject(url1, Object.class);
		
		return searchStarships;
	}
	
	@GetMapping("/starships/search")
	public Object getSearchStarWarsStarshipsHTML(@RequestParam (name = "name") String starshipName) {
		
		String url = "https://swapi.dev/api/starships/?search=";
		
		String url1 = url.concat(starshipName);
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object searchStarships = restTemplate.getForObject(url1, Object.class);
		
		return searchStarships;
	}
}
