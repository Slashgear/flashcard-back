package com.flashcard.web.controllers;

import com.flashcard.web.entities.Deck;
import com.flashcard.web.services.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/deck")
public class DeckController {

    @Autowired
    private DeckService deckService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Deck>> findAll() {
        Iterable<Deck> decks = deckService.findAll();
        return new ResponseEntity<>(decks, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Deck> findById(@PathVariable("id") Long id) {
        Deck deck = deckService.find(id);
        ResponseEntity<Deck> responseEntity;
        if (deck != null) {
            responseEntity = new ResponseEntity<>(deck, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<Deck>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Deck> create(@RequestBody Deck deck) {
        ResponseEntity<Deck> responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if (deck.getId() == null) {
            Deck savedDeck = deckService.save(deck);
            responseEntity = new ResponseEntity<>(savedDeck, HttpStatus.OK);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Deck> save(@PathVariable("id") Long id, @RequestBody Deck deck) {
        ResponseEntity<Deck> responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if (Objects.equals(id, deck.getId())) {
            Deck savedDeck = deckService.save(deck);
            responseEntity = new ResponseEntity<>(savedDeck, HttpStatus.OK);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") Long id) {
        ResponseEntity<Deck> responseEntity = new ResponseEntity<Deck>(HttpStatus.NOT_FOUND);
        if (deckService.exists(id)) {
            deckService.delete(id);
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        }
        return responseEntity;
    }
}
