<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<frm:form action="edit" modelAttribute="emp" method="post"> 
           <table border="0" align="center">
                   <tr style="color:blue">
                      <td>Employee Id::</td>
                      <td><frm:input path="empid" readOnly="true"/></td>
                   </tr>
                   <tr style="color:blue">
                          <td>Employee Name::</td>
                          <td><frm:input path="empname"/></td>
                   </tr>
                   <tr style="color:blue">
                          <td>Employee Designation::</td>
                          <td><frm:input path="empdesg"/></td>
                   </tr>
                   <tr style="color:blue">
                          <td>Employee Salary::</td>
                          <td><frm:input path="empsal"/></td>
                          
                   </tr>
                   <tr style="color:red">
                        <td><input type="submit" value="UpdateEmploye"></td>
                        <td><input type="reset" value="Reset"></td>
                   </tr>
           </table>
</frm:form>