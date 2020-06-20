package dao;
import java.util.List;
import model.Notebook;
import model.NotebookReport;
public interface DaoNotebook {
    public void salvarNotebook(Notebook n);
    public void editarNotebook(Notebook n);
    public void deletarNotebook(int id);
    public List<Notebook> getNotebooks();
    public List<NotebookReport> getNotebooksGamer();
    public List<NotebookReport> getNotebooksConvencional();
    public void gerarRelatorioCollection(List list, String CAMINHO_RELATORIO);
}