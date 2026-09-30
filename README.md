# 🌳 Árvore Binária de Busca em Java

Este repositório contém a implementação completa de uma **Árvore Binária de Busca (BST - Binary Search Tree)** desenvolvida em **Java**. O projeto foi estruturado utilizando os princípios da Programação Orientada a Objetos (POO) e oferece uma interface interativa via terminal (menu) para manipular e visualizar a árvore.

## 🚀 Funcionalidades

O programa permite realizar as seguintes operações:

- **Inserir valores:** Adiciona novos nós respeitando a regra da BST (menores à esquerda, maiores à direita).
- **Buscar valor:** Pesquisa recursivamente se um determinado elemento existe na árvore.
- **Percursos em Profundidade (DFS):**
  - **Pré-ordem** (Raiz → Esquerda → Direita)
  - **Em ordem** (Esquerda → Raiz → Direita)
  - **Pós-ordem** (Esquerda → Direita → Raiz)
  - **DFS Iterativo** (Utilizando Pilha/Stack)
- **Percurso em Largura (BFS):** Visita os nós nível a nível (Utilizando Fila/Queue).
- **Altura da Árvore:** Calcula a altura máxima da árvore de forma recursiva.
- **Estrutura Visual:** Exibe a árvore formatada de forma hierárquica no console.

## 📂 Estrutura do Projeto

O código está organizado em pacotes para separar a lógica de negócio da interface do usuário:

```text
src/
 └── org/
      ├── main/
      │    └── Main.java                # Ponto de entrada do programa e Menu iterativo
      └── models/
           ├── ArvoreBinariaBusca.java  # Lógica de inserção, busca e percursos
           └── No.java                  # Estrutura base de um nó (valor, esquerda, direita)
