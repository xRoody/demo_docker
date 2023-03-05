package com.example.demo.controllers;

import com.example.demo.DTO.HumanDTO;
import com.example.demo.DTO.HumanWithFriendDTO;
import com.example.demo.services.HumanService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/humans")
@Controller
public class HumanController {
    private HumanService humanService;

    public HumanController(HumanService humanService) {
        this.humanService = humanService;
    }

    @GetMapping
    public ResponseEntity<List<HumanDTO>> getAll(){
        return ResponseEntity.ok(humanService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HumanWithFriendDTO> getById(@PathVariable(name = "id") UUID id){
        HumanWithFriendDTO dto=humanService.getById(id);
        if(dto==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    private ResponseEntity<HumanDTO> save(@RequestBody HumanDTO humanDTO){
        try {
            HumanDTO humanDTO1 = humanService.save(humanDTO);
            return ResponseEntity.ok(humanDTO1);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> delete(@PathVariable("id") UUID id){
        humanService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
