package org.main;

import org.models.ArvoreBinariaBusca; // Importante para resolver "cannot find symbol"
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
        int opcao = 0;

        while (opcao != 10) {
            System.out.println("\n=================================");
            System.out.println("    ÁRVORE BINÁRIA DE BUSCA");
            System.out.println("=================================");
            System.out.println("1 - Inserir valores");
            System.out.println("2 - Buscar valor");
            System.out.println("3 - Mostrar Pré-ordem");
            System.out.println("4 - Mostrar Em ordem");
            System.out.println("5 - Mostrar Pós-ordem");
            System.out.println("6 - Mostrar BFS (Busca em Largura)");
            System.out.println("7 - Mostrar DFS (Busca em Profundidade)");
            System.out.println("8 - Mostrar altura da árvore");
            System.out.println("9 - Mostrar estrutura da árvore");
            System.out.println("10 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Entrada inválida! Digite um número.");
                scanner.nextLine(); // Limpar buffer
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Quantos nós deseja inserir na árvore? ");
                    int qtd = scanner.nextInt();
                    for (int i = 0; i < qtd; i++) {
                        System.out.print("Digite o valor para o " + (i + 1) + "º nó: ");
                        int valor = scanner.nextInt();
                        arvore.inserir(valor);
                    }
                    System.out.println("Valores inseridos com sucesso!");
                    break;
                case 2:
                    System.out.print("Qual valor deseja buscar? ");
                    int valorBusca = scanner.nextInt();
                    if (arvore.buscar(valorBusca)) {
                        System.out.println("-> O valor " + valorBusca + " FOI ENCONTRADO na árvore.");
                    } else {
                        System.out.println("-> O valor " + valorBusca + " NÃO ESTÁ na árvore.");
                    }
                    break;
                case 3:
                    System.out.print("Percurso Pré-ordem: ");
                    arvore.preOrdem();
                    break;
                case 4:
                    System.out.print("Percurso Em ordem: ");
                    arvore.emOrdem();
                    break;
                case 5:
                    System.out.print("Percurso Pós-ordem: ");
                    arvore.posOrdem();
                    break;
                case 6:
                    System.out.print("Percurso BFS (Largura): ");
                    arvore.bfs();
                    break;
                case 7:
                    System.out.print("Percurso DFS (Profundidade): ");
                    arvore.dfs();
                    break;
                case 8:
                    int altura = arvore.calcularAltura();
                    if (altura == -1) {
                        System.out.println("A árvore está vazia (altura -1).");
                    } else {
                        System.out.println("A altura da árvore é: " + altura);
                    }
                    break;
                case 9:
                    System.out.println("\nEstrutura da Árvore (Raiz à esquerda, ramos à direita):");
                    arvore.mostrarEstrutura();
                    break;
                case 10:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        scanner.close();
    }
}