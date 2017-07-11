package negocio;

import dados.FuncionarioBD;
import principal.Funcionario;

public class CadastroFuncionario {
	
	private FuncionarioBD funcBD;
	private String invalido = "Funcionario Inv�lido";
	private String naoexiste = "Funcionario n�o existe";
	
	
	
	public CadastroFuncionario(){
		funcBD = new FuncionarioBD();
	}
	
	public void inserirFunc(Funcionario func){
		
		if(func != null){
			if(!(funcBD.existeBD(func.getLogin()))){
				if(funcBD.inserirFuncBD(func.getNome(), func.getEndereco(), func.getCpf(), func.getTelefone(), func.getTipo(), func.getLogin()
						, func.getSenha())){
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
	public Funcionario buscarFunc(String login){
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
	public void removerFunc(String login){
		if(login!=null){
			if(funcBD.existeBD(login)){	
				if(this.funcBD.removerFuncBD(login)){
					System.out.println("Funcion�rio deletado com sucesso");
				}else{
					System.out.println("Erro ao deletar funcion�rio");
				}
			}else{
				System.out.prinln(naoexiste);
			}	
		}else{
			System.out.println(invalido);
		}		
	}
	public void atualizarFunc(Funcionario func){
			
			if(func!=null){
				if(funcBD.existeBD(func.getLogin())){
					if(funcBD.atualizarFuncBD(func)){
						System.out.println("Funcion�rio atualizado com sucesso");
					}else{
						System.out.println("N�o foi poss�vel atualizar o funcion�rio");
					}
				}else{
					System.out.println(n�oexiste);
				}
			}else{
				System.out.println(invalido);
			}
	}
	
	public List<Funcionario> listarFunc(){
		
		return FuncBD.listarFuncBD();
	
	}
	

}
