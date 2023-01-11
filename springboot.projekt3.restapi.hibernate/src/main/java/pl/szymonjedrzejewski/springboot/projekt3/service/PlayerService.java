package pl.szymonjedrzejewski.springboot.projekt3.service;

import java.util.List;
import pl.szymonjedrzejewski.springboot.projekt3.entity.Player;

public interface PlayerService {
	
	public List <Player> findAll();
	
	public Player findById (int theId);
	
	public void save (Player thePlayer);
	
	public void deleteById (int theId);
}
