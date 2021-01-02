package br.com.expensesService.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "expenses")
public class Expenses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int idDebts;
	private String name; 
	private float projectedValue; 
	private float realValue; 
	private String dateExpenses; 
	private String category;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getIdDebts() {
		return idDebts;
	}
	public void setIdDebts(int idDebts) {
		this.idDebts = idDebts;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getProjectedValue() {
		return projectedValue;
	}
	public void setProjectedValue(float projectedValue) {
		this.projectedValue = projectedValue;
	}
	public float getRealValue() {
		return realValue;
	}
	public void setRealValue(float realValue) {
		this.realValue = realValue;
	}
	public String getDateExpenses() {
		return dateExpenses;
	}
	public void setDateExpenses(String dateExpenses) {
		this.dateExpenses = dateExpenses;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	} 
	
}
