/**
 * SimpleJsonCoverter
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/9/8
 **/
package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Arrays;
import lombok.Data;

@Data
class User {

    private int id;
    private String name;
    private Address[] addresses;
    private Contact contact;
    private boolean isVerified;
    private int rating;

    // 构造函数、getter和setter方法省略

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", addresses=" + Arrays.toString(addresses) +
            ", contact=" + contact +
            ", isVerified=" + isVerified +
            ", rating=" + rating +
            '}';
    }
}

@Data
class Address {

    private String street;
    private String city;
    private String country;
    private int zipCode;
    private GeoLocation geoLocation;

    // 构造函数、getter和setter方法省略

    @Override
    public String toString() {
        return "Address{" +
            "street='" + street + '\'' +
            ", city='" + city + '\'' +
            ", country='" + country + '\'' +
            ", zipCode=" + zipCode +
            ", geoLocation=" + geoLocation +
            '}';
    }
}

@Data
class GeoLocation {

    private double latitude;
    private double longitude;

    // 构造函数、getter和setter方法省略

    @Override
    public String toString() {
        return "GeoLocation{" +
            "latitude=" + latitude +
            ", longitude=" + longitude +
            '}';
    }
}

@Data
class Contact {

    private String email;
    private Phone[] phones;

    // 构造函数、getter和setter方法省略

    @Override
    public String toString() {
        return "Contact{" +
            "email='" + email + '\'' +
            ", phones=" + Arrays.toString(phones) +
            '}';
    }
}

@Data
class Phone {

    private String type;
    private String number;

    // 构造函数、getter和setter方法省略

    @Override
    public String toString() {
        return "Phone{" +
            "type='" + type + '\'' +
            ", number='" + number + '\'' +
            '}';
    }
}


public class AnotherMain {

    public static void main(String[] args) {
        User user = new User();
        user.setId(123);
        user.setName("John");

        Address address1 = new Address();
        address1.setStreet("123 Main St");
        address1.setCity("New York");
        address1.setCountry("USA");
        address1.setZipCode(10001);

        GeoLocation location1 = new GeoLocation();
        location1.setLatitude(40.7128);
        location1.setLongitude(-74.0060);

        address1.setGeoLocation(location1);

        Address address2 = new Address();
        address2.setStreet("321 Wall St");
        address2.setCity("Los Angeles");
        address2.setCountry("USA");
        address2.setZipCode(90001);

        GeoLocation location2 = new GeoLocation();
        location2.setLatitude(34.0522);
        location2.setLongitude(-118.2437);

        address2.setGeoLocation(location2);

        user.setAddresses(new Address[]{address1, address2});

        Contact contact = new Contact();
        contact.setEmail("john@example.com");

        Phone phone1 = new Phone();
        phone1.setType("home");
        phone1.setNumber("123-456-7890");

        Phone phone2 = new Phone();
        phone2.setType("work");
        phone2.setNumber("987-654-3210");

        contact.setPhones(new Phone[]{phone1, phone2});

        user.setContact(contact);
        user.setVerified(true);
        user.setRating(4);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(user);
        System.out.println(json);

        System.out.println("----------------------------");
        System.out.println(json.replaceAll("\\s", ""));
    }
}

