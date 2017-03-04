public class Map extends Sequence{
    
    
    public void Print(){
        System.out.print("[");
        for (Sequence ptr = this; ptr != null && ptr.e != null; ptr = ptr.next){
            System.out.print(" ");
            ptr.e.Print();
        }
        System.out.print(" ]");
    } //prints 
    
    MapIterator begin(){
        
         MyInteger sen = new MyInteger();
        sen.Set(-1); 
        
        if(dummy == null)
        {
            dummy = new Sequence(sen,null);
        }
        super.add(dummy,length()); 
    
        MapIterator MI = new MapIterator();
        MI.OnIt = this;
        return MI;
    }
    
    MapIterator end(){
        
        MapIterator MI = new MapIterator();
        MI.OnIt = super.index2(length()-1);
        return MI;
    }
    
    public void add(Pair inval){
        
        int i = 0;
        int position = 0;
        //Sequence ptr = super.index2(0);
        if(super.length() > 0)
        {
        while((i < super.length()) && (index(i) instanceof Pair))
        {
            if(inval.key.Get() >= ((Pair)index(i)).key.Get())
            {
                position++;
            }
            i++;
        }
        }
        super.add(inval,position);
        
    } //add a pair
    
    public MapIterator find(MyChar key){
  
        MapIterator RetVal = end();
        
        for (MapIterator MI = begin(); MI.equal(end()) == false ; MI.advance())
        {
            if(MI.get().key.Get() == key.Get())
            {
                RetVal = MI;
                break;
            }
        }
        
            return RetVal;
        
    }
    
    
    
    
    
}