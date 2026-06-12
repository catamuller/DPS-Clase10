package edu.itba.class10.api.controller;

import edu.itba.class10.IntegrationTest;

import edu.itba.class10.boot.Application;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {Application.class})
@AutoConfigureMockMvc
@ActiveProfiles("sql")
class ExchangeControllerIT extends IntegrationTest {

	@Autowired
	private MockMvc mockMvc;


	@Test
	void convertsEurToUsdThroughTheHttpEndpoint() throws Exception {
		this.mockMvc.perform(post("/v1/exchange/conversion").contentType(MediaType.APPLICATION_JSON).content("""
						{
						  "from": "EUR",
						  "to": "USD",
						  "amount": 100
						}
						"""))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.currency").value("USD"))
				.andExpect(jsonPath("$.amount").value(10200));

		this.mockMvc.perform(get("/v1/exchange/conversion")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].from.currency").value("EUR"))
				.andExpect(jsonPath("$[0].from.amount").value(100))
				.andExpect(jsonPath("$[0].to.amount").value(10200))
				.andExpect(jsonPath("$[0].to.currency").value("USD"));
	}
}
