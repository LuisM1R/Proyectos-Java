import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author federico
 */
public class alumnos {

    /**
     * @param args the command line arguments
     */

    static final String URL = "jdbc:mysql://148.225.60.126/bd2?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";

    public static void main(String[] args) {
        // TODO code application logic here
        Connection conexion = null;
        Statement instruccion = null;
        ResultSet conjuntoResultados = null;
        String SQL = "SELECT * FROM ALUMNOS";
        String user = "bd2";
        String password = "MementoVivere";

        try {
            conexion = DriverManager.getConnection(URL, user, password);
            instruccion = conexion.createStatement();

            conjuntoResultados = instruccion.executeQuery(SQL);
            System.out.println("Lista de alumnos");
            // Obtenemos nombre de las columnas
            ResultSetMetaData metaDatos = conjuntoResultados.getMetaData();
            int numeroColumnas = metaDatos.getColumnCount();
            for (int i = 1; i <= numeroColumnas; i++) {
                System.out.print("  " + metaDatos.getColumnName(i));
            }
            System.out.println("");
            // Obtenemos los datos de cada fila e imprimimos
            while (conjuntoResultados.next()) {
                for (int i = 1; i <= numeroColumnas; i++) {
                    System.out.print("   " + conjuntoResultados.getObject(i));

                }
                System.out.println("");
            }
            conexion.close();

        } catch (SQLException ex) {
            System.out.println("SQL Exception:" + ex.getMessage());
            System.out.println("SQL State:" + ex.getSQLState());
            System.out.println("Vendor Error:" + ex.getErrorCode());
        }
    }

}