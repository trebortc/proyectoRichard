package formularios;


import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Richard
 */
public class MenuAdmin extends javax.swing.JFrame {

    /**
     * Creates new form MenuAdmin
     */
    public MenuAdmin() {
        initComponents();
        this.getContentPane().setBackground(new Color(0,81,81));
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsuConMenuAdm = new javax.swing.JLabel();
        lblUsuAdmConectado = new javax.swing.JLabel();
        mnuAdmin = new javax.swing.JMenuBar();
        mnuIncAdm = new javax.swing.JMenu();
        mnuCerMenuAdm = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnuSalirAdm = new javax.swing.JMenuItem();
        mnuEmpAdm = new javax.swing.JMenu();
        mnuIngAdmEmp = new javax.swing.JMenuItem();
        mnuModAdmEmp = new javax.swing.JMenuItem();
        mnuEliAdmEmp = new javax.swing.JMenuItem();
        mnuAseAdm = new javax.swing.JMenu();
        mnuIngAdmAse = new javax.swing.JMenuItem();
        mnuModAdmAse = new javax.swing.JMenuItem();
        mnuIngProAdmAse = new javax.swing.JMenuItem();
        mnuModProAdmAse = new javax.swing.JMenuItem();
        mnuEliAdmAse = new javax.swing.JMenuItem();
        mnuAdmCliPro = new javax.swing.JMenu();
        mnuAdmDatCli = new javax.swing.JMenu();
        mnuIngAdmCli = new javax.swing.JMenuItem();
        mnuModAdmCli = new javax.swing.JMenuItem();
        mnuEliAdmCli = new javax.swing.JMenuItem();
        mnuAdmDatPro = new javax.swing.JMenu();
        mnuIngAdmProd = new javax.swing.JMenuItem();
        mnuModAdmPro = new javax.swing.JMenuItem();
        mnuEliAdmPro = new javax.swing.JMenuItem();
        mnuAdmPol = new javax.swing.JMenu();
        mnuDatAdmPol = new javax.swing.JMenuItem();
        mnuBusAdmPol = new javax.swing.JMenuItem();
        mnuDatAdmPolPro = new javax.swing.JMenuItem();
        mnuAdmSin = new javax.swing.JMenu();
        mnuRegAdmSol = new javax.swing.JMenuItem();
        mnuAprAdmSol = new javax.swing.JMenuItem();
        mnuBusAdmSol = new javax.swing.JMenuItem();
        mnuAdmCon = new javax.swing.JMenu();
        mnuConPolAdm = new javax.swing.JMenuItem();
        mnuConCliAdm = new javax.swing.JMenuItem();
        mnuConSolAdm = new javax.swing.JMenuItem();
        mnuConProAdm = new javax.swing.JMenuItem();
        mnuAdmUsu = new javax.swing.JMenu();
        mnuPerUsu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AVENDAÑO AGENCIA DE SEGUROS");

        lblUsuConMenuAdm.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuConMenuAdm.setText("Usuario Conectado:");

        lblUsuAdmConectado.setForeground(new java.awt.Color(255, 255, 255));

        mnuIncAdm.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mnuIncAdm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inicio.png"))); // NOI18N
        mnuIncAdm.setText("Inicio           ");
        mnuIncAdm.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N

        mnuCerMenuAdm.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        mnuCerMenuAdm.setText("Cerrar Sesión");
        mnuCerMenuAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCerMenuAdmActionPerformed(evt);
            }
        });
        mnuIncAdm.add(mnuCerMenuAdm);

        jMenuItem1.setText("Backups");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnuIncAdm.add(jMenuItem1);

        mnuSalirAdm.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        mnuSalirAdm.setText("Salir");
        mnuSalirAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalirAdmActionPerformed(evt);
            }
        });
        mnuIncAdm.add(mnuSalirAdm);

        mnuAdmin.add(mnuIncAdm);

        mnuEmpAdm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));
        mnuEmpAdm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/contratado.png"))); // NOI18N
        mnuEmpAdm.setText("Gestionar Empleado      ");
        mnuEmpAdm.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N

        mnuIngAdmEmp.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        mnuIngAdmEmp.setText("Ingresar Datos");
        mnuIngAdmEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuIngAdmEmpActionPerformed(evt);
            }
        });
        mnuEmpAdm.add(mnuIngAdmEmp);

        mnuModAdmEmp.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        mnuModAdmEmp.setText("Modificar Datos");
        mnuModAdmEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuModAdmEmpActionPerformed(evt);
            }
        });
        mnuEmpAdm.add(mnuModAdmEmp);

        mnuEliAdmEmp.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        mnuEliAdmEmp.setText("Eliminar Datos");
        mnuEliAdmEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEliAdmEmpActionPerformed(evt);
            }
        });
        mnuEmpAdm.add(mnuEliAdmEmp);

        mnuAdmin.add(mnuEmpAdm);

        mnuAseAdm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));
        mnuAseAdm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/protected-profile.png"))); // NOI18N
        mnuAseAdm.setText("Gestionar Aseguradora      ");
        mnuAseAdm.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N

        mnuIngAdmAse.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        mnuIngAdmAse.setText("Ingresar Aseguradora");
        mnuIngAdmAse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuIngAdmAseActionPerformed(evt);
            }
        });
        mnuAseAdm.add(mnuIngAdmAse);

        mnuModAdmAse.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        mnuModAdmAse.setText("Modificar Aseguradora");
        mnuModAdmAse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuModAdmAseActionPerformed(evt);
            }
        });
        mnuAseAdm.add(mnuModAdmAse);

        mnuIngProAdmAse.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        mnuIngProAdmAse.setText("Ingresar Cobertura");
        mnuIngProAdmAse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuIngProAdmAseActionPerformed(evt);
            }
        });
        mnuAseAdm.add(mnuIngProAdmAse);

        mnuModProAdmAse.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        mnuModProAdmAse.setText("Modificar Cobertura");
        mnuModProAdmAse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuModProAdmAseActionPerformed(evt);
            }
        });
        mnuAseAdm.add(mnuModProAdmAse);

        mnuEliAdmAse.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        mnuEliAdmAse.setText("Eliminar Datos");
        mnuEliAdmAse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEliAdmAseActionPerformed(evt);
            }
        });
        mnuAseAdm.add(mnuEliAdmAse);

        mnuAdmin.add(mnuAseAdm);

        mnuAdmCliPro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mnuAdmCliPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/carpeta.png"))); // NOI18N
        mnuAdmCliPro.setText("Gestionar Cliente - Producto      ");
        mnuAdmCliPro.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N

        mnuAdmDatCli.setText("Datos del Cliente");
        mnuAdmDatCli.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N

        mnuIngAdmCli.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        mnuIngAdmCli.setText("Ingresar Datos");
        mnuIngAdmCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuIngAdmCliActionPerformed(evt);
            }
        });
        mnuAdmDatCli.add(mnuIngAdmCli);

        mnuModAdmCli.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        mnuModAdmCli.setText("Modificar Datos");
        mnuModAdmCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuModAdmCliActionPerformed(evt);
            }
        });
        mnuAdmDatCli.add(mnuModAdmCli);

        mnuEliAdmCli.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        mnuEliAdmCli.setText("Eliminar Datos");
        mnuEliAdmCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEliAdmCliActionPerformed(evt);
            }
        });
        mnuAdmDatCli.add(mnuEliAdmCli);

        mnuAdmCliPro.add(mnuAdmDatCli);

        mnuAdmDatPro.setText("Datos del Producto");
        mnuAdmDatPro.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N

        mnuIngAdmProd.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        mnuIngAdmProd.setText("Ingresar Datos");
        mnuIngAdmProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuIngAdmProdActionPerformed(evt);
            }
        });
        mnuAdmDatPro.add(mnuIngAdmProd);

        mnuModAdmPro.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        mnuModAdmPro.setText("Modificar Datos");
        mnuModAdmPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuModAdmProActionPerformed(evt);
            }
        });
        mnuAdmDatPro.add(mnuModAdmPro);

        mnuEliAdmPro.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        mnuEliAdmPro.setText("Eliminar Datos");
        mnuEliAdmPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEliAdmProActionPerformed(evt);
            }
        });
        mnuAdmDatPro.add(mnuEliAdmPro);

        mnuAdmCliPro.add(mnuAdmDatPro);

        mnuAdmin.add(mnuAdmCliPro);

        mnuAdmPol.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mnuAdmPol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/contrato.png"))); // NOI18N
        mnuAdmPol.setText("Generar Póliza Seguro       ");
        mnuAdmPol.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N

        mnuDatAdmPol.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        mnuDatAdmPol.setText("Ingresar Póliza");
        mnuDatAdmPol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDatAdmPolActionPerformed(evt);
            }
        });
        mnuAdmPol.add(mnuDatAdmPol);

        mnuBusAdmPol.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        mnuBusAdmPol.setText("Buscar Póliza");
        mnuBusAdmPol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuBusAdmPolActionPerformed(evt);
            }
        });
        mnuAdmPol.add(mnuBusAdmPol);

        mnuDatAdmPolPro.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        mnuDatAdmPolPro.setText("Cobertura General");
        mnuDatAdmPolPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDatAdmPolProActionPerformed(evt);
            }
        });
        mnuAdmPol.add(mnuDatAdmPolPro);

        mnuAdmin.add(mnuAdmPol);

        mnuAdmSin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mnuAdmSin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/solicitud.png"))); // NOI18N
        mnuAdmSin.setText("Solicitud de Siniestro      ");
        mnuAdmSin.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N

        mnuRegAdmSol.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        mnuRegAdmSol.setText("Ingresar Solicitud");
        mnuRegAdmSol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRegAdmSolActionPerformed(evt);
            }
        });
        mnuAdmSin.add(mnuRegAdmSol);

        mnuAprAdmSol.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        mnuAprAdmSol.setText("Aprobar Solicitud");
        mnuAprAdmSol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAprAdmSolActionPerformed(evt);
            }
        });
        mnuAdmSin.add(mnuAprAdmSol);

        mnuBusAdmSol.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        mnuBusAdmSol.setText("Buscar Solicitud");
        mnuBusAdmSol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuBusAdmSolActionPerformed(evt);
            }
        });
        mnuAdmSin.add(mnuBusAdmSol);

        mnuAdmin.add(mnuAdmSin);

        mnuAdmCon.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mnuAdmCon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reportar.png"))); // NOI18N
        mnuAdmCon.setText("Consultas             ");
        mnuAdmCon.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N

        mnuConPolAdm.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        mnuConPolAdm.setText("Consulta Póliza");
        mnuConPolAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConPolAdmActionPerformed(evt);
            }
        });
        mnuAdmCon.add(mnuConPolAdm);

        mnuConCliAdm.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        mnuConCliAdm.setText("Consulta Clientes");
        mnuConCliAdm.setToolTipText("");
        mnuConCliAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConCliAdmActionPerformed(evt);
            }
        });
        mnuAdmCon.add(mnuConCliAdm);

        mnuConSolAdm.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        mnuConSolAdm.setText("Consulta Solicitudes");
        mnuConSolAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConSolAdmActionPerformed(evt);
            }
        });
        mnuAdmCon.add(mnuConSolAdm);

        mnuConProAdm.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        mnuConProAdm.setText("Consulta Productos");
        mnuConProAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConProAdmActionPerformed(evt);
            }
        });
        mnuAdmCon.add(mnuConProAdm);

        mnuAdmin.add(mnuAdmCon);

        mnuAdmUsu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mnuAdmUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuarios.png"))); // NOI18N
        mnuAdmUsu.setText("Usuario    ");
        mnuAdmUsu.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N

        mnuPerUsu.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        mnuPerUsu.setText("Perfiles Usuario");
        mnuPerUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPerUsuActionPerformed(evt);
            }
        });
        mnuAdmUsu.add(mnuPerUsu);

        mnuAdmin.add(mnuAdmUsu);

        setJMenuBar(mnuAdmin);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuConMenuAdm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsuAdmConectado, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1059, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(587, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblUsuConMenuAdm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUsuAdmConectado, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuCerMenuAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCerMenuAdmActionPerformed
        // TODO add your handling code here:
        IngresoSistema principal= new IngresoSistema();
        principal.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mnuCerMenuAdmActionPerformed

    private void mnuSalirAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirAdmActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_mnuSalirAdmActionPerformed

    private void mnuIngAdmAseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuIngAdmAseActionPerformed
        // TODO add your handling code here:
        //this.dispose();
        RegAseguradora InforAseguradorasJF = new RegAseguradora();
        InforAseguradorasJF.setVisible(true);
    }//GEN-LAST:event_mnuIngAdmAseActionPerformed

    private void mnuModAdmAseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuModAdmAseActionPerformed
        // TODO add your handling code here:
        //this.dispose();
        ModAseguradora ModAseguradorasJF = new ModAseguradora();
        ModAseguradorasJF.setVisible(true);
    }//GEN-LAST:event_mnuModAdmAseActionPerformed

    private void mnuEliAdmAseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEliAdmAseActionPerformed
        // TODO add your handling code here:
        //this.dispose();
        EliAseguradora EliAseguradorasJF = new EliAseguradora();
        EliAseguradorasJF.setVisible(true);
    }//GEN-LAST:event_mnuEliAdmAseActionPerformed

    private void mnuIngProAdmAseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuIngProAdmAseActionPerformed
        // TODO add your handling code here:
        RegProAseguradora IngRegProformaJF = new RegProAseguradora();
        IngRegProformaJF.setVisible(true);
    }//GEN-LAST:event_mnuIngProAdmAseActionPerformed

    private void mnuIngAdmCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuIngAdmCliActionPerformed
        // TODO add your handling code here:
        //this.dispose();
        RegCliente InfClienteJF = new RegCliente();
        InfClienteJF.setVisible(true);
    }//GEN-LAST:event_mnuIngAdmCliActionPerformed

    private void mnuModAdmCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuModAdmCliActionPerformed
        // TODO add your handling code here:
        //this.dispose();
        ModCliente ModClienteJF = new ModCliente();
        ModClienteJF.setVisible(true);
    }//GEN-LAST:event_mnuModAdmCliActionPerformed

    private void mnuEliAdmCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEliAdmCliActionPerformed
        // TODO add your handling code here:
        //this.dispose();
        EliCliente EliClienteJF = new EliCliente();
        EliClienteJF.setVisible(true);
    }//GEN-LAST:event_mnuEliAdmCliActionPerformed

    private void mnuIngAdmProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuIngAdmProdActionPerformed
        // TODO add your handling code here:
        //this.dispose();
        RegProducto InfProductoJF = new RegProducto();
        InfProductoJF.setVisible(true);
    }//GEN-LAST:event_mnuIngAdmProdActionPerformed

    private void mnuModAdmProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuModAdmProActionPerformed
        // TODO add your handling code here:
        //this.dispose();
        ModProducto ModProductoJF = new ModProducto();
        ModProductoJF.setVisible(true);
    }//GEN-LAST:event_mnuModAdmProActionPerformed

    private void mnuEliAdmProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEliAdmProActionPerformed
        // TODO add your handling code here:
        //this.dispose();
        EliProducto EliProductoJF = new EliProducto();
        EliProductoJF.setVisible(true);
    }//GEN-LAST:event_mnuEliAdmProActionPerformed

    private void mnuDatAdmPolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDatAdmPolActionPerformed
        // TODO add your handling code here:
        RegPoliza InfPolizaJF = new RegPoliza();
        InfPolizaJF.setVisible(true);
    }//GEN-LAST:event_mnuDatAdmPolActionPerformed

    private void mnuRegAdmSolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRegAdmSolActionPerformed
        // TODO add your handling code here:
        //this.dispose();
        RegSolicitud RegSolicitudJF = new RegSolicitud();
        RegSolicitudJF.setVisible(true);
    }//GEN-LAST:event_mnuRegAdmSolActionPerformed

    private void mnuBusAdmSolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuBusAdmSolActionPerformed
        // TODO add your handling code here:
        //this.dispose();
        BusSolicitud BusSolicitudJF = new BusSolicitud();
        BusSolicitudJF.setVisible(true);
    }//GEN-LAST:event_mnuBusAdmSolActionPerformed

    private void mnuConPolAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConPolAdmActionPerformed
        // TODO add your handling code here:
        //this.dispose();
        ConPoliza ConPolizaJF = new ConPoliza();
        ConPolizaJF.setVisible(true);
    }//GEN-LAST:event_mnuConPolAdmActionPerformed

    private void mnuIngAdmEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuIngAdmEmpActionPerformed
        // TODO add your handling code here:
        RegEmpleado InforEmpleadoJF = new RegEmpleado();
        InforEmpleadoJF.setVisible(true);
    }//GEN-LAST:event_mnuIngAdmEmpActionPerformed

    private void mnuModAdmEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuModAdmEmpActionPerformed
        // TODO add your handling code here:
        ModEmpleado InforEmpleadoJF = new ModEmpleado();
        InforEmpleadoJF.setVisible(true);
    }//GEN-LAST:event_mnuModAdmEmpActionPerformed

    private void mnuEliAdmEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEliAdmEmpActionPerformed
        // TODO add your handling code here:
        EliEmpleado InforEmpleadoJF = new EliEmpleado();
        InforEmpleadoJF.setVisible(true);
    }//GEN-LAST:event_mnuEliAdmEmpActionPerformed

    private void mnuAprAdmSolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAprAdmSolActionPerformed
        // TODO add your handling code here:
        AprSolicitud AprSolicitudJF = new AprSolicitud();
        AprSolicitudJF.setVisible(true);
    }//GEN-LAST:event_mnuAprAdmSolActionPerformed

    private void mnuPerUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPerUsuActionPerformed
        // TODO add your handling code here:
        RegUsuario InforLoginJF = new RegUsuario();
        InforLoginJF.setVisible(true);
    }//GEN-LAST:event_mnuPerUsuActionPerformed

    private void mnuDatAdmPolProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDatAdmPolProActionPerformed
        // TODO add your handling code here:
        MosInfProformas InfProformasJF = new MosInfProformas();
        InfProformasJF.setVisible(true);
    }//GEN-LAST:event_mnuDatAdmPolProActionPerformed

    private void mnuBusAdmPolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuBusAdmPolActionPerformed
        // TODO add your handling code here:
        BusPoliza BusPolizaJF = new BusPoliza();
        BusPolizaJF.setVisible(true);
    }//GEN-LAST:event_mnuBusAdmPolActionPerformed

    private void mnuConCliAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConCliAdmActionPerformed
        // TODO add your handling code here:
        ConCliente ConClienteJF = new ConCliente();
        ConClienteJF.setVisible(true);
    }//GEN-LAST:event_mnuConCliAdmActionPerformed

    private void mnuConSolAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConSolAdmActionPerformed
        // TODO add your handling code here:
        ConSolicitud ConSolicitudJF = new ConSolicitud();
        ConSolicitudJF.setVisible(true);
    }//GEN-LAST:event_mnuConSolAdmActionPerformed

    private void mnuConProAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConProAdmActionPerformed
        // TODO add your handling code here:
        ConProducto ConProductoJF = new ConProducto();
        ConProductoJF.setVisible(true);
    }//GEN-LAST:event_mnuConProAdmActionPerformed

    private void mnuModProAdmAseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuModProAdmAseActionPerformed
        // TODO add your handling code here:
        ModProAseguradora ModProAseguradoraJF = new ModProAseguradora();
        ModProAseguradoraJF.setVisible(true);
    }//GEN-LAST:event_mnuModProAdmAseActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Respaldos respaldos = new Respaldos();
        respaldos.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItem1;
    public static javax.swing.JLabel lblUsuAdmConectado;
    private javax.swing.JLabel lblUsuConMenuAdm;
    private javax.swing.JMenu mnuAdmCliPro;
    private javax.swing.JMenu mnuAdmCon;
    private javax.swing.JMenu mnuAdmDatCli;
    private javax.swing.JMenu mnuAdmDatPro;
    private javax.swing.JMenu mnuAdmPol;
    private javax.swing.JMenu mnuAdmSin;
    private javax.swing.JMenu mnuAdmUsu;
    private javax.swing.JMenuBar mnuAdmin;
    private javax.swing.JMenuItem mnuAprAdmSol;
    private javax.swing.JMenu mnuAseAdm;
    private javax.swing.JMenuItem mnuBusAdmPol;
    private javax.swing.JMenuItem mnuBusAdmSol;
    private javax.swing.JMenuItem mnuCerMenuAdm;
    private javax.swing.JMenuItem mnuConCliAdm;
    private javax.swing.JMenuItem mnuConPolAdm;
    private javax.swing.JMenuItem mnuConProAdm;
    private javax.swing.JMenuItem mnuConSolAdm;
    private javax.swing.JMenuItem mnuDatAdmPol;
    private javax.swing.JMenuItem mnuDatAdmPolPro;
    private javax.swing.JMenuItem mnuEliAdmAse;
    private javax.swing.JMenuItem mnuEliAdmCli;
    private javax.swing.JMenuItem mnuEliAdmEmp;
    private javax.swing.JMenuItem mnuEliAdmPro;
    private javax.swing.JMenu mnuEmpAdm;
    private javax.swing.JMenu mnuIncAdm;
    private javax.swing.JMenuItem mnuIngAdmAse;
    private javax.swing.JMenuItem mnuIngAdmCli;
    private javax.swing.JMenuItem mnuIngAdmEmp;
    private javax.swing.JMenuItem mnuIngAdmProd;
    private javax.swing.JMenuItem mnuIngProAdmAse;
    private javax.swing.JMenuItem mnuModAdmAse;
    private javax.swing.JMenuItem mnuModAdmCli;
    private javax.swing.JMenuItem mnuModAdmEmp;
    private javax.swing.JMenuItem mnuModAdmPro;
    private javax.swing.JMenuItem mnuModProAdmAse;
    private javax.swing.JMenuItem mnuPerUsu;
    private javax.swing.JMenuItem mnuRegAdmSol;
    private javax.swing.JMenuItem mnuSalirAdm;
    // End of variables declaration//GEN-END:variables
}
