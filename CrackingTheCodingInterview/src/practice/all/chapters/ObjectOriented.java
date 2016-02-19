package practice.all.chapters;

public class ObjectOriented {
	int a;
	ObjectOriented(int a){
		this.a=a;
	}
	public static void main(String[] args) {

	}
}

class Sub extends ObjectOriented{
	Sub(){
		super(1);
	}
}