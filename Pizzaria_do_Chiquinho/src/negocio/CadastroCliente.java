package negocio;

import java.util.List;
import dados.ClientBD;
import principal.Cliente


public class CadastroCliente {

	private ClienteBD clienteBD;
	private String invalido = "Cliente Inv�lido";
	private String n�oexiste = "Cliente n�o existe";
	
	public CadastroCliente(){
		clienteBD= new ClienteBD();
	}
	
	public void inserirCliente(){}
	
	public void removerCliente(){}
	
	public Cliente buscarCliente(){}
	
}
