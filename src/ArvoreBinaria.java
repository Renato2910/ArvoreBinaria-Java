public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(int valor) {
        No novoNo = new No(valor);
        if (this.raiz == null) {
            this.raiz = novoNo;
        } else {
            No atual = this.raiz;
            No pai = null;
            boolean esquerda = false;
            while (atual != null) {
                if (novoNo.getValor() < atual.getValor()) {
                    pai = atual;
                    atual = atual.getEsq();
                    esquerda = true;
                } else {
                    pai = atual;
                    atual = atual.getDir();
                    esquerda = false;
                }
            }
            if (esquerda) {
                pai.setEsq(novoNo);
            } else {
                pai.setDir(novoNo);
            }
        }
    }

    public No getRaiz() {
        return this.raiz;
    }

    public void preOrdem(No no) {
        if (no == null) {
            return;
        }
        System.out.println(no.getValor());
        preOrdem(no.getEsq());
        preOrdem(no.getDir());
    }

    public void emOrdem(No no) {
        if (no == null) {
            return;
        }
        emOrdem(no.getEsq());
        System.out.println(no.getValor());
        emOrdem(no.getDir());
    }

    public void posOrdem(No no) {
        if (no == null) {
            return;
        }
        posOrdem(no.getEsq());
        posOrdem(no.getDir());
        System.out.println(no.getValor());
    }

    public boolean remover(int valor) {
        No atual = this.raiz;
        No pai = this.raiz;
        boolean isEsquerda = true;

        // Encontrar o nó a ser removido
        while (atual.getValor() != valor) {
            pai = atual;
            if (valor < atual.getValor()) {
                isEsquerda = true;
                atual = atual.getEsq();
            } else {
                isEsquerda = false;
                atual = atual.getDir();
            }
            if (atual == null) {
                System.out.println("O valor " + valor + " não foi encontrado na árvore!");
                return false;
            }
        }

        // Caso 1: Nó é uma folha
        if (atual.getEsq() == null && atual.getDir() == null) {
            if (atual == raiz) {
                raiz = null;
            } else if (isEsquerda) {
                pai.setEsq(null);
            } else {
                pai.setDir(null);
            }
            System.out.println("O nó removido é uma folha!");
        }

        // Caso 2: Nó tem apenas um filho (direito ou esquerdo)
        else if (atual.getDir() == null) {
            if (atual == raiz) {
                raiz = atual.getEsq();
            } else if (isEsquerda) {
                pai.setEsq(atual.getEsq());
            } else {
                pai.setDir(atual.getEsq());
            }
            System.out.println("O nó removido está à direita do nó pai.");
        } else if (atual.getEsq() == null) {
            if (atual == raiz) {
                raiz = atual.getDir();
            } else if (isEsquerda) {
                pai.setEsq(atual.getDir());
            } else {
                pai.setDir(atual.getDir());
            }
            System.out.println("O nó removido está à esquerda do nó pai.");
        }
        // Caso 3: Nó tem dois filhos
        else {
            No sucessor = obterSucessor(atual);

            if (atual == raiz) {
                raiz = sucessor;
            } else if (isEsquerda) {
                pai.setEsq(sucessor);
            } else {
                pai.setDir(sucessor);
            }
            sucessor.setEsq(atual.getEsq());
            System.out.println("O nó removido tinha dois filhos.");
        }

        return true;
    }

    public No obterSucessor(No no) {
        No paiSucessor = no;
        No sucessor = no;
        No atual = no.getDir();

        while (atual != null) {
            paiSucessor = sucessor;
            sucessor = atual;
            atual = atual.getEsq();
        }

        if (sucessor != no.getDir()) {
            paiSucessor.setEsq(sucessor.getDir());
            sucessor.setDir(no.getDir());
        }
        return sucessor;
    }
}

