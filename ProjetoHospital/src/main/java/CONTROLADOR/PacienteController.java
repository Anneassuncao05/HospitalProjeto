package CONTROLADOR;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.PacienteDao;
import MODELO.Paciente;

@WebServlet(name = "Paciente", urlPatterns = {"/PacienteController"})
public class PacienteController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "WEB-INF/Formulario.jsp";
    private static String LIST_PACIENTE = "WEB-INF/listPaciente.jsp";
    private PacienteDao dao;


    public PacienteController() {
    	
        super();
        dao = new PacienteDao();
    }
 

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action != null && action.equalsIgnoreCase("delete")){
            int Id = Integer.parseInt(request.getParameter("Id"));
            dao.deletePaciente(Id);
            forward = LIST_PACIENTE;
            request.setAttribute("PACIENTE", dao.getAllPaciente());    
        } else if (action != null && action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int Id = Integer.parseInt(request.getParameter("Id"));
            Paciente Paciente = dao.getPacienteById(Id);
            request.setAttribute("Paciente", Paciente);
        } else if (action != null && action.equalsIgnoreCase("listPaciente")){
            forward = LIST_PACIENTE;
           // request.setAttribute("Paciente", dao.getAllPaciente ());
            request.setAttribute("Paciente", new Paciente());
            
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Paciente paciente = new Paciente();
        paciente.setNomePaciente(request.getParameter("NomePaciente"));
        paciente.setNumeroCarteiraPlano(request.getParameter("NumeroCarteiraPlano"));
        paciente.setEspecialidade(Integer.parseInt(request.getParameter("Especialidade")));      
        paciente.setPlano(Integer.parseInt(request.getParameter("Plano"))); 
        int Id =Integer.parseInt(request.getParameter("Id")); 
        paciente.setId(Id);
    
        if (!dao.especialidadePlanoExite(paciente.getNumeroCarteiraPlano(),paciente.getEspecialidade(), paciente.getPlano())) {
            if(Id==0) {
                dao.addPaciente(paciente);
            } else {
                dao.updatePaciente(paciente);
            }
      }
     else
     {
         dao.updatePaciente(paciente);
     }
         RequestDispatcher view = request.getRequestDispatcher(LIST_PACIENTE);
         request.setAttribute("Paciente", dao.getAllPaciente());
         view.forward(request, response);
   
    }
}
  