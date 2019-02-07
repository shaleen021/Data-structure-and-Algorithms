package practice;

class Parent {
	void test(int a){
		Parent.ParentStatic.test();
	}
	
	public void testPrivate(){
		
	}
	static class ParentStatic {
		private static void test() {
			System.out.println("Parent static");
		}
	}
	
	class Inner extends Parent {
		@Override
		public void testPrivate() {
			
		}
		private void innerMethod() {
			System.out.println("Inner method");
		}
	}
	
	public void test() throws Exception{
		System.out.println(this);
		System.out.println("Parent test method");
	}
	
	
}
public class Inheritance extends Parent implements Cloneable {
	
	public String s;
	
	Inheritance(String s){
		this.s = s;
	}
	@Override
	public void test() throws Exception{
		System.out.println(this);
		super.test();
		System.out.println("Child test method");
	}
	
	public static void main(String args[]) throws Exception{
		//Parent p1 = new Inheritance();
		Inheritance h1 = new Inheritance("Shaleen");
		Inheritance h2 = (Inheritance)h1.clone();
		h2.s = "agarwal";
		System.out.println(h1.s);
		System.out.println(h2.s);
		//System.out.println(h1);
		//h1.test();
//		p1.test();
//		Parent p2 = new Parent();
//		Parent.ParentStatic ps = new ParentStatic();
		//ps.test();
	}
	
}




