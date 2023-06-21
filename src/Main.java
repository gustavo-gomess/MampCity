import model.*;
import repository.AluguelDAO;
import repository.InventarioDAO;
import repository.LocalDAO;
import repository.SocioDAO;


import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        Socio socio;
        switch (menuCadastroSocio) {
            case 0: // Cadastrar Sócio
                cadastroSocio();
                break;
            case 1: // Altera Sócio
                socio = selecaoDeSocio();
                alteraSocio(socio);
                break;
            case 2:// Excluir Socio
                excluirSocio();
                break;
            case 3:
                chamaMenuPrincipal();
        }
        chamaMenuPrincipal();
    }

    private static Socio cadastroSocio() {
        try {
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


            Socio socio = new Socio(carteirinha, (StatusSocio) selecionaStatusSocio[statusSocioIndex],
                    (TipoSocio) selecionaTipoSocio[tipoSocioIndex], nome, cpf, email, telefone);
                JOptionPane.showMessageDialog(null, "CADASTRO EFETUADO COM SUCESSO");

            getSocioDAO().salvar(socio);

        } catch (Exception e) {
            chamaMenuSocio();
        }
        chamaMenuSocio();
        return null;
    }

    private static Socio selecaoDeSocio() {
        Object[] selectionValues = getSocioDAO().findSocioInArray();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o socio?",
                "MampAPP", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Socio> socios = getSocioDAO().buscarPorNome((String) selection);
        return socios.get(0);
    }



    private static void alteraSocio(Socio carterinhaatual){
        String carterinha = JOptionPane.showInputDialog(null, "Digite o  nome do item: ", carterinhaatual.getCarterinha());

        if (carterinha.equals(carterinha)) {
            String alteraNome = JOptionPane.showInputDialog(null, "Digite o novo nome: ");
            String alteraEmail = JOptionPane.showInputDialog(null, "Digite um novo email : ");
            Integer alteraTelefone = Integer.valueOf(JOptionPane.showInputDialog(null, "Digite o novo telefone"));

            carterinhaatual.setNomeCompleto(alteraNome);
            carterinhaatual.setEmail(alteraEmail);
            carterinhaatual.setTelefone(alteraTelefone);

            getSocioDAO().salvar(carterinhaatual);
        }
        chamaMenuSocio();
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
        Local local;
        switch (menuCadastroLocal) {
            case 0: // Cadastra um novo local
                cadastrarInfra();
                break;
            case 1: // Altera um local cadastrado;
                local = selecaoDeLocal();
                alteraInfra(local);
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


            Local local = new Local (nome,descricao);
            getLocalDAO().salvar(local);


        } catch (Exception e) {
            chamaMenuInfra();
        }
        chamaMenuInfra();
    }

    public static void alteraInfra (Local local){
        String localAltera = JOptionPane.showInputDialog(null, "Digite o  nome do item: ", local.getNome());

        if (local.equals(localAltera)) {
            String alteranome = JOptionPane.showInputDialog(null, "Digite o nome do local: ");
            String alteraDescricao = JOptionPane.showInputDialog(null, "Digite uma descrição: ");

            local.setNome(alteranome);
            local.setDescricacaoLocal(alteraDescricao);


            getLocalDAO().salvar(local);
        }
        chamaMenuInventario();
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
        Inventario inventario;
        switch (menuCadastroInventario) {
            case 0: // Cadastrar novo produto no Inventário
                cadastroInventario();
                break;
            case 1:
                inventario = selecaoDeInventario();
                alteraInventario(inventario);
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

            Inventario inventario = new Inventario(item, descricao, quantidade);
            getInventarioDAO().salvar(inventario);

        } catch (Exception e) {
            chamaMenuInventario();
        }
        chamaMenuInventario();
    }

    private static Inventario selecaoDeInventario() {
        Object[] selectionValues = getInventarioDAO().findInvetarioInArray();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione qual item!",
                "MampAPP", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Inventario> inventarios = getInventarioDAO().buscarPorNome((String) selection);
        return inventarios.get(0);
    }



    public static void alteraInventario(Inventario produto) {
        String item = JOptionPane.showInputDialog(null, "Digite o  nome do item: ", produto.getItem());

        if (produto.equals(item)) {
            String alteraProduto = JOptionPane.showInputDialog(null, "Digite o nome do Item: ");
            String alteraDescricao = JOptionPane.showInputDialog(null, "Digite uma descrição: ");
            Integer alteraQuantidade = Integer.valueOf(JOptionPane.showInputDialog(null, "Digite a quantidade"));

            produto.setItem(alteraProduto);
            produto.setDescricao(alteraDescricao);
            produto.setQuantidade(alteraQuantidade);

            getInventarioDAO().salvar(produto);
        }
        chamaMenuInventario();
    }

    public static void excluirInventario() {
        Inventario inventario = null;
        inventario = selecaoDeInventario();
        if (inventario != null) {
            getInventarioDAO().remover(inventario);
        } else {
            chamaMenuInventario();
        }
    }


    public static void chamaMenuAluguel() {

        String[] opcoesMenuAluguel = {"Cadastrar Aluguel", "Voltar"};
        int menuCadastroAluguel = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Cadastrar",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuAluguel, opcoesMenuAluguel[0]);

        switch (menuCadastroAluguel) {
            case 0: // Cadastrar novo produto no Inventário
                cadastroAluguel();
                break;
            case 1:// Voltar
                chamaMenuPrincipal();
                break;
        }
    }

    private static Aluguel cadastroAluguel() {
        Socio socio = selecaoDeSocio();
        Local local = selecaoDeLocal();

        String descricaoAluguel = JOptionPane.showInputDialog("Digite a descrição do aluguel:");
        String dataInicio = JOptionPane.showInputDialog("Digite a data de início no formato dd/MM/yyyy:");
        String dataFim = JOptionPane.showInputDialog("Digite a data de término no formato dd/MM/yyyy:");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate inicio = LocalDate.parse(dataInicio, formatter);
        LocalDate fim = LocalDate.parse(dataFim, formatter);
        LocalDateTime dataHoraInicio = inicio.atStartOfDay();
        LocalDateTime dataHoraFim = fim.atStartOfDay();

        String numeroVisitantes = JOptionPane.showInputDialog("Digite a quantidade de visitantes:");

        Aluguel aluguel = new Aluguel(socio, local, descricaoAluguel, dataHoraInicio, dataHoraFim, numeroVisitantes);

        JOptionPane.showMessageDialog(null, "Cadastro de Aluguel realizado com sucesso");

        getAluguelDAO().salvar(aluguel);
        return aluguel;
    }


    public static void chamaRelatorioInventario(){

        List<Inventario> inventarios = getInventarioDAO().buscarTodos();
        RelatorioInventarioForm.emitirRelatorio(inventarios);
    }


    public static void chamaRelatorioLocais(){

        List<Local> locals = getLocalDAO().buscarTodos();
        RelatorioLocalForm.emitirRelatorio(locals);

    }

    public static void chamaRelatorioSocios(){

        List<Socio> socios = getSocioDAO().buscarTodos();
        RelatorioSocioForm.emitirRelatorio(socios);

    }

    public static void chamaRelatorioAluguel(){

        List<Aluguel> aluguel = getAluguelDAO().buscarTodos();
        RelatorioAluguelForm.emitirRelatorio(aluguel);
    }


    public static void chamaMenuRelatorios() {

        String[] opcoesMenuRelatorios = {"Relatório de Socios", "Relatório de Locais", "Relatório de Produtos", "Relatório de Alugueis", "Voltar"};
        int menuRelatorios = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Relatórios",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuRelatorios, opcoesMenuRelatorios[0]);

        switch (menuRelatorios) {
            case 0: // Relatórios de Sócios
                chamaRelatorioSocios();
                break;
            case 1: // Relatórios de locais disponíveis
                chamaRelatorioLocais();
                break;
            case 2: // Relatório de produtos inventáriados
               chamaRelatorioInventario();
                break;
            case 3: // Relatório de Alugueis
                chamaRelatorioAluguel();
                break;
            case 4: // Voltar
                chamaMenuPrincipal();
                break;
        }

    }

    public static SocioDAO getSocioDAO() {
        SocioDAO socioDAO = new SocioDAO();
        return socioDAO;
    }

    public static AluguelDAO getAluguelDAO() {
        AluguelDAO aluguelDAO = new AluguelDAO();
        return aluguelDAO;
    }

    public static LocalDAO getLocalDAO() {
        LocalDAO localDAO = new LocalDAO();
        return localDAO;
    }

    public static InventarioDAO getInventarioDAO() {
        InventarioDAO inventarioDAO = new InventarioDAO();
        return inventarioDAO;
    }

}
