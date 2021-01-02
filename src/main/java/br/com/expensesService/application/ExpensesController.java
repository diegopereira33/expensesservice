package br.com.expensesService.application;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.expensesService.domain.Expenses;
import br.com.expensesService.domain.ExpensesService;


@RestController
@RequestMapping("/expenses")
public class ExpensesController {

	private ExpensesService service;
	
	
	public ExpensesController(ExpensesService service) {
		this.service = service;
	}
	
	@CrossOrigin
	@GetMapping
	public List<Expenses> findAll() {
		return service.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public Expenses findById(@PathVariable Long id) {
		return service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Debt not found"));
	}
	
	/*
	 * @CrossOrigin
	 * 
	 * @GetMapping("/name/{name}") public List<Debt> findByName(@PathVariable String
	 * name) { return service.findByName(name); }
	 * 
	 * @CrossOrigin
	 * 
	 * @GetMapping("/date/{initialDate}/{finalDate}") public List<Debt>
	 * findByDate(@PathVariable String initialDate, @PathVariable String finalDate )
	 * { return service.findByDate(initialDate, finalDate); }
	 * 
	 * 
	 * @CrossOrigin
	 * 
	 * @GetMapping("/category/{category}") public List<Debt>
	 * findByCategory(@PathVariable String category) { return
	 * service.findByCategory(category); }
	 */
	@CrossOrigin
	@PostMapping
	public Expenses create(@RequestBody Expenses expenses) {
		return service.create(expenses);
	}
	
	@CrossOrigin
	@PutMapping(value = "/{id}")
	public ResponseEntity<Expenses> update(@PathVariable("id") long id, @RequestBody Expenses expenses) {
		return service.update(id, expenses);
	}
	
	@CrossOrigin
	@DeleteMapping(path = { "/{id}" })
	public Optional<?> delete(@PathVariable long id) {
		service.findById(id)
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Debt not found"));
		
		return service.delete(id);
	}

}
