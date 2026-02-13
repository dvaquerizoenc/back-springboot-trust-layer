package com.trustlayer.app.model.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String question;
    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;
}
