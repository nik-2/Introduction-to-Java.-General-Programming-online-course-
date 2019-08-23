import java.util.Scanner;

class Payment
{
    private   String name_Payment;
    private int cost_Payment;
    private Product[] products;

    Payment(String name_Payment)
    {
        this.name_Payment = name_Payment;
    }

    private class Product{
        private String name_Product;
        private int cost_Product;
        Product(String name_Product, int cost_Product){
            this.name_Product = name_Product;
            this.cost_Product = cost_Product;
        }

        String getName_Product() {
            return name_Product;
        }

        int getCost_Product() {
            return cost_Product;
        }
    }

    void doPayment()
    {
        this.cost_Payment = 0;
        Scanner in = new Scanner(System.in);
        System.out.print( "Укажите количество товаров покупки: ");
        int kol = Integer.parseInt(in.nextLine());
        this.products = new Product[kol];
        for (int i = 0; i < kol; i++) {
            System.out.println( "Товар " + (i + 1) + ": ");
            System.out.print( "Название товара: ");
            String nameProd = in.nextLine();
            System.out.print( "Цена товара: ");
            int costProd = Integer.parseInt(in.nextLine());
            this.products[i] = new Product(nameProd, costProd);
            this.cost_Payment = this.cost_Payment + this.products[i].getCost_Product();
        }
    }

    void getPayment()
    {
        System.out.printf("\n%1$30s",this.name_Payment + "\n\n");
        for (int i = 0; i < this.products.length; i++) {
            System.out.printf("Товар: %1$-3d| Название товара: %2$-10s| Цена товара($): %3$-3d\n", (i+1),
                            this.products[i].getName_Product(), this.products[i].getCost_Product());
        }
        System.out.println( "\nСтоимость покупки: " + this.cost_Payment + "$\n");
    }
}
