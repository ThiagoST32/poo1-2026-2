package Dominio;

public class Estagiario extends BasePrestador {

    private Double valorBolsa;
    private int cargaHorariaSemanal;
    private String areaEstagio;

    public Double getValorBolsa() {
        return valorBolsa;
    }

    public void setValorBolsa(Double valorBolsa) {
        if (valorBolsa <= 0) {
            System.out.println("Valor da bolsa deve ser maior que zero.");
        }
        this.valorBolsa = valorBolsa;
    }

    public int getCargaHorariaSemanal() {
        return cargaHorariaSemanal;
    }

    public void setCargaHorariaSemanal(int cargaHorariaSemanal) {
        if (cargaHorariaSemanal <= 0) {
            System.out.println("Carga horária semanal deve ser maior que zero.");
        }
        this.cargaHorariaSemanal = cargaHorariaSemanal;
    }

    public String getAreaEstagio() {
        return areaEstagio;
    }

    public void setAreaEstagio(String areaEstagio) {
        if (areaEstagio == null || areaEstagio.isEmpty()) {
            System.out.println("Área de estágio não pode ser nula ou vazia.");
        }
        this.areaEstagio = areaEstagio;
    }

    @Override
    public void exibir()
    {
        System.out.println("\n[ESTAGIÁRIO] Código: " + this.codigo);
        System.out.println(" | Nome: " + this.nome);
        System.out.println(" | CPF: " + this.cpf);
        System.out.println(" | E-mail: " + this.email);
        System.out.println(" | Telefone: " + this.telefone);
        System.out.println(" | Endereço: " + this.endereco);
        System.out.println(" | Valor da bolsa: " + this.valorBolsa);
        System.out.println(" | Area do estagio: " + this.areaEstagio);
        System.out.println(" | Carga horaria semanal: " + this.cargaHorariaSemanal);
    }

    public Estagiario() {}

    public Estagiario(int codigo, String nome, String cpf, String email, String telefone, Double valorBolsa, String endereco, String areaEstagio, int cargaHorariaSemanal) {
        super(codigo, nome, cpf, email, telefone, endereco);
        this.areaEstagio = areaEstagio;
        this.cargaHorariaSemanal = cargaHorariaSemanal;
        this.valorBolsa = valorBolsa;
    }

    public void update(String nome, String email, String telefone, Double valorBolsa, String endereco, String areaEstagio, int cargaHorariaSemanal) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.valorBolsa = valorBolsa;
        this.endereco = endereco;
        this.areaEstagio = areaEstagio;
        this.cargaHorariaSemanal = cargaHorariaSemanal;
    }
}
