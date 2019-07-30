package ru.antonshu.Alg4;

public class MyLinkedList<Element> {

    private Link firstElement;
    private int size = 0;

    public MyLinkedList() {
        this.firstElement = null;
    }

    public boolean isEmpty() {
        return firstElement == null;
    }

    public int size() {
        return size;
    }

    public Element getFirstElement() {
        return (Element) firstElement.getLinkValue();
    }

    public Link getFirstLink() {
        return firstElement;
    }

    public void insertFirstElement(Element element) {
        Link newLink = new Link(element);
        newLink.setNextLink(firstElement);
        firstElement = newLink;
        size++;
    }

    public Element removeFirstElement() {
        if (isEmpty()) {
            return null;
        }
        Link oldFirst = firstElement;
        firstElement = firstElement.getNextLink();
        size--;
        return (Element) oldFirst.getLinkValue();
    }

    public int indexOf(Element element) {
        Link currentElement = firstElement;
        int index = 0;
        while (currentElement != null) {
            if (element.equals(currentElement.getLinkValue())) {
                return index;
            }
            currentElement = currentElement.getNextLink();
            index++;
        }
        return -1;
    }

    public boolean contains(Element element) {
        return indexOf(element) > -1;
    }

    public void insert(int index, Element element) {
        if (index <= 0) {
            insertFirstElement(element);
            return;
        }
        Link currentElement = firstElement;
        int i = 0;
        if (index > size) {
            index = size;
        }
        while(i < index-1){
            currentElement = currentElement.getNextLink();
            i++;
        }
        Link newLink = new Link(element);
        newLink.setNextLink(currentElement.getNextLink());
        currentElement.setNextLink(newLink);
        size++;
    }

    public boolean remove(Element element){
        if(isEmpty()){
            return false;
        }
        if(firstElement.getLinkValue().equals(element)){
            removeFirstElement();
            return true;
        }
        Link currentElement = firstElement;
        while (currentElement.getNextLink()!= null &&
                !currentElement.getNextLink().getLinkValue().equals(element)){
            currentElement = currentElement.getNextLink();
        }
        if(currentElement.getNextLink() == null){
            return false;
        }
        currentElement.setNextLink(currentElement.getNextLink().getNextLink());
        size--;
        return true;
    }

    @Override
    public String toString() {
    Link current = firstElement;
    StringBuilder builder = new StringBuilder();
    builder.setLength(0);
    builder.append("[");
    if (!isEmpty()) {
        while (current != null) {
            builder.append(current.getLinkValue() + ", ");
            current = current.getNextLink();
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.deleteCharAt(builder.length() - 1);
    }
    builder.append("]");
    return builder.toString();
    }

    public static void main(String[] args) {
        MyLinkedList<String> sample = new MyLinkedList<>();
        sample.insertFirstElement("Sasha");
        sample.insertFirstElement("Masha");
        sample.insertFirstElement("Ivan");
        sample.insertFirstElement("Petr");
        sample.insertFirstElement("Vasya");
        MyLinkIterator iterator = new MyLinkIterator(sample);
        System.out.println(sample);
        iterator.insertAfter("Anton");
        iterator.insertBefore("Dima");
        System.out.println(sample);
        iterator.deleteCurrent();
        System.out.println(sample);
    }
}