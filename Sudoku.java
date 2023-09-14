
/**
 * Class Sudoku. Represent the board of a sudoku game as a
 * quadratic two-dimensional array Of square3x3.
 *
 * @author (Sagi Menahem)
 * @version (11.12.21)
 */
public class Sudoku
{
    //declarations:
    private Square3x3[][] _sudoku;

    private static final int SIZE_OF_THE_ROW = 3;
    private static final int SIZE_OF_THE_COL = 3;

    //constructors:
    /**
     * Empty constructor for objects of class Sudoku.
     * Constructs a new sudoku board So it consists of class
     * square3x3 objects that are all filled in -1 by default.
     *
     */
    public Sudoku(){
        this._sudoku = new Square3x3[SIZE_OF_THE_ROW][SIZE_OF_THE_COL];
        
        //set default value (-1) in all the square in the sudoku board
        for (int i = 0; i < SIZE_OF_THE_ROW; i++)
            for (int j = 0; j < SIZE_OF_THE_COL; j++)
                //using the empty constructor of square3x3 class
                this._sudoku[i][j] = new Square3x3();
    } //Sudoku()

    /**
     * Second constructor for objects of class Sudoku.
     * Construct a new sudoku board with the specified value from the square3x3Array.
     *
     * @param  square3x3Array - represents a board of a sudoku game as a
     * quadratic two-dimensional array Of square3x3
     */
    public Sudoku(Square3x3[][] square3x3Array){
        this._sudoku = new Square3x3[SIZE_OF_THE_ROW][SIZE_OF_THE_COL];
        
        //set the value of the square3x3Array in te current sudoku
        for (int i = 0; i < SIZE_OF_THE_ROW; i++)
            for (int j = 0; j < SIZE_OF_THE_COL; j++)
                this._sudoku[i][j] = new Square3x3(square3x3Array[i][j]);
    } //Sudoku(Square3x3[][] square3x3Array)

    //public methods:
    /**
     * Checks if the sudoku board are valid.
     *
     * @return    true - if the dudoku board are valid.
     * false - else.
     */
    public Boolean isValid(){
        //going over all the squares and check if all the number are there
        for (int i = 0; i < SIZE_OF_THE_ROW; i++)
            for (int j = 0; j < SIZE_OF_THE_COL; j++)
                if (!this._sudoku[i][j].allThere())
                    return false;

        boolean[] values;
        //going over all the rows in the sudoku board separately
        for (int i = 0; i < SIZE_OF_THE_ROW; i++)
            for (int j = 0; j < SIZE_OF_THE_COL; j++){
                //resets the array of values
                values = getNewBooleanArray();
                for (int g = 0; g < SIZE_OF_THE_COL; g++){
                    /* check which number are there in a specified row and a specified
                    square of the sudoku board */
                    this._sudoku[i][g].whosThereRow(j, values);
                    //update the values array from the specified square3x3 class
                    values = this._sudoku[i][g]._values;
                }
                //if not all the number are in the specified row of te sudoku board
                if (!booleanArrayIsValid(values))
                    return false;
            }

        //going over all the cols in the sudoku board separately
        for (int i = 0; i < SIZE_OF_THE_COL; i++)
            for (int j = 0; j < SIZE_OF_THE_ROW; j++){
                //resets the array of values
                values = getNewBooleanArray();
                for (int g = 0; g < SIZE_OF_THE_ROW; g++){
                    /* check which number are there in a specified col and a specified
                    square of the sudoku board */
                    this._sudoku[g][i].whosThereCol(j, values);
                    //update the values array from the specified square3x3 class
                    values = this._sudoku[i][g]._values;
                }
                //if not all the number are in the specified col of te sudoku board
                if (!booleanArrayIsValid(values))
                    return false;
            }
        
        //if the sudoku board are valid
        return true;
    } //isValid()

    //private methods:
    private boolean booleanArrayIsValid(boolean[] array){
        for (int i = 1; i < array.length; i++) //going over the array
            if (!array[i]) //if a number not exists
                return false;
        return true;
    } //booleanArrayIsValid(boolean[] array)

    private boolean[] getNewBooleanArray(){
        boolean[] array = new boolean[10];

        for (int i = 0; i < array.length; i++) //going over the array
            array[i] = false; //set false in the cell

        return array;
    } //getNewBooleanArray()
} //Class Sudoku