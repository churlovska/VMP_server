package com.vmp.server.repositories;

import com.vmp.server.entities.CityEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRep extends JpaRepository<CityEntity, Integer>, CrudRepository<CityEntity, Integer> {

    @Override
    List<CityEntity> findAll();

    List<CityEntity> findAllByOrderByCityAsc();

    Optional<CityEntity> findById(Integer id);

    CityEntity getOne(Integer id);

    CityEntity findByCity(String city);

    @Override
    <S extends CityEntity> S save(S s);
}
