import model.Socio;
import model.EnumStatusSocio;
import model.TipoSocio;
import model.Inventario;
import model.Aluguel;
import repository.AluguelDAO;
import repository.InventarioDAO;
import repository.LocalDAO;
import repository.SocioDAO;


import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;


public class Main {
    public static void main(String[] args) {
        chamaMenuPrincipal();

    }
        private static void chamaMenuPrincipal() {
            String[] opcoesMenuPrincipal = {"Socio","Infraestrutura", "Inventário", "Aluguel", "Relatório", "Sair"};
            int opcaoMenuPrincipal = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                    "Menu Principal",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuPrincipal, opcoesMenuPrincipal[0]);
            switch (opcaoMenuPrincipal) {
                case 0: //Chama o menu do Socio
                    chamaMenuSocio();
                    break;
                case 1: //Chama o menu de InfraEstrutura
                    chamaMenuInfra();
                    break;
                case 2: //Chama o menu do Inventario
                    chamaMenuInventario();
                    break;
                case 3://Chama o menu dos Alugueis
                    chamaMenuAluguel();
                    break;
                case 4://Chama o menu relatórios
                    chamaMenuRelatorios();
                    break;
                case 5:

                    break;
            }
        }


    private static void chamaMenuSocio() {
        String[] opcoesMenuSocio = {"Cadastrar Socio", "Exluir Socio", "Voltar"};
        int menuCadastroSocio = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Cadastrar",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuSocio, opcoesMenuSocio[0]);

        switch (menuCadastroSocio) {
            case 0: // Cadastrar Socio
                cadastroSocio();
                break;
            case 1: // Excluir Socio
                excluirSocio();
                break;
            case 2:
                chamaMenuPrincipal();
                break;
        }

    }

    private static void cadastroSocio() {
        try {
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
            Object[] selecionaTipoSocio = {
                    TipoSocio.PRINCIPAL,
                    TipoSocio.DEPENDENTE};
            Object[] selecionaStatusSocio = {
                    EnumStatusSocio.ATIVO,
                    EnumStatusSocio.INATIVO};

        }catch (Exception e){
            chamaMenuSocio();
        }
    }

    private static void excluirSocio (){

    }

    private static void chamaMenuInfra () {
        String[] opcoesLocal = {"Cadastrar Local", "Listar Locais", "Voltar"};
        int menuCadastroLocal = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Cadastrar",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesLocal, opcoesLocal[0]);

        switch (menuCadastroLocal) {
            case 0: // Cadastra um novo local
                cadastrarLocal();
                break;
            case 1: // Lista os locais cadastrados
                listarLocais();
                break;
            case 2:
                chamaMenuPrincipal();
                break;
        }

    }

    public static void cadastrarLocal (){

    }

    public static void listarLocais (){

    }

    public static void chamaMenuInventario() {

        String[] opcoesMenuInventario = {"Cadastrar Produto", "Excluir Produto", "Voltar"};
        int menuCadastroInventario = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Cadastrar",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuInventario, opcoesMenuInventario[0]);

        switch (menuCadastroInventario) {
            case 0: // Cadastrar novo produto no Inventário
                cadastroInventario();
                break;
            case 1: // Excluir um produto do Inventário
                excluirInventario();
                break;
            case 2:// Voltar
                chamaMenuPrincipal();
                break;
        }

    }
    private static void cadastroInventario(){}

    public static void excluirInventario(){}


    public static void chamaMenuAluguel(){

        String[] opcoesMenuAluguel = {"Cadastrar Aluguel", "Listar Alugueis", "Voltar"};
        int menuCadastroAluguel = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Cadastrar",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuAluguel, opcoesMenuAluguel[0]);

        switch (menuCadastroAluguel) {
            case 0: // Cadastrar novo produto no Inventário
                cadastroAluguel();
                break;
            case 1: // Lista os alugueis no momento
                listarAlugueis();
                break;
            case 2:// Voltar
                chamaMenuPrincipal();
                break;
        }
    }
    private static void cadastroAluguel (){
    }

    public static void listarAlugueis(){

    }
    private static void chamaMenuRelatorios() {

        String[] opcoesMenuRelatorios = {"Relatório de Socios", "Relatório de Locais", "Relatório de Produtos", "Relatório de Alugueis", "Voltar"};
        int menuCadastroInventario = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Cadastrar",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuRelatorios, opcoesMenuRelatorios[0]);

        switch (menuCadastroInventario) {
            case 0: // Relatórios de Sócios
                SocioDAO.buscaTodos();
                break;
            case 1: // Relatórios de locais disponíveis
                LocalDAO.buscaTodosLocais();
                break;
            case 2: // Relatório de produtos inventáriados
                InventarioDAO.buscaInventario();
                break;
            case 3: // Relatório de Alugueis
                AluguelDAO.buscaTodosAlugueis();
                break;
            case 4: // Voltar
                chamaMenuPrincipal();
                break;
        }

    }

}
