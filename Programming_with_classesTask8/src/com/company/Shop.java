package com.company;

import java.util.ArrayList;
import java.util.List;

public class Shop
{
    private ArrayList<Customer> customers = new ArrayList<>();

    private void newCustomer(Customer customer)
    {
        customers.add(customer);
    }

    private List<Customer> print()
    {
        return customers;
    }

    private List<Customer> sortbySurname()
    {
        List<Customer> list = new ArrayList<>(customers);
        list.sort((o1, o2) -> o1.getSurname().compareToIgnoreCase(o2.getSurname()));
        return list;
    }

    private List<Customer> getListbyDiapason( int downDiapason, int upDiapason)
    {
        List<Customer> list = new ArrayList<>();
        for (Customer i: customers) {
            if( i.getIdCreditCard() >= downDiapason && i.getIdCreditCard() <= upDiapason)
            {
                list.add(i);
            }
        }
        return list;
    }



    public static void main(String[] args) {
        Shop customersShopList = new Shop();
        customersShopList.newCustomer(new Customer("Поляков", "Никита", "Владимирович", "Беларусь", 20_30_58_96, 12_34_56));
        customersShopList.newCustomer(new Customer("Бабенко", "Александра", "Павловна", "Беларусь", 35_02_85_69, 22_33_44));
        customersShopList.newCustomer(new Customer("Сигел", "Майк", "Александрович", "Австрия", 74_44_44_44, 55_25_39));
        customersShopList.newCustomer(new Customer("Нольде", "Андреас", "Вадимович", "Германия", 55_55_55_55, 78_23_58));
        customersShopList.newCustomer(new Customer("Холмс", "Том", "Артурович", "Англия", 66_66_66_66, 31_52_77));
        customersShopList.newCustomer(new Customer("Франклин", "Бенджамин", "Константинович", "Канада", 99_99_99_99, 65_24_11));
        System.out.println( "\t\t\t\t\t\t\tCUSTOMERS\n");
        for (Customer i: customersShopList.print()) {
            System.out.println(i);
        }
        System.out.println( "\n\t\t\t\t\t\t\tCUSTOMERS SORT BY SURNAME\n");
        for (Customer i: customersShopList.sortbySurname())
        {
            System.out.println(i);
        }
        System.out.println("\n\t\t\t\t\tCUSTOMERS WITH CREDIT CARDS IN A GIVEN RANGE\n");
        for (Customer i: customersShopList.getListbyDiapason(30_00_00_00,70_00_00_00)) {
            System.out.println(i);
        }
    }
}
