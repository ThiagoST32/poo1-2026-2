package Visao;

import java.util.Scanner;

public abstract class BaseMenu {
    protected Scanner scan;

    protected int exibirMenuPai(String dominio){
        System.out.println("\n\n");
        System.out.println("----- Menu Principal [" + dominio +"] -----");
        System.out.println("1 - Listar todos");
        System.out.println("2 - Pesquisar Por Código");
        System.out.println("3 - Incluir");
        System.out.println("4 - Alterar");
        System.out.println("5 - Excluir");
        System.out.println("9 - Finalizar");
        System.out.print("Escolha uma opção: ");
        return this.entradaValida();
    }

    protected void pauseAndClear() {
        this.pausar();
        this.clearConsole();
    }

    protected void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    protected int entradaValida() {
        while (true) {
            if (!this.scan.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, insira uma entrada válida.");
                this.scan.nextLine();
                System.out.print("Informe o valor: ");
                continue;
            }
            int codigo = this.scan.nextInt();
            this.scan.nextLine();
            if (codigo > 0) {
                return codigo;
            }

            System.out.println("Entrada inválida.");
            System.out.print("Informe o valor: ");
        }
    }

    protected void pausar(){
        System.out.println("Clique <ENTER> para continuar...");
        this.scan.nextLine();
    }    
}
