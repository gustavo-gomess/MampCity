package repository;

import model.Local;
import java.util.ArrayList;
import java.util.List;

public class LocalDAO implements IGenericDao<Local>{

    static List<Local> novoLocal = new ArrayList<>();

    public static void cadastrarLocal(Local local ) { novoLocal.add(local);

    }
    public static List<Local> buscaTodosLocais() {
        return novoLocal;
    }

    @Override
    public void salvar(Local objeto) {

    }

    @Override
    public void remover(Local objeto) {

    }

    @Override
    public List<Local> buscarTodos() {
        return null;
    }

    @Override
    public List<Local> buscarPorNome(String nome) {
        return null;
    }
}


