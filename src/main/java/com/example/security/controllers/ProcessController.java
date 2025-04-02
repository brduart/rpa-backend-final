package com.example.security.controllers;

import com.example.security.dto.process.CreateProcessDto;

import com.example.security.dto.process.ProcessAddMessageDto;
import com.example.security.dto.process.ProcessEditDto;
import com.example.security.dto.process.ProcessResponseDto;
import com.example.security.entities.Process;
import com.example.security.services.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rpa")
public class ProcessController {

    @Autowired
    private ProcessService processService;

    @GetMapping
    public ResponseEntity<List<ProcessResponseDto>> getAllProcess() {

        return new ResponseEntity<>(processService.getAllProcess(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProcessResponseDto> getProcessById(@PathVariable String id) {

        return new ResponseEntity<>(processService.getProcessById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProcessResponseDto> createProcess(@RequestBody CreateProcessDto dto, Authentication authentication) {

        return new ResponseEntity<>(processService.createProcess(dto, authentication), HttpStatus.OK);
    }

    @PostMapping("/message/{id}")
    public ResponseEntity<String> addMessage(@PathVariable String id, @RequestBody ProcessAddMessageDto dto) {

        return new ResponseEntity<>(processService.addMessage(id, dto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editProcessData(@PathVariable String id, @RequestBody ProcessEditDto dto) {

        return new ResponseEntity<>(processService.editProcessData(id, dto), HttpStatus.OK);
    }
}
