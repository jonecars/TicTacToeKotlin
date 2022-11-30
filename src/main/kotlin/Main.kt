
// TicTacToe game

class Game {
    // Board
    var board = arrayOf(
        arrayOf("      1       2       3   "),
        arrayOf("  A  ","*","  |  ","*","  |  ","*","   "),
        arrayOf("    ------ ------- -----  "),
        arrayOf("  B  ","*","  |  ","*","  |  ","*","   "),
        arrayOf("    ------ ------- -----  "),
        arrayOf("  C  ","*","  |  ","*","  |  ","*","   "))
    var turn = ""
    var turn_number = 0
    var cord = "a"
    var finished = false
    fun display_board() {

        for (i in 0..5){
            println(board[i].contentToString().replace(",","").replace("]","").replace("[",""))
        }

//        println(board[0].contentToString().replace(",","").replace("]","").replace("[",""))
//        println(board[1].contentToString().replace(",","").replace("]","").replace("[",""))
//        println(board[2].contentToString().replace(",","").replace("]","").replace("[",""))
//        println(board[3].contentToString().replace(",","").replace("]","").replace("[",""))
//        println(board[4].contentToString().replace(",","").replace("]","").replace("[",""))
//        println(board[5].contentToString().replace(",","").replace("]","").replace("[",""))
        println("  =======================")

    }

    fun update_board() {
        var updated = false
        while(!updated) {

        if (cord.uppercase() == "A1")
        {board[1][1] = turn
         updated = true
        }else if (cord.uppercase() == "A2"){
            board[1][3] = turn
            updated = true
        }else if (cord.uppercase() == "A3"){
            board[1][5] = turn
            updated = true
        }else if (cord.uppercase() == "B1"){
            board[3][1] = turn
            updated = true
        }else if (cord.uppercase() == "B2"){
            board[3][3] = turn
            updated = true
        }else if (cord.uppercase() == "B3"){
            board[3][5] = turn
            updated = true
        }else if (cord.uppercase() == "C1"){
            board[5][1] = turn
            updated = true
        }else if (cord.uppercase() == "C2"){
            board[5][3] = turn
            updated = true
        }else if (cord.uppercase() == "C3"){
            board[5][5] = turn
            updated = true
        }else {
            println("Invalid Placement")
            input_manager()
        }
        }
    }

    fun play_game() {


        while(!finished)  {

            // Display Board
            display_board()
            // Determine Turn
            var turn = determine_turn()
            // Get Input
            input_manager()
            // Update Board
            update_board()
            // Display Board
            println()

            println("  =======================")
            // Check for winner
            check_win()
        }
        display_board()
        println("$turn wins!")
    }

    fun check_win(){
        // Check Across
        if (board[1][1] == board[1][3] && board[1][1] == board[1][5] && board[1][1] != "*"){
            finished = true

        }else if (board[3][1] == board[3][3] && board[3][1] == board[3][5] && board[3][1] != "*"){
            finished = true

        }else if (board[5][1] == board[5][3] && board[5][1] == board[5][5] && board[5][1] != "*"){
            finished = true

        }
        // Check Diagonal
        else if (board[1][1] == board[3][3] && board[1][1] == board[5][5] && board[1][1] != "*"){
            finished = true
        }else if (board[5][1] == board[3][3] && board[5][1] == board[1][5] && board[5][1] != "*"){
            finished = true
        }

        // Check Vertical
        else if (board[1][1] == board[3][1] && board[1][1] == board[5][1] && board[1][1] != "*"){
            finished = true

        }else if (board[1][3] == board[3][3] && board[1][3] == board[5][3] && board[1][3] != "*"){
            finished = true

        }else if (board[1][5] == board[3][5] && board[5][5] == board[1][5] && board[1][5] != "*"){
            finished = true

        }

    }

    fun input_manager(){
        println("It is $turn's turn!")
        println("Where would you like to place your piece? Ex:[A1] ")
        cord = readLine().toString()

    }

     fun determine_turn(){
         turn_number += 1
         if (turn_number % 2 == 0) {
            turn = "O"
         }else{
             turn = "X"
         }
         }
}
fun main(args: Array<String>) {

    var ticTacToe = Game()
    ticTacToe.play_game()

}