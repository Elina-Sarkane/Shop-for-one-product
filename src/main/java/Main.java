import entity.Product;
import entity.User;

import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    Shop shop = new Shop();
    public static void main(String[] args) {
        Main main = new Main();
        main.showMenu();
    }
    void showMenu(){
        String userInput = "";
        do {
            System.out.println("Welcome to the shop, choose an option: ");
            System.out.println("1. Log in");
            System.out.println("2. Choose and buy product");
            System.out.println("3. Exit shop");

            System.out.println("Enter your choice:");
            userInput = scanner.nextLine();

            switch (userInput){
                case "1":
                    addUser();
                    break;
                case "2":
                    chooseProduct();
                    break;
                case "3":
                    System.out.println("Exiting shop");
                    break;
            }

            System.out.print("\nPress 0 to continue\n");
            scanner.nextLine();

        } while (!userInput.equalsIgnoreCase("3"));
        return;
    }

    void addUser(){
        System.out.println("Log in");

        User user = new User();
        System.out.println("Enter username: ");
        user.userName = scanner.nextLine();

        System.out.println("Enter email: ");
        user.email = scanner.nextLine();
        String message = shop.addUser(user);
        System.out.println(message);
        System.out.println("Your current balance is " + user.userBalance + " euros.");
    }
    void chooseProduct(){
        Product product = new Product();
        User user = new User();
        System.out.println("Choose product: ");
        product.productName = scanner.nextLine();

        if (product.productName.equalsIgnoreCase("apple")){
            System.out.println("You chose " + product.productName);
            System.out.println(product.availableAmount + " " + product.productName + " are available!");
            System.out.println("The price for one " + product.productName + " is " + product.productPrice + " euros!");
            System.out.println("\nHow many " + product.productName + " do you want?");

            Integer amount= scanner.nextInt();
            if (amount <= product.availableAmount){
                System.out.println("You chose " + amount + " " + product.productName + ".");
                System.out.println("The total sum of " + product.productName + " is " + product.productPrice*amount + " euros.");
                    if(user.userBalance == user.userBalance){
                        System.out.println("Your balance now is " + (user.userBalance - product.productPrice * amount) + " euros!");
                    }else{
                        System.out.println("Not enough money to buy " + product.productName);
                    }
            }else{
                System.out.println("Sorry, we don't have that many " + product.productName);
            }
        }else {
            System.out.println("Product not found!");
        }
    }
}
