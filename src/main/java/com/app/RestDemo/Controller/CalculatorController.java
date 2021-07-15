package com.app.RestDemo.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calc")
public class CalculatorController {

    @GetMapping("/add/{no1}/{no2}")
    public ResponseEntity<Integer> add(@PathVariable int no1 , @PathVariable int no2){
        return ResponseEntity.ok(no1 + no2 );
    }

    @GetMapping("/sub/{no1}/{no2}")
    public ResponseEntity<Integer> sub(@PathVariable int no1 , @PathVariable int no2){
        return ResponseEntity.ok(no1 - no2 );
    }
}
