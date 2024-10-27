package com.vedruna.n.m.dto;

import com.vedruna.n.m.persistance.model.Trophies;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CrearTrophiesDTO {
    private int idTrophie;
    private String title;
    private String description;

    public CrearTrophiesDTO(Trophies tr){
        this.idTrophie = tr.getIdTrophie();
        this.title = tr.getTitle();
        this.description = tr.getDescription();
    }
}
