package formularios;


import conexion.ConexionMySQL;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Richard
 */
public class AprSolicitud extends javax.swing.JFrame {
DefaultTableModel Aprobar;
private TableRowSorter tr;
    /**
     * Creates new form AprSolicitud
     */
    public AprSolicitud() {
        initComponents();
        this.getContentPane().setBackground(new Color(79,157,157));
        this.setLocationRelativeTo(null);
    }
    public void filtro() {
    tr.setRowFilter(RowFilter.regexFilter("(?i)"+txtNumAprBusSolicitud.getText(), 0));
    }
    public void filtrouno() {
    tr.setRowFilter(RowFilter.regexFilter("(?i)"+txtNumAprSolicitud.getText(), 0));
    }
    void CargarTabla(String Solicitud)
    {
        try
        {
            String sSQL="";
            String[] Titulos = {"No. SOLICITUD", "No. PÓLIZA" , "DESCRIPCIÓN", "DÍA", "MES", "AÑO", "HORA", "MINUTO", "LUGAR", "ESTADO"};
            String[] Datos = new String[10];

            Aprobar = new DefaultTableModel(null,Titulos);

            ConexionMySQL mysql = new ConexionMySQL();
            Connection cn = mysql.Conectar();

            sSQL = "SELECT num_poliza, num_solicitud, descripcion, fecha_d, fecha_m, fecha_a, hora, minuto, lugar, estado FROM solicitud "
                    + "WHERE CONCAT(num_solicitud) LIKE '%"+Solicitud+"%' ";

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while(rs.next())
            {
                        Datos[0] = rs.getString("num_solicitud");
                        Datos[1] = rs.getString("num_poliza");
                        Datos[2] = rs.getString("descripcion");
                        Datos[3] = rs.getString("fecha_d");
                        Datos[4] = rs.getString("fecha_m");
                        Datos[5] = rs.getString("fecha_a");
                        Datos[6] = rs.getString("hora");
                        Datos[7] = rs.getString("minuto");
                        Datos[8] = rs.getString("lugar");
                        Datos[9] = rs.getString("estado");

                        Aprobar.addRow(Datos);
            }
            tblAprSolicitud.setModel(Aprobar);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    boolean ValidarLetras(String palabra){
        for(int i = 0; i < palabra.length(); i++){
            if(!((palabra.charAt(i) > 64 && palabra.charAt(i) < 91) || (palabra.charAt(i) > 96 && palabra.charAt(i) < 123)))
                return false;
        }
        return true;
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
        txtNumAprSolicitud.setText("");
        txtNumAprBusSolicitud.setText("");
        cboEstAprSolicitud.setSelectedItem("Seleccione");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitAprSolicitud = new javax.swing.JLabel();
        pnlSolAprSolicitud = new javax.swing.JPanel();
        scpAprSolicitud = new javax.swing.JScrollPane();
        tblAprSolicitud = new javax.swing.JTable();
        btnBusAprSolicitud = new javax.swing.JButton();
        lblNumAprBusSolicitud = new javax.swing.JLabel();
        txtNumAprBusSolicitud = new javax.swing.JTextField();
        pnlAprAprSolicitud = new javax.swing.JPanel();
        cboEstAprSolicitud = new javax.swing.JComboBox();
        lblEstAprSolicitud = new javax.swing.JLabel();
        btnGuardarAprSolicitud = new javax.swing.JButton();
        btnCancelarAprSolicitud = new javax.swing.JButton();
        btnSalirAprSolicitud = new javax.swing.JButton();
        lblIconoAprSolicitud = new javax.swing.JLabel();
        txtNumAprSolicitud = new javax.swing.JTextField();
        lblNumAprSolicitud = new javax.swing.JLabel();
        lblNumAprrSolicitud = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AVENDAÑO AGENCIA DE SEGUROS");
        setName("frmAprSolicitud"); // NOI18N

        lblTitAprSolicitud.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitAprSolicitud.setText("APROBAR SOLICITUD");

        pnlSolAprSolicitud.setBackground(new java.awt.Color(79, 157, 157));
        pnlSolAprSolicitud.setBorder(javax.swing.BorderFactory.createTitledBorder("Solicitudes"));

        scpAprSolicitud.setViewportView(tblAprSolicitud);

        btnBusAprSolicitud.setBackground(new java.awt.Color(79, 157, 157));
        btnBusAprSolicitud.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBusAprSolicitud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        btnBusAprSolicitud.setText("BUSCAR");
        btnBusAprSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusAprSolicitudActionPerformed(evt);
            }
        });

        lblNumAprBusSolicitud.setText("Número de Solicitud ");

        txtNumAprBusSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumAprBusSolicitudActionPerformed(evt);
            }
        });
        txtNumAprBusSolicitud.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumAprBusSolicitudKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout pnlSolAprSolicitudLayout = new javax.swing.GroupLayout(pnlSolAprSolicitud);
        pnlSolAprSolicitud.setLayout(pnlSolAprSolicitudLayout);
        pnlSolAprSolicitudLayout.setHorizontalGroup(
            pnlSolAprSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSolAprSolicitudLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblNumAprBusSolicitud)
                .addGap(18, 18, 18)
                .addComponent(txtNumAprBusSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(btnBusAprSolicitud)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlSolAprSolicitudLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scpAprSolicitud, javax.swing.GroupLayout.DEFAULT_SIZE, 999, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlSolAprSolicitudLayout.setVerticalGroup(
            pnlSolAprSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSolAprSolicitudLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(pnlSolAprSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumAprBusSolicitud)
                    .addComponent(txtNumAprBusSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBusAprSolicitud))
                .addGap(10, 10, 10)
                .addComponent(scpAprSolicitud, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlAprAprSolicitud.setBackground(new java.awt.Color(79, 157, 157));
        pnlAprAprSolicitud.setBorder(javax.swing.BorderFactory.createTitledBorder("Aprobar - Rechazar"));

        cboEstAprSolicitud.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "APROBADO", "RECHAZADO" }));

        lblEstAprSolicitud.setText("Estado Solicitud");

        javax.swing.GroupLayout pnlAprAprSolicitudLayout = new javax.swing.GroupLayout(pnlAprAprSolicitud);
        pnlAprAprSolicitud.setLayout(pnlAprAprSolicitudLayout);
        pnlAprAprSolicitudLayout.setHorizontalGroup(
            pnlAprAprSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAprAprSolicitudLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblEstAprSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboEstAprSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlAprAprSolicitudLayout.setVerticalGroup(
            pnlAprAprSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAprAprSolicitudLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAprAprSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstAprSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboEstAprSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGuardarAprSolicitud.setBackground(new java.awt.Color(79, 157, 157));
        btnGuardarAprSolicitud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        btnGuardarAprSolicitud.setText("GUARDAR");
        btnGuardarAprSolicitud.setMaximumSize(new java.awt.Dimension(122, 33));
        btnGuardarAprSolicitud.setMinimumSize(new java.awt.Dimension(122, 33));
        btnGuardarAprSolicitud.setPreferredSize(new java.awt.Dimension(122, 33));
        btnGuardarAprSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAprSolicitudActionPerformed(evt);
            }
        });

        btnCancelarAprSolicitud.setBackground(new java.awt.Color(79, 157, 157));
        btnCancelarAprSolicitud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar.png"))); // NOI18N
        btnCancelarAprSolicitud.setText("CANCELAR");
        btnCancelarAprSolicitud.setMaximumSize(new java.awt.Dimension(122, 33));
        btnCancelarAprSolicitud.setMinimumSize(new java.awt.Dimension(122, 33));
        btnCancelarAprSolicitud.setPreferredSize(new java.awt.Dimension(122, 33));
        btnCancelarAprSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAprSolicitudActionPerformed(evt);
            }
        });

        btnSalirAprSolicitud.setBackground(new java.awt.Color(79, 157, 157));
        btnSalirAprSolicitud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida.png"))); // NOI18N
        btnSalirAprSolicitud.setText("SALIR");
        btnSalirAprSolicitud.setMaximumSize(new java.awt.Dimension(122, 33));
        btnSalirAprSolicitud.setMinimumSize(new java.awt.Dimension(122, 33));
        btnSalirAprSolicitud.setPreferredSize(new java.awt.Dimension(122, 33));
        btnSalirAprSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirAprSolicitudActionPerformed(evt);
            }
        });

        lblIconoAprSolicitud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/aprobar.png"))); // NOI18N

        txtNumAprSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumAprSolicitudActionPerformed(evt);
            }
        });
        txtNumAprSolicitud.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumAprSolicitudKeyTyped(evt);
            }
        });

        lblNumAprSolicitud.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNumAprSolicitud.setText("Ingrese el Número de Solicitud ");

        lblNumAprrSolicitud.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNumAprrSolicitud.setText("que desea Aprobar/Rechazar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlSolAprSolicitud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblIconoAprSolicitud)
                                .addGap(285, 285, 285)
                                .addComponent(lblTitAprSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNumAprrSolicitud)
                                    .addComponent(lblNumAprSolicitud))
                                .addGap(18, 18, 18)
                                .addComponent(txtNumAprSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pnlAprAprSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(295, 295, 295)
                                .addComponent(btnGuardarAprSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(btnCancelarAprSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(btnSalirAprSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIconoAprSolicitud)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(lblTitAprSolicitud)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSolAprSolicitud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlAprAprSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNumAprSolicitud)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNumAprrSolicitud))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(txtNumAprSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarAprSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarAprSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalirAprSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBusAprSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusAprSolicitudActionPerformed
        // TODO add your handling code here:
        String Solicitud = txtNumAprBusSolicitud.getText();
        if(ValidarNum(Solicitud)==false){
            JOptionPane.showMessageDialog(null, "Campos llenos de manera incorrecta");
        }
        else{
            Borrar();
            CargarTabla(Solicitud);
        }
    }//GEN-LAST:event_btnBusAprSolicitudActionPerformed

    private void btnGuardarAprSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAprSolicitudActionPerformed
        // TODO add your handling code here:
        try
        {
            String sSQL="";
            String Mensaje="";
            
            String Estado = cboEstAprSolicitud.getSelectedItem().toString();
            String Numero = txtNumAprSolicitud.getText();
            ConexionMySQL mysql = new ConexionMySQL();
            Connection cn = mysql.Conectar();
            
            if(Numero.equals("")||Estado.equals("-----------")){
                JOptionPane.showMessageDialog(null, "Llene todos los campos requeridos");
            }
            else{
                if(ValidarNum(Numero)==false||ValidarLetras(Estado)==false){
                    JOptionPane.showMessageDialog(null, "Campos llenos de manera incorrecta");
                }
                else{

                        sSQL = "UPDATE solicitud SET estado = '"+Estado+"'"
                        + "WHERE num_solicitud = '"+Numero+"'";

                        Statement st = cn.createStatement();
                        st.executeUpdate(sSQL);
                        
                        Mensaje ="DATOS GUARDADOS DE FORMA CORRECTA";
                        JOptionPane.showMessageDialog(null, Mensaje);
                        String Informacion = lblIconoAprSolicitud.getText();
                        CargarTabla(Informacion);
                        
                        }    
                Borrar();
                
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Seleccione un estado de solicitud");
        }
        txtNumAprSolicitud.setText("");
        
    }//GEN-LAST:event_btnGuardarAprSolicitudActionPerformed

    private void btnSalirAprSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirAprSolicitudActionPerformed
        // TODO add your handling code here:
        this.dispose();
        //gerente gerenteJF =new gerente();
        //gerenteJF.setVisible(true);
    }//GEN-LAST:event_btnSalirAprSolicitudActionPerformed

    private void txtNumAprSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumAprSolicitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumAprSolicitudActionPerformed

    private void btnCancelarAprSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAprSolicitudActionPerformed
        // TODO add your handling code here:
        Borrar();
    }//GEN-LAST:event_btnCancelarAprSolicitudActionPerformed

    private void txtNumAprBusSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumAprBusSolicitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumAprBusSolicitudActionPerformed

    private void txtNumAprBusSolicitudKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumAprBusSolicitudKeyTyped
        // TODO add your handling code here:
        txtNumAprBusSolicitud.addKeyListener(new KeyAdapter() {
             
            public void keyReleased(final KeyEvent e) {
            String cadena = (txtNumAprBusSolicitud.getText()).trim();
            txtNumAprBusSolicitud.setText(cadena);
            repaint();
            filtro();
        }
        });
            tr = new TableRowSorter(tblAprSolicitud.getModel());
            tblAprSolicitud.setRowSorter(tr);
    }//GEN-LAST:event_txtNumAprBusSolicitudKeyTyped

    private void txtNumAprSolicitudKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumAprSolicitudKeyTyped
        // TODO add your handling code here:
        txtNumAprSolicitud.addKeyListener(new KeyAdapter() {
             
            public void keyReleased(final KeyEvent e) {
            String cadena = (txtNumAprSolicitud.getText()).trim();
            txtNumAprSolicitud.setText(cadena);
            repaint();
            filtrouno();
        }
        });
            tr = new TableRowSorter(tblAprSolicitud.getModel());
            tblAprSolicitud.setRowSorter(tr);
    }//GEN-LAST:event_txtNumAprSolicitudKeyTyped

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
            java.util.logging.Logger.getLogger(AprSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AprSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AprSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AprSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AprSolicitud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusAprSolicitud;
    private javax.swing.JButton btnCancelarAprSolicitud;
    private javax.swing.JButton btnGuardarAprSolicitud;
    private javax.swing.JButton btnSalirAprSolicitud;
    private javax.swing.JComboBox cboEstAprSolicitud;
    private javax.swing.JLabel lblEstAprSolicitud;
    private javax.swing.JLabel lblIconoAprSolicitud;
    private javax.swing.JLabel lblNumAprBusSolicitud;
    private javax.swing.JLabel lblNumAprSolicitud;
    private javax.swing.JLabel lblNumAprrSolicitud;
    private javax.swing.JLabel lblTitAprSolicitud;
    private javax.swing.JPanel pnlAprAprSolicitud;
    private javax.swing.JPanel pnlSolAprSolicitud;
    private javax.swing.JScrollPane scpAprSolicitud;
    private javax.swing.JTable tblAprSolicitud;
    private javax.swing.JTextField txtNumAprBusSolicitud;
    private javax.swing.JTextField txtNumAprSolicitud;
    // End of variables declaration//GEN-END:variables
}
