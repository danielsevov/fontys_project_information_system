package utils;

import businessentitiesapi.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class EntityUtils {
    public static Airplane createAirplane(int id, String name, int cap) {
        return new Airplane() {
            @Override
            public String getRegistrationNumber() {
                return name;
            }

            @Override
            public int getMaxCapacity() {
                return cap;
            }

            @Override
            public int getId() {
                return id;
            }

            @Override
            public String toString() {
                return name;
            }
        };
    }

    public static Airport createAirport(int id, String name, String location) {
        return new Airport() {
            @Override
            public int getId() {
                return id;
            }

            @Override
            public String getName() {
                return name;
            }

            @Override
            public String getLocation() {
                return location;
            }

            @Override
            public String toString() {
                return name;
            }
        };
    }

    public static Flight createFlight(Integer id, Airplane airplane, Airport dep, Airport arr, LocalDateTime depTime, LocalDateTime arrTime, double price) {
        return new Flight() {
            @Override
            public int getId() {
                return id;
            }

            @Override
            public Double getPrice() {
                return price;
            }

            @Override
            public Duration getDuration() {
                return Duration.between(depTime, arrTime);
            }

            @Override
            public Airplane getPlane() {
                return airplane;
            }

            @Override
            public Airport getDepartureAirport() {
                return dep;
            }

            @Override
            public Airport getArrivalAirport() {
                return arr;
            }

            @Override
            public LocalDateTime getArrivalDatetime() {
                return arrTime;
            }

            @Override
            public LocalDateTime getDepartureDatetime() {
                return depTime;
            }

            @Override
            public boolean hasOverlapWith(LocalDateTime startTime, LocalDateTime endTime) {
                return hasOverlap(depTime, arrTime, startTime, endTime);
            }

            @Override
            public String toString() {
                return "Flight " + id + " : " + dep + "-" + arr;
            }
        };
    }

    public static Customer createCustomer(int id, String name, String email, LocalDate birthday) {
        return new Customer() {

            @Override
            public int getId() {
                return id;
            }

            @Override
            public String getName() {
                return name;
            }

            @Override
            public String getEmail() {
                return email;
            }

            @Override
            public LocalDate getBirthDate() {
                return birthday;
            }

            @Override
            public String toString(){
                return name;
            }
        };
    }

    public static Booking createBooking(int id, Customer customer) {
        return new Booking() {

            @Override
            public Customer getBuyer() {
                return customer;
            }

            @Override
            public int getId() {
                return id;
            }

        };
    }

    public static TicketType createTicketType(int id, String name, double multiplier) {
        return new TicketType() {

            @Override
            public String getName() {
                return name;
            }

            @Override
            public double getMultiplier() {
                return multiplier;
            }

            @Override
            public int getId() {
                return id;
            }

        };
    }

    public static TicketOption createTicketOption(int id, String name, int price) {
        return new TicketOption() {

            @Override
            public String getName() {
                return name;
            }

            @Override
            public int getPrice() {
                return price;
            }

            @Override
            public int getId() {
                return id;
            }

        };
    }

    public static Ticket createTicket(int id, Flight flight, Customer customer, String seatNumber,
                                      Booking booking, TicketType ticketType, double price) {
        return new Ticket() {

            @Override
            public Flight getFlight() {
                return flight;
            }

            @Override
            public Customer getCustomer() {
                return customer;
            }

            @Override
            public Booking getBooking() {
                return booking;
            }

            @Override
            public String getSeatNumber() {
                return seatNumber;
            }

            @Override
            public TicketType getTicketType() {
                return ticketType;
            }

            @Override
            public double getPrice() {
                return price;
            }

            @Override
            public int getId() {
                return id;
            }
        };
    }

    public static DailyDiscount createDailyDiscount(int id, String day, double multi) {
        return new DailyDiscount() {
            @Override
            public String getDay() {
                return day;
            }

            @Override
            public double getMultiplier() {
                return multi;
            }

            @Override
            public int getId() {
                return id;
            }
        };
    }

    public static Ticket createTicket(int id, Flight flight, Customer customer, String seatNumber, Booking booking) {
        return createTicket(id, flight, customer, seatNumber, booking, null, 0);
    }

    static <Z extends Comparable<? super Z>> Z max(Z a, Z b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

    static <Z extends Comparable<? super Z>> Z min(Z a, Z b) {
        return a.compareTo(b) <= 0 ? a : b;
    }

    static boolean hasOverlap(LocalDateTime a, LocalDateTime b, LocalDateTime otherA, LocalDateTime otherB) {
        var zero = Duration.ZERO;
        var distance = Duration.between(max(a, otherA), min(b, otherB));
        return (distance.compareTo(zero) <= 0 ? zero : distance) != zero;
    }
}
