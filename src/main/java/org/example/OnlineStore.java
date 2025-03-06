package org.example;

class Product{
    String name;
    double price;

    Product(String name, double price){
        this.name = name;
        this.price = price;

    }

    void details(){
        System.out.println("A " + name + " costs R" + price);
    }
}

class Electronics extends Product{
    int warranty;

    Electronics(int warranty,int price, String name){
        super(name,price);
        this.warranty = warranty;
    }

    @Override
    void details(){
        System.out.println("A " + name + " costs R" + price + "and has a warranty of " + warranty + "months" );
    }



}
public class OnlineStore {

    public static void main(String[] args){
        Product product = new Product("Mic", 200);
        product.details();
    }

}
