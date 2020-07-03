public class IntArrayWorker
{
  /** two dimensional matrix */
  private int[][] matrix = null;

  /** set the matrix to the passed one
    * @param theMatrix the one to use
    */
  public void setMatrix(int[][] theMatrix)
  {
    matrix = theMatrix;
  }

  /**
   * Method to return the total
   * @return the total of the values in the array
   */
  public int getTotal()
  {
    int total = 0;
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; col++)
      {
        total = total + matrix[row][col];
      }
    }
    return total;
  }

  /**
   * Method to return the total using a nested for-each loop
   * @return the total of the values in the array
   */
  public int getTotalNested()
  {
    int total = 0;
    for (int[] rowArray : matrix)
    {
      for (int item : rowArray)
      {
        total = total + item;
      }
    }
    return total;
  }

  /**
   * Method to return the number of times a passed integer value is found in the matrix
   * @return the count of how many times passed int is in the metrix
   */
    public int getCount(int value) {
        int total = 0;
        for (int[] rowArray : matrix)
            for (int item : rowArray)
                total += item==value? 1: 0;

        return total;
    }

   /**
    * Method to return the largest value in the matrix
    * @return the largest value in the matrix
    */
    public int getLargest() {
        int max = matrix[0][0];  // so it's always a real value
        for (int[] rowArray : matrix)
            for (int value : rowArray)
                if (max < value)
                    max = value;

          return max;
    }

    /**
     * Method that returns the total of all integers in a specified column
     * @param the index of the column to be totaled
     * @return the total of a given column
     */
    public int getColTotal(int col) {
        int total = 0;
        for (int[] rowArray : matrix)
            total += rowArray[col];

        return total;
    }

  /**
   * Method to fill with an increasing count
   */
  public void fillCount()
  {
    int numCols = matrix[0].length;
    int count = 1;
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < numCols; col++)
      {
        matrix[row][col] = count;
        count++;
      }
    }
  }

  /**
   * print the values in the array in rows and columns
   */
  public void print()
  {
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; col++)
      {
        System.out.print( matrix[row][col] + " " );
      }
      System.out.println();
    }
    System.out.println();
  }


  /**
   * fill the array with a pattern
   */
  public void fillPattern1()
  {
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length;
           col++)
      {
        if (row < col)
          matrix[row][col] = 1;
        else if (row == col)
          matrix[row][col] = 2;
        else
          matrix[row][col] = 3;
      }
    }
  }


}
