
public class MyInteger extends Element {
    
    private int num;
    public MyInteger() {
       num = 0; 
        
    } //constructor
    
    public MyInteger(int num){
        this.num = num;
    } //constructor
     
    public int Get(){
        return num;
    } //Get() returns num
    
    public void Set(int val){
         num = val;
    } //set
    
  
    
}