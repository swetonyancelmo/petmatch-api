package com.swetonyancelmo.petmatch.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "adotantes")
@NoArgsConstructor
@AllArgsConstructor
public class Adotante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @OneToMany(mappedBy = "adotante",  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Animal> animais = new ArrayList<>();
}
