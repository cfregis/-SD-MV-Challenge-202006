package com.mvtest.challenge.service;

import com.mvtest.challenge.model.Cnes;
import com.mvtest.challenge.repository.CnesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CnesService {

    private CnesRepository cnesRepository;

    public CnesService(CnesRepository cnesRepository) {
        this.cnesRepository = cnesRepository;
    }


    public List<Cnes> listAllCnes() {
        return (List<Cnes>) cnesRepository.findAll();
    }

    public List<Cnes> findByUf(String uf) {
        return cnesRepository.findByUf(uf);
    }

    public List<Cnes> findByDsTipoUnidade(String dsTipoUnidade) {
        return cnesRepository.findByDsTipoUnidade(dsTipoUnidade);
    }
}
