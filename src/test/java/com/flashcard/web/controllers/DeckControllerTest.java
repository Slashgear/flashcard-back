package com.flashcard.web.controllers;

import com.flashcard.web.FlashcardBackApplicationTests;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DatabaseSetup("classpath:initDb/deck.xml")
@DatabaseTearDown(value = "classpath:initDb/deck.xml", type = DatabaseOperation.DELETE_ALL)
public class DeckControllerTest extends FlashcardBackApplicationTests {

    private static final String URL = "/api/deck";
    private static final String CARD_API = "/api/card";

    @Test
    public void findAll() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get(URL).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json(getJsonResourceAsString("json/output/deck/findAll.json")));
    }

    @Test
    public void findById() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get(URL + "/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json(getJsonResourceAsString("json/output/deck/findById.success.json")));

        mvc.perform(MockMvcRequestBuilders.get(URL + "/1000").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void create() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post(URL).accept(MediaType.APPLICATION_JSON)
                .content(getJsonResourceAsString("json/input/deck/create.success.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
        mvc.perform(MockMvcRequestBuilders.post(URL).accept(MediaType.APPLICATION_JSON)
                .content(getJsonResourceAsString("json/input/deck/create.badrequest.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void save() throws Exception {
        mvc.perform(MockMvcRequestBuilders.put(URL + "/1").accept(MediaType.APPLICATION_JSON)
                .content(getJsonResourceAsString("json/input/deck/update.success.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
        mvc.perform(MockMvcRequestBuilders.put(URL + "/2").accept(MediaType.APPLICATION_JSON)
                .content(getJsonResourceAsString("json/input/deck/update.badrequest.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void delete() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete(URL + "/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
        mvc.perform(MockMvcRequestBuilders.delete(CARD_API + "/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
        mvc.perform(MockMvcRequestBuilders.delete(URL + "/1000").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

}