package ru.antonshu.Alg4;

import java.util.Iterator;

public class MyDoubleSideLinkedList<Element> implements Iterable<Element> {

    private DoubleSideLink firstElement;
    private DoubleSideLink lastElement;
    private int size = 0;

    public MyDoubleSideLinkedList() {
        this.firstElement = null;
        this.lastElement = null;
    }

    private class DoubleSideLink<Item> {
        private Item value;
        private DoubleSideLink nextDoubleSideLink;
        private DoubleSideLink previousDoubleSideLink;

        public DoubleSideLink(Item value, DoubleSideLink nextDoubleSideLink) {
            this.value = value;
            this.nextDoubleSideLink = nextDoubleSideLink;
        }

        public DoubleSideLink(Item value) {
            this.value = value;
        }

        public Item getValue() {
            return value;
        }

        public DoubleSideLink getNextDoubleSideLink() {
            return nextDoubleSideLink;
        }

        public void setValue(Item value) {
            this.value = value;
        }

        public void setNextDoubleSideLink(DoubleSideLink nextDoubleSideLink) {
            this.nextDoubleSideLink = nextDoubleSideLink;
        }

        public DoubleSideLink getPreviousDoubleSideLink() {
            return previousDoubleSideLink;
        }

        public void setPreviousDoubleSideLink(DoubleSideLink previousDoubleSideLink) {
            this.previousDoubleSideLink = previousDoubleSideLink;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    public boolean isEmpty() {
        return firstElement == null;
    }

    public int size() {
        return size;
    }

    public Element getFirstElement() {
        return (Element) firstElement.getValue();
    }

    public Element getLastElement() {
        return (Element) lastElement.getValue();
    }

    public void insertFirstPlace(Element element) {
        DoubleSideLink newDoubleSideLink = new DoubleSideLink(element);
        newDoubleSideLink.setNextDoubleSideLink(firstElement);
        if (!isEmpty()) {
            firstElement.setPreviousDoubleSideLink(newDoubleSideLink);
        } else {
            lastElement = newDoubleSideLink;
        }
        firstElement = newDoubleSideLink;
        size++;
    }

    public void insertLastPlace(Element element) {
        DoubleSideLink newDoubleSideLink = new DoubleSideLink(element);
        if (!isEmpty()) {
            newDoubleSideLink.setPreviousDoubleSideLink(lastElement);
            lastElement.setNextDoubleSideLink(newDoubleSideLink);
        } else {
            firstElement = newDoubleSideLink;
        }
        lastElement = newDoubleSideLink;
        size++;
    }

    public Element removeFirstElement() {
        if (isEmpty()) {
            return null;
        }
        DoubleSideLink oldFirst = firstElement;
        firstElement = firstElement.getNextDoubleSideLink();
        if (isEmpty()) {
            lastElement = null;
        } else {
            firstElement.setPreviousDoubleSideLink(null);
        }
        size--;
        return (Element) oldFirst.getValue();
    }

    public Element removeLastElement() {
        if (isEmpty()) {
            return null;
        }
        DoubleSideLink oldLast = lastElement;
        if (lastElement.getPreviousDoubleSideLink() != null) {
            lastElement.getPreviousDoubleSideLink().setNextDoubleSideLink(null);
        } else {
            firstElement = null;
        }
        lastElement = lastElement.getPreviousDoubleSideLink();
        size--;
        return (Element) oldLast.getValue();
    }


    public int indexOf(Element element) {
        DoubleSideLink currentElement = firstElement;
        int index = 0;
        while (currentElement != null) {
            if (element.equals(currentElement.getValue())) {
                return index;
            }
            currentElement = currentElement.getNextDoubleSideLink();
            index++;
        }
        return -1;
    }

    public boolean contains(Element element) {
        return indexOf(element) > -1;
    }

    public boolean removeElement(Element element) {
        if (isEmpty()) {
            return false;
        }
        if (firstElement.getValue().equals(element)) {
            removeFirstElement();
            return true;
        }
        DoubleSideLink currentElement = firstElement;
        while (currentElement != null &&
                !currentElement.getValue().equals(element)) {
            currentElement = currentElement.getNextDoubleSideLink();
        }
        if (currentElement.getNextDoubleSideLink() == null) {
            return false;
        }
        if(currentElement == lastElement) {
            removeLastElement();
            return true;
        }
        DoubleSideLink previous = currentElement.getPreviousDoubleSideLink();
        DoubleSideLink next = currentElement.getNextDoubleSideLink();
        previous.setNextDoubleSideLink(next);
        currentElement = next;
        currentElement.setPreviousDoubleSideLink(previous);
        size--;
        return true;
    }

    @Override
    public String toString() {
        DoubleSideLink currentElement = firstElement;
        StringBuilder builder = new StringBuilder();
        builder.setLength(0);
        builder.append("[");
        if (!isEmpty()) {
            while (currentElement != null) {
                builder.append(currentElement.getValue() + ", ");
                currentElement = currentElement.getNextDoubleSideLink();
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.deleteCharAt(builder.length() - 1);
        }
        builder.append("]");
        return builder.toString();
    }

    @Override
    public Iterator<Element> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<Element>{
        DoubleSideLink currentElementOfIterator = new DoubleSideLink(null, firstElement);

        @Override
        public boolean hasNext() {
            return currentElementOfIterator.getNextDoubleSideLink() != null;
        }

        @Override
        public Element next() {
            if (!currentElementOfIterator.getNextDoubleSideLink().equals(null)) {
                currentElementOfIterator = currentElementOfIterator.getNextDoubleSideLink();
                return (Element) currentElementOfIterator.getValue();
            } else {
                return null;
            }
        }

        @Override
        public void remove() {
            removeElement((Element) currentElementOfIterator.getValue());
        }
    }

    public static void main(String[] args) {
        MyDoubleSideLinkedList<String> sample = new MyDoubleSideLinkedList<>();

        sample.insertLastPlace("Sasha");
        sample.insertLastPlace("Masha");
        sample.insertLastPlace("Ivan");
        sample.insertLastPlace("Petr");
        sample.insertLastPlace("Ivan");
        sample.insertLastPlace("Vasya");
        sample.insertLastPlace("Ivan");
        sample.insertLastPlace("Ivan");
        sample.insertLastPlace("Ivan");
        sample.insertLastPlace("Ivan");
        sample.insertFirstPlace("Ivan");
        System.out.println(sample);
        System.out.println("sample.contains(Ivan)" + sample.contains("Ivan"));
        System.out.println("sample.size()" + sample.size());
        System.out.println("sample.getFirstElement()" + sample.getFirstElement());
        System.out.println("sample.getLastElement()" + sample.getLastElement());
        System.out.println("sample.removeElement(Vasya)" + sample.removeElement("Vasya"));
        System.out.println("sample.removeLastElement()" + sample.removeLastElement());
        System.out.println("sample.indexOf(Petr)" + sample.indexOf("Petr"));
        System.out.println(sample);

        Iterator<String> iterator = sample.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals("Ivan")) {
                iterator.remove();
            }
        }
        System.out.println(sample);
    }
}