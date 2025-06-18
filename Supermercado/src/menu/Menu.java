package menu;

import java.util.Scanner;
import arvore.*;
import dados.Produto;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    ArvoreProdutos arvore = new ArvoreProdutos();

    public void cabecalho() {
        System.out.println("------------------------------");
        System.out.println("|| Produtos de Supermercado ||");
        System.out.println("------------------------------");
    }

    public void exibirMenu() {
        cabecalho();
        System.out.println("\n     --- MENU ---");
        System.out.println("1. Cadastrar Produto");
        System.out.println("2. Pesquisar Produto");
        System.out.println("3. Remover Produto");
        System.out.println("4. Mostrar Produtos");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public void menu() {
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer após nextInt()

            switch (opcao) {
                case 1:
                    menuCadastro();
                    break;

                case 2:
                    menuPesquisar();
                    break;

                case 3:
                    System.out.println("Função de remoção ainda não implementada.");
                    break;

                case 4:
                    menuMostrar();
                    break;

                case 0:
                    System.out.println("Encerrando o programa.");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public void menuCadastro() {
        System.out.print("Nome do Produto: ");
        String nome = scanner.nextLine();

        System.out.print("Código de Barras: ");
        String codigo = scanner.nextLine();

        System.out.print("Preço Unitário: ");
        double preco = scanner.nextDouble();

        System.out.print("Quantidade em Estoque: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer

        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();

        Produto novoItem = new Produto(nome, codigo, preco, quantidade, categoria);
        boolean inserido = arvore.inserir(novoItem);

        if (inserido) {
            System.out.println("Produto cadastrado com sucesso!");
        } else {
            System.out.println("Produto já existente!");
        }
    }

    public void menuPesquisar() {
        System.out.print("Digite o nome do produto para pesquisar: ");
        String nome = scanner.nextLine();

        if (arvore.pesquisar(nome)) {
            System.out.println("Produto encontrado!");
            arvore.buscarProduto(nome);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void menuMostrar() {
        System.out.println("\n--- Produtos Cadastrados ---");
        if (arvore.eVazia()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            arvore.listar();
        }
    }    
}
