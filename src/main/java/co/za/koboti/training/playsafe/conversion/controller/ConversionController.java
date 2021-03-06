package co.za.koboti.training.playsafe.conversion.controller;

import co.za.koboti.training.playsafe.conversion.service.ConversionService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StopWatch;
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
        StopWatch watcher = new StopWatch();
        watcher.start();
        float celsius = conversionService.kelvinToCelsius(kelvin);
        logger.info("Time taken to convert kelvin into celsius is {} nanoseconds", watcher.getTotalTimeNanos());
        return new ResponseEntity<>(celsius, HttpStatus.OK);
    }

    @ApiOperation(value = "Given an input amount in Celsius, return an output amount in Kelvin ", response = float.class, tags = "ctok")
    @GetMapping(value = "/ctok/{celsius}")
    public ResponseEntity<Float> convertCelsiusToKelvin(@PathVariable("celsius") float celsius) {
        logger.info("Converting {} Celsius into Kelvin.", celsius );
        StopWatch watcher = new StopWatch();
        watcher.start();
        float kelvin = conversionService.celsiusToKelvin(celsius);
        watcher.stop();
        logger.info("Time taken to convert celsius into kelvin is {} nanoseconds", watcher.getTotalTimeNanos());
        return new ResponseEntity<>(kelvin, HttpStatus.OK);
    }

    @ApiOperation(value = "Given an input amount in Miles, return an output amount in Kilometers.", response = double.class, tags = "mtok")
    @GetMapping(value = "/mtok/{miles}")
    public ResponseEntity<Double> convertMilesToKilometers(@PathVariable("miles") double miles) {
        logger.info("Converting {} Miles into Kilometers.", miles );
        StopWatch watcher = new StopWatch();
        watcher.start();
        double km = conversionService.milesToKm(miles);
        watcher.stop();
        logger.info("Time taken to convert miles into km is {} nanoseconds", watcher.getTotalTimeNanos());
        return new ResponseEntity<>(km, HttpStatus.OK);
    }

    @ApiOperation(value = "Given an input amount in Kilometers, return an output amount in Miles.", response = double.class, tags = "ktom")
    @GetMapping(value = "/ktom/{km}")
    public ResponseEntity<Double> convertKilometersToMiles(@PathVariable("km") double km) {
        logger.info("Converting {} Kilometers into Miles.", km );
        StopWatch watcher = new StopWatch();
        watcher.start();
        double miles = conversionService.kmToMiles(km);
        watcher.stop();
        logger.info("Time taken to convert km into miles is {} nanoseconds", watcher.getTotalTimeNanos());
        return new ResponseEntity<>(miles, HttpStatus.OK);
    }

}
