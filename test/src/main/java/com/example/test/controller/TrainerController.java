package com.example.test.controller;

import com.example.test.dto.request.TrainerRequestDto;
import com.example.test.dto.response.TrainerResponseDto;
import com.example.test.service.TrainerService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/trainers")
public class TrainerController implements CrudController<TrainerRequestDto, TrainerResponseDto> {

    private final TrainerService clientService;
    private final Logger logger = LoggerFactory.getLogger(TrainerController.class);

    public TrainerController(TrainerService clientService) {
        this.clientService = clientService;
    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<TrainerResponseDto> create(@RequestBody TrainerRequestDto REQUEST) {
        logger.info("Entering in create method..");
        TrainerResponseDto RESPONSE = clientService.create(REQUEST);
        logger.info("Exiting create method..");
        return new ResponseEntity<>(RESPONSE, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<TrainerResponseDto> update(@PathVariable Long id, @RequestBody TrainerRequestDto REQUEST) {
        logger.info("Entering in update method..");
        TrainerResponseDto RESPONSE = clientService.update(id, REQUEST);
        logger.info("Exiting update method..");
        return new ResponseEntity<>(RESPONSE, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        logger.info("Entering in delete method..");
        clientService.delete(id);
        logger.info("Exiting delete method");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    @GetMapping("/find/{id}")
    public ResponseEntity<TrainerResponseDto> findById(@PathVariable Long id) {
        logger.info("Entering in findById methodd..");
        TrainerResponseDto RESPONSE = clientService.findById(id);
        return new ResponseEntity<>(RESPONSE, HttpStatus.FOUND);
    }

    @Override
    @GetMapping("/findAll")
    public ResponseEntity<List<TrainerResponseDto>> findAll() {
        logger.info("Entering in findAll method..");
        List<TrainerResponseDto> RESPONSES = clientService.findAll();
        logger.info("Exiting findAll method..");
        return new ResponseEntity<>(RESPONSES, HttpStatus.FOUND);
    }
}
