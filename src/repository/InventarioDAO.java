package repository;

import model.Inventario;
import model.Socio;

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
        List<Inventario> itensFiltrados = new ArrayList<>();
        for (Inventario itens : listaInventario) {
            if (itens.getItem().contains(nome)) {
                itensFiltrados.add(itens);
            }
        }
        return itensFiltrados;
    }
    public Object[] findInvetarioInArray() {
        List<Inventario> inventario = buscarTodos();
        List<String> inventarioNomes = new ArrayList<>();

        for (Inventario inventario1 : inventario) {
            inventarioNomes.add(inventario1.getItem());
        }

        return inventarioNomes.toArray();
    }
}
