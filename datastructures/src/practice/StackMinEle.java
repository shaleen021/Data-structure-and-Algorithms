package practice;

import java.util.Stack;

public class StackMinEle {
	/*2*min - previous min = inserted ele*/
	StackMinEle() { 
		s = new Stack<Integer>(); 
	}
	
	Stack<Integer> s;
    Integer min;
    
     Integer getMin()
    {
        if (s.isEmpty())
            System.out.println("Stack is empty");
        else
            System.out.println(min);
        return min;
    }
    
    void push(Integer x){
    	if(s.isEmpty()){
    		min = x;
    		s.push(x);
    	}else if(x >= min){
    		s.push(x);
    	}else if(x < min){
    		s.push(2*x- min);
    		min = x;
    	}
    }
    
    void pop(){
    	if(s.isEmpty()){
    		System.out.println("Empty Stack");
    	}else {
    		Integer t = s.pop();
    		if(t<min){
    			min = (2*min) - t;
    		}
    	}
    }
    
    public static void main(String[] args)
    {
        StackMinEle s = new StackMinEle();
        s.push(3);
        s.push(5);
        s.getMin();
        s.push(2);
        s.push(1);
        s.getMin();
        s.pop();
        s.getMin();
        s.pop();
      
    }
}
