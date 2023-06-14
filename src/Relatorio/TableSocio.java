package Relatorio;

import model.Pessoa;
import model.Socio;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class TableSocio extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    public static final int INDEX_NOME = 0;
    public static final int INDEX_EMAIL = 1;
    public static final int INDEX_CPF = 2;
    public static final int INDEX_TELEFONE = 3;
    public static final int INDEX_CARTERINHA = 4;
    public static final int INDEX_STATUS = 5;
    public static final int INDEX_TIPO = 6;
    public static final int INDEX_ESCONDIDO = 6;
    protected String[] nomeColunas;
    protected Vector<Socio> vetorDados;

    public TableSocio(String[] columnNames, Vector<Socio> vetorDados) {
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
        Socio registroSocio = (Socio) vetorDados.get(linha);
        switch (coluna) {
            case INDEX_NOME:
                return registroSocio.getNomeCompleto();
            case INDEX_EMAIL:
                return registroSocio.getEmail();
            case INDEX_CPF:
                return registroSocio.getCpf();
            case INDEX_TELEFONE:
                return registroSocio.getTelefone();
            case INDEX_CARTERINHA:
                return registroSocio.getCarterinha();
            case INDEX_STATUS:
                return registroSocio.getEnumStatusSocio();
            case INDEX_TIPO:
                return registroSocio.getEnumTipoSocio();
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
