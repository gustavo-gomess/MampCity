import model.*;
import repository.AluguelDAO;
import repository.InventarioDAO;
import repository.LocalDAO;
import repository.SocioDAO;


import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        chamaMenuPrincipal();

    }

    private static void chamaMenuPrincipal() {
        String[] opcoesMenuPrincipal = {"Socio", "Infraestrutura", "Inventário", "Aluguel", "Relatório", "Sair"};
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
        String[] opcoesMenuSocio = {"Cadastrar Socio", "Alterar Cadastro", "Exluir Socio", "Voltar"};
        int menuCadastroSocio = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Cadastrar",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuSocio, opcoesMenuSocio[0]);
        Socio socio = null;
        switch (menuCadastroSocio) {
            case 0: // Cadastrar Sócio
                cadastroSocio();
                break;
            case 1: // Altera Sócio
                alteraSocio();
                break;
            case 2:// Excluir Socio
                excluirSocio();
                break;
            case 3:
                chamaMenuPrincipal();
        }
        chamaMenuPrincipal();
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
            Integer telefone = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o telefone do sócio"));
            Integer carteirinha = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da carteirinha do sócio"));
            Object[] selecionaTipoSocio = { TipoSocio.PRINCIPAL, TipoSocio.DEPENDENTE };
            int tipoSocioIndex = JOptionPane.showOptionDialog(null, "Selecione o tipo de sócio", "Tipo de Sócio",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, selecionaTipoSocio, selecionaTipoSocio[0]);
            Object[] selecionaStatusSocio = { StatusSocio.ATIVO, StatusSocio.INATIVO };
            int statusSocioIndex = JOptionPane.showOptionDialog(null, "Selecione o status de sócio", "Status de Sócio",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, selecionaStatusSocio, selecionaStatusSocio[0]);
            SocioDAO socioDAO = new SocioDAO();
            Socio socio = new Socio(carteirinha, (StatusSocio) selecionaStatusSocio[statusSocioIndex],
                    (TipoSocio) selecionaTipoSocio[tipoSocioIndex], nome, cpf, email, telefone);
                JOptionPane.showMessageDialog(null, "CADASTRO EFETUADO COM SUCESSO");
            socioDAO.salvar(socio);

        } catch (Exception e) {
            chamaMenuSocio();
        }
        chamaMenuSocio();
    }

    private static Socio selecaoDeSocio() {
        Object[] selectionValues = getSocioDAO().findSocioInArray();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o socio?",
                "MampAPP", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Socio> socios = getSocioDAO().buscarPorNome((String) selection);
        return socios.get(0);
    }

    public static SocioDAO getSocioDAO() {
        SocioDAO socioDAO = new SocioDAO();
        return socioDAO;
    }


    private static void alteraSocio(){

    }

    private static void excluirSocio() {
        Socio socio = null;
        socio = selecaoDeSocio();
        if (socio != null) {
            getSocioDAO().remover(socio);
        } else {
            chamaMenuSocio();
        }
    }

    private static void chamaMenuInfra() {
        String[] opcoesLocal = {"Cadastrar nova Infraestrutura","Alterar Infraestrutura", "Excluir  Infraestrutura", "Voltar"};
        int menuCadastroLocal = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Cadastrar",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesLocal, opcoesLocal[0]);

        switch (menuCadastroLocal) {
            case 0: // Cadastra um novo local
                cadastrarInfra();
                break;
            case 1: // Altera um local cadastrado;
                alteraInfra();
                break;
            case 2:// Excluir um local cadastrado
                excluirInfra();
                break;
            case 3:
                chamaMenuPrincipal();
        }
        chamaMenuPrincipal();
    }

    public static void cadastrarInfra() {
        try {
            String nome = JOptionPane.showInputDialog(null, "Digite o nome da nova Infraestrutura!");
            String descricao = JOptionPane.showInputDialog(null, "Digite a descrição da Infraestrutura!");

            LocalDAO localDAO = new LocalDAO();
            Local local = new Local (nome,descricao);
            localDAO.salvar(local);
            System.out.println(local);

        } catch (Exception e) {
            chamaMenuInfra();
        }
        chamaMenuInfra();
    }
    public static LocalDAO getLocalDAO() {
        LocalDAO localDAO = new LocalDAO();
        return localDAO;
    }

    public static void alteraInfra (){

    }

    public static void excluirInfra() {
        Local local = null;
        local = selecaoDeLocal();
        if (local != null) {
            getLocalDAO().remover(local);
        } else {
            chamaMenuInfra();
        }
    }

    private static Local selecaoDeLocal() {
        Object[] selectionValues = getLocalDAO().findLocalInArray();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione qual local!",
                "MampAPP", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Local> locals = getLocalDAO().buscarPorNome((String) selection);
        return locals.get(0);
    }

    public static void chamaMenuInventario() {
        String[] opcoesMenuInventario = {"Cadastrar Produto", "Alterar Itens", "Excluir Produto", "Voltar"};
        int menuCadastroInventario = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Cadastrar",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuInventario, opcoesMenuInventario[0]);

        switch (menuCadastroInventario) {
            case 0: // Cadastrar novo produto no Inventário
                cadastroInventario();
                break;
            case 1:
                alteraInventario();
                break;
            case 2: // Excluir um produto do Inventário
                excluirInventario();
                break;
            case 3:// Voltar
                chamaMenuPrincipal();
                break;
        }

    }

    private static void cadastroInventario() {
        try {
            String item = JOptionPane.showInputDialog(null, "Digite o nome do Item: ");
            String descricao = JOptionPane.showInputDialog(null, "Digite uma descrição: ");
            Integer quantidade = Integer.valueOf(JOptionPane.showInputDialog(null, "Digite a quantidade"));

            InventarioDAO inventarioDAO = new InventarioDAO();
            Inventario inventario = new Inventario(item, descricao, quantidade);
            inventarioDAO.salvar(inventario);
            System.out.println(inventario);

        } catch (Exception e) {
            chamaMenuInventario();
        }
        chamaMenuInventario();
    }
    public static InventarioDAO getInventarioDAO() {
        InventarioDAO inventarioDAO = new InventarioDAO();
        return inventarioDAO;
    }
    public static void alteraInventario(Inventario produto) {
        String item = JOptionPane.showInputDialog(null, "Digite o  nome do item: ", produto.getItem());

        if (produto.equals(item)) {
            String alteraProduto = JOptionPane.showInputDialog(null, "Digite o nome do Item: ");
            String alteraDescricao = JOptionPane.showInputDialog(null, "Digite uma descrição: ");
            Integer alteraQuantidade = Integer.valueOf(JOptionPane.showInputDialog(null, "Digite a quantidade"));

            Inventario inventario = new Inventario();
            // falta finallizar essa parte, pois não salva

            produto.setItem(alteraProduto);
            produto.setDescricao(alteraDescricao);
            produto.setQuantidade(alteraQuantidade);


            // talvez crie um new

            getInventarioDAO().salvar(produto);

        }

    }

    public static void excluirInventario() {
    }


    public static void chamaMenuAluguel() {

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

    private static void cadastroAluguel() {
    }

    public static void listarAlugueis() {

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
