package nop_Commerce_BDD.stepDef;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ParameterizationSteps {
	int x,y;
	int result=0;
	@Given("I have two numbers {int} and {int}")
	public void i_have_two_numbers_and(int x, int y) {
		this.x=x;
		this.y=y;
	}

	@When("I add them")
	public void i_add_them() {
		result=x+y;
	}

	@Then("print the result")
	public void print_the_result() {
		System.out.println("Addition:"+result);
	}
	@Given("I have following items:")
	public void acceptListOfFruites(DataTable table) {
		List<String> fruits=table.asList();
		System.out.println("List of Fruites");
		for (String fruit : fruits) {
			System.out.println(fruit);
		}

	}
	
	@Given("I have following items with qty:")
	public void acceptListOfFruitesWithQty(DataTable table) {
		Map<String, String> map=table.asMap();
		Set<Entry<String,String>> entries= map.entrySet();
		System.out.println("List of Fruites");
		for (Entry entry : entries) {
			System.out.println(entry.getKey()+""+entry.getValue());
		}

	}
	
	
	@Given("I have following {string} {int}")
	public void acceptDataDriven(String fruitName,int qty ) {
		System.out.println("I have"+fruitName+"with"+qty);
	}

}
