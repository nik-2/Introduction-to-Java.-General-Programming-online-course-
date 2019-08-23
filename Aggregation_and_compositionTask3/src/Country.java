import java.util.ArrayList;
import java.util.List;

public class Country
{
    private String capital;
    private String country;
    private ArrayList<City> cities = new ArrayList<>();
    private ArrayList<District> districts = new ArrayList<>();
    private ArrayList<Region> regions = new ArrayList<>();

    private Country(City city, String country)
    {
        this.country = country;
        capital = city.getCity();
    }

    private void addCity(City city)
    {
        cities.add(city);
    }

    private void addDistrict(District district)
    {
        districts.add(district);
    }


    private void addRegion(Region region)
    {
        regions.add(region);
    }

    private List<String> regionalCenters()
    {
        List<String> list = new ArrayList<>();
        for (Region i: regions) {
            list.add(i.getRegionalCenter());
        }
        return list;
    }

    private double area()
    {
        double sum = 0;
        for (Region i: regions) {
            sum = sum + i.getArea();
        }
        return sum;
    }

    private String getCapital()
    {
        return capital;
    }

    private String getCountry()
    {
        return country;
    }

    public static void main(String[] args) {
        Country country = new Country(new City("Минск"), "Республика Беларусь");
        country.addCity(new City("Бобруйск"));
        country.addCity(new City("Минск"));
        country.addCity(new City("Борисов"));
        country.addCity(new City("Слуцк"));
        country.addCity(new City("Кличев"));
        country.addCity(new City("Осиповичи"));
        country.addCity(new City("Солигорск"));
        country.addCity(new City("Жлобин"));
        country.addDistrict(new District("Бобруйский"));
        country.addDistrict(new District("Минский"));
        country.addDistrict(new District("Борисовский"));
        country.addDistrict(new District("Слуцкий"));
        country.addDistrict(new District("Кличевский"));
        country.addDistrict(new District("Осиповичский"));
        country.addDistrict(new District("Солигорский"));
        country.addDistrict(new District("Жлобинский"));
        country.addRegion(new Region("Брестская", 32.8, "Брест"));
        country.addRegion(new Region("Витебская", 40, "Витебск"));
        country.addRegion(new Region("Гомельская", 40.4, "Гомель"));
        country.addRegion(new Region("Гродненская", 25.1,"Гродно"));
        country.addRegion(new Region("г.Минск", 0.3, "Минск"));
        country.addRegion(new Region("Минская", 39.9,"Минск"));
        country.addRegion(new Region("Могилёвская", 29.1, "Могилёв"));
        System.out.println("Название государства: " + country.getCountry());
        System.out.println("Площадь государства: " + country.area() + " тыс.км2");
        System.out.println("Столица: " + country.getCapital());
        System.out.println("Количество областей: " + country.regions.size());
        System.out.println("Список областей и их площадь:");
        for (Region i: country.regions) {
            System.out.printf("Область: %1$-15s | Area: %2$-4s тыс.км2\n",i.getRegion(), i.getArea());
        }
        System.out.print("Список областных центров: ");
        for (String i: country.regionalCenters()) {
            System.out.print(i + " ");
        }
        System.out.print("\nНебольшой список городов: ");
        for (City i:country.cities) {
            System.out.print(i.getCity() + " ");
        }
        System.out.print("\nНебольшой список районов: ");
        for (District i:country.districts) {
            System.out.print(i.getDistrict() + " ");
        }
    }
}
