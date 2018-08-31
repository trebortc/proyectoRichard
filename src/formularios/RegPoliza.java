package formularios;


import clases.SessionAvendano;
import conexion.ConexionMySQL;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
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
public class RegPoliza extends javax.swing.JFrame {
    DefaultComboBoxModel Poliza, Placa, Nom_Pro;
    private Map<String,Integer> mapPlacaValor;
    
    /**
     * Creates new form InfPoliza
     */
    public RegPoliza() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(79,157,157));
        Cargar_Nombre();
        Cargar();
        Cargar_placa();
        cboNomRegPol.setEditable(true); //para poder escribir adentro
        AutoCompleteDecorator.decorate(this.cboNomRegPol);
        cboPlaRegPol.setEditable(true); //para poder escribir adentro
        AutoCompleteDecorator.decorate(this.cboPlaRegPol);
        cboAseRegPol.setEditable(true); //para poder escribir adentro
        AutoCompleteDecorator.decorate(this.cboAseRegPol);
        agregarListerComboPlaca();
        agregarListenerPorcentaje();
        cboPlaRegPol.setSelectedIndex(0);
    }
    void Cargar_Nombre()
    {
        try
        {
            String Nombre_Propietario;
            String sSQL="";

            Nom_Pro = new DefaultComboBoxModel();
            ConexionMySQL mysql = new ConexionMySQL();
            Connection cn = mysql.Conectar();

            //Solo hace la consulta de los clientes con estado de activo
            sSQL = "SELECT ci_cli FROM cliente where estado='A'";

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next())
            {
                Nombre_Propietario = rs.getString("ci_cli");
                Nom_Pro.addElement(Nombre_Propietario);
            }
            cboNomRegPol.setModel(Nom_Pro);

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    void Cargar_placa()
    {
        try
        {
            String Placa_V;
            Integer valorVehiculo;
            String sSQL="";

            ConexionMySQL mysql = new ConexionMySQL();
            Connection cn = mysql.Conectar();

            Placa = new DefaultComboBoxModel();
            mapPlacaValor=new HashMap<String,Integer>();

            sSQL = "SELECT matri_vehi,val FROM vehiculo";

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while(rs.next())
            {
                Placa_V = rs.getString("matri_vehi");
                valorVehiculo=rs.getInt("val");
                Placa.addElement(Placa_V);
                mapPlacaValor.put(Placa_V, valorVehiculo);
                
            }
            cboPlaRegPol.setModel(Placa);

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
     void Borrar()
    {
        txtNumRegPol.setText("");
        txtValorRegPol.setText("");
        cboNomRegPol.setSelectedItem("Seleccione");
        cboPlaRegPol.setSelectedItem("Seleccione");
        cboAseRegPol.setSelectedItem("Seleccione");
        cboEmiDiaRegPol.setSelectedItem("d");
        cboEmiMesRegPol.setSelectedItem("m");
        cboEmiAnioRegPol.setSelectedItem("a");
        cboFirDiaRegPol.setSelectedItem("d");
        cboFirMesRegPol.setSelectedItem("m");
        cboFirAnioRegPol.setSelectedItem("a");
        cboVigDiaRegPol.setSelectedItem("d");
        cboVigMesRegPol.setSelectedItem("m");
        cboVigAnioRegPol.setSelectedItem("a");
               
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
            if(!((palabra.charAt(i) > 43 && palabra.charAt(i) < 58)))
                return false;
        }
        return true;
    }


    void Cargar()
    {
        try
        {
            String Nombre;

            String sSQL="";

            Poliza = new DefaultComboBoxModel();

            ConexionMySQL mysql = new ConexionMySQL();
            Connection cn = mysql.Conectar();

            sSQL = "SELECT nom_emp FROM aseguradora";

            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while(rs.next())
            {
                Nombre = rs.getString("nom_emp");
                Poliza.addElement(Nombre);
            }
            cboAseRegPol.setModel(Poliza);
        }
        catch(Exception e)
        {
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

        lblIconoRegPol = new javax.swing.JLabel();
        lblTitRegPol = new javax.swing.JLabel();
        pnlPlaRegPol = new javax.swing.JPanel();
        cboPlaRegPol = new javax.swing.JComboBox();
        pnlDatRegPol = new javax.swing.JPanel();
        lblNumRegPol = new javax.swing.JLabel();
        lblAseRegPol = new javax.swing.JLabel();
        lblFecEmiRegPol = new javax.swing.JLabel();
        lblFecFirRegPol = new javax.swing.JLabel();
        lblFecVigRegPol = new javax.swing.JLabel();
        cboFirDiaRegPol = new javax.swing.JComboBox();
        cboVigMesRegPol = new javax.swing.JComboBox();
        cboVigDiaRegPol = new javax.swing.JComboBox();
        cboEmiMesRegPol = new javax.swing.JComboBox();
        cboVigAnioRegPol = new javax.swing.JComboBox();
        cboEmiDiaRegPol = new javax.swing.JComboBox();
        cboFirMesRegPol = new javax.swing.JComboBox();
        txtNumRegPol = new javax.swing.JTextField();
        cboEmiAnioRegPol = new javax.swing.JComboBox();
        cboFirAnioRegPol = new javax.swing.JComboBox();
        lblValPriRegPol = new javax.swing.JLabel();
        txtValorRegPol = new javax.swing.JTextField();
        cboAseRegPol = new javax.swing.JComboBox();
        btnMostrarRegPol = new javax.swing.JButton();
        txtPorcentajePrima = new javax.swing.JTextField();
        btnCancelarRegPol = new javax.swing.JButton();
        btnGuardarRegPol = new javax.swing.JButton();
        btnSalirRegPol = new javax.swing.JButton();
        pnlCedRegProPol = new javax.swing.JPanel();
        cboNomRegPol = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AVENDAÑO AGENCIA DE SEGUROS");
        setName("frmRegPoliza"); // NOI18N

        lblIconoRegPol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/poliza.png"))); // NOI18N

        lblTitRegPol.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitRegPol.setText("DATOS DE LA PÓLIZA");

        pnlPlaRegPol.setBackground(new java.awt.Color(79, 157, 157));
        pnlPlaRegPol.setBorder(javax.swing.BorderFactory.createTitledBorder("Placa de Vehículo"));

        cboPlaRegPol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione" }));
        cboPlaRegPol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPlaRegPolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPlaRegPolLayout = new javax.swing.GroupLayout(pnlPlaRegPol);
        pnlPlaRegPol.setLayout(pnlPlaRegPolLayout);
        pnlPlaRegPolLayout.setHorizontalGroup(
            pnlPlaRegPolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlaRegPolLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(cboPlaRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        pnlPlaRegPolLayout.setVerticalGroup(
            pnlPlaRegPolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlaRegPolLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboPlaRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDatRegPol.setBackground(new java.awt.Color(79, 157, 157));
        pnlDatRegPol.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Póliza"));

        lblNumRegPol.setText("Número Póliza *");

        lblAseRegPol.setText("Aseguradora *");

        lblFecEmiRegPol.setText("Fecha de Emisión *");

        lblFecFirRegPol.setText("Fecha de Firma *");

        lblFecVigRegPol.setText("Fecha de Vigencia *");

        cboFirDiaRegPol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "d", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cboVigMesRegPol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "m", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));

        cboVigDiaRegPol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "d", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cboEmiMesRegPol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "m", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));

        cboVigAnioRegPol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "a", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", " " }));

        cboEmiDiaRegPol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "d", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cboFirMesRegPol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "m", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));

        cboEmiAnioRegPol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "a", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", " " }));

        cboFirAnioRegPol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "a", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", " " }));

        lblValPriRegPol.setText("Valor Prima * %");

        txtValorRegPol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorRegPolActionPerformed(evt);
            }
        });

        cboAseRegPol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione" }));
        cboAseRegPol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboAseRegPolActionPerformed(evt);
            }
        });

        btnMostrarRegPol.setBackground(new java.awt.Color(79, 157, 157));
        btnMostrarRegPol.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnMostrarRegPol.setText("MOSTRAR INFORMACIÓN DE COBERTURA GENERAL");
        btnMostrarRegPol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarRegPolActionPerformed(evt);
            }
        });

        txtPorcentajePrima.setText("4");

        javax.swing.GroupLayout pnlDatRegPolLayout = new javax.swing.GroupLayout(pnlDatRegPol);
        pnlDatRegPol.setLayout(pnlDatRegPolLayout);
        pnlDatRegPolLayout.setHorizontalGroup(
            pnlDatRegPolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatRegPolLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pnlDatRegPolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMostrarRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDatRegPolLayout.createSequentialGroup()
                        .addGroup(pnlDatRegPolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDatRegPolLayout.createSequentialGroup()
                                .addGroup(pnlDatRegPolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFecEmiRegPol)
                                    .addComponent(lblNumRegPol))
                                .addGap(32, 32, 32))
                            .addGroup(pnlDatRegPolLayout.createSequentialGroup()
                                .addComponent(lblValPriRegPol)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPorcentajePrima, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(pnlDatRegPolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDatRegPolLayout.createSequentialGroup()
                                .addComponent(txtValorRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnlDatRegPolLayout.createSequentialGroup()
                                .addGroup(pnlDatRegPolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNumRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlDatRegPolLayout.createSequentialGroup()
                                        .addComponent(cboEmiDiaRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)
                                        .addComponent(cboEmiMesRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)
                                        .addComponent(cboEmiAnioRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlDatRegPolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFecFirRegPol)
                                    .addComponent(lblAseRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(pnlDatRegPolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboAseRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlDatRegPolLayout.createSequentialGroup()
                                        .addComponent(cboFirDiaRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)
                                        .addComponent(cboFirMesRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)
                                        .addComponent(cboFirAnioRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblFecVigRegPol)
                                .addGap(20, 20, 20)
                                .addComponent(cboVigDiaRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(cboVigMesRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(cboVigAnioRegPol, 0, 70, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        pnlDatRegPolLayout.setVerticalGroup(
            pnlDatRegPolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatRegPolLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(pnlDatRegPolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumRegPol)
                    .addComponent(txtNumRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAseRegPol)
                    .addComponent(cboAseRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(pnlDatRegPolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFecEmiRegPol)
                    .addComponent(cboEmiDiaRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboEmiMesRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboEmiAnioRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFecFirRegPol)
                    .addComponent(cboFirDiaRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboFirMesRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboFirAnioRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFecVigRegPol)
                    .addComponent(cboVigDiaRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboVigMesRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboVigAnioRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(pnlDatRegPolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValPriRegPol)
                    .addComponent(txtValorRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPorcentajePrima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnMostrarRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCancelarRegPol.setBackground(new java.awt.Color(79, 157, 157));
        btnCancelarRegPol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar.png"))); // NOI18N
        btnCancelarRegPol.setText("CANCELAR");
        btnCancelarRegPol.setMaximumSize(new java.awt.Dimension(122, 33));
        btnCancelarRegPol.setMinimumSize(new java.awt.Dimension(122, 33));
        btnCancelarRegPol.setPreferredSize(new java.awt.Dimension(122, 33));
        btnCancelarRegPol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarRegPolActionPerformed(evt);
            }
        });

        btnGuardarRegPol.setBackground(new java.awt.Color(79, 157, 157));
        btnGuardarRegPol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        btnGuardarRegPol.setText("GUARDAR");
        btnGuardarRegPol.setMaximumSize(new java.awt.Dimension(122, 33));
        btnGuardarRegPol.setMinimumSize(new java.awt.Dimension(122, 33));
        btnGuardarRegPol.setPreferredSize(new java.awt.Dimension(122, 33));
        btnGuardarRegPol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarRegPolActionPerformed(evt);
            }
        });

        btnSalirRegPol.setBackground(new java.awt.Color(79, 157, 157));
        btnSalirRegPol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida.png"))); // NOI18N
        btnSalirRegPol.setText("SALIR");
        btnSalirRegPol.setMaximumSize(new java.awt.Dimension(122, 33));
        btnSalirRegPol.setMinimumSize(new java.awt.Dimension(122, 33));
        btnSalirRegPol.setPreferredSize(new java.awt.Dimension(122, 33));
        btnSalirRegPol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirRegPolActionPerformed(evt);
            }
        });

        pnlCedRegProPol.setBackground(new java.awt.Color(79, 157, 157));
        pnlCedRegProPol.setBorder(javax.swing.BorderFactory.createTitledBorder("Cédula Propietario"));

        cboNomRegPol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione" }));
        cboNomRegPol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNomRegPolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCedRegProPolLayout = new javax.swing.GroupLayout(pnlCedRegProPol);
        pnlCedRegProPol.setLayout(pnlCedRegProPolLayout);
        pnlCedRegProPolLayout.setHorizontalGroup(
            pnlCedRegProPolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCedRegProPolLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(cboNomRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        pnlCedRegProPolLayout.setVerticalGroup(
            pnlCedRegProPolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCedRegProPolLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboNomRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlDatRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnlCedRegProPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(pnlPlaRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblIconoRegPol)
                                .addGap(201, 201, 201)
                                .addComponent(lblTitRegPol))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(btnGuardarRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnCancelarRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnSalirRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lblIconoRegPol))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(lblTitRegPol)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlPlaRegPol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCedRegProPol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDatRegPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(btnCancelarRegPol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardarRegPol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalirRegPol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtValorRegPolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorRegPolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorRegPolActionPerformed

    private void cboAseRegPolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboAseRegPolActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cboAseRegPolActionPerformed

    private void btnMostrarRegPolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarRegPolActionPerformed
        // TODO add your handling code here:
        //this.dispose();
        MosProformas MosProformasJF = new MosProformas();
        MosProformasJF.setVisible(true);
    }//GEN-LAST:event_btnMostrarRegPolActionPerformed

    private void btnCancelarRegPolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarRegPolActionPerformed
        // TODO add your handling code here:
        Borrar();
    }//GEN-LAST:event_btnCancelarRegPolActionPerformed

    private void btnGuardarRegPolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarRegPolActionPerformed
        // TODO add your handling code here:
        try
        {
            ConexionMySQL mysql = new ConexionMySQL();
            Connection cn = mysql.Conectar();

            String sSQL="";
            String Mensaje="";

            String Numero_Pol;
            String Aseguradora;
            String Cliente;
            String Placa;
            

            String Emi_D;
            String Emi_M;
            String Emi_A;

            String Fir_D;
            String Fir_M;
            String Fir_A;

            String Vig_D;
            String Vig_M;
            String Vig_A;

            String Valor_Pri;

            Numero_Pol = txtNumRegPol.getText();
            Aseguradora = cboAseRegPol.getSelectedItem().toString();

            Emi_D = cboEmiDiaRegPol.getSelectedItem().toString();
            Emi_M = cboEmiMesRegPol.getSelectedItem().toString();
            Emi_A = cboEmiAnioRegPol.getSelectedItem().toString();

            Fir_D = cboFirDiaRegPol.getSelectedItem().toString();
            Fir_M = cboFirMesRegPol.getSelectedItem().toString();
            Fir_A = cboFirAnioRegPol.getSelectedItem().toString();

            Vig_D = cboVigDiaRegPol.getSelectedItem().toString();
            Vig_M = cboVigMesRegPol.getSelectedItem().toString();
            Vig_A = cboVigAnioRegPol.getSelectedItem().toString();

            Valor_Pri = txtValorRegPol.getText();
            Cliente = cboNomRegPol.getSelectedItem().toString();
            Placa = cboPlaRegPol.getSelectedItem().toString();

            if(Numero_Pol.equals("")||Valor_Pri.equals("")||Emi_D.equals("d")||Emi_M.equals("m")||Emi_A.equals("a")||
                Fir_D.equals("d")||Fir_M.equals("m")||Fir_A.equals("a")||
                Vig_D.equals("d")||Vig_M.equals("m")||Vig_A.equals("a")){
                JOptionPane.showMessageDialog(null, "Llene todos los campos requeridos");
            }
            else{
                if(ValidarNum(Numero_Pol)==false||ValidarNum(Valor_Pri)==false){
                    JOptionPane.showMessageDialog(null, "Campos llenos de manera incorrecta");
                }

                else{
                    
                    //Validar que no exista ingresado un vehiculo con esa poliza
                    if(verificarPolizaIngresadaPlaca(Placa))
                    {
                        JOptionPane.showMessageDialog(null,"No se puede grabar porque ya existe ingresado una poliza con esa placa");
                        return;
                    }
                    
                    
                    //Validacion adicional de la fecha de emision que no puede ser anterior a la fecha actual
                    String dia= cboEmiDiaRegPol.getSelectedItem().toString();
                    String mes= cboEmiMesRegPol.getSelectedItem().toString();
                    String anio= cboEmiAnioRegPol.getSelectedItem().toString();
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                    
                    java.util.Date fechaHoy = new Date();
                    
                    Date fechaEmision=sdf.parse(anio+"-"+mes+"-"+dia);
                    Date fechaActual=sdf.parse(sdf.format(fechaHoy));
                    
                    //Si la fecha es menor que la de hoy lanzo una excepcion
                    System.out.println(fechaEmision.compareTo(fechaHoy));
                    if(fechaEmision.compareTo(fechaActual)<0)
                    {
                        JOptionPane.showMessageDialog(null,"La fecha de emision no puede ser menor a la fecha actual");
                        return;
                    }
                    
                    /**
                     * Validar que las fecha de vigencia no pueda ser menor que un año
                     */  
                    dia = cboVigDiaRegPol.getSelectedItem().toString();
                    mes = cboVigMesRegPol.getSelectedItem().toString();
                    anio = cboVigAnioRegPol.getSelectedItem().toString();
                    
                    Date fechaVigencia=sdf.parse(anio+"-"+mes+"-"+dia);
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(fechaEmision);
                    
                    cal.add(Calendar.YEAR,1);
                    
                    Date fechaActualMasAnio = cal.getTime();
                    
                    System.out.println(sdf.format(fechaActualMasAnio));
                    
                    if(fechaVigencia.compareTo(fechaActualMasAnio)<0)
                    {
                        JOptionPane.showMessageDialog(null,"La fecha de vigencia tiene que ser mayor que 1 año de la fecha de emisión");
                        return;
                    }
                    
                    
                    /////////////////////////////////////////////
                    try
                    {
                                          
                        sSQL = "INSERT INTO poliza(num_poliza, aseg, emi_d, emi_m, emi_a, fir_d, fir_m, fir_a, vig_d, vig_m, vig_a, val_pri, nom_cli, num_pla,USUARIO_INGRESO)"
                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        Mensaje = "DATOS GUARDADOS DE FORMA CORRECTA";

                        PreparedStatement pst = cn.prepareStatement(sSQL);

                        pst.setString(1, Numero_Pol);
                        pst.setString(2, Aseguradora);
                        pst.setString(3, Emi_D);
                        pst.setString(4, Emi_M);
                        pst.setString(5, Emi_A);
                        pst.setString(6, Fir_D);
                        pst.setString(7, Fir_M);
                        pst.setString(8, Fir_A);
                        pst.setString(9, Vig_D);
                        pst.setString(10, Vig_M);
                        pst.setString(11, Vig_A);
                        pst.setString(12, Valor_Pri);
                        pst.setString(13, Cliente);
                        pst.setString(14, Placa);
                        pst.setString(15,SessionAvendano.nickSession);

                        int n = pst.executeUpdate();

                        if(n>0)
                        {
                            JOptionPane.showMessageDialog(null, Mensaje);
                        }
                    }catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e) 
                        {
                            JOptionPane.showMessageDialog(null, "La póliza ya esta registrada");
                            //JOptionPane.showMessageDialog(null, "El código postal no existe o no esta cargado","ADVERTENCIA",JOptionPane.WARNING_MESSAGE)
                        }
                    Borrar();
                }
            }

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
      
    }//GEN-LAST:event_btnGuardarRegPolActionPerformed

    private void btnSalirRegPolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirRegPolActionPerformed
        // TODO add your handling code here:
        this.dispose();
        //MenuUsuario MenuUsuarioJF = new MenuUsuario();
        //MenuUsuarioJF.setVisible(true);
    }//GEN-LAST:event_btnSalirRegPolActionPerformed

    private void cboNomRegPolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNomRegPolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboNomRegPolActionPerformed

    private void cboPlaRegPolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPlaRegPolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboPlaRegPolActionPerformed

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
            java.util.logging.Logger.getLogger(RegPoliza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegPoliza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegPoliza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegPoliza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegPoliza().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarRegPol;
    private javax.swing.JButton btnGuardarRegPol;
    private javax.swing.JButton btnMostrarRegPol;
    private javax.swing.JButton btnSalirRegPol;
    private javax.swing.JComboBox cboAseRegPol;
    private javax.swing.JComboBox cboEmiAnioRegPol;
    private javax.swing.JComboBox cboEmiDiaRegPol;
    private javax.swing.JComboBox cboEmiMesRegPol;
    private javax.swing.JComboBox cboFirAnioRegPol;
    private javax.swing.JComboBox cboFirDiaRegPol;
    private javax.swing.JComboBox cboFirMesRegPol;
    private javax.swing.JComboBox cboNomRegPol;
    private javax.swing.JComboBox cboPlaRegPol;
    private javax.swing.JComboBox cboVigAnioRegPol;
    private javax.swing.JComboBox cboVigDiaRegPol;
    private javax.swing.JComboBox cboVigMesRegPol;
    private javax.swing.JLabel lblAseRegPol;
    private javax.swing.JLabel lblFecEmiRegPol;
    private javax.swing.JLabel lblFecFirRegPol;
    private javax.swing.JLabel lblFecVigRegPol;
    private javax.swing.JLabel lblIconoRegPol;
    private javax.swing.JLabel lblNumRegPol;
    private javax.swing.JLabel lblTitRegPol;
    private javax.swing.JLabel lblValPriRegPol;
    private javax.swing.JPanel pnlCedRegProPol;
    private javax.swing.JPanel pnlDatRegPol;
    private javax.swing.JPanel pnlPlaRegPol;
    private javax.swing.JTextField txtNumRegPol;
    private javax.swing.JTextField txtPorcentajePrima;
    private javax.swing.JTextField txtValorRegPol;
    // End of variables declaration//GEN-END:variables

    private void agregarListerComboPlaca() {
        cboPlaRegPol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularValorPrima();
            }
        });
    }
    
    private void calcularValorPrima()
    {
        String placa = cboPlaRegPol.getSelectedItem().toString();
        if (placa != null) {
            Integer valor = mapPlacaValor.get(placa);
            if (valor != null) {
                Integer porcentaje = Integer.parseInt(txtPorcentajePrima.getText());
                Double prima = ((double) (porcentaje * valor) / (double) 100);
                txtValorRegPol.setText(prima.toString());
            }
        }
    }

    private void agregarListenerPorcentaje() {
        txtPorcentajePrima.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularValorPrima();
            }
        });
    }
    
    private Boolean verificarPolizaIngresadaPlaca(String placa)
    {
        try {
            ConexionMySQL mysql = new ConexionMySQL();
            Connection cn = mysql.Conectar();

            String sSQL = "SELECT * FROM poliza WHERE num_pla='"+placa+"'";

            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while(rs.next())
            {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegPoliza.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
