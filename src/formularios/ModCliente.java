package formularios;


import conexion.ConexionMySQL;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
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
public class ModCliente extends javax.swing.JFrame {
DefaultTableModel Cliente;
private TableRowSorter tr;
    /**
     * Creates new form ModCliente
     */
    public ModCliente() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(79,157,157));
        tblModCli.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
    
         @Override
         public void valueChanged(ListSelectionEvent e){
             if(tblModCli.getSelectedRow() != -1)
         {
             
            int fila = tblModCli.getSelectedRow();
            txtCedModCli.setText(tblModCli.getValueAt(fila, 0).toString());
            txtPriNomModCli.setText(tblModCli.getValueAt(fila, 1).toString());
            txtSegNomModCli.setText(tblModCli.getValueAt(fila, 2).toString());
            txtPriApeModCli.setText(tblModCli.getValueAt(fila, 3).toString());
            txtSegApeModCli.setText(tblModCli.getValueAt(fila, 4).toString());
            dtpFecNacModCli.setDate((java.util.Date) tblModCli.getValueAt(fila, 5));
            cboGenModCli.setSelectedItem(tblModCli.getValueAt(fila, 6));         
            txtTelModCli.setText(tblModCli.getValueAt(fila, 7).toString());
            txtCiuModCli.setText(tblModCli.getValueAt(fila, 8).toString());
            txtDirModCli.setText(tblModCli.getValueAt(fila, 9).toString());
            txtMailModCli.setText(tblModCli.getValueAt(fila, 10).toString());
     }
    }
    });
    }
     public void filtro() {
    tr.setRowFilter(RowFilter.regexFilter(txtCedModCli.getText(), 0));
    }
    void CargarTabla(Object Informacion)
    {
        try
        {
            String sSQL="";
            String[] Titulos = {"CÉDULA", "PRI. NOMBRE", "SEG. NOMBBRE", "PRI. APELLIDO", "SEG. APELLIDO", "FECHA NACIMIENTO", "GÉNERO", "TELÉFONO", "CIUDAD", "DIRECCIÓN", "MAIL"};
            //Object[] Datos = new Object[9];
            Object Datos[]= new Object[11];
            
            Cliente = new DefaultTableModel(null,Titulos);

            ConexionMySQL mysql = new ConexionMySQL();
            Connection cn = mysql.Conectar();

            sSQL = "SELECT ci_cli, pnom_cli, snom_cli, pape_cli, sape_cli, fec_nac, gen, telf, ciu, dir, mail FROM cliente "
                    + "WHERE CONCAT(ci_cli) LIKE '%"+Informacion+"%'";

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while(rs.next())
            {
                        Datos[0] = rs.getString("ci_cli");
                        Datos[1] = rs.getString("pnom_cli");
                        Datos[2] = rs.getString("snom_cli");
                        Datos[3] = rs.getString("pape_cli");
                        Datos[4] = rs.getString("sape_cli");
                        Datos[5] = rs.getDate("fec_nac");
                        Datos[6] = rs.getString("gen");
                        Datos[7] = rs.getString("telf");
                        Datos[8] = rs.getString("ciu");
                        Datos[9] = rs.getString("dir");
                        Datos[10] = rs.getString("mail");                     

                        Cliente.addRow(Datos);
            }
            tblModCli.setModel(Cliente);
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

            String Cedula_C = "";
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

            sSQL = "SELECT ci_cli, pnom_cli, snom_cli, pape_cli, sape_cli, fec_nac, gen, telf, ciu, dir, mail  FROM cliente "
                    + "WHERE CONCAT(ci_cli) LIKE '%"+Datos_Producto+"%'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while(rs.next())
            {
               
                 Cedula_C = rs.getString("ci_cli");
                 Nombre_P = rs.getString("pnom_cli");
                 Nombre_S = rs.getString("snom_cli");
                 Apellido_P = rs.getString("pape_cli");
                 Apellido_S = rs.getString("sape_cli");
                 Fecha = rs.getDate("fec_nac");
                 Genero = rs.getString("gen");
                 Telefono = rs.getString("telf");
                 Ciudad = rs.getString("ciu");
                 Direccion = rs.getString("dir");
                 Mail = rs.getString("mail");    

              
            }
            txtCedModCli.setText(Cedula_C);
            txtPriNomModCli.setText(Nombre_P);
            txtSegNomModCli.setText(Nombre_S);
            txtPriApeModCli.setText(Apellido_P);
            txtSegApeModCli.setText(Apellido_S);
            dtpFecNacModCli.setDate(Fecha);
            //txtGenModEmp.
            txtCiuModCli.setText(Ciudad);
            txtTelModCli.setText(Telefono);
            txtDirModCli.setText(Direccion);
            txtMailModCli.setText(Mail);


        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    void Borrar()
    {
            txtCedModCli.setText("");
            txtPriNomModCli.setText("");
            txtSegNomModCli.setText("");
            txtPriApeModCli.setText("");
            txtSegApeModCli.setText("");
            dtpFecNacModCli.setDate(null);
            txtDirModCli.setText("");
            txtCiuModCli.setText("");
            txtTelModCli.setText("");
            txtMailModCli.setText("");
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

        lblIconoModCli = new javax.swing.JLabel();
        lblTituloModCli = new javax.swing.JLabel();
        pnlMosModCli = new javax.swing.JPanel();
        scpMosModCli = new javax.swing.JScrollPane();
        tblModCli = new javax.swing.JTable();
        btnMosModCli = new javax.swing.JButton();
        scpMosModCli1 = new javax.swing.JScrollPane();
        tblModCli1 = new javax.swing.JTable();
        pnlInfModCli = new javax.swing.JPanel();
        lblPriNomModCli = new javax.swing.JLabel();
        lblCedModCli = new javax.swing.JLabel();
        lblCiuModCli = new javax.swing.JLabel();
        lblDirModCli = new javax.swing.JLabel();
        lblTelModCli = new javax.swing.JLabel();
        lblMailModCli = new javax.swing.JLabel();
        lblGenModCli = new javax.swing.JLabel();
        txtPriNomModCli = new javax.swing.JTextField();
        txtCedModCli = new javax.swing.JTextField();
        txtCiuModCli = new javax.swing.JTextField();
        txtDirModCli = new javax.swing.JTextField();
        txtTelModCli = new javax.swing.JTextField();
        txtMailModCli = new javax.swing.JTextField();
        cboGenModCli = new javax.swing.JComboBox<>();
        dtpFecNacModCli = new com.toedter.calendar.JDateChooser();
        lblFecNacModCli = new javax.swing.JLabel();
        lblPriApeModCli = new javax.swing.JLabel();
        lblSegNomModCli = new javax.swing.JLabel();
        lblSegApeModCli = new javax.swing.JLabel();
        txtSegNomModCli = new javax.swing.JTextField();
        txtPriApeModCli = new javax.swing.JTextField();
        txtSegApeModCli = new javax.swing.JTextField();
        btnModCli = new javax.swing.JButton();
        btnMostrarCli = new javax.swing.JButton();
        btnCanModCli = new javax.swing.JButton();
        btnSalModCli = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblIconoModCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clientes.png"))); // NOI18N

        lblTituloModCli.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTituloModCli.setText("MODIFICAR LOS DATOS DEL CLIENTE");

        pnlMosModCli.setBackground(new java.awt.Color(79, 157, 157));
        pnlMosModCli.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Clientes"));

        tblModCli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        scpMosModCli.setViewportView(tblModCli);

        btnMosModCli.setBackground(new java.awt.Color(79, 157, 157));
        btnMosModCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cargar.png"))); // NOI18N
        btnMosModCli.setText("MOSTRAR DATOS");
        btnMosModCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMosModCliActionPerformed(evt);
            }
        });

        tblModCli1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        scpMosModCli1.setViewportView(tblModCli1);

        javax.swing.GroupLayout pnlMosModCliLayout = new javax.swing.GroupLayout(pnlMosModCli);
        pnlMosModCli.setLayout(pnlMosModCliLayout);
        pnlMosModCliLayout.setHorizontalGroup(
            pnlMosModCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMosModCliLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnMosModCli)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(scpMosModCli, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnlMosModCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlMosModCliLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scpMosModCli1)
                    .addContainerGap()))
        );
        pnlMosModCliLayout.setVerticalGroup(
            pnlMosModCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMosModCliLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(btnMosModCli, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(scpMosModCli, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
            .addGroup(pnlMosModCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMosModCliLayout.createSequentialGroup()
                    .addContainerGap(51, Short.MAX_VALUE)
                    .addComponent(scpMosModCli1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pnlInfModCli.setBackground(new java.awt.Color(79, 157, 157));
        pnlInfModCli.setBorder(javax.swing.BorderFactory.createTitledBorder("Información Empleado"));

        lblPriNomModCli.setText("Primer Nombre *");

        lblCedModCli.setText("Cédula *");

        lblCiuModCli.setText(" Ciudad *");

        lblDirModCli.setText("Dirección *");

        lblTelModCli.setText("Teléfono *");

        lblMailModCli.setText("E-Mail *");

        lblGenModCli.setText("Sexo *");

        txtPriNomModCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriNomModCliActionPerformed(evt);
            }
        });
        txtPriNomModCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPriNomModCliKeyTyped(evt);
            }
        });

        txtCedModCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedModCliActionPerformed(evt);
            }
        });
        txtCedModCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedModCliKeyTyped(evt);
            }
        });

        txtCiuModCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCiuModCliKeyTyped(evt);
            }
        });

        txtDirModCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDirModCliKeyTyped(evt);
            }
        });

        txtMailModCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMailModCliActionPerformed(evt);
            }
        });
        txtMailModCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMailModCliKeyTyped(evt);
            }
        });

        cboGenModCli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------------", "Femenino", "Masculino" }));
        cboGenModCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGenModCliActionPerformed(evt);
            }
        });

        lblFecNacModCli.setText("Fecha Nacimiento *");

        lblPriApeModCli.setText("Primer Apellido *");

        lblSegNomModCli.setText("Segundo Nombre");

        lblSegApeModCli.setText("Segundo Apellido");

        txtSegNomModCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSegNomModCliActionPerformed(evt);
            }
        });
        txtSegNomModCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSegNomModCliKeyTyped(evt);
            }
        });

        txtPriApeModCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriApeModCliActionPerformed(evt);
            }
        });
        txtPriApeModCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPriApeModCliKeyTyped(evt);
            }
        });

        txtSegApeModCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSegApeModCliActionPerformed(evt);
            }
        });
        txtSegApeModCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSegApeModCliKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout pnlInfModCliLayout = new javax.swing.GroupLayout(pnlInfModCli);
        pnlInfModCli.setLayout(pnlInfModCliLayout);
        pnlInfModCliLayout.setHorizontalGroup(
            pnlInfModCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfModCliLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInfModCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInfModCliLayout.createSequentialGroup()
                        .addGroup(pnlInfModCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCedModCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblGenModCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDirModCli, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                            .addComponent(lblCiuModCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addGroup(pnlInfModCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInfModCliLayout.createSequentialGroup()
                                .addGroup(pnlInfModCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDirModCli, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cboGenModCli, javax.swing.GroupLayout.Alignment.TRAILING, 0, 170, Short.MAX_VALUE)
                                    .addComponent(txtCiuModCli))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtCedModCli)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInfModCliLayout.createSequentialGroup()
                        .addGroup(pnlInfModCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPriNomModCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPriApeModCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlInfModCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPriNomModCli)
                            .addComponent(txtPriApeModCli, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))))
                .addGroup(pnlInfModCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInfModCliLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblSegNomModCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSegNomModCli, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInfModCliLayout.createSequentialGroup()
                        .addGroup(pnlInfModCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInfModCliLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblSegApeModCli, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlInfModCliLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblTelModCli, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSegApeModCli, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInfModCliLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pnlInfModCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFecNacModCli, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMailModCli, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(pnlInfModCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelModCli, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtpFecNacModCli, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMailModCli, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        pnlInfModCliLayout.setVerticalGroup(
            pnlInfModCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfModCliLayout.createSequentialGroup()
                .addGroup(pnlInfModCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedModCli)
                    .addComponent(txtCedModCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnlInfModCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPriNomModCli, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPriNomModCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSegNomModCli, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSegNomModCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnlInfModCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPriApeModCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSegApeModCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPriApeModCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSegApeModCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlInfModCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInfModCliLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(pnlInfModCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlInfModCliLayout.createSequentialGroup()
                                .addGroup(pnlInfModCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblGenModCli)
                                    .addComponent(lblFecNacModCli))
                                .addGap(14, 14, 14))
                            .addGroup(pnlInfModCliLayout.createSequentialGroup()
                                .addComponent(cboGenModCli, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))
                        .addGroup(pnlInfModCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInfModCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtDirModCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblTelModCli)
                                .addComponent(txtTelModCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlInfModCliLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(lblDirModCli, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(pnlInfModCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInfModCliLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(txtCiuModCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInfModCliLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCiuModCli))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInfModCliLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(dtpFecNacModCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlInfModCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMailModCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlInfModCliLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(lblMailModCli, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(8, 8, 8))
        );

        btnModCli.setBackground(new java.awt.Color(79, 157, 157));
        btnModCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/modificar.png"))); // NOI18N
        btnModCli.setText("MODIFICAR");
        btnModCli.setMaximumSize(new java.awt.Dimension(122, 33));
        btnModCli.setMinimumSize(new java.awt.Dimension(122, 33));
        btnModCli.setPreferredSize(new java.awt.Dimension(122, 33));
        btnModCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModCliActionPerformed(evt);
            }
        });

        btnMostrarCli.setBackground(new java.awt.Color(79, 157, 157));
        btnMostrarCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mostrar.png"))); // NOI18N
        btnMostrarCli.setText("MOSTRAR");
        btnMostrarCli.setMaximumSize(new java.awt.Dimension(122, 33));
        btnMostrarCli.setMinimumSize(new java.awt.Dimension(122, 33));
        btnMostrarCli.setPreferredSize(new java.awt.Dimension(122, 33));
        btnMostrarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarCliActionPerformed(evt);
            }
        });

        btnCanModCli.setBackground(new java.awt.Color(79, 157, 157));
        btnCanModCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar.png"))); // NOI18N
        btnCanModCli.setText("CANCELAR");
        btnCanModCli.setMaximumSize(new java.awt.Dimension(122, 33));
        btnCanModCli.setMinimumSize(new java.awt.Dimension(122, 33));
        btnCanModCli.setPreferredSize(new java.awt.Dimension(122, 33));
        btnCanModCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanModCliActionPerformed(evt);
            }
        });

        btnSalModCli.setBackground(new java.awt.Color(79, 157, 157));
        btnSalModCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida.png"))); // NOI18N
        btnSalModCli.setText("SALIR");
        btnSalModCli.setMaximumSize(new java.awt.Dimension(122, 33));
        btnSalModCli.setMinimumSize(new java.awt.Dimension(122, 33));
        btnSalModCli.setPreferredSize(new java.awt.Dimension(122, 33));
        btnSalModCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalModCliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlMosModCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblIconoModCli)
                                .addGap(295, 295, 295)
                                .addComponent(lblTituloModCli)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(pnlInfModCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(300, 300, 300)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(330, 330, 330)
                .addComponent(btnModCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnMostrarCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnCanModCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnSalModCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIconoModCli)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(lblTituloModCli)))
                .addGap(5, 5, 5)
                .addComponent(pnlMosModCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlInfModCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMostrarCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCanModCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalModCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMosModCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMosModCliActionPerformed
        // TODO add your handling code here:
        String Cliente = txtCedModCli.getText();
        CargarTabla(Cliente);
    }//GEN-LAST:event_btnMosModCliActionPerformed

    private void txtPriNomModCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriNomModCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriNomModCliActionPerformed

    private void txtCedModCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedModCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedModCliActionPerformed

    private void txtMailModCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMailModCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMailModCliActionPerformed

    private void cboGenModCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGenModCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboGenModCliActionPerformed

    private void txtSegNomModCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSegNomModCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSegNomModCliActionPerformed

    private void txtPriApeModCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriApeModCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriApeModCliActionPerformed

    private void txtSegApeModCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSegApeModCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSegApeModCliActionPerformed

    private void btnModCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModCliActionPerformed
        // TODO add your handling code here:
        int Pregunta;
        Pregunta = JOptionPane.showConfirmDialog(null,"Desea Modifiacar Los Datos","Pregunta" ,0);
        if (Pregunta==0)
        {
            try
            {
                try
                {
                    String sSQL="";
                    String Mensaje="";

                    String Cedula_C;
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

                    Cedula_C = txtCedModCli.getText();
                    Nombre_P = txtPriNomModCli.getText();
                    Nombre_S = txtSegNomModCli.getText();
                    Apellido_P = txtPriApeModCli.getText();
                    Apellido_S = txtSegApeModCli.getText();
                    Fecha = new java.sql.Date(dtpFecNacModCli.getDate().getTime());
                    Genero = cboGenModCli.getSelectedItem().toString();
                    Ciudad = txtCiuModCli.getText();
                    Direccion = txtDirModCli.getText();
                    Telefono = txtTelModCli.getText();
                    Mail =  txtMailModCli.getText();

                    ConexionMySQL mysql = new ConexionMySQL();
                    Connection cn = mysql.Conectar();

                    if(Cedula_C.equals("")||Nombre_P.equals("")||Apellido_P.equals("")||Ciudad.equals("")||
                        Direccion.equals("")||Genero.equals("")||Fecha.equals("")||Mail.equals("")||Telefono.equals("")){
                        JOptionPane.showMessageDialog(null, "Llene todos los campos requeridos");
                    }

                    else{
                        if(Cedula_C.length()!=10||ValidarNum(Cedula_C)==false||ValidarLetras(Nombre_P)==false||ValidarLetras(Nombre_S)==false||ValidarLetras(Apellido_P)==false||
                            ValidarLetras(Apellido_S)==false||ValidarLetras(Ciudad)==false||
                            ValidarLetras(Genero)==false||ValidarNum(Telefono)==false){
                            JOptionPane.showMessageDialog(null, "Campos llenos de manera incorrecta");
                        }

                        else{

                    sSQL = "UPDATE cliente SET  pnom_cli = '"+Nombre_P+"', snom_cli = '"+Nombre_S+"', pape_cli = '"+Apellido_P+"', sape_cli = '"+Apellido_S+"', fec_nac = '"+Fecha +"', gen = '"+Genero+"', telf = '"+Telefono+"', ciu = '"+Ciudad+"', dir = '"+Direccion+"', mail = '"+Mail+"'" ;
                    sSQL = sSQL+ "WHERE  ci_cli = '"+Cedula_C+"'";

                    Mensaje ="DATOS MODIFICADOS DE FORMA CORRECTA";
                    Statement st = cn.createStatement();
                    int n = st.executeUpdate(sSQL);

                    if(n>0)
                    {
                        JOptionPane.showMessageDialog(null, Mensaje);
                    }
                    String Informacion = lblIconoModCli.getText();
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

    }//GEN-LAST:event_btnModCliActionPerformed

    private void btnMostrarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarCliActionPerformed
        // TODO add your handling code here:
        String Datos_Cliente = txtCedModCli.getText();
        CargarDatos(Datos_Cliente);
    }//GEN-LAST:event_btnMostrarCliActionPerformed

    private void btnCanModCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanModCliActionPerformed
        // TODO add your handling code here:
        Borrar();
    }//GEN-LAST:event_btnCanModCliActionPerformed

    private void btnSalModCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalModCliActionPerformed
        // TODO add your handling code here:
        this.dispose();
        //MenuUsuario MenuUsuarioJF = new MenuUsuario();
        //MenuUsuarioJF.setVisible(true);
    }//GEN-LAST:event_btnSalModCliActionPerformed

    private void txtCedModCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedModCliKeyTyped
        // TODO add your handling code here:
         txtCedModCli.addKeyListener(new KeyAdapter() {
             
            public void keyReleased(final KeyEvent e) {
            String cadena = (txtCedModCli.getText()).trim();
            txtCedModCli.setText(cadena);
            repaint();
            filtro();
        }
        });
            tr = new TableRowSorter(tblModCli.getModel());
            tblModCli.setRowSorter(tr);
    }//GEN-LAST:event_txtCedModCliKeyTyped

    private void txtPriNomModCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriNomModCliKeyTyped
        // TODO add your handling code here:.
        String texto = txtPriNomModCli.getText();
        if(texto.length()>0){
            char primeraletra = texto.charAt(0);
            texto = Character.toUpperCase(primeraletra)+texto.substring(1, texto.length());
            txtPriNomModCli.setText(texto);
        }
    }//GEN-LAST:event_txtPriNomModCliKeyTyped

    private void txtSegNomModCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSegNomModCliKeyTyped
        // TODO add your handling code here:
        String texto = txtSegNomModCli.getText();
        if(texto.length()>0){
            char primeraletra = texto.charAt(0);
            texto = Character.toUpperCase(primeraletra)+texto.substring(1, texto.length());
            txtSegNomModCli.setText(texto);
        }
    }//GEN-LAST:event_txtSegNomModCliKeyTyped

    private void txtPriApeModCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriApeModCliKeyTyped
        // TODO add your handling code here:
        String texto = txtPriApeModCli.getText();
        if(texto.length()>0){
            char primeraletra = texto.charAt(0);
            texto = Character.toUpperCase(primeraletra)+texto.substring(1, texto.length());
            txtPriApeModCli.setText(texto);
        }
    }//GEN-LAST:event_txtPriApeModCliKeyTyped

    private void txtSegApeModCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSegApeModCliKeyTyped
        // TODO add your handling code here:
        String texto = txtSegApeModCli.getText();
        if(texto.length()>0){
            char primeraletra = texto.charAt(0);
            texto = Character.toUpperCase(primeraletra)+texto.substring(1, texto.length());
            txtSegApeModCli.setText(texto);
        }
    }//GEN-LAST:event_txtSegApeModCliKeyTyped

    private void txtDirModCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDirModCliKeyTyped
        // TODO add your handling code here:
       String texto = txtDirModCli.getText();
        if(texto.length()>0){
            char primeraletra = texto.charAt(0);
            texto = Character.toUpperCase(primeraletra)+texto.substring(1, texto.length());
            txtDirModCli.setText(texto);
        }
    }//GEN-LAST:event_txtDirModCliKeyTyped

    private void txtCiuModCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCiuModCliKeyTyped
        // TODO add your handling code here:
        String texto = txtCiuModCli.getText();
        if(texto.length()>0){
            char primeraletra = texto.charAt(0);
            texto = Character.toUpperCase(primeraletra)+texto.substring(1, texto.length());
            txtCiuModCli.setText(texto);
        }
    }//GEN-LAST:event_txtCiuModCliKeyTyped

    private void txtMailModCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMailModCliKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isUpperCase(c)){
            String cad = (""+c).toLowerCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtMailModCliKeyTyped

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
            java.util.logging.Logger.getLogger(ModCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCanModCli;
    private javax.swing.JButton btnModCli;
    private javax.swing.JButton btnMosModCli;
    private javax.swing.JButton btnMostrarCli;
    private javax.swing.JButton btnSalModCli;
    private javax.swing.JComboBox<String> cboGenModCli;
    private com.toedter.calendar.JDateChooser dtpFecNacModCli;
    private javax.swing.JLabel lblCedModCli;
    private javax.swing.JLabel lblCiuModCli;
    private javax.swing.JLabel lblDirModCli;
    private javax.swing.JLabel lblFecNacModCli;
    private javax.swing.JLabel lblGenModCli;
    private javax.swing.JLabel lblIconoModCli;
    private javax.swing.JLabel lblMailModCli;
    private javax.swing.JLabel lblPriApeModCli;
    private javax.swing.JLabel lblPriNomModCli;
    private javax.swing.JLabel lblSegApeModCli;
    private javax.swing.JLabel lblSegNomModCli;
    private javax.swing.JLabel lblTelModCli;
    private javax.swing.JLabel lblTituloModCli;
    private javax.swing.JPanel pnlInfModCli;
    private javax.swing.JPanel pnlMosModCli;
    private javax.swing.JScrollPane scpMosModCli;
    private javax.swing.JScrollPane scpMosModCli1;
    private javax.swing.JTable tblModCli;
    private javax.swing.JTable tblModCli1;
    private javax.swing.JTextField txtCedModCli;
    private javax.swing.JTextField txtCiuModCli;
    private javax.swing.JTextField txtDirModCli;
    private javax.swing.JTextField txtMailModCli;
    private javax.swing.JTextField txtPriApeModCli;
    private javax.swing.JTextField txtPriNomModCli;
    private javax.swing.JTextField txtSegApeModCli;
    private javax.swing.JTextField txtSegNomModCli;
    private javax.swing.JTextField txtTelModCli;
    // End of variables declaration//GEN-END:variables
}
