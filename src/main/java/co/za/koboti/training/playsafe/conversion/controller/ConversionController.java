package co.za.koboti.training.playsafe.conversion.controller;

import co.za.koboti.training.playsafe.conversion.service.ConversionService;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "Given an input amount in Kelvin, return an output amount in Celsius ", response = float.class, tags = "ktoc")
    @GetMapping(value = "/ktoc/{kelvin}")
    public ResponseEntity<Float> convertKelvinToCelsius(@PathVariable("kelvin") float kelvin) {
        logger.info("Converting {} Kelvin into Celsius", kelvin);
        return new ResponseEntity<>(conversionService.kelvinToCelsius(kelvin), HttpStatus.OK);
    }

    @ApiOperation(value = "Given an input amount in Celsius, return an output amount in Kelvin ", response = float.class, tags = "ctok")
    @GetMapping(value = "/ctok/{celsius}")
    public ResponseEntity<Float> convertCelsiusToKelvin(@PathVariable("celsius") float celsius) {
        logger.info("Converting {} Celsius into Kelvin.", celsius );

        return new ResponseEntity<>(conversionService.celsiusToKelvin(celsius), HttpStatus.OK);
    }

    @ApiOperation(value = "Given an input amount in Miles, return an output amount in Kilometers.", response = float.class, tags = "mtok")
    @GetMapping(value = "/mtok/{miles}")
    public ResponseEntity<Double> convertMilesToKilometers(@PathVariable("miles") double miles) {
        return new ResponseEntity<>(conversionService.milesToKm(miles), HttpStatus.OK);
    }

    @ApiOperation(value = "Given an input amount in Kilometers, return an output amount in Miles.", response = float.class, tags = "ktom")
    @GetMapping(value = "/ktom/{km}")
    public ResponseEntity<Double> convertKilometersToMiles(@PathVariable("km") double km) {
        return new ResponseEntity<>(conversionService.kmToMiles(km), HttpStatus.OK);
    }

}
