package co.za.koboti.training.playsafe.conversion.service;

import org.springframework.stereotype.Service;

@Service
public class ConversionServiceImpl implements ConversionService {

    @Override
    public float kelvinToCelsius(float kelvin) {
        return kelvin - 273.15f;
    }

    @Override
    public float celsiusToKelvin(float celsius) {
        return celsius + 273.15f;
    }

    @Override
    public double milesToKm(double miles) {
        return miles * 1.60934;
    }

    @Override
    public double kmToMiles(double kilometers) {
        return kilometers * 0.621371;
    }
}
