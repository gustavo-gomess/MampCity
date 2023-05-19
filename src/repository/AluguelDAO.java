package repository;

import model.Aluguel;
import java.util.ArrayList;
import java.util.List;

public class AluguelDAO {

    static List<Aluguel> novoAluguel = new ArrayList<>();

    public static void salvarAluguel(Aluguel aluguel) {
        novoAluguel.add(aluguel);
    }

    public static List<Aluguel> buscaTodosAlugueis() {
        return novoAluguel;
    }
}







