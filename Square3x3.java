
/**
 * Class Square3x3. The Square3x3 class represents a quadratic two-dimensional
 * array of integers in size 3x3.
 *
 * @author (Sagi Menahem)
 * @version (11.12.21)
 */
public class Square3x3
{
    //declarations:
    private int[][] _square;

    private static final int SIZE_OF_THE_ROW = 3;
    private static final int SIZE_OF_THE_COL = 3;
    private static final int DEFAULT_VALUE = -1;
    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 1;

    public boolean[] _values;

    //constructors:
    /**
     * Empty constructor for objects of class Square3x3.
     * Constructs a new square with the default value of -1.
     *
     */
    public Square3x3(){
        _square = new int[SIZE_OF_THE_ROW][SIZE_OF_THE_COL];
        
        //set -1 in all the cell of the square
        for (int i = 0; i < SIZE_OF_THE_ROW; i++)
            for (int j = 0; j < SIZE_OF_THE_COL; j++)
                this._square[i][j] = DEFAULT_VALUE;
    } //Square3x3()

    /**
     * Second constructor for objects of class Square3x3.
     * Construct a new square with the specified value from the array.
     *
     * @param  array - represents a quadratic two-dimensional
     * array of integers in size 3x3
     */
    public Square3x3(int[][] array){
        _square = new int[SIZE_OF_THE_ROW][SIZE_OF_THE_COL];

        //set the value of the array in the current square
        for (int i = 0; i < SIZE_OF_THE_ROW; i++)
            for(int j = 0; j < SIZE_OF_THE_COL; j++)
                if (i < array.length && j < array[0].length) //the value are valid
                    this._square[i][j] = array[i][j];
                else //the value invalid
                    this._square[i][j] = DEFAULT_VALUE;
    } //Square3x3(int[][] array)

    /**
     * Copy constructor for objects of class Square3x3.
     * Constructs a square using another square.
     *
     * @param  other - The square from which to construct the new object
     */
    public Square3x3(Square3x3 other){
        _square = new int[SIZE_OF_THE_ROW][SIZE_OF_THE_COL];
        
        //set the value of other square in the current square
        for (int i = 0; i < SIZE_OF_THE_ROW; i++)
            for (int j = 0; j < SIZE_OF_THE_COL; j++)
                this._square[i][j] = other._square[i][j];
    } //Square3x3(Square3x3 other)

    //public methods:
    /**
     * Returns the value in the (row, col) cell.
     * If the row and/or col are out of the array bounds,
     * returns –1. Legal values for row/col are 0,1,2.
     *
     * @param  row - identification of the row in the square
     * @param  col - identification of the col in the square
     * @return    the value in the (row, col) cell
     */
    public int getCell(int row, int col){
        if (row < SIZE_OF_THE_ROW && row >= 0 && //the row are valid
        col < SIZE_OF_THE_COL && col >=0) //the col are valid
            return this._square[row][col];
        else //the row or col are invalid
            return DEFAULT_VALUE;
    } //getCell(int row, int col)

    /**
     * Sets the cell (row, col) in the array to the given value.
     * If the row and/or col are out of the array bounds –
     * does nothing. Legal values for row/col are 0,1,2.
     *
     * @param  row - identification of the row in the square
     * @param  col - identification of the col in the square
     * @param  value - the new value in the (row, col) cell
     */
    public void setXY(int row, int col, int value){
        if (row < SIZE_OF_THE_ROW && row >= 0 && //the row are valid
        col < SIZE_OF_THE_COL && col >= 0) //the col are valid
            this._square[row][col] = value; //update the cell
    } //setXY(int row, int col, int value)

    /**
     * Returns a String representation of the array.
     *
     * @return    the string representation of the array
     */
    public String toString(){
        String text = "";
        for (int i = 0; i < SIZE_OF_THE_ROW; i++){ //going over the rows
            for (int j = 0; j < SIZE_OF_THE_COL; j++){ //going over the cols
                text+= this._square[i][j];
                if (j != SIZE_OF_THE_COL - 1) //if it not the last cell in the row
                    text+= "\t";
            }
            //add \n in the end of the row
            text+= "\n";
        }
        return text;
    } //String toString()

    /**
     * Checks if all the number from 1 until 9 are in te square.
     *
     * @return    true - if all the number from 1 until 9 are in the square.
     * false - else.
     */
    public boolean allThere(){
        String values = "";
        int temp;

        for (int i = 0; i < SIZE_OF_THE_ROW; i++) //going over the rows
            for (int j = 0; j < SIZE_OF_THE_COL; j++){ //going over the cols
                //save the specified cell
                temp = this._square[i][j];
                //if the specified cell are valid
                if (temp >= MIN_NUMBER && temp <= MAX_NUMBER)
                    //add the cell to values
                    values+= temp;
                else //if the specified cell are invalid
                    return false;
            }

        //check if there are same valid number in this square
        for (int i = 0; i < values.length(); i++)
            for (int j = i + 1; j < values.length(); j++){
                if (values.charAt(i) == values.charAt(j))
                    return false;
            }

        return true;
    } //allThere()

    /**
     * Checks which number in the specified row are existing and update
     * the result in the array of boolean.
     *
     * @param  row - identification of the row in the square
     * @param  values - represents in the array which numbers exist
     */
    public void whosThereRow (int row, boolean[] values){
        if (row >= 0 && row < SIZE_OF_THE_ROW){ //the row is valid
            int temp;
            for (int i = 0; i < SIZE_OF_THE_COL; i++){
                temp = this._square[row][i];
                //if the specified cell is valid
                if (temp >= MIN_NUMBER && temp <=MAX_NUMBER)
                    values[temp] = true;
            }
        }
        _values = values;
    } //whosThereRow (int row, boolean[] values)

    /**
     * Checks which number in the specified col are existing and update
     * the result in the array of boolean.
     *
     * @param  col - identification of the col in the square
     * @param  values - represents in the array which numbers exist
     */
    public void whosThereCol (int col, boolean[] values){
        if (col >= 0 && col < SIZE_OF_THE_COL){ //the col is valid
            int temp;
            for (int i = 0; i < SIZE_OF_THE_ROW; i++){
                temp = this._square[i][col];
                //if the specified cell is valid
                if (temp >= MIN_NUMBER && temp <=MAX_NUMBER)
                    values[temp] = true;
            }
        }
        _values = values;
    } //whosThereCol (int col, boolean[] values)
} //class Square3x3
