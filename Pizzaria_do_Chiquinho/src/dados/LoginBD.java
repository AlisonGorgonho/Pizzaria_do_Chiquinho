package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import principal.Funcionario;

public class LoginBD {
	
	private PreparedStatement testelogin = null;
	private ResultSet rs = null;
	private Connection con = null;
	private Funcionario check = null;
	
	public LoginBD() throws ClassNotFoundException, SQLException{
		con = ConexaoBD.getConnection();
		
			String sql = "SELECT * FROM funcionarios WHERE login =? AND senha =?" ;
			testelogin = con.prepareStatement(sql);
			
		
	}
	public Funcionario checkLogin( String login, String senha) throws SQLException{

		
			
			testelogin.setString(1, login);
			testelogin.setString(2, senha);
			rs = testelogin.executeQuery();
			
			if(rs  != null){
				check = new Funcionario();
				rs.next();
				check.setCodigo(rs.getInt("cod"));
				check.setTipo(rs.getString("tipo"));
					
			}
			
	
		return check;
	}
	

}
