package br.com.compasso.modelo;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BeanCrud implements Serializable{
	
	public Connection connection;
	
	public void toDo(String sql, List<Object> arguments){
		PreparedStatement st = null;
		try{
			st = connection.prepareStatement(sql);
			
			for(int i = 1; i <= arguments.size(); i++){
				if(arguments.get(i -1) instanceof String){
					st.setString(i, (String)arguments.get(i -1));
				} else{
					st.setInt(i, (Integer)arguments.get(i -1));
				}
				
			}
			
			st.execute();
			
		}catch (SQLException e){
			e.printStackTrace();
		} finally {
			if(st != null){
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}
		}
	}
}
