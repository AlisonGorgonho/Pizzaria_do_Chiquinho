package dados.exception;

public class AtualizarClienteErro extends Exception{
	
	private static final long serialVersionUID = 1L;

	public AtualizarClienteErro(){
		
		super("Cliente n�o pode ser atualizado!");
		
	}
}
