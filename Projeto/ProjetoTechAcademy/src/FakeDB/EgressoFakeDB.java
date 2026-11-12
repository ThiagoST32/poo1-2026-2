package FakeDB;

import Dominio.Egresso;

import java.util.ArrayList;
import java.util.List;

public class EgressoFakeDB extends BaseGenericaFakeDB<Egresso> {
    @Override
    protected void autoPreencher() {
        this.dados.addAll(List.of(
                new Egresso(301, "Lucas Silva", "12345678901", 2020, "Engenharia de Software", "Desenvolvimento"),
                new Egresso(302, "Mariana Costa", "12345678902", 2019, "Ciência da Computação", "Análise de Dados"),
                new Egresso(303, "Rafael Oliveira", "12345678903", 2021, "Sistemas de Informação", "Gestão de Projetos"),
                new Egresso(304, "Juliana Santos", "12345678904", 2018, "Engenharia de Computação", "Infraestrutura"),
                new Egresso(305, "Gabriel Almeida", "12345678905", 2022, "Análise e Desenvolvimento de Sistemas", "Suporte Técnico")
        ));
    }


    public EgressoFakeDB() {
        this.dados = new ArrayList<>();
        this.autoPreencher();
    }
}
