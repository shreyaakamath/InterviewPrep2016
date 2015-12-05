package data.structures;

public class DirectAddressTable<M> {
	int noKeys;
	Element[] dat;
	class Element<M>{
		int key ;
		M data;
		
		public void setData(M data) {
			this.data = data;
		}

		public Element(int key , M value) {
			this.key = key;
			this.data = value;
		}
		
		public M getData(){
			return this.data;
		}
	}
	
	public DirectAddressTable(int noKeys) {
		dat = new Element[noKeys];
	}
	
	void add(int key , M value){
		Element<M> node = new Element<M>(key,value);
		if(dat[key]==null) dat[key] = node;
		else System.out.println("element exists for key = "+key);
	}
	
	void remove(int key){
		if(dat[key]!=null) dat[key]=null;
		else System.out.println("no element");
	}
	
	/*M search(int key){
		M returnValue;
		if(dat[key]==null) System.out.println("no element");
		else returnValue = dat[key].getData();
		return returnValue;
	}*/
	public static void main(String args[]){
		DirectAddressTable<Integer> obj = new DirectAddressTable<Integer>(5);
		obj.add(1, 1);
	}

}
