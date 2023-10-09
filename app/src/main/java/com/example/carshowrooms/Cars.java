package com.example.carshowrooms;

public class Cars {
    private String name;
    private int amount;
    private int imageCar;

    public Cars(String name, int amount, int imageCar){

        this.name=name;
        this.amount=amount;
        this.imageCar=imageCar;
    }
    public String getCar() {
        return this.name;
    }

    public void setCar(String name) {
        this.name = name;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getImageCar() {
        return this.imageCar;
    }

    public void setImageCar(int imageCar) {
        this.imageCar = imageCar;
    }
}
