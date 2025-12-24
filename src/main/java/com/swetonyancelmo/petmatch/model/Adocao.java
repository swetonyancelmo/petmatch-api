 package com.swetonyancelmo.petmatch.model;

 import jakarta.persistence.*;
 import lombok.AllArgsConstructor;
 import lombok.Data;
 import lombok.NoArgsConstructor;

 import java.time.LocalDate;

@Entity
@Table(name = "adocoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Adocao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Animal animal;

    @ManyToOne(optional = false)
    private Adotante adotante;

    private LocalDate dataAdocao;
}
