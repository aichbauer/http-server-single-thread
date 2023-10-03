package example.com.app.services;

import example.com.app.models.City;
import lombok.AccessLevel;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class CityService {
    @Setter(AccessLevel.PRIVATE)
    private List<City> cityData;

    public CityService() {
        setCityData(new ArrayList<>());
        cityData.add(new City(0, "Vienna", 1900000));
        cityData.add(new City(0, "Graz", 300000));
        cityData.add(new City(0, "Linz", 190000));
    }

    public City getCityById(int id) {
        City foundCity = cityData.stream()
                .filter(city -> id == city.getId())
                .findAny()
                .orElse(null);

        return foundCity;
    }

    public List<City> getCities() {
        return cityData;
    }

    public void addCity(City city) {
        cityData.add(city);
    }

    public void removeCity(int id) {
        cityData.removeIf(city -> id == city.getId());
    }
}
