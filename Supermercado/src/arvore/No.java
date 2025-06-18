package arvore;

import dados.Produto;

public class No {
    private Produto info;
    private No dir, esq;

    public No(Produto elem) {
        this.info = elem;
        this.dir = null;
        this.esq = null;
    }

    public Produto getInfo() {
        return this.info;
    }

    public void setInfo(Produto elem) {
        this.info = elem;
    }

    public No getDir() {
        return this.dir;
    }

    public void setDir(No dir) {
        this.dir = dir;
    }

    public No getEsq() {
        return this.esq;
    }

    public void setEsq(No esq) {
        this.esq = esq;
    }

}
