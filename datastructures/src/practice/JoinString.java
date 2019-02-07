package practice;

public class JoinString {
	
	public static void findMaxLength(String[] args,int len){
		
		int rr = 0;
		int bb = 0;
		int rb = 0;
		int br = 0;
		
		for(int i=0;i<args.length;i++) {
			if(args[i].charAt(0) == 'R') {
				if(args[i].charAt(args[i].length()-1) == 'R'){
					rr++;
				}else {
					rb++;
				}
			} else {
				if(args[i].charAt(args[i].length()-1) == 'R'){
					br++;
				}else {
					bb++;
				}
			}
		}
		
		if(rb == 0 && br == 0){
			if(rr > 1 || bb > 1){
				System.out.println(Math.max(rr, bb)*len);
			}
		} else if(rb == 0 || br == 0){
			if (rr == 0 && bb ==0){
				
			} else {
				System.out.println(rr + bb + Math.min(rb, br)+1);
			}
		} else {
			if(rb == br){
				System.out.println(rr + bb + rb * 2);
			} else {
				System.out.println(rr + bb + Math.min(rb, br) * 2 + 1);
			}
		}
	}

	public static void main(String args[]){
		
	}
}
