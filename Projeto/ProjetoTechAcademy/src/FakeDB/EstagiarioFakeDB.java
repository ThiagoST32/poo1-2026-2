package FakeDB;

import Dominio.Estagiario;

import java.util.ArrayList;
import java.util.List;

public class EstagiarioFakeDB extends BaseGenericaFakeDB<Estagiario> {
    @Override
    protected void autoPreencher() {

        this.dados.addAll(List.of(
                        new Estagiario(201, "Ana Paula", "12345678901",
                                "ana.paula@techacademy.com", "(11) 99999-0001", 900.0, "Rua das Flores, 100", "Desenvolvimento", 30),
                        new Estagiario(202, "Bruno Martins", "12345678902", "bruno.martins@techacademy.com", "(11) 99999-0002", 950.0,
                                "Avenida Central, 200", "Suporte", 30),
                        new Estagiario(203, "Carla Souza", "12345678903",
                                "carla.souza@techacademy.com", "(11) 99999-0003", 1000.0, "Rua do Comercio, 300", "Administracao", 20),
                        new Estagiario(204, "Diego Oliveira", "12345678904",
                                "diego.oliveira@techacademy.com", "(11) 99999-0004", 900.0, "Rua Primavera, 400", "Infraestrutura", 30),
                        new Estagiario(205, "Fernanda Lima", "12345678905",
                                "fernanda.lima@techacademy.com", "(11) 99999-0005", 1100.0, "Avenida Brasil, 500", "Recursos Humanos", 20)
                )
        );
    }

    public EstagiarioFakeDB() {
        this.dados = new ArrayList<>();
        this.autoPreencher();
    }
}
