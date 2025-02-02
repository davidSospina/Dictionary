/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionaryclient_views;

import dictionaryclient_actors.Client;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author DSO
 */
public class MainPage extends javax.swing.JFrame {

    Client cliente;

    /**
     * Creates new form MainPage
     */
    public MainPage() {
        initComponents();

        try {
            this.setIconImage(new ImageIcon(getClass().getResource("/dictionaryclient_images/dictionary.png")).getImage());
            this.setLocationRelativeTo(null);
        } catch (Exception e) {
            System.out.println("no lo veo");
        }
        //this.cliente = c;
    }

    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }
    
    public void generateCliente(String ip, int port)
    {
        try {
            this.cliente = new Client(ip, port);
        } catch (SocketException ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jpBuscar = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jpIngresar = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jpListar = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jpEliminar = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jpSalir = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));
        jPanel2.setForeground(new java.awt.Color(255, 102, 0));

        jLabel1.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NOVA DICTIONARY");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dictionaryclient_images/dictionary.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jpBuscar.setBackground(new java.awt.Color(255, 255, 255));
        jpBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpBuscarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jpBuscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpBuscarMouseExited(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dictionaryclient_images/search1.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 0));
        jLabel4.setText("Buscar palabra");

        javax.swing.GroupLayout jpBuscarLayout = new javax.swing.GroupLayout(jpBuscar);
        jpBuscar.setLayout(jpBuscarLayout);
        jpBuscarLayout.setHorizontalGroup(
            jpBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBuscarLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jpBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jpBuscarLayout.setVerticalGroup(
            jpBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBuscarLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jpIngresar.setBackground(new java.awt.Color(255, 255, 255));
        jpIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpIngresarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jpIngresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpIngresarMouseExited(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dictionaryclient_images/ingresar1.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 153, 0));
        jLabel8.setText("Ingresar palabra");

        javax.swing.GroupLayout jpIngresarLayout = new javax.swing.GroupLayout(jpIngresar);
        jpIngresar.setLayout(jpIngresarLayout);
        jpIngresarLayout.setHorizontalGroup(
            jpIngresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpIngresarLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jpIngresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpIngresarLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpIngresarLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(20, 20, 20))))
        );
        jpIngresarLayout.setVerticalGroup(
            jpIngresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpIngresarLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jpListar.setBackground(new java.awt.Color(255, 255, 255));
        jpListar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpListarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jpListarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpListarMouseExited(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dictionaryclient_images/lista.png"))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 153, 0));
        jLabel11.setText("Listar palabras");

        javax.swing.GroupLayout jpListarLayout = new javax.swing.GroupLayout(jpListar);
        jpListar.setLayout(jpListarLayout);
        jpListarLayout.setHorizontalGroup(
            jpListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpListarLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jpListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jpListarLayout.setVerticalGroup(
            jpListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpListarLayout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(0, 23, Short.MAX_VALUE))
        );

        jpEliminar.setBackground(new java.awt.Color(255, 255, 255));
        jpEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpEliminarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jpEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpEliminarMouseExited(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dictionaryclient_images/eliminar.png"))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 153, 0));
        jLabel13.setText("Eliminar palabra");

        javax.swing.GroupLayout jpEliminarLayout = new javax.swing.GroupLayout(jpEliminar);
        jpEliminar.setLayout(jpEliminarLayout);
        jpEliminarLayout.setHorizontalGroup(
            jpEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEliminarLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jpEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jpEliminarLayout.setVerticalGroup(
            jpEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEliminarLayout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jpSalir.setBackground(new java.awt.Color(255, 255, 255));
        jpSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jpSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpSalirMouseExited(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dictionaryclient_images/salir.png"))); // NOI18N

        javax.swing.GroupLayout jpSalirLayout = new javax.swing.GroupLayout(jpSalir);
        jpSalir.setLayout(jpSalirLayout);
        jpSalirLayout.setHorizontalGroup(
            jpSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSalirLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );
        jpSalirLayout.setVerticalGroup(
            jpSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSalirLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jpBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jpIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jpListar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jpEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jpListar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jpBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jpBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpBuscarMouseClicked
            
        SearchView v = new SearchView(this, true, cliente, this);
        v.setVisible(true);
        
        
    }//GEN-LAST:event_jpBuscarMouseClicked

    private void jpBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpBuscarMouseEntered
        setColorEntrar(jpBuscar);
    }//GEN-LAST:event_jpBuscarMouseEntered

    private void jpBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpBuscarMouseExited
        setColorSalir(jpBuscar);
    }//GEN-LAST:event_jpBuscarMouseExited

    private void jpSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jpSalirMouseClicked

    private void jpSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpSalirMouseEntered
        setColorEntrar(jpSalir);
    }//GEN-LAST:event_jpSalirMouseEntered

    private void jpSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpSalirMouseExited
        setColorSalir(jpSalir);
    }//GEN-LAST:event_jpSalirMouseExited

    private void jpIngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpIngresarMouseClicked
       
        AddView v = new AddView(cliente, this);
        this.setVisible(false);
        v.setVisible(true);
        
    }//GEN-LAST:event_jpIngresarMouseClicked

    private void jpIngresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpIngresarMouseEntered
        setColorEntrar(jpIngresar);
    }//GEN-LAST:event_jpIngresarMouseEntered

    private void jpIngresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpIngresarMouseExited
        setColorSalir(jpIngresar);
    }//GEN-LAST:event_jpIngresarMouseExited

    private void jpListarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpListarMouseClicked
        
        String response = this.cliente.selectAllConcepts();
        System.out.println(response);
        String[] lista = response.split(";");
        System.out.println(lista.length);
        //System.out.println(this.cliente.selectAllConcepts());
        ArrayList<String> palabras = new ArrayList<String>();
        for (int i = 1; i < lista.length; i++) {
            String linea = lista[i];
            //System.out.println(linea.split("-").length);
            if(linea.split("-").length == 2){
//                String palabra = linea.split("-")[0];
//                String definicion = linea.split("-")[1];

                String consept = " - " + linea.split("-")[0] + " : " + linea.split("-")[1];
                palabras.add(consept);
            }
        }
        
        ShowView view = new ShowView(palabras,this);
        this.setVisible(false);
        view.setVisible(true);
        
        
    }//GEN-LAST:event_jpListarMouseClicked

    private void jpListarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpListarMouseEntered
        setColorEntrar(jpListar);
    }//GEN-LAST:event_jpListarMouseEntered

    private void jpListarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpListarMouseExited
        setColorSalir(jpListar);
    }//GEN-LAST:event_jpListarMouseExited

    private void jpEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpEliminarMouseClicked
        DeleteView v = new DeleteView(cliente, this);
        this.setVisible(false);
        v.setVisible(true);
    }//GEN-LAST:event_jpEliminarMouseClicked

    private void jpEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpEliminarMouseEntered
        setColorEntrar(jpEliminar);
    }//GEN-LAST:event_jpEliminarMouseEntered

    private void jpEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpEliminarMouseExited
        setColorSalir(jpEliminar);
    }//GEN-LAST:event_jpEliminarMouseExited

    private void setColorEntrar(JPanel panel) {

        panel.setBackground(new java.awt.Color(255, 223, 172));
    }

    private void setColorSalir(JPanel panel) {

        panel.setBackground(new java.awt.Color(255, 255, 255));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        MainPage ventana = new MainPage();
        ConfigurateView cv = new ConfigurateView(ventana, true, ventana);
        cv.setVisible(true);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jpBuscar;
    private javax.swing.JPanel jpEliminar;
    private javax.swing.JPanel jpIngresar;
    private javax.swing.JPanel jpListar;
    private javax.swing.JPanel jpSalir;
    // End of variables declaration//GEN-END:variables
}
