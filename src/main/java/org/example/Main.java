package org.example;

import org.example.mobile.Contact;
import org.example.mobile.MobilePhone;
import org.example.models.Grocery;

public class Main {
    public static void main(String[] args) {

        // Grocery test
        Grocery.addItems("tomato, orange, peach");
        Grocery.addItems("apple");
        Grocery.addItems("tomato"); // tekrar eklenmez
        Grocery.printSorted();

        Grocery.removeItems("orange");
        Grocery.printSorted();


        // MobilePhone test
        MobilePhone phone = new MobilePhone("5551234567");

        Contact bob = Contact.createContact("Bob", "31415926");
        Contact alice = Contact.createContact("Alice", "16180339");
        Contact tom = Contact.createContact("Tom", "11235813");
        Contact jane = Contact.createContact("Jane", "23571113");

        System.out.println(phone.addNewContact(bob));
        System.out.println(phone.addNewContact(alice));
        System.out.println(phone.addNewContact(tom));
        System.out.println(phone.addNewContact(jane));

        phone.printContact();

        Contact newBob = Contact.createContact("Bobby", "99999999");
        System.out.println(phone.updateContact(bob, newBob));

        phone.printContact();

        System.out.println(phone.findContact("Alice"));
        System.out.println(phone.queryContact("Tom").getPhoneNumber());

        System.out.println(phone.removeContact(alice));

        phone.printContact();
    }
}