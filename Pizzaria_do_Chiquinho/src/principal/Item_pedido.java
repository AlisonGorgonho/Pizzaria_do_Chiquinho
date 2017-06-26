package principal;

import java.util.ArrayList;
import java.util.List;

/**Classe para objetos do tipo Produtos, onde ser�o contidos, valores e m�todos para o mesmo.
 * @author 
 * @version 1.0
 * @since Release 0
 */

public class Item_pedido{
	
	private List <Produto> itensPedido;
	
	public Item_pedido(){
		itensPedido =  new ArrayList<Produto>();
	}
	
	public Produto buscaProduto(String nomedoproduto) {
		Produto prod = null;
		for(int i =0;i< itensPedido.size();i++){
			if((itensPedido.get(i).getNome()).equals(nomedoproduto)){
				prod = itensPedido.get(i);
			}
		}
		return prod;
	}
	
	public void addProduto(Produto prod) {
		itensPedido.add(prod);
	}
	
	public void removerProduto(String nomedoproduto){
		
		for(int i =0;i< itensPedido.size();i++){
			if((itensPedido.get(i).getNome()).equals(nomedoproduto)){
				 itensPedido.remove(i);
			}
		}
	}
}
