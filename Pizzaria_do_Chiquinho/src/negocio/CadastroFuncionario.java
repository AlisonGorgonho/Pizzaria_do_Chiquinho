package negocio;

import java.sql.SQLException;
import java.util.List;

import dados.FuncionarioBD;
import principal.Funcionario;

public class CadastroFuncionario {
	
	private FuncionarioBD funcBD;
	private String invalido = "Funcionario Inv�lido";
	private String naoexiste = "Funcionario n�o existe";
	
	
	
	public CadastroFuncionario() throws ClassNotFoundException, SQLException{
		funcBD = new FuncionarioBD();
	}
	
	public void inserirFunc(Funcionario func) throws SQLException{
		
		if(func != null){
			if(!(funcBD.existeBD(func.getLogin()))){
				if(funcBD.inserirFuncBD(func)){
					System.out.println("Funcionario cadastrado com sucesso");
				}else{
					System.out.println("N�o foi poss�vel cadastrar o funcionario");
				}
			}else{
				System.out.println("Funcionario j� existe");
			}
		}else{
			System.out.println(invalido);
		}
	}
	
	
	//Daqui pra baixo foi eu que fiz, qualquer erro vcs me avisem, blz?
	public Funcionario buscarFunc(String login) throws SQLException{
		Funcionario aux = null;
		if(login!=null){
			if(funcBD.existeBD(login)){
				aux = funcBD.buscarFuncBD(login); 
			}else{
				System.out.println(naoexiste);
			}
		}else{
			System.out.println(invalido);
		}
		return aux;
	}
	public void removerFunc(String login) throws SQLException{
		if(login!=null){
			if(funcBD.existeBD(login)){	
				if(this.funcBD.removerFuncBD(login)){
					System.out.println("Funcion�rio deletado com sucesso");
				}else{
					System.out.println("Erro ao deletar funcion�rio");
				}
			}else{
				System.out.println(naoexiste);
			}	
		}else{
			System.out.println(invalido);
		}		
	}
	public void atualizarFunc(Funcionario func) throws SQLException{
			
			if(func!=null){
				if(funcBD.existeBD(func.getLogin())){
					if(funcBD.atualizarFuncBD(func)){
						System.out.println("Funcion�rio atualizado com sucesso");
					}else{
						System.out.println("N�o foi poss�vel atualizar o funcion�rio");
					}
				}else{
					System.out.println(naoexiste);
				}
			}else{
				System.out.println(invalido);
			}
	}
	
	public List<Funcionario> listarFunc() throws SQLException{
		
		return funcBD.listarFuncBD();
	
	}
	

}
