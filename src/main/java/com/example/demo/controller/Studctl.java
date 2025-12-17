package com.example.demo.controller;
import java.util.Collection;
import org.springframework.beans.factory.annotation.AutoWired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Studentity;
import com.example.demo.service.Studservice;
@RestController
@RequestMapping("/student")
public class Studctl{
    @AutoWired
    private  Studservice ser;

    @postMapping("/add")
    public Studentity addStudent(@RequestBody Studentity st){
        return ser.saveData(st);
    }
    @Get
}