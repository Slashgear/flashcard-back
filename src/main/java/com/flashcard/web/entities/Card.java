package com.flashcard.web.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Card {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String question;

    @OneToMany
    private List<Answer> answer = new ArrayList<>();

}
