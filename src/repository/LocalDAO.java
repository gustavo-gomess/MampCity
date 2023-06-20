package repository;

import model.Local;
import model.Socio;

import java.util.ArrayList;
import java.util.List;

public class LocalDAO implements IGenericDao<Local>{
    static List<Local> novoLocal = new ArrayList<>();

    public void init(){
        if (novoLocal.isEmpty()){
            Local local1 = new Local();;
            local1.setNome("SALÃO 1");
            local1.setDescricacaoLocal("COM 200 CADEIRAS");

            Local local2 = new Local();
            local2.setNome("SALÃO 2");
            local2.setDescricacaoLocal("COM 500 CADEIRAS");

            Local local3 = new Local();
            local3.setNome("SALÃO 1");
            local3.setDescricacaoLocal("COM 1000 CADEIRAS");

            novoLocal.add(local1);
            novoLocal.add(local2);
            novoLocal.add(local3);
        }
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
        init();
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


