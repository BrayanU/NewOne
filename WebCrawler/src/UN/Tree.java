/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UN;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Hewlett Packard
 */
public class Tree extends javax.swing.JFrame {

    private JPanel contentPane;
    public GUI drawer;
    public names tree;

    public Tree(names tree) {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        drawer = new GUI(tree);

        contentPane.add(drawer);
        setContentPane(contentPane);
        this.tree = tree;
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private static class GUI extends JPanel {

        public names name;

        public GUI(names name) {
            this.name = name;
        }

        @Override
        protected void paintComponent(Graphics g) {
            g.setFont(new Font("Times New Roman", Font.BOLD, 5));
            draw(g, 0, getWidth(), 0, getHeight() / 3, name);
        }

        private void draw(Graphics g, int SAnch, int anch, int Altu, int Level, names name) {
            System.out.println("How many?");
            String data = name.getNurl();
            int ct = 0;
            g.setFont(new Font("Times New Roman", Font.BOLD, 5));
            FontMetrics fm = g.getFontMetrics();
            int dataAnch = fm.stringWidth(data);
            g.drawString(data, (SAnch + anch) / 2 - dataAnch / 2, Altu + Level / 2);
            for (names allName : name.getAllNames()) {
                ct++;
                switch (ct) {
                    case 1:
                        data = allName.getNurl();
                        dataAnch = fm.stringWidth(data);
                        g.drawString(data, (SAnch + (SAnch + anch) / 5) / 2 - dataAnch / 2, Altu + Level);
                        break;
                    case 2:
                        data = allName.getNurl();
                        dataAnch = fm.stringWidth(data);
                        g.drawString(data, (SAnch + ((SAnch + anch) / 5 + anch)) / 2 - dataAnch / 2, Altu + Level);
                        break;
                    case 3:
                        data = allName.getNurl();
                        dataAnch = fm.stringWidth(data);
                        g.drawString(data, (SAnch + anch) / 2 - dataAnch / 2, Altu + Level);
                        break;
                    case 4:
                        data = allName.getNurl();
                        dataAnch = fm.stringWidth(data);
                        g.drawString(data, ((((SAnch + anch) / 5) + anch * 3) + anch) / 2 - dataAnch / 2, Altu + Level);
                        break;
                    case 5:
                        data = allName.getNurl();
                        dataAnch = fm.stringWidth(data);
                        g.drawString(data, ((((SAnch + anch) / 5) + anch * 4) + anch) / 2 - dataAnch / 2, Altu + Level / 2);
                        break;
                }
            }
//            if (node.left != null) {
//                DrawTree(g, SAnch, (SAnch + anch) / 2, Altu + Level, Level, node.left);
//            }
//
//            if (node.right != null) {
//                DrawTree(g, (SAnch + anch) / 2, anch, Altu + Level, Level, node.right);
//            }
        }
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

