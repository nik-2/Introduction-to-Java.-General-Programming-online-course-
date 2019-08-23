public class RunnerPayment
{
    public static void main(String[] args) {
        Payment payment1 = new Payment("Первая покупка");
        Payment payment2 = new Payment("Вторая покупка");
        Payment payment3 = new Payment("Третья покупка");
        payment1.doPayment();
        payment1.getPayment();
        payment2.doPayment();
        payment2.getPayment();
        payment3.doPayment();
        payment3.getPayment();
    }
}
