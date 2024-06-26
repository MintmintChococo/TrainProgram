package com.mintchoco.common;

public class TicketDTO {

    private String name;
    private int number;

    public TicketDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "TicketDTO{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}

