import model.*;
import repository.*;


import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.lang.System.exit;
import static model.StatusSocio.INATIVO;


public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Object usuarioLogado = chamaSelecaoUsuario();
        checaSenhaUsuario(usuarioLogado);
    }


    public static void chamaMenuPrincipal() {
        String[] opcoesMenuPrincipal = {"Sócio", "Infraestrutura", "Inventário", "Aluguel", "Relatório", "Sair"};
        int opcaoMenuPrincipal = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu Principal",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuPrincipal, opcoesMenuPrincipal[0]);
        switch (opcaoMenuPrincipal) {
            case 0: //Chama o menu do Sócio
                chamaMenuSocio();
                break;
            case 1: //Chama o menu de InfraEstrutura
                chamaMenuInfra();
                break;
            case 2: //Chama o menu do Inventário
                chamaMenuInventario();
                break;
            case 3://Chama o menu dos Alugueis
                chamaMenuAluguel();
                break;
            case 4://Chama o menu relatórios
                chamaMenuRelatorios();
                break;
            case 5:
                exit(0);
                break;
        }
    }


    public static void chamaMenuSocio() {
        String[] opcoesMenuSocio = {"Cadastrar Sócio", "Alterar Cadastro", "Exluir Sócio", "Voltar"};
        int menuCadastroSocio = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Cadastrar",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuSocio, opcoesMenuSocio[0]);
        Socio socio;
        switch (menuCadastroSocio) {
            case 0: // Cadastrar Sócio
                cadastroSocio();
                break;
            case 1: // Altera Sócio
                alteraSocio();
                break;
            case 2:// Excluir Sócio
                excluirSocio();
                break;
            case 3:
                chamaMenuPrincipal();
        }
        chamaMenuPrincipal();
    }

    public static Socio cadastroSocio() {
        try {
            String nome = JOptionPane.showInputDialog(null, "Digite o nome do sócio");
            if (nome == null || nome.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nome inválido. Por favor, insira um nome válido.");
                return null;
            }

            String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do sócio");
            if (cpf == null || cpf.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "CPF inválido. Por favor, insira um CPF válido.");
                return null;
            }

            String email = JOptionPane.showInputDialog(null, "Digite o email do sócio");
            if (email == null || email.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Email inválido. Por favor, insira um email válido.");
                return null;
            }

            Integer telefone;
            try {
                String telefoneInput = JOptionPane.showInputDialog(null, "Digite o telefone do sócio");
                telefone = Integer.parseInt(telefoneInput);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Telefone inválido. Por favor, insira um telefone válido.");
                return null;
            }

            Integer carteirinha;
            try {
                String carteirinhaInput = JOptionPane.showInputDialog(null, "Digite o número da carteirinha do sócio");
                carteirinha = Integer.parseInt(carteirinhaInput);

                if (getSocioDAO().existeCarteirinha(carteirinha)) {
                    JOptionPane.showMessageDialog(null, "Número da carteirinha já existe. Por favor, insira outro número.");
                    return null;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Número da carteirinha inválido. Por favor, insira um número válido.");
                return null;
            }

            Object[] selecionaTipoSocio = {TipoSocio.PRINCIPAL, TipoSocio.DEPENDENTE};
            int tipoSocioIndex = JOptionPane.showOptionDialog(null, "Selecione o tipo de sócio", "Tipo de Sócio",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, selecionaTipoSocio, selecionaTipoSocio[0]);

            Object[] selecionaStatusSocio = {StatusSocio.ATIVO, StatusSocio.INATIVO};
            int statusSocioIndex = JOptionPane.showOptionDialog(null, "Selecione o status de sócio", "Status de Sócio",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, selecionaStatusSocio, selecionaStatusSocio[0]);


            Socio socio = new Socio(carteirinha, StatusSocio.ATIVO,
                    (TipoSocio) selecionaTipoSocio[tipoSocioIndex], nome, cpf, email, telefone);
            JOptionPane.showMessageDialog(null, "CADASTRO EFETUADO COM SUCESSO");

            getSocioDAO().salvar(socio);

        } catch (Exception e) {
            chamaMenuSocio();
        }
        chamaMenuSocio();
        return null;
    }

    public static Socio selecaoDeSocio() {
        Object[] selectionValues = getSocioDAO().findSocioInArray();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o sócio: ",
                "MampAPP", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Socio> socios = getSocioDAO().buscarPorNome((String) selection);
        return socios.get(0);
    }


    public static void alteraSocio(Socio socioAtual) {
        String novaCarterinha = JOptionPane.showInputDialog(null, "Digite o  nome do item: ", socioAtual.getCarterinha());

        if (novaCarterinha.equals(socioAtual.getCarterinha())) {
            String alteraNome = JOptionPane.showInputDialog(null, "Digite o novo nome: ");
            String alteraEmail = JOptionPane.showInputDialog(null, "Digite um novo email : ");
            Integer alteraTelefone = Integer.valueOf(JOptionPane.showInputDialog(null, "Digite o novo telefone"));

            socioAtual.setNomeCompleto(alteraNome);
            socioAtual.setEmail(alteraEmail);
            socioAtual.setTelefone(alteraTelefone);

            getSocioDAO().salvar(socioAtual);
        } else {
            JOptionPane.showMessageDialog(null, "O número da carteirinha não pode ser alterado.");
        }
        chamaMenuSocio();
    }

    public static void excluirSocio() {
        Socio socioSelecionado = selecaoDeSocio();
        if (socioSelecionado != null) {
            getSocioDAO().remover(socioSelecionado);
            JOptionPane.showMessageDialog(null, "Sócio excluído com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Operação de exclusão cancelada ou nenhum sócio selecionado.");
        }
        chamaMenuSocio();
    }

    public static void chamaMenuInfra() {
        String[] opcoesLocal = {"Cadastrar nova Infraestrutura", "Alterar Infraestrutura", "Excluir  Infraestrutura", "Voltar"};
        int menuCadastroLocal = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Cadastrar",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesLocal, opcoesLocal[0]);
        Local local;
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
            if (nome == null || nome.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nome inválido. Por favor, insira um nome válido.");
                return;
            }
          
            String descricao = JOptionPane.showInputDialog(null, "Digite a descrição da Infraestrutura!");
            if (descricao == null || descricao.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Descrição inválida. Por favor, insira uma descrição válida.");
                return;
            }

            Local localExistente = getLocalDAO().buscarPorNome(nome).stream().findFirst().orElse(null);
            if (localExistente != null) {
                JOptionPane.showMessageDialog(null, "Já existe uma infraestrutura com o mesmo nome. Por favor, escolha outro nome.");
                return;
            }

            Local local = new Local(nome, descricao);

            getLocalDAO().salvar(local);
            JOptionPane.showMessageDialog(null, "Cadastro de Infraestrutura realizado com sucesso!");

        } catch (Exception e) {
            chamaMenuInfra();
        }
        chamaMenuInfra();
    }


    public static void alteraInfra(Local local) {
        String localAltera = JOptionPane.showInputDialog(null, "Digite o nome do item: ", local.getNome());

        if (local.equals(localAltera)) {
          
            String alteranome = JOptionPane.showInputDialog(null, "Digite o nome do local: ");
            String alteraDescricao = JOptionPane.showInputDialog(null, "Digite uma descrição: ");

            local.setNome(alteranome);
            local.setDescricacaoLocal(alteraDescricao);

            getLocalDAO().salvar(local);
        }
        chamaMenuInfra();
    }

    public static void excluirInfra() {
        Local localSelecionado = selecaoDeLocal();

        if (localSelecionado != null) {
            getLocalDAO().remover(localSelecionado);
            JOptionPane.showMessageDialog(null, "Infraestrutura excluída com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma infraestrutura selecionada. Operação de exclusão cancelada.");
        }

        chamaMenuInfra();
    }

    public static Local selecaoDeLocal() {
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
        chamaMenuPrincipal();
    }

    public static void cadastroInventario() {
        try {
            String item = JOptionPane.showInputDialog(null, "Digite o nome do Item: ");
            if (item == null || item.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nome do item inválido. Por favor, insira um nome válido.");
                return;
            }

            String descricao = JOptionPane.showInputDialog(null, "Digite uma descrição: ");
            if (descricao == null || descricao.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Descrição inválida. Por favor, insira uma descrição válida.");
                return;
            }

            Integer quantidade = Integer.valueOf(JOptionPane.showInputDialog(null, "Digite a quantidade"));
            if (quantidade == null) {
                JOptionPane.showMessageDialog(null, "Quantidade inválida. Por favor, insira um valor numérico válido.");
                return;
            }

            Inventario inventario = new Inventario(item, descricao, quantidade);
            JOptionPane.showMessageDialog(null, "CADASTRO EFETUADO COM SUCESSO");
            getInventarioDAO().salvar(inventario);
            JOptionPane.showMessageDialog(null, "Cadastro de inventário realizado com sucesso!");


        } catch (Exception e) {
            chamaMenuInventario();
        }
        chamaMenuInventario();
    }

    public static Inventario selecaoDeInventario() {
        Object[] selectionValues = getInventarioDAO().findInvetarioInArray();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione qual item!",
                "MampAPP", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Inventario> inventarios = getInventarioDAO().buscarPorNome((String) selection);
        return inventarios.get(0);
    }

    public static void alteraInventario(Inventario produtoAtual) {
        if (produtoAtual.equals(produtoAtual)) {
            String alteraProduto = JOptionPane.showInputDialog(null, "Digite o nome do Item: ");
            String alteraDescricao = JOptionPane.showInputDialog(null, "Digite uma descrição: ");
            Integer alteraQuantidade = Integer.valueOf(JOptionPane.showInputDialog(null, "Digite a quantidade"));

            produtoAtual.setItem(alteraProduto);
            produtoAtual.setDescricaoInv(alteraDescricao);
            produtoAtual.setQuantidade(alteraQuantidade);

            getInventarioDAO().salvar(produtoAtual);
        }
        chamaMenuInventario();
    }

    public static void excluirInventario() {
        Inventario inventarioSelecionado = selecaoDeInventario();

        if (inventarioSelecionado != null) {
            getInventarioDAO().remover(inventarioSelecionado);
            JOptionPane.showMessageDialog(null, "Infraestrutura excluída com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma infraestrutura selecionada. Operação de exclusão cancelada.");
        }

        chamaMenuInventario();
    }


    public static void chamaMenuAluguel() {
        String[] opcoesMenuAluguel = {"Cadastrar Aluguel", "Voltar"};
        int menuCadastroAluguel = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Cadastrar",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuAluguel, opcoesMenuAluguel[0]);

        switch (menuCadastroAluguel) {
            case 0: // Cadastra novo Aluguel
                cadastroAluguel();
                break;
            case 1:// Voltar
                chamaMenuPrincipal();
                break;
        }
    }

    public static void cadastroAluguel() {
        Socio socio = selecaoDeSocio();
        StatusSocio inativo = socio.getEnumStatusSocio();
        if (inativo == INATIVO){
            JOptionPane.showMessageDialog(null,"Socio INATIVO!! Favor selecionar um socio ATIVO");
            chamaMenuAluguel();
        }
        Local local = selecaoDeLocal();

        String descricaoAluguel = JOptionPane.showInputDialog("Digite a descrição do aluguel:");
        String dataInicio = JOptionPane.showInputDialog("Digite a data de início no formato dd/MM/yyyy:");
        String dataFim = JOptionPane.showInputDialog("Digite a data de término no formato dd/MM/yyyy:");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate inicio = null;
        try {
            inicio = LocalDate.parse(dataInicio, formatter);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data de início inválida. Por favor, insira uma data válida no formato dd/MM/yyyy.");

        }

        LocalDate fim = null;
        try {
            fim = LocalDate.parse(dataFim, formatter);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data de término inválida. Por favor, insira uma data válida no formato dd/MM/yyyy.");
        }

        LocalDateTime dataHoraInicio = inicio.atTime(14, 00, 00);
        LocalDateTime dataHoraFim = fim.atTime(07, 00, 00);

        String numeroVisitantes = JOptionPane.showInputDialog("Digite a quantidade de visitantes:");
        try {
            int visitantes = Integer.parseInt(numeroVisitantes);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Quantidade de visitantes inválida. Por favor, insira um valor numérico válido.");
        }


        if (dataHoraInicio.isAfter(dataHoraFim)) {
            JOptionPane.showMessageDialog(null, "A data de início deve ser anterior à data de término.");
            return;
        }

        List<Aluguel> alugueisExistentes = getAluguelDAO().buscarPorNome(local.getNome());
        if (verificarDisponibilidade(alugueisExistentes, dataHoraInicio, dataHoraFim)) {
            Aluguel novoAluguel = new Aluguel(socio, local, descricaoAluguel, dataHoraInicio, dataHoraFim, numeroVisitantes);
            getAluguelDAO().salvar(novoAluguel);
            JOptionPane.showMessageDialog(null, "Aluguel cadastrado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "O local selecionado não está disponível no período desejado.");
        }
        chamaMenuPrincipal();
    }

    private static boolean verificarDisponibilidade(List<Aluguel> alugueisExistentes, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim) {
        for (Aluguel aluguel : alugueisExistentes) {
            LocalDateTime inicioExistente = aluguel.getDataHoraInicio();
            LocalDateTime fimExistente = aluguel.getDataHoraFim();
            if ((dataHoraInicio.isAfter(inicioExistente) && dataHoraInicio.isBefore(fimExistente)) ||
                    (dataHoraFim.isAfter(inicioExistente) && dataHoraFim.isBefore(fimExistente)) ||
                    (dataHoraInicio.isBefore(inicioExistente) && dataHoraFim.isAfter(fimExistente))) {
                return false;
            }
        }
        return true;
    }


    public static void chamaRelatorioInventario() {

        List<Inventario> inventarios = getInventarioDAO().buscarTodos();
        RelatorioInventarioForm.emitirRelatorio(inventarios);
    }



    public static void chamaRelatorioLocais() {
        List<Local> locals = getLocalDAO().buscarTodos();
        RelatorioLocalForm.emitirRelatorio(locals);
    }

    public static void chamaRelatorioSocios() {
        List<Socio> socios = getSocioDAO().buscarTodos();
        RelatorioSocioForm.emitirRelatorio(socios);
    }

    public static void chamaRelatorioAluguel() {
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
        chamaMenuPrincipal();
    }

    public static void checaSenhaUsuario(Object usuarioLogado) throws SQLException, ClassNotFoundException {
        String senhaDigitada = JOptionPane.showInputDialog(null,
                "Informe a senha do usuario (" + usuarioLogado + ")");
        Usuario usuarioByLogin = UsuarioDAO.findUsuarioByLogin((String) usuarioLogado);

        if (usuarioByLogin.getSenha().equals(senhaDigitada)) {
            chamaMenuPrincipal();
        } else {
            JOptionPane.showMessageDialog(null, "Senha incorreta!");
            chamaSelecaoUsuario();
        }
    }

    public static Object chamaSelecaoUsuario() {
        Object[] selectionValues = UsuarioDAO.findUsuariosSistemaInArray();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o usuario?",
                "SeguradoraAPP", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        return selection;
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
