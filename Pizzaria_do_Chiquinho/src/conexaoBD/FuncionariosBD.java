package conexaoBD;

/**Classe para a conex�o do classe funcion�rios com o banco de dados, onde ser�o contidos, valores e m�todos para o mesmo.
 * @author 
 * @version 1.0
 * @since Release 0
 */

import java.sql.*;
import java.util.logging.*;

public class FuncionariosBD {

	public boolean checkLogin( String login, String senha){
		boolean check = false;
		PreparedStatement stmp = null;
		ResultSet rs = null;
		Connection con = null;
		
		con = ConexaoBD.getConnection();
		
		
		try {
			stmp = con.prepareStatement("SELECT * FROM funcionarios WHERE login = ? AND senha = ? ");
			stmp.setString(1, login);
			stmp.setString(2, senha);
			
			
			rs = stmp.executeQuery();
			
			if(rs.next()){
				check = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			ConexaoBD.closeConnection(con, stmp, rs);
		}
		return check;
	}
	
}
