package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Marca;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class DaoMarcaImp implements DaoMarca {
    Connection conexao = null;
    PreparedStatement pstm = null;

    @Override
    public void salvarMarca(Marca marca) {
        conexao = new Conexao().getConnection();
        String sqlinsert = "INSERT INTO tb_marca(descricao) values(?)";
        try {
            pstm = conexao.prepareStatement(sqlinsert, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            pstm.setString(1, marca.getDescricao());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException insert) {
            System.out.println("Erro: " + insert);
        } finally {
            try {
                conexao.close();
            } catch (SQLException insertclose) {
                System.out.println("Erro: " + insertclose);
            }
        }
    }

    @Override
    public void alterarMarca(Marca marca) {
        conexao = new Conexao().getConnection();
        String query = "UPDATE tb_marca SET descricao=? WHERE id=?";
        try {
            pstm = conexao.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            pstm.setString(1, marca.getDescricao());
            pstm.setInt(2, marca.getId());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Editado com sucesso!");
        } catch (SQLException update) {
            System.out.println("Erro: " + update);
        } finally {
            try {
                conexao.close();
            } catch (SQLException updateclose) {
                System.out.println("Erro: " + updateclose);
            }
        }
    }

    @Override
    public void excluirMarca(int id) {
        int resp = JOptionPane.showConfirmDialog(null, "Deseja realmente exluir o registro?");
        if (resp == 1) {
            JOptionPane.showMessageDialog(null, "Você não excluiu o registro");
        } else {
            conexao = new Conexao().getConnection();
            String query = "DELETE FROM tb_marca WHERE id=?";
            try {
                pstm = conexao.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                pstm.setInt(1, id);
                pstm.execute();
                pstm.close();
                JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            } catch (SQLException delete) {
                System.out.println("Erro: " + delete);
            } finally {
                try {
                    conexao.close();
                } catch (SQLException deleteclose) {
                    System.out.println("Erro: " + deleteclose);
                }
            }

        }
    }

    @Override
    public List<Marca> getMarcas() {
        ResultSet rs = null;
        List<Marca> lista = new ArrayList<Marca>();
        conexao = new Conexao().getConnection();
        String query = "SELECT * FROM tb_marca";
        try {
            pstm = conexao.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = pstm.executeQuery();
            rs.first();
            do {
                Marca marca = new Marca();
                marca.setId(rs.getInt("id"));
                marca.setDescricao(rs.getString("descricao"));

                lista.add(marca);

            } while (rs.next());
        } catch (SQLException errolistar) {
            System.out.println("Erro: " + errolistar);
        } finally {
            try {
                conexao.close();
            } catch (SQLException errofechar) {
                System.out.println("Erro: " + errofechar);
            }
        }
        return lista;
    }
    
    @Override
    public int buscarId(String descricao) {
        ResultSet rs = null;
        conexao = new Conexao().getConnection();
        String query = "SELECT id FROM tb_marca WHERE descricao = ?";
        int id = 0;
        try {
            pstm = conexao.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            pstm.setString(1, descricao);
            rs = pstm.executeQuery();
            if(rs.first())
            {
            id = rs.getInt("id");
            }
        } catch (SQLException update) {
            System.out.println("Erro: " + update);
        } finally {
            try {
                conexao.close();
            } catch (SQLException updateclose) {
                System.out.println("Erro: " + updateclose);
            }
        }
        return id;
    }
    
    public String buscarMarca(int id){
        ResultSet rs = null;
        conexao = new Conexao().getConnection();
        String query = "SELECT descricao FROM tb_marca WHERE id = ?";
        String marca = "";
        try {
            pstm = conexao.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if(rs.first())
            {
            marca = rs.getString("descricao");
            }
        } catch (SQLException update) {
            System.out.println("Erro: " + update);
        } finally {
            try {
                conexao.close();
            } catch (SQLException updateclose) {
                System.out.println("Erro: " + updateclose);
            }
        }
        return marca;
    }
    
     @Override
    public List<Marca> carregaCombo() {
         
        List<Marca> lista = new ArrayList<Marca>();
        conexao = new Conexao().getConnection();
        
        String query = "SELECT * FROM tb_marca ORDER BY descricao ASC";
        
        try {
            pstm = conexao.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            
           
            ResultSet rs = pstm.executeQuery();
            rs.first();
           
            do{
                JOptionPane.showMessageDialog(null, "Deu certo 1");
                Marca marca = new Marca();
                marca.setId(rs.getInt("id"));
                marca.setDescricao(rs.getString("descricao"));
                
                lista.add(marca);

            }while(rs.next());
        } catch (SQLException errolistar) {
            System.out.println("Erro: " + errolistar);
        } finally {
            try {
                conexao.close();
            } catch (SQLException errofechar) {
                System.out.println("Erro: " + errofechar);
            }
        }
        return lista;
    }

    @Override
    public void gerarRelatorioCollection(List list, String CAMINHO_RELATORIO) {
        HashMap filtro = new HashMap();
        JRBeanCollectionDataSource colecao = new JRBeanCollectionDataSource(list, false);

        JasperPrint imprimir = null;
        try {
            imprimir = JasperFillManager.fillReport(CAMINHO_RELATORIO, filtro, colecao);
        } catch (JRException ex) {
            Logger.getLogger(DaoMarcaImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        JasperViewer visualizar = new JasperViewer(imprimir, false);
        visualizar.setVisible(true);
    }

    
}
