package ru.antonshu.Alg6;

import java.util.NoSuchElementException;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    private Node root;
    private int treeLevel;
    private int hop;

    public int getTreeLevel() {
        return treeLevel;
    }

    public class Node {
        private Key key;
        private Value value;
        private Node leftChild;
        private Node rightChild;
        private int size;
        private int nodeLevel;

        Node(Key key, Value value, int nodeLevel) {
            this.key = key;
            this.value = value;
            this.nodeLevel = nodeLevel;
            size = 1;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private boolean isKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может быть null");
        }
        return true;
    }

    public boolean contains(Key key) {
        isKeyNotNull(key);
        return get(key) != null;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        isKeyNotNull(key);
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node.value;
        } else if (cmp < 0) {
            return get(node.leftChild, key);
        } else {
            return get(node.rightChild, key);
        }
    }

    public Node getNodeByKey(Key key) {
        return getNodeByKey(root, key);
    }

    private Node getNodeByKey(Node node, Key key) {
        isKeyNotNull(key);
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        } else if (cmp < 0) {
            return getNodeByKey(node.leftChild, key);
        } else {
            return getNodeByKey(node.rightChild, key);
        }
    }

    public void put(Key key, Value value) {
        isKeyNotNull(key);
        if (value == null) {
            delete(key);
            return;
        }
        hop = 1;
        root = put(root, key, value, hop);
    }

    private Node put(Node node, Key key, Value value, int hop) {
        if (node == null) {
            hop++;
            return new Node(key, value, hop);
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.value = value;
        } else if (cmp < 0) {
            hop++;
            node.leftChild = put(node.leftChild, key, value, hop);
        } else {
            hop++;
            node.rightChild = put(node.rightChild, key, value, hop);
        }
        node.size = size(node.leftChild) + size(node.rightChild) + 1;
        node.nodeLevel = hop;
        if (node.nodeLevel > treeLevel) {
            treeLevel = node.nodeLevel;
        }
        return node;
    }

    private Node min(Node node) {
        if (node.leftChild == null) {
            return node;
        }
        return min(node.leftChild);
    }

    public Key minKey() {
        return min(root).key;
    }

    private Node max(Node node) {
        if (node.rightChild == null) {
            return node;
        }
        return max(node.rightChild);
    }

    public Key maxKey() {
        return max(root).key;
    }

    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.leftChild == null) {
            return node.rightChild;
        }
        node.leftChild = deleteMin(node.leftChild);
        node.size = size(node.leftChild) + size(node.rightChild) + 1;
        treeLevel = searchHighLevel();
        return node;
    }

    public void delete(Key key) {
        isKeyNotNull(key);
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.leftChild = delete(node.leftChild, key);
        } else if (cmp > 0){
            node.rightChild = delete(node.rightChild, key);
        }else{
            if(node.leftChild == null ){
                treeLevel = searchHighLevel();
                return node.rightChild;
            }
            if(node.rightChild == null ){
                treeLevel = searchHighLevel();
                return node.leftChild;
            }
            Node temp = node;
            node = min(node.rightChild);
            node.rightChild = deleteMin(temp.rightChild);
            node.leftChild = temp.leftChild;
        }
        node.size = size(node.leftChild) + size(node.rightChild) + 1;
        treeLevel = searchHighLevel();
        return node;
    }

    public int searchHighLevel() {
        return searchHighLevel(root, 0);
    }

    private int searchHighLevel(Node rootNode, int beginLevel) {
        if(rootNode != null) {
            if (rootNode.nodeLevel > beginLevel) {
                beginLevel++;
            }
            if (rootNode.leftChild == null && rootNode.rightChild == null) {
                return beginLevel;
            }
            return Math.max(searchHighLevel(rootNode.leftChild, beginLevel), searchHighLevel(rootNode.rightChild, beginLevel));
        } else {
            return -1;
        }

    }

    public boolean isBalancedTree() {
        if (Math.abs(searchHighLevel(root.leftChild, 0) - searchHighLevel(root.rightChild, 0)) <= 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "BST{" +
                toString(root) +
                '}';
    }

    private String toString(Node node) {
        if (node == null) {
            return "";
        }
        return toString(node.leftChild) + " " + node.value.toString()
                + " " + toString(node.rightChild);
    }
}
