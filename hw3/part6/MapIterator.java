public class MapIterator extends SequenceIterator{
    
    //Sequence OnIt;
    
    MapIterator() {
        
    }
    
    public boolean equal(MapIterator other){
        if(OnIt.e == other.OnIt.e)
            return true;
        else
            return false;
    } 
    
    MapIterator advance()
    {
        OnIt = OnIt.next;
        return this;
    }
    
    Pair get()
    {
        return (Pair)(OnIt.index(0));
        //return OnIt;
    }
    
    
    
    
}