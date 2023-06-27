package repository;

import model.Local;
import model.Socio;

import java.util.ArrayList;
import java.util.List;

public class LocalDAO implements IGenericDao<Local>{
    static List<Local> novoLocal = new ArrayList<>();

    @Override
    public void salvar(Local local) {
        if (local.getId() == null) {
            local.setId((long) (novoLocal.size() + 1));
        } else {
            novoLocal.remove((int) (local.getId() - 1));
        }

        novoLocal.add(local);
    }

    @Override
    public void remover(Local local) {
        if (local.getId() != null) {
            novoLocal.remove((int) (local.getId() - 1));
        }
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


