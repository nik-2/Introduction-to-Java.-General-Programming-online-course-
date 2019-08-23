public class Airline
{
    private String destination;
    private String flightNumber;
    private String typeAirplane;
    private String time;
    private String daysWeek;

    public Airline(String destination, String flightNumber, String typeAirplane, String time, String daysWeek) {
        setDestination(destination);
        setFlightNumber(flightNumber);
        setTypeAirplane(typeAirplane);
        setTime(time);
        setDaysWeek(daysWeek);
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getTypeAirplane() {
        return typeAirplane;
    }

    public void setTypeAirplane(String typeAirplane) {
        this.typeAirplane = typeAirplane;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDaysWeek() {
        return daysWeek;
    }

    public void setDaysWeek(String daysWeek) {
        this.daysWeek = daysWeek;
    }

    public String toString()
    {
        return String.format("|Destination: %1$-15s|Flight number: %2$-5s|Type of aircraft: %3$-15s|Departure time: %4$-10s" +
                        "|Days of the week: %5$-30s", getDestination(), getFlightNumber(), getTypeAirplane(),
                getTime(), getDaysWeek());
    }
}
