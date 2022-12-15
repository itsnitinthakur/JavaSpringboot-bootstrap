package ca.lambtoncollage.FinalProject;

import java.util.ArrayList;
import java.util.List;

public class ClientCache {

	private List<Client> storedClients;
	
	public ClientCache() {
		storedClients = new ArrayList<>();
	}
	
	public void storeClient(Client client) {
		this.storedClients.add(client);
	}
	
	public List<Client> getAllClients() {
		return this.storedClients;
	}
}
