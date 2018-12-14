package com.bobocode.dal;

import com.bobocode.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query("select t from Team t where name = :name")
    Optional<Team> findTeamByName(@Param("name") String name);
}
