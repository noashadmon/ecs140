
public class MyInteger extends Element {
    
    private int num;
    public MyInteger() {
       num = 0; 
        
    } //constructor
    
    public MyInteger(int num){
        this.num = num;
    }
     
    public int Get(){
        return num;
    } //Get()
    
    public void Set(int val){
         num = val;
    } //set
    
    public void Print(){
        System.out.print(num);
    } //print
    
    
    
}