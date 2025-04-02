package com.example.security.controllers;

import com.example.security.dto.selenium.SeleniumResponseDto;
import com.example.security.entities.Process;
import com.example.security.entities.Status;
import com.example.security.repositories.ProcessRepository;
import com.example.security.services.SeleniumService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/selenium")
public class SeleniumController {

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    SeleniumService seleniumService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<SeleniumResponseDto> login(@PathVariable Long id) {
        Optional<Process> process = processRepository.findById(id);
        Process process1 = process.orElse(new Process());

        String processName = process1.getNomeRpa();

        if (processName.equals("RPALOGIN")) {
            return new ResponseEntity<>(seleniumService.performLogin(), HttpStatus.OK);
        } else if (processName.equals("RPABUTTON")) {
            return new ResponseEntity<>(seleniumService.performLogin(), HttpStatus.OK);
        } else if (processName.equals("RPAREGISTER")) {
            return new ResponseEntity<>(seleniumService.performLogin(), HttpStatus.OK);
        } else if (processName.equals("RPAINPUT")) {
            return new ResponseEntity<>(seleniumService.performLogin(), HttpStatus.OK);
        }
        return null;
    }
}
