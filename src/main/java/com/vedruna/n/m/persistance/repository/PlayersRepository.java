package com.vedruna.n.m.persistance.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vedruna.n.m.persistance.model.Players;


@Repository
public interface PlayersRepository extends JpaRepository<Players, Integer>{
    Players findByIdPlayer(int idplayer);
    List<Players> findByUsername(String username);
    Players save(Players players);
}
