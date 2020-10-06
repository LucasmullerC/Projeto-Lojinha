package br.unicap.p3.Dados;
public class ListadoProduto<T extends Comparable<T>> {
	private LSENode<T> inicio;
	private LSENode<T> fim;
	private int qtd;

	public boolean isEmpty() {
		if (this.qtd == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void Cadastrar(T obj) {
		LSENode<T> novo = new LSENode(obj);
		LSENode<T> anterior = null, atual;
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

	public void ExibirTodos() {
		LSENode<T> aux;
		aux = this.inicio;
		while (aux != null) {
			System.out.println(aux.getInfo());
			aux = aux.getProx();
		}
	}

	private LSENode<T> BuscaMelhorada(T obj) { // busca sequencial melhorada
		LSENode<T> aux;
		aux = this.inicio;
		if (this.isEmpty() == true) {
			return null;
		} else {
			while (aux != null) {
				if (obj.compareTo(aux.getInfo()) == 0) {
					return aux;
				} else if (aux.getInfo().compareTo(obj) > 0) {
					return aux;
				}
				aux = aux.getProx();
			}
			return null;
		}
	}

	public void ExibirUm(T obj) {
		LSENode<T> aux;

		aux = this.BuscaMelhorada(obj);
		if (aux == null) {
			System.out.println("Produto não encontrado");
		} else {
			System.out.println(aux.getInfo());
		}
	}

	public T AlterarValor(T obj) { // busca sequencia melhorada que procura o objeto para alterar
		LSENode<T> aux;
		aux = this.inicio;
		if (this.isEmpty() == true) {
			return null;
		} else {
			while (aux != null) {
				if (obj.compareTo(aux.getInfo()) == 0) {
					return aux.getInfo();
				} else if (aux.getInfo().compareTo(obj) > 0) {
					return aux.getInfo();
				}
				aux = aux.getProx();
			}
			return null;
		}
	}
}