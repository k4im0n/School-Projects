package de.kaimon.schoolproject.kai.treetraversionen;
import de.kaimon.schoolproject.implementations.datenstrukturklassen.baum.BinaryTree;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;


public class TreeView extends Canvas
{
    // Instanzvariablen
    private int breite;
    private int hoehe;
    private BinaryTree baum;
    private final int vertikalerAbstand = 50;

    /**
     * Konstruktor fuer Objekte der Klasse TreeView
     *
     * @param breite die Breite der Canvas
     * @param hoehe die Hoehe der Canvas
     * @baum der darzustellende Baum
     */
    public TreeView(int breite, int hoehe, BinaryTree baum){
        // Instanzvariable initialisieren
        this.breite = breite;
        this.hoehe = hoehe;
        this.baum = baum;
    }

    /**
     * Die Canvas wird neu gezeichnet.
     *
     * @param g der "Stift"
     */
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.clearRect(0, 0, breite, hoehe);
        Object wurzel = baum.getContent();
        g.setColor(Color.black);
        if (!baum.isEmpty()){
            zeichneBaum(g, baum, breite/2, vertikalerAbstand, 2);
        }
    }

    /**
     * Es wird ein Teilbaum gezeichnet.
     *
     * @param g der "Stift"
     * @param b der zu zeichnende Teilbaum
     * @param x die x-Koordinate der Wurzel des Teilbaums
     * @param y die y-Koordinate des Wurzel des Teilbaums
     * @param anz maximale Anzahl der Teilbaeume fuer das folgende Level
     */
    private void zeichneBaum(Graphics g, BinaryTree b, int x, int y, int anz){
        Object wurzel = b.getContent();
        g.fillOval(x-2, y-2, 4, 4);
        g.drawString(wurzel.toString(), x+4, y+2);

        BinaryTree links = b.getLeftTree();
        if (!links.isEmpty()){
            int xNeu = x - (int) (breite / Math.pow(2, anz));
            int yNeu = y + vertikalerAbstand;
            g.drawLine(x, y, xNeu, yNeu);
            zeichneBaum(g, links, xNeu, yNeu, anz + 1);
        }

        BinaryTree rechts = b.getRightTree();
        if (!rechts.isEmpty()){
            int xNeu = x + (int)(breite / Math.pow(2, anz));
            int yNeu = y + vertikalerAbstand;
            g.drawLine(x, y, xNeu, yNeu);
            zeichneBaum(g, rechts, xNeu, yNeu, anz + 1);
        }
    }
}
















