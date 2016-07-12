package com.flashcard.web.services;

import com.flashcard.web.entities.Deck;

public interface DeckService {

    Deck find(Long id);

    Deck save(Deck deck);

    void delete(Long id);

    Iterable<Deck> findAll();

    boolean exists(Long id);
}
