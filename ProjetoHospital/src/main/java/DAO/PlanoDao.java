package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import MODELO.Plano;
import UTIL.ConexaoBanco;

public class PlanoDao { 
        


	    private Connection connection;

	    public PlanoDao() {
	        connection = ConexaoBanco.getConnection();
	    }

	    public List<Plano> getAllPlano() {
	        List<Plano> listaDePlano = new ArrayList<Plano>();
	        try {
	            Statement stmt = connection.createStatement();
	            ResultSet rs = stmt.executeQuery("select * from PlanoDeSaude");
	            while (rs.next()) {
	                Plano plano = new  Plano();
	                
	                plano.setId(rs.getInt("Id"));
	                plano.setPlano(rs.getString("Plano"));
	               
	                listaDePlano.add(plano);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return listaDePlano;
	    }

	}
