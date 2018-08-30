package formularios;


import conexion.ConexionMySQL;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
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
public class RegSolicitud extends javax.swing.JFrame {
DefaultComboBoxModel Poliza;
    /**
     * Creates new form RegSolicitud
     */
    public RegSolicitud() {
        initComponents();
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(79,157,157));
        NumeroPoliza();
        cboNumPolSol.setEditable(true); //para poder escribir adentro
        AutoCompleteDecorator.decorate(this.cboNumPolSol);
        lblFecVigSol.setVisible(false);
        lblFecFirSol.setVisible(false);
        lblFirTitSol.setVisible(false);
        lblVigTitSol.setVisible(false);
        lblPolNoVig.setVisible(false);
        lblAnioPolNoVig.setVisible(false);
        lblMesPolNoVig.setVisible(false);
        lblDiaPolNoVig.setVisible(false);
        lblDiaFecVigSol.setVisible(false);
        lblMesFecVigSol.setVisible(false);
        lblAnioFecVigSol.setVisible(false);
    }
    
    void NumeroPoliza()
    {
        try
        {
            String Numero;
            String sSQL="";

            ConexionMySQL mysql = new ConexionMySQL();
            Connection cn = mysql.Conectar();

            Poliza = new DefaultComboBoxModel();

            sSQL = "SELECT num_poliza FROM poliza";

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next())
            {
                Numero = rs.getString("num_poliza");
                Poliza.addElement(Numero);

            }
            cboNumPolSol.setModel(Poliza);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }


    void CargarFecha(String Fecha)
    {
        try
        {
            String Dia = "";
            String Mes = "";
            String Anio = "";
            String Diafir = "";
            String Mesfir = "";
            String Aniofir = "";
            String sSQL="";
            int Fech,Fech2,Fech3,D,M,A,Fechfir,Fechfir2,Fechfir3,Dfir,Mfir,Afir;

            ConexionMySQL mysql = new ConexionMySQL();
            Connection cn = mysql.Conectar();

            sSQL = "SELECT vig_d, vig_m , vig_a, fir_d, fir_m , fir_a  FROM poliza "
                    + "WHERE CONCAT(num_poliza) LIKE '%"+Fecha+"%'";

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while(rs.next())
            {
                Dia = rs.getString("vig_d");
                Mes = rs.getString("vig_m");
                Anio = rs.getString("vig_a");
                Diafir = rs.getString("fir_d");
                Mesfir = rs.getString("fir_m");
                Aniofir = rs.getString("fir_a");
            }
            
            lblDiaFecVigSol.setText(Dia);
            lblMesFecVigSol.setText(Mes);
            lblAnioFecVigSol.setText(Anio);
            lblDiaPolNoVig.setText(Diafir);
            lblMesPolNoVig.setText(Mesfir);
            lblAnioPolNoVig.setText(Aniofir);
            Calendar Cal= Calendar.getInstance();


            String fec = Cal.get(Cal.DATE)+"";//+(
            //String fec_m = (Cal.get(Cal.MONTH)+1)+"";//+
            String fec_m = Cal.get(Cal.MONTH)+"";
            String fec_a = Cal.get(Cal.YEAR)+"";
            String fecfir = Cal.get(Cal.DATE)+"";//+(
            String fecfir_m = (Cal.get(Cal.MONTH)+1)+"";//+
            String fecfir_a = Cal.get(Cal.YEAR)+"";


            /*lblDiaPolNoVig.setText(fec);
            lblMesPolNoVig.setText(fec_m);
            lblAnioPolNoVig.setText(fec_a);*/

            Fech = Integer.parseInt(fec);
            Fech2 = Integer.parseInt(fec_m);
            Fech3 = Integer.parseInt(fec_a);
            Fechfir = Integer.parseInt(fecfir);
            Fechfir2 = Integer.parseInt(fecfir_m);
            Fechfir3 = Integer.parseInt(fecfir_a);

            D = Integer.parseInt(Dia);
            M = Integer.parseInt(Mes);
            A = Integer.parseInt(Anio);
            Dfir = Integer.parseInt(Dia);
            Mfir = Integer.parseInt(Mes);
            Afir = Integer.parseInt(Anio);


        if(A == Fech3 )
        {
            if(M >= Fech2)
            {
                if(D >= Fech)
                {
                    //JOptionPane.showConfirmDialog(null, "Hola Richard");
                    lblDiaFecVigSol.setVisible(true);
                    lblMesFecVigSol.setVisible(true);
                    lblAnioFecVigSol.setVisible(true);
                    lblDiaPolNoVig.setVisible(true);
                    lblMesPolNoVig.setVisible(true);
                    lblAnioPolNoVig.setVisible(true);
                    lblPolNoVig.setVisible(true);
                    lblPolNoVig.setText("PÓLIZA VIGENTE");
                    Habilitar();
                }
            }
        }
        else

            if(A > Fech3 )
            {
                lblDiaFecVigSol.setVisible(true);
                lblMesFecVigSol.setVisible(true);
                lblAnioFecVigSol.setVisible(true);
                lblDiaPolNoVig.setVisible(true);
                lblMesPolNoVig.setVisible(true);
                lblAnioPolNoVig.setVisible(true);
                lblPolNoVig.setVisible(true);
                lblPolNoVig.setText("PÓLIZA VIGENTE");
                Habilitar();
            }
                else
                    if(A < Fech3 )
                    {
                        lblDiaFecVigSol.setVisible(true);
                        lblMesFecVigSol.setVisible(true);
                        lblAnioFecVigSol.setVisible(true);
                        lblPolNoVig.setVisible(true);
                        lblPolNoVig.setText("PÓLIZA NO VIGENTE");
                        Inhabilitar();
                    }

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }  
    }
    
    void Inhabilitar()
    {
                        txtNumRegSol.setEnabled(false);
                        txtDesRegSol.setEnabled(false);
                        txtLugarRegSol.setEnabled(false);
                        cboDiaFecRegSol.setEnabled(false);
                        cboMesFecRegSol.setEnabled(false);
                        cboAnioFecRegSol.setEnabled(false);
                        cboHoraRegSol.setEnabled(false);
                        cboMinRegSol.setEnabled(false);
                        cboEstadoRegSol.setEnabled(false);
    }

    void Habilitar()
    {
                        txtNumRegSol.setEnabled(true);
                        txtDesRegSol.setEnabled(true);
                        txtLugarRegSol.setEnabled(true);
                        cboDiaFecRegSol.setEnabled(true);
                        cboMesFecRegSol.setEnabled(true);
                        cboAnioFecRegSol.setEnabled(true);
                        cboHoraRegSol.setEnabled(true);
                        cboMinRegSol.setEnabled(true);
                        cboEstadoRegSol.setEnabled(true);
    }

    void Borrar()
    {
        txtNumRegSol.setText("");
        txtDesRegSol.setText("");
        txtLugarRegSol.setText("");  
        cboNumPolSol.setSelectedItem("Seleccione");
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

        pnlNumRegSol = new javax.swing.JPanel();
        cboNumPolSol = new javax.swing.JComboBox();
        lblFecVigSol = new javax.swing.JLabel();
        lblDiaFecVigSol = new javax.swing.JLabel();
        lblMesFecVigSol = new javax.swing.JLabel();
        lblAnioFecVigSol = new javax.swing.JLabel();
        lblPolNoVig = new javax.swing.JLabel();
        lblDiaPolNoVig = new javax.swing.JLabel();
        lblMesPolNoVig = new javax.swing.JLabel();
        lblAnioPolNoVig = new javax.swing.JLabel();
        lblTitRegSol = new javax.swing.JLabel();
        lblIconoRegSol = new javax.swing.JLabel();
        pnlDetRegSol = new javax.swing.JPanel();
        lblDesRegSol = new javax.swing.JLabel();
        lblFechaRegSol = new javax.swing.JLabel();
        lblHoraRegSol = new javax.swing.JLabel();
        lblLugarRegSol = new javax.swing.JLabel();
        lblNumRegSol = new javax.swing.JLabel();
        txtNumRegSol = new javax.swing.JTextField();
        txtDesRegSol = new javax.swing.JTextField();
        lblEstadoRegSol = new javax.swing.JLabel();
        cboEstadoRegSol = new javax.swing.JComboBox();
        txtLugarRegSol = new javax.swing.JTextField();
        cboDiaFecRegSol = new javax.swing.JComboBox();
        cboMesFecRegSol = new javax.swing.JComboBox();
        cboAnioFecRegSol = new javax.swing.JComboBox();
        cboHoraRegSol = new javax.swing.JComboBox();
        cboMinRegSol = new javax.swing.JComboBox();
        btnGuaRegSol = new javax.swing.JButton();
        btnCanRegSol = new javax.swing.JButton();
        btnSalRegSol = new javax.swing.JButton();
        lblFecFirSol = new javax.swing.JLabel();
        lblFirTitSol = new javax.swing.JLabel();
        lblVigTitSol = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AVENDAÑO AGENCIA DE SEGUROS");
        setName("frmRegSolicitud"); // NOI18N

        pnlNumRegSol.setBackground(new java.awt.Color(79, 157, 157));
        pnlNumRegSol.setBorder(javax.swing.BorderFactory.createTitledBorder("Número Poliza"));
        pnlNumRegSol.setName(""); // NOI18N

        cboNumPolSol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione" }));
        cboNumPolSol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNumPolSolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlNumRegSolLayout = new javax.swing.GroupLayout(pnlNumRegSol);
        pnlNumRegSol.setLayout(pnlNumRegSolLayout);
        pnlNumRegSolLayout.setHorizontalGroup(
            pnlNumRegSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNumRegSolLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cboNumPolSol, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        pnlNumRegSolLayout.setVerticalGroup(
            pnlNumRegSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNumRegSolLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboNumPolSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblFecVigSol.setText("FECHA DE VIGENCIA");

        lblDiaFecVigSol.setText("d");

        lblMesFecVigSol.setText("m");

        lblAnioFecVigSol.setText("a");

        lblPolNoVig.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPolNoVig.setForeground(new java.awt.Color(255, 0, 0));
        lblPolNoVig.setText("POLIZA NO VIGENTE");

        lblDiaPolNoVig.setText("d");

        lblMesPolNoVig.setText("m");

        lblAnioPolNoVig.setText("a");

        lblTitRegSol.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitRegSol.setText("SOLICITUD DE SINIESTRO");
        lblTitRegSol.setName("frmRegSolicitud"); // NOI18N

        lblIconoRegSol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/siniestro.png"))); // NOI18N

        pnlDetRegSol.setBackground(new java.awt.Color(79, 157, 157));
        pnlDetRegSol.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles "));

        lblDesRegSol.setText("Descripción del Siniestro *");

        lblFechaRegSol.setText("Fecha *");

        lblHoraRegSol.setText("Hora *");

        lblLugarRegSol.setText("Lugar *");

        lblNumRegSol.setText("Número de Solicitud *");

        lblEstadoRegSol.setText("Estado *");

        cboEstadoRegSol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Generado" }));

        cboDiaFecRegSol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "d", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cboMesFecRegSol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "m", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));

        cboAnioFecRegSol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "a", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", " " }));

        cboHoraRegSol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "H", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
        cboHoraRegSol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboHoraRegSolActionPerformed(evt);
            }
        });

        cboMinRegSol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "M", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        javax.swing.GroupLayout pnlDetRegSolLayout = new javax.swing.GroupLayout(pnlDetRegSol);
        pnlDetRegSol.setLayout(pnlDetRegSolLayout);
        pnlDetRegSolLayout.setHorizontalGroup(
            pnlDetRegSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetRegSolLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDetRegSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumRegSol)
                    .addComponent(lblDesRegSol)
                    .addComponent(lblEstadoRegSol)
                    .addGroup(pnlDetRegSolLayout.createSequentialGroup()
                        .addGroup(pnlDetRegSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblLugarRegSol, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblFechaRegSol, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(cboDiaFecRegSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(cboMesFecRegSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(pnlDetRegSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNumRegSol)
                    .addGroup(pnlDetRegSolLayout.createSequentialGroup()
                        .addGroup(pnlDetRegSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDesRegSol, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlDetRegSolLayout.createSequentialGroup()
                                .addComponent(cboAnioFecRegSol, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(lblHoraRegSol)
                                .addGap(18, 18, 18)
                                .addComponent(cboHoraRegSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cboMinRegSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtLugarRegSol, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboEstadoRegSol, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlDetRegSolLayout.setVerticalGroup(
            pnlDetRegSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetRegSolLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlDetRegSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumRegSol)
                    .addComponent(txtNumRegSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDetRegSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDesRegSol)
                    .addComponent(txtDesRegSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(pnlDetRegSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDetRegSolLayout.createSequentialGroup()
                        .addGroup(pnlDetRegSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFechaRegSol)
                            .addGroup(pnlDetRegSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblHoraRegSol)
                                .addComponent(cboHoraRegSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboMinRegSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23)
                        .addGroup(pnlDetRegSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLugarRegSol)
                            .addComponent(txtLugarRegSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDetRegSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEstadoRegSol)
                            .addComponent(cboEstadoRegSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cboDiaFecRegSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMesFecRegSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboAnioFecRegSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGuaRegSol.setBackground(new java.awt.Color(79, 157, 157));
        btnGuaRegSol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        btnGuaRegSol.setText("GUARDAR");
        btnGuaRegSol.setMaximumSize(new java.awt.Dimension(120, 33));
        btnGuaRegSol.setMinimumSize(new java.awt.Dimension(120, 33));
        btnGuaRegSol.setPreferredSize(new java.awt.Dimension(120, 33));
        btnGuaRegSol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuaRegSolActionPerformed(evt);
            }
        });

        btnCanRegSol.setBackground(new java.awt.Color(79, 157, 157));
        btnCanRegSol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar.png"))); // NOI18N
        btnCanRegSol.setText("CANCELAR");
        btnCanRegSol.setMaximumSize(new java.awt.Dimension(122, 33));
        btnCanRegSol.setMinimumSize(new java.awt.Dimension(122, 33));
        btnCanRegSol.setPreferredSize(new java.awt.Dimension(122, 33));
        btnCanRegSol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanRegSolActionPerformed(evt);
            }
        });

        btnSalRegSol.setBackground(new java.awt.Color(79, 157, 157));
        btnSalRegSol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida.png"))); // NOI18N
        btnSalRegSol.setText("SALIR");
        btnSalRegSol.setMaximumSize(new java.awt.Dimension(122, 33));
        btnSalRegSol.setMinimumSize(new java.awt.Dimension(122, 33));
        btnSalRegSol.setPreferredSize(new java.awt.Dimension(122, 33));
        btnSalRegSol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalRegSolActionPerformed(evt);
            }
        });

        lblFecFirSol.setText("FECHA DE FIRMA");

        lblFirTitSol.setText("Día     Mes    Año");

        lblVigTitSol.setText("Día     Mes    Año");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblIconoRegSol)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPolNoVig)
                            .addComponent(lblTitRegSol)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(pnlNumRegSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDiaPolNoVig)
                                .addGap(23, 23, 23)
                                .addComponent(lblMesPolNoVig)
                                .addGap(27, 27, 27)
                                .addComponent(lblAnioPolNoVig, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblVigTitSol)
                            .addComponent(lblFecFirSol))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFirTitSol)
                            .addComponent(lblFecVigSol)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDiaFecVigSol)
                                .addGap(23, 23, 23)
                                .addComponent(lblMesFecVigSol)
                                .addGap(27, 27, 27)
                                .addComponent(lblAnioFecVigSol))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnGuaRegSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(btnCanRegSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalRegSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11))
                            .addComponent(pnlDetRegSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lblIconoRegSol)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitRegSol)
                        .addGap(34, 34, 34)
                        .addComponent(lblPolNoVig)
                        .addGap(15, 15, 15)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlNumRegSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFecFirSol)
                            .addComponent(lblFecVigSol))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblVigTitSol)
                            .addComponent(lblFirTitSol))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDiaPolNoVig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMesPolNoVig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAnioPolNoVig)
                            .addComponent(lblDiaFecVigSol)
                            .addComponent(lblMesFecVigSol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAnioFecVigSol))
                        .addGap(23, 23, 23)))
                .addComponent(pnlDetRegSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(btnCanRegSol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalRegSol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnGuaRegSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboNumPolSolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNumPolSolActionPerformed
        // TODO add your handling code here:
        String Fecha = cboNumPolSol.getSelectedItem().toString();
        CargarFecha(Fecha);
        lblFecFirSol.setVisible(true);
        lblFecVigSol.setVisible(true);
        
    }//GEN-LAST:event_cboNumPolSolActionPerformed

    private void btnGuaRegSolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuaRegSolActionPerformed
        // TODO add your handling code here:
        try
        {
            String sSQL="";
            String Mensaje="";

            String Numero_Poliza = cboNumPolSol.getSelectedItem().toString();
            String Numero_Solicitud = txtNumRegSol.getText();

            String Descripcion = txtDesRegSol.getText();

            int Dia = Integer.parseInt(cboDiaFecRegSol.getSelectedItem().toString());
            int Mes = Integer.parseInt(cboMesFecRegSol.getSelectedItem().toString());
            int Anio = Integer.parseInt(cboAnioFecRegSol.getSelectedItem().toString());

            int Hora = Integer.parseInt(cboHoraRegSol.getSelectedItem().toString());
            int Minuto = Integer.parseInt(cboMinRegSol.getSelectedItem().toString());

            String Lugar = txtLugarRegSol.getText();
            
            String Estado = cboEstadoRegSol.getSelectedItem().toString();

            ConexionMySQL mysql = new ConexionMySQL();
            Connection cn = mysql.Conectar();

            if(Lugar.equals("")||Estado.equals("Seleccione")||Descripcion.equals("")){
                JOptionPane.showMessageDialog(null, "Llene todos los campos requeridos");
            }
            else{
                if(ValidarLetras(Estado)==false){
                    JOptionPane.showMessageDialog(null, "Campos llenos de manera incorrecta");
                }
                else{

                    sSQL = "INSERT INTO solicitud(num_poliza, num_solicitud, descripcion, fecha_d, fecha_m, fecha_a, hora, minuto, lugar, estado )"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                    Mensaje ="DATOS GUARDADOS DE FORMA CORRECTA";

                    PreparedStatement pst = cn.prepareStatement(sSQL);

                    pst.setString(1, Numero_Poliza);
                    pst.setString(2, Numero_Solicitud);
                    pst.setString(3, Descripcion);
                    pst.setInt(4, Dia);
                    pst.setInt(5, Mes);
                    pst.setInt(6, Anio);
                    pst.setInt(7, Hora);
                    pst.setInt(8, Minuto);
                    pst.setString(9, Lugar);
                    pst.setString(10, Estado);

                    int n = pst.executeUpdate();
                    if(n>0)
                    {
                        JOptionPane.showMessageDialog(null, Mensaje);
                        Borrar();
                    }
                }
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error al ingresar el número de solicitud");
        }
    }//GEN-LAST:event_btnGuaRegSolActionPerformed

    private void btnCanRegSolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanRegSolActionPerformed
        // TODO add your handling code here:
        Borrar();
    }//GEN-LAST:event_btnCanRegSolActionPerformed

    private void btnSalRegSolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalRegSolActionPerformed
        // TODO add your handling code here:
        this.dispose();
        //MenuUsuario MenuUsuarioJF = new MenuUsuario();
        //MenuUsuarioJF.setVisible(true);
    }//GEN-LAST:event_btnSalRegSolActionPerformed

    private void cboHoraRegSolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboHoraRegSolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboHoraRegSolActionPerformed

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
            java.util.logging.Logger.getLogger(RegSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegSolicitud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCanRegSol;
    private javax.swing.JButton btnGuaRegSol;
    private javax.swing.JButton btnSalRegSol;
    private javax.swing.JComboBox cboAnioFecRegSol;
    private javax.swing.JComboBox cboDiaFecRegSol;
    private javax.swing.JComboBox cboEstadoRegSol;
    private javax.swing.JComboBox cboHoraRegSol;
    private javax.swing.JComboBox cboMesFecRegSol;
    private javax.swing.JComboBox cboMinRegSol;
    private javax.swing.JComboBox cboNumPolSol;
    private javax.swing.JLabel lblAnioFecVigSol;
    private javax.swing.JLabel lblAnioPolNoVig;
    private javax.swing.JLabel lblDesRegSol;
    private javax.swing.JLabel lblDiaFecVigSol;
    private javax.swing.JLabel lblDiaPolNoVig;
    private javax.swing.JLabel lblEstadoRegSol;
    private javax.swing.JLabel lblFecFirSol;
    private javax.swing.JLabel lblFecVigSol;
    private javax.swing.JLabel lblFechaRegSol;
    private javax.swing.JLabel lblFirTitSol;
    private javax.swing.JLabel lblHoraRegSol;
    private javax.swing.JLabel lblIconoRegSol;
    private javax.swing.JLabel lblLugarRegSol;
    private javax.swing.JLabel lblMesFecVigSol;
    private javax.swing.JLabel lblMesPolNoVig;
    private javax.swing.JLabel lblNumRegSol;
    private javax.swing.JLabel lblPolNoVig;
    private javax.swing.JLabel lblTitRegSol;
    private javax.swing.JLabel lblVigTitSol;
    private javax.swing.JPanel pnlDetRegSol;
    private javax.swing.JPanel pnlNumRegSol;
    private javax.swing.JTextField txtDesRegSol;
    private javax.swing.JTextField txtLugarRegSol;
    private javax.swing.JTextField txtNumRegSol;
    // End of variables declaration//GEN-END:variables
}
