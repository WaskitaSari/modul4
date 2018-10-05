/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asistensi;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import javax.swing.JOptionPane;

/**
 *
 * @author cynux
 */
public class server_CS extends javax.swing.JFrame {

    public static final int SERVICE_PORT=7;
    public static final int BUFSIZE=4096;
    private DatagramSocket socket;
    public server_CS() {
        initComponents();
    }
    public void server_on(){
        try{
            socket=new DatagramSocket(SERVICE_PORT);
            history.append("Server Active on port "+socket.getLocalPort());
            //serviceClients();
        }catch(Exception e){
            history.append("Unable to bind port");
        }
    }
    public void serviceClients(){
        byte[] buffer=new byte[BUFSIZE];
        for (;;) {
            try{
                DatagramPacket packet=new DatagramPacket(buffer,BUFSIZE);
                socket.receive(packet);
                System.out.println("Packet Receive From "+packet.getAddress()+" : "+packet.getPort()+" of length "+packet.getLength());
                socket.send(packet);
            }catch(IOException ioe){
                System.out.println("Error "+ioe);
            }
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

        con = new javax.swing.JButton();
        label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        history = new javax.swing.JTextArea();
        dis = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        con.setText("Connect");
        con.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conActionPerformed(evt);
            }
        });

        label.setText("Status : -----------");

        history.setColumns(20);
        history.setRows(5);
        jScrollPane1.setViewportView(history);

        dis.setText("Disconnect");
        dis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dis, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(con, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(65, 65, 65)
                        .addComponent(label)
                        .addGap(0, 143, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(con)
                        .addGap(7, 7, 7)
                        .addComponent(dis))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void conActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conActionPerformed
            label.setText("Status : Connect");
            server_CS a=new server_CS();
            a.server_on();
            a.serviceClients();
            con.setEnabled(false);
            dis.setEnabled(true);
        
    }//GEN-LAST:event_conActionPerformed

    private void disActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disActionPerformed
            label.setText("Status : Disconnect");
            dis.setEnabled(false);
            con.setEnabled(true);
    }//GEN-LAST:event_disActionPerformed

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
            java.util.logging.Logger.getLogger(server_CS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(server_CS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(server_CS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(server_CS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new server_CS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton con;
    private javax.swing.JButton dis;
    private javax.swing.JTextArea history;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables
}