import java.io.FileOutputStream;
import java.io.PrintStream;

//Raymond Valdez
import java.io.*;

public class Main {
	
	public static void main(String [] args)throws FileNotFoundException{
		
		//PrintStream out = new PrintStream(new FileOutputStream("MyTrace.txt"));
		
		
		long startTime = System.nanoTime();	
		long endTime = System.nanoTime();
		
		
		Population society = new Population(100,.05);
		
		int j = 0;
		
		//i declare the 1st element of the array of Genomes as the mostFit so the while loop will run.
		society.pop[0].fitness();
		society.mostFit = society.pop[0];
	
		while(society.mostFit.fitness != 0){
			
		//out.println("Generation: " + j);
			
		
			society.day();
			//out.println(society.displayPopulation());
		
		System.out.println( society.mostFit().toString());
		j++;
		}
		
		
		endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		double milliseconds = totalTime/(Math.pow(10,6));
		System.out.println(milliseconds + " milliseconds to complete and " + (j-1) + " generations.");
		
	
		//testPopulation();
		//testGenome();
		
	}
	
	static void testGenome(){
		
		Genome Adam = new Genome(0.05);
		Genome Eve= new Genome(0.05);
		Genome Chris = new Genome(.05);
		
		Adam.specimen = "ADAM";
		Eve.specimen = "EVE";
		Chris.specimen = "CHRISTOPHER PAUL MARIOTT";
		
		Adam.fitness();
		Eve.fitness();
		Chris.fitness();
		
		
		System.out.println("display the string before mutation with their fitness");
		System.out.println(Adam.toString());
		System.out.println(Eve.toString());
		System.out.println(Chris.toString());
		System.out.println();
		

		for(int i = 0; i<500; i++){
		Adam.mutate();
		Eve.mutate();
		}
		
		Adam.fitness();
		Eve.fitness();
		Chris.fitness();
		
		
		
		System.out.println("Both and and Eve mutates multiples of times and displays their names with their fitness level");
		System.out.println(Adam.toString());
		System.out.println(Eve.toString());
		System.out.println(Chris.toString());
		System.out.println();
		
		
		Adam.crossover(Eve);
		
		System.out.println("crossover both Adam and Eve, the new name is stored in the caller Adam");
		System.out.println(Adam.toString());
		System.out.println(Eve.toString());
		System.out.println(Chris.toString());
		
		Genome clone = new Genome(Adam);
		
		System.out.println();
		System.out.println("Testing the constructor that initializes a clone.\nThe name and fitness for the clone should be the same as the one in the parameter.\nIn this case it is a clone of Adam");
		
		System.out.println(clone.toString());
		
	}
	
	
	static void testPopulation(){
		
		System.out.println("testing the population constructor w/ a population of 60 and a mutation rate of .30");
		
		Population goblins = new Population(60,.30); 
		
		System.out.println("print out the initial population with their fitness level.");
		
		for(int i = 0; i<60; i++){
			goblins.pop[i].fitness();
		}
		goblins.displayPopulation();
		
		goblins.day();
		goblins.day();
		goblins.day();
		
		System.out.println();
		System.out.println("after calling day() 3 times.\nNotice it isn't sorted yet because sort is called before mutating");
		
		goblins.displayPopulation();
		
		System.out.println("\ndisplays the most fit individual. \nA tie prints the youngest mostFit individual.\n(closest to the bottom of the list).");
		System.out.println(goblins.mostFit.toString());
		
		
	}
}
