package com.example.security.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tb_process")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Process {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeRpa;
    private Status status;
    private LocalDate dataHoraAgendada;
    private LocalDate dataHoraInicio;
    private LocalDate dataHoraFinalizacao;
    private String msgErro;
    private String idioma;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

}
