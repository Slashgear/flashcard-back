package com.flashcard.web.controllers;

import com.flashcard.web.entities.Card;
import com.flashcard.web.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Card>> findAll() {
        return new ResponseEntity<>(cardService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Card> findById(@PathVariable("id") Long id) {
        Card card = cardService.find(id);
        ResponseEntity<Card> responseEntity;
        if (card != null) {
            responseEntity = new ResponseEntity<>(card, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<Card>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/deck/{deckId}", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Card>> findByDeck(@PathVariable("deckId") Long deckId) {
        return new ResponseEntity<>(cardService.findAllByDeckId(deckId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Card> create(@RequestBody Card card) {
        ResponseEntity<Card> responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if (card.getId() == null) {
            Card savedDeck = cardService.save(card);
            responseEntity = new ResponseEntity<>(savedDeck, HttpStatus.OK);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Card> save(@PathVariable("id") Long id, @RequestBody Card card) {
        ResponseEntity<Card> responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if (Objects.equals(id, card.getId())) {
            Card savedDeck = cardService.save(card);
            responseEntity = new ResponseEntity<>(savedDeck, HttpStatus.OK);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") Long id) {
        ResponseEntity<Card> responseEntity = new ResponseEntity<Card>(HttpStatus.NOT_FOUND);
        if (cardService.exists(id)) {
            cardService.delete(id);
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        }
        return responseEntity;
    }
}
