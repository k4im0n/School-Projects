package de.kaimon.schoolproject.kai.treetraversionen;
import de.kaimon.schoolproject.implementations.datenstrukturklassen.baum.BinaryTree;

import javax.swing.JFrame;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;


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