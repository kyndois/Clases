
val N = 16

fun main() {
    solveNQ()
}

fun printSolution(board: Array<IntArray>) {
    for (i in 0 until N) {
        for (j in 0 until N) {
            if (board[i][j] == 1) print("Q ")
            else print(". ")
        }
        println()
    }
}

fun isSafe(board: Array<IntArray>, row: Int, col: Int): Boolean {
    var i = 0
    while (i < col) {
        if (board[row][i] == 1) return false
        i++
    }

    i = row
    var j = col
    while (i >= 0 && j >= 0) {
        if (board[i][j] == 1) return false
        i--
        j--
    }

    i = row
    j = col
    while (j >= 0 && i < N) {
        if (board[i][j] == 1) return false
        i++
        j--
    }

    return true
}

fun solveNQUtil(board: Array<IntArray>, col: Int): Boolean {

    if (col >= N) return true
    for (i in 0 until N) {
        if (isSafe(board, i, col)) {

            board[i][col] = 1
            if (solveNQUtil(board, col + 1) == true) return true

            board[i][col] = 0 
        }
    }

    return false
}

fun solveNQ(): Boolean {
    val board = Array(N) { IntArray(N) }
    if (solveNQUtil(board, 0) == false) {
        print("No hay solución")
        return false
    }

    printSolution(board)
    return true
}
