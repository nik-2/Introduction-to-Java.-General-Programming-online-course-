public class TravelPackage
{
    public String type;
    public String transport;
    public int days;
    public String nutrition;
    public int price;
    public String name;

    public TravelPackage(String type, String name, String transport, int days, String nutrition, int price)
    {
        setType(type);
        setTransport(transport);
        setDays(days);
        setNutrition(nutrition);
        setPrice(price);
        setName(name);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getNutrition() {
        return nutrition;
    }

    public void setNutrition(String nutrition) {
        this.nutrition = nutrition;
    }

    public String toString()
    {
        return String.format( " Тип путевки: %1$-10s| Название: %2$-20s| Транспорт: %3$-15s| Количество дней: %4$-4s| " +
                        "Питание: %5$-15s| Цена($): %6$-6s\n", getType(), getName(), getTransport(), getDays(), getNutrition(), getPrice());
    }
}
