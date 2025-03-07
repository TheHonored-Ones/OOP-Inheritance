package org.example;

//@Override is just an annotation—it helps the compiler check if you are correctly
// overriding a method, but it does not affect the actual behavior of the code.

//Prevents Mistakes
//If you accidentally change the method signature (e.g., void details(String extraParam))
// without @Override, Java won’t warn you, and it won’t override the parent method—it
// will just be a new method in the child class.
//
//With @Override, the compiler will give an error if the method doesn't correctly match
//the parent method's signature.
//
//Improves Readability
//When another developer (or future you) looks at the code, they can immediately see
//that this method is meant to override a parent method.
//
//Helps with Maintenance
//If the parent class changes its method signature, @Override ensures that you’ll be
//notified of the conflict rather than silently introducing a bug.

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    void details() {
        System.out.println("A " + name + " costs R" + price);
    }
}

class Electronics extends Product {
    int warranty;

    Electronics(String name, double price, int warranty) {
        super(name, price);
        this.warranty = warranty;
    }

    @Override
    void details() {
        System.out.println("A " + name + " costs R" + price + " and has a warranty of " + warranty + " months.");
    }
}

class Clothing extends Product {
    int size;

    Clothing(String name, double price, int size) {
        super(name, price);
        this.size = size;
    }

    @Override
    void details() {
        System.out.println("A size " + size + " " + name + " costs R" + price);
    }
}


class Books extends Product{
    String author;

    Books(String name, int price, String author){
        super(name,price);
        this.author = author;
    }


    void details(){
        System.out.println(name + " by " + author + " costs R" + price );
    }
}

public class OnlineStore {
    public static void main(String[] args) {
        Product product = new Product("Mic", 200);
        Electronics laptop = new Electronics("Laptop", 8550, 24);
        Clothing tshirt = new Clothing("T-shirt", 300, 32);
        Books purplehibiscus = new Books("Purple Hibiscus",250,"Chimamanda Ngozi");

        product.details();
        laptop.details();
        tshirt.details();
        purplehibiscus.details();
    }
}
