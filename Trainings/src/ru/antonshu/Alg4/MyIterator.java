package ru.antonshu.Alg4;

import java.util.Iterator;
import java.util.ListIterator;

public class MyIterator<Item> {

    private Link current;
    private Link previous;
    private MyLinkedList<Item> list;

    public MyIterator(MyLinkedList<Item> list){
        this.list = list;
        this.reset();
    }

    public void reset(){
        current = (Link) list.getFirstElement();
        previous = null;
    }

    public boolean atEnd(){
        return (current.getNextLink() == null);
    }

    public void nextLink(){
        previous = current;
        current = current.getNextLink();
    }

    public Link getCurrent(){
        return current;
    }

    public void insertAfter(Item item){
        Link newLink = new Link(item);
        if (list.isEmpty()){
            list.insertFirstElement((Item) newLink.getLinkValue());
            current = newLink;
        } else {
            newLink.setNextLink(current.getNextLink());
            current.setNextLink(newLink);
            nextLink();
        }
    }

    public void insertBefore(Item item){
        Link newLink = new Link(item);
        if(previous == null){
            newLink.setNextLink((Link) list.getFirstElement());
            list.insertFirstElement((Item) newLink.getLinkValue());
            reset();
        }
        else{
            newLink.setNextLink(previous.getNextLink());
            previous.setNextLink(newLink);
            current = newLink;
        }
    }

    public Item deleteCurrent(){
        Item item = (Item) current.getLinkValue();
        if (previous == null) {
            list.insertFirstElement((Item) current.getNextLink());
            reset();
        } else {
            previous.setNextLink(current.getNextLink());
            if (atEnd()){
                reset();
            } else {
                current = current.getNextLink();
            }
        }

        return item;
    }

}
