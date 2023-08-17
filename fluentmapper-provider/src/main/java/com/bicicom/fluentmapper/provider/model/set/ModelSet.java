package com.bicicom.fluentmapper.provider.model.set;

import java.util.HashSet;

/**
 * A set implementation, which on addition, replaces an object if it already
 * exists inside. This should be refactored once the model classes are self written and
 * their API isn't generated from JAXB.
 *
 * @param <E>
 */
public class ModelSet<E> extends HashSet<E> {

    @Override
    public boolean add(E element) {
        if (this.contains(element)) {
            this.remove(element);
            return super.add(element);
        }
        return super.add(element);
    }

}
