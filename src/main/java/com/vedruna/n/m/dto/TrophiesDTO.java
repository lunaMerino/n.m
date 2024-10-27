package com.vedruna.n.m.dto;

import com.vedruna.n.m.persistance.model.Trophies;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TrophiesDTO {
    private int idTrophie;
    private String title;
    private String description;

    public TrophiesDTO(Trophies tr){
        this.idTrophie = tr.getIdTrophie();
        this.title = tr.getTitle();
        this.description = tr.getDescription();
    }
}
