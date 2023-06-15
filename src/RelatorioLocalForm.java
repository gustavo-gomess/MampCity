import Relatorio.TableLocal;
import model.Local;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Vector;

public class RelatorioLocalForm extends JPanel {

    private static final long serialVersionUID = 1L;

    public static final String[] nomeColunas =
            {"Nome", "Descrição", ""};

    protected JTable table;
    protected JScrollPane scroller;
    protected TableLocal tabela;

    public RelatorioLocalForm(Vector<Local> vetorDados) {
        iniciarComponentes(vetorDados);
    }

    public void iniciarComponentes(Vector<Local> vetorDados) {
        tabela = new TableLocal(nomeColunas, vetorDados);
        table = new JTable();
        table.setModel(tabela);
        table.setSurrendersFocusOnKeystroke(true);
        scroller = new javax.swing.JScrollPane(table);
        table.setPreferredScrollableViewportSize(new java.awt.Dimension(500, 300));

        TableColumn colunaEscondida = table.getColumnModel().getColumn(TableLocal.INDEX_ESCONDIDO);
        colunaEscondida.setMinWidth(2);
        colunaEscondida.setPreferredWidth(2);
        colunaEscondida.setMaxWidth(2);
        setLayout(new BorderLayout());
        add(scroller, BorderLayout.CENTER);

    }

    public static void emitirRelatorio(List<Local> local) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            JFrame frame = new JFrame("Relatorio");

            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent evt) {
                    frame.setVisible(false);
                    Main.chamaMenuRelatorios();
                }
            });

            Vector<Local> vetorDados = new Vector<Local>();
            for (Local local1 : local) {
                vetorDados.add(local1);
            }

            frame.getContentPane().add(new RelatorioLocalForm(vetorDados));
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

