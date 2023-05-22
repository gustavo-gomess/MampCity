package repository;

import model.Local;
import java.util.ArrayList;
import java.util.List;

public class LocalDAO {

    static List<Local> novoLocal = new ArrayList<>();

    public static void cadastrarLocal(Local local ) { novoLocal.add(local);

    }
    public static List<Local> buscaTodosLocais() {
        return novoLocal;
    }
}


