package controller;

import conexao.Conexao;
import dao.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;

public class MarcaController {
    DaoMarca marcaDao = new DaoMarcaImp();

    public void salvarMarca(Marca marca) {
        if (marca != null && !marca.getDescricao().equals("")) {
            marcaDao.salvarMarca(marca);
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios!");
        }
    }

    public void alterarMarca(Marca marca) {
        if (marca != null && !marca.getDescricao().equals("")) {
            marcaDao.alterarMarca(marca);
            JOptionPane.showMessageDialog(null, "Editado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios!");
        }
    }

    public void excluirMarca(int id) {
        int resp = JOptionPane.showConfirmDialog(null, "Deseja realmente exluir o registro?");
        if (resp == 1) {
            JOptionPane.showMessageDialog(null, "Você não excluiu o registro");
        } else {
            if (id != 0) {
                marcaDao.excluirMarca(id);
                JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Informe uma marca para ser excluída!");
            }
        }
    }

    public List<Marca> getMarcas() {
        List<Marca> lista = new ArrayList<Marca>();
        lista = marcaDao.getMarcas();
        return lista;
    }

    public int buscarId(String descricao) {
        int id = marcaDao.buscarId(descricao);
        return id;
    }

    public String buscarDescricao(int id) {
        String descricao = marcaDao.buscarMarca(id);
        return descricao;
    }
    
    public List<Marca> carregaCombo() {
        List<Marca> lista = new ArrayList<Marca>();
        lista = marcaDao.carregaCombo();
        return lista;
    }
    
    public List<MarcaReport> getListaMarcas() {
        List<Marca> listaMarcas = new ArrayList<Marca>();
        List<MarcaReport> lista = new ArrayList<MarcaReport>();

        listaMarcas = marcaDao.getMarcas();
        lista = construirObjetoNotebookReports(listaMarcas);

        return lista;
    }
    
    public void gerarRelatorioGeral() throws JRException {
        String CAMINHO_RELATORIO = "C:\\Users\\NathaliaCosim\\Documents\\NetBeansProjects\\AulaMVCAPI\\src\\reports\\rel_marca.jasper";
        List<MarcaReport> lista = new ArrayList<MarcaReport>();
        lista = getListaMarcas();
        marcaDao.gerarRelatorioCollection(lista, CAMINHO_RELATORIO);
    }
    
    public List<MarcaReport> construirObjetoNotebookReports(List<Marca> listaMarcas) {
        List<MarcaReport> lista = new ArrayList<MarcaReport>();

        for (int i = 0; i < listaMarcas.size(); i++) {
            MarcaReport marcaReport = new MarcaReport();
            marcaReport.setId(listaMarcas.get(i).getId());
            marcaReport.setDescricao(listaMarcas.get(i).getDescricao());
            
            lista.add(marcaReport);
        }

        return lista;
    }
    
}
