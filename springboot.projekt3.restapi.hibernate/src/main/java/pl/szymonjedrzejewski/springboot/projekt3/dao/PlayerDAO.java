package pl.szymonjedrzejewski.springboot.projekt3.dao;

import java.util.List;

import pl.szymonjedrzejewski.springboot.projekt3.entity.Player;

public interface PlayerDAO {
	
	public List <Player> findAll();
	
	public Player findById (int theId);
	
	public void save (Player thePlayer);
	
	public void deleteById (int theId);
}
