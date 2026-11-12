package Dominio;

import java.util.Random;

public class Visitante extends BasePrestador {

    private static final int MAX_CRACHA_NUMERO = 10000;
    private String motivoVisita;
    private int crachaNumero;
    private String setorVisita;

    public String getMotivoVisita() {
        return motivoVisita;
    }

    public void setMotivoVisita(String motivoVisita) {
        if (motivoVisita == null || motivoVisita.isEmpty()) {
            System.out.println("Motivo da visita não pode ser nulo ou vazio.");
        }
        this.motivoVisita = motivoVisita;
    }

    public int getCrachaNumero() {
        return crachaNumero;
    }

    public void setCrachaNumero(int crachaNumero) {
        if (crachaNumero <= 0) {
            System.out.println("Número do crachá não pode ser menor ou igual a zero.");
        }
        this.crachaNumero = crachaNumero;
    }

    public String getSetorVisita() {
        return setorVisita;
    }

    public void setSetorVisita(String setorVisita) {
        if (setorVisita == null || setorVisita.isEmpty()) {
            System.out.println("Setor da visita não pode ser nulo ou vazio.");
        }
        this.setorVisita = setorVisita;
    }

    public Visitante() {}

    public Visitante(int codigo, String nome, String cpf, String email, String telefone, String endereco, String motivoVisita, String setorVisita) {
        super(codigo, nome, cpf, email, telefone, endereco);
        this.crachaNumero = new Random().nextInt(MAX_CRACHA_NUMERO);
        this.setorVisita = setorVisita;
        this.motivoVisita = motivoVisita;
    }

    public Visitante update(String nome, String email, String telefone, String endereco, String motivoVisita, String setorVisita) {
        this.setNome(nome);
        this.setEmail(email);
        this.setTelefone(telefone);
        this.setEndereco(endereco);
        this.setMotivoVisita(motivoVisita);
        this.setSetorVisita(setorVisita);
        return this;
    }

    @Override
    public void exibir() {
        System.out.println("\n[VISITANTE] Código: " + this.codigo);
        System.out.println(" | Nome: " + this.nome);
        System.out.println(" | CPF: " + this.cpf);
        System.out.println(" | E-mail: " + this.email);
        System.out.println(" | Telefone: " + this.telefone);
        System.out.println(" | Endereço: " + this.endereco);
        System.out.println(" | Motivo da visita: " + this.motivoVisita);
        System.out.println(" | Número do crachá: " + this.crachaNumero);
        System.out.println(" | Setor da visita: " + this.setorVisita);
    }
}
