# Sudoku Java Game

This project is a Java implementation of a Sudoku game, consisting of two main classes: `Sudoku` and `Square3x3`.

## Square3x3 Class

The `Square3x3` class represents a 3x3 square within the Sudoku board. It provides the following constructors and methods:

### Constructors:

1. `Square3x3()`: Initializes a 3x3 square with values of -1 in each cell.

2. `Square3x3(int[][] array)`: Constructs a 3x3 square using values from a given 2-dimensional array. If the array is larger than 3x3, only the first 3x3 cells are considered. If it's smaller, the remaining cells are initialized to -1.

3. `Square3x3(Square3x3 other)`: Copy constructor that creates a new 3x3 square using the values from another `Square3x3` object.

### Methods:

- `int getCell(int row, int col)`: Returns the value in the specified cell. Returns -1 if the row and/or col are out of bounds.

- `void setXY(int row, int col, int value)`: Sets the value of the specified cell. Does nothing if the row and/or col are out of bounds.

- `String toString()`: Returns a string representation of the square in the format of three rows, separated by tabs, with each row containing three digits.

- `boolean allThere()`: Checks if all numbers from 1 to 9 are present in the square. Returns true if all are present, otherwise false.

- `void whosThereRow(int row, boolean[] values)`: Sets the values in the given boolean array to true if the corresponding number from 1 to 9 exists in the specified row.

- `void whosThereCol(int col, boolean[] values)`: Similar to `whosThereRow`, but for columns.

## Sudoku Class

The `Sudoku` class represents the entire Sudoku board, consisting of 9x9 `Square3x3` squares. It provides the following constructors and methods:

### Constructors:

1. `Sudoku()`: Initializes a Sudoku board with all cells set to -1.

2. `Sudoku(Square3x3[][] square3x3Array)`: Constructs a Sudoku board using an array of `Square3x3` objects.

### Methods:

- `Boolean isValid()`: Checks if the Sudoku board is valid according to Sudoku rules. Returns true if valid, otherwise false.

## Usage

You can use these classes to create and validate Sudoku boards. Make sure to adhere to the provided method signatures and follow the documentation.

Good luck with your Sudoku Java project!
