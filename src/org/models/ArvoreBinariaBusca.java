package org.models;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ArvoreBinariaBusca {
    private No raiz;

    public ArvoreBinariaBusca() {
        this.raiz = null;
    }

    // --- 1. INSERIR VALOR ---
    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    private No inserirRec(No raiz, int valor) {
        if (raiz == null) {
            raiz = new No(valor);
            return raiz;
        }
        if (valor < raiz.valor) {
            raiz.esquerda = inserirRec(raiz.esquerda, valor);
        } else if (valor > raiz.valor) {
            raiz.direita = inserirRec(raiz.direita, valor);
        } else {
            System.out.println("Valor " + valor + " já existe na árvore (ignorando duplicata).");
        }
        return raiz;
    }

    // --- 2. BUSCAR VALOR ---
    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(No raiz, int valor) {
        if (raiz == null) {
            return false;
        }
        if (raiz.valor == valor) {
            return true;
        }
        if (valor < raiz.valor) {
            return buscarRec(raiz.esquerda, valor);
        } else {
            return buscarRec(raiz.direita, valor);
        }
    }

    // --- 3. PRÉ-ORDEM ---
    public void preOrdem() {
        preOrdemRec(raiz);
        System.out.println();
    }

    private void preOrdemRec(No raiz) {
        if (raiz != null) {
            System.out.print(raiz.valor + " ");
            preOrdemRec(raiz.esquerda);
            preOrdemRec(raiz.direita);
        }
    }

    // --- 4. EM ORDEM ---
    public void emOrdem() {
        emOrdemRec(raiz);
        System.out.println();
    }

    private void emOrdemRec(No raiz) {
        if (raiz != null) {
            emOrdemRec(raiz.esquerda);
            System.out.print(raiz.valor + " ");
            emOrdemRec(raiz.direita);
        }
    }

    // --- 5. PÓS-ORDEM ---
    public void posOrdem() {
        posOrdemRec(raiz);
        System.out.println();
    }

    private void posOrdemRec(No raiz) {
        if (raiz != null) {
            posOrdemRec(raiz.esquerda);
            posOrdemRec(raiz.direita);
            System.out.print(raiz.valor + " ");
        }
    }

    // --- 6. BFS - BUSCA EM LARGURA ---
    public void bfs() {
        if (raiz == null) {
            System.out.println("A árvore está vazia.");
            return;
        }

        // A adição do  de ambos os lados resolve o erro
        Queue fila = new LinkedList();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No atual = (No) (No) fila.poll(); // Linha 106 deixará de dar erro
            System.out.print(atual.valor + " ");

            if (atual.esquerda != null) {
                fila.add(atual.esquerda);
            }
            if (atual.direita != null) {
                fila.add(atual.direita);
            }
        }
        System.out.println();
    }

    // --- 7. DFS - BUSCA EM PROFUNDIDADE ---
    public void dfs() {
        if (raiz == null) {
            System.out.println("A árvore está vazia.");
            return;
        }

        // A adição do  de ambos os lados resolve o erro
        Stack pilha = new Stack();
        pilha.push(raiz);

        while (!pilha.isEmpty()) {
            No atual = (No) pilha.pop(); // Linha 130 deixará de dar erro
            System.out.print(atual.valor + " ");

            if (atual.direita != null) {
                pilha.push(atual.direita);
            }
            if (atual.esquerda != null) {
                pilha.push(atual.esquerda);
            }
        }
        System.out.println();
    }
    // --- 8. ALTURA DA ÁRVORE ---
    public int calcularAltura() {
        return calcularAlturaRec(raiz);
    }

    private int calcularAlturaRec(No raiz) {
        if (raiz == null) {
            return -1;
        }
        int alturaEsquerda = calcularAlturaRec(raiz.esquerda);
        int alturaDireita = calcularAlturaRec(raiz.direita);

        return Math.max(alturaEsquerda, alturaDireita) + 1;
    }

    // --- 9. ESTRUTURA DA ÁRVORE ---
    public void mostrarEstrutura() {
        if (raiz == null) {
            System.out.println("A árvore está vazia.");
            return;
        }
        mostrarEstruturaRec(raiz, 0);
    }

    private void mostrarEstruturaRec(No raiz, int nivel) {
        if (raiz == null) {
            return;
        }
        mostrarEstruturaRec(raiz.direita, nivel + 1);

        for (int i = 0; i < nivel; i++) {
            System.out.print("       ");
        }
        System.out.println(raiz.valor);

        mostrarEstruturaRec(raiz.esquerda, nivel + 1);
    }
}