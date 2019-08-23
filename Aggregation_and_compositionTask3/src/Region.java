public class Region
{
    public String region;
    public double area;
    public String regionalCenter;

    public Region(String region, double area, String regionalCenter)
    {
        this.area = area;
        this.region = region;
        this.regionalCenter = regionalCenter;
    }

    public double getArea()
    {
        return area;
    }

    public String getRegion()
    {
        return region;
    }

    public String getRegionalCenter()
    {
        return regionalCenter;
    }
}
