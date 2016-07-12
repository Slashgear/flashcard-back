package com.flashcard.web.controllers;

import com.flashcard.web.entities.Card;
import com.flashcard.web.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/card")
public class CardController {
    @Autowired
    private CardService cardService;

    @RequestMapping(method = RequestMethod.GET)
    Iterable<Card> listAll() {
        return cardService.listAll();
    }
}
