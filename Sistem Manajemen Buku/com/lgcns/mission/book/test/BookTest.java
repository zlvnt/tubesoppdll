package com.lgcns.mission.book.test;

import mission.book.*;

public class BookTest {
    public static void main(String[] args) {
        Book[] books = {
            new Book("Apa itu keadilan?", "Michael Sandel", 15000, 15),
            new Book("Pistol, kuman dan Besi", "Jared Diamond", 28000, 3),
            new Book("Street of Dark Shops", "Patrick Modiano", 11000, 12),
            new Book("Perjalanan Mr. Cuffe", "François Leroy", 13500, 1)
        };

        SecondBook[] secondBooks = {
            new SecondBook("Penjelajah warisan budaya", "Yoo Hong-Jun", 13000, "IU", 45),
            new SecondBook("Cerita pendek Tolstoy", "Tolstoy", 16000, "Kim Soo-hyun", 40)
        };

        Customer[] customers = {
            new Customer("Na Gong-Bu"),
            new Customer("Kim Sin-ip")
        };

        System.out.println("--Informasi buku--");
        for (Book book : books) {
            System.out.println(book);
        }
        for (SecondBook secondBook : secondBooks) {
            System.out.println(secondBook);
        }

        System.out.println();
        customers[0].buyBook(books[2], 3);
        customers[0].buyBook(books[1], 0);
        customers[0].buyBook(secondBooks[1]);

        System.out.println();
        customers[1].buyBook(books[0], 1);
        customers[1].buyBook(secondBooks[0]);

        System.out.println();
        System.out.println("--Informasi akhir buku--");
        for (Book book : books) {
            System.out.println(book);
        }
        for (SecondBook secondBook : secondBooks) {
            System.out.println(secondBook);
        }

        System.out.println();
        System.out.println("--Informasi pembelian--");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}
