package com.example.Mapping.Controller;

import com.example.Mapping.Model.Laptop;
import com.example.Mapping.Service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptop")
public class LaptopController {

    @Autowired
    private LaptopService laptopService;

    @PostMapping("/laptop")
    public Laptop addLaptop(@RequestBody String laptop) {
        Laptop laptop1 =  laptopService.addLaptop(laptop);
        return laptop1;
    }

    @GetMapping("/laptop")
    public List<Laptop> getLaptop(@Nullable @RequestParam String laptopId){
        return  laptopService.getLaptop(laptopId);

    }}
