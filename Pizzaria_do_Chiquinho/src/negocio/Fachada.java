package negocio;

import java.sql.SQLException;
import java.util.List;

import principal.Pedido;
import principal.Produto;
import principal.Funcionario;

public class Fachada {
	private  static Fachada instance;
	private CadastroPedido pedido;
	private CadastroProduto produto;
	private CadastroFuncionario funcionario;
	
	public Fachada() throws ClassNotFoundException, SQLException{
		pedido = new CadastroPedido();
		produto = new CadastroProduto();
	}
	
	public static Fachada getInstance() throws ClassNotFoundException, SQLException{
		if(Fachada.instance == null){
			Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}
	
	public void inserir(Pedido pedido) throws ClassNotFoundException, SQLException{
		this.pedido.inserirPedido(pedido);
	}
	
	public void remover(Pedido pedido) throws ClassNotFoundException, SQLException{
		this.pedido.removerPedido(pedido.getCodigo());
	}
	public Pedido buscar(Pedido pedido) throws ClassNotFoundException, SQLException{
		return this.pedido.buscarPedido(pedido.getCodigo());
	}
	public void atualizar(Pedido pedido) throws ClassNotFoundException, SQLException{
		this.pedido.atualizarPedido(pedido);
	}
	public List<Pedido> listar() throws ClassNotFoundException, SQLException{
		return this.pedido.listarPedido();
	}
	
	public void inserir(Produto produto) throws SQLException{
		this.produto.inserirProduto(produto);
	}
	public void remover(Produto produto) throws SQLException{
		this.produto.removerProduto(produto.getNome());
	}
	public Produto buscar(Produto produto) throws SQLException{
		return this.produto.buscarProduto(produto.getNome());
	}
	public void atualizar(Produto produto) throws SQLException{
		this.produto.atualizarProduto(produto);
	}
	public List<Produto> listarProduto() throws SQLException{
		return this.produto.listarProdutos();
	}
	
	public void inserir(Funcionario funcionario) throws SQLException{
		this.funcionario.inserirFunc(funcionario);
	}
	public void remover(Funcionario funcionario) throws SQLException{
		this.funcionario.removerFunc(funcionario.getLogin());
	}
	public Funcionario buscar(Funcionario funcionario) throws SQLException{
		return this.funcionario.buscarFunc(funcionario.getLogin());
	}
	public void atualizar(Funcionario funcionario) throws SQLException{
		this.funcionario.atualizarFunc(funcionario);
	}
	public List<Funcionario> listarFuncionario() throws SQLException{
		return this.funcionario.listarFunc();
	}

}
