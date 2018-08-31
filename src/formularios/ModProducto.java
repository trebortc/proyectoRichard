package formularios;


import clases.Metodos;
import conexion.ConexionMySQL;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Richard
 */
public class ModProducto extends javax.swing.JFrame {
    
    DefaultTableModel Producto;
    public boolean bandera;
    private TableRowSorter tr;
    public String imagen = null;
    public String imagen2 = null;
    public String imagen3 = null;
    public String imagen4 = null;
    /**
     * Creates new form ModProducto
     */
    public ModProducto() {
        initComponents();
        bandera = false;
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(79,157,157));
        cboTipModPro.setEditable(true); //para poder escribir adentro
        AutoCompleteDecorator.decorate(this.cboTipModPro); 
        cboMarcaModPro.setEditable(true); //para poder escribir adentro
        AutoCompleteDecorator.decorate(this.cboMarcaModPro);
        
        //jTblReservaciones.getColumnModel().getColumn(7).setPreferredWidth(0);
        
        tblModProd.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
                if(tblModProd.getSelectedRow() != -1)
                {

                    int fila = tblModProd.getSelectedRow();
                    txtPlacaModPro.setText(tblModProd.getValueAt(fila, 1).toString());
                    cboTipModPro.setSelectedItem(tblModProd.getValueAt(fila, 2).toString()); 
                    cboMarcaModPro.setSelectedItem(tblModProd.getValueAt(fila, 3).toString());
                    txtModeloModPro.setText(tblModProd.getValueAt(fila, 4).toString());  
                    txtAnioModPro.setText(tblModProd.getValueAt(fila, 5).toString()); 
                    txtColorModPro.setText(tblModProd.getValueAt(fila, 6).toString());
                    txtValorModPro.setText(tblModProd.getValueAt(fila, 7).toString());
                    try{
                        imagen = null;imagen2 = null;imagen3 = null;imagen4 = null;
                        if(tblModProd.getValueAt(fila, 8) != null && tblModProd.getValueAt(fila, 9) != null && tblModProd.getValueAt(fila, 10) != null && tblModProd.getValueAt(fila, 11) != null){
                             
                            imagen = tblModProd.getValueAt(fila, 8).toString();
                            imagen2 = tblModProd.getValueAt(fila, 9).toString();
                            imagen3 = tblModProd.getValueAt(fila, 10).toString();
                            imagen4 = tblModProd.getValueAt(fila, 11).toString();
                        }else{
                            btnVerModPro.setIcon(null);
                            jButton1.setIcon(null);
                            jButton2.setIcon(null);
                            jButton3.setIcon(null);
                        }
                        
                        if(imagen != null && imagen2 != null && imagen3 != null && imagen4 != null)
                        {
                            Metodos.cargarImagen(imagen, btnVerModPro);
                            Metodos.cargarImagen(imagen2, jButton1);
                            Metodos.cargarImagen(imagen3, jButton2);
                            Metodos.cargarImagen(imagen4, jButton3);  
                        }
                    }catch(Exception exc)
                    {
                        exc.printStackTrace();
                    }

                }
            }
        });
    }
     public void filtro() {
    tr.setRowFilter(RowFilter.regexFilter("(?i)"+txtPlacaModPro.getText(), 0));
    }
    void CargarTabla(String Informacion)
    {
        try
        {
            String sSQL="";
            String[] Titulos = {"CÉDULA", "PLACA", "TIPO", "MARCA", "MODELO", "AÑO", "COLOR", "VALOR ACTUAL","","","",""};
            String[] Datos = new String[12];

            Producto = new DefaultTableModel(null,Titulos);

            ConexionMySQL mysql = new ConexionMySQL();
            Connection cn = mysql.Conectar();

            sSQL = "SELECT nom_pro, tip, mar, modelo, anio, col, val, matri_vehi, imagen, imagen2, imagen3, imagen4 FROM vehiculo "
                    + "WHERE CONCAT(matri_vehi) LIKE '%"+Informacion+"%'";

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while(rs.next())
            {
                Datos[0] = rs.getString("nom_pro");        
                Datos[1] = rs.getString("matri_vehi");
                Datos[2] = rs.getString("tip");
                Datos[3] = rs.getString("mar");
                Datos[4] = rs.getString("modelo");
                Datos[5] = rs.getString("anio");
                Datos[6] = rs.getString("col");
                Datos[7] = rs.getString("val");
                Datos[8] = rs.getString("imagen");
                Datos[9] = rs.getString("imagen2");
                Datos[10] = rs.getString("imagen3");
                Datos[11] = rs.getString("imagen4");

                Producto.addRow(Datos);
            }
            tblModProd.setModel(Producto);
            tblModProd.getColumnModel().getColumn(8).setPreferredWidth(0);
            tblModProd.getColumnModel().getColumn(9).setPreferredWidth(0);
            tblModProd.getColumnModel().getColumn(10).setPreferredWidth(0);
            tblModProd.getColumnModel().getColumn(11).setPreferredWidth(0);


        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    void CargarDatos(String Datos_Producto)
    {
        try
        {
            String sSQL="";

            String Codigo_V = "";
            String Tipo = "";
            String Marca = "";
            String Modelo = "";
            String Anio = "";
            String Color = "";
            String Valor = "";
            String Propietario = "";
            imagen = "";
            imagen2 = "";
            imagen3 = "";
            imagen4 = "";

            ConexionMySQL mysql = new ConexionMySQL();
            Connection cn = mysql.Conectar();

            sSQL = "SELECT mar, modelo, anio, col, val, matri_vehi, imagen, imagen2, imagen3, imagen4 FROM vehiculo "
                    + "WHERE CONCAT(matri_vehi) LIKE '%"+Datos_Producto+"%'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while(rs.next())
            {

                Codigo_V =  rs.getString("matri_vehi");
                Marca = rs.getString("mar");
                Modelo = rs.getString("modelo");
                Anio = rs.getString("anio");
                Color = rs.getString("col");
                Valor = rs.getString("val");
                if(rs.getString("imagen") != null){
                    imagen = rs.getString("imagen");
                }
                if(rs.getString("imagen2") != null){
                    imagen2 = rs.getString("imagen2");
                }
                if(rs.getString("imagen3") != null){
                    imagen3 = rs.getString("imagen3");
                }
                if(rs.getString("imagen4") != null){
                    imagen4 = rs.getString("imagen4");
                }
 
            }
            txtPlacaModPro.setText(Codigo_V);
            //txtMarcaModPro.setText(Marca);
            txtModeloModPro.setText(Modelo);
            txtAnioModPro.setText(Anio);
            txtColorModPro.setText(Color);
            txtValorModPro.setText(Valor);
            if(imagen != null)
            {
                Metodos.cargarImagen(imagen, btnVerModPro);
            }else{
                btnVerModPro.setIcon(null);
            }
            if(imagen2 != null)
            {
                Metodos.cargarImagen(imagen2, jButton1);
            }else{
                jButton1.setIcon(null);
            }
            if(imagen3 != null)
            {
                Metodos.cargarImagen(imagen3, jButton2);
            }else{
                jButton2.setIcon(null);
            }
            if(imagen4 != null)
            {
                Metodos.cargarImagen(imagen4, jButton3);
            }else{
                jButton3.setIcon(null);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
     public void setTxtCodEmpMod(JTextField txtPlacaModPro) {
        this.txtPlacaModPro = txtPlacaModPro;
    }

    void Borrar()
    {
            txtPlacaModPro.setText("");
            cboTipModPro.setSelectedItem("Seleccione");
            cboMarcaModPro.setSelectedItem("Seleccione");
            txtModeloModPro.setText("");
            txtAnioModPro.setText("");
            txtColorModPro.setText("");
            txtValorModPro.setText("");
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

        lblTitModPro = new javax.swing.JLabel();
        pnlMosModPro = new javax.swing.JPanel();
        scpModProd = new javax.swing.JScrollPane();
        tblModProd = new javax.swing.JTable();
        btnMosModPro = new javax.swing.JButton();
        pnlInfModPro = new javax.swing.JPanel();
        lblTipModPro = new javax.swing.JLabel();
        lblModeloModPro = new javax.swing.JLabel();
        lblMarcaModPro = new javax.swing.JLabel();
        lblAnioModPro = new javax.swing.JLabel();
        lblColorModPro = new javax.swing.JLabel();
        lblValorModPro = new javax.swing.JLabel();
        cboTipModPro = new javax.swing.JComboBox();
        txtModeloModPro = new javax.swing.JTextField();
        txtAnioModPro = new javax.swing.JTextField();
        txtColorModPro = new javax.swing.JTextField();
        txtValorModPro = new javax.swing.JTextField();
        lblPlacaModPro = new javax.swing.JLabel();
        txtPlacaModPro = new javax.swing.JTextField();
        cboMarcaModPro = new javax.swing.JComboBox();
        btnVerModPro = new javax.swing.JButton();
        btnCarModPro = new javax.swing.JButton();
        btnModModPro = new javax.swing.JButton();
        btnCanModPro = new javax.swing.JButton();
        btnSalModPro = new javax.swing.JButton();
        lblIconoModPro = new javax.swing.JLabel();
        btnMostarModPro = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnCarModPro2 = new javax.swing.JButton();
        btnCarModPro3 = new javax.swing.JButton();
        btnCarModPro4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AVENDAÑO AGENCIA DE SEGUROS");
        setName("frmModProducto"); // NOI18N

        lblTitModPro.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitModPro.setText("MODIFICAR DATOS DEL VEHÍCULO");

        pnlMosModPro.setBackground(new java.awt.Color(79, 157, 157));
        pnlMosModPro.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Producto"));

        tblModProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        scpModProd.setViewportView(tblModProd);

        btnMosModPro.setBackground(new java.awt.Color(79, 157, 157));
        btnMosModPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cargar.png"))); // NOI18N
        btnMosModPro.setText("MOSTRAR DATOS");
        btnMosModPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMosModProActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMosModProLayout = new javax.swing.GroupLayout(pnlMosModPro);
        pnlMosModPro.setLayout(pnlMosModProLayout);
        pnlMosModProLayout.setHorizontalGroup(
            pnlMosModProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMosModProLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnMosModPro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(scpModProd)
        );
        pnlMosModProLayout.setVerticalGroup(
            pnlMosModProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMosModProLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMosModPro)
                .addGap(5, 5, 5)
                .addComponent(scpModProd, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pnlInfModPro.setBackground(new java.awt.Color(79, 157, 157));
        pnlInfModPro.setBorder(javax.swing.BorderFactory.createTitledBorder("Información Producto"));

        lblTipModPro.setText("Tipo *");

        lblModeloModPro.setText("Modelo *");

        lblMarcaModPro.setText("Marca *");

        lblAnioModPro.setText("Año *");

        lblColorModPro.setText("Color *");

        lblValorModPro.setText("Valor Actual *");

        cboTipModPro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Sedan", "Hatchback", "Convertible", "Coupe", "Deportivo", "Jeep", "CabinaSimple4x2 ", "CabinaDoble4x2", "CabinaSimple4x4 ", "CabinaDoble4x4" }));
        cboTipModPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipModProActionPerformed(evt);
            }
        });

        txtModeloModPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtModeloModProKeyTyped(evt);
            }
        });

        txtAnioModPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnioModProKeyTyped(evt);
            }
        });

        txtColorModPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtColorModProActionPerformed(evt);
            }
        });
        txtColorModPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtColorModProKeyTyped(evt);
            }
        });

        txtValorModPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorModProKeyTyped(evt);
            }
        });

        lblPlacaModPro.setText(" Placa *");

        txtPlacaModPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlacaModProActionPerformed(evt);
            }
        });
        txtPlacaModPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPlacaModProKeyTyped(evt);
            }
        });

        cboMarcaModPro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Audi", "BMW", "BYD", "Changhe", "Chery", "Chevrolet", "Citroën", "Dodge", "Dongfeng", "DS", "FAW", "Fiat", "Ford", "Foton", "Great Wall", "Haval", "Honda", "Hyundai", "JAC Motors", "Jeep", "Jinbei", "Kia", "King Long", "Mahindra", "Mazda", "Mercedes Benz", "MINI", "Mitsubishi", "Nissan", "Peugeot", "Porsche", "Renault", "Skoda", "Suzuki", "Tata", "Toyota", "Volkswagen", "Zotye" }));
        cboMarcaModPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMarcaModProActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInfModProLayout = new javax.swing.GroupLayout(pnlInfModPro);
        pnlInfModPro.setLayout(pnlInfModProLayout);
        pnlInfModProLayout.setHorizontalGroup(
            pnlInfModProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfModProLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlInfModProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPlacaModPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTipModPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblModeloModPro, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(lblMarcaModPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(pnlInfModProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtModeloModPro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlInfModProLayout.createSequentialGroup()
                        .addGroup(pnlInfModProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPlacaModPro, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(cboTipModPro, 0, 1, Short.MAX_VALUE)
                            .addComponent(cboMarcaModPro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(35, 35, 35)
                        .addGroup(pnlInfModProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblValorModPro, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(lblColorModPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAnioModPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(9, 9, 9)
                .addGroup(pnlInfModProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtValorModPro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAnioModPro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtColorModPro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        pnlInfModProLayout.setVerticalGroup(
            pnlInfModProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfModProLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pnlInfModProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPlacaModPro)
                    .addGroup(pnlInfModProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPlacaModPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblAnioModPro)
                        .addComponent(txtAnioModPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(pnlInfModProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTipModPro)
                    .addGroup(pnlInfModProLayout.createSequentialGroup()
                        .addGroup(pnlInfModProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboTipModPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblColorModPro)
                            .addComponent(txtColorModPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(pnlInfModProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMarcaModPro)
                            .addComponent(lblValorModPro)
                            .addComponent(txtValorModPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboMarcaModPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(pnlInfModProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtModeloModPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblModeloModPro))))
                .addGap(5, 5, 5))
        );

        btnVerModPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagenVehiculo.jpg"))); // NOI18N
        btnVerModPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerModProActionPerformed(evt);
            }
        });

        btnCarModPro.setBackground(new java.awt.Color(79, 157, 157));
        btnCarModPro.setText("Imagen parte frontal");
        btnCarModPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarModProActionPerformed(evt);
            }
        });

        btnModModPro.setBackground(new java.awt.Color(79, 157, 157));
        btnModModPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/modificar.png"))); // NOI18N
        btnModModPro.setText("MODIFICAR");
        btnModModPro.setMaximumSize(new java.awt.Dimension(122, 33));
        btnModModPro.setMinimumSize(new java.awt.Dimension(122, 33));
        btnModModPro.setPreferredSize(new java.awt.Dimension(122, 33));
        btnModModPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModModProActionPerformed(evt);
            }
        });

        btnCanModPro.setBackground(new java.awt.Color(79, 157, 157));
        btnCanModPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar.png"))); // NOI18N
        btnCanModPro.setText("CANCELAR");
        btnCanModPro.setMaximumSize(new java.awt.Dimension(122, 33));
        btnCanModPro.setMinimumSize(new java.awt.Dimension(122, 33));
        btnCanModPro.setPreferredSize(new java.awt.Dimension(122, 33));
        btnCanModPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanModProActionPerformed(evt);
            }
        });

        btnSalModPro.setBackground(new java.awt.Color(79, 157, 157));
        btnSalModPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida.png"))); // NOI18N
        btnSalModPro.setText("SALIR");
        btnSalModPro.setMaximumSize(new java.awt.Dimension(122, 33));
        btnSalModPro.setMinimumSize(new java.awt.Dimension(122, 33));
        btnSalModPro.setPreferredSize(new java.awt.Dimension(122, 33));
        btnSalModPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalModProActionPerformed(evt);
            }
        });

        lblIconoModPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/producto.png"))); // NOI18N

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

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenVehiculo.jpg"))); // NOI18N
        jButton1.setBorder(null);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenVehiculo.jpg"))); // NOI18N
        jButton2.setBorder(null);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenVehiculo.jpg"))); // NOI18N
        jButton3.setBorder(null);

        btnCarModPro2.setText("Imagen lateral izquierda");
        btnCarModPro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarModPro2ActionPerformed(evt);
            }
        });

        btnCarModPro3.setText("Imagen lateral derecha");
        btnCarModPro3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarModPro3ActionPerformed(evt);
            }
        });

        btnCarModPro4.setText("Imagen trasera vehiculo");
        btnCarModPro4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarModPro4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMosModPro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblIconoModPro)
                        .addGap(45, 45, 45)
                        .addComponent(lblTitModPro)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnModModPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnMostarModPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnCanModPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnSalModPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(208, 208, 208)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(pnlInfModPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVerModPro, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCarModPro, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCarModPro2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(btnCarModPro3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCarModPro4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lblIconoModPro))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(lblTitModPro)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMosModPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVerModPro, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCarModPro)
                            .addComponent(btnCarModPro2)
                            .addComponent(btnCarModPro3)
                            .addComponent(btnCarModPro4)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlInfModPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModModPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMostarModPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCanModPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalModPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMosModProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMosModProActionPerformed
        // TODO add your handling code here:
        String Informacion = txtPlacaModPro.getText();
        CargarTabla(Informacion);
    }//GEN-LAST:event_btnMosModProActionPerformed

    private void txtColorModProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColorModProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtColorModProActionPerformed

    private void btnVerModProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerModProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerModProActionPerformed

    private void btnCarModProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarModProActionPerformed
        // TODO add your handling code here:
        //this.dispose();
        bandera = true;
        ImgProducto ImgProductoJF = new ImgProducto();
        ImgProductoJF.setVisible(true);        
    }//GEN-LAST:event_btnCarModProActionPerformed

    private void btnModModProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModModProActionPerformed
        // TODO add your handling code here:
        int Pregunta;
        Pregunta = JOptionPane.showConfirmDialog(null,"Desea Modifiacar Los Datos","Pregunta" ,0);
        if (Pregunta==0)
        {
            try
            {
                String sSQL="";
                String Mensaje="";

                String Codigo_V = txtPlacaModPro.getText();
                String Tipo = cboTipModPro.getSelectedItem().toString();
                String Marca = cboMarcaModPro.getSelectedItem().toString();
                String Modelo = txtModeloModPro.getText();
                String Anio = txtAnioModPro.getText();
                String Color = txtColorModPro.getText();
                String Valor = txtValorModPro.getText();
                imagen = null;
                imagen2 = null;
                imagen3 = null;
                imagen4 = null;
                
                if (bandera){
                    imagen = Metodos.datosImagen(ImgProducto.fichero);
                    imagen2 = Metodos.datosImagen(ImgProducto2.fichero);
                    imagen3 = Metodos.datosImagen(ImgProducto3.fichero);
                    imagen4 = Metodos.datosImagen(ImgProducto4.fichero);
                }
                
                ConexionMySQL mysql = new ConexionMySQL();
                Connection cn = mysql.Conectar();
                
                 if(Codigo_V.equals("")||Tipo.equals("")||Marca.equals("")||Modelo.equals("")||Anio.equals("")||
                         Color.equals("")||Valor.equals("")){
                    JOptionPane.showMessageDialog(null, "Llene todos los campos requeridos");
                }

                else{
                    if(ValidarLetras(Marca)==false||ValidarLetras(Color)==false||ValidarNum(Valor)==false){
                        JOptionPane.showMessageDialog(null, "Campos llenos de manera incorrecta");
                    }

                    else{
                
                if(!bandera)        {
                    sSQL = "UPDATE vehiculo SET tip = '"+Tipo+"', mar = '"+Marca+"', modelo = '"+Modelo+"', anio='"+Anio+"', col='"+Color+"', val='"+Valor+"'";
                    sSQL = sSQL+ "WHERE matri_vehi = '"+Codigo_V+"'";
                }
                else{
                    sSQL = "UPDATE vehiculo SET tip = '"+Tipo+"', mar = '"+Marca+"', modelo = '"+Modelo+"', anio='"+Anio+"', col='"+Color+"', val='"+Valor+"', imagen='"+imagen+"', imagen2='"+imagen2+"', imagen3='"+imagen3+"', imagen4='"+imagen4+"'";
                    sSQL = sSQL+ " WHERE matri_vehi = '"+Codigo_V+"'";
                }
                Mensaje ="DATOS MODIFICADOS DE FORMA CORRECTA";
                Statement st = cn.createStatement();
                int n = st.executeUpdate(sSQL);
                
                    if(n>0)
                    {
                        JOptionPane.showMessageDialog(null, Mensaje);
                    }
                    String Informacion = lblIconoModPro.getText();
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
    }//GEN-LAST:event_btnModModProActionPerformed

    private void btnCanModProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanModProActionPerformed
        // TODO add your handling code here:
        Borrar();
    }//GEN-LAST:event_btnCanModProActionPerformed

    private void btnSalModProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalModProActionPerformed
        // TODO add your handling code here:
        this.dispose();
        //MenuUsuario MenuUsuarioJF = new MenuUsuario();
        //MenuUsuarioJF.setVisible(true);
    }//GEN-LAST:event_btnSalModProActionPerformed

    private void btnMostarModProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostarModProActionPerformed
        // TODO add your handling code here:
        String Datos_Producto = txtPlacaModPro.getText();
        CargarDatos(Datos_Producto);
    }//GEN-LAST:event_btnMostarModProActionPerformed

    private void txtPlacaModProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlacaModProKeyTyped
        // TODO add your handling code here:
        txtPlacaModPro.addKeyListener(new KeyAdapter() {
             
            public void keyReleased(final KeyEvent e) {
            String cadena = (txtPlacaModPro.getText()).trim();
            txtPlacaModPro.setText(cadena);
            repaint();
            filtro();
        }
        });
            tr = new TableRowSorter(tblModProd.getModel());
            tblModProd.setRowSorter(tr);
            char c = evt.getKeyChar();
            if(Character.isLowerCase(c))
            {
                String cad = (""+c).toUpperCase();
                c=cad.charAt(0);
                evt.setKeyChar(c);
                
            }
    }//GEN-LAST:event_txtPlacaModProKeyTyped

    private void txtColorModProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtColorModProKeyTyped
        // TODO add your handling code here:
        String texto = txtColorModPro.getText();
        if(texto.length()>0){
            char primeraletra = texto.charAt(0);
            texto = Character.toUpperCase(primeraletra)+texto.substring(1, texto.length());
            txtColorModPro.setText(texto);
        }  
    }//GEN-LAST:event_txtColorModProKeyTyped

    private void txtModeloModProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModeloModProKeyTyped
        // TODO add your handling code here:
         String texto = txtModeloModPro.getText();
        if(texto.length()>0){
            char primeraletra = texto.charAt(0);
            texto = Character.toUpperCase(primeraletra)+texto.substring(1, texto.length());
            txtModeloModPro.setText(texto);
        }  
      
    }//GEN-LAST:event_txtModeloModProKeyTyped

    private void txtPlacaModProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlacaModProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlacaModProActionPerformed

    private void txtAnioModProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnioModProKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingrese solo Números");
        }
    }//GEN-LAST:event_txtAnioModProKeyTyped

    private void txtValorModProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorModProKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingrese solo Números");
        }
    }//GEN-LAST:event_txtValorModProKeyTyped

    private void cboTipModProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipModProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTipModProActionPerformed

    private void cboMarcaModProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMarcaModProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboMarcaModProActionPerformed

    private void btnCarModPro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarModPro2ActionPerformed
        // TODO add your handling code here:
        bandera = true;
        ImgProducto2 ImgProductoJF = new ImgProducto2();
        ImgProductoJF.setVisible(true); 
    }//GEN-LAST:event_btnCarModPro2ActionPerformed

    private void btnCarModPro3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarModPro3ActionPerformed
        // TODO add your handling code here:
        bandera = true;
        ImgProducto3 ImgProductoJF = new ImgProducto3();
        ImgProductoJF.setVisible(true); 
    }//GEN-LAST:event_btnCarModPro3ActionPerformed

    private void btnCarModPro4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarModPro4ActionPerformed
        // TODO add your handling code here:
        bandera = true;
        ImgProducto4 ImgProductoJF = new ImgProducto4();
        ImgProductoJF.setVisible(true); 
    }//GEN-LAST:event_btnCarModPro4ActionPerformed

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
            java.util.logging.Logger.getLogger(ModProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCanModPro;
    private javax.swing.JButton btnCarModPro;
    private javax.swing.JButton btnCarModPro2;
    private javax.swing.JButton btnCarModPro3;
    private javax.swing.JButton btnCarModPro4;
    private javax.swing.JButton btnModModPro;
    private javax.swing.JButton btnMosModPro;
    private javax.swing.JButton btnMostarModPro;
    private javax.swing.JButton btnSalModPro;
    private javax.swing.JButton btnVerModPro;
    private javax.swing.JComboBox cboMarcaModPro;
    private javax.swing.JComboBox cboTipModPro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel lblAnioModPro;
    private javax.swing.JLabel lblColorModPro;
    private javax.swing.JLabel lblIconoModPro;
    private javax.swing.JLabel lblMarcaModPro;
    private javax.swing.JLabel lblModeloModPro;
    private javax.swing.JLabel lblPlacaModPro;
    private javax.swing.JLabel lblTipModPro;
    private javax.swing.JLabel lblTitModPro;
    private javax.swing.JLabel lblValorModPro;
    private javax.swing.JPanel pnlInfModPro;
    private javax.swing.JPanel pnlMosModPro;
    private javax.swing.JScrollPane scpModProd;
    private javax.swing.JTable tblModProd;
    private javax.swing.JTextField txtAnioModPro;
    private javax.swing.JTextField txtColorModPro;
    private javax.swing.JTextField txtModeloModPro;
    private javax.swing.JTextField txtPlacaModPro;
    private javax.swing.JTextField txtValorModPro;
    // End of variables declaration//GEN-END:variables
}
