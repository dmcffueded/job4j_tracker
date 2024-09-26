package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        int size = evenElements.size();
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < size; i++) {
            Character element = evenElements.pollFirst();
            if (i % 2 == 0) {
                string.append(element);
            }
        }
        return string.toString();
    }

    private String getDescendingElements() {
        int size = descendingElements.size();
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < size; i++) {
            string.append(descendingElements.pollLast());
        }
        return string.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}