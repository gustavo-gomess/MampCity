package repository;

import model.Inventario;
import java.util.List;
import java.util.ArrayList;


public class InventarioDAO implements IGenericDao<Inventario> {


    static List<Inventario> novoItem = new ArrayList<>();

    public static void cadastraItem (Inventario inventario) { novoItem.add(inventario);}

    public static List<Inventario> buscaInventario () {
        return novoItem;
    }


    @Override
    public void salvar(Inventario objeto) {

    }

    @Override
    public void remover(Inventario objeto) {

    }

    @Override
    public List<Inventario> buscarTodos() {
        return null;
    }

    @Override
    public List<Inventario> buscarPorNome(String nome) {
        return null;
    }
}
