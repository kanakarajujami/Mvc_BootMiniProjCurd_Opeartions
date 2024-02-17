<%@ page isELIgnored="false"%>
<h1 style="color:yellow;text-align:center">Report Page</h1>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
      <c:when test="${!empty emplist}">
               <table border="1"  align="center">
                   <tr style="color:blue"><th>EMPNO</th><th>EMPNAME</th><th>EMPDESG</th><th>EMPSAL</th><th>Operations</th></tr>
                   <c:forEach var="empdata" items="${emplist}">
                    <tr style="color:red">
                       <td>${empdata.empid}</td>
                       <td>${empdata.empname}</td>
                       <td>${empdata.empdesg}</td>
                       <td>${empdata.empsal}</td>
                       <td><a href="edit?empid=${empdata.empid}"><img src="images/edit.jfif" width="30px" height="30px"></a>
                            <a href="delete?empid=${empdata.empid}" onclick="return confirm('do you want to detelet?')"><img src="images/delete.jfif" width="30px" height="30px"></a>
                       </td>
                   </tr>
                 </c:forEach>
               </table> 
     </c:when>
      <c:otherwise>
               <h1 style="color:green;text-align:center">Employee Records not found</h1>
      </c:otherwise>
</c:choose><br>
         <center>
                   <a href="register"><img src="images/add.jfif" width="50px" height="50px"></a>&nbsp;&nbsp;
                   <a href="./"><img src="images/home.png" width="50px" height="50px"></a>
         </center>
           
         <h1 style="color:green;text-align:center">${resultMsg}</h1>
         