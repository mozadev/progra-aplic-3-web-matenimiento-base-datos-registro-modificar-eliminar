
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BEAN.RegionBean"%>
<%!ArrayList<RegionBean> listaregion; %>
<%listaregion=(ArrayList<RegionBean>)request.getAttribute("listaregion");%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
        <script>
        function salir(){
            document.form.action="<%=request.getContextPath()%>/RegionServlet";
            document.form.method="GET";
            document.form.op.value="2";
            document.form.submit();
        }
        function nuevo(){
            document.form.action="<%=request.getContextPath()%>/RegionServlet";
            document.form.method="GET";
            document.form.op.value="3";
            document.form.submit();
        }
        function modificar(cod,nomb){
            document.form.action="<%=request.getContextPath()%>/RegionServlet";
            document.form.method="GET";
            document.form.op.value="6";
            document.form.COD.value=cod;
            document.form.NOM.value=nomb;
            document.form.submit();
        }
        function eliminar(cod){
            document.form.action="<%=request.getContextPath()%>/RegionServlet";
            document.form.method="GET";
            document.form.op.value="8";
            document.form.COD.value=cod;
            document.form.submit();
        }
        </script>
    </head>
    
    <body>
    <center>
        <form name="form">
            <input type="hidden" name="op">
            <input type="hidden" name="COD">
            <input type="hidden" name="NOM">
            <table border="1">
                <tr>
                    <td><button onclick="nuevo()">Nuevo</button></td>
                    <td colspan="2"></td>
                    <td><button onclick="salir()">Salir</button></td>
                </tr>
                <tr>
                    <td>Codigo</td>
                    <td>Nombre</td>
                    <td>Eliminar</td>
                    <td>Modificar</td> 
                </tr>
                <% for(RegionBean obj:listaregion)
                {%>
                <tr>
                    <td><%=obj.getCODREGION()%></td>
                    <td><%=obj.getNOMBREGION()%></td>
                    <td><button onclick="modificar('<%=obj.getCODREGION()%>','<%=obj.getNOMBREGION()%>')">Modificar</button></td>

                    <td><button onclick="eliminar('<%=obj.getCODREGION()%>')">Eliminar</button></td>
                </tr>
                <%}%>
            </table>
        </form>
    </center>
    </body>
</html>
