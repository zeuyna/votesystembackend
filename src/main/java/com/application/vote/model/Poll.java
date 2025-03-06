package com.application.vote.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    
    @ElementCollection
    private List<OptionVote> options = new ArrayList<>(); // Liste d'objets OptionVote

    @ElementCollection
    private List<String> votes = new ArrayList<>(); // Liste de chaînes de caractères


}
