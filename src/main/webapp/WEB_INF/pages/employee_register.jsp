<%@ page isELIgnored="false" %>
<h1 style="text-align:center;color:red"></h1>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<h1 style="color:blue;text-align:center">Employee Registration</h1>
<frm:form action="addemp" modelAttribute="emp" methd="post">
    <table border="0" align="center">
       <tr>
          <td>Employee Name::</td>
          <td><frm:input path="empname"></frm:input></td>
       </tr>
       <tr>
       <td>Employee Designation::</td>
       <td><frm:input path="empdesg"></frm:input></td>
       </tr>
       <tr>
          <td>Employee Salary::</td>
          <td><frm:input path="empsal"/></td>
       </tr>
       <tr>
             <td style="color:red"><input type="submit" value="submit"></td>
       </tr>
    </table>
</frm:form>