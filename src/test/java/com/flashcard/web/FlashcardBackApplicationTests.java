package com.flashcard.web;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FlashcardBackApplication.class)
@WebAppConfiguration
@ActiveProfiles("test")
@Component
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
public abstract class FlashcardBackApplicationTests {

    @Autowired
    protected WebApplicationContext webApplicationContext;

    protected MockMvc mvc;

    @SneakyThrows
    protected String getJsonResourceAsString(String jsonFilePath) {
        return FileUtils
                .readFileToString(new ClassPathResource(jsonFilePath).getFile(), StandardCharsets.UTF_8);
    }

    @Before
    public void setUpZenMLBackOfficeAppBaseTest() {
        this.mvc = webAppContextSetup(this.webApplicationContext).build();
    }

}
