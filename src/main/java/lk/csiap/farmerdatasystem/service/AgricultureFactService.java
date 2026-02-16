package lk.csiap.farmerdatasystem.service;

import lk.csiap.farmerdatasystem.dto.AgricultureFactRequestDTO;
import lk.csiap.farmerdatasystem.dto.AgricultureFactResponseDTO;
import lk.csiap.farmerdatasystem.entity.AgricultureFact;
import lk.csiap.farmerdatasystem.repository.AgricultureFactRepository;
import org.springframework.beans.BeanUtils; // Simple utility for copying properties
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgricultureFactService {

    @Autowired
    private AgricultureFactRepository repository;

    // Helper method to convert Entity to Response DTO
    private AgricultureFactResponseDTO convertToDto(AgricultureFact entity) {
        AgricultureFactResponseDTO dto = new AgricultureFactResponseDTO();
        BeanUtils.copyProperties(entity, dto);

        // Due to the name mismatch in the entity (program_name vs seasonMonth),
        // we might need manual mapping for certain fields if BeanUtils can't handle it.
        // Assuming BeanUtils can handle the simple mapping here.

        return dto;
    }

    // Helper method to convert Request DTO to Entity
    private AgricultureFact convertToEntity(AgricultureFactRequestDTO dto) {
        AgricultureFact entity = new AgricultureFact();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    // --- CRUD Operations ---

    // CREATE
    public AgricultureFactResponseDTO create(AgricultureFactRequestDTO requestDTO) {
        AgricultureFact entity = convertToEntity(requestDTO);
        AgricultureFact savedEntity = repository.save(entity);
        return convertToDto(savedEntity);
    }

    // READ All
    public List<AgricultureFactResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // READ by ID
    public AgricultureFactResponseDTO findById(Long id) {
        AgricultureFact entity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Agriculture Fact not found with ID: " + id));
        return convertToDto(entity);
    }

    // UPDATE
    public AgricultureFactResponseDTO update(Long id, AgricultureFactRequestDTO requestDTO) {
        AgricultureFact existingEntity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Agriculture Fact not found with ID: " + id));

        // Copy properties from DTO to existing entity, ignoring the ID
        BeanUtils.copyProperties(requestDTO, existingEntity, "recordId");

        AgricultureFact updatedEntity = repository.save(existingEntity);
        return convertToDto(updatedEntity);
    }

    // DELETE
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Agriculture Fact not found with ID: " + id);
        }
        repository.deleteById(id);
    }
}