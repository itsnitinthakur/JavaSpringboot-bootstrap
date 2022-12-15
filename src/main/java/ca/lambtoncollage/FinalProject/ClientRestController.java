package ca.lambtoncollage.FinalProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientRestController {
	
	@Autowired
	private ClientCache clientCache;
	
	@Autowired
	private ClientRepository clientRepo;
	
	@GetMapping("/clientcount")
	public Long listAllClients() {
		return clientRepo.count();
	}
	
	@GetMapping("/findbyname")
	public Client findByName(@RequestParam String name) {
		return this.clientRepo.findByName(name);
	}
}
