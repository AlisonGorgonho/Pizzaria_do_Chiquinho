package negocio;

import java.sql.SQLException;
import java.util.List;
import dados.ClienteBD;
import principal.Cliente;


public class CadastroCliente {

	private ClienteBD clienteBD;
	private String invalido = "Cliente Inv�lido";
	private String n�oexiste = "Cliente n�o existe";
	
	public CadastroCliente() throws ClassNotFoundException, SQLException{
		clienteBD= new ClienteBD();
}
	
	public void inserirCliente(){}
	
	public void removerCliente(){}
	
	public Cliente buscarCliente(){
		return null;
	}
	
}
