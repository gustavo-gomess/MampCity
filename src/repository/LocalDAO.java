package repository;

import model.Local;
import model.Socio;

import java.util.ArrayList;
import java.util.List;

public class LocalDAO implements IGenericDao<Local>{

    static List<Local> novoLocal = new ArrayList<>();

    public static List<Local> buscaTodosLocais() {
        return novoLocal;
    }

    @Override
    public void salvar(Local local) {
        novoLocal.add(local);
    }

    @Override
    public void remover(Local local) {
            novoLocal.remove(local);
    }

    @Override
    public List<Local> buscarTodos() {
        System.out.println(novoLocal);
        return novoLocal;
    }

    @Override
    public List<Local> buscarPorNome(String nome) {
        List<Local> localfiltrados = new ArrayList<>();
        for (Local local : novoLocal) {
            if (local.getNome().contains(nome)) {
                localfiltrados.add(local);
            }
        }
        return localfiltrados;
    }

    public Object[] findLocalInArray() {
        List<Local>  locais = buscarTodos();
        List<String> localsNomes = new ArrayList<>();

        for (Local local : locais) {
            localsNomes.add(local.getNome());
        }

        return localsNomes.toArray();
    }
}


