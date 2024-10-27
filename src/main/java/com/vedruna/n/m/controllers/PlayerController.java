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

import com.vedruna.n.m.dto.CrearPlayersDTO;
import com.vedruna.n.m.dto.PlayersDTO;
import com.vedruna.n.m.services.PlayersServiceI;

@RestController
@RequestMapping("/api/v1/player")
@CrossOrigin
public class PlayerController {

    @Autowired
    PlayersServiceI playerMngmnt;
    @GetMapping
    public List<PlayersDTO> findAll(){
        return playerMngmnt.findAll();
    }

    @GetMapping("/id/{idplayer}")
    public PlayersDTO selectWhereIdPlayersDTO(@PathVariable int idplayer){
        return playerMngmnt.getPlayerById(idplayer);
    }

    @GetMapping("/username/{username}")
    public List<PlayersDTO> selectWhereUsernamePlayersDTO(@PathVariable String username){
        return playerMngmnt.getPlayerByUsername(username);
    }

    @PostMapping("/insert")
    public void insertPlayer(@RequestBody CrearPlayersDTO player){
        playerMngmnt.insertPlayer(player);
    }
    

    @DeleteMapping("/delete/{idPlayer}")
    public void deletePlayer(@PathVariable int idPlayer) {
        playerMngmnt.deletePlayer(idPlayer);
    }

}
