package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import MODELO.Especialidade;
import UTIL.ConexaoBanco;

public class EspecialidadeDao {
        


	    private Connection connection;

	    public EspecialidadeDao() {
	        connection = ConexaoBanco.getConnection();
	    }

	    public List<Especialidade> getAllEspecialidade() {
	        List<Especialidade> listaDeEspecialidade = new ArrayList<Especialidade>();
	        try {
	            Statement stmt = connection.createStatement();
	            ResultSet rs = stmt.executeQuery("select * from Especialidades");
	            while (rs.next()) {
	                Especialidade Especialidade = new  Especialidade();
	                
	                Especialidade.setId(rs.getInt("Id"));
	                Especialidade.setEspe(rs.getString("Espe"));
	               
	                listaDeEspecialidade.add(Especialidade);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return listaDeEspecialidade;
	    }

	  
	}