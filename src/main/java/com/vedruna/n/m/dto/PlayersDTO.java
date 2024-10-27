package com.vedruna.n.m.dto;

import com.vedruna.n.m.persistance.model.Players;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlayersDTO {
    private int idPlayer;
    private String username;

    public PlayersDTO(Players pl){
        this.idPlayer = pl.getIdPlayer();
        this.username = pl.getUsername();
    }
}
