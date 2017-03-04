
public class MyChar extends Element {
    
    private char ch;
    
    public MyChar() { 
        ch = '0';
    } //constructor
    
    public MyChar(char ch){
        this.ch = ch;
    } // constructor
    
    public char Get() {
        return ch;
    } //get - returns char
    
    public void Set(char val) {
        ch = val;
    } //set - sets value
    
    public void Print(){
        System.out.print("'" + ch + "'");
    } // prints char
}