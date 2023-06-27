package Relatorio;

import model.Aluguel;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class TableAluguel extends AbstractTableModel  {

    private static final long serialVersionUID = 1L;

    public static final int INDEX_SOCIO = 0;
    public static final int INDEX_LOCAL = 1;
    public static final int INDEX_DESCRICAOALUGUEL = 2;
    public static final int INDEX_DATAHORAINICIO = 3;
    public static final int INDEX_DATAHORAFIM = 4;
    public static final int INDEX_NUMERODEVISITANTES = 5;
    public static final int INDEX_ESCONDIDO = 6;
    protected String[] nomeColunas;
    protected Vector<Aluguel> vetorDados;

    public TableAluguel(String[] columnNames,
                        Vector<Aluguel> vetorDados) {
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
        Aluguel registroAluguel = vetorDados.get(linha);
        switch (coluna) {
            case INDEX_SOCIO:
                return registroAluguel.getSocio().getNomeCompleto();
            case INDEX_LOCAL:
                return registroAluguel.getLocal().getNome();
            case INDEX_DESCRICAOALUGUEL:
                return registroAluguel.getDescricao();
            case INDEX_DATAHORAINICIO:
                return registroAluguel.getDataHoraInicio();
            case INDEX_DATAHORAFIM:
                return registroAluguel.getDataHoraFim();
            case INDEX_NUMERODEVISITANTES:
                return registroAluguel.getNumeroVisitantes();
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