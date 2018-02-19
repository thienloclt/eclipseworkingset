package ecommerce.dao;

import ecommerce.model.Client;
import ecommerce.model.ClientId;

public interface ClientDao extends Dao<Client, ClientId>{
	Client findWithAdresses(ClientId id);
}
