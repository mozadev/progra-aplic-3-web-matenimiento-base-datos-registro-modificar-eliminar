

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="BEAN.RegionBean"%>
<%!
    RegionBean objRegionBean=null;
%>
<%
    objRegionBean =(RegionBean)request.getAttribute("datos");
%>

<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
        <script>
         
        function salir(){
            document.form.action="<%=request.getContextPath()%>/RegionServlet";
            document.form.method="GET";
            document.form.op.value="5";
            document.form.submit();
        }
        function modificar(){
            document.form.action="<%=request.getContextPath()%>/RegionServlet";
            document.form.method="GET";
            document.form.op.value="7";
            document.form.submit();
        }
        </script>
    </head>
    <body>
        <form name="form">
            <input type="hidden" name="op">
            <input type="hidden" name="CODIGO" VALUE="<%=objRegionBean.getCODREGION()%>">
            
            <center>
                <table>
                    <tr>
                        <td colspan="2">Modificar Tabla Region</td>
                    </tr>
                    <tr>
                        <td>Codigo: </td>
                        <td><input type="text" disabled="false" name="txtcodigo" value="<%=objRegionBean.getCODREGION()%>"></td>
                    </tr>
                    <tr>
                        <td>Nombre: </td>
                        <td><input type="text" name="txtnombre" value="<%=objRegionBean.getNOMBREGION()%>"></td>
                    </tr>
                </table>
                    <table border="1">
                        <tr>
                            <td><button onclick="modificar()">Modifciar</button></td>
                            <td><button onclick="salir()">Salir</button></td>
                        </tr>
                    </table>
                    <font style="color: red">
                    <% 
                        if(request.getAttribute("mensaje")!=null){
                        String msj=(String)request.getAttribute("mensaje");
                        out.print(msj);
                    }
                    %>
                    </font>
            </center>
        </form>
    </body>
</html>
