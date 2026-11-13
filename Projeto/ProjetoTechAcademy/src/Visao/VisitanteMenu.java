package Visao;

import Dominio.Visitante;
import Servico.VisitanteSRV;

import java.util.Scanner;

public class VisitanteMenu extends BaseMenu implements IMenu {

    private final VisitanteSRV servico;
    private Visitante visitante;

    public void iniciar() {
        this.exibirMenuPrincipal();
    }

    private void exibirMenuPrincipal() {
        this.scan = new Scanner(System.in);
        int opcao = 0;
        while (opcao != 9) {
            opcao = this.exibirMenuPai("Visitante");
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
        this.servico.listar().forEach(Visitante::exibir);
        this.pauseAndClear();
    }

    @Override
    public void pesquisarPorCodigo() {
        System.out.println("\n\n");
        System.out.println("***** PESQUISAR POR CÓDIGO *****");
        System.out.print("Informe o código: ");
        this.visitante = this.servico.buscar(this.entradaValida());
        if (this.visitante != null) {
            this.visitante.exibir();
            return;
        }
        System.out.println("Visitante não encontrado!");
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

        System.out.print("Informe o endereço: ");
        String endereco = this.scan.nextLine();
        
        System.out.print("Informe o motivo da visita: ");
        String motivoVisita = this.scan.nextLine();

        System.out.print("Informe o setor de visita: ");
        String setorVisita = this.scan.nextLine();

        this.visitante = this.servico.criar(new Visitante(0, nome, cpf, email, telefone, endereco, motivoVisita, setorVisita));

        if (this.visitante == null) {
            System.out.println("Erro ao incluir visitante!");
            this.pauseAndClear();
            return;
        }

        System.out.println("Visitante incluído com sucesso!");
        this.visitante.exibir();
        this.pauseAndClear();
    }

    @Override
    public void alterar() {
        System.out.println("\n\n");
        System.out.println("***** ALTERAR *****");
        this.pesquisarPorCodigo();

        if (this.visitante == null) {
            System.out.println("Visitante não encontrado!");
            this.pauseAndClear();
            return;
        }

        System.out.print("Informe o nome: ");
        String nome = this.scan.nextLine();

        System.out.print("Informe o email: ");
        String email = this.scan.nextLine();

        System.out.print("Informe o telefone: ");
        String telefone = this.scan.nextLine();

        System.out.print("Informe o endereço: ");
        String endereco = this.scan.nextLine();

        System.out.print("Informe o motivo da visita: ");
        String motivoVisita = this.scan.nextLine();

        System.out.print("Informe o setor de visita: ");
        String setorVisita = this.scan.nextLine();

        System.out.println("Confirma a alteração do Visitante? (Sim/Não): ");
        String confirmacao = this.scan.nextLine().trim().toLowerCase();

        if (confirmacao.equals("sim")) {
            this.visitante.update(nome, email, telefone, endereco, motivoVisita, setorVisita);
            if (this.servico.alterar(this.visitante) != null) {
                System.out.println("Visitante alterado com sucesso!");
                this.visitante.exibir();
                this.pauseAndClear();
                return;
            }
            System.out.println("Erro ao alterar Visitante!");
        }

        System.out.println("Alteração cancelada.");
        this.pauseAndClear();
    }

    @Override
    public void excluir() {
        System.out.println("\n\n");
        System.out.println("***** EXCLUIR *****");
        this.pesquisarPorCodigo();
        if (this.visitante != null) {
            System.out.println("Confirma a exclusão do visitante? (Sim/Não): ");
            String confirmacao = this.scan.nextLine().trim().toLowerCase();

            if (confirmacao.equals("sim")) {
                this.servico.excluirPorID(this.visitante.getCodigo());
                System.out.println("Estagiário excluído com sucesso!");
                this.pauseAndClear();
            }
            System.out.println("Exclusão cancelada.");
        }
    }

    public VisitanteMenu() {
        this.servico = new VisitanteSRV();
    }
}
