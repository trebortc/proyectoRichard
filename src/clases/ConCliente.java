package clases;

import conexion.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Data provider for excel
 *
 * @author angel
 */
public final class ConCliente {

    private ConexionMySQL cl = new ConexionMySQL();
    private Connection cn = cl.Conectar();
    public static PreparedStatement ps;
    

    /**
     * Return the columns name for the table
     */
    public static List<String> getTableHeaders() {
        List<String> tableHeader = new ArrayList<String>();
        //TITULOS DE LAS COLUMNAS
        tableHeader.add("CÉDULA");
        tableHeader.add("PRI. NOMBRE");
        tableHeader.add("SEG. NOMBRE");
        tableHeader.add("PRI. APELLIDO");
        tableHeader.add("SEG. APELLIDO");
        tableHeader.add("FECHA NACIMIENTO");
        tableHeader.add("GENERO");
        tableHeader.add("TELÉFONO");
        tableHeader.add("CIUDAD");
        tableHeader.add("DIRECCIÓN");
        tableHeader.add("MAIL");

        return tableHeader;
    }

    /**
     * Return values for the table
     *
     * @param numberOfRows Number of rows we want to receive
     *
     * @return Values
     */
    public static List<List<String>> getTableContent(int numberOfRows) {
        try {
            if (numberOfRows <= 0) {
                throw new IllegalArgumentException("The number of rows must be a positive integer");
            }

            List<List<String>> tableContent = new ArrayList<List<String>>();
            String sSQL="";
            ConexionMySQL mysql = new ConexionMySQL();
            Connection cn = mysql.Conectar();

            String SQL = "SELECT * FROM cliente";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            int i = 0;
            List<String> row = null;
            while (rs.next()) {
                tableContent.add(row = new ArrayList<String>());

                row.add(rs.getString("ci_cli"));
                row.add(rs.getString("pnom_cli"));
                row.add(rs.getString("snom_cli"));
                row.add(rs.getString("pape_cli"));
                row.add(rs.getString("sape_cli"));
                row.add(rs.getString("fec_nac"));
                row.add(rs.getString("gen"));
                row.add(rs.getString("telf"));
                row.add(rs.getString("ciu"));
                row.add(rs.getString("dir"));
                row.add(rs.getString("mail"));

                i++;
            }
            return tableContent;
        } catch (SQLException ex) {
            Logger.getLogger(ConCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
