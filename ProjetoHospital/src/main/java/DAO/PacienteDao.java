package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import MODELO.Paciente;
import UTIL.ConexaoBanco;

public class PacienteDao extends ConexaoBanco{
	
        public void addPaciente(Paciente paciente){
            try (Connection connection = getConnection()) {
                PreparedStatement pstm = connection.prepareStatement
                ("Insert into FichaPacientes (Id, NomePaciente, NumeroCarteiraPlano, Especialidade, Planos) values (?,?,?,?,?)");
                pstm.setInt(1, 0);
                pstm.setString(2, paciente.getNomePaciente());
                pstm.setString(3, paciente.getNumeroCarteiraPlano());
                pstm.setInt(4, paciente.getEspecialidade());
                pstm.setInt(5, paciente.getPlano());
                pstm.execute();
                pstm.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void deletePaciente(int Id) {
                try (Connection connection = getConnection()) {
                PreparedStatement pstm = connection.prepareStatement("delete from FichaPacientes where Id=?");
                pstm.setInt(1, Id);
                pstm.execute();
                pstm.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void updatePaciente(Paciente paciente) {
                try (Connection connection = getConnection()) {
                PreparedStatement pstm = connection.prepareStatement
                ("update FichaPacientes set NomePaciente=?, NumeroCarteiraPlano=?, Especialidade=?, Planos=? where Id=?");
                pstm.setString(1, paciente.getNomePaciente());
                pstm.setString(2, paciente.getNumeroCarteiraPlano());
                pstm.setInt(3, paciente.getEspecialidade());
                pstm.setInt(4, paciente.getPlano());
                pstm.setInt(5, paciente.getId());
                pstm.execute();
                pstm.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	  
        public List<Paciente> getAllPaciente() {
                List<Paciente> listaDePaciente = new ArrayList<Paciente>();
                try (Connection connection = getConnection()) {
                    Statement pstm = connection.createStatement();
                    ResultSet rs = pstm.executeQuery("select * from FichaPacientes");
                    while (rs.next()) {
                        Paciente paciente = new Paciente();
                        paciente.setId(rs.getInt("Id"));
                        paciente.setNomePaciente(rs.getString("NomePaciente"));
                        paciente.setNumeroCarteiraPlano(rs.getString("NumeroCarteiraPlano"));
                        paciente.setEspecialidade(rs.getInt("Especialidade"));
                        paciente.setPlano(rs.getInt("Plano"));
                        listaDePaciente.add(paciente);
                    }
                    pstm.close();
                    connection.close();
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return listaDePaciente;
        }
        
        public Paciente getPacienteById(int Id) {
                Paciente paciente = new Paciente();
                try (Connection connection = getConnection()) {
                    PreparedStatement pstm = connection.prepareStatement("select * from FichaPacientes where Id=?");
                    pstm.setInt(1, Id);
                    ResultSet rs = pstm.executeQuery();
                    if (rs.next()) {
                        paciente.setId(rs.getInt("Id"));
                        paciente.setNomePaciente(rs.getString("NomePaciente"));
                        paciente.setNumeroCarteiraPlano(rs.getString("NumeroCarteiraPlano"));
                        paciente.setEspecialidade(rs.getInt("Especialidade"));
                        paciente.setPlano(rs.getInt("Plano"));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return paciente;
            }
        public boolean especialidadePlanoExite(String NumeroCarteiraPlano , int Especialidade, int Plano) {
        	try(Connection connection = getConnection()){
        		PreparedStatement pstm = connection.prepareStatement("select*from FichaPacientes where Id=? and Especialidade=? and Planos=?");
        		
        		pstm.setString(1,NumeroCarteiraPlano);
        		pstm.setInt(2,Especialidade);
        		pstm.setInt(3,Plano);
        		ResultSet rs = pstm.executeQuery();
        		if(rs.next()) {
        			return true;
        		}
           }catch(SQLException e) {
        	   e.printStackTrace();
           }
        	return false;
        }
        
        
        
        }