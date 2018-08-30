package formularios;


import conexion.ConexionMySQL;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
public class ModAseguradora extends javax.swing.JFrame {
    DefaultTableModel tabla;
    private TableRowSorter tr;

    /**
     * Creates new form ModAseguradoras
     */
    public ModAseguradora() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(79,157,157));
        tblModificarAse.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
    
         @Override
         public void valueChanged(ListSelectionEvent e){
             if(tblModificarAse.getSelectedRow() != -1)
         {
             
            int fila = tblModificarAse.getSelectedRow();
            txtCodEmpMod.setText(tblModificarAse.getValueAt(fila, 0).toString());
            txtNomEmpMod.setText(tblModificarAse.getValueAt(fila, 1).toString());
            txtGerMod.setText(tblModificarAse.getValueAt(fila, 2).toString());  
            txtCiuMod.setText(tblModificarAse.getValueAt(fila, 3).toString()); 
            txtDirMod.setText(tblModificarAse.getValueAt(fila, 4).toString());
            txtTelMod.setText(tblModificarAse.getValueAt(fila, 5).toString());
            txtMailMod.setText(tblModificarAse.getValueAt(fila, 6).toString());
                  
           
     }
    }
    });
    }
     public void filtro() {
    tr.setRowFilter(RowFilter.regexFilter(txtCodEmpMod.getText(), 0));
    }
    void CargarTabla(String datos)
    {
        String[] Titulos = {"CÓDIGO" ,"NOMBRE","GERENTE", "CIUDAD", "DIRECCIÓN", "TELÉFONO", "E-MAIL"};
        String[] Informacion = new String[7];

        String sSQL="";

        tabla = new DefaultTableModel(null,Titulos);

        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.Conectar();

        sSQL = "SELECT cod_emp, nom_emp, ger, ciu, dir, telf, mail FROM aseguradora " + "WHERE CONCAT(cod_emp) LIKE '%"+datos+"%'";

        try
        {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while(rs.next())
            {
                Informacion[0] = rs.getString("cod_emp");
                Informacion[1] = rs.getString("nom_emp");
                Informacion[2] = rs.getString("ger");
                Informacion[3] = rs.getString("ciu");
                Informacion[4] = rs.getString("dir");
                Informacion[5] = rs.getString("telf");
                Informacion[6] = rs.getString("mail");

                tabla.addRow(Informacion);
            }
            tblModificarAse.setModel(tabla);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }


    }

    void CargarDatos(String Informacion)
    {
        try
        {
            String sSQL="";
            String Codigo_Emp="";
            String Nombre_Emp="";
            String Ciudad="";
            String Direccion="";
            String Gerente="";
            String Telefono="";
            String Mail="";

            ConexionMySQL mysql = new ConexionMySQL();
            Connection cn = mysql.Conectar();

            sSQL = "SELECT cod_emp, nom_emp, ciu, dir, ger, telf, mail FROM aseguradora " + "WHERE CONCAT(cod_emp) LIKE '%"+Informacion+"%'";

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while(rs.next())
            {
                Codigo_Emp = rs.getString("cod_emp");
                Nombre_Emp = rs.getString("nom_emp");
                Ciudad = rs.getString("ciu");
                Direccion = rs.getString("dir");
                Gerente = rs.getString("ger");
                Telefono = rs.getString("telf");
                Mail = rs.getString("mail");
            }
            
            txtCodEmpMod.setText( Codigo_Emp);
            txtNomEmpMod.setText( Nombre_Emp);
            txtCiuMod.setText( Ciudad);
            txtDirMod.setText( Direccion);
            txtGerMod.setText( Gerente);
            txtTelMod.setText( Telefono);
            txtMailMod.setText( Mail);

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void setTxtCodEmpMod(JTextField txtCodEmpMod) {
        this.txtCodEmpMod = txtCodEmpMod;
    }

    void Borrar()
    {
        txtCodEmpMod.setText("");
        txtNomEmpMod.setText("");
        txtCiuMod.setText("");
        txtDirMod.setText("");
        txtGerMod.setText("");
        txtTelMod.setText("");
        txtMailMod.setText("");
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

        lblIconoMod = new javax.swing.JLabel();
        lblTituloModAse = new javax.swing.JLabel();
        pnlMosAseguradoras = new javax.swing.JPanel();
        scpModMosAse = new javax.swing.JScrollPane();
        tblModificarAse = new javax.swing.JTable();
        btnModMosAse = new javax.swing.JButton();
        pnlDatosModAse = new javax.swing.JPanel();
        lblNomEmpMod = new javax.swing.JLabel();
        lblCiuMod = new javax.swing.JLabel();
        lblDirMod = new javax.swing.JLabel();
        lblGerMod = new javax.swing.JLabel();
        lblTelMod = new javax.swing.JLabel();
        lblMailMod = new javax.swing.JLabel();
        txtNomEmpMod = new javax.swing.JTextField();
        txtCiuMod = new javax.swing.JTextField();
        txtDirMod = new javax.swing.JTextField();
        txtGerMod = new javax.swing.JTextField();
        lblCodEmpMod = new javax.swing.JLabel();
        txtCodEmpMod = new javax.swing.JTextField();
        txtTelMod = new javax.swing.JTextField();
        txtMailMod = new javax.swing.JTextField();
        btnModAse = new javax.swing.JButton();
        btnMostarModAse = new javax.swing.JButton();
        btnCancelarModAse = new javax.swing.JButton();
        btnSalirModAse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AVENDAÑO AGENCIA DE SEGUROS");
        setName("frmModAseguradoras"); // NOI18N

        lblIconoMod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/empresa.png"))); // NOI18N

        lblTituloModAse.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblTituloModAse.setText("MODIFICAR DATOS DE LA ASEGURADORA");

        pnlMosAseguradoras.setBackground(new java.awt.Color(79, 157, 157));
        pnlMosAseguradoras.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Empresa"));

        tblModificarAse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scpModMosAse.setViewportView(tblModificarAse);

        btnModMosAse.setBackground(new java.awt.Color(79, 157, 157));
        btnModMosAse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cargar.png"))); // NOI18N
        btnModMosAse.setText("MOSTRAR DATOS");
        btnModMosAse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModMosAseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMosAseguradorasLayout = new javax.swing.GroupLayout(pnlMosAseguradoras);
        pnlMosAseguradoras.setLayout(pnlMosAseguradorasLayout);
        pnlMosAseguradorasLayout.setHorizontalGroup(
            pnlMosAseguradorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMosAseguradorasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMosAseguradorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnModMosAse)
                    .addComponent(scpModMosAse, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMosAseguradorasLayout.setVerticalGroup(
            pnlMosAseguradorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMosAseguradorasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnModMosAse)
                .addGap(18, 18, 18)
                .addComponent(scpModMosAse, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDatosModAse.setBackground(new java.awt.Color(79, 157, 157));
        pnlDatosModAse.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Empresas Aseguradoras"));

        lblNomEmpMod.setText("Nombre Empresa *");

        lblCiuMod.setText("Ciudad *");

        lblDirMod.setText("Dirección *");

        lblGerMod.setText("Gerente *");

        lblTelMod.setText("Teléfono *");

        lblMailMod.setText("E-Mail *");

        txtNomEmpMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomEmpModActionPerformed(evt);
            }
        });
        txtNomEmpMod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomEmpModKeyTyped(evt);
            }
        });

        txtCiuMod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCiuModKeyTyped(evt);
            }
        });

        txtDirMod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDirModKeyTyped(evt);
            }
        });

        txtGerMod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGerModKeyTyped(evt);
            }
        });

        lblCodEmpMod.setText("Código Empresa *");

        txtCodEmpMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodEmpModActionPerformed(evt);
            }
        });
        txtCodEmpMod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodEmpModKeyTyped(evt);
            }
        });

        txtMailMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMailModActionPerformed(evt);
            }
        });
        txtMailMod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMailModKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout pnlDatosModAseLayout = new javax.swing.GroupLayout(pnlDatosModAse);
        pnlDatosModAse.setLayout(pnlDatosModAseLayout);
        pnlDatosModAseLayout.setHorizontalGroup(
            pnlDatosModAseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosModAseLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(pnlDatosModAseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCodEmpMod)
                    .addComponent(lblNomEmpMod)
                    .addComponent(lblCiuMod)
                    .addComponent(lblDirMod))
                .addGap(31, 31, 31)
                .addGroup(pnlDatosModAseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtCiuMod, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtNomEmpMod, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDirMod)
                    .addComponent(txtCodEmpMod, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(74, 74, 74)
                .addGroup(pnlDatosModAseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosModAseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblGerMod, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTelMod, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblMailMod, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosModAseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMailMod, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtTelMod)
                    .addComponent(txtGerMod, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        pnlDatosModAseLayout.setVerticalGroup(
            pnlDatosModAseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosModAseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosModAseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlDatosModAseLayout.createSequentialGroup()
                        .addGroup(pnlDatosModAseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGerMod)
                            .addComponent(txtGerMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDatosModAseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelMod)
                            .addComponent(txtTelMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDatosModAseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMailMod)
                            .addComponent(txtMailMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlDatosModAseLayout.createSequentialGroup()
                        .addGroup(pnlDatosModAseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodEmpMod)
                            .addComponent(txtCodEmpMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(pnlDatosModAseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNomEmpMod)
                            .addComponent(txtNomEmpMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDatosModAseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCiuMod)
                            .addComponent(txtCiuMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosModAseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDirMod)
                    .addComponent(txtDirMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnModAse.setBackground(new java.awt.Color(79, 157, 157));
        btnModAse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/modificar.png"))); // NOI18N
        btnModAse.setText("MODIFICAR");
        btnModAse.setMaximumSize(new java.awt.Dimension(122, 33));
        btnModAse.setMinimumSize(new java.awt.Dimension(122, 33));
        btnModAse.setPreferredSize(new java.awt.Dimension(122, 33));
        btnModAse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModAseActionPerformed(evt);
            }
        });

        btnMostarModAse.setBackground(new java.awt.Color(79, 157, 157));
        btnMostarModAse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar.png"))); // NOI18N
        btnMostarModAse.setText("CANCELAR");
        btnMostarModAse.setMaximumSize(new java.awt.Dimension(122, 33));
        btnMostarModAse.setMinimumSize(new java.awt.Dimension(122, 33));
        btnMostarModAse.setPreferredSize(new java.awt.Dimension(122, 33));
        btnMostarModAse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostarModAseActionPerformed(evt);
            }
        });

        btnCancelarModAse.setBackground(new java.awt.Color(79, 157, 157));
        btnCancelarModAse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida.png"))); // NOI18N
        btnCancelarModAse.setText("SALIR");
        btnCancelarModAse.setMaximumSize(new java.awt.Dimension(122, 33));
        btnCancelarModAse.setMinimumSize(new java.awt.Dimension(122, 33));
        btnCancelarModAse.setPreferredSize(new java.awt.Dimension(122, 33));
        btnCancelarModAse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarModAseActionPerformed(evt);
            }
        });

        btnSalirModAse.setBackground(new java.awt.Color(79, 157, 157));
        btnSalirModAse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mostrar.png"))); // NOI18N
        btnSalirModAse.setText("MOSTRAR");
        btnSalirModAse.setMaximumSize(new java.awt.Dimension(122, 33));
        btnSalirModAse.setMinimumSize(new java.awt.Dimension(122, 33));
        btnSalirModAse.setPreferredSize(new java.awt.Dimension(122, 33));
        btnSalirModAse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirModAseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(pnlDatosModAse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblIconoMod)
                                .addGap(128, 128, 128)
                                .addComponent(lblTituloModAse))
                            .addComponent(pnlMosAseguradoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnModAse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnSalirModAse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnMostarModAse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnCancelarModAse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(lblTituloModAse)
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lblIconoMod)
                        .addGap(5, 5, 5)))
                .addComponent(pnlMosAseguradoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(pnlDatosModAse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarModAse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMostarModAse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalirModAse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModAse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModMosAseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModMosAseActionPerformed
        // TODO add your handling code here:
        String datos = txtCodEmpMod.getText();
        CargarTabla(datos);
    }//GEN-LAST:event_btnModMosAseActionPerformed

    private void txtNomEmpModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomEmpModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomEmpModActionPerformed

    private void txtMailModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMailModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMailModActionPerformed

    private void btnModAseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModAseActionPerformed
        // TODO add your handling code here:
        int Pregunta;
        Pregunta = JOptionPane.showConfirmDialog(null,"Desea modificar los datos","Pregunta" ,0);
        if (Pregunta==0)
        {
            try
            {
                ConexionMySQL mysql = new ConexionMySQL();
                Connection cn = mysql.Conectar();

                String Codigo_Emp;
                String Nombre_Emp;
                String Ciudad;
                String Direccion;
                String Gerente;
                String Telefono;
                String Mail;
                String Mensaje="";

                String sSQL="";

                Codigo_Emp = txtCodEmpMod.getText();
                Nombre_Emp = txtNomEmpMod.getText();
                Ciudad =  txtCiuMod.getText();
                Direccion = txtDirMod.getText();
                Gerente = txtGerMod.getText();
                Telefono = txtTelMod.getText();
                Mail = txtMailMod.getText();

                if(Codigo_Emp.equals("")||Nombre_Emp.equals("")||Ciudad.equals("")||
                    Direccion.equals("")||Gerente.equals("")||Mail.equals("")||Telefono.equals("")){
                    JOptionPane.showMessageDialog(null, "Llene todos los campos requeridos");
                }

                else{
                    if(ValidarNum(Codigo_Emp)==false||ValidarLetras(Ciudad)==false||ValidarNum(Telefono)==false){
                        JOptionPane.showMessageDialog(null, "Campos llenos de manera incorrecta");
                    }

                    else{

                        sSQL = "UPDATE aseguradora SET nom_emp = '"+Nombre_Emp+"', ciu='"+Ciudad+"', dir='"+Direccion+"', ger='"+Gerente+"', telf='"+Telefono+"', mail='"+Mail+"'";
                        sSQL = sSQL+ "WHERE cod_emp = '"+Codigo_Emp+"'";

                        Statement st = cn.createStatement();
                        st.executeUpdate(sSQL);
                        Mensaje ="DATOS MODIFICADOS DE FORMA CORRECTA";
                        JOptionPane.showMessageDialog(null, Mensaje);
                        String Informacion = lblIconoMod.getText();
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

    }//GEN-LAST:event_btnModAseActionPerformed

    private void btnMostarModAseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostarModAseActionPerformed
        // TODO add your handling code here:
        Borrar();
    }//GEN-LAST:event_btnMostarModAseActionPerformed

    private void btnCancelarModAseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarModAseActionPerformed
        // TODO add your handling code here:
        this.dispose();
        //MenuUsuario MenuUsuarioJF = new MenuUsuario ();
        //MenuUsuarioJF.setVisible(true);
    }//GEN-LAST:event_btnCancelarModAseActionPerformed

    private void btnSalirModAseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirModAseActionPerformed
        // TODO add your handling code here:
        String Informacion = txtCodEmpMod.getText();
        CargarDatos(Informacion);
    }//GEN-LAST:event_btnSalirModAseActionPerformed

    private void txtCodEmpModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodEmpModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodEmpModActionPerformed

    private void txtCodEmpModKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodEmpModKeyTyped
        // TODO add your handling code here:
        txtCodEmpMod.addKeyListener(new KeyAdapter() {
             
            public void keyReleased(final KeyEvent e) {
            String cadena = (txtCodEmpMod.getText()).trim();
            txtCodEmpMod.setText(cadena);
            repaint();
            filtro();
        }
        });
            tr = new TableRowSorter(tblModificarAse.getModel());
            tblModificarAse.setRowSorter(tr);
           
    }//GEN-LAST:event_txtCodEmpModKeyTyped

    private void txtGerModKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGerModKeyTyped
        // TODO add your handling code here:
         char c = evt.getKeyChar();
            if(Character.isLowerCase(c))
            {
                String cad = (""+c).toUpperCase();
                c=cad.charAt(0);
                evt.setKeyChar(c);
                
            }
          
    }//GEN-LAST:event_txtGerModKeyTyped

    private void txtNomEmpModKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomEmpModKeyTyped
        // TODO add your handling code here:
            char c = evt.getKeyChar();
            if(Character.isLowerCase(c))
            {
                String cad = (""+c).toUpperCase();
                c=cad.charAt(0);
                evt.setKeyChar(c);
                
            }
        
    }//GEN-LAST:event_txtNomEmpModKeyTyped

    private void txtCiuModKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCiuModKeyTyped
        // TODO add your handling code here:.
        String texto = txtCiuMod.getText();
        if(texto.length()>0){
            char primeraletra = texto.charAt(0);
            texto = Character.toUpperCase(primeraletra)+texto.substring(1, texto.length());
            txtCiuMod.setText(texto);
        }    
    }//GEN-LAST:event_txtCiuModKeyTyped

    private void txtDirModKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDirModKeyTyped
        // TODO add your handling code here:
        String texto = txtDirMod.getText();
        if(texto.length()>0){
            char primeraletra = texto.charAt(0);
            texto = Character.toUpperCase(primeraletra)+texto.substring(1, texto.length());
            txtDirMod.setText(texto);
        }    
    }//GEN-LAST:event_txtDirModKeyTyped

    private void txtMailModKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMailModKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
            if(Character.isUpperCase(c))
            {
                String cad = (""+c).toLowerCase();
                c=cad.charAt(0);
                evt.setKeyChar(c);
                
            }
    }//GEN-LAST:event_txtMailModKeyTyped

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
            java.util.logging.Logger.getLogger(ModAseguradora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModAseguradora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModAseguradora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModAseguradora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModAseguradora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarModAse;
    private javax.swing.JButton btnModAse;
    private javax.swing.JButton btnModMosAse;
    private javax.swing.JButton btnMostarModAse;
    private javax.swing.JButton btnSalirModAse;
    private javax.swing.JLabel lblCiuMod;
    private javax.swing.JLabel lblCodEmpMod;
    private javax.swing.JLabel lblDirMod;
    private javax.swing.JLabel lblGerMod;
    private javax.swing.JLabel lblIconoMod;
    private javax.swing.JLabel lblMailMod;
    private javax.swing.JLabel lblNomEmpMod;
    private javax.swing.JLabel lblTelMod;
    private javax.swing.JLabel lblTituloModAse;
    private javax.swing.JPanel pnlDatosModAse;
    private javax.swing.JPanel pnlMosAseguradoras;
    private javax.swing.JScrollPane scpModMosAse;
    private javax.swing.JTable tblModificarAse;
    private javax.swing.JTextField txtCiuMod;
    private javax.swing.JTextField txtCodEmpMod;
    private javax.swing.JTextField txtDirMod;
    private javax.swing.JTextField txtGerMod;
    private javax.swing.JTextField txtMailMod;
    private javax.swing.JTextField txtNomEmpMod;
    private javax.swing.JTextField txtTelMod;
    // End of variables declaration//GEN-END:variables
}
