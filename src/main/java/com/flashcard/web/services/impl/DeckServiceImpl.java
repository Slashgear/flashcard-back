package com.flashcard.web.services.impl;

import com.flashcard.web.entities.Deck;
import com.flashcard.web.repositories.DeckRepository;
import com.flashcard.web.services.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeckServiceImpl implements DeckService {

    @Autowired
    private DeckRepository deckRepository;


    @Override
    public Deck find(Long id) {
        return deckRepository.findOne(id);
    }

    @Override
    public Deck save(Deck deck) {
        return deckRepository.save(deck);
    }

    @Override
    public void delete(Long id) {
        deckRepository.delete(id);
    }

    @Override
    public Iterable<Deck> findAll() {
        return deckRepository.findAll();
    }

    @Override
    public boolean exists(Long id) {
        return deckRepository.exists(id);
    }

}
