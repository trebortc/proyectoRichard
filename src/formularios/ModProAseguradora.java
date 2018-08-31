/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Richard
 */
public class ModProAseguradora extends javax.swing.JFrame {
DefaultTableModel Producto;
private TableRowSorter tr;

    /**
     * Creates new form ModProAseguradora
     */
    public ModProAseguradora() {
        initComponents();
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(79,157,157));
    
    
    tblModAse.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
    
         @Override
         public void valueChanged(ListSelectionEvent e){
             if(tblModAse.getSelectedRow() != -1)
         {
             
            int fila = tblModAse.getSelectedRow();
            txtCodProModProAse.setText(tblModAse.getValueAt(fila, 0).toString());
            txtNomEmpModProAse.setText(tblModAse.getValueAt(fila, 1).toString());
            cboRoboModProAse.setSelectedItem(tblModAse.getValueAt(fila, 3).toString()); 
            txtPorRobModProAse.setText(tblModAse.getValueAt(fila, 4).toString());
            cboAccModProAse.setSelectedItem(tblModAse.getValueAt(fila, 5).toString());
            txtPorAccModProAse.setText(tblModAse.getValueAt(fila, 6).toString());
            cboMedModProAse.setSelectedItem(tblModAse.getValueAt(fila, 7).toString()); 
            txtPorMedModProAse.setText(tblModAse.getValueAt(fila, 8).toString()); 
            cboAntModProAse.setSelectedItem(tblModAse.getValueAt(fila, 9).toString());
            cboResModProAse.setSelectedItem(tblModAse.getValueAt(fila, 10).toString());  
     }
    }
    });
    }
     public void filtro() {
    //tr.setRowFilter(RowFilter.regexFilter(txtPlacaModPro.getText(), 0));.
    tr.setRowFilter(RowFilter.regexFilter("(?i)"+txtCodProModProAse.getText(), 0));
    }
    void CargarTabla(String Informacion)
    {
        try
        {
            String sSQL="";
            String[] Titulos = {"CÓDIGO","EMPRESA","CÓDIGO EMPRESA","POR ROBO","COBERTURA %","POR ACCIDENTE","COBERTURA %","POR HOSPITAL","COBERTURA %","ANTIGUEDAD DEL VEHÍCULO","RESPONSABILIDAD CIVIL"};
            String[] Datos = new String[11];

            Producto = new DefaultTableModel(null,Titulos);

            ConexionMySQL mysql = new ConexionMySQL();
            Connection cn = mysql.Conectar();

            sSQL = "SELECT cod_pro, nom_emp, cod_emp, robo, por_robo, accidente,por_acci, medico, por_med, ant_veh, res_civ FROM proforma "
                    + "WHERE CONCAT(cod_pro) LIKE '%"+Informacion+"%'";

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while(rs.next())
            {
                Datos[0]= rs.getString("cod_pro");
                Datos[1]= rs.getString("nom_emp");
                Datos[2] = rs.getString("cod_emp");
                Datos[3] = rs.getString("robo");
                Datos[4] = rs.getString("por_robo");
                Datos[5] = rs.getString("accidente");
                Datos[6] = rs.getString("por_acci");
                Datos[7] = rs.getString("medico");
                Datos[8] = rs.getString("por_med");
                Datos[9] = rs.getString("ant_veh");
                Datos[10] = rs.getString("res_civ");

                Producto.addRow(Datos);
            }
            tblModAse.setModel(Producto);



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
            
            String Nombre_Emp = "";
            String Robo = "";
            String Acci = "";
            String Medi = "";
            String Cod_Pro = "";
            String Por_Robo = "";
            String Por_Acci = "";
            String Por_Medi = "";
            String Ant_v = "";
            String Res_v = "";
            String Cod_Emp = "";

            ConexionMySQL mysql = new ConexionMySQL();
            Connection cn = mysql.Conectar();

            sSQL = "SELECT cod_pro, nom_emp, cod_emp, robo, por_robo, accidente,por_acci, medico, por_med, ant_veh, res_civ FROM proforma "
                    + "WHERE CONCAT(cod_pro) LIKE '%"+Datos_Producto+"%'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while(rs.next())
            {
                Cod_Pro = rs.getString("cod_pro");
                Nombre_Emp = rs.getString("nom_emp");
                Cod_Emp = rs.getString("cod_emp");
                Robo = rs.getString("robo");
                Por_Robo = rs.getString("por_robo");
                Acci = rs.getString("accidente");
                Por_Acci = rs.getString("por_acci");
                Medi = rs.getString("medico");
                Por_Medi = rs.getString("por_med");
                Ant_v = rs.getString("ant_veh");
                Res_v = rs.getString("res_civ");
                              
            }
            txtCodProModProAse.setText(Cod_Emp);
            txtNomEmpModProAse.setText(Nombre_Emp);
            cboRoboModProAse.setSelectedItem(Robo); 
            cboAccModProAse.setSelectedItem(Acci);
            cboMedModProAse.setSelectedItem(Medi); 
            cboAntModProAse.setSelectedItem(Ant_v);
            cboResModProAse.setSelectedItem(Res_v);
            txtPorRobModProAse.setText(Por_Medi);  
            txtPorAccModProAse.setText(Por_Robo); 
            txtPorMedModProAse.setText(Por_Acci);
          

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
     public void setTxtCodEmpMod(JTextField txtPlacaModPro) {
        this.txtCodProModProAse = txtPlacaModPro;
    }

    void Borrar()
    {
           
            txtCodProModProAse.setText("");
            txtNomEmpModProAse.setText("");
            cboAccModProAse.setSelectedItem("Seleccione");
            cboMedModProAse.setSelectedItem("Seleccione"); 
            cboAntModProAse.setSelectedItem("Seleccione");
            cboResModProAse.setSelectedItem("Seleccione");
            txtPorRobModProAse.setText("");  
            txtPorAccModProAse.setText(""); 
            txtPorMedModProAse.setText("");
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

        lblIconoRegProAse = new javax.swing.JLabel();
        lblTitRegProAse = new javax.swing.JLabel();
        pnlDatRegModAse = new javax.swing.JPanel();
        lblAntModProAse = new javax.swing.JLabel();
        cboAntModProAse = new javax.swing.JComboBox();
        lblRoboModProAse = new javax.swing.JLabel();
        lblAccModProAse = new javax.swing.JLabel();
        lblMedModProAse = new javax.swing.JLabel();
        cboRoboModProAse = new javax.swing.JComboBox();
        cboAccModProAse = new javax.swing.JComboBox();
        cboMedModProAse = new javax.swing.JComboBox();
        lblPorMedModProAse = new javax.swing.JLabel();
        txtPorRobModProAse = new javax.swing.JTextField();
        lblModPorAccAse = new javax.swing.JLabel();
        txtPorMedModProAse = new javax.swing.JTextField();
        lblModPorRoboProAse = new javax.swing.JLabel();
        txtPorAccModProAse = new javax.swing.JTextField();
        lblCodModProAse = new javax.swing.JLabel();
        txtCodProModProAse = new javax.swing.JTextField();
        lblResModProAse = new javax.swing.JLabel();
        cboResModProAse = new javax.swing.JComboBox();
        lblNomEmpModAse = new javax.swing.JLabel();
        txtNomEmpModProAse = new javax.swing.JTextField();
        btnModModProAse = new javax.swing.JButton();
        btnMostarModProAse = new javax.swing.JButton();
        btnCanModProAse = new javax.swing.JButton();
        btnSalModProAse = new javax.swing.JButton();
        pnlMosModAse = new javax.swing.JPanel();
        scpModProd = new javax.swing.JScrollPane();
        tblModAse = new javax.swing.JTable();
        btnMosModAse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblIconoRegProAse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconoProforma.jpg"))); // NOI18N

        lblTitRegProAse.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitRegProAse.setText("MODIFICAR COBERTURA GENERAL DE LA ASEGURADORA");

        pnlDatRegModAse.setBackground(new java.awt.Color(79, 157, 157));
        pnlDatRegModAse.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Que Ofrece Aseguradora"));

        lblAntModProAse.setText("Antiguedad del Vehículo *");

        cboAntModProAse.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Hasta 10 años de fabricación", "Hasta 12 años de fabricación", "Hasta 13 años de fabricación", "Hasta 14 años de fabricación", "Hasta 15 años de fabricación" }));

        lblRoboModProAse.setText("Pérdida Por Robo *");

        lblAccModProAse.setText("Pérdida Por Accidente *");

        lblMedModProAse.setText("Gatos Médicos *");

        cboRoboModProAse.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "TOTAL", "PARCIAL" }));

        cboAccModProAse.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "TOTAL", "PARCIAL" }));

        cboMedModProAse.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "TOTAL", "PARCIAL" }));

        lblPorMedModProAse.setText("Porcentaje de Cobertura *       %");

        lblModPorAccAse.setText("Porcentaje de Cobertura *       %");

        lblModPorRoboProAse.setText("Porcentaje de Cobertura *       %");

        lblCodModProAse.setText("Código de Cobertura*");

        txtCodProModProAse.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodProModProAseKeyTyped(evt);
            }
        });

        lblResModProAse.setText("Responsabilidad Civil *");

        cboResModProAse.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "En Ecuador", "No aplica fuera del Ecuador", "Dentro de territorio ecuatoriano", "Aplica dentro de Comunidad Andina" }));

        lblNomEmpModAse.setText("Nombre de la Empresa*");

        javax.swing.GroupLayout pnlDatRegModAseLayout = new javax.swing.GroupLayout(pnlDatRegModAse);
        pnlDatRegModAse.setLayout(pnlDatRegModAseLayout);
        pnlDatRegModAseLayout.setHorizontalGroup(
            pnlDatRegModAseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatRegModAseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatRegModAseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAccModProAse)
                    .addComponent(lblRoboModProAse)
                    .addComponent(lblAntModProAse)
                    .addComponent(lblMedModProAse)
                    .addComponent(lblCodModProAse)
                    .addComponent(lblResModProAse)
                    .addComponent(lblNomEmpModAse))
                .addGap(33, 33, 33)
                .addGroup(pnlDatRegModAseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboResModProAse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboAccModProAse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboMedModProAse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboAntModProAse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboRoboModProAse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCodProModProAse)
                    .addComponent(txtNomEmpModProAse))
                .addGap(20, 20, 20)
                .addGroup(pnlDatRegModAseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblModPorAccAse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblModPorRoboProAse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPorMedModProAse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(67, 67, 67)
                .addGroup(pnlDatRegModAseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPorRobModProAse, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(txtPorAccModProAse)
                    .addComponent(txtPorMedModProAse))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDatRegModAseLayout.setVerticalGroup(
            pnlDatRegModAseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatRegModAseLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pnlDatRegModAseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodModProAse)
                    .addComponent(txtCodProModProAse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(pnlDatRegModAseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomEmpModAse)
                    .addComponent(txtNomEmpModProAse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(pnlDatRegModAseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPorRobModProAse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDatRegModAseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblRoboModProAse)
                        .addComponent(cboRoboModProAse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblModPorRoboProAse)))
                .addGroup(pnlDatRegModAseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatRegModAseLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtPorAccModProAse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(pnlDatRegModAseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPorMedModProAse)
                            .addComponent(txtPorMedModProAse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlDatRegModAseLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(pnlDatRegModAseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAccModProAse)
                            .addComponent(cboAccModProAse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblModPorAccAse))
                        .addGap(5, 5, 5)
                        .addGroup(pnlDatRegModAseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMedModProAse)
                            .addComponent(cboMedModProAse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 5, 5)
                .addGroup(pnlDatRegModAseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboAntModProAse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAntModProAse))
                .addGap(5, 5, 5)
                .addGroup(pnlDatRegModAseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboResModProAse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblResModProAse))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnModModProAse.setBackground(new java.awt.Color(79, 157, 157));
        btnModModProAse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/modificar.png"))); // NOI18N
        btnModModProAse.setText("MODIFICAR");
        btnModModProAse.setMaximumSize(new java.awt.Dimension(122, 33));
        btnModModProAse.setMinimumSize(new java.awt.Dimension(122, 33));
        btnModModProAse.setPreferredSize(new java.awt.Dimension(122, 33));
        btnModModProAse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModModProAseActionPerformed(evt);
            }
        });

        btnMostarModProAse.setBackground(new java.awt.Color(79, 157, 157));
        btnMostarModProAse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mostrar.png"))); // NOI18N
        btnMostarModProAse.setText("MOSTRAR");
        btnMostarModProAse.setMaximumSize(new java.awt.Dimension(122, 33));
        btnMostarModProAse.setMinimumSize(new java.awt.Dimension(122, 33));
        btnMostarModProAse.setPreferredSize(new java.awt.Dimension(122, 33));
        btnMostarModProAse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostarModProAseActionPerformed(evt);
            }
        });

        btnCanModProAse.setBackground(new java.awt.Color(79, 157, 157));
        btnCanModProAse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar.png"))); // NOI18N
        btnCanModProAse.setText("CANCELAR");
        btnCanModProAse.setMaximumSize(new java.awt.Dimension(122, 33));
        btnCanModProAse.setMinimumSize(new java.awt.Dimension(122, 33));
        btnCanModProAse.setPreferredSize(new java.awt.Dimension(122, 33));
        btnCanModProAse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanModProAseActionPerformed(evt);
            }
        });

        btnSalModProAse.setBackground(new java.awt.Color(79, 157, 157));
        btnSalModProAse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida.png"))); // NOI18N
        btnSalModProAse.setText("SALIR");
        btnSalModProAse.setMaximumSize(new java.awt.Dimension(122, 33));
        btnSalModProAse.setMinimumSize(new java.awt.Dimension(122, 33));
        btnSalModProAse.setPreferredSize(new java.awt.Dimension(122, 33));
        btnSalModProAse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalModProAseActionPerformed(evt);
            }
        });

        pnlMosModAse.setBackground(new java.awt.Color(79, 157, 157));
        pnlMosModAse.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Cobertura Aseguradora"));

        tblModAse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        scpModProd.setViewportView(tblModAse);

        btnMosModAse.setBackground(new java.awt.Color(79, 157, 157));
        btnMosModAse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cargar.png"))); // NOI18N
        btnMosModAse.setText("MOSTRAR DATOS");
        btnMosModAse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMosModAseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMosModAseLayout = new javax.swing.GroupLayout(pnlMosModAse);
        pnlMosModAse.setLayout(pnlMosModAseLayout);
        pnlMosModAseLayout.setHorizontalGroup(
            pnlMosModAseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMosModAseLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnMosModAse)
                .addContainerGap())
            .addComponent(scpModProd, javax.swing.GroupLayout.DEFAULT_SIZE, 1178, Short.MAX_VALUE)
        );
        pnlMosModAseLayout.setVerticalGroup(
            pnlMosModAseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMosModAseLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(btnMosModAse)
                .addGap(5, 5, 5)
                .addComponent(scpModProd, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlMosModAse, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblIconoRegProAse)
                        .addGap(18, 18, 18)
                        .addComponent(lblTitRegProAse)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(249, 249, 249)
                                .addComponent(pnlDatRegModAse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(310, 310, 310)
                                .addComponent(btnModModProAse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(btnMostarModProAse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(btnCanModProAse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(btnSalModProAse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIconoRegProAse, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblTitRegProAse)))
                .addGap(2, 2, 2)
                .addComponent(pnlMosModAse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDatRegModAse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModModProAse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMostarModProAse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCanModProAse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalModProAse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModModProAseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModModProAseActionPerformed
        // TODO add your handling code here:
        int Pregunta;
        Pregunta = JOptionPane.showConfirmDialog(null,"Desea Modifiacar Los Datos","Pregunta" ,0);
        if (Pregunta==0)
        {
            try
            {
                String sSQL="";
                String Mensaje="";
                
                String Cod_Pro = txtCodProModProAse.getText();
                String Nombre_Emp = txtNomEmpModProAse.getText();
                String Robo = cboRoboModProAse.getSelectedItem().toString();
                String Por_Robo = txtPorAccModProAse.getText();
                String Acci = cboAccModProAse.getSelectedItem().toString();
                String Por_Acci = txtPorMedModProAse.getText();
                String Medi = cboMedModProAse.getSelectedItem().toString();
                String Por_Medi = txtPorRobModProAse.getText();
                String Ant_v = cboAntModProAse.getSelectedItem().toString();
                String Res_v = cboResModProAse.getSelectedItem().toString();
                
                ConexionMySQL mysql = new ConexionMySQL();
                Connection cn = mysql.Conectar();

                if(Cod_Pro.equals("")||Nombre_Emp.equals("")||Medi.equals("")||Por_Robo.equals("")||Por_Acci.equals("")||
                    Por_Medi.equals("")||Acci.equals("")){
                    JOptionPane.showMessageDialog(null, "Llene todos los campos requeridos");
                }

                else{
                    if(ValidarNum(Por_Robo)==false||ValidarNum(Por_Acci)==false||ValidarNum(Por_Medi)==false){
                        JOptionPane.showMessageDialog(null, "Campos llenos de manera incorrecta");
                    }

                    else{

                        sSQL = "UPDATE proforma SET nom_emp = '"+Nombre_Emp+"', robo = '"+Robo+"',  por_robo='"+Por_Robo+"', accidente = '"+Acci+"', por_acci='"+Por_Acci+"', medico='"+Medi+"', por_med='"+Por_Medi+"', ant_veh='"+Ant_v+"', res_civ='"+Res_v+"'";
                        sSQL = sSQL+ "WHERE cod_pro = '"+Cod_Pro+"'";

                        Mensaje ="DATOS MODIFICADOS DE FORMA CORRECTA";
                        Statement st = cn.createStatement();
                        int n = st.executeUpdate(sSQL);

                        if(n>0)
                        {
                            JOptionPane.showMessageDialog(null, Mensaje);
                        }
                        String Informacion = lblIconoRegProAse.getText();
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
    }//GEN-LAST:event_btnModModProAseActionPerformed

    private void btnMostarModProAseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostarModProAseActionPerformed
        // TODO add your handling code here:
        String Datos_Producto = txtCodProModProAse.getText();
        CargarDatos(Datos_Producto);
    }//GEN-LAST:event_btnMostarModProAseActionPerformed

    private void btnCanModProAseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanModProAseActionPerformed
        // TODO add your handling code here:
        Borrar();
    }//GEN-LAST:event_btnCanModProAseActionPerformed

    private void btnSalModProAseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalModProAseActionPerformed
        // TODO add your handling code here:
        this.dispose();
        //MenuUsuario MenuUsuarioJF = new MenuUsuario();
        //MenuUsuarioJF.setVisible(true);
    }//GEN-LAST:event_btnSalModProAseActionPerformed

    private void btnMosModAseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMosModAseActionPerformed
        // TODO add your handling code here:
        String Informacion = txtCodProModProAse.getText();
        CargarTabla(Informacion);
    }//GEN-LAST:event_btnMosModAseActionPerformed

    private void txtCodProModProAseKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodProModProAseKeyTyped
        // TODO add your handling code here:
        txtCodProModProAse.addKeyListener(new KeyAdapter() {
             
            public void keyReleased(final KeyEvent e) {
            String cadena = (txtCodProModProAse.getText()).trim();
            txtCodProModProAse.setText(cadena);
            repaint();
            filtro();
        }
        });
            tr = new TableRowSorter(tblModAse.getModel());
            tblModAse.setRowSorter(tr);
    }//GEN-LAST:event_txtCodProModProAseKeyTyped

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
            java.util.logging.Logger.getLogger(ModProAseguradora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModProAseguradora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModProAseguradora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModProAseguradora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModProAseguradora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCanModProAse;
    private javax.swing.JButton btnModModProAse;
    private javax.swing.JButton btnMosModAse;
    private javax.swing.JButton btnMostarModProAse;
    private javax.swing.JButton btnSalModProAse;
    private javax.swing.JComboBox cboAccModProAse;
    private javax.swing.JComboBox cboAntModProAse;
    private javax.swing.JComboBox cboMedModProAse;
    private javax.swing.JComboBox cboResModProAse;
    private javax.swing.JComboBox cboRoboModProAse;
    private javax.swing.JLabel lblAccModProAse;
    private javax.swing.JLabel lblAntModProAse;
    private javax.swing.JLabel lblCodModProAse;
    private javax.swing.JLabel lblIconoRegProAse;
    private javax.swing.JLabel lblMedModProAse;
    private javax.swing.JLabel lblModPorAccAse;
    private javax.swing.JLabel lblModPorRoboProAse;
    private javax.swing.JLabel lblNomEmpModAse;
    private javax.swing.JLabel lblPorMedModProAse;
    private javax.swing.JLabel lblResModProAse;
    private javax.swing.JLabel lblRoboModProAse;
    private javax.swing.JLabel lblTitRegProAse;
    private javax.swing.JPanel pnlDatRegModAse;
    private javax.swing.JPanel pnlMosModAse;
    private javax.swing.JScrollPane scpModProd;
    private javax.swing.JTable tblModAse;
    private javax.swing.JTextField txtCodProModProAse;
    private javax.swing.JTextField txtNomEmpModProAse;
    private javax.swing.JTextField txtPorAccModProAse;
    private javax.swing.JTextField txtPorMedModProAse;
    private javax.swing.JTextField txtPorRobModProAse;
    // End of variables declaration//GEN-END:variables
}
