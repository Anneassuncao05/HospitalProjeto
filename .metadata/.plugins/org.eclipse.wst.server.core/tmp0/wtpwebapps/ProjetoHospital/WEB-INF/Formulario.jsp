<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="styles.css">
<style>
   form{
      margin-left:350px;
  
   }
   input, option{
      display:block;
      border:1px solid #6959CD;
   }
   h1{
     margin-left:289px;
     color:#836FFF;
   }
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


  <h1>PROJETO-HOSPITAL</h1><BR>

   <form action="PacienteController" method="post" name="formAddPaciente">
   
        <input type="hidden" name="Id" value="<c:out value="${0 }"/>" />
      
          Nome do Paciente: <input type="text" name="NomePaciente"
       value="<c:out value="${Paciente.NomePaciente }"/>" /><br/>
          Num. da Carteira/Plano: <input type="text"  name="NumeroCarteiraPlano"
       value="<c:out value="${Paciente.NumeroCarteiraPlano }"/>" /><br/>
       
         Especialidade:<br> <select name="Especialidade">
                <option value="1"> Clinico geral</option>
                <option value="2"> Pediatra</option>
                <option value="3">Obstetra</option>
                <option value="4">Ortopedista</option>
                
         </select><br><br>
          Plano: <br> <select name="Plano">
                <option value="5"> Unimed</option>
                <option value="6"> Bradesco Saúde</option>
                <option value="7"> Amil</option>
                <option value="8">GNDI</option>
                
         </select><br><br>
       <input type="submit" value="Cadastrar"/>
   </form>
</body>
</html>