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
public class ConSolicitud extends javax.swing.JFrame {
    DefaultTableModel modelo;
    private ConexionMySQL cl = new ConexionMySQL();
    private Connection cn = cl.Conectar();
    private TableRowSorter tr;
    /**
     * Creates new form ConCliente
     */
    public ConSolicitud() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(79,157,157));
        setListar();
    }
    public void filtros() {
        int columnaABuscar = 0;
  
        if (cboExpConSol.getSelectedItem() == "No. Póliza") {
            columnaABuscar = 0;
        }
        if (cboExpConSol.getSelectedItem().toString() == "No. Solicitud") {
            columnaABuscar = 1;
        }
        if (cboExpConSol.getSelectedItem().toString() == "Día") {
            columnaABuscar = 3;
        }
        if (cboExpConSol.getSelectedItem() == "Mes") {
            columnaABuscar = 4;
        }
        if (cboExpConSol.getSelectedItem().toString() == "Año") {
            columnaABuscar = 5;
        }
        if (cboExpConSol.getSelectedItem().toString() == "Hora") {
            columnaABuscar = 6;
        }
        if (cboExpConSol.getSelectedItem() == "Estado") {
            columnaABuscar = 9;
        }
        tr.setRowFilter(RowFilter.regexFilter("(?i)"+txtExpConSol.getText(), columnaABuscar));
    
      }
   
    public void setListar() {
        DefaultTableModel modelo = (DefaultTableModel) this.tblExpConSol.getModel();
        

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "SELECT * FROM solicitud";
        String Datos[] = new String[10];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Datos[0] = rs.getString("num_poliza");
                Datos[1] = rs.getString("num_solicitud");
                Datos[2] = rs.getString("descripcion");
                Datos[3] = rs.getString("fecha_d");
                Datos[4] = rs.getString("fecha_m");
                Datos[5] = rs.getString("fecha_a");
                Datos[6] = rs.getString("hora");
                Datos[7] = rs.getString("minuto");
                Datos[8] = rs.getString("lugar");
                Datos[9] = rs.getString("estado");
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
        btnExpConSol = new javax.swing.JButton();
        scpConSol = new javax.swing.JScrollPane();
        tblExpConSol = new javax.swing.JTable();
        lblExpConSol = new javax.swing.JLabel();
        btnSalExpConSol = new javax.swing.JButton();
        lblIconoFecRep = new javax.swing.JLabel();
        cboExpConSol = new javax.swing.JComboBox<>();
        txtExpConSol = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AVENDAÑO AGENCIA DE SEGUROS");
        setName("frmConSolicitud"); // NOI18N

        pnlConSol.setBackground(new java.awt.Color(79, 157, 157));

        btnExpConSol.setBackground(new java.awt.Color(79, 157, 157));
        btnExpConSol.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnExpConSol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/exportar.png"))); // NOI18N
        btnExpConSol.setText(" EXPORTAR EXCEL");
        btnExpConSol.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExpConSol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExpConSolActionPerformed(evt);
            }
        });

        tblExpConSol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. PÓLIZA", "No. SOLICITUD", "DESCRIPCIÓN", "DÍA", "MES", "AÑO", "HORA", "MINUTO", "LUGAR", "ESTADO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblExpConSol.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        scpConSol.setViewportView(tblExpConSol);

        lblExpConSol.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblExpConSol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExpConSol.setText("CONSULTA SOLICITUDES DE SINIESTRO");

        btnSalExpConSol.setBackground(new java.awt.Color(79, 157, 157));
        btnSalExpConSol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida.png"))); // NOI18N
        btnSalExpConSol.setText("SALIR");
        btnSalExpConSol.setMaximumSize(new java.awt.Dimension(157, 33));
        btnSalExpConSol.setMinimumSize(new java.awt.Dimension(157, 33));
        btnSalExpConSol.setPreferredSize(new java.awt.Dimension(157, 33));
        btnSalExpConSol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalExpConSolActionPerformed(evt);
            }
        });

        lblIconoFecRep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reporte.png"))); // NOI18N

        cboExpConSol.setBackground(new java.awt.Color(79, 157, 157));
        cboExpConSol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "No. Póliza", "No. Solicitud", "Día", "Mes", "Año", "Hora", "Estado" }));
        cboExpConSol.setToolTipText("Seleccionar");
        cboExpConSol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboExpConSolActionPerformed(evt);
            }
        });

        txtExpConSol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtExpConSolActionPerformed(evt);
            }
        });
        txtExpConSol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtExpConSolKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout pnlConSolLayout = new javax.swing.GroupLayout(pnlConSol);
        pnlConSol.setLayout(pnlConSolLayout);
        pnlConSolLayout.setHorizontalGroup(
            pnlConSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConSolLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlConSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlConSolLayout.createSequentialGroup()
                        .addComponent(scpConSol, javax.swing.GroupLayout.DEFAULT_SIZE, 979, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pnlConSolLayout.createSequentialGroup()
                        .addComponent(lblIconoFecRep)
                        .addGroup(pnlConSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlConSolLayout.createSequentialGroup()
                                .addGap(194, 194, 194)
                                .addComponent(lblExpConSol, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnlConSolLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(cboExpConSol, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtExpConSol, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnExpConSol)
                                .addGap(20, 20, 20)
                                .addComponent(btnSalExpConSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(179, 179, 179))))))
        );
        pnlConSolLayout.setVerticalGroup(
            pnlConSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConSolLayout.createSequentialGroup()
                .addGroup(pnlConSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlConSolLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblExpConSol, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlConSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlConSolLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(pnlConSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnExpConSol, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSalExpConSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlConSolLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(pnlConSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboExpConSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtExpConSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(lblIconoFecRep))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scpConSol, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlConSol, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlConSol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExpConSolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpConSolActionPerformed
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
                String[] titulos = {"No. PÓLIZA", "No. SOLICITUD", "DESCRIPCIÓN", "DÍA", "MES",
                            "AÑO", "HORA","MINUTO", "LUGAR","ESTADO"};
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
                    for(int i=0; i<tblExpConSol.getRowCount();i++){
                        rect = tblExpConSol.getCellRect(i, 0, true);
                        try
                        {
                            tblExpConSol.scrollRectToVisible(rect);
                        }catch(java.lang.ClassCastException e){}
                        tblExpConSol.setRowSelectionInterval(i, i);
                        
                        filas = hoja.createRow((i+1));
                                                
                        filas.createCell(0).setCellValue(tblExpConSol.getValueAt(i, 0).toString());
                        filas.createCell(1).setCellValue(tblExpConSol.getValueAt(i, 1).toString());
                        filas.createCell(2).setCellValue(tblExpConSol.getValueAt(i, 2).toString());
                        filas.createCell(3).setCellValue(tblExpConSol.getValueAt(i, 3).toString());
                        filas.createCell(4).setCellValue(tblExpConSol.getValueAt(i, 4).toString());
                        filas.createCell(5).setCellValue(tblExpConSol.getValueAt(i, 5).toString());
                        filas.createCell(6).setCellValue(tblExpConSol.getValueAt(i, 6).toString());
                        filas.createCell(7).setCellValue(tblExpConSol.getValueAt(i, 7).toString());
                        filas.createCell(8).setCellValue(tblExpConSol.getValueAt(i, 8).toString());
                        filas.createCell(9).setCellValue(tblExpConSol.getValueAt(i, 9).toString());
                        
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
       
    }//GEN-LAST:event_btnExpConSolActionPerformed

    private void btnSalExpConSolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalExpConSolActionPerformed
        // TODO add your handling code here:
         this.dispose();
    }//GEN-LAST:event_btnSalExpConSolActionPerformed

    private void cboExpConSolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboExpConSolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboExpConSolActionPerformed

    private void txtExpConSolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtExpConSolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtExpConSolActionPerformed

    private void txtExpConSolKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExpConSolKeyTyped
        // TODO add your handling code here:
        txtExpConSol.addKeyListener(new KeyAdapter() {

            public void keyReleased(final KeyEvent e) {
                String cadena = (txtExpConSol.getText()).trim();
                txtExpConSol.setText(cadena);
                repaint();
                filtros();
            }
        });
        tr = new TableRowSorter(tblExpConSol.getModel());
        tblExpConSol.setRowSorter(tr);
    }//GEN-LAST:event_txtExpConSolKeyTyped

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
            java.util.logging.Logger.getLogger(ConSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConSolicitud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExpConSol;
    private javax.swing.JButton btnSalExpConSol;
    private javax.swing.JComboBox<String> cboExpConSol;
    private javax.swing.JLabel lblExpConSol;
    private javax.swing.JLabel lblIconoFecRep;
    private javax.swing.JPanel pnlConSol;
    private javax.swing.JScrollPane scpConSol;
    private javax.swing.JTable tblExpConSol;
    private javax.swing.JTextField txtExpConSol;
    // End of variables declaration//GEN-END:variables
}
