package businesslogic;

import businessentitiesapi.Airplane;
import businessentitiesapi.Airport;
import businessentitiesapi.Flight;
import genericmapper.ForeignKey;
import helpers.ranges.LocalDateTimeRange;
import nl.fontys.sebivenlo.sebiannotations.ID;
import nl.fontys.sebivenlo.sebiannotations.TableName;

import java.time.Duration;
import java.time.LocalDateTime;

@TableName(value = "flight")
public class FlightImpl implements Flight {
    @ID
    private final Integer id;
    private final LocalDateTime departureDatetime;
    private final LocalDateTime arrivalDatetime;
    @ForeignKey
    private final Airplane plane;
    @ForeignKey
    private final Airport departureAirport;
    @ForeignKey
    private final Airport arrivalAirport;
    private final double price;

    public FlightImpl(Integer id, LocalDateTime departure, LocalDateTime arrival, Airplane airplane,
                      Airport arrivalAirport, Airport departureAirport, double price) {
        this.id = id;
        this.departureDatetime = departure;
        this.arrivalDatetime = arrival;
        this.plane = airplane;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.price = price;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public Airplane getPlane() {
        return plane;
    }

    @Override
    public Airport getDepartureAirport() {
        return departureAirport;
    }

    @Override
    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    @Override
    public LocalDateTime getArrivalDatetime() {
        return arrivalDatetime;
    }

    @Override
    public LocalDateTime getDepartureDatetime() {
        return departureDatetime;
    }

    LocalDateTimeRange timeRange() {
        return LocalDateTimeRange.of(arrivalDatetime, departureDatetime);
    }

    @Override
    public boolean hasOverlapWith(LocalDateTime startTime, LocalDateTime endTime) {
        var newRange = LocalDateTimeRange.of(startTime, endTime);
        return timeRange().overlaps(newRange);
    }

    @Override
    public Duration getDuration() {
        return Duration.between(departureDatetime, arrivalDatetime);
    }

    public String toString(){
        return String.format("Flight %d : %s-%s", id, departureAirport, arrivalAirport);
    }
}
