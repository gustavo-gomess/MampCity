package Relatorio;

import model.Local;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class TableLocal extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    public static final int INDEX_NOME = 0;
    public static final int INDEX_DESCRICAO = 1;
    public static final int INDEX_ESCONDIDO = 2;


    protected String[] nomeColunas;
    protected Vector<Local> vetorDados;

    public TableLocal (String[] columnNames,
                       Vector<Local> vetorDados) {
        this.nomeColunas = columnNames;
        this.vetorDados = vetorDados;
    }

    @Override
    public String getColumnName(int column) {
        return nomeColunas[column];
    }

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
        Local registroLocal = (Local) vetorDados.get(linha);
        switch (coluna) {
            case INDEX_NOME:
                return registroLocal.getNome();
            case INDEX_DESCRICAO:
                return registroLocal.getDescricacaoLocal();
            default:
                return new Object();
        }
    }

    @Override
    public int getRowCount() {
        return vetorDados.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }
}
