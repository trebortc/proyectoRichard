/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author RICHARD
 */
public class MiPanel extends javax.swing.JPanel
{
    BufferedImage _image;
    /*coloca la imagen que se encuentra en el Buffer en el objeto jpanel
     redimensiona la imagen para que encaje en las dimensiones de jpanel
     pero la imagen que se encuentra en el Buffer, preserva el tamanio original*/

    public MiPanel(BufferedImage imagen, Dimension d)
    {
        this._image = imagen;
        this.setSize(d);
    }


    @Override
    public void paint(Graphics g)
    {
        ImageIcon imagenFondo = new ImageIcon(_image);
        g.drawImage(imagenFondo.getImage(), 0, 0, getWidth(),getHeight(), null);
        setOpaque(false);
        super.paintComponent(g);
    }
}
