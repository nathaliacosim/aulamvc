package dao;
import java.util.List;
import model.Marca;
public interface DaoMarca {
    public void salvarMarca(Marca marca);
    public void alterarMarca(Marca marca);
    public void excluirMarca(int id);
    public List<Marca> getMarcas();
    public int buscarId(String descricao);
    public String buscarMarca(int id);
    public List<Marca> carregaCombo();
    public void gerarRelatorioCollection(List list, String CAMINHO_RELATORIO);
}
