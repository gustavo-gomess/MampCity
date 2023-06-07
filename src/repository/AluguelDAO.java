package repository;

import model.Aluguel;
import java.util.ArrayList;
import java.util.List;

public class AluguelDAO implements IGenericDao<Aluguel> {

    static List<Aluguel> novoAluguel = new ArrayList<>();

    public static void salvarAluguel(Aluguel aluguel) {
        novoAluguel.add(aluguel);
    }

    public static List<Aluguel> buscaTodosAlugueis() {
        return novoAluguel;
    }

    @Override
    public void salvar(Aluguel objeto) {

    }

    @Override
    public void remover(Aluguel objeto) {

    }

    @Override
    public List<Aluguel> buscarTodos() {
        return null;
    }

    @Override
    public List<Aluguel> buscarPorNome(String nome) {
        return null;
    }
}







