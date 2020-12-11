package br.unicap.p3.Controle;

public class SaveLogin {
	private String state;

	public void set(String state) {
		this.state = state;
	}

	public Memento saveToMemento() {
		return new Memento(state);
	}

	public void restoreFromMemento(Memento memento) {
		state = memento.getSavedState();
	}

	public static class Memento {
		private final String state;

		private Memento(String stateToSave) {
			state = stateToSave;
		}

		private String getSavedState() {
			return state;
		}
	}
}
