package com.mvtest.challenge.bootstrap;

import com.mvtest.challenge.model.Cnes;
import com.mvtest.challenge.repository.CnesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Component
public class DemoData implements CommandLineRunner {

    @Autowired
    private CnesRepository cnesRepository;

    @Override
    public void run(String...args) throws Exception {
        String fileName = "cnes_ativonone.csv";
        System.out.println( "CommandLineRunner - DemoData - BEGIN" );
        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(line -> {
                Cnes cnes =  new Cnes();
                String[] lineParts = line.split(",");
                cnes.setCodCnes(lineParts[0].replaceAll("\"", ""));
                cnes.setCodIbge(lineParts[1].replaceAll("\"", ""));
                cnes.setNomeFantasia(lineParts[2].replaceAll("\"", ""));
                cnes.setDsTipoUnidade(lineParts[3].replaceAll("\"", ""));
                cnes.setTpGestao(lineParts[4].replaceAll("\"", ""));
                cnes.setNomeLogradouro(lineParts[5].replaceAll("\"", ""));
                cnes.setNumeroEndereco(lineParts[6].replaceAll("\"", ""));
                cnes.setNomeBairro(lineParts[7].replaceAll("\"", ""));
                cnes.setCodCep(lineParts[8].replaceAll("\"", ""));
                cnes.setUf(lineParts[9].replaceAll("\"", ""));
                cnes.setMunicipio(lineParts[10].replaceAll("\"", ""));
                cnes.setNumeroTelefone(lineParts[11].replaceAll("\"", ""));
                cnesRepository.save(cnes);
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println( "CommandLineRunner - DemoData - END" );
    }
}
