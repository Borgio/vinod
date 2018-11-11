package io.javabrains.lambda.unit1;

public class Greeter {

	public void greet(Greeting greeting) {
		greeting.perform();
	}
	
	
	public static void main(String[] args) {
		Greeter greeter = new Greeter();
		
		
		Greeting lambdaGreeting = () -> System.out.print("Hello world!");
		
		Greeting innerClassGreeting = new Greeting() {
			public void perform() {
				System.out.print("Hello world!");
			}
		};
		
		greeter.greet(lambdaGreeting);
		
		greeter.greet(() -> System.out.print("Hello world!"));
		greeter.greet(innerClassGreeting);
		
		
		// some more examples
		MyLambda myLambda = () -> System.out.println("fooo !");
		myLambda.foo();
		
		Add2Variables add2Variables = (a, b) -> a+b;
		System.out.println("Add : "+add2Variables.add(10, 20));
	}

}

interface MyLambda {
	public void foo();
}

interface Add2Variables {
	public int add(int a, int b);
}



