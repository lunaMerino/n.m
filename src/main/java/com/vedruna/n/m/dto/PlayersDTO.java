package com.vedruna.n.m.dto;


import java.util.ArrayList;
import java.util.List;

import com.vedruna.n.m.persistance.model.Players;
import com.vedruna.n.m.persistance.model.Trophies;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlayersDTO {
    private int idPlayer;
    private String username;
    private List<TrophiesDTO> trophies; 

    public PlayersDTO(Players pl){
        this.idPlayer = pl.getIdPlayer();
        this.username = pl.getUsername();
        this.trophies = new ArrayList<>();
        for(Trophies trophie : pl.getTrophiesOfPlayer()){
            this.trophies.add(new TrophiesDTO(trophie));
        }
    }
}
