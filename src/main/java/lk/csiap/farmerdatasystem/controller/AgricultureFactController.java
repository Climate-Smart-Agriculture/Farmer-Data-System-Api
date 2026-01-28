package lk.csiap.farmerdatasystem.controller;

import lk.csiap.farmerdatasystem.dto.AgricultureFactRequestDTO;
import lk.csiap.farmerdatasystem.dto.AgricultureFactResponseDTO;
import lk.csiap.farmerdatasystem.service.AgricultureFactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agriculturefacts")
public class AgricultureFactController {

    @Autowired
    private AgricultureFactService service;

    @PostMapping
    public ResponseEntity<AgricultureFactResponseDTO> createFact(
            @Valid @RequestBody AgricultureFactRequestDTO requestDTO) {

        AgricultureFactResponseDTO createdFact = service.create(requestDTO);
        return new ResponseEntity<>(createdFact, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AgricultureFactResponseDTO>> getAllFacts() {
        List<AgricultureFactResponseDTO> facts = service.findAll();
        return ResponseEntity.ok(facts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgricultureFactResponseDTO> getFactById(@PathVariable Long id) {
        AgricultureFactResponseDTO fact = service.findById(id);
        return ResponseEntity.ok(fact);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgricultureFactResponseDTO> updateFact(
            @PathVariable Long id,
            @Valid @RequestBody AgricultureFactRequestDTO requestDTO) {

        AgricultureFactResponseDTO updatedFact = service.update(id, requestDTO);
        return ResponseEntity.ok(updatedFact);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFact(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}