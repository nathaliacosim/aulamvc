package view;

import controller.UsuarioController;
import java.awt.Dimension;
import java.awt.Toolkit;
import model.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;

public class FrmRelatorioUsuario extends javax.swing.JInternalFrame {
    UsuarioController usuarioController = new UsuarioController();
    List<Usuario> usuarios = new ArrayList<Usuario>();

    public FrmRelatorioUsuario() {
        initComponents();
        centralizarComponente();
        usuarios = usuarioController.getUsuarios();
        if (usuarios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ainda não foram cadastrados usuarios");
        } else {
            preencheUsuarios();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblNomeUsuario = new javax.swing.JLabel();
        cbxUsuario = new javax.swing.JComboBox<>();
        btnGerarRelatorio = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitulo.setText("Relatório de Usuário");

        lblNomeUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNomeUsuario.setText("Nome de usuário:");

        btnGerarRelatorio.setText("Gerar Relatório");
        btnGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(lblTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomeUsuario)
                            .addComponent(cbxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGerarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(38, 38, 38)
                .addComponent(lblNomeUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnGerarRelatorio)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarRelatorioActionPerformed
        try {
            String nomeUsuario = cbxUsuario.getSelectedItem().toString();
            usuarioController.gerarRelatorioUsuario(nomeUsuario);
        } catch (JRException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + erro);
        } catch (SQLException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGerarRelatorioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerarRelatorio;
    private javax.swing.JComboBox<String> cbxUsuario;
    private javax.swing.JLabel lblNomeUsuario;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables

    public void preencheUsuarios() {
        cbxUsuario.addItem("--Selecione--");
        for (int i = 0; i < usuarios.size(); i++) {
            cbxUsuario.addItem(usuarios.get(i).getNome());
        }
    }
    
    public void centralizarComponente() { 
        Dimension ds = Toolkit.getDefaultToolkit().getScreenSize(); 
        Dimension dw = getSize(); 
        setLocation((ds.width - dw.width) / 2, (ds.height - 450) / 2); 
    }
}
