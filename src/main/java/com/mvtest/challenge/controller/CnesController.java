package com.mvtest.challenge.controller;

import com.mvtest.challenge.model.Cnes;
import com.mvtest.challenge.service.CnesService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/cnes")
@Api(value="cnes repository", description="Operations pertaining to cnes repository list")
public class CnesController {

	private CnesService cnesService;

	public CnesController(CnesService cnesService) {
		this.cnesService = cnesService;
	}

	@ApiOperation(value = "Cnes All List endpoint")
	@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(value = "/list", method= RequestMethod.GET, produces = "application/json")
	public List<Cnes> list() {
		List<Cnes> listAllCnes = this.cnesService.listAllCnes();
        System.out.println("Lista de Cnes: " + listAllCnes.size());

        return listAllCnes;
	}


	@ApiOperation(value = "Cnes by UF List endpoint")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@RequestMapping(value = "/listbyuf/{uf}", method= RequestMethod.GET, produces = "application/json")
	public List<Cnes> getCnesByState(@PathVariable(value = "uf") String uf) {
		List<Cnes> listAllCnesByUf = this.cnesService.findByUf(uf);
		System.out.println("Lista de Cnes por UF: " + listAllCnesByUf.size());

		return listAllCnesByUf;
	}


	@ApiOperation(value = "Cnes by tipo List endpoint")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@RequestMapping(value = "/listbytipo/{tipo}", method= RequestMethod.GET, produces = "application/json")
	public List<Cnes> getCnesByTipo(@PathVariable(value = "tipo") String tipo) {
		List<Cnes> listAllCnesDsTipoUnidade = this.cnesService.findByDsTipoUnidade(tipo);
		System.out.println("Lista de Cnes por tipo: " + listAllCnesDsTipoUnidade.size());

		return listAllCnesDsTipoUnidade;
	}
}
