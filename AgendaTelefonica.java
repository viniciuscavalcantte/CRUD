import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AgendaTelefonica {
    private Map<String, Contato> contatos;
    private Scanner scanner;

    public AgendaTelefonica() {
        contatos = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void adicionarContato() {
        System.out.println("Digite o nome do contato:");
        String nome = scanner.nextLine();
        System.out.println("Digite o telefone do contato:");
        String telefone = scanner.nextLine();
        System.out.println("Digite a idade do contato:");
        int idade = Integer.parseInt(scanner.nextLine());
        System.out.println("Digite o endereço do contato:");
        String endereco = scanner.nextLine();

        Contato contato = new Contato(nome, telefone, idade, endereco);
        contatos.put(nome, contato);
        System.out.println("Contato adicionado com sucesso!");
    }

    public void exibirContatos() {
        if (contatos.isEmpty()) {
            System.out.println("A agenda está vazia.");
        } else {
            System.out.println("Contatos na agenda:");
            for (Contato contato : contatos.values()) {
                System.out.println(contato);
            }
        }
    }

    public void atualizarContato() {
        System.out.println("Digite o nome do contato que deseja atualizar:");
        String nome = scanner.nextLine();

        if (contatos.containsKey(nome)) {
            Contato contato = contatos.get(nome);

            System.out.println("Digite o novo telefone do contato:");
            String telefone = scanner.nextLine();
            System.out.println("Digite a nova idade do contato:");
            int idade = Integer.parseInt(scanner.nextLine());
            System.out.println("Digite o novo endereço do contato:");
            String endereco = scanner.nextLine();

            contato.setTelefone(telefone);
            contato.setIdade(idade);
            contato.setEndereco(endereco);

            System.out.println("Contato atualizado com sucesso!");
        } else {
            System.out.println("Contato não encontrado na agenda.");
        }
    }

    public void removerContato() {
        System.out.println("Digite o nome do contato que deseja remover:");
        String nome = scanner.nextLine();

        if (contatos.containsKey(nome)) {
            contatos.remove(nome);
            System.out.println("Contato removido com sucesso!");
        } else {
            System.out.println("Contato não encontrado na agenda.");
        }
    }

    public static void main(String[] args) {
        AgendaTelefonica agenda = new AgendaTelefonica();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Agenda Telefônica ---");
            System.out.println("1. Adicionar contato");
            System.out.println("2. Exibir contatos");
            System.out.println("3. Atualizar contato");
            System.out.println("4. Remover contato");
            System.out.println("0. Sair");
            System.out.println("Escolha uma opção:");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    agenda.adicionarContato();
                    break;
                case 2:
                    agenda.exibirContatos();
                    break;
                case 3:
                    agenda.atualizarContato();
                    break;
                case 4:
                    agenda.removerContato();
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}

class Contato {
    private String nome;
    private String telefone;
    private int idade;
    private String endereco;

    public Contato(String nome, String telefone, int idade, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.idade = idade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getIdade() {
        return idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Telefone: " + telefone + ", Idade: " + idade + ", Endereço: " + endereco;
    }
}
