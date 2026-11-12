package FakeDB;

import Dominio.Visitante;

import java.util.ArrayList;
import java.util.List;

public class VisitanteFakeDB extends  BaseGenericaFakeDB<Visitante> {

    @Override
    protected void autoPreencher() {
        this.dados.addAll(List.of(
                new Visitante(301, "Joao da Silva", "98765432101",
                        "joao.silva@email.com", "(11) 98888-0001",
                        "Rua das Flores, 100", "Reuniao", "Administração"),
                new Visitante(302, "Maria Oliveira", "98765432102",
                        "maria.oliveira@email.com", "(11) 98888-0002",
                        "Avenida Central, 200", "Entrevista", "Recursos Humanos"),
                new Visitante(303, "Pedro Santos", "98765432103",
                        "pedro.santos@email.com", "(11) 98888-0003",
                        "Rua Primavera, 300", "Entrega de documentos", "Secretaria"),
                new Visitante(304, "Ana Costa", "98765432104",
                        "ana.costa@email.com", "(11) 98888-0004",
                        "Avenida Brasil, 400", "Visita tecnica", "Tecnologia"),
                new Visitante(305, "Lucas Mendes", "98765432105",
                        "lucas.mendes@email.com", "(11) 98888-0005",
                        "Rua do Comercio, 500", "Reuniao com fornecedor", "Compras")
        ));
    }

    public VisitanteFakeDB() {
        this.dados = new ArrayList<>();
        this.autoPreencher();
    }
}
