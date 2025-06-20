package arvore;

import dados.Produto;

public class ArvoreProdutos {
    private No raiz;
    private int quantNos;

    public ArvoreProdutos() {
        this.raiz = null;
        this.quantNos = 0;
    }

    public boolean eVazia() {
        return (this.raiz == null);
    }

    public No getRaiz() {
        return this.raiz;
    }

    public int getQuantNos() {
        return this.quantNos;
    }

    // inserir um novo nó na arvore. Sempre insere em um atributo que seja igual a
    // null

    public boolean inserir(Produto elem) {
        if (pesquisar(elem.getNome())) {
            return true;
        } else {
            this.raiz = inserir(elem, this.raiz);
            this.quantNos++;
            return true;
        }
    }

    public No inserir(Produto elem, No no) {
        if (no == null) {
            No novo = new No(elem);
            return novo;
        } else {
            if (elem.getNome().compareToIgnoreCase(no.getInfo().getNome()) < 0) {
                no.setEsq(inserir(elem, no.getEsq()));
            } else {
                no.setDir(inserir(elem, no.getDir()));
            }
            return no;
        }
    }

    // Pesquisa se um determinado valor está na árvore

    public boolean pesquisar(String nome) {
        if (pesquisar(nome, this.raiz) != null) {
            return true;
        } else {
            return false;
        }
    }

    private No pesquisar(String nome, No no) {
        if (no != null) {
            if (nome.compareToIgnoreCase(no.getInfo().getNome()) < 0) {
                no = pesquisar(nome, no.getEsq());
            } else {
                if (nome.compareToIgnoreCase(no.getInfo().getNome()) > 0) {
                    no = pesquisar(nome, no.getDir());
                }
            }
        }
        return no;
    }

    // remove um determinado nó procurando pela chave. O nó pode estar em qualquer
    // posição na árvore

    public boolean remover(String nome) {
        if (pesquisar(nome, this.raiz) != null) {
            this.raiz = remover(nome, this.raiz);
            this.quantNos--;
            return true;
        } else {
            return false;
        }
    }

    private No remover(String nome, No no) {
        if (nome.compareToIgnoreCase(no.getInfo().getNome()) < 0) {
            no.setEsq(remover(nome, no.getEsq()));
        } else {
            if (nome.compareToIgnoreCase(no.getInfo().getNome()) > 0) {
                no.setDir(remover(nome, no.getDir()));
            } else {
                if (no.getDir() == null) {
                    return no.getEsq();
                } else {
                    if (no.getEsq() == null) {
                        return no.getDir();
                    } else {
                        no.setEsq(Arrumar(no, no.getEsq()));
                    }
                }
            }
        }
        return no;
    }

    private No Arrumar(No no, No maior) {
        if (maior.getDir() != null) {
            maior.setDir(Arrumar(no, maior.getDir()));
        } else {
            no.setInfo(maior.getInfo());
            maior = maior.getEsq();
        }
        return maior;
    }

    public void listar() {
        listarEmOrdem(this.raiz);
    }

    private void listarEmOrdem(No no) {
        if (no != null) {
            listarEmOrdem(no.getEsq());
            System.out.println(no.getInfo());
            listarEmOrdem(no.getDir());
        }
    }

    public void buscarProduto(String nome) {
        No resultado = pesquisar(nome, this.raiz);
        if (resultado != null) {
            System.out.println(resultado.getInfo());
        }
    }

     public boolean verificarExistencia(Produto elem) {
    // já existe? —> não insere
    if (pesquisar(elem.getNome())) {
        return false;
    }
    // não existe —> insere
    this.raiz = inserir(elem, this.raiz);
    this.quantNos++;
    return true;
}

}
