package com.vedruna.n.m.services;

import java.util.List;

import com.vedruna.n.m.dto.CrearTrophiesDTO;
import com.vedruna.n.m.dto.TrophiesDTO;

public interface TrophiesServiceI {
    List<TrophiesDTO> findAll();
    TrophiesDTO getTrophieById(int idtrophie);
    List<TrophiesDTO> getTrophieByTitle(String title);
    List<TrophiesDTO> getTrophieByDescription(String description);
    void insertTrophie(CrearTrophiesDTO trophies);
    void deleteTrophie(int id);    
}
