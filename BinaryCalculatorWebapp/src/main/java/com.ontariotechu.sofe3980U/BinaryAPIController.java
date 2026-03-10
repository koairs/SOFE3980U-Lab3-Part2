package com.ontariotechu.sofe3980U;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BinaryAPIController {

	/* ADD */
	@GetMapping("/add")
	public String addString(
			@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
			@RequestParam(name="operand2", required=false, defaultValue="") String operand2) {

		Binary number1 = new Binary(operand1);
		Binary number2 = new Binary(operand2);
		return Binary.add(number1, number2).getValue();
	}

	@GetMapping("/add_json")
	public BinaryAPIResult addJSON(
			@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
			@RequestParam(name="operand2", required=false, defaultValue="") String operand2) {

		Binary number1 = new Binary(operand1);
		Binary number2 = new Binary(operand2);
		return new BinaryAPIResult(number1, "add", number2,
				Binary.add(number1, number2));
	}

	/* MULTIPLY */
	@GetMapping("/multiply")
	public String multiplyString(
			@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
			@RequestParam(name="operand2", required=false, defaultValue="") String operand2) {

		return Binary.multiply(new Binary(operand1), new Binary(operand2)).getValue();
	}

	@GetMapping("/multiply_json")
	public BinaryAPIResult multiplyJSON(
			@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
			@RequestParam(name="operand2", required=false, defaultValue="") String operand2) {

		Binary n1 = new Binary(operand1);
		Binary n2 = new Binary(operand2);
		return new BinaryAPIResult(n1, "multiply", n2,
				Binary.multiply(n1, n2));
	}

	/* AND */
	@GetMapping("/and")
	public String andString(
			@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
			@RequestParam(name="operand2", required=false, defaultValue="") String operand2) {

		return Binary.and(new Binary(operand1), new Binary(operand2)).getValue();
	}

	@GetMapping("/and_json")
	public BinaryAPIResult andJSON(
			@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
			@RequestParam(name="operand2", required=false, defaultValue="") String operand2) {

		Binary n1 = new Binary(operand1);
		Binary n2 = new Binary(operand2);
		return new BinaryAPIResult(n1, "and", n2,
				Binary.and(n1, n2));
	}

	/* OR (I) */
	@GetMapping("/or")
	public String orString(
			@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
			@RequestParam(name="operand2", required=false, defaultValue="") String operand2) {

		return Binary.or(new Binary(operand1), new Binary(operand2)).getValue();
	}

	@GetMapping("/or_json")
	public BinaryAPIResult orJSON(
			@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
			@RequestParam(name="operand2", required=false, defaultValue="") String operand2) {

		Binary n1 = new Binary(operand1);
		Binary n2 = new Binary(operand2);
		return new BinaryAPIResult(n1, "or", n2,
				Binary.or(n1, n2));
	}
}
