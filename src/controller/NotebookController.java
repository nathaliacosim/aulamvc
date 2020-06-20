package controller;

import dao.*;
import model.*;
import java.util.*;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*;


public class NotebookController {
    DaoNotebook notebookDao = new DaoNotebookImp();
    DaoMarca marcaDao = new DaoMarcaImp();

    public void salvarNotebook(Notebook n) {
        if (n != null && !n.getModelo().equals("")
                && !n.getSerie().equals("")
                && n.getMarca() != 0
                && !n.getSerie().equals("")
                && !n.getTipo().equals("")) {
            notebookDao.salvarNotebook(n);
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios!");
        }
    }

    public void alterarNotebook(Notebook n) {
        if (n != null && !n.getModelo().equals("")
                && !n.getSerie().equals("")
                && n.getMarca() != 0
                && !n.getSerie().equals("")
                && !n.getTipo().equals("")) {
            notebookDao.editarNotebook(n);
            JOptionPane.showMessageDialog(null, "Editado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios!");
        }
    }

    public void excluirNotebook(int id) {
        if (id != 0) {
            int resp = JOptionPane.showConfirmDialog(null, "Deseja realmente exluir o registro?");
            if (resp == 1) {
                JOptionPane.showMessageDialog(null, "Você não excluiu o registro");
            } else {
                notebookDao.deletarNotebook(id);
                JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Informe um notebook para ser excluído!");
        }
    }

    public List<Notebook> getNotebooks() {
        List<Notebook> lista = new ArrayList<Notebook>();
        lista = notebookDao.getNotebooks();
        return lista;
    }

    public List<NotebookReport> getListaNotebooks() {
        List<Notebook> listaNotebooks = new ArrayList<Notebook>();
        List<NotebookReport> lista = new ArrayList<NotebookReport>();

        listaNotebooks = notebookDao.getNotebooks();
        lista = construirObjetoNotebookReports(listaNotebooks);

        return lista;
    }

    public List<NotebookReport> getListaNotebooksGamer() {
        List<NotebookReport> lista = new ArrayList<NotebookReport>();
        lista = notebookDao.getNotebooksGamer();
        return lista;
    }
    
    public List<NotebookReport> getListaNotebooksConvencional() {
        List<NotebookReport> lista = new ArrayList<NotebookReport>();
        lista = notebookDao.getNotebooksConvencional();
        return lista;
    }

    public void gerarRelatorioGeral() throws JRException {
        String CAMINHO_RELATORIO = "C:\\Users\\NathaliaCosim\\Documents\\NetBeansProjects\\AulaMVCAPI\\src\\reports\\rel_notebook.jasper";
        List<NotebookReport> lista = new ArrayList<NotebookReport>();
        lista = getListaNotebooks();
        notebookDao.gerarRelatorioCollection(lista, CAMINHO_RELATORIO);
    }

    public void gerarRelatorioNotebookGamer() throws JRException {
        String CAMINHO_RELATORIO = "C:\\Users\\NathaliaCosim\\Documents\\NetBeansProjects\\AulaMVCAPI\\src\\reports\\rel_notebook.jasper";
        List<NotebookReport> lista = new ArrayList<NotebookReport>();
        lista = getListaNotebooksGamer();
        notebookDao.gerarRelatorioCollection(lista, CAMINHO_RELATORIO);
    }
    
    public void gerarRelatorioNotebookConvencional() throws JRException {
        String CAMINHO_RELATORIO = "C:\\Users\\NathaliaCosim\\Documents\\NetBeansProjects\\AulaMVCAPI\\src\\reports\\rel_notebook.jasper";
        List<NotebookReport> lista = new ArrayList<NotebookReport>();
        lista = getListaNotebooksConvencional();
        notebookDao.gerarRelatorioCollection(lista, CAMINHO_RELATORIO);
    }

    public List<NotebookReport> construirObjetoNotebookReports(List<Notebook> listaNotebooks) {
        List<NotebookReport> lista = new ArrayList<NotebookReport>();

        for (int i = 0; i < listaNotebooks.size(); i++) {
            NotebookReport notebookReport = new NotebookReport();
            notebookReport.setId(listaNotebooks.get(i).getId());
            notebookReport.setModelo(listaNotebooks.get(i).getModelo());
            notebookReport.setDescricao(marcaDao.buscarMarca(listaNotebooks.get(i).getMarca()));
            notebookReport.setSerie(listaNotebooks.get(i).getSerie());
            notebookReport.setTipo(listaNotebooks.get(i).getTipo());
            lista.add(notebookReport);
        }

        return lista;
    }
}
