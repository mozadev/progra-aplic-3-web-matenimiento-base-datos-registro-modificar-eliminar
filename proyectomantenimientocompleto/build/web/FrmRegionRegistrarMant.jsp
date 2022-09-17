

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
        <script>
         
        function grabar(){
            document.form.action="<%=request.getContextPath()%>/RegionServlet";
            document.form.method="GET";
            document.form.op.value="4";
            document.form.submit();
        }
        function salir(){
            document.form.action="<%=request.getContextPath()%>/RegionServlet";
            document.form.method="GET";
            document.form.op.value="5";
            document.form.submit();
        }
        </script>
    </head>
    <body>
        <form name="form">
            <input type="hidden" name="op">
            <center>
                <table>
                    <tr>
                        <td colspan="2">Registrar Tabla Region</td>
                    </tr>
                    <tr>
                        <td>Codigo: </td>
                        <td><input type="text" name="txtcodigo"></td>
                    </tr>
                    <tr>
                        <td>Nombre: </td>
                        <td><input type="text" name="txtnombre"></td>
                    </tr>
                </table>
                <table border="1">
                    <tr>
                        <td><button onclick="grabar()">Grabar</button></td>
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
