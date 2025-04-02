package com.example.security.dto.process;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateProcessDto {
    private String nomeRpa;
    private String dataHoraAgendada;
    private String idioma;
}
