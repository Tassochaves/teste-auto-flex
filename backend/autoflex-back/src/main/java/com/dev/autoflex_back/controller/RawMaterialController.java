package com.dev.autoflex_back.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dev.autoflex_back.dto.request.RawMaterialRequest;
import com.dev.autoflex_back.dto.response.MessageResponse;
import com.dev.autoflex_back.dto.response.RawMaterialResponse;
import com.dev.autoflex_back.service.RawMaterialService;

@RestController
@RequestMapping("/api/v1/materials")
public class RawMaterialController {

    private final RawMaterialService rawMaterialService;

    public RawMaterialController(RawMaterialService rawMaterialService){
        this.rawMaterialService = rawMaterialService;
    }

    @PostMapping
    public ResponseEntity<RawMaterialResponse> createMaterial(@RequestBody RawMaterialRequest request){

        RawMaterialResponse response = rawMaterialService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteMaterial(@PathVariable Long id){

        MessageResponse response = rawMaterialService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<List<RawMaterialResponse>> findAll(){
        
        List<RawMaterialResponse> materials = rawMaterialService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(materials);
    }
}
