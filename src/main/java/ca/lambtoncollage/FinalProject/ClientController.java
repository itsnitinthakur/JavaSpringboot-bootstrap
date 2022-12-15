package ca.lambtoncollage.FinalProject;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientController {
	
	@Autowired
	private ClientCache clientCache;
	
	@Autowired
	private ClientRepository clientRepo;

	@GetMapping("/createclient")
	public String clientForm(Model model) {
		model.addAttribute("client", new Client());
		return "clientform";
	}
	
	@PostMapping("/createclient")
	public String createClient(@Valid Client toSave, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "clientform";
		} else {
			this.clientRepo.save(toSave);
			return "saved";
		}
	}
	
	
	@GetMapping("/allclients")
	public String listAllClients(Model model) {
		model.addAttribute("clients", this.clientRepo.findAll());
		return "listclients";
	}
}