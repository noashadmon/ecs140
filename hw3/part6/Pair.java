public class Pair extends Element{
    
    public MyChar key;
    public Element value;
    
    
    Pair(MyChar key, Element value){
        this.key = key;
        this.value = value;
    } //constructor
    
    Pair(MyChar key, Element value, Pair next){
        this.key = key;
        this.value = value;
    } //constructor
    
    public void Print(){
        System.out.print("(");
        key.Print();
        System.out.print(" ");
        value.Print();
        System.out.print(")");
    } //pair print
    
    
}