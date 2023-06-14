package repository;

import model.Inventario;
import java.util.List;
import java.util.ArrayList;


public class InventarioDAO implements IGenericDao<Inventario> {
    static List<Inventario> listaInventario = new ArrayList<>();

    public static List<Inventario> buscaInventario () {
        return listaInventario;
    }


    @Override
    public void salvar(Inventario inventario) {
        if (inventario.getId() == null){
            inventario.setId((long) (listaInventario.size() +1));
        } else {
            listaInventario.remove((int) (inventario.getId() - 1));
        }
        listaInventario.add(inventario);

    }

    @Override
    public void remover(Inventario inventario) {
        if(inventario.getId() != null){
            listaInventario.remove((int) (inventario.getId() -1));
        }
    }

    @Override
    public List<Inventario> buscarTodos() {
        System.out.println(listaInventario);
        return listaInventario;
    }

    @Override
    public List<Inventario> buscarPorNome(String nome) {
        // por ora ficará assim
        // podemos tentar colocar uma busca por ITEM
        return null;
    }
}
