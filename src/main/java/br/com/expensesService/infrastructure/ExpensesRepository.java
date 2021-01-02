package br.com.expensesService.infrastructure;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import br.com.expensesService.domain.Expenses;

public interface ExpensesRepository extends CrudRepository<Expenses, Long> {
	
	List<Expenses> findAll();

}
