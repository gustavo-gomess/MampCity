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
    public void salvar(Socio socio) {
        if (socio.getId() == null) {
            socio.setId((long) (socios.size() + 1));
        } else {
            socios.remove((int) (socio.getId() - 1));
        }
        socios.add(socio);
    }

    @Override
    public void remover(Socio socio) {
        if (socio.getId() != null) {
            socios.remove((int) (socio.getId() - 1));
        }
    }

    @Override
    public List<Socio> buscarTodos() {
        System.out.println(socios);
        return socios;
    }

    @Override
    public List<Socio> buscarPorNome(String nome) {
        List<Socio> sociosfiltrados = new ArrayList<>();
        for (Socio socio : socios) {
            if (socio.getNomeCompleto().contains(nome)) {
                sociosfiltrados.add(socio);
            }
        }
        return sociosfiltrados;
    }
}
