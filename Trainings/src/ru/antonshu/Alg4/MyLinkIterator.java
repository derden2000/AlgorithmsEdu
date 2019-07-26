package ru.antonshu.Alg4;

public class MyLinkIterator<Item> {

    private Link currentLink;
    private Link previousLink;
    private MyLinkedList<Item> list;

    public MyLinkIterator(MyLinkedList list){
        this.list = list;
        this.reset();
    }

    public void reset() {
        currentLink = list.getFirstLink();
        previousLink = null;
    }

    public boolean atEnd(){
        return (currentLink.getNextLink() == null);
    }

    public void nextLink(){
        previousLink = currentLink;
        currentLink = currentLink.getNextLink();
    }

    public Link getCurrentLink(){
        return currentLink;
    }

    public void insertAfter(Item item){
        Link newLink = new Link(item);
        if (list.isEmpty()){
            list.insertFirstElement(item);
            currentLink = newLink;
        } else {
            newLink.setNextLink(currentLink.getNextLink());
            currentLink.setNextLink(newLink);
            nextLink();
        }
    }

    public void insertBefore(Item item){
        Link newLink = new Link(item);
        if(previousLink == null){
            newLink.setNextLink((Link) list.getFirstElement());
            list.insertFirstElement(item);
            reset();
        } else {
            newLink.setNextLink(previousLink.getNextLink());
            previousLink.setNextLink(newLink);
            currentLink = newLink;
        }
    }

    public Item deleteCurrent() {
        Item item = (Item) currentLink.getLinkValue();
        if (previousLink == null) {
            Item buf = (Item) currentLink.getNextLink().getLinkValue();
            list.insertFirstElement(buf);
            reset();
        } else {
            previousLink.setNextLink(currentLink.getNextLink());
            if (atEnd()){
                reset();
            } else {
                currentLink = currentLink.getNextLink();
            }
        }

        return item;
    }

}
