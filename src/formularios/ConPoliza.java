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
public class ConPoliza extends javax.swing.JFrame {
DefaultTableModel modelo;
 private ConexionMySQL cl = new ConexionMySQL();
    private Connection cn = cl.Conectar();
    private TableRowSorter tr;
    /**
     * Creates new form FecReporte
     */
    public ConPoliza() {
        initComponents();
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(79,157,157));
        String Cliente = lblTitFecRep.getText();
        setListar(modelo);
    }
    public void filtros() {
        int columnaABuscar = 0;
       
        if (cboExpConPol.getSelectedItem() == "No. Póliza") {
            columnaABuscar = 0;
        }
        if (cboExpConPol.getSelectedItem().toString() == "Aseguradora") {
            columnaABuscar = 1;
        }
        if (cboExpConPol.getSelectedItem().toString() == "Día Emisión") {
            columnaABuscar = 2;
        }
        if (cboExpConPol.getSelectedItem() == "Mes Emisión") {
            columnaABuscar = 3;
        }
        if (cboExpConPol.getSelectedItem() == "Año Emisión") {
            columnaABuscar = 4;
        }
        if (cboExpConPol.getSelectedItem().toString() == "Día Firma") {
            columnaABuscar = 5;
        }
        if (cboExpConPol.getSelectedItem().toString() == "Mes Firma") {
            columnaABuscar = 6;
        }
        if (cboExpConPol.getSelectedItem() == "Año Firma") {
            columnaABuscar = 7;
        }
         if (cboExpConPol.getSelectedItem().toString() == "Día Vigencia") {
            columnaABuscar = 8;
        }
        if (cboExpConPol.getSelectedItem().toString() == "Mes Vigencia") {
            columnaABuscar = 9;
        }
         if (cboExpConPol.getSelectedItem() == "Año Vigencia") {
            columnaABuscar = 10;
        }
          if (cboExpConPol.getSelectedItem() == "Cédula") {
            columnaABuscar = 12;
        }
        if (cboExpConPol.getSelectedItem() == "Placa") {
            columnaABuscar = 13;
        }
        
        tr.setRowFilter(RowFilter.regexFilter("(?i)"+txtExpConPol.getText(), columnaABuscar));
    
      }
    
    public void setListar(Object Informacion) {
        DefaultTableModel modelo = (DefaultTableModel) this.tblExpConPol.getModel();
        

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "SELECT * FROM poliza";
        Object Datos[]= new Object[14];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                        Datos[0] = rs.getString("num_poliza");
                        Datos[1] = rs.getString("aseg");
                        Datos[2] = rs.getString("emi_d");
                        Datos[3] = rs.getString("emi_m");
                        Datos[4] = rs.getString("emi_a");
                        Datos[5] = rs.getString("fir_d");
                        Datos[6] = rs.getString("fir_m");
                        Datos[7] = rs.getString("fir_a");
                        Datos[8] = rs.getString("vig_d");
                        Datos[9] = rs.getString("vig_m");
                        Datos[10] = rs.getString("vig_a"); 
                        Datos[11] = rs.getString("val_pri");
                        Datos[12] = rs.getString("nom_cli");
                        Datos[13] = rs.getString("num_pla"); 
  
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

        lblIconoFecRep = new javax.swing.JLabel();
        lblTitFecRep = new javax.swing.JLabel();
        btnSalExpConPol = new javax.swing.JButton();
        btnExpConPol = new javax.swing.JButton();
        scpConSol = new javax.swing.JScrollPane();
        tblExpConPol = new javax.swing.JTable();
        cboExpConPol = new javax.swing.JComboBox<>();
        txtExpConPol = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AVENDAÑO AGENCIA DE SEGUROS");
        setName("frmFecReporte"); // NOI18N

        lblIconoFecRep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reporte.png"))); // NOI18N

        lblTitFecRep.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitFecRep.setText("CONSULTA PÓLIZAS");

        btnSalExpConPol.setBackground(new java.awt.Color(79, 157, 157));
        btnSalExpConPol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida.png"))); // NOI18N
        btnSalExpConPol.setText("SALIR");
        btnSalExpConPol.setMaximumSize(new java.awt.Dimension(157, 33));
        btnSalExpConPol.setMinimumSize(new java.awt.Dimension(157, 33));
        btnSalExpConPol.setPreferredSize(new java.awt.Dimension(157, 33));
        btnSalExpConPol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalExpConPolActionPerformed(evt);
            }
        });

        btnExpConPol.setBackground(new java.awt.Color(79, 157, 157));
        btnExpConPol.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnExpConPol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/exportar.png"))); // NOI18N
        btnExpConPol.setText(" EXPORTAR EXCEL");
        btnExpConPol.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExpConPol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExpConPolActionPerformed(evt);
            }
        });

        tblExpConPol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. PÓLIZA", "ASEGURADORA", "DÍA EMISIÓN", "MES EMISIÓN", "AÑO EMISIÓN", "DÍA FIRMA", "MES FIRMA", "AÑO FIRMA", "DÍA VIGENCIA", "MES VIGENCIA", "AÑO VIGENCIA", "VALOR PRIMA", "CÉDULA", "PLACA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblExpConPol.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        scpConSol.setViewportView(tblExpConPol);

        cboExpConPol.setBackground(new java.awt.Color(79, 157, 157));
        cboExpConPol.setMaximumRowCount(13);
        cboExpConPol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "No. Póliza", "Aseguradora", "Día Emisión", "Mes Emisión", "Año Emisión", "Día Firma", "Mes Firma", "Año Firma", "Día Vigencia", "Mes Vigencia", "Año Vigencia", "Cédula", "Placa", " " }));
        cboExpConPol.setToolTipText("Seleccionar");
        cboExpConPol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboExpConPolActionPerformed(evt);
            }
        });

        txtExpConPol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtExpConPolActionPerformed(evt);
            }
        });
        txtExpConPol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtExpConPolKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIconoFecRep)
                .addGap(31, 31, 31)
                .addComponent(cboExpConPol, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtExpConPol, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(lblTitFecRep))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnExpConPol)
                        .addGap(20, 20, 20)
                        .addComponent(btnSalExpConPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 439, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scpConSol, javax.swing.GroupLayout.DEFAULT_SIZE, 1251, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblIconoFecRep))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(lblTitFecRep))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboExpConPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtExpConPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalExpConPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExpConPol, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(395, 395, 395))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(148, 148, 148)
                    .addComponent(scpConSol, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalExpConPolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalExpConPolActionPerformed
        // TODO add your handling code here:
        this.dispose();
        //MenuUsuario MenuUsuarioJF = new MenuUsuario();
        //MenuUsuarioJF.setVisible(true);
    }//GEN-LAST:event_btnSalExpConPolActionPerformed

    private void btnExpConPolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpConPolActionPerformed
        //generarExcel();
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
                String[] titulos = {"No. PÓLIZA", "ASEGURADORA", "DÍA EMISIÓN", "MES EMISIÓN", "AÑO EMISIÓN",
                            "DÍA FIRMA", "MES FIRMA","AÑO FIRMA", "DÍA VIGENCIA", "MES VIGENCIA", "AÑO VIGENCIA", "VALOR PRIMA", "CÉDULA", "PLACA"};
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
                    for(int i=0; i<tblExpConPol.getRowCount();i++){
                        rect = tblExpConPol.getCellRect(i, 0, true);
                        try
                        {
                            tblExpConPol.scrollRectToVisible(rect);
                        }catch(java.lang.ClassCastException e){}
                        tblExpConPol.setRowSelectionInterval(i, i);
                        
                        filas = hoja.createRow((i+1));
                                                
                        filas.createCell(0).setCellValue(tblExpConPol.getValueAt(i, 0).toString());
                        filas.createCell(1).setCellValue(tblExpConPol.getValueAt(i, 1).toString());
                        filas.createCell(2).setCellValue(tblExpConPol.getValueAt(i, 2).toString());
                        filas.createCell(3).setCellValue(tblExpConPol.getValueAt(i, 3).toString());
                        filas.createCell(4).setCellValue(tblExpConPol.getValueAt(i, 4).toString());
                        filas.createCell(5).setCellValue(tblExpConPol.getValueAt(i, 5).toString());
                        filas.createCell(6).setCellValue(tblExpConPol.getValueAt(i, 6).toString());
                        filas.createCell(7).setCellValue(tblExpConPol.getValueAt(i, 7).toString());
                        filas.createCell(8).setCellValue(tblExpConPol.getValueAt(i, 8).toString());
                        filas.createCell(9).setCellValue(tblExpConPol.getValueAt(i, 9).toString());
                        filas.createCell(10).setCellValue(tblExpConPol.getValueAt(i, 10).toString());
                        filas.createCell(11).setCellValue(tblExpConPol.getValueAt(i, 11).toString());
                        filas.createCell(12).setCellValue(tblExpConPol.getValueAt(i, 12).toString());
                        filas.createCell(13).setCellValue(tblExpConPol.getValueAt(i, 13).toString());
                        
                        
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
        
    }//GEN-LAST:event_btnExpConPolActionPerformed

    private void cboExpConPolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboExpConPolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboExpConPolActionPerformed

    private void txtExpConPolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtExpConPolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtExpConPolActionPerformed

    private void txtExpConPolKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExpConPolKeyTyped
        // TODO add your handling code here:
        txtExpConPol.addKeyListener(new KeyAdapter() {

            public void keyReleased(final KeyEvent e) {
                String cadena = (txtExpConPol.getText()).trim();
                txtExpConPol.setText(cadena);
                repaint();
                filtros();
            }
        });
        tr = new TableRowSorter(tblExpConPol.getModel());
        tblExpConPol.setRowSorter(tr);
    }//GEN-LAST:event_txtExpConPolKeyTyped

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
            java.util.logging.Logger.getLogger(ConPoliza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConPoliza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConPoliza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConPoliza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConPoliza().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExpConPol;
    private javax.swing.JButton btnSalExpConPol;
    private javax.swing.JComboBox<String> cboExpConPol;
    private javax.swing.JLabel lblIconoFecRep;
    private javax.swing.JLabel lblTitFecRep;
    private javax.swing.JScrollPane scpConSol;
    private javax.swing.JTable tblExpConPol;
    private javax.swing.JTextField txtExpConPol;
    // End of variables declaration//GEN-END:variables
}
