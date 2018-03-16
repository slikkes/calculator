import java.lang.*;
import java.util.*;

public class calculator{

	

	public static ArrayList<Character> argOps= new ArrayList<Character>();
	public static ArrayList<Float> numbers= new ArrayList<Float>();
	public static ArrayList<Integer> order= new ArrayList<Integer>();

	public static void main(String[] args){


		separate(args[0]);

		order= setOrder();
		

		for(int i=0;i<order.size();i++){


			int n=order.get(i);

			float x=numbers.get(n);
			char o=argOps.get(n);
			float y=numbers.get(n+1);

			numbers.set(n,calculate(x,o,y));
			
			numbers.remove(n+1);
			argOps.remove(n);

			resetOrder(n);

			/*System.out.println("argOps"+argOps);
			System.out.println("numbers"+numbers);
			System.out.println("order"+order);
			System.out.println();*/

		}
			
			System.out.println(numbers.get(0));
			
	}


	//separation of numbers and operators

	public static void separate(String arg){
		
		String subElement="";
		ArrayList<Character> operatorSigns=new ArrayList<Character>(
			Arrays.asList('+','-','*','/'));

		for(int i=0; i<arg.length();i++){

			if(operatorSigns.contains(arg.charAt(i))){
				argOps.add(arg.charAt(i));

				numbers.add(Float.parseFloat(subElement));
				subElement="";

			}else{
				subElement+=arg.charAt(i);
			};
		}

		numbers.add(Float.parseFloat(subElement));
	}


	//calculate from two number

	public static float calculate(float x, char o, float y){

			//System.out.println(x+""+o+""+y);
		switch(o){
			case '+':
				return x+y;
			case '-':
				return x-y;
			case '*':
				return x*y;
			case '/':
				return x/y;
			default:
				return 0;
		}
	}


	//sets order of operations

	public static ArrayList<Integer> setOrder(){
		
		ArrayList<Integer> order=new ArrayList<Integer>();

		for(int i=0;i<argOps.size();i++){
			if(argOps.get(i)=='*'||argOps.get(i)=='/'){
				order.add(i);
			}
		}

		for(int i=0;i<argOps.size();i++){
			if(argOps.get(i)=='+'||argOps.get(i)=='-'){
				order.add(i);
			}
		}

		return order;
	}


	public static void resetOrder(int mainCounter){


		for(int i=0;i<order.size();i++){
			int number=order.get(i);
			if(number>mainCounter){
				order.set(i,number-1);
			}
		}

	}

}