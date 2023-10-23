package multiservicios.cliente.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import multiservicios.cliente.model.cliente;
import multiservicios.cliente.repository.clienterepository;

@Controller
@RequestMapping("/clientes")//http:localhost:8080/clientes
public class clientecontoller {
	
	private final Logger logg=LoggerFactory.getLogger(cliente.class);
	
	@Autowired
	private clienterepository clienterepository;
	
	@GetMapping("")
	public String home(Model model) {
		model.addAttribute("clientes", clienterepository.findAll());
		
		return"home";
	}
	
	@GetMapping("/create")//http:localhost:8080/clientes/create
	public String create() {
		return"create";
	}
	
	@PostMapping("/save")
	public String save(cliente cliente) {
		logg.info("informacion del objeto cliente{}",cliente);
		clienterepository.save(cliente);
		return"redirect:/clientes";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		cliente c= clienterepository.getOne(id);
		logg.info("objeto recuperado()",c);
		model.addAttribute("cliente",c);
		return"edit";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		cliente c= clienterepository.getOne(id);
		logg.info("objeto recuperado()",c);
		clienterepository.delete(c);
		return"redirect:/clientes";
	}

}
