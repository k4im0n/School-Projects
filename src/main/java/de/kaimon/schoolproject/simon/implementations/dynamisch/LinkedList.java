package de.kaimon.schoolproject.simon.implementations.dynamisch;

public class LinkedList<c> extends List<c> {

    private NodeObject firstNode = null;
    private NodeObject lastNode = null;

    private class NodeObject {

        private NodeObject previous;
        private NodeObject next;
        private c value;

        public NodeObject(NodeObject previous, NodeObject next, c value) {
            this.previous = previous;
            this.next = next;
            this.value = value;
        }

        public NodeObject getPrevious() {
            return previous;
        }

        public void setPrevious(NodeObject previous) {
            this.previous = previous;
        }

        public NodeObject getNext() {
            return next;
        }

        public void setNext(NodeObject next) {
            this.next = next;
        }

        public c getValue() {
            return value;
        }

        public void setValue(c value) {
            this.value = value;
        }
    }

    public int getLength() {
        return length;
    }

    @Override
    public c get(int index) {
        if (firstNode == null) throw new IndexOutOfBoundsException(index);
        if (index >= this.length) throw new IndexOutOfBoundsException(index);
        int currentIndex;
        NodeObject currentNode;
        if (length / 2 >= index) {
            currentIndex = 0;
            currentNode = firstNode;
            while (index > currentIndex) {
                currentNode = currentNode.getNext();
                currentIndex++;
                if (currentNode == null) throw new IndexOutOfBoundsException(currentIndex);
            }
        } else {
            currentIndex = length - 1;
            currentNode = lastNode;
            while (index < currentIndex) {
                currentNode = currentNode.getPrevious();
                currentIndex--;
                if (currentNode == null) throw new IndexOutOfBoundsException(currentIndex);
            }
        }
        return currentNode.getValue();
    }

    @Override
    public void add(c contend) {
        if (this.firstNode == null && this.lastNode == null) this.firstNode = new NodeObject(null, null, contend);
        else if (this.firstNode != null && this.lastNode == null) {
            this.lastNode = new NodeObject(firstNode, null, contend);
            this.firstNode.setNext(this.lastNode);
        } else this.lastNode.setNext(this.lastNode = new NodeObject(this.lastNode, null, contend));
        length++;
    }

    public void remove(c contend) {

    }

    public void remove(int index) {

    }
}
