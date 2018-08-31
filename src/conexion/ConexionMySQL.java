/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author RICHARD
 */
public class ConexionMySQL
{
    public String db = "agenciaavendano";
    public String url = "jdbc:mysql://localhost/"+db;
    public String user = "root";
    public String pass = "1234";




    public Connection Conectar()
    {
        Connection link = null;
        try
        {
            Class.forName("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection(this.url, this.user, this.pass);

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }

        return link;
    }
    
}
