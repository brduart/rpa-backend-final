package com.example.security.dto.process;

import com.example.security.entities.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProcessEditDto {
    private Status status;
    private String dataHoraInicio;
    private String dataHoraFinalizacao;
}
