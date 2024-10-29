package com.vedruna.n.m.services;
import java.util.ArrayList;
import java.util.List;

import com.vedruna.n.m.dto.TrophiesDTO;
import com.vedruna.n.m.dto.CrearPlayersDTO;
import com.vedruna.n.m.dto.CrearTrophiesDTO;
import com.vedruna.n.m.dto.PlayersDTO;
import com.vedruna.n.m.persistance.model.Players;
import com.vedruna.n.m.persistance.model.Trophies;
import com.vedruna.n.m.persistance.repository.TrophiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TrophiesServiceImpl implements TrophiesServiceI{
    
    @Autowired
    TrophiesRepository trophiesRepo;

    @Override
    public TrophiesDTO getTrophieById(int idTrophie){
        return new TrophiesDTO(trophiesRepo.findByIdTrophie(idTrophie));
    }

    @Override
    public List<TrophiesDTO> getTrophieByTitle(String title) {
        List<Trophies> trophiesList = trophiesRepo.findByTitle(title);
        List<TrophiesDTO> trophiesDTOList = new ArrayList<TrophiesDTO>();
        
            for (Trophies trophie : trophiesList){
                trophiesDTOList.add(new TrophiesDTO(trophie));
        }
        return trophiesDTOList;
    }
    
    @Override
    public List<TrophiesDTO> getTrophieByDescription(String description) {
        List<Trophies> trophiesList = trophiesRepo.findByDescription(description);
        List<TrophiesDTO> trophiesDTOList = new ArrayList<>();
        
        for (Trophies trophie : trophiesList){
            trophiesDTOList.add(new TrophiesDTO(trophie));
        }
        return trophiesDTOList;
    }

    @Override
    public List<TrophiesDTO> findAll(){
        List<Trophies> trophiesList = trophiesRepo.findAll();
        List<TrophiesDTO> trophiesDTOList = new ArrayList<>();

        for (Trophies trophies : trophiesList){
            trophiesDTOList.add(new TrophiesDTO(trophies));
        }

        return trophiesDTOList;
    }


    @Override
    public void insertTrophie(CrearTrophiesDTO trophies){
        Trophies newTrophie = new Trophies();
        newTrophie.setIdTrophie(trophies.getIdTrophie());
        newTrophie.setTitle(trophies.getTitle());
        newTrophie.setDescription(trophies.getDescription());
        trophiesRepo.save(newTrophie);
    }

    @Override
    public void deleteTrophie(int id) {
        trophiesRepo.deleteById(id);
    }
    
}

   