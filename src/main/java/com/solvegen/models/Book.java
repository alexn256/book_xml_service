package com.solvegen.models;

import com.solvegen.util.LocalDateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Simple POJO class that represents book.
 *
 * @author Alexander Naumov
 */


@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
public class Book implements Comparable<Book>{

    @XmlAttribute(name = "id")
    private String id;

    @XmlElement(name = "author")
    private String author;

    @XmlElement(name = "title")
    private String title;

    @XmlElement(name = "genre")
    private String genre;

    @XmlElement(name = "price")
    private Double price;

    @XmlElement(name = "publish_date")
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate publishDate;

    @XmlElement(name = "description")
    private String description;

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public Double getPrice() {
        return price;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public String getDescription() {
        return description;
    }

    public boolean isEmpty() {
        return this.id != null &&
                this.author == null &&
                this.price == null &&
                this.genre == null &&
                this.title == null &&
                this.publishDate == null &&
                this.description == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(author, book.author) &&
                Objects.equals(title, book.title) &&
                Objects.equals(genre, book.genre) &&
                Objects.equals(price, book.price) &&
                Objects.equals(publishDate, book.publishDate) &&
                Objects.equals(description, book.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, title, genre, price, publishDate, description);
    }

    @Override
    public int compareTo(Book o) {
        int result = id.compareTo(o.getId());
        if (result < 0) {
            return -1;
        } else {
            if (result > 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    @Override
    public String toString() {
        return "book = {\nid:" + id +
                "\nauthor:" + author +
                "\ntitle:" + title +
                "\ngenre:" + genre +
                "\nprice:" + price +
                "\npublish date:" + publishDate +
                "\ndescription:" +description +
                "\n}";
    }
}
