
class SequenceIterator {
    
    Sequence OnIt;
    Sequence dummy;
    
    SequenceIterator()
    {
        //OnIt = null;
    }//constructor
    
    public boolean equal(SequenceIterator other) 
    {  
        if((OnIt.e == other.OnIt.e))
            return true;
        else
            return false;
    } //checks for equality
    
    SequenceIterator advance()
    {
        OnIt = OnIt.next;
        return this;
    } //next for iterator
    
    Element get()
    {
        //return OnIt.first();
        return OnIt.index(0);
    } //returns element at index 0
    
}