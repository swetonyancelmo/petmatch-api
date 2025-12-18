// package com.swetonyancelmo.petmatch.model;

// import jakarta.persistence.*;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// import java.time.LocalDate;

// @Entity
// @Table(name = "adocoes")
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// public class Adocao {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false)
//     private Animal animal;

//     @Column(nullable = false)
//     private Adotante adotante;

//     private LocalDate dataAdocao;

//     @PrePersist
//     private void prePersist(){
//         if(this.dataAdocao == null){
//             this.dataAdocao = LocalDate.now();
//         }
//     }
// }
