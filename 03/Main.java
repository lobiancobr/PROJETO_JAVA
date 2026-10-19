import model.Projeto;
import service.ProjetoService;

public class Main {

    public static void main(String[] args) {

        ProjetoService service =
            new ProjetoService();

        Projeto p1 = new Projeto(
            1,
            "Sistema Acadêmico",
            "Sistema para gerenciamento acadêmico",
            "Software",
            "Em desenvolvimento"
        );

        Projeto p2 = new Projeto(
            2,
            "Site Institucional",
            "Website institucional",
            "Web",
            "Concluído"
        );

        Projeto p3 = new Projeto(
            3,
            "Aplicativo Mobile",
            "Aplicativo para prestação de serviços",
            "Mobile",
            "Planejado"
        );

        Projeto p4 = new Projeto(
            4,
            "Portal de Eventos",
            "Website dos eventos institucionais",
            "Web",
            "Em desenvolvimento"
        );

        Projeto p5 = new Projeto(
            5,
            "Sistema Financeiro",
            "Desktop para apoio financeiro",
            "Software ",
            "Concluído"
        );

        service.adicionar(p1);
        service.adicionar(p2);
        service.adicionar(p3);
        service.adicionar(p4);
        service.adicionar(p5);

        System.out.println(
            "TOTAL DE PROJETOS: "
            + service.listar().size()
        );

        System.out.println();

        System.out.println("LISTA DE PROJETOS");

        for (Projeto projeto : service.listar()) {
            projeto.exibirDados();
            System.out.println("----------------");

        }

        System.out.println();

        System.out.println("BUSCA PELO ID 3");

        Projeto encontrado =
            service.buscarPorId(3);

        if (encontrado != null) {
            encontrado.exibirDados();

        }

        System.out.println();

        System.out.println("PROJETOS WEB");

        for (Projeto projeto :
            service.buscarPorCategoria("Web")
        ) {

            projeto.exibirDados();

        }

        System.out.println();

        System.out.println("PROJETOS CONCLUÍDOS");

        for (Projeto projeto :
            service.buscarPorStatus("Concluído")
        ) {
            projeto.exibirDados();

        }

        System.out.println();

        System.out.println("REMOVER ID 4");

        Projeto remocao =
            service.buscarPorId(4);

        if (encontrado != null) {
            service.removerPorId(4);
            System.out.println("PROJETO REMOVIDO");
        }

        System.out.println();

        System.out.println("TENTAR INSERIR ID 1 OUTRA VEZ");

        Projeto p6 = new Projeto(
            1,
            "Outro sistema",
            "Sistema para teste",
            "Software",
            "Concluído"
        );

        if (service.adicionar(p6)) {
            System.out.println("PROJETO INSERIDO");
        }        
        else {
            System.out.println("PROJETO NÃO INSERIDO");
        }

        
    }
}

