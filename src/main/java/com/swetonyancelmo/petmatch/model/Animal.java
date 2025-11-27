package com.swetonyancelmo.petmatch.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "animais")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sexo;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private Boolean adotado = false;

    @ManyToOne
    @JoinColumn(name = "adotante_id")
    private Adotante adotante;
}
