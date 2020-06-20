package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.*;
import controller.*;
import java.awt.Dimension;
import java.awt.Toolkit;

public class FrmCadastroNotebook extends javax.swing.JInternalFrame {
    int indice = 0;
    
    List<Notebook> list = new ArrayList<Notebook>();
    List<Marca> marcas = new ArrayList<Marca>();
    NotebookController notebookController = new NotebookController();
    MarcaController marcaController = new MarcaController();
    
    public FrmCadastroNotebook() {
        initComponents();
        centralizarComponente();
        
        txtId.setEnabled(false);
        list = notebookController.getNotebooks();
        marcas = marcaController.carregaCombo();
        if(marcas.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Você deve cadastrar uma Marca primeiro!","Erro",JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
        else
        {
            while(!marcas.isEmpty())
            {
                cbxMarca.addItem(marcas.get(0).getDescricao());
                marcas.remove(0);
            }
        }
        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ainda não foram cadastrados Notebooks!");
        } else {
            mostrarDados();
            preencheTabela();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoTipo = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        lblSerie = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        cbxMarca = new javax.swing.JComboBox<>();
        txtSerie = new javax.swing.JFormattedTextField();
        rbConvencional = new javax.swing.JRadioButton();
        rbGamer = new javax.swing.JRadioButton();
        btnPrimeiro = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnProximo = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbNotebooks = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Notebooks");

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Cadastro de Notebooks");

        lblId.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblId.setText("Id:");

        lblModelo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblModelo.setText("Modelo:");

        lblMarca.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblMarca.setText("Marca:");

        lblSerie.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSerie.setText("Série:");

        lblTipo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTipo.setText("Tipo de Notebook:");

        cbxMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Selecionar--" }));

        try {
            txtSerie.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        grupoTipo.add(rbConvencional);
        rbConvencional.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbConvencional.setText("Convencional");

        grupoTipo.add(rbGamer);
        rbGamer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbGamer.setText("Gamer");

        btnPrimeiro.setText("|<");
        btnPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeiroActionPerformed(evt);
            }
        });

        btnAnterior.setText("<<");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnProximo.setText(">>");
        btnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximoActionPerformed(evt);
            }
        });

        btnUltimo.setText(">|");
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });

        btnNovo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        tbNotebooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "modelo", "marca", "serie", "tipo"
            }
        ));
        tbNotebooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNotebooksMouseClicked(evt);
            }
        });
        tbNotebooks.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbNotebooksKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbNotebooks);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMarca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSerie))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTipo)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(rbConvencional)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbGamer, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 9, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPrimeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSerie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbConvencional)
                    .addComponent(rbGamer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrimeiro)
                    .addComponent(btnAnterior)
                    .addComponent(btnProximo)
                    .addComponent(btnUltimo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeiroActionPerformed
        indice = 0;
        mostrarDados();
    }//GEN-LAST:event_btnPrimeiroActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        indice--;
        if(indice < 0){
            indice++;
            JOptionPane.showMessageDialog(null, "Você está no primeiro registro!");
        }
        mostrarDados();
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoActionPerformed
        indice++;
        if(indice > list.size() - 1){
            indice--;
            JOptionPane.showMessageDialog(null, "Você está no último registro!");
        }
        mostrarDados();
    }//GEN-LAST:event_btnProximoActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        indice = list.size() - 1;
        mostrarDados();
    }//GEN-LAST:event_btnUltimoActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        txtId.setText("");
        txtModelo.setText("");
        cbxMarca.setSelectedItem("--Selecionar--");
        txtSerie.setText("");
        grupoTipo.clearSelection();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Notebook n = new Notebook();
        n.setModelo(txtModelo.getText());
        n.setMarca(marcaController.buscarId(cbxMarca.getSelectedItem().toString()));
        n.setSerie(txtSerie.getText());
                if(rbConvencional.isSelected()){
            n.setTipo(rbConvencional.getText());
        } if(rbGamer.isSelected()) {
            n.setTipo(rbGamer.getText());
        }
        
        notebookController.salvarNotebook(n);
        
        list.clear();
        list = notebookController.getNotebooks();
        indice = list.size() - 1;
        mostrarDados();
        preencheTabela();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void tbNotebooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNotebooksMouseClicked
        preencherDadosFormulario();
    }//GEN-LAST:event_tbNotebooksMouseClicked

    private void tbNotebooksKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbNotebooksKeyReleased
        if (evt.getKeyCode() == 38 || evt.getKeyCode() == 40) {
            preencherDadosFormulario();
        }
    }//GEN-LAST:event_tbNotebooksKeyReleased

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Notebook n = new Notebook();
        n.setId(Integer.parseInt(txtId.getText()));
        n.setModelo(txtModelo.getText());
        n.setMarca(marcaController.buscarId(cbxMarca.getSelectedItem().toString()));
        n.setSerie(txtSerie.getText());
        if(rbConvencional.isSelected()){
            n.setTipo(rbConvencional.getText());
        } if(rbGamer.isSelected()) {
            n.setTipo(rbGamer.getText());
        }
        
        notebookController.alterarNotebook(n);
        
        list.clear();
        list = notebookController.getNotebooks();
        indice = list.size() - 1;
        mostrarDados();
        preencheTabela();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int id = (Integer.parseInt(txtId.getText()));
        notebookController.excluirNotebook(id);
        list.clear();
        list = notebookController.getNotebooks();
        indice = list.size() - 1;
        mostrarDados();
        preencheTabela();
    }//GEN-LAST:event_btnExcluirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPrimeiro;
    private javax.swing.JButton btnProximo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JComboBox<String> cbxMarca;
    private javax.swing.ButtonGroup grupoTipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblSerie;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JRadioButton rbConvencional;
    private javax.swing.JRadioButton rbGamer;
    private javax.swing.JTable tbNotebooks;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JFormattedTextField txtSerie;
    // End of variables declaration//GEN-END:variables

public void mostrarDados(){
    txtId.setText("" + list.get(indice).getId());
    txtModelo.setText(list.get(indice).getModelo());
    cbxMarca.setSelectedItem(marcaController.buscarDescricao(list.get(indice).getMarca()));
    txtSerie.setText(list.get(indice).getSerie());
    if(list.get(indice).getTipo().equals("Convencional")){
        rbConvencional.setSelected(true);
    } if(list.get(indice).getTipo().equals("Gamer")){
        rbGamer.setSelected(true);
    }
}

public void preencheTabela() {
        tbNotebooks.getColumnModel().getColumn(0).setPreferredWidth(20);
        DefaultTableModel modelo = (DefaultTableModel) tbNotebooks.getModel();
        modelo.setNumRows(0);
        for (int i = 0; i < list.size(); i++) {
            modelo.addRow(new Object[]{list.get(i).getId(), list.get(i).getModelo(), 
               marcaController.buscarDescricao(list.get(i).getMarca()), list.get(i).getSerie(), list.get(i).getTipo()});
        }
    }

    public void preencherDadosFormulario() {
        int indiceDaTabela = tbNotebooks.getSelectedRow();
        txtId.setText("" + tbNotebooks.getValueAt(indiceDaTabela, 0));
        txtModelo.setText(tbNotebooks.getValueAt(indiceDaTabela, 1).toString());
        cbxMarca.setSelectedItem(tbNotebooks.getValueAt(indiceDaTabela, 2).toString());
        txtSerie.setText(tbNotebooks.getValueAt(indiceDaTabela, 3).toString());
        if (tbNotebooks.getValueAt(indiceDaTabela, 4).toString().equals("Convencional")) {
            rbConvencional.setSelected(true);
        }
        if (tbNotebooks.getValueAt(indiceDaTabela, 4).toString().equals("Gamer")) {
            rbGamer.setSelected(true);
        }
    }
    
    public void centralizarComponente() { 
        Dimension ds = Toolkit.getDefaultToolkit().getScreenSize(); 
        Dimension dw = getSize(); 
        setLocation((ds.width - dw.width) / 2, (ds.height - 500) / 2); 
    }
}
