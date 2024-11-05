package it.unibo.inner.impl;

import java.util.Iterator;
import java.util.List;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T> {

    private final List<T> items;
    private Predicate<T> filter;

    public IterableWithPolicyImpl(final T[] array, final Predicate<T> filter) {
        items = List.of(array);
        this.filter = filter;
    }

    public IterableWithPolicyImpl(final T[] array) {
        this(array, new Predicate<T>() {

            @Override
            public boolean test(T elem) {
                return true;
            }

        });
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomIterator();
    }

    @Override
    public void setIterationPolicy(Predicate<T> filter) {
        this.filter = filter;
    }

    private class CustomIterator implements Iterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            while (index < items.size()) {
                if (filter.test(items.get(index))) {
                    return true;
                }
                index++;
            }
            return false;
        }

        @Override
        public T next() {
            return items.get(index++);
        }

    }

}
