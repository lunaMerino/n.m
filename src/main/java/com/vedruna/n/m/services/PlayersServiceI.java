package com.vedruna.n.m.services;

import java.util.List;

import com.vedruna.n.m.dto.CrearPlayersDTO;
import com.vedruna.n.m.dto.PlayersDTO;

public interface PlayersServiceI {
    List<PlayersDTO> findAll();
    PlayersDTO getPlayerById(int idplayer);
    List<PlayersDTO> getPlayerByUsername(String player);
    void insertPlayer(CrearPlayersDTO player);
    void deletePlayer(int idPlayer);
    void giveTrophieToPlayer(int idPlayer, int idTrophie);

}
