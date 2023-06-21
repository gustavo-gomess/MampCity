import Relatorio.TableInventario;
import Relatorio.TableSocio;
import model.Inventario;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Vector;

public class RelatorioInventarioForm extends JPanel {

    private static final long serialVersionID = 1L;

    public static final String[] nomeColunas =
            {"Item", "Descrição", "Quantidade", ""};

    protected JTable table;
    protected JScrollPane scroller;
    protected TableInventario tabela;

    public RelatorioInventarioForm(Vector<Inventario> vetorDados) {iniciarComponentes(vetorDados); }

    public void iniciarComponentes(Vector<Inventario> vetorDados) {
        tabela = new TableInventario(nomeColunas, vetorDados);
        table = new JTable();
        table.setModel(tabela);
        table.setSurrendersFocusOnKeystroke(true);
        scroller = new javax.swing.JScrollPane(table);
        table.setPreferredScrollableViewportSize(new java.awt.Dimension(500, 300));

        TableColumn colunaEscondida = table.getColumnModel().getColumn(TableInventario.INDEX_ESCONDIDO);
        colunaEscondida.setMinWidth(2);
        colunaEscondida.setPreferredWidth(2);
        colunaEscondida.setMaxWidth(2);
        setLayout(new BorderLayout());
        add(scroller, BorderLayout.CENTER);
    }

    public static void emitirRelatorio(List<Inventario> listaInventario) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            JFrame frame = new JFrame("Relatorio");

            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent evt) {
                    frame.setVisible(false);
                    Main.chamaMenuRelatorios();
                }

            });

            Vector<Inventario> vetorDados = new Vector<>();
            for (Inventario inventario : listaInventario) {
                vetorDados.add(inventario);
            }

            frame.getContentPane().add(new RelatorioInventarioForm(vetorDados));
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
