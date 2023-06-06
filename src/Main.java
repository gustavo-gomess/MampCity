import model.Socio;
import model.EnumStatusSocio;
import model.*;
import repository.SocioDAO;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //AluguelDAO.salvarAluguel();
        //InventarioDAO.cadastraItem();
        //SocioDAO.salvar();
        chamaMenuPrincipal();
    }
        private static void chamaMenuPrincipal() {
            String[] opcoesMenuPrincipal = {"Socio","Infraestrutura", "Inventário", "Aluguel", "Relatório", "Sair"};
            int opcaoMenuPrincipal = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                    "Menu Principal",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuPrincipal, opcoesMenuPrincipal[0]);
            switch (opcaoMenuPrincipal) {
                case 0: //Socio
                    chamaMenuSocio();
                    break;
                case 1: //Local
                    chamaMenuEstoque();
                    break;
                case 2: //Inventario
                    //chamaMenuCadastroCompra();
                    break;
                case 3:// Aluguel
                    //();
                    break;
                case 4:;
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
        String[] opcoesMenuSocio = {"Cadastrar Socio", "Exluir Socio", "Relatorio", "Voltar"};
        int menuCadastroSocio = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Cadastrar",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuSocio, opcoesMenuSocio[0]);

        switch (menuCadastroSocio) {
            case 0: //Cadastrar Socio
                cadastroSocio();
                break;
            case 1: // ExcluirSocio
                //excluirSocio();
                break;
            case 2: //geraRelatorioSocios
                // getRelatorioSocios;
                break;
            case 3:
                chamaMenuPrincipal();
                break;
        }

    }

    private static void cadastroSocio(){
        LocalDate dataPlanejamento = LocalDate.now();
        String inputData = JOptionPane.showInputDialog(null, "Digite uma data (formato: dd/MM/yyyy):",
                "Cadastrar socio", JOptionPane.DEFAULT_OPTION);
        try {
            dataPlanejamento = LocalDate.parse(inputData, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Formato inválido!",
                    "Cadastrar Planejamento", JOptionPane.ERROR_MESSAGE);
            chamaMenuSocio();
        }
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do sócio");
        String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do sócio");
        String email = JOptionPane.showInputDialog(null, "Digite o email do sócio");
        String telefone = JOptionPane.showInputDialog(null, "Digite o telefone do sócio");
        Integer carteirinha = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da carteirinha do sócio"));


        /* Object[] selecionaStatus = {
                Quarto.TipoQuarto.ATIVO(),
                Quarto.TipoQuarto.MASTER_VIP(),
                Quarto.TipoQuarto.VIP(),
                Quarto.TipoQuarto.STAR_VIP.getDescricao(),
                Quarto.TipoQuarto.BLACK_VIP.getDescricao(),
        };

        String initialSelectionQuarto = (String) selectionQuarto[0];
        Object selecQuarto = JOptionPane.showInputDialog(null, "Selecione o quarto escolhido",
                "Quartos", JOptionPane.QUESTION_MESSAGE, null, selectionQuarto, initialSelectionQuarto);*/

        String enumTipoSocio = JOptionPane.showInputDialog(null, "Digite o tipo de sócio do sócio");
        Socio socio = new Socio(carteirinha, enumStatusSocio, enumTipoSocio,null, null, nome, cpf, email, telefone);
        SocioDAO.salvar(socio);

    }

    private static void excluiSocio (){

    }

    private static void chamaMenuEstoque (){
        String[] opcoesEstoque = {"Cadastrar Estoque", "Listar Estoques", "Voltar"};
        int menuCadastroEstoque = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Cadastrar",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesEstoque, opcoesEstoque[0]);

        switch (menuCadastroEstoque){
            case 1:
                //adicionaEstoque;
                break;
            case 2:
                //listaEstoque;
                break;
            case 3:
                chamaMenuPrincipal();
                break;
        }


    }
}