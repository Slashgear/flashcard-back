package com.flashcard.web.services;

import com.flashcard.web.entities.Card;

public interface CardService {
    Card find(Long id);

    Card save(Card card);

    void delete(Long id);

    Iterable<Card> findAll();

    Iterable<Card> findAllByDeckId(Long deckId);

    boolean exists(Long id);
}
