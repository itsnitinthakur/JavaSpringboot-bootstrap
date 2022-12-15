package ca.lambtoncollage.FinalProject;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.eq;

@WebMvcTest(ClientController.class)
public class ClientControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ClientCache clientCache;
	
	@MockBean
	private ClientRepository clientRepo;
	
	@Test
	public void createclientTest() throws Exception {
		mockMvc.perform(get("/createclient"))
		//.andDo(print());
		.andExpect(status().isOk())
		.andExpect(view().name("clientform"))
		.andExpect(model().attribute("client", new Client()));
	}
	
	@Test
	public void createPostTest() throws Exception {
	    Client expectedUser = new Client(null, "nitin@lambton.com", "Nitin brag", 225);
		mockMvc.perform(post("/createuser").param("name", "Nitin brag").param("email", "nitin@lambton.com").param("age", "225"))
		.andExpect(status().isOk())
		.andExpect(view().name("saved"))
		.andExpect(model().attribute("client", expectedClient));
		
		Mockito.verify(clientRepo).save(eq(expectedClient));
	}
	
	@Test
	public void createPostTest_InvalidUser() throws Exception {
		Client expectedUser = new Client(null, "joe", "joe boe", 225);
		
		mockMvc.perform(post("/createclient").param("name", "Nitin brag").param("email", "Nitin brag").param("age", "225"))
		.andExpect(status().isOk())
		.andExpect(view().name("clientform"))
		.andExpect(model().attribute("client", expectedUser));
		
		Mockito.verifyNoInteractions(clientRepo);
	}
	
	@Test
	public void listUserTest() throws Exception {
		List<Client> expectedList = new ArrayList<>();
		expectedList.add(new Client(null, "nitin@lambton.com", "Nitin brag", 225));
		
		Mockito.when(clientRepo.findAll()).thenReturn(expectedList);
		
		mockMvc.perform(get("/allclients"))
		.andExpect(status().isOk())
		.andExpect(view().name("listclients"))
		.andExpect(model().attribute("clients", expectedList));
	}
}
