package onedimensionautomata;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TestWorld.java
 *
 * Created on Oct 1, 2009, 12:03:49 PM
 */

/**
 *
 * @author ae3263
 */
public class TestWorld extends javax.swing.JFrame {

    /** Creates new form TestWorld */
    public TestWorld() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        worldView1 = new WorldView();
        worldView2 = new WorldView();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout worldView1Layout = new javax.swing.GroupLayout(worldView1);
        worldView1.setLayout(worldView1Layout);
        worldView1Layout.setHorizontalGroup(
            worldView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 486, Short.MAX_VALUE)
        );
        worldView1Layout.setVerticalGroup(
            worldView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 426, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(worldView1);

        jSplitPane1.setLeftComponent(jScrollPane1);

        javax.swing.GroupLayout worldView2Layout = new javax.swing.GroupLayout(worldView2);
        worldView2.setLayout(worldView2Layout);
        worldView2Layout.setHorizontalGroup(
            worldView2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 458, Short.MAX_VALUE)
        );
        worldView2Layout.setVerticalGroup(
            worldView2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 366, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(worldView2);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestWorld().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private WorldView worldView1;
    private WorldView worldView2;
    // End of variables declaration//GEN-END:variables

}
