package ru.antonshu.Alg4;

public class Link<Item> {

    private Item value;
    private Link nextLink;

    public Link(Item value) {
        this.value = value;
    }

    public Item getLinkValue() {
        return value;
    }

    public Link getNextLink() {
        return nextLink;
    }

    public void setLinkValue(Item value) {
        this.value = value;
    }

    public void setNextLink(Link next) {
        this.nextLink = next;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
