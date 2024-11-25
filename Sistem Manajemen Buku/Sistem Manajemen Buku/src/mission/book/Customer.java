package mission.book;

public class Customer {
    private String name;
    private int totalPrice;

    public Customer(String name) {
        this.name = name;
        this.totalPrice = 0;
    }

    public String getName() {
        return name;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void buyBook(Book book, int quantity) {
        if (quantity <= 0) {
            System.out.println("[Error] 0 jilid kurang, tidak dapat dibeli.");
            return;
        }
    
        if (book.getStockQuantity() < quantity) {
            System.out.println("[Error] Persediaannya kurang. Jumlah persediaan saat ini: " + book.getStockQuantity() + " jilid");
            return;
        }
    
        book.setStockQuantity(book.getStockQuantity() - quantity);
        this.totalPrice += book.getPrice() * quantity;
        System.out.println(name + " membeli " + book.getTitle() + ". Jumlah total: " + (book.getPrice() * quantity));
    }
    

    public void buyBook(SecondBook book) {
        if (book.getStockQuantity() <= 0) {
            System.out.println("[Error] Persediaannya kurang. Jumlah persediaan saat ini: " + book.getStockQuantity() + " jilid");
            return;
        }
    
        int discountedPrice = book.getPrice() * (100 - book.getDiscountRate()) / 100;
        this.totalPrice += discountedPrice;
        book.setStockQuantity(0);
        System.out.println(name + " membeli " + book.getTitle() + ". Jumlah total: " + discountedPrice);
    }
    

    @Override
    public String toString() {
        return "Nama Pelanggan : " + name + " Jumlah total : " + totalPrice;
    }
}
