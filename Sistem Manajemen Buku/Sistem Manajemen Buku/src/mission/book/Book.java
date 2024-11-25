package mission.book;

public class Book {
    private String title;
    private String author;
    private int price;
    private int stockQuantity;

    public Book(String title, String author, int price, int stockQuantity) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public int getprice(){
        return price;
    }

    @Override
    public String toString() {
        return "Judul : " + title + " Penulis : " + author + " Harga : " + price + " Persediaan : " + stockQuantity + "jilid";
    }
}