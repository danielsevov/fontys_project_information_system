package entities;

import businessentitiesapi.Entity;
import nl.fontys.sebivenlo.sebiannotations.ID;


/**
 * Entity with non numeric primary key.
 *
 * @author Pieter van den Hombergh {@code pieter.van.den.hombergh@gmail.com}
 */
public class Company2 implements Entity {

    private String name;
    private String country;
    private String city;
    private String address;
    @ID(generated = false)
    private String ticker;
    private String postcode;
    private int someInt;
    private Integer someInteger;

    public Company2(String name, String country, String city,
                    String address, String ticker, String postcode) {
        this(name, country, city, address, ticker, postcode, 0, null);
    }

    public Company2(String name, String country, String city,
                    String address, String ticker, String postcode, int i, Integer j) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.address = address;
        this.ticker = ticker;
        this.postcode = postcode;
        this.someInt = i;
        this.someInteger = j;
    }

    @Override
    public String toString() {
        return "Company{" + "ticker=" + ticker + ", name=" + name + ", country="
                + country + ", city=" + city + ", address=" + address
                + ", postcode=" + postcode + ",somint =" + someInt + ", somInteger=" + someInteger + '}';
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    static Company2 fromParts(Object[] parts) {

        return new Company2((String) parts[0], (String) parts[1], (String) parts[2], (String) parts[3], (String) parts[4],
                (String) parts[5], (Integer) parts[6], (Integer) parts[7]);
    }

    public int getSomeInt() {
        return someInt;
    }

    public void setSomeInt(int someInt) {
        this.someInt = someInt;
    }

    public Integer getSomeInteger() {
        return someInteger;
    }

    public void setSomeInteger(Integer someInteger) {
        this.someInteger = someInteger;
    }

    @Override
    public int getId() {
        return 0;
    }
}
