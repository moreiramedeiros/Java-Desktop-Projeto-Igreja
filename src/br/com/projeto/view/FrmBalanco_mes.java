/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.view;

import br.com.projeto.dao.Balanco_mesDAO;
import br.com.projeto.dao.IgrejasDAO;
import br.com.projeto.model.Igrejas;
import br.com.projeto.utilitarios.Relatorio;
import br.com.projeto.utilitarios.Utilitarios;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Isaac
 */
public class FrmBalanco_mes extends javax.swing.JFrame {

            
         Utilitarios util = new Utilitarios();
    
    public void listarIgrejaComboBox() {

        IgrejasDAO dao = new IgrejasDAO();
        List<Igrejas> lista = dao.listarIgrejas();
        cbIgrejas.removeAllItems();

        for (Igrejas c : lista) {
            cbIgrejas.addItem(c);
        }
    }

    
     public void listarAnoComboBox() {
        cbAno.removeAllItems();
        int anoAtual = Integer.parseInt(util.getAnoAtual());
        for (int i=2000;i<=anoAtual;i++) {
            cbAno.addItem(String.valueOf(i));
        }
        
 
         cbAno.setSelectedItem(util.getAnoAtual());
   
    }
    
  
    public void listarMesComboBox() {
        cbMes.removeAllItems();
        for (int i=1;i<13;i++) {
            cbMes.addItem(util.convertMesParaNome(i));
        }
         
         int mesAtual = Integer.parseInt(util.getMesAtual());
         cbMes.setSelectedItem(util.convertMesParaNome(mesAtual));
        
    } 
    /**
     * Creates new form RrmBalanco_mes
     */
    public FrmBalanco_mes() {
        initComponents();
        listarIgrejaComboBox();
       listarMesComboBox();
       listarAnoComboBox();
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
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        cbIgrejas = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        cbAno = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        cbMes = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("Balanço do Mês");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados"));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Igreja:");

        cbIgrejas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbIgrejas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbIgrejasItemStateChanged(evt);
            }
        });
        cbIgrejas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbIgrejasMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cbIgrejasMouseReleased(evt);
            }
        });
        cbIgrejas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIgrejasActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Ano:");

        cbAno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbAno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbAnoItemStateChanged(evt);
            }
        });
        cbAno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbAnoMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cbAnoMouseReleased(evt);
            }
        });
        cbAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAnoActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Mês:");

        cbMes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbMes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMesItemStateChanged(evt);
            }
        });
        cbMes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbMesMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cbMesMouseReleased(evt);
            }
        });
        cbMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMesActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/relatorio.png"))); // NOI18N
        jButton1.setText("GERAR RELATÓRIO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbIgrejas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbAno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbIgrejas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(30, 30, 30)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(cbAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(cbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbIgrejasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbIgrejasItemStateChanged

    }//GEN-LAST:event_cbIgrejasItemStateChanged

    private void cbIgrejasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbIgrejasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbIgrejasMouseClicked

    private void cbIgrejasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbIgrejasMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cbIgrejasMouseReleased

    private void cbIgrejasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIgrejasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbIgrejasActionPerformed

    private void cbMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMesActionPerformed

    private void cbMesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbMesMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMesMouseReleased

    private void cbMesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbMesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMesMouseClicked

    private void cbMesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMesItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMesItemStateChanged

    private void cbAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAnoActionPerformed

    private void cbAnoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbAnoMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAnoMouseReleased

    private void cbAnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbAnoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAnoMouseClicked

    private void cbAnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAnoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAnoItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        Balanco_mesDAO dao = new Balanco_mesDAO();
        String mesNome = cbMes.getSelectedItem().toString();
        
        int mes = util.convertMesParaNumero(mesNome);
        int ano = Integer.parseInt(cbAno.getSelectedItem().toString());        
        Igrejas igreja =  (Igrejas) cbIgrejas.getSelectedItem();
        int id_igreja = igreja.getId();      
        double total_dizimos = dao.totalDizimo(id_igreja,mes,ano); 
        double total_ofertas = dao.totalOferta(id_igreja,mes,ano);         
        double total_despesas = dao.totalDespesas(id_igreja,mes,ano);    

        Relatorio relatorio = new  Relatorio();  
        
        
        
        
        relatorio.setNomeIgreja(igreja.getNome());
        relatorio.setMes(mesNome);
        relatorio.setAno(String.valueOf(ano));
        relatorio.setTotal_dizimos(total_dizimos);
        relatorio.setTotal_ofertas(total_ofertas);        
        relatorio.setTotal_despesas(total_despesas);  
        relatorio.setId_igreja(id_igreja);
        
        FrmRelatorio  a = new FrmRelatorio(relatorio,0);
        
        
        
        
        a.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmBalanco_mes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBalanco_mes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBalanco_mes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBalanco_mes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmBalanco_mes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbAno;
    private javax.swing.JComboBox cbIgrejas;
    private javax.swing.JComboBox cbMes;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    // End of variables declaration//GEN-END:variables
}
