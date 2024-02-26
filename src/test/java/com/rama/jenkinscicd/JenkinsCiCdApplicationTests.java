package com.rama.jenkinscicd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
class JenkinsCiCdApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	public void testWelcome() throws Exception{

		String name="Ramalakshmi Vanam";
		mockMvc.perform(MockMvcRequestBuilders.get("/welcome/{name}",name))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("Hello"+name.split(" ")[0]+"Congratulation"));
	}


}
