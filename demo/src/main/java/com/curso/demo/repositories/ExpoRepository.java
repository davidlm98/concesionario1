package com.curso.demo.repositories;
import com.curso.demo.model.clases.ExpoWeb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpoRepository extends JpaRepository<ExpoWeb,Integer> {
    public Optional<List<ExpoWeb>>findByNumeroExpo(int numeroExpo);
}
