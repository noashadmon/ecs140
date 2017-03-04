
public class Sequence extends Element {
    Element e;
    Sequence next;
    
    public Sequence(){
    } //constructor
    
    public Sequence(Element e, Sequence next){
        this.e = e;
        this.next = next;
    } //constructor
    
    public void Print(){
        System.out.print("[");
        for (Sequence ptr = this; ptr != null; ptr = ptr.next){
            System.out.print(" ");
            ptr.e.Print();
        }
        System.out.print(" ]");
    } //prints 
    
    public Element first(){
        return this.e;
    } //returns first Element
    
    public Sequence rest(){
        return this.next;
    } //returns rest of the elements
    
    public int length(){
        int len = 0;
        
        for (Sequence ptr = this; ptr != null; ptr = ptr.next){
            len++;
        }
        
        return len;
    } //returns length of Sequence
    
    public void add(Element elm, int pos){
        Sequence ptr = this, prev = null;
        for (int i = 0; (ptr != null) && (i < pos); ptr = ptr.next){
            prev = ptr;
            i++;
        }
            
        //if not null then add element with next being pointer
        if (prev != null){
            prev.next = new Sequence(elm, ptr);
        }
        
        else {
            //if element is not null then fill next with element
            if (ptr.e != null)
                this.next = new Sequence(this.e, this.next);
            this.e = elm;
        }
                
    } //add an element
    
    public void delete(int pos){
        Sequence ptr = this, prev = null;
        for (int i = 0; (ptr != null) && (i < pos); ptr = ptr.next){
            prev = ptr;
            i++;
        }
        // checks if ptr is not null 
        //if prev is null then assign next element to current
        //assign next element to next next element
        if (ptr != null){
            if (prev == null){
                this.e = this.next.e;
                this.next = this.next.next;
            }
            else {
                prev.next = ptr.next;
            }    //if prev has val 
            
        }
    }
    
    
    
    
}