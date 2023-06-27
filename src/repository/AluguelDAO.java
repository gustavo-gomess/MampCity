package repository;

import model.Aluguel;

import java.util.ArrayList;
import java.util.List;

public class AluguelDAO implements IGenericDao<Aluguel> {

    static List<Aluguel> novoAluguel = new ArrayList<>();

    @Override
    public void salvar(Aluguel aluguel) {
        if (aluguel.getId() == null) {
            aluguel.setId((long) (novoAluguel.size() + 1));
        } else {
            novoAluguel.remove((int) (aluguel.getId() - 1));
        }
        novoAluguel.add(aluguel);
    }

    @Override
    public void remover(Aluguel aluguel) {
        if (aluguel.getId() != null) {
            novoAluguel.remove((int) (aluguel.getId() - 1));
        }
    }

    @Override
    public List<Aluguel> buscarTodos() {
        System.out.println(novoAluguel);
        return novoAluguel;
    }

    @Override
    public List<Aluguel> buscarPorNome(String nome_local) {
        List<Aluguel> busca_aluguel = new ArrayList<>();
        for (Aluguel aluguel : novoAluguel) {
            if (aluguel.getLocal().getDescricacaoLocal().contains(nome_local)) {
                busca_aluguel.add(aluguel);
            }
        }
        return busca_aluguel;

    }

}







