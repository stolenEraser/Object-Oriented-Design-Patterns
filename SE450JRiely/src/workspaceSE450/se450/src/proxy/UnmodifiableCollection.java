package proxy;
import java.util.Collection;
import java.util.Iterator;
import java.io.Serializable;

@SuppressWarnings("serial")
class UnmodifiableCollection<E> implements Collection<E>, Serializable {
	Collection<E> c;

	UnmodifiableCollection(Collection<E> c) {
		if (c==null)
			throw new NullPointerException();
		this.c = c;
	}

	public int      size()                       {return c.size();}
	public boolean  isEmpty()                    {return c.isEmpty();}
	public boolean  contains(Object o)           {return c.contains(o);}
	public Object[] toArray()                    {return c.toArray();}
	public <T> T[]  toArray(T[] a)               {return c.toArray(a);}
	public String   toString()                   {return c.toString();}
	public boolean  containsAll(Collection<?> d) {return c.containsAll(d);}

	public Iterator<E> iterator() {
		return new Iterator<E>() {
			Iterator<E> i = UnmodifiableCollection.this.c.iterator();

			public boolean hasNext() {return i.hasNext();}
			public E next()          {return i.next();}
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	public boolean add(Object o){
		throw new UnsupportedOperationException();
	}
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}
	public boolean addAll(Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}
	public void clear() {
		throw new UnsupportedOperationException();
	}
}
