package Day2;
class SimpleP{
	public void simpleP() {
	System.out.println("this is parent of simple inheritance");	
	}
}
class SimpleC extends SimpleP{
	public void simpleChild() {
		System.out.println("this is child of simple inheritance");	
	}
}
class MultileveGP{
	public void Gparent() {
		System.out.println("this is Multi level grand parent inheritance");	
	}
}
class Multip extends MultileveGP{
	public void parent() {
		System.out.println("this is parent of multilevel");
	}
}
class Multic extends Multip{
	public void child() {
		System.out.println("this is child of multilevel inheritance");
	}
}
class Hierarchiyalp{
	public void HierP(){
		System.out.println("this is Hierachiel parent inheritance");	
	}
}
class HierChild1 extends Hierarchiyalp{
	public void child1() {
		System.out.println("this is hierchild1");
	}
}
class HierChild2 extends Hierarchiyalp{
	public void child2() {
		System.out.println("this is hierchild2");
	}
}

public class TypesOf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
SimpleC childsimp=new SimpleC();
childsimp.simpleP();
childsimp.simpleChild();
Multic multichild=new Multic();
multichild.Gparent();
multichild.parent();
multichild.child();
HierChild1 hierarc=new HierChild1();
hierarc.HierP();
hierarc.child1();
HierChild2 hierarc2=new HierChild2();
hierarc2.HierP();
hierarc2.child2();
	}

}
