package com.example.security.services;

import com.example.security.dto.process.CreateProcessDto;
import com.example.security.dto.process.ProcessAddMessageDto;
import com.example.security.dto.process.ProcessEditDto;
import com.example.security.dto.process.ProcessResponseDto;
import com.example.security.dto.user.UserDto;
import com.example.security.entities.Process;
import com.example.security.entities.Status;
import com.example.security.entities.User;
import com.example.security.repositories.ProcessRepository;
import com.example.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProcessService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProcessRepository processRepository;

    public ProcessResponseDto createProcess(CreateProcessDto dto, Authentication authentication) {

        User actualUser = (User) userRepository.findByName(authentication.getName());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dataAgendada = LocalDate.parse(dto.getDataHoraAgendada(), formatter);
        System.out.println("Data formatada: " + dataAgendada);


        Process process = new Process();
        process.setNomeRpa(dto.getNomeRpa());
        process.setStatus(Status.PENDENTE);
        process.setDataHoraAgendada(dataAgendada);
        process.setDataHoraInicio(null);
        process.setDataHoraFinalizacao(null);
        process.setMsgErro("");
        process.setIdioma(dto.getIdioma());
        process.setUser(actualUser);

        processRepository.save(process);

       ProcessResponseDto responseDto = new ProcessResponseDto();
       responseDto.setId(process.getId());
       responseDto.setNome_rpa(process.getNomeRpa());
       responseDto.setStatus(process.getStatus());
       responseDto.setData_hora_agendada(dto.getDataHoraAgendada());
       responseDto.setData_hora_inicio(null);
       responseDto.setData_hora_finalizacao(null);
       responseDto.setMsg_erro("");
       responseDto.setIdioma(dto.getIdioma());
       responseDto.setUser(new UserDto(actualUser.getId(), actualUser.getName(), actualUser.getRole()));

       return responseDto;
    }

    public List<ProcessResponseDto> getAllProcess() {
        List<Process> process = processRepository.findAll();
        List<ProcessResponseDto> rpaList = new ArrayList<>();

        for(Process i: process) {
            ProcessResponseDto responseDto =  new ProcessResponseDto();
            responseDto.setId(i.getId());
            responseDto.setNome_rpa(i.getNomeRpa());
            responseDto.setStatus(i.getStatus());
            responseDto.setData_hora_agendada(String.valueOf(i.getDataHoraAgendada()));
            responseDto.setData_hora_inicio(String.valueOf(i.getDataHoraInicio()));
            responseDto.setData_hora_finalizacao(String.valueOf(i.getDataHoraFinalizacao()));
            responseDto.setMsg_erro(i.getMsgErro());
            responseDto.setIdioma(i.getIdioma());
            responseDto.setUser(new UserDto(i.getUser().getId(), i.getUser().getName(), i.getUser().getRole()));
            rpaList.add(responseDto);
        }

        return rpaList;
    }

    public ProcessResponseDto getProcessById(String id) {
        Optional<Process> process = processRepository.findById(Long.valueOf(id));
        Process newProcess = process.orElse(new Process());

        System.out.println(newProcess);

        ProcessResponseDto processResponseDto = new ProcessResponseDto();
        processResponseDto.setId(newProcess.getId());
        processResponseDto.setNome_rpa(newProcess.getNomeRpa());
        processResponseDto.setStatus(newProcess.getStatus());
        processResponseDto.setData_hora_inicio(String.valueOf(newProcess.getDataHoraInicio()));
        processResponseDto.setData_hora_agendada(String.valueOf(newProcess.getDataHoraAgendada()));
        processResponseDto.setData_hora_finalizacao(String.valueOf(newProcess.getDataHoraFinalizacao()));
        processResponseDto.setMsg_erro(newProcess.getMsgErro());
        processResponseDto.setIdioma(newProcess.getIdioma());
        processResponseDto.setUser(new UserDto(newProcess.getUser().getId(), newProcess.getUser().getName(), newProcess.getUser().getRole()));

        return processResponseDto;
    }

    public String addMessage(String id, ProcessAddMessageDto dto) {
        Optional<Process> process = processRepository.findById(Long.valueOf(id));
        Process process1 = process.orElse(new Process());

        process1.setMsgErro(dto.getProcessMessage());

        processRepository.save(process1);

        return "Mensagem adicionada com sucesso!";
    }

    public String editProcessData(String id, ProcessEditDto dto) {
        Optional<Process> process = processRepository.findById(Long.valueOf(id));
        Process process1 = process.orElse(new Process());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dataInicio = LocalDate.parse(dto.getDataHoraInicio(), formatter);
        LocalDate dataFinal = LocalDate.parse(dto.getDataHoraFinalizacao(), formatter);
        System.out.println("Data formatada: " + dataInicio);

        process1.setStatus(dto.getStatus());
        process1.setDataHoraInicio(dataInicio);
        process1.setDataHoraFinalizacao(dataFinal);

        processRepository.save(process1);

        return "Processo atualizado com sucesso!";
    }
}

