package formularios;


import conexion.ConexionMySQL;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Richard
 */
public class ConCliente extends javax.swing.JFrame {
    DefaultTableModel modelo;
    private ConexionMySQL cl = new ConexionMySQL();
    private Connection cn = cl.Conectar();
    private TableRowSorter tr;
    /**
     * Creates new form ConCliente
     */
    public ConCliente() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(79,157,157));
        String Cliente = lblConSol.getText();
        setListar(modelo); 
    
    }
  
    public void filtros() {
        int columnaABuscar = 0;
        if (cboExpConCli.getSelectedItem() == "Cédula") {
            columnaABuscar = 0;
        }
        if (cboExpConCli.getSelectedItem().toString() == "Nombre") {
            columnaABuscar = 1;
        }
        if (cboExpConCli.getSelectedItem().toString() == "Apellido") {
            columnaABuscar = 3;
        }
        if (cboExpConCli.getSelectedItem() == "Ciudad") {
            columnaABuscar = 8;
        }
        tr.setRowFilter(RowFilter.regexFilter("(?i)"+txtExpConCli.getText(), columnaABuscar));
    
      }

    public void setListar(Object Informacion) {
        DefaultTableModel modelo = (DefaultTableModel) this.tblExpConCli.getModel();
        

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "SELECT * FROM cliente";
        Object Datos[]= new Object[11];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
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
                modelo.addRow(Datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConSolicitud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
     private boolean getFileExtension(File file) {
        String ext = null;
        String s = file.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 && i < s.length() - 1) {
            ext = s.substring(i + 1).toLowerCase();
        }

        if (ext != null) {
            return true;
        } else {
            return false;
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

        pnlConSol = new javax.swing.JPanel();
        scpConSol = new javax.swing.JScrollPane();
        tblExpConCli = new javax.swing.JTable();
        lblConSol = new javax.swing.JLabel();
        btnSalExpConCli = new javax.swing.JButton();
        lblIconoFecRep = new javax.swing.JLabel();
        cboExpConCli = new javax.swing.JComboBox<>();
        txtExpConCli = new javax.swing.JTextField();
        btnExpConCli = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlConSol.setBackground(new java.awt.Color(79, 157, 157));

        tblExpConCli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÉDULA", "PRI. NOMBRE", "SEG. NOMBRE", "PRI. APELLIDO", "SEG. APELLIDO", "FECHA NACIMIENTO", "GÉNERO", "TELÉFONO", "CIUDAD", "DIRECCIÓN", "MAIL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblExpConCli.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        scpConSol.setViewportView(tblExpConCli);

        lblConSol.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblConSol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblConSol.setText("CONSULTA CLIENTES");

        btnSalExpConCli.setBackground(new java.awt.Color(79, 157, 157));
        btnSalExpConCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida.png"))); // NOI18N
        btnSalExpConCli.setText("SALIR");
        btnSalExpConCli.setMaximumSize(new java.awt.Dimension(157, 33));
        btnSalExpConCli.setMinimumSize(new java.awt.Dimension(157, 33));
        btnSalExpConCli.setPreferredSize(new java.awt.Dimension(157, 33));
        btnSalExpConCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalExpConCliActionPerformed(evt);
            }
        });

        lblIconoFecRep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reporte.png"))); // NOI18N

        cboExpConCli.setBackground(new java.awt.Color(79, 157, 157));
        cboExpConCli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Cédula", "Nombre", "Apellido", "Ciudad" }));
        cboExpConCli.setToolTipText("Seleccionar");
        cboExpConCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboExpConCliActionPerformed(evt);
            }
        });

        txtExpConCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtExpConCliActionPerformed(evt);
            }
        });
        txtExpConCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtExpConCliKeyTyped(evt);
            }
        });

        btnExpConCli.setBackground(new java.awt.Color(79, 157, 157));
        btnExpConCli.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnExpConCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/exportar.png"))); // NOI18N
        btnExpConCli.setText("EXPORTAR EXCEL");
        btnExpConCli.setMaximumSize(new java.awt.Dimension(157, 33));
        btnExpConCli.setMinimumSize(new java.awt.Dimension(157, 33));
        btnExpConCli.setPreferredSize(new java.awt.Dimension(157, 33));
        btnExpConCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExpConCliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlConSolLayout = new javax.swing.GroupLayout(pnlConSol);
        pnlConSol.setLayout(pnlConSolLayout);
        pnlConSolLayout.setHorizontalGroup(
            pnlConSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConSolLayout.createSequentialGroup()
                .addGroup(pnlConSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlConSolLayout.createSequentialGroup()
                        .addComponent(lblIconoFecRep)
                        .addGap(37, 37, 37)
                        .addComponent(cboExpConCli, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtExpConCli, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlConSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblConSol, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlConSolLayout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(btnExpConCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(btnSalExpConCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlConSolLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scpConSol, javax.swing.GroupLayout.DEFAULT_SIZE, 1230, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlConSolLayout.setVerticalGroup(
            pnlConSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConSolLayout.createSequentialGroup()
                .addGroup(pnlConSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlConSolLayout.createSequentialGroup()
                        .addComponent(lblIconoFecRep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlConSolLayout.createSequentialGroup()
                        .addComponent(lblConSol, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlConSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalExpConCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExpConCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlConSolLayout.createSequentialGroup()
                        .addGroup(pnlConSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboExpConCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtExpConCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)))
                .addComponent(scpConSol, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlConSol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlConSol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalExpConCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalExpConCliActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalExpConCliActionPerformed

    private void btnExpConCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpConCliActionPerformed
        // TODO add your handling code here:
        try{
            Thread t=new Thread(){
                public void run (){

                HSSFWorkbook workbook = new HSSFWorkbook();
                HSSFSheet hoja = workbook.createSheet();
                CellStyle style = workbook.createCellStyle();
                style.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE.getIndex());
                style.setFillPattern(CellStyle.SOLID_FOREGROUND);
                
                style.setBorderTop(CellStyle.BORDER_THIN);
                style.setBorderLeft(CellStyle.BORDER_THIN);
            	style.setBorderRight(CellStyle.BORDER_THIN);
		style.setBorderBottom(CellStyle.BORDER_THIN);
                   
                //style.
                String[] titulos = {"  CÉDULA  ", "  PRI. NOMBRE  ", "SEG. NOMBRE", "PRI. APELLIDO",
                            "SEG. APELLIDO", "FECHA NACIMIENTO","  GÉNERO  ", "  TELÉFONO  ", "CIUDAD", "DIRECCIÓN", "MAIL"};
                HSSFRow fila = hoja.createRow(0);
                 // Creamos el encabezado
                for(int i = 0; i < titulos.length; i++) {
                 // Creamos una celda en esa fila, en la posicion 
                 // indicada por el contador del ciclo
                Cell celda = fila.createCell(i);
                celda.setCellStyle(style); 
                celda.setCellValue(titulos[i]);
                }
                    
                    HSSFRow filas;
                    Rectangle rect;
                    for(int i=0; i<tblExpConCli.getRowCount();i++){
                        rect = tblExpConCli.getCellRect(i, 0, true);
                        try
                        {
                            tblExpConCli.scrollRectToVisible(rect);
                        }catch(java.lang.ClassCastException e){}
                        tblExpConCli.setRowSelectionInterval(i, i);
                        
                        filas = hoja.createRow((i+1));
                                                
                        filas.createCell(0).setCellValue(tblExpConCli.getValueAt(i, 0).toString());
                        filas.createCell(1).setCellValue(tblExpConCli.getValueAt(i, 1).toString());
                        filas.createCell(2).setCellValue(tblExpConCli.getValueAt(i, 2).toString());
                        filas.createCell(3).setCellValue(tblExpConCli.getValueAt(i, 3).toString());
                        filas.createCell(4).setCellValue(tblExpConCli.getValueAt(i, 4).toString());
                        filas.createCell(5).setCellValue(tblExpConCli.getValueAt(i, 5).toString());
                        filas.createCell(6).setCellValue(tblExpConCli.getValueAt(i, 6).toString());
                        filas.createCell(7).setCellValue(tblExpConCli.getValueAt(i, 7).toString());
                        filas.createCell(8).setCellValue(tblExpConCli.getValueAt(i, 8).toString());
                        filas.createCell(9).setCellValue(tblExpConCli.getValueAt(i, 9).toString());
                        filas.createCell(10).setCellValue(tblExpConCli.getValueAt(i, 10).toString());
                        
                        
                    }
                    JFileChooser fileChooser = new JFileChooser();
                    FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos Excel (*.xls)", "xls");
                    fileChooser.setAcceptAllFileFilterUsed(false);
                    fileChooser.setFileFilter(filter);
                    fileChooser.setDialogTitle("GUARDAR ARCHIVO");
                    if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
        
                    {

                        try {
                            File archivo = new File(fileChooser.getSelectedFile().getAbsolutePath());

                            OutputStream out = null;
                            if (getFileExtension(archivo)) {
                                out = new FileOutputStream(fileChooser.getSelectedFile().getAbsolutePath());
                            } else {
                                out = new FileOutputStream(fileChooser.getSelectedFile().getAbsolutePath() + ".xls");
                            }

                            JOptionPane.showMessageDialog(null, "Archivo generado con éxito");

                            workbook.write(out);
                            workbook.close();
                            out.flush();
                            out.close();
                        } catch (IOException ex) {
                            Logger.getLogger(ConSolicitud.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }

        
            };
            t.start();
        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
        
    }//GEN-LAST:event_btnExpConCliActionPerformed

    private void txtExpConCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExpConCliKeyTyped
        // TODO add your handling code here:
         txtExpConCli.addKeyListener(new KeyAdapter() {
             
            public void keyReleased(final KeyEvent e) {
            String cadena = (txtExpConCli.getText()).trim();
            txtExpConCli.setText(cadena);
            repaint();
            filtros();   
        }
        });
            tr = new TableRowSorter(tblExpConCli.getModel());
            tblExpConCli.setRowSorter(tr);
    }//GEN-LAST:event_txtExpConCliKeyTyped

    private void cboExpConCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboExpConCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboExpConCliActionPerformed

    private void txtExpConCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtExpConCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtExpConCliActionPerformed

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
            java.util.logging.Logger.getLogger(ConCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExpConCli;
    private javax.swing.JButton btnSalExpConCli;
    private javax.swing.JComboBox<String> cboExpConCli;
    private javax.swing.JLabel lblConSol;
    private javax.swing.JLabel lblIconoFecRep;
    private javax.swing.JPanel pnlConSol;
    private javax.swing.JScrollPane scpConSol;
    private javax.swing.JTable tblExpConCli;
    private javax.swing.JTextField txtExpConCli;
    // End of variables declaration//GEN-END:variables
}
