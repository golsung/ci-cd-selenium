package unitTests;

import cloud.ez2learn.seleniumproj.Calculator;
import cloud.ez2learn.seleniumproj.CalculatorController;
import cloud.ez2learn.seleniumproj.IndexController;
import cloud.ez2learn.seleniumproj.SeleniumProjApplication;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ContextConfiguration(classes = {CalculatorController.class, IndexController.class})
@WebMvcTest
public class CalculatorControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    Calculator calculator;

    @Test
    @DisplayName("간단한 덧셈 요청 처리 테스트")
    void getSumRequest() throws Exception {
        when(calculator.getSum()).thenReturn(8);
        mvc.perform(get("http://localhost:8080/api/sum?a=15&b=31"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("46"));

    }

}
