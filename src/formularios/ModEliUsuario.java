/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import conexion.ConexionMySQL;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Richard
 */
public class ModEliUsuario extends javax.swing.JFrame {
DefaultTableModel Usuario;
private TableRowSorter tr;
    /**
     * Creates new form ModEliUsuario
     */
    public ModEliUsuario() {
        initComponents();
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(79,157,157));
        tblUsuario.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
    
         @Override
         public void valueChanged(ListSelectionEvent e){
             if(tblUsuario.getSelectedRow() != -1)
         {
             
            int fila = tblUsuario.getSelectedRow();
            txtNickLogEmp.setText(tblUsuario.getValueAt(fila, 0).toString());
            txtPassLogEmp.setText(tblUsuario.getValueAt(fila, 1).toString());
            cboTipLogEmp.setSelectedItem(tblUsuario.getValueAt(fila, 2));  
     }
    }
    });
    }
    
    
 void CargarTabla(String Informacion)
    {
        try
        {
            String sSQL="";
            String[] Titulos = {"EMPLEADO","USUARIO","CONTRASEÑA","TIPO USUARIO"};
            String[] Datos = new String[7];

            Usuario = new DefaultTableModel(null,Titulos);

            ConexionMySQL mysql = new ConexionMySQL();
            Connection cn = mysql.Conectar();

            sSQL = "SELECT  nick, password , tipo_usuario   FROM usuario "
                    /*+ "WHERE CONCAT(ci_emp) LIKE '%"+Informacion+"%'"*/;

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while(rs.next())
            {
                        //Datos[0]=rs.getString("ci_emp");
                        Datos[0]=rs.getString("nick");
                        Datos[1]=rs.getString("password");
                        Datos[2]=rs.getString("tipo_usuario");
                        
                         Usuario.addRow(Datos);

            }
            tblUsuario.setModel(Usuario);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
   
      void CargarDatos(String Datos_Producto)
     {
        try
        {
            String sSQL="";
            //String Propietario = cboCedLogEmp.getSelectedItem().toString();
            String Nick_E = "";
            String Pass = "";
            String Tipo = "";

            ConexionMySQL mysql = new ConexionMySQL();
            Connection cn = mysql.Conectar();

            sSQL = "SELECT nick, password, tipo_usuario FROM usuario "
                    + "WHERE CONCAT(nick) LIKE '%"+Datos_Producto+"%'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while(rs.next())
            {
                Nick_E = rs.getString("nick");
                Pass = rs.getString("password");
               
            }
            txtNickLogEmp.setText(Nick_E);
            txtPassLogEmp.setText(Pass);
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
     public void setTxtCodEmpMod(JTextField txtNickLogEmp) {
        this.txtNickLogEmp = txtNickLogEmp;
    }

    void Borrar()
    {
            txtNickLogEmp.setText("");
            txtPassLogEmp.setText("");
            //txtModeloModPro.setText("");
            
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitModUsu = new javax.swing.JLabel();
        lblIconoModUsu = new javax.swing.JLabel();
        pnlLogEmp = new javax.swing.JPanel();
        lblNickLogEmp = new javax.swing.JLabel();
        lblPassLogEmp = new javax.swing.JLabel();
        lblTipLogEmp = new javax.swing.JLabel();
        txtNickLogEmp = new javax.swing.JTextField();
        cboTipLogEmp = new javax.swing.JComboBox();
        txtPassLogEmp = new javax.swing.JPasswordField();
        btnModModEmp = new javax.swing.JButton();
        btnEliUsu = new javax.swing.JButton();
        btnSalEliPro = new javax.swing.JButton();
        pnlMosModUsu = new javax.swing.JPanel();
        btnMosUsu = new javax.swing.JButton();
        scpLogEmp = new javax.swing.JScrollPane();
        tblUsuario = new javax.swing.JTable();
        btnMostarModPro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitModUsu.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitModUsu.setText("LISTA DE USUARIOS");

        lblIconoModUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario.png"))); // NOI18N

        pnlLogEmp.setBackground(new java.awt.Color(79, 157, 157));
        pnlLogEmp.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuevo Usuario"));

        lblNickLogEmp.setText("Usuario *");

        lblPassLogEmp.setText("Contraseña *");

        lblTipLogEmp.setText("Tipo de Usuario *");

        cboTipLogEmp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Administrador", "Agente", " " }));
        cboTipLogEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipLogEmpActionPerformed(evt);
            }
        });

        txtPassLogEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassLogEmpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLogEmpLayout = new javax.swing.GroupLayout(pnlLogEmp);
        pnlLogEmp.setLayout(pnlLogEmpLayout);
        pnlLogEmpLayout.setHorizontalGroup(
            pnlLogEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogEmpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLogEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNickLogEmp)
                    .addComponent(lblPassLogEmp)
                    .addComponent(lblTipLogEmp))
                .addGap(27, 27, 27)
                .addGroup(pnlLogEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPassLogEmp)
                    .addComponent(txtNickLogEmp)
                    .addComponent(cboTipLogEmp, 0, 117, Short.MAX_VALUE))
                .addGap(0, 28, Short.MAX_VALUE))
        );
        pnlLogEmpLayout.setVerticalGroup(
            pnlLogEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogEmpLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pnlLogEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNickLogEmp)
                    .addComponent(txtNickLogEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlLogEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassLogEmp)
                    .addComponent(txtPassLogEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlLogEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipLogEmp)
                    .addComponent(cboTipLogEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        btnModModEmp.setBackground(new java.awt.Color(79, 157, 157));
        btnModModEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/modificar.png"))); // NOI18N
        btnModModEmp.setText("MODIFICAR");
        btnModModEmp.setMaximumSize(new java.awt.Dimension(122, 33));
        btnModModEmp.setMinimumSize(new java.awt.Dimension(122, 33));
        btnModModEmp.setPreferredSize(new java.awt.Dimension(122, 33));
        btnModModEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModModEmpActionPerformed(evt);
            }
        });

        btnEliUsu.setBackground(new java.awt.Color(79, 157, 157));
        btnEliUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/x.png"))); // NOI18N
        btnEliUsu.setText("ELIMINAR");
        btnEliUsu.setMaximumSize(new java.awt.Dimension(147, 33));
        btnEliUsu.setMinimumSize(new java.awt.Dimension(147, 33));
        btnEliUsu.setPreferredSize(new java.awt.Dimension(147, 33));
        btnEliUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliUsuActionPerformed(evt);
            }
        });

        btnSalEliPro.setBackground(new java.awt.Color(79, 157, 157));
        btnSalEliPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida.png"))); // NOI18N
        btnSalEliPro.setText("SALIR");
        btnSalEliPro.setMaximumSize(new java.awt.Dimension(147, 33));
        btnSalEliPro.setMinimumSize(new java.awt.Dimension(147, 33));
        btnSalEliPro.setPreferredSize(new java.awt.Dimension(147, 33));
        btnSalEliPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalEliProActionPerformed(evt);
            }
        });

        pnlMosModUsu.setBackground(new java.awt.Color(79, 157, 157));
        pnlMosModUsu.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Producto"));

        btnMosUsu.setBackground(new java.awt.Color(79, 157, 157));
        btnMosUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cargar.png"))); // NOI18N
        btnMosUsu.setText("MOSTRAR DATOS");
        btnMosUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMosUsuActionPerformed(evt);
            }
        });

        tblUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scpLogEmp.setViewportView(tblUsuario);

        javax.swing.GroupLayout pnlMosModUsuLayout = new javax.swing.GroupLayout(pnlMosModUsu);
        pnlMosModUsu.setLayout(pnlMosModUsuLayout);
        pnlMosModUsuLayout.setHorizontalGroup(
            pnlMosModUsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMosModUsuLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnMosUsu)
                .addContainerGap(290, Short.MAX_VALUE))
            .addGroup(pnlMosModUsuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scpLogEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlMosModUsuLayout.setVerticalGroup(
            pnlMosModUsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMosModUsuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMosUsu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpLogEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        btnMostarModPro.setBackground(new java.awt.Color(79, 157, 157));
        btnMostarModPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mostrar.png"))); // NOI18N
        btnMostarModPro.setText("MOSTRAR");
        btnMostarModPro.setMaximumSize(new java.awt.Dimension(122, 33));
        btnMostarModPro.setMinimumSize(new java.awt.Dimension(122, 33));
        btnMostarModPro.setPreferredSize(new java.awt.Dimension(122, 33));
        btnMostarModPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostarModProActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(pnlLogEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnModModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMostarModPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalEliPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(pnlMosModUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblIconoModUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(lblTitModUsu)))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIconoModUsu)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(lblTitModUsu)))
                .addGap(4, 4, 4)
                .addComponent(pnlMosModUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlLogEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalEliPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMostarModPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboTipLogEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipLogEmpActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cboTipLogEmpActionPerformed

    private void txtPassLogEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassLogEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassLogEmpActionPerformed

    private void btnModModEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModModEmpActionPerformed
        // TODO add your handling code here:

        int Pregunta;
        Pregunta = JOptionPane.showConfirmDialog(null,"Desea Modifiacar Los Datos","Pregunta" ,0);
        if (Pregunta==0)
        {
            try
            {
                String sSQL="";
                String Mensaje="";

               
                String Nick_E = txtNickLogEmp.getText();
                String Pass = new String (txtPassLogEmp.getPassword());
                String Tipo = cboTipLogEmp.getSelectedItem().toString();

                ConexionMySQL mysql = new ConexionMySQL();
                Connection cn = mysql.Conectar();

                if(Nick_E.equals("")||Pass.equals("")||Tipo.equals("")){
                    JOptionPane.showMessageDialog(null, "Llene todos los campos requeridos");
                }

                else{
                    if(ValidarLetras(Tipo)==false||ValidarLetras(Nick_E)==false){
                        JOptionPane.showMessageDialog(null, "Campos llenos de manera incorrecta----");
                    }

                    else{

                        sSQL = "UPDATE usuario SET nick = '"+Nick_E+"', password = '"+Pass+"', tipo_usuario='"+Tipo+"''";
                        //sSQL = sSQL+ "WHERE ni = '"+Propietario+"'";

                        Mensaje ="DATOS MODIFICADOS DE FORMA CORRECTA";

                        Statement st = cn.createStatement();
                        int n = st.executeUpdate(sSQL);

                        if(n>0)
                        {
                            JOptionPane.showMessageDialog(null, Mensaje);
                        }
                        String Informacion = lblIconoModUsu.getText();
                        CargarTabla(Informacion);
                        Borrar();

                    }
                }

            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btnModModEmpActionPerformed

    private void btnEliUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliUsuActionPerformed
        // TODO add your handling code here:
        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.Conectar();
        int fila= tblUsuario.getSelectedRow();
        if(fila<0)
        {
            JOptionPane.showMessageDialog(this, "Seleccione alguna fila");
        }
        else
        {
            int Pregunta;
            Pregunta = JOptionPane.showConfirmDialog(null,"Desea Eliminar Los Datos","Pregunta" ,0);
            if (Pregunta==0)
            {
                idfila= tblUsuario.getValueAt(fila, 0).toString();
                String eli="DELETE FROM usuario WHERE ci_emp = '"+idfila+"'";
                PreparedStatement pst;
                try
                {
                    pst = cn.prepareStatement(eli);
                    int m=pst.executeUpdate();
                    if(m>0)
                    {
                        JOptionPane.showMessageDialog(this, "ELIMINO LOS DATOS DE FORMA CORRECTA");
                        String Informacion = lblIconoModUsu.getText();
                        CargarTabla(Informacion);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "No se pudo eliminar");
                        String Informacion = lblIconoModUsu.getText();
                        CargarTabla(Informacion);
                    }

                } catch (SQLException ex)
                {
                    Logger.getLogger(EliProducto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnEliUsuActionPerformed

    private void btnSalEliProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalEliProActionPerformed
        // TODO add your handling code here:
        this.dispose();
        //MenuUsuario MenuUsuarioJF = new MenuUsuario();
        //MenuUsuarioJF.setVisible(true);
    }//GEN-LAST:event_btnSalEliProActionPerformed

    private void btnMosUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMosUsuActionPerformed
        // TODO add your handling code here:
       String Informacion = lblIconoModUsu.getText();
        CargarTabla(Informacion);
    }//GEN-LAST:event_btnMosUsuActionPerformed

    private void btnMostarModProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostarModProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMostarModProActionPerformed

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
            java.util.logging.Logger.getLogger(ModEliUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModEliUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModEliUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModEliUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModEliUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliUsu;
    private javax.swing.JButton btnModModEmp;
    private javax.swing.JButton btnMosUsu;
    private javax.swing.JButton btnMostarModPro;
    private javax.swing.JButton btnSalEliPro;
    private javax.swing.JComboBox cboTipLogEmp;
    private javax.swing.JLabel lblIconoModUsu;
    private javax.swing.JLabel lblNickLogEmp;
    private javax.swing.JLabel lblPassLogEmp;
    private javax.swing.JLabel lblTipLogEmp;
    private javax.swing.JLabel lblTitModUsu;
    private javax.swing.JPanel pnlLogEmp;
    private javax.swing.JPanel pnlMosModUsu;
    private javax.swing.JScrollPane scpLogEmp;
    private javax.swing.JTable tblUsuario;
    private javax.swing.JTextField txtNickLogEmp;
    private javax.swing.JPasswordField txtPassLogEmp;
    // End of variables declaration//GEN-END:variables
String idfila="";
}
