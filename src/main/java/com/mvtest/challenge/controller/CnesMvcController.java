package com.mvtest.challenge.controller;

import java.util.List;
import java.util.Optional;

import com.mvtest.challenge.model.Cnes;
import com.mvtest.challenge.service.CnesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mvc")
public class CnesMvcController {

	private CnesService cnesService;

	public CnesMvcController(CnesService cnesService) {
		this.cnesService = cnesService;
	}

	@RequestMapping(value = "/cnes", method = RequestMethod.GET)
	public String list(Model model){
		List<Cnes> listCnes = cnesService.listAllCnes();
		model.addAttribute("listCnes", listCnes);
		
		System.out.println("Returning listCnes:" + listCnes.size());
		return "cneslist";
	}

	@RequestMapping(value = "cnes/{id}", method = RequestMethod.GET)
	public String showCnes(@PathVariable Integer id, Model model){
		Optional<Cnes> cnes = cnesService.findById(id);
		model.addAttribute("cnes", cnes.get());
		return "cnesshow";
	}

	@RequestMapping("cnes/uf/{uf}")
	public String showCnesByUf(@PathVariable String uf, Model model){
		List<Cnes> listCnes = cnesService.findByUf(uf);
		model.addAttribute("listCnes", listCnes);

		System.out.println("Returning listCnesByUf:" + listCnes.size());
		return "cneslist";
	}

	@RequestMapping("cnes/tipo/{tipo}")
	public String showCnesByTipo(@PathVariable String tipo, Model model){
		List<Cnes> listCnes = cnesService.findByDsTipoUnidade(tipo);
		model.addAttribute("listCnes", listCnes);

		System.out.println("Returning listCnesByTipo:" + listCnes.size());
		return "cneslist";
	}

	@RequestMapping("cnes/uf")
	public String newCnesUf(Model model){
		model.addAttribute("cnes", new Cnes());

		return "cnesbyufform";
	}

	@RequestMapping(value = "cnes/uf", method = RequestMethod.POST)
	public String loadCnesBy(Cnes cnes){

		return "redirect:/mvc/cnes/uf/" + cnes.getUf();
	}

	@RequestMapping("cnes/tipo")
	public String newCnesTipo(Model model){
		model.addAttribute("cnes", new Cnes());

		return "cnesbytipoform";
	}

	@RequestMapping(value = "cnes/tipo", method = RequestMethod.POST)
	public String loadCnesByTipo(Cnes cnes){

		return "redirect:/mvc/cnes/tipo/" + cnes.getDsTipoUnidade();
	}
}
