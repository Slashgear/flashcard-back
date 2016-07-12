package com.flashcard.web.repositories;

import com.flashcard.web.entities.Deck;
import org.springframework.data.repository.CrudRepository;

public interface DeckRepository extends CrudRepository<Deck, Long> {

}
