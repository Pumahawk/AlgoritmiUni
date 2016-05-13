package AlberiDiRicerca;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Dictionary;
import java.util.Enumeration;

public class Albero<K, T> extends Dictionary<K, T> {
	private class Nodo {
		public K chiave;
		public T valore;
		public Nodo sinistra;
		public Nodo destra;

		public Nodo(K chiave, T valore, Nodo sinistra, Nodo destra) {
			this.chiave = chiave;
			this.valore = valore;
			this.sinistra = sinistra;
			this.destra = destra;
		}

		public Nodo(K chiave, T valore) {
			this(chiave, valore, null, null);
		}

	}

	private class Lista<P> implements Enumeration<P> {

		private class Nodo {
			private P valore;
			private Nodo next;

			public Nodo(P valore, Nodo next) {
				this.valore = valore;
				this.next = next;
			}

			public Nodo(P valore) {
				this(valore, null);
			}
		}

		private Nodo sentinella = new Nodo(null, null);
		private Nodo ultimo = sentinella;

		public void put(P val) {
			ultimo.next = new Nodo(val);
			ultimo = ultimo.next;
		}

		@Override
		public boolean hasMoreElements() {
			return (sentinella.next != null);
		}

		@Override
		public P nextElement() {
			P ret = sentinella.next.valore;
			sentinella.next = sentinella.next.next;
			return ret;
		}

	}

	private Comparator<K> comparator;
	private Nodo root;
	private int size;

	public Albero(Comparator<K> comp) {
		this.comparator = comp;
	}

	@Override
	public Enumeration<T> elements() {
		Lista<T> lista = new Lista<>();
		ArrayList<Nodo> nodi = new ArrayList<>();
		if (root != null) {
			Nodo p;
			nodi.add(root);
			for (int i = 0; i < nodi.size(); i++) {
				p = nodi.get(i);
				lista.put(p.valore);
				if (p.sinistra != null) {
					nodi.add(p.sinistra);
				}
				if (p.destra != null) {
					nodi.add(p.destra);
				}
			}
		}
		return lista;
	}

	@Override
	public T get(Object key) {
		K chiave = (K) key;
		if(key == null)
		    throw new NullPointerException();

		return null;
	}

	@Override
	public boolean isEmpty() {
		return (size() == 0) ? true : false;
	}

	@Override
	public Enumeration<K> keys() {
		Lista<K> lista = new Lista<>();
		ArrayList<Nodo> nodi = new ArrayList<>();
		if (root != null) {
			Nodo p;
			nodi.add(root);
			for (int i = 0; i < nodi.size(); i++) {
				p = nodi.get(i);
				lista.put(p.chiave);
				if (p.sinistra != null) {
					nodi.add(p.sinistra);
				}
				if (p.destra != null) {
					nodi.add(p.destra);
				}
			}
		}
		return lista;
	}

	@Override
	public T put(K key, T value) {
		Nodo nodo = new Nodo(key, value);
		T p = null;
		if (this.root == null) {
			this.root = nodo;
		} else
			p = inserimento(this.root, nodo);

		if (p == null)
			this.size++;
		return p;
	}

	private T inserimento(Nodo root, Nodo add) {
		if (comparator.compare(add.chiave, root.chiave) < 0) {
			if (root.sinistra != null)
				return inserimento(root.sinistra, add);
			else
				root.sinistra = add;
		} else if (comparator.compare(add.chiave, root.chiave) == 0) {
			T p = root.valore;
			root.valore = add.valore;
			return p;
		} else {
			if (root.destra != null)
				return inserimento(root.destra, add);
			else
				root.destra = add;
		}
		return null;
	}

	@Override
	public T remove(Object key) {
		T eliminato = null;
		if (this.root == null)
			return null;
		else
			eliminato = remove((K) key, root);
		if (eliminato != null)
			this.size--;
		return eliminato;
	}

	public T remove(K key, Nodo padre) {
		T ret = null;
		if (padre.sinistra != null)
			if (comparator.compare(padre.sinistra.chiave, key) == 0) {
				Nodo eliminato = padre.sinistra;
				padre.sinistra = eliminato.sinistra;
				if (padre.sinistra != null)
					inserimento(padre.sinistra, eliminato.destra);
				else
					padre.sinistra = eliminato.destra;
				ret = eliminato.valore;
			} else
				ret = remove(key, padre.sinistra);
		if (ret == null)
			if (padre.destra != null)
				if (comparator.compare(padre.destra.chiave, key) == 0) {
					Nodo eliminato = padre.destra;
					padre.destra = eliminato.sinistra;
					if (padre.destra != null)
						inserimento(padre.destra, eliminato.destra);
					else
						padre.destra = eliminato.destra;
					return eliminato.valore;
				} else
					return remove(key, padre.destra);
		return ret;
	}

	@Override
	public int size() {
		return size;
	}

	public T ricercaInAmpiezza(K ric, Nodo root) {
		if (root != null) {
			ArrayList<Nodo> nodi = new ArrayList<>();
			nodi.add(root);
			Nodo ritorno;
			for (int i = 0; i < nodi.size(); i++)
				if (comparator.compare((ritorno = nodi.get(i)).chiave, ric) == 0) {
					System.out.println("Chiave:" + ritorno.chiave + " Valore:" + ritorno.valore);
					return ritorno.valore;
				} else {
					if (ritorno.sinistra != null)
						nodi.add(ritorno.sinistra);
					if (ritorno.destra != null)
						nodi.add(ritorno.destra);
				}
		}
		return null;
	}

	public T stampa() {
		if (root != null) {
			ArrayList<Nodo> nodi = new ArrayList<>();
			nodi.add(root);
			Nodo ritorno;
			for (int i = 0; i < nodi.size(); i++) {
				ritorno = nodi.get(i);
				System.out.println("Chiave:" + ritorno.chiave + " Valore:" + ritorno.valore);
				if (ritorno.sinistra != null)
					nodi.add(ritorno.sinistra);
				if (ritorno.destra != null)
					nodi.add(ritorno.destra);
			}
		}
		return null;
	}

	public T ricercaInProfonditaPost() {
		// TODO
		return null;
	}

	public T ricercaInProfonditaIn(K ric, Nodo root) {
		if (root != null) {
			T val;
			if (comparator.compare(ric, root.chiave) == 0)
				return root.valore;
			if ((val = ricercaInProfonditaIn(ric, root.sinistra)) == null)
				return ricercaInProfonditaIn(ric, root.destra);
			else
				return val;
		} else
			return null;
	}
}
