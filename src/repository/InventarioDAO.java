package repository;

import model.Inventario;
import java.util.List;
import java.util.ArrayList;


public class InventarioDAO {


    static List<Inventario> novoItem = new ArrayList<>();

    public static void cadastraItem (Inventario inventario) { novoItem.add(inventario);}

    public static List<Inventario> buscaInventario () {
        return novoItem;
    }


}
