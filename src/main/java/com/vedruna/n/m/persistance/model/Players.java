package com.vedruna.n.m.persistance.model;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "players")
@Data
@NoArgsConstructor

public class Players {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idplayer", nullable = false)
    private int idPlayer;

    @Column(name="username", length=45)
    private String username;
    
    @ManyToMany
    @JoinTable(
        name = "players_has_trophies",
        joinColumns = @JoinColumn(name = "players_idplayer"),
        inverseJoinColumns = @JoinColumn(name = "trophies_idtrophie")
    )
    private List<Trophies> trophiesOfPlayer = new ArrayList<>();
    
}