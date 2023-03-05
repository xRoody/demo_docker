package com.example.demo.services;

import com.example.demo.DTO.HumanDTO;
import com.example.demo.DTO.HumanWithFriendDTO;
import com.example.demo.entity.Human;
import com.example.demo.repository.HumanRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class HumanService {
    private HumanRepo humanRepo;

    public HumanService(HumanRepo humanRepo) {
        this.humanRepo = humanRepo;
    }

    public HumanWithFriendDTO getById(UUID uuid){
        Optional<Human> h1=humanRepo.findById(uuid);
        if (h1.isEmpty()) return null;
        Human human=h1.get();
        return new HumanWithFriendDTO(
                human.getId(),
                human.getName(),
                human.getLastName(),
                human.getFriends()
                        .stream()
                        .map(x->new HumanDTO(x.getId(), x.getName(), x.getLastName()))
                        .collect(Collectors.toSet())
        );
    }

    public HumanDTO save(HumanDTO humanDTO){
        Human human=new Human(humanDTO.getId(), humanDTO.getName(), humanDTO.getLastName(), new HashSet<>());
        Human human1=humanRepo.save(human);
        humanDTO.setId(human1.getId());
        return humanDTO;
    }

    public void deleteById(UUID uuid){
        humanRepo.deleteById(uuid);
    }

    public List<HumanDTO> getAll(){
        return humanRepo.findAll().stream().map(x->new HumanDTO(x.getId(), x.getName(), x.getLastName())).toList();
    }
}
