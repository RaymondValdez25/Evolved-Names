//Raymond Valdez
import java.util.*;

public class Population {
	Genome mostFit;
	Genome[] pop;
	double mutationRate;
	Integer numGenomes;
	

	Population(Integer numGenomes, Double mutationRate){
		
		this.mutationRate = mutationRate;
		this.numGenomes = numGenomes;
		
		pop = new Genome[numGenomes];
	
		for(int i=0; i<numGenomes; i++){
			Genome var = new Genome(this.mutationRate);
			pop[i] = var;
		}
	}
	
	void day(){
		int i = 0;
		
		Genome temp = new Genome(mutationRate);
		
		//updates the fitness of the array
		
			for(i = 0; i<numGenomes; i++){
				pop[i].fitness();
			}	
			
			mostFit = pop[0];
				
		
			
//************************************************************		
	//sorts the array
	for(int x = 0; x< numGenomes; x++){
		for(int j = 1; j<numGenomes; j++){
			if(pop[j].fitness < pop[j-1].fitness){
				temp = pop[j-1];
				pop[j-1]=pop[j];
				pop[j]=temp;
			}
		}
	}
	
	
	
	//deletes the least fit half
	for(int x = numGenomes/2; x < numGenomes; x++){
		pop[x].specimen = null;
		pop[x].fitness = 25;
	}
	
			
//***************************************************************		
	
	//create new genomes from the remaining population
	//if rand is 0, duplicate then mutate
	
		Random rand = new Random();
		
		int binRand = rand.nextInt(2);
		int cloneRand = 0;
		int cloneRand2 = 0;
	
	
		for(int x = numGenomes/2; x< numGenomes ; x++){
			if(binRand == 0){
				cloneRand = rand.nextInt(numGenomes/2);
				pop[x].specimen = pop[cloneRand].specimen;
				pop[x].mutate();
			}
			
			else{
				cloneRand = rand.nextInt(numGenomes/2);
				cloneRand2 = rand.nextInt(numGenomes/2);
				
				pop[x].specimen = pop[cloneRand].specimen;
				pop[x].crossover(pop[cloneRand2]);
				pop[x].mutate();
			}
		}
		
		
		//selects the most fit genome in the array
				for( i=0; i<numGenomes; i++){
					if(pop[i].fitness <= mostFit.fitness){
						mostFit = pop[i];
					}
				}
				
	}	
	
	
	Genome mostFit(){
		
		return mostFit;
	}
	
	
	String displayPopulation(){
		
		StringBuilder build = new StringBuilder();
		
		for(int i = 0; i<numGenomes; i++){
			//System.out.println(pop[i].toString());
			
			build.append(pop[i].toString() + System.lineSeparator());
	
			
		}
		
		return build.toString();
		
	}
	
		
	
}
