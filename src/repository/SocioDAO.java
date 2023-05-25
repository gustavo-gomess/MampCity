package repository;

import model.Socio;
import java.util.ArrayList;
import java.util.List;

public class SocioDAO {
    static List<Socio> socios = new ArrayList<>();


    public SocioDAO(){

    }


    public static void salvar(Socio socio) {
        socios.add(socio);
    }

    public static List<Socio> buscaTodos() {
        return socios;
    }
}
