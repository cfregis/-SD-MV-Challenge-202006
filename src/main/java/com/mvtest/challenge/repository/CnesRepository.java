package com.mvtest.challenge.repository;

import com.mvtest.challenge.model.Cnes;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CnesRepository extends CrudRepository<Cnes, Integer> {

    public List<Cnes> findByUf(String uf);

    public List<Cnes> findByDsTipoUnidade(String uf);
}
