package org.example.lab7;

import org.example.Tariff;
import org.example.exception.TariffException;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class TariffSet implements Set<Tariff> {

    private LinkedList<Tariff> tariffLinkedList;

    public TariffSet() {
        this.tariffLinkedList = new LinkedList<>();
    }

    public TariffSet(Tariff tariff){
        this();
        tariffLinkedList.add(tariff);
    }

    public TariffSet(Collection<Tariff> tariffs) {
        this();
        tariffLinkedList.addAll(tariffs);
    }

    @Override
    public int size() {
        return tariffLinkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return tariffLinkedList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return tariffLinkedList.contains(o);
    }

    @Override
    public Iterator<Tariff> iterator() {
        return tariffLinkedList.iterator();
    }

    @Override
    public Object[] toArray() {
        return tariffLinkedList.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return tariffLinkedList.toArray(a);
    }

    @Override
    public boolean add(Tariff tariff) {
        if (tariff == null){
            throw new TariffException("Tariff can't be null");
        }
        if (tariffLinkedList.contains(tariff)){
            return false;
        }
        return tariffLinkedList.add(tariff);
    }

    @Override
    public boolean remove(Object o) {
        return tariffLinkedList.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return tariffLinkedList.containsAll(c);
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
        return tariffLinkedList.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return tariffLinkedList.removeAll(c);
    }

    @Override
    public void clear() {
        tariffLinkedList.clear();
    }
}
