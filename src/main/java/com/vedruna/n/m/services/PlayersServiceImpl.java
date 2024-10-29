package com.vedruna.n.m.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.n.m.controllers.TrophieController;
import com.vedruna.n.m.dto.CrearPlayersDTO;
import com.vedruna.n.m.dto.PlayersDTO;
import com.vedruna.n.m.persistance.model.Players;
import com.vedruna.n.m.persistance.repository.PlayersRepository;
import com.vedruna.n.m.persistance.repository.TrophiesRepository;

@Service
public class PlayersServiceImpl implements PlayersServiceI {
    @Autowired
    PlayersRepository playersRepo;
    @Autowired
    TrophiesRepository trophieRepo;

    @Override
    public PlayersDTO getPlayerById(int idPlayer){
        return new PlayersDTO(playersRepo.findByIdPlayer(idPlayer));
    }
    
    @Override
    public List<PlayersDTO> getPlayerByUsername(String username){
        List<Players> playersList = playersRepo.findByUsername(username);
        List<PlayersDTO>playersDTOList = new ArrayList<PlayersDTO>();

        for (Players player : playersList){
            playersDTOList.add(new PlayersDTO(player));
        }
        return playersDTOList; 
    }

    @Override
    public List<PlayersDTO> findAll(){
        List<Players> playersList = playersRepo.findAll();
        List<PlayersDTO> playersDTOList = new ArrayList<>();

        for (Players player : playersList){
            playersDTOList.add(new PlayersDTO(player));
        }
        return playersDTOList;
    }

    @Override
    public void insertPlayer(CrearPlayersDTO players){
        Players newPlayer = new Players();
        newPlayer.setIdPlayer(players.getIdPlayer());
        newPlayer.setUsername(players.getUsername());
        playersRepo.save(newPlayer);
    }

    @Override
    public void deletePlayer(int idPlayer) {
        playersRepo.deleteById(idPlayer); // Asegúrate de que esta función existe en tu repositorio
    }

    @Override
    public void giveTrophieToPlayer(int idPlayer, int idTrophie){
        Players player=playersRepo.findByIdPlayer(idPlayer);

        player.getTrophiesOfPlayer().add(trophieRepo.findById(idTrophie).get());
        playersRepo.save(player);
    }

}
