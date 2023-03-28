package com.example.demo;

import com.example.demo.model.Demo1;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = JunitConfiguration.class)
@TestPropertySource(locations="classpath:test.properties")
@AutoConfigureMockMvc
//@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:data1.sql")
class SpringBoot2ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads2() throws Exception{
		mockMvc.perform(post("/api/tutorials").contentType(MediaType.APPLICATION_JSON).content("{\n" +
				"    \"id\": 2,\n" +
				"    \"title\": \"a\",\n" +
				"    \"description\": \"b\",\n" +
				"    \"published\": true\n" +
				"}")).andExpect(status().isCreated());

		String s =
				mockMvc.perform(get("/api/tutorials/1")).andExpect(status().isOk())
						.andDo(MockMvcResultHandlers.print())
						.andReturn().getResponse().getContentAsString();
		System.out.println(s);
	}

	@Test
	void contextLoads3() throws Exception{
		String s =
				mockMvc.perform(get("/api/tutorials/2")).andExpect(status().isOk())
						.andDo(MockMvcResultHandlers.print())
						.andReturn().getResponse().getContentAsString();
		System.out.println(s);

	}




	@Test
	void sdfd(){
		Demo1 demo1 = new Demo1("s", "s");
		Demo1 demo11 = new Demo1("s",  new Throwable());
	}
}
