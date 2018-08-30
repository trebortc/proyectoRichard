package formularios;


import com.sun.glass.events.KeyEvent;
import conexion.ConexionMySQL;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Richard
 */
public class BusSolicitud extends javax.swing.JFrame {
DefaultTableModel Buscar;
private TableRowSorter tr;
           
    /**
     * Creates new form BusSolicitud
     */
    public BusSolicitud() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        this.getContentPane().setBackground(new Color(79,157,157));
    }
    
    public void filtros() {
        int columnaABuscar = 0;
       
        if (cboBusSol.getSelectedItem() == "No. Póliza") {
            columnaABuscar = 0;
        }
        if (cboBusSol.getSelectedItem().toString() == "No. Solicitud") {
            columnaABuscar = 1;
        }
        if (cboBusSol.getSelectedItem().toString() == "Día") {
            columnaABuscar = 3;
        }
        if (cboBusSol.getSelectedItem().toString()== "Mes") {
            columnaABuscar = 4;
        }
        if (cboBusSol.getSelectedItem().toString() == "Año") {
            columnaABuscar = 5;
        }
        if (cboBusSol.getSelectedItem().toString() == "Estado") {
            columnaABuscar = 9;
        }
        
        tr.setRowFilter(RowFilter.regexFilter("(?i)"+txtBusSol.getText(), columnaABuscar));
    
      }
    void CargarTabla(String Solicitud)
    {
        try
        {
            String sSQL="";
            String[] Titulos = {"No. PÓLIZA", "No. SOLICITUD" ,"DESCRIPCIÓN", "DÍA", "MES", "AÑO", "HORA", "MINUTO", "LUGAR", "ESTADO"};
            String[] Datos = new String[10];

            Buscar = new DefaultTableModel(null,Titulos);

            ConexionMySQL mysql = new ConexionMySQL();
            Connection cn = mysql.Conectar();

            sSQL = "SELECT num_poliza, num_solicitud, descripcion, fecha_d, fecha_m, fecha_a, hora, minuto, lugar, estado FROM solicitud "
                    + "WHERE CONCAT(num_poliza) LIKE '%"+Solicitud+"%' ";
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
 
            while(rs.next())
            {
                        Datos[0] = rs.getString("num_poliza");
                        Datos[1] = rs.getString("num_solicitud");
                        Datos[2] = rs.getString("descripcion");
                        Datos[3] = rs.getString("fecha_d");
                        Datos[4] = rs.getString("fecha_m");
                        Datos[5] = rs.getString("fecha_a");
                        Datos[6] = rs.getString("hora");
                        Datos[7] = rs.getString("minuto");
                        Datos[8] = rs.getString("lugar");
                        Datos[9] = rs.getString("estado");

                        Buscar.addRow(Datos);
            }   
            //else {
              //  JOptionPane.showMessageDialog(null, "No existe una persona con la clave");
           // }
            tblBuscarSolicitud.setModel(Buscar);

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }

     boolean ValidarNum(String palabra){
        for(int i = 0; i < palabra.length(); i++){
            if(!((palabra.charAt(i) > 47 && palabra.charAt(i) < 58)))
                return false;
        }
        return true;
    }
     
      void Borrar()
    {
            txtBusSol.setText("");
            
    }
      public void ValidaExpediente(String exp) {
        
        String expedienteKCPro;
        boolean existe = false; //variable bandera para comprobar si NO existe el expediente en la BD
        
        try{        
            String sSQL="";
            ConexionMySQL mysql = new ConexionMySQL();
            Connection cn = mysql.Conectar();
            //pstm = con.getConnection().prepareStatement("SELECT escExpediente FROM KCP WHERE escExpediente = '" + exp+ "'");            
            //res = pstm.executeQuery(); 
            sSQL ="SELECT num_solicitud FROM solicitud WHERE num_solicitud = '" + exp+ "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while(rs.next()){
                existe = true;
                if(existe == true){
                    expedienteKCPro = rs.getString("num_solictud");               
                    if ( exp.equals(expedienteKCPro) ){                
                        JOptionPane.showMessageDialog(null, "El expediente: " + expedienteKCPro + " si está en la BD", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    }
                }    
            } //fin while res.next 
            if ( existe == false ) {
                JOptionPane.showMessageDialog(null, "El expediente NO está en la base de datos,\nvuelva a capturar el número o reportelo a TI", "Error de captura", JOptionPane.ERROR_MESSAGE);
            }
            rs.close();                        
            
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
          }
        
    }
     
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIconoBusSol = new javax.swing.JLabel();
        lblTitBusSol = new javax.swing.JLabel();
        pnlBusSol = new javax.swing.JPanel();
        btnBusBusSol = new javax.swing.JButton();
        btnSalBusSol = new javax.swing.JButton();
        scpBuscarSolicitud = new javax.swing.JScrollPane();
        tblBuscarSolicitud = new javax.swing.JTable();
        lblNumBusSol = new javax.swing.JLabel();
        cboBusSol = new javax.swing.JComboBox<>();
        txtBusSol = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AVENDAÑO AGENCIA DE SEGUROS");
        setAlwaysOnTop(true);
        setName("frmBusSolicitud"); // NOI18N

        lblIconoBusSol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscarSolicitud.png"))); // NOI18N

        lblTitBusSol.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitBusSol.setText("BUSCAR SOLICITUD");

        pnlBusSol.setBackground(new java.awt.Color(79, 157, 157));
        pnlBusSol.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Solicitud"));

        btnBusBusSol.setBackground(new java.awt.Color(79, 157, 157));
        btnBusBusSol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        btnBusBusSol.setText("MOSTRAR DATOS");
        btnBusBusSol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusBusSolActionPerformed(evt);
            }
        });

        btnSalBusSol.setBackground(new java.awt.Color(79, 157, 157));
        btnSalBusSol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida.png"))); // NOI18N
        btnSalBusSol.setText("SALIR");
        btnSalBusSol.setMaximumSize(new java.awt.Dimension(101, 33));
        btnSalBusSol.setMinimumSize(new java.awt.Dimension(101, 33));
        btnSalBusSol.setPreferredSize(new java.awt.Dimension(101, 33));
        btnSalBusSol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalBusSolActionPerformed(evt);
            }
        });

        tblBuscarSolicitud.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblBuscarSolicitud.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        scpBuscarSolicitud.setViewportView(tblBuscarSolicitud);

        lblNumBusSol.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNumBusSol.setText("Seleccione Para Buscar Solicitud");

        cboBusSol.setBackground(new java.awt.Color(79, 157, 157));
        cboBusSol.setMaximumRowCount(13);
        cboBusSol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "No. Póliza", "No. Solicitud", "Día", "Mes", "Año", "Estado" }));
        cboBusSol.setToolTipText("Seleccionar");

        txtBusSol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusSolKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout pnlBusSolLayout = new javax.swing.GroupLayout(pnlBusSol);
        pnlBusSol.setLayout(pnlBusSolLayout);
        pnlBusSolLayout.setHorizontalGroup(
            pnlBusSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBusSolLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlBusSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scpBuscarSolicitud, javax.swing.GroupLayout.DEFAULT_SIZE, 1045, Short.MAX_VALUE)
                    .addGroup(pnlBusSolLayout.createSequentialGroup()
                        .addComponent(lblNumBusSol)
                        .addGap(31, 31, 31)
                        .addComponent(cboBusSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(txtBusSol, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(btnBusBusSol, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnSalBusSol, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlBusSolLayout.setVerticalGroup(
            pnlBusSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBusSolLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBusSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalBusSol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBusBusSol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNumBusSol)
                    .addComponent(cboBusSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBusSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpBuscarSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlBusSol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblIconoBusSol)
                        .addGap(346, 346, 346)
                        .addComponent(lblTitBusSol)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblIconoBusSol))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(lblTitBusSol)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlBusSol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBusBusSolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusBusSolActionPerformed
        // TODO add your handling code here:
      String Solicitud = txtBusSol.getText();
        if(ValidarNum(Solicitud)==false){
            JOptionPane.showMessageDialog(null, "Campos llenos de manera incorrecta");
        }
        else{
          
            Borrar();
            CargarTabla(Solicitud);
        }
      
        
    }//GEN-LAST:event_btnBusBusSolActionPerformed

    private void btnSalBusSolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalBusSolActionPerformed
        // TODO add your handling code here:
        this.dispose();
    
    }//GEN-LAST:event_btnSalBusSolActionPerformed

    private void txtBusSolKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusSolKeyTyped
        // TODO add your handling code here:
        txtBusSol.addKeyListener(new KeyAdapter() {

            public void keyReleased(final java.awt.event.KeyEvent e) {
                String cadena = (txtBusSol.getText()).trim();
                txtBusSol.setText(cadena);
                repaint();
                filtros();
            }
        });
        tr = new TableRowSorter(tblBuscarSolicitud.getModel());
        tblBuscarSolicitud.setRowSorter(tr);
    }//GEN-LAST:event_txtBusSolKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BusSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BusSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BusSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BusSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                /*try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(BusSolicitud.class.getName()).log(Level.SEVERE, null, ex);
                }*/
                new BusSolicitud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusBusSol;
    private javax.swing.JButton btnSalBusSol;
    private javax.swing.JComboBox<String> cboBusSol;
    private javax.swing.JLabel lblIconoBusSol;
    private javax.swing.JLabel lblNumBusSol;
    private javax.swing.JLabel lblTitBusSol;
    private javax.swing.JPanel pnlBusSol;
    private javax.swing.JScrollPane scpBuscarSolicitud;
    private javax.swing.JTable tblBuscarSolicitud;
    private javax.swing.JTextField txtBusSol;
    // End of variables declaration//GEN-END:variables
}
