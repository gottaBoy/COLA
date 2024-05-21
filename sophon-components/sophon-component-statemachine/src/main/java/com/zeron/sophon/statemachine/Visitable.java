package com.zeron.sophon.statemachine;

/**
 * Visitable
 */
public interface Visitable {
    String accept(final Visitor visitor);
}
