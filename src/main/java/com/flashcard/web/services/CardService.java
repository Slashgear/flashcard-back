package com.flashcard.web.services;

import com.flashcard.web.entities.Card;

public interface CardService {
    Card find(Long id);

    Card save(Card card);

    void delete(Long id);

    Iterable<Card> findAll();

    boolean exists(Long id);
}
