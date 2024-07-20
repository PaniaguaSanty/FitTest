package com.example.test.controller;

import com.example.test.dto.request.ClientRequestDto;
import com.example.test.dto.response.ClientResponseDto;
import com.example.test.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/clients")
public class ClientController implements CrudController<ClientRequestDto, ClientResponseDto> {

    private final ClientService clientService;
    private final Logger logger = LoggerFactory.getLogger(ClientController.class);

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<ClientResponseDto> create(@RequestBody ClientRequestDto REQUEST) {
        logger.info("Entering in create method..");
        ClientResponseDto RESPONSE = clientService.create(REQUEST);
        logger.info("Exiting create method..");
        return new ResponseEntity<>(RESPONSE, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<ClientResponseDto> update(@PathVariable Long id, @RequestBody ClientRequestDto REQUEST) {
        logger.info("Entering in update method..");
        ClientResponseDto RESPONSE = clientService.update(id, REQUEST);
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
    public ResponseEntity<ClientResponseDto> findById(@PathVariable Long id) {
        logger.info("Entering in findById methodd..");
        ClientResponseDto RESPONSE = clientService.findById(id);
        return new ResponseEntity<>(RESPONSE, HttpStatus.FOUND);
    }

    @Override
    @GetMapping("/findAll")
    public ResponseEntity<List<ClientResponseDto>> findAll() {
        logger.info("Entering in findAll method..");
        List<ClientResponseDto> RESPONSES = clientService.findAll();
        logger.info("Exiting findAll method..");
        return new ResponseEntity<>(RESPONSES, HttpStatus.FOUND);
    }
}
