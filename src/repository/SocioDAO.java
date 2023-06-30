package repository;

import model.Aluguel;
import model.Pessoa;
import model.Socio;

import java.util.ArrayList;
import java.util.List;

public class SocioDAO implements IGenericDao<Socio> {
    static List<Socio> socios = new ArrayList<>();

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

    public Object[] findSocioInArray() {
        List<Socio> socios = buscarTodos();
        List<String> sociosNomes = new ArrayList<>();
        for (Socio socio : socios) {
            sociosNomes.add(socio.getNomeCompleto());
        }

        return sociosNomes.toArray();
    }
        public boolean existeCarteirinha(int numeroCarteirinha) {
            for (Socio socio : socios) {
                if (socio.getCarterinha() == numeroCarteirinha) {
                    return true;
                }
            }
            return false;
        }
    }




