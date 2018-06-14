//Raymond Valdez
import java.util.Random;
import java.lang.StringBuilder;


public class Genome {

	String specimen;
	double mutationRate;
	String target = "CHRISTOPHER PAUL MARIOTT";
	Integer fitness;
	
	public Genome(double mutationRate){
		
		specimen = "A";
		this.mutationRate = mutationRate;
		
	}
	
	
	public Genome(Genome gene){
		this.specimen = gene.specimen; 
		fitness = gene.fitness;
		mutationRate=gene.mutationRate;
	}
	
	
	/*in my mutate() method, the string of letters are represented
	 as integers using their corresponding ASCII value and vice versa.
	*/
	void mutate(){
		Random rand = new Random();
		StringBuilder str = new StringBuilder(specimen);
		
		int randAdd = rand.nextInt(100); //max is 99 min is 0
		int randDelete = rand.nextInt(100);
		int randLetter = rand.nextInt(29); 
		int mutationConvert = (int)((this.mutationRate*100) -1);
		int randPos = rand.nextInt(specimen.length() + 1);
		char ch;
		
		
		//code to add a random letter
		if(randAdd <= mutationConvert){ 
			if(randLetter + 32 == 32){
				ch = ' ';
				str.insert(randPos,ch);
			}
			
			else if(randLetter + 44 == 45){
				ch = '-';
				str.insert(randPos,ch);
			}
			
			else if(randLetter + 37 == 39){
				ch = '\'';
				str.insert(randPos,ch);
			}
			else{
				ch = (char)(randLetter + 62);
				str.insert(randPos,ch);
			}
		}
		//code to delete a random letter
		if(randDelete <= mutationConvert){ 
			if(str.toString().length() >= 2){
			randPos = rand.nextInt(str.length());
			str.deleteCharAt(randPos);
			}
		}
	
		//code to swap each letter
		for(int i = 0; i<str.toString().length(); i++){
			randLetter = rand.nextInt(29); 
			randAdd = rand.nextInt(100);
			
		if(randAdd <= mutationConvert){
			if(randLetter + 32 == 32){
				ch = ' ';
				str.setCharAt(i,ch);
			}
			
			else if(randLetter + 44 == 45){
				ch = '-';
				str.setCharAt(i,ch);
			}
			
			else if(randLetter + 37 == 39){
				ch = '\'';
				str.setCharAt(i,ch);
			}
			else{
				ch = (char)(randLetter + 62);
				str.setCharAt(i,ch);
			}	
			}
		}
		specimen = str.toString();
	}
	
	
	void crossover(Genome other){
		
		String str = "";
		
		Random rand = new Random();
		
		int p1 = specimen.length();
		int p2 = other.specimen.length();
		
		int shorter = Math.min(p1, p2);
		
		for(int i=0; i< shorter; i++){
			int n = rand.nextInt(2);
			if(n == 0){
			str = str + specimen.charAt(i);
			}
			else
			str = str + other.specimen.charAt(i);
		}
		specimen = str;
	}
	
	Integer fitness(){
		
		int i = 0;
		int n = specimen.length();
		int m = target.length();
		int min = Math.min(n,m);
		int max = Math.max(n,m);
		
		fitness = Math.abs(m-n);
		
		for(i = 0; i < min; i++){
			if(specimen.charAt(i) != target.charAt(i)){
				fitness++;
			}
		}
		
		fitness = fitness + (max - i);
		
		return fitness;
	}
	public String toString(){
		
	return specimen + " " + fitness ;	
	}
}
