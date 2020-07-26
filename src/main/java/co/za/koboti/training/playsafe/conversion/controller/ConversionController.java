package co.za.koboti.training.playsafe.conversion.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/conversion")
public class ConversionController {

    @GetMapping(value = "/ktoc/{kelvin}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> convertKelvinToCelsius(@PathVariable("kelvin") float kelvin) {
        return new ResponseEntity<>(String.valueOf(""), HttpStatus.OK);
    }

    @GetMapping(value = "/ctok/{celsius}")
    public ResponseEntity<String> convertCelsiusToKelvin(@PathVariable("celsius") float celsius) {
        return new ResponseEntity<>(String.valueOf(""), HttpStatus.OK);
    }

    @GetMapping(value = "/mtok/{miles}")
    public ResponseEntity<String> convertMilesToKilometers(@PathVariable("miles") double miles) {
        return new ResponseEntity<>(String.valueOf(""), HttpStatus.OK);
    }

    @GetMapping(value = "/ktom/{km}")
    public ResponseEntity<String> convertKilometersToMiles(@PathVariable("km") double km) {
        return new ResponseEntity<>(String.valueOf(""), HttpStatus.OK);
    }

}
