package de.kaimon.schoolproject.simon.implementations.dynamisch;

public class ArrayList<c> extends List<c> {

    private c[] listArray = (c[]) new Object[2];
    private int length = 0;

    @Override
    public int getLenght() {
        return this.length;
    }

    @Override
    public c get(int index) {
        if (index >= this.length) throw new IndexOutOfBoundsException();
        return this.listArray[index];
    }

    @Override
    public void add(c contend) {
        this.listArray[this.length] = contend;
        this.length++;
        this.expandArray();
    }

    @Override
    public void remove(c contend) {
        boolean found = false;
        for (int i = 0; i < this.length; i++) {
            if (!found) {
                if (this.listArray[i] != contend) continue;
                else found = true;
            }
            listArray[i] = listArray[i + 1];
        }
        if (found) this.length--;
        reduceArray();
    }

    @Override
    public void remove(int index) {
        if (index >= this.length) throw new IndexOutOfBoundsException();
        boolean found = false;
        for (int i = 0; i < this.length + 1; i++) {
            if (!found) {
                if (i < index) continue;
                else found = true;
            }
            listArray[i] = listArray[i + 1];
        }
        if (found) this.length--;
        reduceArray();
    }

    private void expandArray() {
        if (this.length >= this.listArray.length) {
            c[] temp = (c[]) new Object[this.listArray.length * 2];
            for (int i = 0; i < this.listArray.length; i++) temp[i] = this.listArray[i];
            this.listArray = temp;
        }
    }

    private void reduceArray() {
        if (this.length < this.listArray.length / 4) {
            c[] temp = (c[]) new Object[this.listArray.length / 2];
            for (int i = 0; i < this.listArray.length; i++) temp[i] = this.listArray[i];
            this.listArray = temp;
        }
    }
}
