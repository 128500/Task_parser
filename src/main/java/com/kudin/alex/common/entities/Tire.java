package com.kudin.alex.common.entities;

/**
 * Created by KUDIN ALEKSANDR on 22.01.2018.
 *
 * This class represents an entity of a tire.
 */

public class Tire {

    /*Entity id*/
    private int id;

    /*Type of a tire*/
    private String type;

    /*Manufacturer of a tire (brand)*/
    private String manufacturer;

    /*Model of a tire*/
    private String model;

    /*Tire width*/
    private int width;

    /*Tire height*/
    private int height;

    /*Diameter of a tire*/
    private int diameter;

    /*Season of tire using*/
    private String season;

    /*Load index of a tire*/
    private int loadIndex;

    /*Speed index of a tire*/
    private char speedIndex;

    /*Strengthening mark*/
    private boolean strengthen;

    /*Studding mark*/
    private boolean studded;

    /*Additional parameter*/
    private String additionalParam;

    /*Manufacturing country*/
    private String country;

    /*Year of manufacturing*/
    private int year;

    /*Current balance*/
    private int balance;

    /*Price of a tire*/
    private double price;

    /*Getters and setters*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public int getLoadIndex() {
        return loadIndex;
    }

    public void setLoadIndex(int loadIndex) {
        this.loadIndex = loadIndex;
    }

    public char getSpeedIndex() {
        return speedIndex;
    }

    public void setSpeedIndex(char speedIndex) {
        this.speedIndex = speedIndex;
    }

    public boolean isStrengthen() {
        return strengthen;
    }

    public void setStrengthen(boolean strengthen) {
        this.strengthen = strengthen;
    }

    public boolean isStudded() {
        return studded;
    }

    public void setStudded(boolean studded) {
        this.studded = studded;
    }

    public String getAdditionalParam() {
        return additionalParam;
    }

    public void setAdditionalParam(String additionalParam) {
        this.additionalParam = additionalParam;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Tire{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", diameter=" + diameter +
                ", season='" + season + '\'' +
                ", loadIndex=" + loadIndex +
                ", speedIndex=" + speedIndex +
                ", strengthen=" + strengthen +
                ", studded=" + studded +
                ", additionalParam='" + additionalParam + '\'' +
                ", country='" + country + '\'' +
                ", year=" + year +
                ", balance=" + balance +
                ", price=" + price +
                '}';
    }
}
