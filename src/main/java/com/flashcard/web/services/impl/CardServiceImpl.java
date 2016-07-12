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
    public Iterable<Card> listAll() {
        return cardRepository.findAll();
    }
}
