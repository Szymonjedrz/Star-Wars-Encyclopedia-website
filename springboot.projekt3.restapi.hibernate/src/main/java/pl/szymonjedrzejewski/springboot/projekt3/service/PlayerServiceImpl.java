package pl.szymonjedrzejewski.springboot.projekt3.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szymonjedrzejewski.springboot.projekt3.dao.PlayerDAO;
import pl.szymonjedrzejewski.springboot.projekt3.entity.Player;

@Service
public class PlayerServiceImpl implements PlayerService {
	
	private PlayerDAO playerDAO;

	@Autowired
	public PlayerServiceImpl(PlayerDAO thePlayerDAO) {
		this.playerDAO = thePlayerDAO;
	}

	@Override
	@Transactional
	public List<Player> findAll() {
		return playerDAO.findAll();
	}

	@Override
	@Transactional
	public Player findById(int theId) {
		return playerDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Player thePlayer) {
		playerDAO.save(thePlayer);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		playerDAO.deleteById(theId);
	}

}
