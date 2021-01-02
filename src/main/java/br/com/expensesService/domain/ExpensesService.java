package br.com.expensesService.domain;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.expensesService.infrastructure.ExpensesRepository;

@Service
public class ExpensesService {
	
	private ExpensesRepository repository; 
	
	public ExpensesService(ExpensesRepository repository) {
		this.repository = repository;
	}
	
	public List<Expenses> findAll() { 
		return repository.findAll(); 	
	}
	
	public Optional<Expenses> findById(Long id) {
		return repository.findById(id);
	}
	
	/*
	 * public List<Debt> findByName(String name) { return
	 * repository.findByName(name); }
	 * 
	 * public List<Debt> findByDate(String initialDate, String finalDate) { return
	 * repository.findByDate(initialDate, finalDate); }
	 * 
	 * public List<Debt> findByCategory(String category) { return
	 * repository.findByCategory(category); }
	 */
	
	public Expenses create(Expenses expenses) {
		return repository.save(expenses);
	}
	
	public ResponseEntity<Expenses> update (Long id, Expenses expenses) {
		return repository.findById(id).map(record -> {
			record.setIdDebts(expenses.getIdDebts());
			record.setCategory(expenses.getCategory());
			record.setProjectedValue(expenses.getProjectedValue());
			record.setRealValue(expenses.getRealValue());
			record.setDateExpenses(expenses.getDateExpenses());
			record.setName(expenses.getName());
			Expenses newExpenses = repository.save(record);
			return ResponseEntity.ok().body(newExpenses);
		}).orElse(ResponseEntity.notFound().build());
	}
	
	public Optional<?> delete (Long id) {
		return repository.findById(id).map(record -> {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		});
	}

}
