package view;

import controller.MarcaController;
import controller.NotebookController;
import controller.UsuarioController;
import java.io.IOException;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*;

public class FrmPrincipal extends javax.swing.JFrame {
    NotebookController notebookController = new NotebookController();
    MarcaController marcaController = new MarcaController();
    UsuarioController usuarioController = new UsuarioController();

    public FrmPrincipal() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        menuPrincipal = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        menuItemNotebook = new javax.swing.JMenuItem();
        menuItemMarca = new javax.swing.JMenuItem();
        menuItemUsuario = new javax.swing.JMenuItem();
        menuRelatorios = new javax.swing.JMenu();
        menuItemRelatorioNotebooks = new javax.swing.JMenuItem();
        menuItemRelatorioNotebooksGamer = new javax.swing.JMenuItem();
        menuItemRelatorioNotebooksConv = new javax.swing.JMenuItem();
        menuItemRelatorioMarcas = new javax.swing.JMenuItem();
        menuItemRelatorioUsuarios = new javax.swing.JMenuItem();
        menuUtilidades = new javax.swing.JMenu();
        menuItemBloco = new javax.swing.JMenuItem();
        menuItemCalc = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 281, Short.MAX_VALUE)
        );

        menuCadastro.setText("Cadastro");
        menuCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroActionPerformed(evt);
            }
        });

        menuItemNotebook.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK));
        menuItemNotebook.setText("Notebook");
        menuItemNotebook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNotebookActionPerformed(evt);
            }
        });
        menuCadastro.add(menuItemNotebook);

        menuItemMarca.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK));
        menuItemMarca.setText("Marca");
        menuItemMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemMarcaActionPerformed(evt);
            }
        });
        menuCadastro.add(menuItemMarca);

        menuItemUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        menuItemUsuario.setText("Usuario");
        menuItemUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemUsuarioActionPerformed(evt);
            }
        });
        menuCadastro.add(menuItemUsuario);

        menuPrincipal.add(menuCadastro);

        menuRelatorios.setText("Relatórios");

        menuItemRelatorioNotebooks.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_MASK));
        menuItemRelatorioNotebooks.setText("Relatório de Noteboooks");
        menuItemRelatorioNotebooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRelatorioNotebooksActionPerformed(evt);
            }
        });
        menuRelatorios.add(menuItemRelatorioNotebooks);

        menuItemRelatorioNotebooksGamer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.SHIFT_MASK));
        menuItemRelatorioNotebooksGamer.setText("Relatório de Noteboooks Gamer");
        menuItemRelatorioNotebooksGamer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRelatorioNotebooksGamerActionPerformed(evt);
            }
        });
        menuRelatorios.add(menuItemRelatorioNotebooksGamer);

        menuItemRelatorioNotebooksConv.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK));
        menuItemRelatorioNotebooksConv.setText("Relatório de Noteboooks Convencional");
        menuItemRelatorioNotebooksConv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRelatorioNotebooksConvActionPerformed(evt);
            }
        });
        menuRelatorios.add(menuItemRelatorioNotebooksConv);

        menuItemRelatorioMarcas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.SHIFT_MASK));
        menuItemRelatorioMarcas.setText("Relatório de Marcas");
        menuItemRelatorioMarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRelatorioMarcasActionPerformed(evt);
            }
        });
        menuRelatorios.add(menuItemRelatorioMarcas);

        menuItemRelatorioUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.SHIFT_MASK));
        menuItemRelatorioUsuarios.setText("Relatório de Usuários");
        menuItemRelatorioUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRelatorioUsuariosActionPerformed(evt);
            }
        });
        menuRelatorios.add(menuItemRelatorioUsuarios);

        menuPrincipal.add(menuRelatorios);

        menuUtilidades.setText("Utilidades");

        menuItemBloco.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK));
        menuItemBloco.setText("Bloco de Notas");
        menuItemBloco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBlocoActionPerformed(evt);
            }
        });
        menuUtilidades.add(menuItemBloco);

        menuItemCalc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        menuItemCalc.setText("Calculadora");
        menuItemCalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCalcActionPerformed(evt);
            }
        });
        menuUtilidades.add(menuItemCalc);

        menuPrincipal.add(menuUtilidades);

        menuSair.setText("Sair");
        menuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSairMouseClicked(evt);
            }
        });
        menuPrincipal.add(menuSair);

        setJMenuBar(menuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSairMouseClicked
       System.exit(0);
    }//GEN-LAST:event_menuSairMouseClicked

    private void menuCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroActionPerformed
        
    }//GEN-LAST:event_menuCadastroActionPerformed

    private void menuItemNotebookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNotebookActionPerformed
        FrmCadastroNotebook not = new FrmCadastroNotebook();
        desktop.add(not);
        not.setVisible(true);
    }//GEN-LAST:event_menuItemNotebookActionPerformed

    private void menuItemBlocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBlocoActionPerformed
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec("C:\\WINDOWS\\system32\\notepad.exe");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ocorreu uma falha ao tentar abrir o bloco de notas!", "Falha!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuItemBlocoActionPerformed

    private void menuItemCalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCalcActionPerformed
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec("C:\\WINDOWS\\system32\\calc.exe");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ocorreu uma falha ao tentar abrir calculadora!", "Falha!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuItemCalcActionPerformed

    private void menuItemMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemMarcaActionPerformed
        FrmCadastroMarca mar = new FrmCadastroMarca();
        desktop.add(mar);
        mar.setVisible(true);
    }//GEN-LAST:event_menuItemMarcaActionPerformed

    private void menuItemUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemUsuarioActionPerformed
        FrmCadastroUsuario usu = new FrmCadastroUsuario();
        desktop.add(usu);
        usu.setVisible(true);
    }//GEN-LAST:event_menuItemUsuarioActionPerformed

    private void menuItemRelatorioNotebooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRelatorioNotebooksActionPerformed
        try {
            notebookController.gerarRelatorioGeral();
        } catch (JRException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + erro);
        }
    }//GEN-LAST:event_menuItemRelatorioNotebooksActionPerformed

    private void menuItemRelatorioMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRelatorioMarcasActionPerformed
        try {
            marcaController.gerarRelatorioGeral();
        } catch (JRException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + erro);
        }
    }//GEN-LAST:event_menuItemRelatorioMarcasActionPerformed

    private void menuItemRelatorioUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRelatorioUsuariosActionPerformed
        FrmRelatorioUsuario relatorioUsuario = new FrmRelatorioUsuario();
        desktop.add(relatorioUsuario);
        relatorioUsuario.setVisible(true);
    }//GEN-LAST:event_menuItemRelatorioUsuariosActionPerformed

    private void menuItemRelatorioNotebooksConvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRelatorioNotebooksConvActionPerformed
        try {
            notebookController.gerarRelatorioNotebookConvencional();
        } catch (JRException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + erro);
        }
    }//GEN-LAST:event_menuItemRelatorioNotebooksConvActionPerformed

    private void menuItemRelatorioNotebooksGamerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRelatorioNotebooksGamerActionPerformed
        try {
            notebookController.gerarRelatorioNotebookGamer();
        } catch (JRException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + erro);
        }
    }//GEN-LAST:event_menuItemRelatorioNotebooksGamerActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenuItem menuItemBloco;
    private javax.swing.JMenuItem menuItemCalc;
    private javax.swing.JMenuItem menuItemMarca;
    private javax.swing.JMenuItem menuItemNotebook;
    private javax.swing.JMenuItem menuItemRelatorioMarcas;
    private javax.swing.JMenuItem menuItemRelatorioNotebooks;
    private javax.swing.JMenuItem menuItemRelatorioNotebooksConv;
    private javax.swing.JMenuItem menuItemRelatorioNotebooksGamer;
    private javax.swing.JMenuItem menuItemRelatorioUsuarios;
    private javax.swing.JMenuItem menuItemUsuario;
    private javax.swing.JMenuBar menuPrincipal;
    private javax.swing.JMenu menuRelatorios;
    private javax.swing.JMenu menuSair;
    private javax.swing.JMenu menuUtilidades;
    // End of variables declaration//GEN-END:variables
}
