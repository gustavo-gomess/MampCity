package Relatorio;

import model.Inventario;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;
public class TableInventario extends AbstractTableModel{

    private static final long serialVersionUID = 1L;

    public static final int INDEX_ITEM = 0;
    public static final int INDEX_DESCRICAO = 1;
    public static final int INDEX_QUANTIDADE = 2;

    public static final int INDEX_ESCONDIDO = 3;

    protected String[] nomeColunas;

    protected Vector<Inventario> vetorDados;

    public TableInventario(String[] columnNames,
                           Vector<Inventario> vetorDados) {
        this.nomeColunas = columnNames;
        this.vetorDados = vetorDados;
    }

    @Override
    public String getColumnName(int column) { return nomeColunas[column]; }

    @Override
    public boolean isCellEditable(int linha, int coluna) {
        if (coluna == INDEX_ESCONDIDO) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Inventario registroInventario = (Inventario) vetorDados.get(linha);
        switch (coluna) {
            case INDEX_ITEM:
                return registroInventario.getItem();
            case INDEX_DESCRICAO:
                return registroInventario.getDescricao();
            case INDEX_QUANTIDADE:
                return registroInventario.getQuantidade();
            default:
                return new Object();
        }
    }

    @Override
    public int getRowCount() { return vetorDados.size(); }

    @Override
    public int getColumnCount() { return nomeColunas.length; }

} // fim classe

