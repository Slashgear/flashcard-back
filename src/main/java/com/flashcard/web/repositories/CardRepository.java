package com.flashcard.web.repositories;

import com.flashcard.web.entities.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, Long> {

}
