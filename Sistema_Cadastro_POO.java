package Classes_Objetos;
import java.util.Scanner;
import java.util.ArrayList;

public class Sistema_Cadastro_POO {

	public static void main(String[] args) {
		
		  Scanner sc = new Scanner(System.in);
	        ArrayList<Produto> lista = new ArrayList<>();

	        int opcao;

	        do {
	            System.out.println("\n===== MENU =====");
	            System.out.println("1 - Cadastrar produto");
	            System.out.println("2 - Listar produtos");
	            System.out.println("3 - Mostrar preço com desconto");
	            System.out.println("4 - Remover produto");
	            System.out.println("5 - Média de preços");
	            System.out.println("0 - Sair");
	            System.out.print("Escolha: ");
	            opcao = sc.nextInt();
	            sc.nextLine(); // limpar buffer

	            switch (opcao) {

	                case 1:
	                    Produto p = new Produto();

	                    System.out.print("Nome: ");
	                    p.nome = sc.nextLine();

	                    System.out.print("Preço: ");
	                    p.preco = sc.nextDouble();

	                    System.out.print("Desconto (%): ");
	                    p.desconto = sc.nextDouble();

	                    sc.nextLine(); // 🔥 limpar ENTER

	                    lista.add(p);

	                    System.out.println("✅ Produto cadastrado!");
	                    break;

	                case 2:
	                    if (lista.isEmpty()) {
	                        System.out.println("Nenhum produto cadastrado.");
	                    } else {
	                        System.out.println("\n=== LISTA DE PRODUTOS ===");
	                        for (Produto prod : lista) {
	                            System.out.println("Nome: " + prod.nome);
	                            System.out.println("Preço: R$ " + prod.preco);
	                            System.out.println("Desconto: " + prod.desconto + "%");
	                            System.out.println("----------------------");
	                        }
	                    }
	                    break;

	                case 3:
	                    if (lista.isEmpty()) {
	                        System.out.println("Nenhum produto cadastrado.");
	                    } else {
	                        for (Produto prod : lista) {
	                            System.out.println("Produto: " + prod.nome);
	                            System.out.println("Preço final: R$ " + prod.precoComDesconto());
	                            System.out.println("----------------------");
	                        }
	                    }
	                    break;

	                case 4:
	                    if (lista.isEmpty()) {
	                        System.out.println("Nenhum produto para remover.");
	                    } else {
	                        System.out.print("Digite o nome do produto: ");
	                        String nomeRemover = sc.nextLine();

	                        boolean removido = lista.removeIf(prod ->
	                                prod.nome.equalsIgnoreCase(nomeRemover)
	                        );

	                        if (removido) {
	                            System.out.println("✅ Produto removido!");
	                        } else {
	                            System.out.println("❌ Produto não encontrado.");
	                        }
	                    }
	                    break;

	                case 5:
	                    if (lista.isEmpty()) {
	                        System.out.println("Lista vazia.");
	                    } else {
	                        double soma = 0;

	                        for (Produto prod : lista) {
	                            soma += prod.preco;
	                        }

	                        double media = soma / lista.size();
	                        System.out.println("Média dos preços: R$ " + media);
	                    }
	                    break;

	                case 0:
	                    System.out.println("Saindo...");
	                    break;

	                default:
	                    System.out.println("Opção inválida!");
	            }

	        } while (opcao != 0);

	        sc.close();
	    }
	}

