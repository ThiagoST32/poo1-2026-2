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
                System.out.println("Entrada inválida. Por favor, insira um número inteiro para o código.");
                this.scan.nextLine();
                System.out.print("Informe o código: ");
                continue;
            }
            int codigo = this.scan.nextInt();
            this.scan.nextLine();
            if (codigo > 0) {
                return codigo;
            }

            System.out.println("Entrada inválida. O código deve ser maior que zero.");
            System.out.print("Informe o código: ");
        }
    }

    protected void pausar(){
        System.out.println("Clique <ENTER> para continuar...");
        this.scan.nextLine();
    }    
}
