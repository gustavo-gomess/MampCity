package repository;

import model.Socio;
import java.util.ArrayList;
import java.util.List;

public class SocioDAO implements IGenericDao<Socio> {
    static List<Socio> socios = new ArrayList<>();
    public static List<Socio> buscaTodos() {
        return socios;
    }

    @Override
    public void salvar(Socio objeto) {

    }

    @Override
    public void remover(Socio objeto) {

    }

    @Override
    public List<Socio> buscarTodos() {
        return null;
    }

    @Override
    public List<Socio> buscarPorNome(String nome) {
        return null;
    }
}
