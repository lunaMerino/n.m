package com.vedruna.n.m.persistance.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedruna.n.m.persistance.model.Trophies;

public interface TrophiesRepository extends JpaRepository<Trophies, Integer>{
        Trophies findByIdTrophie(int idtrophie);
        List<Trophies> findByTitle(String title);
        List<Trophies> findByDescription(String description);
        Trophies save(Trophies trophies);
}
