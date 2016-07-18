package com.flashcard.web.services.impl;

import com.flashcard.web.entities.Card;
import com.flashcard.web.repositories.CardRepository;
import com.flashcard.web.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public Iterable<Card> findAll() {
        return cardRepository.findAll();
    }

    @Override
    public boolean exists(Long id) {
        return cardRepository.exists(id);
    }

    @Override
    public Card find(Long id) {
        return cardRepository.findOne(id);
    }

    @Override
    public Card save(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public void delete(Long id) {
        cardRepository.delete(id);
    }
}
