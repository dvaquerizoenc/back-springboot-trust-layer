package com.trustlayer.app.model.entities;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String question;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String response;
}
