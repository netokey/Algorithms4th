import java.util.Iterator;

public class RandomBag<Item> implements Iterable<Item> {
    private Node first;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return first == null;
    }

    private class Node {
        Item item;
        Node next;
    }

    public void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        size++;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Item[] a;
        private int index;

        public ListIterator() {
            a = (Item[]) new Object[size];
            Node current = first;
            int i = 0;
            while (current.next != null) {
                a[i] = current.item;
                i++;
            }
            StdRandom.shuffle(a);
            index = 0;
        }

        public boolean hasNext() {
            return index < a.length;
        }

        public void remove() {
        }

        public Item next() {
            Item ret = a[index];
            index++;
            return ret;
        }
    }
}
