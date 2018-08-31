package formularios;


import clases.SessionAvendano;
import conexion.ConexionMySQL;
import com.sun.glass.events.KeyEvent;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.net.URL;
import java.security.Principal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Richard
 */
public class IngresoSistema extends javax.swing.JFrame {

    /**
     * Creates new form Usuarios
     */
    public IngresoSistema() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(79,157,157));
        //ImageIcon imagen1 = new ImageIcon ("src/Imagenes/iconoInicio1.jpg");
        //ImageIcon imagen1 = new ImageIcon ("null");
        //ImageIcon imagen2 = new ImageIcon ("src/Imagenes/iconoInicio.jpg");
        //Icon fondo1 = new ImageIcon (imagen1.getImage().getScaledInstance(lblFondop.getWidth(),lblFondop.getHeight(), Image.SCALE_DEFAULT));
        //Icon fondo2 = new ImageIcon (imagen2.getImage().getScaledInstance(lblFondoIng.getWidth(),lblFondoIng.getHeight(), Image.SCALE_DEFAULT));
        //lblFondop.setIcon(fondo1);
        //lblFondoIng.setIcon(fondo2);
        this.repaint();     
    }
    
     void acceder(String usuario, String pass)
    {
        
        String cap="";
        String sql="SELECT * FROM usuario WHERE nick='"+usuario+"' && password='"+pass+"'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                cap=rs.getString("tipo_usuario");
            }
            if(cap.equals("Administrador"))
            {
                  this.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Bienvenido");
                    MenuAdmin ingreso = new MenuAdmin();
                    ingreso.setVisible(true);
                    ingreso.pack();
                    MenuAdmin.lblUsuAdmConectado.setText(usuario);
                    SessionAvendano.nickSession=usuario;
        
                
            }
            if(cap.equals("Agente"))
            {
                this.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Bienvenido");
                    MenuUsuario ingresos = new MenuUsuario();
                    ingresos.setVisible(true);
                    ingresos.pack();
                    MenuUsuario.lblUsuUsuConectado.setText(usuario);
                    SessionAvendano.nickSession=usuario;
            }
            if((!cap.equals("Administrador"))&& (!cap.equals("Agente")))
            {
                JOptionPane.showMessageDialog(this, "No existe sus datos");
            }
            Borrar ();
        } catch (SQLException ex) {
            Logger.getLogger(IngresoSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        }
     void Borrar()
    {
      
        txtPassword.setText("");
        txtUsuario.setText("");
        
    }
       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDatosIngreso = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnCancelarIng = new javax.swing.JButton();
        lblFondoIng = new javax.swing.JLabel();
        btnIngresarIng = new javax.swing.JButton();
        lblTituloProducto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AVENDAÑO AGENCIA DE SEGUROS");
        setBackground(new java.awt.Color(0, 153, 153));
        setMinimumSize(new java.awt.Dimension(400, 300));
        setName("frmInicioSesion"); // NOI18N

        pnlDatosIngreso.setBackground(new java.awt.Color(79, 157, 157));
        pnlDatosIngreso.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingreso Del Usuario"));
        pnlDatosIngreso.setLayout(null);

        lblUsuario.setText("Usuario");
        pnlDatosIngreso.add(lblUsuario);
        lblUsuario.setBounds(20, 50, 70, 14);

        lblPassword.setText("Contraseña");
        pnlDatosIngreso.add(lblPassword);
        lblPassword.setBounds(20, 90, 70, 14);

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        pnlDatosIngreso.add(txtUsuario);
        txtUsuario.setBounds(100, 50, 110, 27);

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        pnlDatosIngreso.add(txtPassword);
        txtPassword.setBounds(100, 90, 110, 27);

        btnCancelarIng.setBackground(new java.awt.Color(79, 157, 157));
        btnCancelarIng.setText("CANCELAR");
        btnCancelarIng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarIngActionPerformed(evt);
            }
        });

        lblFondoIng.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/contrasena.png"))); // NOI18N

        btnIngresarIng.setBackground(new java.awt.Color(79, 157, 157));
        btnIngresarIng.setText("INGRESAR");
        btnIngresarIng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarIngActionPerformed(evt);
            }
        });

        lblTituloProducto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTituloProducto.setText("INGRESO AL SISTEMA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblFondoIng)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTituloProducto)
                .addGap(0, 15, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(btnIngresarIng)
                        .addGap(28, 28, 28)
                        .addComponent(btnCancelarIng))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(pnlDatosIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFondoIng)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(lblTituloProducto)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDatosIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresarIng)
                    .addComponent(btnCancelarIng))
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
        //txtPassword.transferFocus();
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:\
        txtUsuario.transferFocus();
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnCancelarIngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarIngActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnCancelarIngActionPerformed

    private void btnIngresarIngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarIngActionPerformed
        // TODO add your handling code here:
        String usu=txtUsuario.getText();
        String pas=new String(txtPassword.getPassword());
        acceder(usu, pas);
                
    }//GEN-LAST:event_btnIngresarIngActionPerformed

    
    
    
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
            java.util.logging.Logger.getLogger(IngresoSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresoSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresoSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresoSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresoSistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarIng;
    private javax.swing.JButton btnIngresarIng;
    private javax.swing.JLabel lblFondoIng;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTituloProducto;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlDatosIngreso;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
ConexionMySQL cc= new ConexionMySQL();
Connection cn = cc.Conectar();
}

