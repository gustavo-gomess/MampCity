package repository;

import model.Pessoa;
import model.Socio;
import java.util.ArrayList;
import java.util.List;

public class SocioDAO implements IGenericDao<Socio> {
    static List<Socio> socios = new ArrayList<>();

    public void init (){
            if (socios.isEmpty()){
                Socio socio1 = new Socio();
                socio1.setNomeCompleto("Luiz");
                socio1.setCpf("212123132");
                socio1.setCarterinha(1);

                Socio socio2 = new Socio();
                socio1.setNomeCompleto("Gustavo");
                socio1.setCpf("3123123123213");
                socio1.setCarterinha(2);

                Socio socio3 = new Socio();
                socio1.setNomeCompleto("Lucas");
                socio1.setCpf("212123132");
                socio1.setCarterinha(3);

                socios.add(socio1);
                socios.add(socio2);
                socios.add(socio3);

            }
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
        init ();
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
}
