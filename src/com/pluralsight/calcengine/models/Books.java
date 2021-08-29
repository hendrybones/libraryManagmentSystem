package com.pluralsight.calcengine.models;

public class Books {
    String CallNo;
    String name;
    String author;
    String publisher;
    int quantity;

//    public Books(String callNo, String name, String author, String publisher, int quantity) {
//        CallNo = callNo;
//        this.name = name;
//        this.author = author;
//        this.publisher = publisher;
//        this.quantity = quantity;
//    }

    public String getCallNo() {
        return CallNo;
    }

    public void setCallNo(String callNo) {
        CallNo = callNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Books{" +
                "CallNo='" + CallNo + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
