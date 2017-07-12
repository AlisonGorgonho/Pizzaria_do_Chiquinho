package negocio;

import java.util.List;

import dados.ProdutoBD;
import principal.Produto;


public class CadastroProduto{
	
	private ProdutoBD prodBD;
	private String invalido = "Produto Inv�lido";
	private String n�oexiste = "Produto n�o existe";	
	
	public CadastroProduto(){
		 prodBD = new ProdutoBD();
		
	}
	
	public void inserirProduto(Produto prod){
		
		if(prod != null){
			if(!(prodBD.existeBD(prod.getNome()))){
				if(prodBD.inserirProdBD(prod)){
					System.out.println("Produto cadastrado com sucesso");
				}else{
					System.out.println("N�o foi poss�vel cadastrar o Produto");
				}
			}else{
				System.out.println("Produto j� existe");
			}
		}else{
			System.out.println(invalido);
		}
	}
	
	public Produto buscarProduto(String nome){
		Produto aux = null;
		if(nome !=null){
			if(prodBD.existeBD(nome)){
				prodBD.buscarProdBD(nome);
			}else{
				System.out.println(n�oexiste);
			}
		}else{
			System.out.println(invalido);
		}
		return aux;
	}
	
	public void removerProduto(String nome){
		if(nome!=null){
			if(prodBD.existeBD(nome)){
				if(this.prodBD.removerProdBD(nome)){
					System.out.println("Produto excluido com sucesso");
				}else{
					System.out.println("N�o foi poss�vel deletar Produto");
				}
			}else{
				System.out.println(n�oexiste);
			}
		}else{
			System.out.println(invalido);
		}
		
	}
	
	public void atualizarProduto(Produto produto){
		
		if(produto!= null){
			if(prodBD.existeBD(produto.getNome())){
				if(prodBD.atualizarPedidoBD(produto)){
					System.out.println("Produto atualizado com sucesso");
				}else{
					System.out.println("N�o foi poss�vel atualizar o produto");
				}
			}else{
				System.out.println(n�oexiste);
			}
			
		}else{
			System.out.println(invalido);
		}
		
	}
	
	public List<Produto> listarProdutos(){
		return this.prodBD.listarProdBD();
	}
}

