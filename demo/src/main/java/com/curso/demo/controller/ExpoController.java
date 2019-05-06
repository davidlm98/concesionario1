package com.curso.demo.controller;

import com.curso.demo.model.clases.CocheWeb;
import com.curso.demo.model.clases.ExpoWeb;
import com.curso.demo.repositories.CocheRepository;
import com.curso.demo.repositories.ExpoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ExpoController {

    @Autowired
    private ExpoRepository expoRepository;

    @RequestMapping("/expo")
    public String addExpo (@RequestBody ExpoWeb input) throws Exception {
        Optional<ExpoWeb> expoWeb = expoRepository.findById(input.getNumeroDeExpo());
        if(!expoWeb.isPresent()){
            expoRepository.save(input);
            return "Enhorabuena, la exposicion ha sido incluida con exito";
        }else{
            throw new Exception("La exposicion ya esta en la lista");
        }
    }

    @PutMapping("/expo")
    public ExpoWeb updateExpo (@RequestBody ExpoWeb input) throws Exception {
        Optional<ExpoWeb>expoWeb = expoRepository.findById(input.getNumeroDeExpo());
        if(expoWeb.isPresent()){
            expoRepository.save(input);
            return input;
        } else {
            throw new Exception("La exposicion no se ha encontrado");
        }
    }

    @GetMapping("/expo/{id}")
    public ExpoWeb expoWeb (@PathVariable Integer id) throws Exception {
        Optional<ExpoWeb>expoWeb = expoRepository.findById(id);
        if(expoWeb.isPresent()) return expoWeb.get();
        throw new Exception("La exposicion con " + id + " no existe");
    }

    @GetMapping("/exposiciones")
    public List<ExpoWeb> expoWebList(){ return expoRepository.findAll();
    }

    @DeleteMapping("/expoEliminar/{id}")
    public String deleteExpò(@PathVariable Integer id) throws Exception {
        Optional<ExpoWeb>expoWeb = expoRepository.findById(id);
        if(expoWeb.isPresent()){
            expoRepository.deleteById(id);
            return "La exposicion " + id + " ha sido borrada";
        }else {
            throw new Exception("La exposicion con " + id + "no existe");
        }
    }

    @GetMapping("/expo/{numeroExpo}")
    public List<ExpoWeb> expoWebNumeroExpo (@PathVariable int numeroExpo){
        return expoRepository.findByNumeroExpo(numeroExpo).get();
    }
}
