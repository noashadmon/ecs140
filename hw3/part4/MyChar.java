
public class MyChar extends Element {
    
    private char ch;
    
    public MyChar() { 
        ch = '0';
    } //constructor
    
    public MyChar(char ch){
        this.ch = ch;
    }
    
    public char Get() {
        return ch;
    } //get
    
    public void Set(char val) {
        ch = val;
    } //set
    
    public void Print(){
        System.out.print("'" + ch + "'");
    } //print
}