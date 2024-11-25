package mission.book;

public class SecondBook extends Book {
    private String seller;
    private int discountRate;

    public SecondBook(String title, String author, int price, String seller, int discountRate) {
        super(title, author, price, 1);
        this.seller = seller;
        this.discountRate = discountRate;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    @Override
    public String toString() {
        return super.toString() + " Tingkat diskon : " + discountRate + "% Penjual : " + seller;
    }
}