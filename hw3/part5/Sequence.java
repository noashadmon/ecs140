
public class Sequence extends Element {
    Element e;
    Sequence next;
    Sequence dummy; //to indicate end
    
    SequenceIterator begin()
    {
        MyInteger sen = new MyInteger();
        sen.Set(-1);  //set new int to -1
        
        if(dummy == null)
        {
            dummy = new Sequence(sen,null);
        }
        add(dummy,length()); //end sequence with sentinial val = -1
        
        SequenceIterator SI = new SequenceIterator();
        SI.OnIt = this;
        
    return SI;
    } //returns sequence iterator that points to start of sequence
    
    SequenceIterator end()
    {
        SequenceIterator SI = new SequenceIterator();
    
        SI.OnIt = index2(length()-1);
        return SI;
    }   //returns sequence iterator that points to dummy var 
    
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
        //traverses through sequence
        for (Sequence ptr = this; ptr != null; ptr = ptr.next){
            len++;
        }
        
        return len;
    } //returns length of Sequence
    
    public void add(Element elm, int pos){
        Sequence ptr = this, prev = null;
        //finds pos to add element
        for (int i = 0; ptr != null &&  i < pos; i++, ptr = ptr.next){
            prev = ptr;
      
        }
            
        //if prev not null then add element to next else add it to prev
        if (prev != null){
            prev.next = new Sequence(elm, ptr);
        }   
        else {
            if (ptr.e != null)
                this.next = new Sequence(this.e, this.next);
            this.e = elm;
        }
                

    } //add
    
    public void delete(int pos){
        Sequence ptr = this, prev = null;
        //finds pos to delete element
        for (int i = 0; (ptr != null) && (i < pos); ptr = ptr.next){
            prev = ptr;
            i++;
        }
        //shifts everything after deletion   
        if (ptr != null){
            if (prev == null){
                this.e = this.next.e;
                this.next = this.next.next;
            }
            else {
                prev.next = ptr.next;
            }    //if prev has val 
            
        }
    } //delete
    
    public Element index(int pos){
        Sequence ptr = this;
        Element RetVal;
        //checks to make sure valid pos then gets to element
        if(pos >= 0 && pos < length())
        {
            for (int i = 0; i < pos; i++ , ptr = ptr.next);
                RetVal = ptr.e; 
        }
        //if invalid location error
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
            
            //Deals with rest
        return newSeq;
    } //flattens Sequence
    
    
    public Sequence copy(){
        
        Sequence newSeq = new Sequence();
        Sequence ptr = this;
        int i = 0;
        while(ptr != null)
        {
            Element Itr = ptr.e;
            
            //if char element copy and add
            if (Itr instanceof MyChar){
                MyChar newChar = new MyChar();
                newChar.Set(((MyChar)(Itr)).Get());
                newSeq.add(newChar, i);
                }
            //if int element copy and add
            else if(Itr instanceof MyInteger){
                MyInteger newInt = new MyInteger();
                newInt.Set(((MyInteger)(Itr)).Get());
                newSeq.add(newInt,i);
                }    
            //if sequence element copy and add    
            else
            {
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

    
    
    