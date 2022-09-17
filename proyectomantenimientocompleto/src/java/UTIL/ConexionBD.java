package UTIL;

import java.sql.*;

public class ConexionBD {

    public static Connection getConexionBD() {
        Connection cn = null;

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost/bdmantenimiento","root",""); // puente de conexion
            System.out.print("se conecto tarea3 !!!");
        } catch (Exception e)
        {
            System.out.print("NO se conecto a la base de datos tarea3 !!!");
        }
        return cn;
    }

    public static void main(String[] args) {
        getConexionBD();
    }

}

