package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {

    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("""
                    
                    0 - Uygulamayı durdur
                    1 - Ürün ekle
                    2 - Ürün çıkar
                    Seçiminiz:
                    """);

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    isRunning = false;
                    break;

                case 1:
                    System.out.println("Eklemek istediğiniz ürünleri giriniz:");
                    String addInput = scanner.nextLine();
                    addItems(addInput);
                    printSorted();
                    break;

                case 2:
                    System.out.println("Çıkarmak istediğiniz ürünleri giriniz:");
                    String removeInput = scanner.nextLine();
                    removeItems(removeInput);
                    printSorted();
                    break;

                default:
                    System.out.println("Geçersiz seçim yaptınız.");
            }
        }
    }

    public static void addItems(String input) {
        String[] items = input.split(",");

        for (String item : items) {
            String product = item.trim();

            if (!product.isEmpty() && !checkItemIsInList(product)) {
                groceryList.add(product);
            }
        }

        Collections.sort(groceryList);
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");

        for (String item : items) {
            String product = item.trim();

            if (checkItemIsInList(product)) {
                groceryList.remove(product);
            }
        }

        Collections.sort(groceryList);
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println("Grocery List: " + groceryList);
    }
}