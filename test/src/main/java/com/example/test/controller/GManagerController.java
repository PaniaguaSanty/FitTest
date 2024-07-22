package com.example.test.controller;

import com.example.test.dto.request.GymManagerRequestDto;
import com.example.test.dto.response.GymManagerResponseDto;
import com.example.test.service.GymManagerService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/managers")
public class GManagerController implements CrudController<GymManagerRequestDto, GymManagerResponseDto> {

    private final GymManagerService gymManagerService;
    private final Logger logger = LoggerFactory.getLogger(GManagerController.class);


    public GManagerController(GymManagerService gymManagerService) {
        this.gymManagerService = gymManagerService;
    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<GymManagerResponseDto> create(@RequestBody GymManagerRequestDto REQUEST) {
        logger.info("Entering in create method..");
        GymManagerResponseDto RESPONSE = gymManagerService.create(REQUEST);
        logger.info("Exiting create method..");
        return new ResponseEntity<>(RESPONSE, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseEntity<GymManagerResponseDto> update(@PathVariable Long id, @RequestBody GymManagerRequestDto REQUEST) {
        logger.info("Entering in update method..");
        GymManagerResponseDto RESPONSE = gymManagerService.update(id, REQUEST);
        logger.info("Exiting update method..");
        return new ResponseEntity<>(RESPONSE, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        logger.info("Entering in delete method..");
        gymManagerService.delete(id);
        logger.info("Exiting delete method");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    @GetMapping("/find/{id}")
    public ResponseEntity<GymManagerResponseDto> findById(@PathVariable Long id) {
        logger.info("Entering in findById methodd..");
        GymManagerResponseDto RESPONSE = gymManagerService.findById(id);
        return new ResponseEntity<>(RESPONSE, HttpStatus.FOUND);

    }

    @Override
    @GetMapping("/findAll")
    public ResponseEntity<List<GymManagerResponseDto>> findAll() {
        logger.info("Entering in findAll method..");
        List<GymManagerResponseDto> RESPONSES = gymManagerService.findAll();
        logger.info("Exiting findAll method..");
        return new ResponseEntity<>(RESPONSES, HttpStatus.FOUND);
    }
}
