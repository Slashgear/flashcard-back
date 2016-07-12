package com.flashcard.web.services;

import com.flashcard.web.entities.Card;

public interface CardService {
    Iterable<Card> listAll();
}
