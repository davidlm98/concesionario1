package com.curso.demo.repositories;

import com.curso.demo.model.clases.ClienteWeb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ClienteRepository extends JpaRepository<ClienteWeb, Integer> {
    public Optional<ClienteWeb>findByNombre(String nombre);
    public Optional<ClienteWeb>findByDni(String dni);
    public Optional<List<ClienteWeb>>findByIdAndDni(int id, String dni);

    //public Optional<List<ClienteWeb>>findByNameOrderByDirection(String name);
    //obtener por nombre ordenado por direccion

    //public Optional<List<ClienteWeb>>findByNameAndDireccion(String name, String direccion);
    // public Optional<List<ClienteWeb>>findTop1ByNameAndDireccion(String name, String direccion); te sale el top 1
    //public  findByIdAndName(Integer id, String name);
}
