package com.company;

public class Customer
{
    private static int generatorID;
    {
        generatorID++;
    }
    private int id = generatorID;
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private int idCreditCard;
    private int bankNumberCard;

    Customer(String surname, String name, String patronymic, String address, int idCreditCard, int bankNumberCard)
    {
        setSurname(surname);
        setName(name);
        setPatronymic(patronymic);
        setAddress(address);
        setIdCreditCard(idCreditCard);
        setBankNumberCard(bankNumberCard);
    }

    private int getId() {
        return id;
    }

    String getSurname() {
        return surname;
    }

    private void setSurname(String surname) {
        this.surname = surname;
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private String getPatronymic() {
        return patronymic;
    }

    private void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    private String getAddress() {
        return address;
    }

    private void setAddress(String address) {
        this.address = address;
    }

    int getIdCreditCard() {
        return idCreditCard;
    }

    private void setIdCreditCard(int idCreditCard) {
        this.idCreditCard = idCreditCard;
    }

    private int getBankNumberCard() {
        return bankNumberCard;
    }

    private void setBankNumberCard(int bankNumberCard) {
        this.bankNumberCard = bankNumberCard;
    }

    public String toString()
    {
        return String.format("|ID: %1$-2d|Surname: %2$-10s|Name: %3$-10s|Patronymic: %4$-15s|Address: %5$-15s" +
                                    "|Credit Card: %6$-10d|Bank Number: %7$-10d", getId(), getSurname(), getName(),
                                    getPatronymic(), getAddress(), getIdCreditCard(), getBankNumberCard());
    }
}
