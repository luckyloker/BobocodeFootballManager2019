package com.bobocode.service;

import com.bobocode.dal.PlayerRepository;
import com.bobocode.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public void createNewPlayer(Player player) {
        playerRepository.save(player);
    }


}
