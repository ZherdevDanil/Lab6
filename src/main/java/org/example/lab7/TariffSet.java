package org.example.lab7;

import org.example.Tariff;
import org.example.exception.TariffException;

import java.util.*;

public class TariffSet implements Set<Tariff> {

    public class Node{
        private Tariff tariff;
        private Node next;

        private Node prev;

        public Node(Tariff tariff) {
            this.tariff = tariff;
            this.next = null;
            this.prev = null;
        }

        public Tariff getTariff() {
            return tariff;
        }

        public void setTariff(Tariff tariff) {
            this.tariff = tariff;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

    private Node head;
    private Node tail;

    private int size;




    public TariffSet() {
        this.head=null;
        this.tail=null;
        this.size=0;
    }

    public TariffSet(Tariff tariff){
        this.head = new Node(tariff);
        this.tail = this.head;
        this.size=1;
    }

    public TariffSet(Collection<Tariff> tariffs) {
        this();
        addAll(tariffs);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (Node current = head; current != null; current = current.getNext()) {
                if (current.getTariff() == null) {
                    return true;
                }
            }
        } else {
            for (Node current = head; current != null; current = current.getNext()) {
                if (o.equals(current.getTariff())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator<Tariff> iterator() {
        return new Iterator<Tariff>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Tariff next() {
                if (!hasNext()) {
                    throw new UnsupportedOperationException("No more elements in the set");
                }
                Tariff tariff = current.getTariff();
                current = current.getNext();
                return tariff;
            }

            @Override
            public void remove() {

                if (current == null) {
                    throw new TariffException("Tariff can't be removed before next()");
                }

                Node prev = current.getPrev();
                Node next = current.getNext();

                if (prev == null) {
                    head = next;
                } else {
                    prev.setNext(next);
                    current.setPrev(null);
                }

                if (next == null) {
                    tail = prev;
                } else {
                    next.setPrev(prev);
                    current.setNext(null);
                }

                Node oldCurrent = current;
                current = next;
                oldCurrent.setNext(null);
                oldCurrent.setPrev(null);

                size--;
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        for (Node current = head; current != null; current = current.getNext()) {
            array[index++] = current.getTariff();
        }
        return array;

    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            return (T[]) toArray();
        } else {
            int index = 0;
            for (Node current = head; current != null; current = current.getNext()) {
                a[index++] = (T) current.getTariff();
            }
            return a;
        }
    }

    @Override
    public boolean add(Tariff tariff) {
        if(tariff == null){
            throw new TariffException("Tariff can't be NULL");
        }
        if (!contains(tariff)){
            Node newNode = new Node(tariff);
            if (isEmpty()){
                this.head=newNode;
                this.tail=newNode;
            }else {
                this.tail.setNext(newNode);
                newNode.setPrev(tail);
                tail = newNode;
            }
            size++;
            return true;
        }else {
            return false;
        }

    }

    @Override
    public boolean remove(Object o) {
        if(o == null){
            throw new TariffException("Can't remove NULL object");
        }
        for(Node current=head; current!=null ;current = current.getNext()){
            if (o.equals(current.getTariff())){
                unlink(current);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object obj:c){
            if (!contains(obj)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Tariff> c) {
        if (c.isEmpty()){
            throw new TariffException("Collection is empty");
        }
        boolean isModified = false;
        for (Tariff tariff : c) {
            if (add(tariff)) {
                isModified = true;
            }
        }
        return isModified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        List <Tariff> retainedElements = new ArrayList<>();
        for (Node current = head; current != null; current = current.getNext()) {
            if (c.contains(current.getTariff())) {
                retainedElements.add(current.getTariff());
            }
        }

        boolean modified = size != retainedElements.size();

        clear();
        addAll(retainedElements);

        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object element : c) {
            modified |= remove(element);
        }
        return modified;
    }

    @Override
    public void clear() {
        head=null;
        tail=null;
        size=0;
    }

    public void unlink(Node node){
        Node next = node.next;
        Node prev = node.prev;

        if (prev == null) {
            head = next;
        } else {
            prev.setNext(next);
            node.setPrev(null);
        }

        if (next == null) {
            tail = prev;
        } else {
            next.setPrev(prev);
            node.setNext(null);
        }
        size--;
    }


}
