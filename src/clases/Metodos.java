/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import static org.apache.poi.hssf.usermodel.HeaderFooter.file;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
/**
 *
 * @author RICHARD
 */
public class Metodos {  private BufferedImage _image = null;
    private FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de imagen","JPG");
    public File fichero = null;


    public Metodos()
    {
    }

    public void cargar_imagen_en_buffer(URL _url)
    {
        try
        {
            _image = ImageIO.read(_url);

        }
        catch (IOException ex)
        {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    public BufferedImage Obtener_imagen_de_Buffer()
    {
        return _image;
    }

    public void crear_imagen (JPanel p)
    {
        this._image = new BufferedImage (400,300, BufferedImage.TYPE_INT_RGB);
        this._image.createGraphics();
        Graphics2D g = (Graphics2D)this._image.getGraphics();
        // pintar la imagen
        g.setColor(Color.red);
        g.fillRect(0, 0, 400, 100);
        g.setColor(Color.YELLOW);
        g.fillRect(0, 100, 400, 100);
        g.setColor(Color.GREEN);
        g.fillRect(0, 200, 400, 100);

        // aniadir al jpanel con las dimensiones del contenedor no de la imagen
        p.add(new MiPanel(this._image, p.getSize()));
        p.setVisible(true);
        p.repaint();

    }

    public void guardar_imagen(String f) throws IOException
    {
        try
        {
            //se extrae el formato de la cadena "f" que ontinen la direccion
            String formato = (f.endsWith(".jpg")) ? "jpg" : "png";
            ImageIO.write(_image, formato, new File(f));

        }
        catch(IOException e)
        {
            System.out.println("ERROR AL CREAR EL ARCHIVO");
        }
    }


    public void Guardar_Dialogo() throws IOException
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            //se obtiene la direecion donde se guardara la imagen
            String url = fileChooser.getSelectedFile().toString();
            System.out.println("url: " + url);
            //se guarda la imagen
            guardar_imagen(url);
        }
    }

    // metodo que muestra una ventana de dialogo para aniadir "archivo de imagen"
    //en memoria

    public void Abrir_Dialogo(JPanel p)
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            try
            {
                //se asigna a "url" el archivo de imagen seleccionado
                URL url = fileChooser.getSelectedFile().toURL();
                // se lo coloca en memoria
                cargar_imagen_en_buffer(url);
                //se aniada al contenido
                p.add(new MiPanel(Obtener_imagen_de_Buffer(), p.getSize()));
                p.setVisible(true);
                p.repaint();
                
                //Guardar el archivo en un fichero
                fichero = fileChooser.getSelectedFile();

        }
        catch(IOException ex)
        {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
    }


    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public static String encodeToString(BufferedImage image) {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(image, "jpg", bos);
            byte[] imageBytes = bos.toByteArray();

            BASE64Encoder encoder = new BASE64Encoder();
            imageString = encoder.encode(imageBytes);

            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }
    
    public static BufferedImage decodeToImage(String imageString) {

        BufferedImage image = null;
        byte[] imageByte;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            imageByte = decoder.decodeBuffer(imageString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }
    
    public static void cargarImagen(String imagen_string, JButton lbver)
    {
        BufferedImage img = null;
        img = decodeToImage(imagen_string);
                ImageIcon icon = new ImageIcon(img);
                Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lbver.getWidth(), lbver.getHeight(), Image.SCALE_DEFAULT));
                lbver.setText(null);
                lbver.setIcon(icono);        
    }
    
    public static String datosImagen(File fichero) throws IOException
    {
        BufferedImage img = ImageIO.read(new File(fichero.toString()));
        String image_string = Metodos.encodeToString(img);
        return image_string;
    }
    
    
    
}
