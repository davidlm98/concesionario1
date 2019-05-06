package com.curso.demo.controller;

import com.curso.demo.model.clases.CocheWeb;
import com.curso.demo.repositories.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CocheController {

    @Autowired
    private CocheRepository cocheRepository;

    @RequestMapping("/coche")
    public String addCoche (@RequestBody CocheWeb input) throws Exception {
        Optional<CocheWeb> cocheWeb = cocheRepository.findById(input.getIdCoche());
        if(!cocheWeb.isPresent()){
            cocheRepository.save(input);
            return "Enhorabuena, el coche ha sido incluido con exito";
        }else{
            throw new Exception("El coche ya esta en la lista");
        }
    }

    @PutMapping("/coche")
    public CocheWeb updateCoches (@RequestBody CocheWeb input) throws Exception {
        Optional<CocheWeb>cocheWeb = cocheRepository.findById(input.getIdCoche());
        if(cocheWeb.isPresent()){
            cocheRepository.save(input);
            return input;
        } else {
            throw new Exception("El coche no se ha encontrado");
        }
    }

    @GetMapping("/coche/{id}")
    public CocheWeb coche (@PathVariable Integer id) throws Exception {
        Optional<CocheWeb>cocheWeb = cocheRepository.findById(id);
        if(cocheWeb.isPresent()) return cocheWeb.get();
        throw new Exception("El coche con " + id + " no existe");
    }

    @GetMapping("/coches")
    public List<CocheWeb> cocheList(){ return cocheRepository.findAll();
    }

    @DeleteMapping("/cocheEliminar/{id}")
    public String deleteCoche(@PathVariable Integer id) throws Exception {
        Optional<CocheWeb>cocheWeb = cocheRepository.findById(id);
        if(cocheWeb.isPresent()){
            cocheRepository.deleteById(id);
            return "El coche " + id + " ha sido borrado";
        }else {
            throw new Exception("El coche con " + id + "no existe");
        }
    }

    @GetMapping("/coche/{matricula}")
    public List<CocheWeb> cocheByMatricula (@PathVariable String matricula){
        return cocheRepository.findByMatricula(matricula).get();
    }
}
