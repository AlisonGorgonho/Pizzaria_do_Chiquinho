package conexaoBD;

/**Classe para a conex�o de todas as outras classes com o banco de dados, onde ser�o contidos, valores e m�todos para o mesmo.
 * @author 
 * @version 1.0
 * @since Release 0
 */

import java.sql.*;
import java.util.logging.*;

public class ConexaoBD {
	
	static final String driver = "com.mysql.jdbc.Driver";
	static final String user = "sql10178383";
	static final String pass = "Zp8QulGVDB";
	static final String url = "jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10178383";
	
	static final String nao  = "N�o conectou";
	static final String sim = "Conectou";
	static final String fim = "Desconectou";
	
	public static  java.sql.Connection getConnection(){
		
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			System.out.println(sim);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(nao);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(nao);
			
		}
		return con;
		
	}
	public static void closeConnection(Connection con){
        
        if(con!=null){
            try {
                con.close();
                System.out.println(fim);
                
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
	public static void closeConnection(Connection con, PreparedStatement stmp){
        
        closeConnection(con);
       if(stmp!=null){
           try {
               stmp.close();
           } catch (SQLException ex) {
               Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
           }
       }

   }
	public static void closeConnection(Connection con, PreparedStatement stmp, ResultSet rs ){
        
        closeConnection(con,stmp);
       if(rs!=null){
           try {
               rs.close();
               
           } catch (SQLException ex) {
               Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
           }
       }

   }
	

}
