import java.io.*;
import java.util.*;

public class Node {
    private String data;
    private Node prev;
    private Node next;

    public Node(String data, Node prev, Node next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public Node(String data) {
        this.data = data;
        this.prev = this.next = null;
    }

    public Node() {
        this.next = null;
        this.data = "";
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String getData() {
        return data;
    }

    public Node getPrev() {
        return prev;
    }
    public Node getNext() {
        return next;
    }

    public String toString() {
        return this.data;
    }

}
