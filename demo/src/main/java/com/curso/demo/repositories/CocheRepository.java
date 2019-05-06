package com.curso.demo.repositories;

import com.curso.demo.model.clases.CocheWeb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CocheRepository extends JpaRepository<CocheWeb, Integer> {
    public Optional <List<CocheWeb>> findByMatricula(String matricula);
}
