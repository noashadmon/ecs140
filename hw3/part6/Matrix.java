
    
  class Matrix extends Sequence {
      int row_size, col_size; 
      
    // constructor for creating a matrix of specific number of rows and columns
    public Matrix(int rowsize, int colsize)
    {
       row_size = rowsize;
       col_size = colsize;
       //matrix = new Sequence();
       
       int Position = 0;
       
       for(int i = 0; i < row_size; i++)
       {
           for(int j = 0; j < col_size; j++)
           {
               MyInteger Temp = new MyInteger();
               super.add(Temp,Position);
               Position++;
               
           }
       }//initializing matrix to zeros
    }
    
    
    // set the value of an element
    void Set(int rowsize, int colsize, int value)
    {
        int Position = GetPos(rowsize,colsize);
        Element E = super.index(Position);
        MyInteger obj = ((MyInteger)E);
        obj.Set(value);
    }
    
    
    int GetPos(int rowsize,int colsize)
    {
        int Position = 0;
        int retval = 0; 
        
        for(int i = 0; i < row_size; i++)
        {
            for(int j = 0; j < col_size; j++)
            {
                if((i == rowsize) && (j == colsize))
                    retval = Position;
                Position++;
            }
        }
        
        return retval;
        
    }//rows & cols -> pos
    
    
    // get the value of an element
    int Get(int rowsize, int colsize)
    {
        int Position = GetPos(rowsize,colsize);
        Element E = super.index(Position);
        MyInteger obj = ((MyInteger)E);
        return obj.Get();
        
    }
    
    
    // get the value of an element
    Matrix Sum(Matrix mat)
    {
        Matrix Result = new Matrix(row_size,col_size);
        
       
       for(int i = 0; i < row_size; i++)
       {
           for(int j = 0; j < col_size; j++)
           {
               int TempSum = this.Get(i,j) + mat.Get(i,j);
               Result.Set(i,j,TempSum);
           }
       }
       
       return Result;
    }
    
    // return the product of two matrices: mat & this
    Matrix Product(Matrix mat)
    {
       
       if(col_size != mat.row_size)
       {
           System.out.println("Matrix dimensions incompatible for Product");
           System.exit(1);	
           
       }
       
       
        Matrix Resultx = new Matrix(row_size,mat.col_size);
        for (int row = 0; row < row_size; row++) 
        {
            for (int col = 0; col < mat.col_size; col++) 
            {
                int TempSum = 0;
            // Multiply the row of A by the column of B to get the row, column of product.
                for (int inner = 0; inner < col_size; inner++) 
                    {
                    TempSum = TempSum + (this.Get(row,inner) * mat.Get(inner,col));
                    }
                Resultx.Set(row,col,TempSum);
            }
        }
    
        return Resultx;
        
    }
    
    // print the elements of matrix
    public void Print()
    {
        int Position = 0;
       
       for(int i = 0; i < row_size; i++)
       {
           System.out.print("[ ");	
           for(int j = 0; j < col_size; j++)
           {
               Element E = super.index(Position);
               MyInteger obj = ((MyInteger)E);
               obj.Print();
               System.out.print(" ");
               Position++;
           }
           System.out.print("]\n");
       }
    }
}
  
