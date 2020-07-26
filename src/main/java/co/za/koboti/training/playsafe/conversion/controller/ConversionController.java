package co.za.koboti.training.playsafe.conversion.controller;

import co.za.koboti.training.playsafe.conversion.service.ConversionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/conversion")
public class ConversionController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ConversionService conversionService;

    public ConversionController(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @GetMapping(value = "/ktoc/{kelvin}")
    public ResponseEntity<Float> convertKelvinToCelsius(@PathVariable("kelvin") float kelvin) {
        return new ResponseEntity<>(conversionService.kelvinToCelsius(kelvin), HttpStatus.OK);
    }

    @GetMapping(value = "/ctok/{celsius}")
    public ResponseEntity<String> convertCelsiusToKelvin(@PathVariable("celsius") float celsius) {
        return new ResponseEntity<>(String.valueOf(conversionService.celsiusToKelvin(celsius)), HttpStatus.OK);
    }

    @GetMapping(value = "/mtok/{miles}")
    public ResponseEntity<String> convertMilesToKilometers(@PathVariable("miles") double miles) {
        return new ResponseEntity<>(String.valueOf(conversionService.milesToKm(miles)), HttpStatus.OK);
    }

    @GetMapping(value = "/ktom/{km}")
    public ResponseEntity<String> convertKilometersToMiles(@PathVariable("km") double km) {
        return new ResponseEntity<>(String.valueOf(conversionService.kmToMiles(km)), HttpStatus.OK);
    }

}
