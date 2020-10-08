package com.xrd.znsbgl.entity;

public class Equipment {
private Integer id;
private String name;
private String person;
private String brand;//品牌
private String number;//型号

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", person='" + person + '\'' +
                ", brand='" + brand + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
