package ru.surf.transitions.delayed_transition.data;

import android.annotation.SuppressLint;
import android.transition.Fade;
import android.transition.Transition;

@SuppressLint("NewApi")
public enum TransitionType {
    FADE(new Fade(), "Fade");

    TransitionType(Transition transition, String name) {
        this.transition = transition;
        this.name = name;
    }

    private Transition transition;
    private String name;

    public Transition getTransition() {
        return transition;
    }

    public String getName() {
        return name;
    }
}
