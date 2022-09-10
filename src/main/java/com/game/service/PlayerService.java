package com.game.service;

import com.game.entity.Player;
import com.game.repository.PlayerRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlayerService {
//    private List<Player> players;
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
//        players = playerRepository.findAll();
    }

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    @Transactional
    public void removePlayerWithId(long id) {
        playerRepository.deleteById(id);
//        players = playerRepository.findAll();
    }
    @Transactional
    public Player getPlayerWithId(long id) {
        return playerRepository.findById(id).orElse(null);
    }

    @Transactional
    public void addPlayer(Player player) {
        playerRepository.save(player);
    }
    @Transactional
    public void updatePlayer(Player player) {
        playerRepository.save(player);
    }

}
