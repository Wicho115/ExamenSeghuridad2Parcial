
package exameninterfaz;

import Cliente.Cliente;
import RSA.rsa;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.JOptionPane;

/*
 * @author luisc
 */

public class ClienteInterfaz extends javax.swing.JFrame {

    private static BigInteger d;
    private static BigInteger N;
    
    public static String name;

    public static BigInteger getD() {
        return d;
    }

    public static BigInteger getN() {
        return N;
    }

    public static void setD(BigInteger aD) {
        d = aD;
    }

    public static void setN(BigInteger aN) {
        N = aN;
    }
    
    Cliente cl;
    rsa rsa;
    public static int np;
    
    
    public ClienteInterfaz() {
        initComponents();   
        cl = new Cliente(name, this);        
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){     
                try {
                    cl.CerrarCliente();
                } catch (IOException ex) {
                    Logger.getLogger(ClienteInterfaz.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.exit(0);
            }
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        txtmensaje = new javax.swing.JTextField();
        btnenviar = new javax.swing.JButton();
        separador1 = new javax.swing.JSeparator();
        separador2 = new javax.swing.JSeparator();
        instrucciones = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtarmensajes = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 102, 255), 1, true));
        jPanel1.setMaximumSize(new java.awt.Dimension(500, 470));
        jPanel1.setMinimumSize(new java.awt.Dimension(500, 470));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        titulo.setText("Exámen Seguridad Web y Aplicaciones");
        jPanel1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        txtmensaje.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        txtmensaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        jPanel1.add(txtmensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 390, 20));

        btnenviar.setBackground(new java.awt.Color(51, 153, 255));
        btnenviar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnenviar.setText("Enviar");
        btnenviar.setBorder(null);
        btnenviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnenviarActionPerformed(evt);
            }
        });
        jPanel1.add(btnenviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 390, 70, 40));

        separador1.setBackground(new java.awt.Color(0, 0, 0));
        separador1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(separador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 460, 10));

        separador2.setBackground(new java.awt.Color(0, 0, 0));
        separador2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(separador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 460, 10));

        instrucciones.setBackground(new java.awt.Color(204, 255, 255));
        instrucciones.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        instrucciones.setText("Por favor, ingrese el mensaje que desea enviar:");
        jPanel1.add(instrucciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));

        txtarmensajes.setEditable(false);
        txtarmensajes.setColumns(20);
        txtarmensajes.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtarmensajes.setRows(5);
        txtarmensajes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        jScrollPane1.setViewportView(txtarmensajes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 460, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnenviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnenviarActionPerformed
        String txt = txtmensaje.getText();
        txtmensaje.setText("");
        try {
            EnviarTexto(txt);
        } catch (IOException ex) {
            Logger.getLogger(ClienteInterfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnenviarActionPerformed

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
            java.util.logging.Logger.getLogger(ClienteInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JOptionPane jp = new JOptionPane("Nombre");                
                name = JOptionPane.showInputDialog("Introduce tu Nombre");  
                
                np = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu numero primo"));
                
                new ClienteInterfaz().setVisible(true);
            }
        });
    }
    
    public void EnviarTexto(String txt) throws IOException{
        if(txt.startsWith("/*d*/")){
            cl.Escribir(txt + rsa.d.toString());
        }else if(txt.startsWith("/*N*/")){
            cl.Escribir(txt + rsa.N.toString());
        }else{
            BigInteger big = new BigInteger(txt);
            BigInteger cifrado = rsa.encryptMessage(big);
            txt = cifrado.toString();
            cl.Escribir(txt);
        }
        
    }
    
    public void RecibirTexto(String txt){        
        BigInteger cifrado = new BigInteger(txt);
        String txtAnterior = txtarmensajes.getText();
        txtarmensajes.setText(txtAnterior + "\n" + cifrado + "(Encriptado)"); 
        txtAnterior = txtarmensajes.getText();
        BigInteger descifrado = rsa.decryptMessage(cifrado);
        txtarmensajes.setText(txtAnterior + "\n" + descifrado + "(Desencriptado)");
    }
    
    public void RecibirTexto(String txt, int i){        
        BigInteger cifrado = new BigInteger(txt);
        String txtAnterior = txtarmensajes.getText();
        txtarmensajes.setText(txtAnterior + "\n" + "(YO)" + cifrado + "(Encriptado)"); 
        txtAnterior = txtarmensajes.getText();
        BigInteger descifrado = rsa.decryptMessage(cifrado);
        txtarmensajes.setText(txtAnterior + "\n" + "(YO)" + descifrado + "(Desencriptado)");
    }
    
    public void CrearRSA(){
        rsa = new rsa(np);
    }
    
    public void AsignarD(String d){
        rsa.d = new BigInteger(d);
        System.out.println("Se asigno d para todos");
    }
    
    public void AsignarN(String N){
        rsa.N = new BigInteger(N);
        System.out.println("Se asigno N para todos");
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnenviar;
    private javax.swing.JLabel instrucciones;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator separador1;
    private javax.swing.JSeparator separador2;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextArea txtarmensajes;
    private javax.swing.JTextField txtmensaje;
    // End of variables declaration//GEN-END:variables
}
