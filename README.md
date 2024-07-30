# Árvore Binária

## Descrição

Este projeto é uma implementação de uma **Árvore Binária** em Java. Uma árvore binária é uma estrutura de dados hierárquica na qual cada nó possui no máximo dois filhos: o filho esquerdo e o filho direito. A árvore binária é amplamente utilizada em diversas aplicações, como a implementação de algoritmos de busca, organização de dados e na construção de estruturas de dados mais complexas.

### Funcionalidades

Este projeto oferece uma implementação básica de árvore binária com os seguintes recursos:

- **Inserção**: Adiciona novos nós à árvore, mantendo a propriedade da árvore binária.
- **Remoção**: Remove nós da árvore com base em seu valor. O método lida com diferentes casos de remoção, incluindo nós com zero, um ou dois filhos.
  - **Nó Folha**: Se o nó a ser removido não tiver filhos (é um nó folha), ele é removido diretamente da árvore.
  - **Nó com Um Filho**: Se o nó a ser removido tem apenas um filho, este filho substitui o nó removido. 
  - **Nó com Dois Filhos**: Se o nó a ser removido tem dois filhos, ele é substituído pelo seu sucessor (o menor valor na subárvore direita) e a árvore é ajustada conforme necessário.

- **Percursos**: Realiza travessias da árvore em três ordens diferentes:
  - **Pré-Ordem**: Visita a raiz, depois os filhos esquerdo e direito.
  - **Em-Ordem**: Visita o filho esquerdo, depois a raiz e, por fim, o filho direito.
  - **Pós-Ordem**: Visita os filhos esquerdo e direito, e, por último, a raiz.
