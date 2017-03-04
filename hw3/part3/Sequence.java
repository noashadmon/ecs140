
public class Sequence extends Element {
    Element e;
    Sequence next;
    
    public Sequence(){
    } //constructor
    
    public Sequence(Element e, Sequence next){
        this.e = e;
        this.next = next;
    }
    public void Print(){
        System.out.print("[");
        for (Sequence ptr = this; ptr != null && ptr.e != null; ptr = ptr.next){
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
        
        //iterates through the sequence to count len
        for (Sequence ptr = this; ptr != null; ptr = ptr.next){
            len++;
        }
        
        return len;
    } //returns length of Sequence
    
    public void add(Element elm, int pos){
        Sequence ptr = this, prev = null;
        //traverses until finds the position to add elm
        for (int i = 0; ptr != null && i < pos; i++, ptr = ptr.next){
            prev = ptr;
      
        }
            
        
        //if prev not null then add it to next
        if (prev != null){
            prev.next = new Sequence(elm, ptr);
        }   
        //if element is not null then add it to next
        else {
            if (ptr.e != null)
                this.next = new Sequence(this.e, this.next);
            this.e = elm;
        }
                

    } //add
    
    public void delete(int pos){
        Sequence ptr = this, prev = null;
        //finds element to delete at pos
        for (int i = 0; (ptr != null) && (i < pos); ptr = ptr.next){
            prev = ptr;
            i++;
        }
         //checks if ptr is not null and if prev is null   
        if (ptr != null){
            if (prev == null){
                this.e = this.next.e;
                this.next = this.next.next;
            }
            else {
                prev.next = ptr.next;
            }    //if prev has val 
            
        }
    } //deletes element at a certain position
    
    //returns element at pos
    public Element index(int pos){
        Sequence ptr = this;
        Element RetVal;
        
        //checks to make sure if pos is valid then travrses to find elm
        if(pos >= 0 && pos < length())
        {
            for (int i = 0; i < pos; i++ , ptr = ptr.next);
                RetVal = ptr.e; 
        }
        //error if invalid position
        else
        {
            System.err.print("invalid position");
			System.exit(1);
			RetVal = null;
        }
        
        return RetVal;
        
    } //returns element at pos
    
  
    public Sequence index2(int pos){
        Sequence ptr = this;
        for (int i = 0; i < pos; i++ , ptr = ptr.next);
        
        return ptr; 
        
    } //returns element at pos
    
    public Sequence flatten() {
        Sequence newSeq = new Sequence();
        
            if(e instanceof Sequence)
            {
                newSeq = ((Sequence)(e)).flatten();
                
            }//if current Element is a Sequence, flatten it
            else
            {
                newSeq.e = e;
            }//else BASE CASE
     
        //Deals with first
        
            if(next != null)
            {
                
                newSeq.index2(newSeq.length() - 1).next = next.flatten();
                    
            }
        return newSeq;
    } //flattens Sequence
    
    
    public Sequence copy(){
        
        Sequence newSeq = new Sequence();
        Sequence ptr = this;
        int i = 0;
        while(ptr != null)
        {
            Element Itr = ptr.e;
            //if char then get and set new char to it and add to sequence
            if (Itr instanceof MyChar){
                MyChar newChar = new MyChar();
                newChar.Set(((MyChar)(Itr)).Get());
                newSeq.add(newChar, i);
                }
            //if int then get and set new int to it and add to sequence
            else if(Itr instanceof MyInteger){
                MyInteger newInt = new MyInteger();
                newInt.Set(((MyInteger)(Itr)).Get());
                newSeq.add(newInt,i);
                }    
                
            else
            {
                //if seqthen get and set new seq to it and add to sequence
                Sequence temp = new Sequence(); 
                temp = ((Sequence)Itr).copy();
                newSeq.add(temp,i);
            }
            
            ptr = ptr.next;
            i++;
        }
        
        return newSeq;
        
    }
    
}

    
    
    