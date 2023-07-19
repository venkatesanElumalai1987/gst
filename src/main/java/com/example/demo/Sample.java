package com.example.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class Sample {
	@GetMapping(value = "/Hello")
	public String getHello() {
		return "Welcome to SpringBoot";
	}

	@GetMapping(value = "Hi")
	public String getHi() {
		return "Hi";
	}

	@GetMapping(value = "/add/{num1}/{num2}")
	public int addition(@PathVariable int num1, @PathVariable int num2) {
		return num1 + num2;
	}

	@GetMapping(value = "/add/{palidrome}")

	public String findPalindrome(@PathVariable String palidrome) {
		String a = "";
		for (int i = palidrome.length() - 1; i >= 0; i--) {
			a = a + palidrome.charAt(i);
		}
		if (palidrome.equalsIgnoreCase(a)) {
			return "It is Palindrome";
		} else {
			return "It is Not Palindrome";
		}
	}

	@GetMapping(value = "/prime/{num3}")
	public String findPrime(@PathVariable int num3) {
		boolean c = true;
		for (int i = 2; i < num3; i++) {
			if (i % 2 == 0) {
				c = false;
				break;
			}
		}

		if (c == true) {
			return "prime";
		} else {
			return "Not prime";

		}
	}

	@GetMapping(value = "/square/{num4}")
	public String findSquare(@PathVariable int num4) {
		boolean a = true;
		for (int i = 0; i < num4; i++) {
			if (num4 != (i * i)) {
				a = false;
				break;
			}
		}
		if (a == false) {
			return "Square";
		} else {
			return "Not Square";
		}
	}

	@GetMapping(value = "/even/{num5}")
	public String findEven(@PathVariable int num5) {
		boolean a = false;
		for (int i = 0; i < num5; i++) {
			if (num5 % 2 == 0) {
				a = true;
			}
		}
		if (a == true) {
			return "Even";
		} else {
			return "Not Even";
		}

	}

	@GetMapping(value = "/Validation_Check")
	public String getAccess(@RequestParam String username, @RequestParam String password) {
		if ((username.equals("Venkatesh")) && (password.equals("Venkat@1987"))) {
			return "Access Granted";
		} else {
			return "Access Denied";
		}
	}

	@GetMapping(value = "/Even/{a}")

	public ArrayList<Integer> findEvenN(@PathVariable int a) {
		ArrayList<Integer> e = new ArrayList<>();
		for (int i = 0; i < a; i++) {
			if (i % 2 == 0) {
				e.add(i);
			} else {
				continue;
			}
		}
		return e;

	}

	@GetMapping(value = "/fiboo")
	public ArrayList<Integer> findFibonacci(@RequestParam int num7) {
		int b = 0;
		ArrayList<Integer> fibo = new ArrayList<>();
		for (int i = 0; i <= num7; i++) {
			b = b + i;
			fibo.add(b);
		}
		return fibo;
	}

	@GetMapping(value = "/getCar")
	public Car getCar(@RequestBody Car c) {
		return c;
	}
	@GetMapping(value="/getallcars")
	public List<Car> getCar(@RequestBody List<Car>a)
	{
		return a;
	}
	@GetMapping(value="/Color/{colour}")
	public List<Car> findColor(@RequestBody List<Car>a,@PathVariable String colour)
	{
		return a.stream().filter(x->x.getColour().equalsIgnoreCase(colour)).collect(Collectors.toList());
	}
	@GetMapping(value="/Brand/{brand}")
	public List<Car>findBrand(@RequestBody List<Car>b,@PathVariable String brand)
	{
		return b.stream().filter(x->x.getBrand().equalsIgnoreCase(brand)).collect(Collectors.toList());
	}
	@GetMapping(value="/Max")
	public Car findMaximum(@RequestBody List<Car>c)
	{
		return c.stream().max(Comparator.comparing(Car::getPrice)).get();
	}
	@GetMapping(value="/Price/{price}")
	public List<Car>findPrice(@RequestBody List<Car>cars,@PathVariable int price)
	{
	return cars.stream().filter(x->x.getPrice()>price).collect(Collectors.toList());
	}
	@GetMapping(value="/Min")
	public Car findMinimum(@RequestBody List<Car>c)
	{
		return c.stream().min(Comparator.comparing(Car::getPrice)).get();
	}
	@GetMapping(value="/NewestCar")
	public Car findNew(@RequestBody List<Car>c)
	{
		return c.stream().max(Comparator.comparing(Car::getModel)).get();
	}
	@GetMapping(value="/NewestCarName")
	public String findNewName(@RequestBody List<Car>c)
	{
		return c.stream().max(Comparator.comparing(Car::getModel)).map(x->x.getBrand()).get();
	}
	@GetMapping(value="/Increase")
	public List<Car> increasePrice(@RequestBody List<Car>c)
	{
	//return c.stream().max(Comparator.comparing(Car::getModel)).map(x->x.getPrice()+(5*x.getPrice())).get();
	//c.stream().filter(x->x.getModel()>2018).forEach(x->x.setPrice(x.getPrice()+((5*x.getPrice())/100)));
	//return c.stream().filter(x->x.getModel()>2018).collect(Collectors.toList());
		return c.stream().filter(x->x.getModel()>2018).map((y)->{y.setPrice(y.getPrice()+((5*y.getPrice())/100));return y;}).toList();
		}
	}
	
	

