package org.gr40in;

public class Fork implements Comparable<Fork> {

    public int numberOnTable;

    public Fork(int numberOnTable) {
        this.numberOnTable = numberOnTable;
    }

    @Override
    public String toString() {
        return "Fork " + numberOnTable;
    }

    @Override
    public int compareTo(Fork other) {
        return numberOnTable - other.numberOnTable;
    }
}
