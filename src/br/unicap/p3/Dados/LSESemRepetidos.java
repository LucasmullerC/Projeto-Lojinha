package br.unicap.p3.Dados;

public class LSESemRepetidos<T extends Comparable<T>> {

    private LSENode<T> inicio;
    private LSENode<T> fim;
    private int qtd;

    public boolean isEmpty() {
        if (this.inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void inserirNoInicio(T obj) {
        LSENode<T> novo, aux;
        novo = new LSENode(obj);
        if (this.isEmpty() == true) {
            this.inicio = novo;
            this.fim = novo;
            this.qtd++;
        } else {
            aux = this.buscaSimples(obj);
            if (aux == null) {
                novo.setProx(this.inicio);
                this.inicio = novo;
                this.qtd++;
            } else {
                System.out.println("Valor repetido!");
            }
        }
    }

    private LSENode<T> buscaSimples(T obj) {
        LSENode<T> aux = this.inicio;
        while (aux != null) {
            if (aux.getInfo().compareTo(obj) == 0) {
                return aux;
            }
            aux = aux.getProx();
        }
        return null;
    }

    public void inserirNoFinal(T obj) {
        LSENode<T> novo, aux;
        novo = new LSENode(obj);
        if (this.isEmpty() == true) {
            this.inicio = novo;
            this.fim = novo;
        } else {
            aux = this.buscaSimples(obj);
            if (aux == null) {
                this.fim.setProx(novo);
                this.fim = novo;
            } else {
                System.out.println("Valor repetido!");
            }
        }
        this.qtd++;
    }

    public void inserirOrdenado(T obj) {
        LSENode<T> novo = new LSENode(obj);
        LSENode<T> pos, anterior = null, atual;
        if (this.isEmpty() == true) {
            this.inicio = novo;
            this.fim = novo;
            this.qtd++;
            System.out.println("Cadastro efetuado");
        } else {
            if (obj.compareTo(this.inicio.getInfo()) < 0) {
                novo.setProx(this.inicio);
                this.inicio = novo;
                this.qtd++;
                System.out.println("Cadastro efetuado");
            } else if (obj.compareTo(this.fim.getInfo()) > 0) {
                this.fim.setProx(novo);
                this.fim = novo;
                this.qtd++;
                System.out.println("Cadastro efetuado");
            } else {
                atual = this.inicio;
                while (true) {
                    if (atual.getInfo().compareTo(obj) == 0) {
                        System.out.println("Valor repetido! Inserção não efetuada");
                        return;
                    } else if (atual.getInfo().compareTo(obj) > 0) {
                        anterior.setProx(novo);
                        novo.setProx(atual);
                        this.qtd++;
                        System.out.println("Cadastro efetuado");
                        return;
                    } else {
                        anterior = atual;
                        atual = atual.getProx();
                    }
                }
            }
        }
    }

    public void Remover(T obj) {
        LSENode<T> aux, anterior, atual;
        if (this.isEmpty() == true) {
            System.out.println("Lista está vazia");
        } else if (this.inicio.getInfo().compareTo(obj) == 0) {
            if (this.qtd == 1) {
                this.inicio = null;
                this.fim = null;
            } else {
                this.inicio = this.inicio.getProx();
            }
            this.qtd--;
            System.out.println("Remoção efetuada!");
        } else if (this.fim.getInfo().compareTo(obj) == 0) {
            aux = this.inicio;
            while (aux.getProx() != this.fim) {
                aux = aux.getProx();
            }
            aux.setProx(null);
            this.fim = aux;
            this.qtd--;
            System.out.println("Remoção efetuada!");
        } else {
            anterior = this.inicio;
            atual = anterior.getProx();
            while (atual != null) {
                if (atual.getInfo().compareTo(obj) == 0) {
                    anterior.setProx(atual.getProx());
                    this.qtd--;
                    System.out.println("Remoção efetuada!");
                    return;
                }
                anterior = anterior.getProx();
                atual = atual.getProx();
            }
            System.out.println("Elemento não encontrado!");
        }
    }

    public void exibirDado(T obj) {
        LSENode<T> aux;
        aux = buscaSimples(obj);
        if (aux == null) {
            System.out.println("Valor não encontrado.");
        } else {
            System.out.println(aux.getInfo());
        }
    }

    public T BuscarObjeto(T obj) {
        LSENode<T> aux;
        aux = this.inicio;
        if (this.isEmpty() == true) {
            return null;
        } else {
            while (aux != null) {
                if (obj.compareTo(aux.getInfo()) == 0) {
                    return aux.getInfo();
                }
                aux = aux.getProx();
            }
            return null;
        }
    }

    public void exibirTodos() {
        LSENode<T> aux;
        aux = this.inicio;
        while (aux != null) {
            System.out.print(aux.getInfo() + " ");
            aux = aux.getProx();
        }
        System.out.println();
    }

    public T EnviarObjeto() {
        LSENode<T> aux = this.inicio;
        if (isEmpty() == true) {
            System.out.println("Lista Vazia!");
            return null;
        } else if (aux.getProx() == null) {
            this.inicio = null;
            this.fim = null;
            this.qtd = 0;
        } else {
            this.inicio = this.inicio.getProx();
            this.qtd--;
        }
        return aux.getInfo();
    }
}