package com.mvtest.challenge;

import com.mvtest.challenge.service.CnesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Esta classe testa a partir da camada de serviços da aplicação a corretude dos totais de registros
 * presentes no arquivo cnes_ativonone.csv, extraído da página http://dados.gov.br/dataset/cnes_ativo
 */
@SpringBootTest
class ChallengeApplicationTests {

	@Autowired
	private CnesService cnesService;


	/**
	 * teste para verificar se o serviço de busca retorna a quantidade correta de todos os registros CNES
	 */
	@Test
	void testCnesAll() {
		assertEquals(cnesService.listAllCnes().size(), 354804);
	}

	/**
	 * teste para verificar se o serviço de busca retorna a quantidade correta de registros CNES para o tipo escolhido:
	 * CENTRAL DE GESTAO EM SAUDE
	 */
	@Test
	void testCnesByTipo() {
		assertEquals(cnesService.findByDsTipoUnidade("CENTRAL DE GESTAO EM SAUDE").size(), 6059);
	}

	/**
	 * teste para verificar se o serviço de busca retorna a quantidade correta de registros CNES para a UF escolhida: AL
	 */
	@Test
	void testCnesByEstado() {
		assertEquals(cnesService.findByUf("AL").size(), 3754);
	}
}
