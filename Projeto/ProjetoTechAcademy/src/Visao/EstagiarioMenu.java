package Visao;

import Dominio.Estagiario;
import Servico.EstagiarioSRV;

import java.util.Scanner;

public class EstagiarioMenu extends BaseMenu implements IMenu {

    private final EstagiarioSRV servico;
    private Estagiario estagiario;

    public void iniciar() {
        this.exibirMenuPrincipal();
    }

    private void exibirMenuPrincipal() {
        this.scan = new Scanner(System.in);
        int opcao = 0;
        while (opcao != 9) {
            opcao = this.exibirMenuPai("ESTAGIÁRIO");
            switch (opcao) {
                case 1:
                    this.listarTodos();
                    break;
                case 2:
                    this.pesquisarPorCodigo();
                    break;
                case 3:
                    this.incluir();
                    break;
                case 4:
                    this.alterar();
                    break;
                case 5:
                    this.excluir();
                    break;
                case 9:
                    System.out.println("TCHAU");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!");
                    this.pauseAndClear();
                    break;
            }
        }
    }


    @Override
    public void listarTodos() {
        System.out.println("\n\n\n\n\n");
        System.out.println("***** LISTANDO TUDO *****");
        this.servico.listar().forEach(Estagiario::exibir);
        this.pauseAndClear();
    }

    @Override
    public void pesquisarPorCodigo() {
        System.out.println("\n\n");
        System.out.println("***** PESQUISAR POR CÓDIGO *****");
        System.out.print("Informe o código: ");
        int codigo;
        while (true) {
            if (!this.scan.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro para o código.");
                this.scan.nextLine();
                System.out.print("Informe o código: ");
                continue;
            }

            codigo = this.scan.nextInt();
            this.scan.nextLine();
            if (codigo > 0) {
                break;
            }

            System.out.println("Entrada inválida. O código deve ser maior que zero.");
            System.out.print("Informe o código: ");
        }

        this.estagiario = this.servico.buscar(codigo);
        if (this.estagiario != null) {
            this.estagiario.exibir();
            return;
        }
        System.out.println("Estagiário não encontrado!");
        this.pauseAndClear();
    }

    @Override
    public void incluir() {
        System.out.println("\n\n");
        System.out.println("***** INCLUIR *****");

        System.out.print("Informe o nome: ");
        String nome = this.scan.nextLine();

        System.out.print("Informe o CPF: ");
        String cpf = this.scan.nextLine();

        System.out.print("Informe o email: ");
        String email = this.scan.nextLine();

        System.out.print("Informe o telefone: ");
        String telefone = this.scan.nextLine();

        System.out.print("Informe o valor bolsa: ");
        double valorBolsa = this.scan.nextDouble();

        this.scan.nextLine();
        System.out.print("Informe o endereço: ");
        String endereco = this.scan.nextLine();

        System.out.print("Informe o area estágio: ");
        String areaEstagio = this.scan.nextLine();

        System.out.print("Informe o carga horaria semanal: ");
        int cargaHorariaSemanal = this.scan.nextInt();

        this.estagiario = this.servico.criar(new Estagiario(0, nome, cpf, email, telefone, valorBolsa, endereco, areaEstagio, cargaHorariaSemanal));

        if (this.estagiario == null) {
            System.out.println("Erro ao incluir estagiário!");
            this.pauseAndClear();
            return;
        }

        System.out.println("Estagiário incluído com sucesso!");
        this.estagiario.exibir();
        this.pauseAndClear();
    }

    @Override
    public void alterar() {
        System.out.println("\n\n");
        System.out.println("***** ALTERAR *****");
        this.pesquisarPorCodigo();

        if (this.estagiario == null) {
            System.out.println("Estagiário não encontrado!");
            this.pauseAndClear();
            return;
        }

        System.out.print("Informe o nome: ");
        String nome = this.scan.nextLine();

        System.out.print("Informe o email: ");
        String email = this.scan.nextLine();

        System.out.print("Informe o telefone: ");
        String telefone = this.scan.nextLine();

        System.out.print("Informe o valor bolsa: ");
        double valorBolsa = this.scan.nextDouble();

        this.scan.nextLine();
        System.out.print("Informe o endereço: ");
        String endereco = this.scan.nextLine();

        System.out.print("Informe o area estágio: ");
        String areaEstagio = this.scan.nextLine();

        System.out.print("Informe o carga horaria semanal: ");
        int cargaHorariaSemanal = this.scan.nextInt();
        this.scan.nextLine();

        System.out.println("Confirma a alteração do estagiário? (Sim/Não): ");
        String confirmacao = this.scan.nextLine().trim().toLowerCase();

        if (confirmacao.equals("sim")) {
            this.estagiario.update(nome, email, telefone, valorBolsa, endereco, areaEstagio, cargaHorariaSemanal);
            if (this.servico.alterar(this.estagiario) != null) {
                System.out.println("Estagiário alterado com sucesso!");
                this.estagiario.exibir();
                this.pauseAndClear();
                return;
            }
            System.out.println("Erro ao alterar estagiário!");
        }

        System.out.println("Alteração cancelada.");
        this.pauseAndClear();
    }

    @Override
    public void excluir() {
        System.out.println("\n\n");
        System.out.println("***** EXCLUIR *****");
        this.pesquisarPorCodigo();
        if (this.estagiario != null) {
            System.out.println("Confirma a alteração do estagiário? (Sim/Não): ");
            String confirmacao = this.scan.nextLine().trim().toLowerCase();

            if (confirmacao.equals("sim")) {
                this.servico.excluirPorID(this.estagiario.getCodigo());
                System.out.println("Estagiário excluído com sucesso!");
                this.pauseAndClear();
            }
            System.out.println("Exclusão cancelada.");
        }
    }


    public EstagiarioMenu() {
        this.servico = new EstagiarioSRV();
    }
}
