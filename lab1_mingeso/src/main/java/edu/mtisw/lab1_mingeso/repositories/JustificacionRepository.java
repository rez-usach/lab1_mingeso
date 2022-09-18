package edu.mtisw.lab1_mingeso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mtisw.lab1_mingeso.entities.JustificacionEntity;

@Repository
public interface JustificacionRepository extends JpaRepository<JustificacionEntity, Integer> {
}
