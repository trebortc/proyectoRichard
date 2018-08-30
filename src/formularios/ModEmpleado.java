package formularios;


import conexion.ConexionMySQL;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.EmptyStackException;
import javax.swing.JOptionPane;
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
public class ModEmpleado extends javax.swing.JFrame {
DefaultTableModel Empleado;
private TableRowSorter tr;
    /**
     * Creates new form ModEmpleado
     */
    public ModEmpleado() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(79,157,157));
        tblModEmp.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
    
         @Override
         public void valueChanged(ListSelectionEvent e){
             if(tblModEmp.getSelectedRow() != -1)
         {
             
            int fila = tblModEmp.getSelectedRow();
            txtCedModEmp.setText(tblModEmp.getValueAt(fila, 0).toString());
            txtPriNomModEmp.setText(tblModEmp.getValueAt(fila, 1).toString());
            txtSegNomModEmp.setText(tblModEmp.getValueAt(fila, 2).toString());
            txtPriApeModEmp.setText(tblModEmp.getValueAt(fila, 3).toString());
            txtSegApeModEmp.setText(tblModEmp.getValueAt(fila, 4).toString());
            dtpFecNacModEmp.setDate((java.util.Date) tblModEmp.getValueAt(fila, 5));
            cboGenModEmp.setSelectedItem(tblModEmp.getValueAt(fila, 6));         
            txtTelModEmp.setText(tblModEmp.getValueAt(fila, 7).toString());
            txtCiuModEmp.setText(tblModEmp.getValueAt(fila, 8).toString());
            txtDirModEmp.setText(tblModEmp.getValueAt(fila, 9).toString());
            txtMailModEmp.setText(tblModEmp.getValueAt(fila, 10).toString());
     }
    }
    });
        
    }
     public void filtro() {
    tr.setRowFilter(RowFilter.regexFilter(txtCedModEmp.getText(), 0));
    }
    
    void CargarTabla(Object Informacion)
    {
        try
        {
            String sSQL="";
            String[] Titulos = {"CÉDULA", "PRI. NOMBRE", "SEG. NOMBBRE", "PRI. APELLIDO", "SEG. APELLIDO", "FECHA NACIMIENTO", "GÉNERO", "TELÉFONO", "CIUDAD", "DIRECCIÓN", "MAIL"};
            //Object[] Datos = new Object[9];
            Object Datos[]= new Object[11];
            
            Empleado = new DefaultTableModel(null,Titulos);

            ConexionMySQL mysql = new ConexionMySQL();
            Connection cn = mysql.Conectar();

            sSQL = "SELECT ci_emp, pnom_emp, snom_emp, pape_emp, sape_emp, fec_nac, gen, telf, ciu, dir, mail FROM empleado "
                    + "WHERE CONCAT(ci_emp) LIKE '%"+Informacion+"%'";

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while(rs.next())
            {
                        Datos[0] = rs.getString("ci_emp");
                        Datos[1] = rs.getString("pnom_emp");
                        Datos[2] = rs.getString("snom_emp");
                        Datos[3] = rs.getString("pape_emp");
                        Datos[4] = rs.getString("sape_emp");
                        Datos[5] = rs.getDate("fec_nac");
                        Datos[6] = rs.getString("gen");
                        Datos[7] = rs.getString("telf");
                        Datos[8] = rs.getString("ciu");
                        Datos[9] = rs.getString("dir");
                        Datos[10] = rs.getString("mail");                     

                        Empleado.addRow(Datos);
            }
            tblModEmp.setModel(Empleado);
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

            String Cedula_E = "";
            String Nombre_P = "";
            String Nombre_S = "";
            String Apellido_P= "";
            String Apellido_S = "";
            Date Fecha = null ;
           
            String Genero = "";
            String Telefono = "";
            String Ciudad = "";
            String Direccion = "";
            String Mail = "";
           

            ConexionMySQL mysql = new ConexionMySQL();
            Connection cn = mysql.Conectar();

            sSQL = "SELECT ci_emp, pnom_emp, snom_emp, pape_emp, sape_emp, fec_nac, gen, telf, ciu, dir, mail  FROM empleado "
                    + "WHERE CONCAT(ci_emp) LIKE '%"+Datos_Producto+"%'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while(rs.next())
            {
               
                 Cedula_E = rs.getString("ci_emp");
                 Nombre_P = rs.getString("pnom_emp");
                 Nombre_S = rs.getString("snom_emp");
                 Apellido_P = rs.getString("pape_emp");
                 Apellido_S = rs.getString("sape_emp");
                 Fecha = rs.getDate("fec_nac");
                 Telefono = rs.getString("telf");
                 Ciudad = rs.getString("ciu");
                 Direccion = rs.getString("dir");
                 Mail = rs.getString("mail");    

              
            }
            txtCedModEmp.setText(Cedula_E);
            txtPriNomModEmp.setText(Nombre_P);
            txtSegNomModEmp.setText(Nombre_S);
            txtPriApeModEmp.setText(Apellido_P);
            txtSegApeModEmp.setText(Apellido_S);
            dtpFecNacModEmp.setDate(Fecha);
            txtCiuModEmp.setText(Ciudad);
            txtTelModEmp.setText(Telefono);
            txtDirModEmp.setText(Direccion);
            txtMailModEmp.setText(Mail);


        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    void Borrar()
    {
            txtCedModEmp.setText("");
            txtPriNomModEmp.setText("");
            txtSegNomModEmp.setText("");
            txtPriApeModEmp.setText("");
            txtSegApeModEmp.setText("");
            dtpFecNacModEmp.setDate(null);
            txtDirModEmp.setText("");
            txtCiuModEmp.setText("");
            txtTelModEmp.setText("");
            txtMailModEmp.setText("");
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

        lblIconoModEmp = new javax.swing.JLabel();
        lblTitModEmp = new javax.swing.JLabel();
        pnlMosModEmp = new javax.swing.JPanel();
        scpModEmp = new javax.swing.JScrollPane();
        tblModEmp = new javax.swing.JTable();
        btnMosModEmp = new javax.swing.JButton();
        pnlInfModEmp = new javax.swing.JPanel();
        lblPriNomModEmp = new javax.swing.JLabel();
        lblCedModEmp = new javax.swing.JLabel();
        lblCiuModEmp = new javax.swing.JLabel();
        lblDirModEmp = new javax.swing.JLabel();
        lblTelModEmp = new javax.swing.JLabel();
        lblMailModEmp = new javax.swing.JLabel();
        lblGenModEmp = new javax.swing.JLabel();
        txtPriNomModEmp = new javax.swing.JTextField();
        txtCedModEmp = new javax.swing.JTextField();
        txtCiuModEmp = new javax.swing.JTextField();
        txtDirModEmp = new javax.swing.JTextField();
        txtTelModEmp = new javax.swing.JTextField();
        txtMailModEmp = new javax.swing.JTextField();
        cboGenModEmp = new javax.swing.JComboBox<>();
        dtpFecNacModEmp = new com.toedter.calendar.JDateChooser();
        lblFecNacModEmp = new javax.swing.JLabel();
        lblPriApeModEmp = new javax.swing.JLabel();
        lblSegNomModEmp = new javax.swing.JLabel();
        lblSegApeModEmp = new javax.swing.JLabel();
        txtSegNomModEmp = new javax.swing.JTextField();
        txtPriApeModEmp = new javax.swing.JTextField();
        txtSegApeModEmp = new javax.swing.JTextField();
        btnModModEmp = new javax.swing.JButton();
        btnMostarModEmp = new javax.swing.JButton();
        btnCanModEmp = new javax.swing.JButton();
        btnSalModEmp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblIconoModEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/empleados.png"))); // NOI18N

        lblTitModEmp.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitModEmp.setText("MODIFICAR LOS DATOS DEL EMPLEADO");

        pnlMosModEmp.setBackground(new java.awt.Color(79, 157, 157));
        pnlMosModEmp.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Empleado"));

        tblModEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        scpModEmp.setViewportView(tblModEmp);

        btnMosModEmp.setBackground(new java.awt.Color(79, 157, 157));
        btnMosModEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cargar.png"))); // NOI18N
        btnMosModEmp.setText("MOSTRAR DATOS");
        btnMosModEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMosModEmpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMosModEmpLayout = new javax.swing.GroupLayout(pnlMosModEmp);
        pnlMosModEmp.setLayout(pnlMosModEmpLayout);
        pnlMosModEmpLayout.setHorizontalGroup(
            pnlMosModEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMosModEmpLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlMosModEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMosModEmpLayout.createSequentialGroup()
                        .addComponent(btnMosModEmp)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scpModEmp, javax.swing.GroupLayout.DEFAULT_SIZE, 1173, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlMosModEmpLayout.setVerticalGroup(
            pnlMosModEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMosModEmpLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(btnMosModEmp)
                .addGap(5, 5, 5)
                .addComponent(scpModEmp, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlInfModEmp.setBackground(new java.awt.Color(79, 157, 157));
        pnlInfModEmp.setBorder(javax.swing.BorderFactory.createTitledBorder("Información Empleado"));

        lblPriNomModEmp.setText("Primer Nombre *");

        lblCedModEmp.setText("Cédula *");

        lblCiuModEmp.setText("Ciudad *");

        lblDirModEmp.setText("Dirección *");

        lblTelModEmp.setText("Teléfono *");

        lblMailModEmp.setText("E-Mail");

        lblGenModEmp.setText("Sexo *");

        txtPriNomModEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriNomModEmpActionPerformed(evt);
            }
        });
        txtPriNomModEmp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPriNomModEmpKeyTyped(evt);
            }
        });

        txtCedModEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedModEmpActionPerformed(evt);
            }
        });
        txtCedModEmp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedModEmpKeyTyped(evt);
            }
        });

        txtCiuModEmp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCiuModEmpKeyTyped(evt);
            }
        });

        txtDirModEmp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDirModEmpKeyTyped(evt);
            }
        });

        txtMailModEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMailModEmpActionPerformed(evt);
            }
        });
        txtMailModEmp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMailModEmpKeyTyped(evt);
            }
        });

        cboGenModEmp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------------", "Femenino", "Masculino" }));
        cboGenModEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGenModEmpActionPerformed(evt);
            }
        });

        lblFecNacModEmp.setText("Fecha Nacimiento *");

        lblPriApeModEmp.setText("Primer Apellido *");

        lblSegNomModEmp.setText("Segundo Nombre");

        lblSegApeModEmp.setText("Segundo Apellido");

        txtSegNomModEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSegNomModEmpActionPerformed(evt);
            }
        });
        txtSegNomModEmp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSegNomModEmpKeyTyped(evt);
            }
        });

        txtPriApeModEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriApeModEmpActionPerformed(evt);
            }
        });
        txtPriApeModEmp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPriApeModEmpKeyTyped(evt);
            }
        });

        txtSegApeModEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSegApeModEmpActionPerformed(evt);
            }
        });
        txtSegApeModEmp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSegApeModEmpKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout pnlInfModEmpLayout = new javax.swing.GroupLayout(pnlInfModEmp);
        pnlInfModEmp.setLayout(pnlInfModEmpLayout);
        pnlInfModEmpLayout.setHorizontalGroup(
            pnlInfModEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfModEmpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInfModEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInfModEmpLayout.createSequentialGroup()
                        .addGroup(pnlInfModEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCedModEmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCiuModEmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDirModEmp, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(lblGenModEmp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(14, 14, 14)
                        .addGroup(pnlInfModEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInfModEmpLayout.createSequentialGroup()
                                .addGroup(pnlInfModEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDirModEmp, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cboGenModEmp, javax.swing.GroupLayout.Alignment.TRAILING, 0, 170, Short.MAX_VALUE)
                                    .addComponent(txtCiuModEmp))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtCedModEmp)))
                    .addGroup(pnlInfModEmpLayout.createSequentialGroup()
                        .addGroup(pnlInfModEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPriNomModEmp, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(lblPriApeModEmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlInfModEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPriApeModEmp, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(txtPriNomModEmp))))
                .addGroup(pnlInfModEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInfModEmpLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblSegNomModEmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSegNomModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInfModEmpLayout.createSequentialGroup()
                        .addGroup(pnlInfModEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInfModEmpLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblSegApeModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlInfModEmpLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblTelModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSegApeModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInfModEmpLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pnlInfModEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFecNacModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMailModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(pnlInfModEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtpFecNacModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMailModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        pnlInfModEmpLayout.setVerticalGroup(
            pnlInfModEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfModEmpLayout.createSequentialGroup()
                .addGroup(pnlInfModEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedModEmp)
                    .addComponent(txtCedModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnlInfModEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPriNomModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPriNomModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSegNomModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSegNomModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnlInfModEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPriApeModEmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSegApeModEmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPriApeModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSegApeModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnlInfModEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInfModEmpLayout.createSequentialGroup()
                        .addGroup(pnlInfModEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlInfModEmpLayout.createSequentialGroup()
                                .addGroup(pnlInfModEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblGenModEmp)
                                    .addComponent(lblFecNacModEmp))
                                .addGap(11, 11, 11))
                            .addGroup(pnlInfModEmpLayout.createSequentialGroup()
                                .addComponent(cboGenModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))
                        .addGroup(pnlInfModEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInfModEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtDirModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblTelModEmp)
                                .addComponent(txtTelModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlInfModEmpLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(lblDirModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8)
                        .addGroup(pnlInfModEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCiuModEmp)
                            .addComponent(txtCiuModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInfModEmpLayout.createSequentialGroup()
                        .addComponent(dtpFecNacModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlInfModEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMailModEmp)
                            .addComponent(txtMailModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8))
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

        btnMostarModEmp.setBackground(new java.awt.Color(79, 157, 157));
        btnMostarModEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mostrar.png"))); // NOI18N
        btnMostarModEmp.setText("MOSTRAR");
        btnMostarModEmp.setMaximumSize(new java.awt.Dimension(122, 33));
        btnMostarModEmp.setMinimumSize(new java.awt.Dimension(122, 33));
        btnMostarModEmp.setPreferredSize(new java.awt.Dimension(122, 33));
        btnMostarModEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostarModEmpActionPerformed(evt);
            }
        });

        btnCanModEmp.setBackground(new java.awt.Color(79, 157, 157));
        btnCanModEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar.png"))); // NOI18N
        btnCanModEmp.setText("CANCELAR");
        btnCanModEmp.setMaximumSize(new java.awt.Dimension(122, 33));
        btnCanModEmp.setMinimumSize(new java.awt.Dimension(122, 33));
        btnCanModEmp.setPreferredSize(new java.awt.Dimension(122, 33));
        btnCanModEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanModEmpActionPerformed(evt);
            }
        });

        btnSalModEmp.setBackground(new java.awt.Color(79, 157, 157));
        btnSalModEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida.png"))); // NOI18N
        btnSalModEmp.setText("SALIR");
        btnSalModEmp.setMaximumSize(new java.awt.Dimension(122, 33));
        btnSalModEmp.setMinimumSize(new java.awt.Dimension(122, 33));
        btnSalModEmp.setPreferredSize(new java.awt.Dimension(122, 33));
        btnSalModEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalModEmpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIconoModEmp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitModEmp)
                .addGap(343, 343, 343))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlMosModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addComponent(btnModModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnMostarModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnCanModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnSalModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(pnlInfModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(lblTitModEmp))
                    .addComponent(lblIconoModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMosModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(pnlInfModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMostarModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCanModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalModEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMosModEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMosModEmpActionPerformed
        // TODO add your handling code here:
        String Informacion = txtCedModEmp.getText();
        CargarTabla(Informacion);
    }//GEN-LAST:event_btnMosModEmpActionPerformed

    private void txtPriNomModEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriNomModEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriNomModEmpActionPerformed

    private void txtCedModEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedModEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedModEmpActionPerformed

    private void txtMailModEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMailModEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMailModEmpActionPerformed

    private void cboGenModEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGenModEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboGenModEmpActionPerformed

    private void txtSegNomModEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSegNomModEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSegNomModEmpActionPerformed

    private void txtPriApeModEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriApeModEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriApeModEmpActionPerformed

    private void txtSegApeModEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSegApeModEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSegApeModEmpActionPerformed

    private void btnModModEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModModEmpActionPerformed
        // TODO add your handling code here:
        
       
        int Pregunta;
        Pregunta = JOptionPane.showConfirmDialog(null,"Desea Modifiacar Los Datos","Pregunta" ,0);
        if (Pregunta==0)
        {
            try
            {
                try
                {
                    String Mensaje="";
                    String sSQL="";

                    String Cedula_E;
                    String Nombre_P;
                    String Apellido_P;
                    String Nombre_S;
                    String Apellido_S;
                    Date Fecha;
                    String Genero;
                    String Ciudad;
                    String Direccion;
                    String Telefono;
                    String Mail;

                    Cedula_E = txtCedModEmp.getText();
                    Nombre_P = txtPriNomModEmp.getText();
                    Nombre_S = txtSegNomModEmp.getText();
                    Apellido_P = txtPriApeModEmp.getText();
                    Apellido_S = txtSegApeModEmp.getText();
                    Fecha = new java.sql.Date(dtpFecNacModEmp.getDate().getTime());
                    Genero = cboGenModEmp.getSelectedItem().toString();
                    Ciudad = txtCiuModEmp.getText();
                    Direccion = txtDirModEmp.getText();
                    Telefono = txtTelModEmp.getText();
                    Mail =  txtMailModEmp.getText();

                    ConexionMySQL mysql = new ConexionMySQL();
                    Connection cn = mysql.Conectar();

                    if(Cedula_E.equals("")||Nombre_P.equals("")||Apellido_P.equals("")||
                            Ciudad.equals("")||Direccion.equals("")||Genero.equals("")||
                            Fecha.equals("")||Mail.equals("")||Telefono.equals("")){
                       JOptionPane.showMessageDialog(null, "Llene todos los campos requeridos");
                       }
                 
                    else{
                        if(Cedula_E.length()!=10||ValidarNum(Cedula_E)==false||ValidarLetras(Nombre_P)==false||
                                ValidarLetras(Nombre_S)==false||ValidarLetras(Apellido_P)==false||
                                ValidarLetras(Apellido_S)==false||ValidarLetras(Ciudad)==false||
                                ValidarLetras(Genero)==false||ValidarNum(Telefono)==false){
                            JOptionPane.showMessageDialog(null, "Campos llenos de manera incorrecta");
                        }

                    else{
                        

                        sSQL = "UPDATE empleado SET  pnom_emp = '"+Nombre_P+"', snom_emp = '"+Nombre_S+"', pape_emp = '"+Apellido_P+"', sape_emp = '"+Apellido_S+"', fec_nac = '"+Fecha +"', gen = '"+Genero+"', telf = '"+Telefono+"', ciu = '"+Ciudad+"', dir = '"+Direccion+"', mail = '"+Mail+"'" ;
                        sSQL = sSQL+ "WHERE ci_emp = '"+Cedula_E+"'";

                        Mensaje ="DATOS MODIFICADOS DE FORMA CORRECTA";
                        Statement st = cn.createStatement();
                        int n = st.executeUpdate(sSQL);
                
                         if(n>0)
                         {
                          JOptionPane.showMessageDialog(null, Mensaje);
                         }
                        String Informacion = lblIconoModEmp.getText();
                        CargarTabla(Informacion);
                        Borrar();

                        }
                    
                        }
                }catch(java.lang.NullPointerException e) 
                    
                   {
                       JOptionPane.showMessageDialog(null, "LLene todos los campos requeridos");
                            //JOptionPane.showMessageDialog(null, "El código postal no existe o no esta cargado","ADVERTENCIA",JOptionPane.WARNING_MESSAGE)
                   }
                
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
                  }
    }//GEN-LAST:event_btnModModEmpActionPerformed

    private void btnMostarModEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostarModEmpActionPerformed
        // TODO add your handling code here:
        String Datos_Producto = txtCedModEmp.getText();
        CargarDatos(Datos_Producto);
    }//GEN-LAST:event_btnMostarModEmpActionPerformed

    private void btnCanModEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanModEmpActionPerformed
        // TODO add your handling code here:
        Borrar();
    }//GEN-LAST:event_btnCanModEmpActionPerformed

    private void btnSalModEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalModEmpActionPerformed
        // TODO add your handling code here:
        this.dispose();
        //MenuUsuario MenuUsuarioJF = new MenuUsuario();
        //MenuUsuarioJF.setVisible(true);
    }//GEN-LAST:event_btnSalModEmpActionPerformed

    private void txtCedModEmpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedModEmpKeyTyped
        // TODO add your handling code here:
        txtCedModEmp.addKeyListener(new KeyAdapter() {
             
            public void keyReleased(final KeyEvent e) {
            String cadena = (txtCedModEmp.getText()).trim();
            txtCedModEmp.setText(cadena);
            repaint();
            filtro();
        }
        });
            tr = new TableRowSorter(tblModEmp.getModel());
            tblModEmp.setRowSorter(tr);
    }//GEN-LAST:event_txtCedModEmpKeyTyped

    private void txtPriNomModEmpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriNomModEmpKeyTyped
        // TODO add your handling code here:
        String texto = txtPriNomModEmp.getText();
        if(texto.length()>0){
            char primeraletra = texto.charAt(0);
            texto = Character.toUpperCase(primeraletra)+texto.substring(1, texto.length());
            txtPriNomModEmp.setText(texto);
        }
    }//GEN-LAST:event_txtPriNomModEmpKeyTyped

    private void txtSegNomModEmpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSegNomModEmpKeyTyped
        // TODO add your handling code here:
        String texto = txtSegNomModEmp.getText();
        if(texto.length()>0){
            char primeraletra = texto.charAt(0);
            texto = Character.toUpperCase(primeraletra)+texto.substring(1, texto.length());
            txtSegNomModEmp.setText(texto);
        }
    }//GEN-LAST:event_txtSegNomModEmpKeyTyped

    private void txtPriApeModEmpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriApeModEmpKeyTyped
        // TODO add your handling code here:
         String texto = txtPriApeModEmp.getText();
        if(texto.length()>0){
            char primeraletra = texto.charAt(0);
            texto = Character.toUpperCase(primeraletra)+texto.substring(1, texto.length());
            txtPriApeModEmp.setText(texto);
        }
    }//GEN-LAST:event_txtPriApeModEmpKeyTyped

    private void txtSegApeModEmpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSegApeModEmpKeyTyped
        // TODO add your handling code here:
         String texto = txtSegApeModEmp.getText();
        if(texto.length()>0){
            char primeraletra = texto.charAt(0);
            texto = Character.toUpperCase(primeraletra)+texto.substring(1, texto.length());
            txtSegApeModEmp.setText(texto);
        }
    }//GEN-LAST:event_txtSegApeModEmpKeyTyped

    private void txtDirModEmpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDirModEmpKeyTyped
        // TODO add your handling code here:
        String texto = txtDirModEmp.getText();
        if(texto.length()>0){
            char primeraletra = texto.charAt(0);
            texto = Character.toUpperCase(primeraletra)+texto.substring(1, texto.length());
            txtDirModEmp.setText(texto);
        }
    }//GEN-LAST:event_txtDirModEmpKeyTyped

    private void txtCiuModEmpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCiuModEmpKeyTyped
        // TODO add your handling code here:
         String texto = txtCiuModEmp.getText();
        if(texto.length()>0){
            char primeraletra = texto.charAt(0);
            texto = Character.toUpperCase(primeraletra)+texto.substring(1, texto.length());
            txtCiuModEmp.setText(texto);
        }
    }//GEN-LAST:event_txtCiuModEmpKeyTyped

    private void txtMailModEmpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMailModEmpKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isUpperCase(c)){
            String cad = (""+c).toLowerCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtMailModEmpKeyTyped

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
            java.util.logging.Logger.getLogger(ModEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCanModEmp;
    private javax.swing.JButton btnModModEmp;
    private javax.swing.JButton btnMosModEmp;
    private javax.swing.JButton btnMostarModEmp;
    private javax.swing.JButton btnSalModEmp;
    private javax.swing.JComboBox<String> cboGenModEmp;
    private com.toedter.calendar.JDateChooser dtpFecNacModEmp;
    private javax.swing.JLabel lblCedModEmp;
    private javax.swing.JLabel lblCiuModEmp;
    private javax.swing.JLabel lblDirModEmp;
    private javax.swing.JLabel lblFecNacModEmp;
    private javax.swing.JLabel lblGenModEmp;
    private javax.swing.JLabel lblIconoModEmp;
    private javax.swing.JLabel lblMailModEmp;
    private javax.swing.JLabel lblPriApeModEmp;
    private javax.swing.JLabel lblPriNomModEmp;
    private javax.swing.JLabel lblSegApeModEmp;
    private javax.swing.JLabel lblSegNomModEmp;
    private javax.swing.JLabel lblTelModEmp;
    private javax.swing.JLabel lblTitModEmp;
    private javax.swing.JPanel pnlInfModEmp;
    private javax.swing.JPanel pnlMosModEmp;
    private javax.swing.JScrollPane scpModEmp;
    private javax.swing.JTable tblModEmp;
    private javax.swing.JTextField txtCedModEmp;
    private javax.swing.JTextField txtCiuModEmp;
    private javax.swing.JTextField txtDirModEmp;
    private javax.swing.JTextField txtMailModEmp;
    private javax.swing.JTextField txtPriApeModEmp;
    private javax.swing.JTextField txtPriNomModEmp;
    private javax.swing.JTextField txtSegApeModEmp;
    private javax.swing.JTextField txtSegNomModEmp;
    private javax.swing.JTextField txtTelModEmp;
    // End of variables declaration//GEN-END:variables
}
