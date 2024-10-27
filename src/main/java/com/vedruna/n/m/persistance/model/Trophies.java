package com.vedruna.n.m.persistance.model;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "trophies")
@Data
@NoArgsConstructor
public class Trophies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idtrophie", nullable = false)
    private int idTrophie;

    @Column(name="title", length = 45)
    private String title;

    @Column(name="description", length = 65535)
    private String description;

    @ManyToMany(mappedBy = "trophiesOfPlayer")
    private List<Players> playersWhoHaveTrophy = new ArrayList<>();
    }
    

