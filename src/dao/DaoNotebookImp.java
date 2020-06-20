package dao;
import conexao.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Notebook;
import model.NotebookReport;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class DaoNotebookImp implements DaoNotebook {
    Connection conexao = null;
    PreparedStatement pstm = null;
    
    @Override
    public void salvarNotebook(Notebook n) {
       conexao = new Conexao().getConnection();
        String sqlinsert = "INSERT INTO tb_notebook(modelo, marca, serie, tipo) values(?,?,?,?)";
        try {
            pstm = conexao.prepareStatement(sqlinsert, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            pstm.setString(1, n.getModelo());
            pstm.setInt(2, n.getMarca());
            pstm.setString(3, n.getSerie());
            pstm.setString(4, n.getTipo());
            pstm.execute();
            pstm.close();
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
    public void editarNotebook(Notebook n) {
        conexao = new Conexao().getConnection();
        String query = "UPDATE tb_notebook SET modelo=?, marca=?, serie=?, tipo=? WHERE id=?";
        try {
            pstm = conexao.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            pstm.setString(1, n.getModelo());
            pstm.setInt(2, n.getMarca());
            pstm.setString(3, n.getSerie());
            pstm.setString(4, n.getTipo());
            pstm.setInt(5, n.getId());
            pstm.execute();
            pstm.close();
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
    public void deletarNotebook(int id) {
        conexao = new Conexao().getConnection();
        String query = "DELETE FROM tb_notebook WHERE id=?";
        try {
            pstm = conexao.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            pstm.setInt(1, id);
            pstm.execute();
            pstm.close();
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

    @Override
    public List<Notebook> getNotebooks() {
        ResultSet rs = null;
        List<Notebook> lista = new ArrayList<Notebook>();
        conexao = new Conexao().getConnection();
        String query = "SELECT * FROM tb_notebook";
        try {
            pstm = conexao.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = pstm.executeQuery();
            rs.first();
            do {
                Notebook notebook = new Notebook();
                notebook.setId(rs.getInt("id"));
                notebook.setModelo(rs.getString("modelo"));
                notebook.setMarca(rs.getInt("marca"));
                notebook.setSerie(rs.getString("serie"));
                notebook.setTipo(rs.getString("tipo"));

                lista.add(notebook);

            } while(rs.next());
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
    public List<NotebookReport> getNotebooksGamer() {
        ResultSet rs = null;
        List<NotebookReport> lista = new ArrayList<NotebookReport>();
        conexao = new Conexao().getConnection();
        String query = "SELECT n.id, n.modelo, m.descricao, n.serie, n.tipo FROM tb_notebook n, tb_marca m WHERE n.marca = m.id AND n.tipo = 'Gamer'";
        try {
            pstm = conexao.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = pstm.executeQuery();
            rs.first();
            do {
                NotebookReport notebook = new NotebookReport();
                notebook.setId(rs.getInt("n.id"));
                notebook.setModelo(rs.getString("n.modelo"));
                notebook.setDescricao(rs.getString("m.descricao"));
                notebook.setSerie(rs.getString("n.serie"));
                notebook.setTipo(rs.getString("n.tipo"));

                lista.add(notebook);

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
    public void gerarRelatorioCollection(List lista, String CAMINHO_RELATORIO) {
        HashMap filtro = new HashMap();
        JRBeanCollectionDataSource colecao = new JRBeanCollectionDataSource(lista, false);

        JasperPrint imprimir = null;
        try {
            imprimir = JasperFillManager.fillReport(CAMINHO_RELATORIO, filtro, colecao);
        } catch (JRException ex) {
            Logger.getLogger(DaoNotebookImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        JasperViewer visualizar = new JasperViewer(imprimir, false);
        visualizar.setVisible(true);
    }

    @Override
    public List<NotebookReport> getNotebooksConvencional() {
        ResultSet rs = null;
        List<NotebookReport> lista = new ArrayList<NotebookReport>();
        conexao = new Conexao().getConnection();
        String query = "SELECT n.id, n.modelo, m.descricao, n.serie, n.tipo FROM tb_notebook n, tb_marca m WHERE n.marca = m.id AND n.tipo = 'Convencional'";
        try {
            pstm = conexao.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = pstm.executeQuery();
            rs.first();
            do {
                NotebookReport notebook = new NotebookReport();
                notebook.setId(rs.getInt("n.id"));
                notebook.setModelo(rs.getString("n.modelo"));
                notebook.setDescricao(rs.getString("m.descricao"));
                notebook.setSerie(rs.getString("n.serie"));
                notebook.setTipo(rs.getString("n.tipo"));

                lista.add(notebook);

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
}