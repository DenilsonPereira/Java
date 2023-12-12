package teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTeste {
	
	   // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "org.postgresql.Driver";  
	   static final String DB_URL = "jdbc:postgresql://localhost:5432/hotel";

	   //  Database credentials
	   static final String USER = "postgres";
	   static final String PASS = "";
	   
	   public static void main(String[] args) {
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName(JDBC_DRIVER);

	      //STEP 3: Open a connection
	      System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      System.out.println("Connected database successfully...");
	      
	      //STEP 4: Execute a query
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql = "UPDATE Hotel " +
	                   "SET nome = 'Gold garden' WHERE codigo = '1'";
	      int qtd = stmt.executeUpdate(sql);
	      
	      if(qtd > 0) System.out.println("Row updated!");

	      // Now you can extract all the records
	      // to see the updated records
	      
	      sql = "SELECT codigo, nome, cep, logradouro, cidade, estado FROM hotel";
	      ResultSet rs = stmt.executeQuery(sql);

	      while(rs.next()){
	         //Retrieve by column name
	         String codigo  = rs.getString("codigo");
	         String nome = rs.getString("nome");
	         String cep = rs.getString("cep");
	         String logradouro = rs.getString("logradouro");
	         String cidade = rs.getString("cidade");
	         String estado = rs.getString("estado");

	         //Display values
	         System.out.print("Código: " + codigo);
	         System.out.print(", Nome: " + nome);
	         System.out.print(", Cep: " + cep);
	         System.out.print(", Logradouro: " + logradouro);
	         System.out.print(", Cidade: " + cidade);
	         System.out.print(", Estado: " + estado);
	         System.out.println();
	      }
	      rs.close();
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	        	stmt.close();
	      }catch(SQLException se){
	      }// do nothing
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
	}//end main
}//end JDBCExample
