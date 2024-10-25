package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
private CustomList list;
public CustomList mockCityList() {
    list = new CustomList(null, new ArrayList<>());
    return list ;
}

    // Test for addCity
    @Test
    public void testAddCity() {
        CustomList cityList = mockCityList();
        int listSize = cityList.getCount();
        cityList.addCity(new City("Estevan", "SK"));
        assertEquals(cityList.getCount(), listSize + 1);
    }

    // Test for hasCity
    @Test
    public void testHasCity() {
        CustomList cityList = mockCityList();
        City city = new City("Calgary", "Alberta");
        assertFalse(cityList.hasCity(city));  // Should return false

        cityList.addCity(city);
        assertTrue(cityList.hasCity(city));  // Should return true now
    }

    // Test for deleteCity
    @Test
    public void testDeleteCity() {
        CustomList cityList = mockCityList();
        City city = new City("Toronto", "Ontario");
        cityList.addCity(city);
        assertEquals(1, cityList.getCount());

        cityList.deleteCity(city);
        assertEquals(0, cityList.getCount());
        assertFalse(cityList.hasCity(city));  // City should be deleted
    }

    // Test for countCities
    @Test
    public void testCountCities() {
        CustomList cityList = mockCityList();
        assertEquals(0, cityList.countCities());  // Initially empty

        cityList.addCity(new City("Vancouver", "British Columbia"));
        assertEquals(1, cityList.countCities());
    }



}
