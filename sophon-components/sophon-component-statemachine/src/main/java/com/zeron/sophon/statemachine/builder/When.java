package com.zeron.sophon.statemachine.builder;

import com.zeron.sophon.statemachine.Action;

/**
 * When
 *
 */
public interface When<S, E, C>{
    /**
     * Define action to be performed during transition
     *
     * @param action performed action
     */
    void perform(Action<S, E, C> action);
}
