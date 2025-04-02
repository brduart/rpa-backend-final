package com.example.security.dto.process;

import com.example.security.dto.user.UserDto;
import com.example.security.entities.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProcessResponseDto {
    private Long id;
    private String nome_rpa;
    private Status status;
    private String data_hora_agendada;
    private String data_hora_inicio;
    private String data_hora_finalizacao;
    private String msg_erro;
    private String idioma;
    private UserDto user;
}
