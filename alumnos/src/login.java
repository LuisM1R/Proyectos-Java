import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class login {

    static final String URL = "jdbc:mysql://148.225.60.126/bd2?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";

    public static void main(String[] args) {
        String usuario, contra;
        Scanner sc = new Scanner(System.in);

        System.out.println("Cual es tu usuario?");
        usuario = sc.nextLine();

        System.out.println("Cual es tu contraseña?");
        contra = sc.nextLine();

        try {
            ingresoBaseDatos(usuario, contra);
        } catch (Exception e) {
            System.out.println("SQL Exception:" + e.getMessage());
        }

        System.out.println("");


    }

    public static void ingresoBaseDatos(String program_username, String program_password) {
        // usuario y contraseña
        String user = "bd2";
        String password = "MementoVivere";
        Connection conexion = null;
        Statement instruccion = null;
        ResultSet conjuntoResultados = null;

        String SQL_auth = "SELECT username FROM LAMD_USERS WHERE username = '" + program_username + "'"
                + " AND password = SHA2('" + program_password + "', 256)";
        System.out.println(SQL_auth);

        try {
            conexion = DriverManager.getConnection(URL, user, password);
            instruccion = conexion.createStatement();
            conjuntoResultados = instruccion.executeQuery(SQL_auth);
            if (conjuntoResultados.next() == true) {
                System.out.println("Bienvenido " + program_username);
            } else {
                System.out.println("Usuario o contraseña incorrectos");
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.getMessage());
            System.out.println("SQL State:" + e.getSQLState());
            System.out.println("Vendor Error:" + e.getErrorCode());
        }

    }


    public static void Seleccion(int opcion){
        
        switch(opcion){
            
        }

        String SQL = "SELECT OPCIONES_MENU.* FROM OPCIONES_MENU, LAMD_USERS WHERE LAMD_USERS.username = "pedrito777" AND LAMD_USERS.usertype = OPCIONES_MENU.TIPO_USER";
        System.out.println(SQL);

        try {
            conexion = DriverManager.getConnection(URL, user, password);
            instruccion = conexion.createStatement();
            conjuntoResultados = instruccion.executeQuery(SQL);
            if (conjuntoResultados.next() == true) {
                System.out.println("Bienvenido " + program_username);
            } else {
                System.out.println("Usuario o contraseña incorrectos");
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.getMessage());
            System.out.println("SQL State:" + e.getSQLState());
            System.out.println("Vendor Error:" + e.getErrorCode());
        }

    }
        


}