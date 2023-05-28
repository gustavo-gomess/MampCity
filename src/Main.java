import repository.AluguelDAO;
import repository.InventarioDAO;
import repository.SocioDAO;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String[] args) {
        //AluguelDAO.salvarAluguel();
        //InventarioDAO.cadastraItem();
        //SocioDAO.salvar();
        chamaMenuPrincipal();
    }

        private static void chamaMenuPrincipal() {
            String[] opcoesMenuPrincipal = {"Socio","Local", "Inventario", "Aluguel", "Relatorio", "Sair"};
            int opcaoMenuPrincipal = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                    "Menu Principal",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuPrincipal, opcoesMenuPrincipal[0]);
            switch (opcaoMenuPrincipal) {
                case 0: //Socio
                    chamaMenuSocio();
                    break;
                case 1: //Local
                   // chamaMenuEstoque();
                    break;
                case 2: //Inventario
                    //chamaMenuCadastroCompra();
                    break;
                case 3:// Aluguel
                    //chamaMenuCadastroReceitas();
                    break;
                case 4:// Cardapio
                    // chamaMenuCardapio();
                    break;
                case 5:// Relatorio
                    // chamaMenuVenda();
                    break;
                case 6:// Sair
                    //chamaMenuRelatorios();
                    break;
            }
        }

    private static void chamaMenuSocio() {
        String[] opcoesMenuSocio = {"Cadastrar Socio", "Exluir Socio", "relatorio"};
        int menuCadastroSocio = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Cadastrar",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuSocio, opcoesMenuSocio[0]);

        switch (menuCadastroSocio) {
            case 0: //Cadastrar Socio
                cadastroSocio();
                break;
            case 1: // exemplo
                // planeja()
                break;
            case 2: //menuPrincipal
                chamaMenuPrincipal();
                break;
        }

    }

    private static void cadastroSocio(){
        LocalDate dataPlanejamento = LocalDate.now();
        String inputData = JOptionPane.showInputDialog(null, "Digite uma data (formato: dd/MM/yyyy):",
                "Cadastrar Planejamento", JOptionPane.DEFAULT_OPTION);
        try {
            dataPlanejamento = LocalDate.parse(inputData, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Formato inválido!",
                    "Cadastrar Planejamento", JOptionPane.ERROR_MESSAGE);
            chamaMenuSocio();
        }


    }
}