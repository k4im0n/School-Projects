package de.kaimon.schoolproject.implementations.datenstrukturklassen.baum;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class TreeViewGUI extends JFrame implements MouseListener
{
    // Instanzvariablen
    private TreeView sicht;

    /**
     * Konstruktor fuer Objekte der Klasse TreeViewGUI
     *
     * @param baum der anzuzeigende Baum
     */
    public TreeViewGUI(BinaryTree baum){
        super("Baumanzeiger");
        setSize(1000, 500);
        sicht = new TreeView(1000, 500, baum);
        sicht.addMouseListener(this);
        add(sicht);
        setVisible(true);
    }

    public void mouseClicked(MouseEvent e){
        sicht.repaint();
    }
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
}