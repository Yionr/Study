package cn.yionr.beans;


public class Book {

  private String isbn;
  private String bookName;
  private long price;


  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Book() {
  }

  @Override
  public String toString() {
    return "Book{" +
            "isbn='" + isbn + '\'' +
            ", bookName='" + bookName + '\'' +
            ", price=" + price +
            '}';
  }

  public String getBookName() {
    return bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }


  public long getPrice() {
    return price;
  }

  public void setPrice(long price) {
    this.price = price;
  }

}
