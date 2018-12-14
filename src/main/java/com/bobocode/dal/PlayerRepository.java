package com.bobocode.dal;

import com.bobocode.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
