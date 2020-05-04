package com.example.mihail.info_holiday;

public class Atraction {

    private int idAtraction;



    private String name;


    private String description;


    private String urlImage;

    private String rating;

    private String price;






    public Atraction() {
        super();
    }

    public Atraction(int idAtraction, String name, String description, String urlImage, String rating, String price) {
        super();
        this.idAtraction = idAtraction;
        this.name = name;
        this.description = description;
        this.urlImage = urlImage;
        this.rating = rating;
        this.price = price;
    }


    public Atraction( String name, String description, String rating, String price) {


        this.name = name;
        this.description = description;
        this.rating = rating;
        this.price = price;
    }


    public int getIdAtraction() {
        return idAtraction;
    }

    public void setIdAtraction(int idAtraction) {
        this.idAtraction = idAtraction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Atraction{" +
                "idAtraction=" + idAtraction +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", urlImage='" + urlImage + '\'' +
                ", rating='" + rating + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
