<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border=1>
    <thead>
       <tr>
          <th>Id</th>
          <th>Nome do paciente</th>
          <th>Num. da carteira/Plano</th>
          <th>Especialidade</th>
          <th> Planos</th>
          <th colspan=2>Ação</th>
       </tr>
    </thead>
<tbody>
    
     <c:forEach items="${Paciente}" var="Paciente">
     <tr>
           
           <td><c:out value="${Paciente.NomePaciente}"/></td>
           <td><c:out value="${Paciente.NumeroCarteiraPlano}"/></td>
           <td><c:out value="${Paciente.Especialidade}"/></td>
           <td><c:out value="${Paciente.Plano}"/></td>
           <td><a href="PacienteController?action=edit&Id= <c:out value= "${Paciente.Id}"/>">Alterar</a></td>
           <td><a href="PacienteController? action= delete & Id= <c:out value= "${Paciente.Id}"/>">Deletar</a></td>
     </tr>
     </c:forEach>

</table>

</body>
</html>