package com.vedruna.n.m.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.n.m.dto.CrearTrophiesDTO;
import com.vedruna.n.m.dto.TrophiesDTO;
import com.vedruna.n.m.services.TrophiesServiceI;

@RestController
@RequestMapping("/api/v1/trophie")
@CrossOrigin
public class TrophieController {

    @Autowired
    TrophiesServiceI playerMngmnt;
    @GetMapping
    public List<TrophiesDTO> findAll(){
        return playerMngmnt.findAll();
    }

    @GetMapping("/id/{idtrophie}")
    public TrophiesDTO selectWhereIdTrophiesDTO(@PathVariable int idtrophie){
        return playerMngmnt.getTrophieById(idtrophie);
    }

    @GetMapping("/title/{title}")
    public List<TrophiesDTO> selectWhereTitleTrophiesDTO(@PathVariable String title){
        return playerMngmnt.getTrophieByTitle(title);
    }

    @GetMapping("/description/{description}")
    public List<TrophiesDTO> selectWhereDescriptionTrophiesDTO(@PathVariable String description){
        return playerMngmnt.getTrophieByDescription(description);
    }

    @PostMapping("/insert")
    public void insertTrophie(@RequestBody CrearTrophiesDTO trophie){
        playerMngmnt.insertTrophie(trophie);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTrophie(@PathVariable int id){
        playerMngmnt.deleteTrophie(id);
    }
    
}
