package com.example.restapiczn.repositories;

import com.example.restapiczn.entities.JogadoresEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogadoresRepository extends JpaRepository<JogadoresEntity, Long> {

}
