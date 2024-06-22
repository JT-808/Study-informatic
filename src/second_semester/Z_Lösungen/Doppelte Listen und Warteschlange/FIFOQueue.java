import java.util.NoSuchElementException;

/**
 * 
 * einfache Implementierung einer (F)irst(I)n(F)irst(O)ut Warteschlange
 * 
 * @author Knut Altroggen
 *
 * @param <E>
 */
public class FIFOQueue<E> {

	private DoppelteListe<E> queue;

	public FIFOQueue() {
		queue = new DoppelteListe<E>();
	}

	public E element() throws NoSuchElementException {
		if (queue.isEmpty()) {
			throw new NoSuchElementException("Warteschlange leer");
		}
		return queue.getFirst();
	}

	public E peek() {
		if (queue.isEmpty()) {
			return null;
		}

		return queue.getFirst();
	}

	public boolean add(E data) {
		queue.addLast(data);
		return true;
	}

	public boolean offer(E data) {
		queue.addLast(data);
		return true;
	}

	public E remove() throws NoSuchElementException {
		if (queue.isEmpty()) {
			throw new NoSuchElementException("Warteschlange leer");
		}
		return queue.removeFirst();
	}

	public E poll() {
		if (queue.isEmpty()) {
			return null;
		}

		return queue.removeFirst();
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public String toString() {
		return queue.toString();
	}
}
