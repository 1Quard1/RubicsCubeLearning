package com.example.rubicscubelearning

import android.util.Log

class Cube(val Orientation: String) {

    private var sideUp = mutableListOf("up","up","up","up","up","up","up","up","up")
    private var sideDown = mutableListOf("down","down","down","down","down","down","down","down","down")
    private var sideRight = mutableListOf("right","right","right","right","right","right","right","right","right")
    private var sideLeft = mutableListOf("left","left","left","left","left","left","left","left","left")
    private var sideFront = mutableListOf("front","front","front","front","front","front","front","front","front")
    private var sideBack = mutableListOf("back","back","back","back","back","back","back","back","back")
    var sides = mutableListOf(sideUp,sideFront,sideDown,sideRight,sideBack,sideLeft)

    fun showCube(){
        Log.d("myLog","$sides")
    }

    fun disassembly(Scramble:MutableList<String>){
        for(i in Scramble){
            when (i){
                "R" -> turnR()
                "R2" -> turnR2()
                "R'" -> turnInverseR()
                "L" -> turnL()
                "L2" -> turnL2()
                "L'" -> turnInverseL()
                "F" -> turnF()
                "F2" -> turnF2()
                "F'" -> turnInverseF()
                "B" -> turnB()
                "B2" -> turnB2()
                "B'" -> turnInverseB()
                "U" -> turnU()
                "U2" -> turnU2()
                "U'" -> turnInverseU()
                "D" -> turnD()
                "D2" -> turnD2()
                "D'" -> turnInverseD()
            }
        }
    }



    private fun turnInSideСlockwise(edge: Int){
        var tempSide = sides[edge][0]
        sides[edge][0] = sides[edge][6]
        sides[edge][6] = sides[edge][8]
        sides[edge][8] = sides[edge][2]
        sides[edge][2] = tempSide
        tempSide = sides[edge][1]
        sides[edge][1] = sides[edge][3]
        sides[edge][3] = sides[edge][7]
        sides[edge][7] = sides[edge][5]
        sides[edge][5] = tempSide
    }
    private fun turnInSideCounterСlockwise(edge: Int){
        var tempSide = sides[edge][0]
        sides[edge][0] = sides[edge][2]
        sides[edge][2] = sides[edge][8]
        sides[edge][8] = sides[edge][6]
        sides[edge][6] = tempSide
        tempSide = sides[edge][1]
        sides[edge][1] = sides[edge][5]
        sides[edge][5] = sides[edge][7]
        sides[edge][7] = sides[edge][3]
        sides[edge][3] = tempSide
    }
    private fun turnInSideDouble(edge: Int){
        var tempSide = sides[edge][0]
        sides[edge][0] = sides[edge][8]
        sides[edge][8] = tempSide
        tempSide = sides[edge][2]
        sides[edge][2] = sides[edge][6]
        sides[edge][6] = tempSide
        tempSide = sides[edge][1]
        sides[edge][1] = sides[edge][7]
        sides[edge][7] = tempSide
        tempSide = sides[edge][3]
        sides[edge][3] = sides[edge][5]
        sides[edge][5] = tempSide
    }
    fun turnR(){
        //Поворот вне грани
        var tempSides = listOf(sides[0][2],sides[0][5],sides[0][8])
        sides[0][2] = sides[1][2]
        sides[0][5] = sides[1][5]
        sides[0][8] = sides[1][8]
        sides[1][2] = sides[2][2]
        sides[1][5] = sides[2][5]
        sides[1][8] = sides[2][8]
        sides[2][2] = sides[4][6]
        sides[2][5] = sides[4][3]
        sides[2][8] = sides[4][0]
        sides[4][0] = tempSides[2]
        sides[4][3] = tempSides[1]
        sides[4][6] = tempSides[0]
        //Поворот внутри грани
        turnInSideСlockwise(3)
    }
    fun turnR2(){
        //Поворот вне грани
        var tempSides = listOf(sides[0][2],sides[0][5],sides[0][8])
        sides[0][2] = sides[2][2]
        sides[0][5] = sides[2][5]
        sides[0][8] = sides[2][8]
        sides[2][2] = tempSides[0]
        sides[2][5] = tempSides[1]
        sides[2][8] = tempSides[2]
        tempSides = listOf(sides[4][6],sides[4][3],sides[4][0])
        sides[4][6] = sides[1][2]
        sides[4][3] = sides[1][5]
        sides[4][0] = sides[1][8]
        sides[1][2] = tempSides[0]
        sides[1][5] = tempSides[1]
        sides[1][8] = tempSides[2]
        //Поворот внутри грани
        turnInSideDouble(3)

    }
    fun turnInverseR(){
        var tempSides = listOf(sides[0][2],sides[0][5],sides[0][8])
        sides[0][2] = sides[4][6]
        sides[0][5] = sides[4][3]
        sides[0][8] = sides[4][0]
        sides[4][0] = sides[2][8]
        sides[4][3] = sides[2][5]
        sides[4][6] = sides[2][2]
        sides[2][2] = sides[1][2]
        sides[2][5] = sides[1][5]
        sides[2][8] = sides[1][8]
        sides[1][2] = tempSides[0]
        sides[1][5] = tempSides[1]
        sides[1][8] = tempSides[2]
        //Поворот внутри грани
        turnInSideCounterСlockwise(3)
    }
    fun turnL(){
        var tempSides = listOf(sides[0][0],sides[0][3],sides[0][6])
        sides[0][0] = sides[4][8]
        sides[0][3] = sides[4][5]
        sides[0][6] = sides[4][2]
        sides[4][2] = sides[2][6]
        sides[4][5] = sides[2][3]
        sides[4][8] = sides[2][0]
        sides[2][0] = sides[1][0]
        sides[2][3] = sides[1][3]
        sides[2][6] = sides[1][6]
        sides[1][0] = tempSides[0]
        sides[1][3] = tempSides[1]
        sides[1][6] = tempSides[2]

        turnInSideСlockwise(5)
    }
    fun turnL2(){
        var tempSides = listOf(sides[0][0],sides[0][3],sides[0][6])
        sides[0][0] = sides[2][0]
        sides[0][3] = sides[2][3]
        sides[0][6] = sides[2][6]
        sides[2][0] = tempSides[0]
        sides[2][3] = tempSides[1]
        sides[2][6] = tempSides[2]
        tempSides = listOf(sides[4][2],sides[4][5],sides[4][8])
        sides[4][2] = sides[1][6]
        sides[4][5] = sides[1][3]
        sides[4][8] = sides[1][0]
        sides[1][0] = tempSides[2]
        sides[1][3] = tempSides[1]
        sides[1][6] = tempSides[0]

        turnInSideDouble(5)
    }
    fun turnInverseL(){
        var tempSides = listOf(sides[0][0],sides[0][3],sides[0][6])
        sides[0][0] = sides[1][0]
        sides[0][3] = sides[1][3]
        sides[0][6] = sides[1][6]
        sides[1][0] = sides[2][0]
        sides[1][3] = sides[2][3]
        sides[1][6] = sides[2][6]
        sides[2][0] = sides[4][8]
        sides[2][3] = sides[4][5]
        sides[2][6] = sides[4][2]
        sides[4][2] = tempSides[2]
        sides[4][5] = tempSides[1]
        sides[4][8] = tempSides[0]

        turnInSideCounterСlockwise(5)
    }
    fun turnU(){
        var tempSides = listOf(sides[1][0],sides[1][1],sides[1][2])
        sides[1][0] = sides[3][0]
        sides[1][1] = sides[3][1]
        sides[1][2] = sides[3][2]
        sides[3][0] = sides[4][0]
        sides[3][1] = sides[4][1]
        sides[3][2] = sides[4][2]
        sides[4][0] = sides[5][0]
        sides[4][1] = sides[5][1]
        sides[4][2] = sides[5][2]
        sides[5][0] = tempSides[0]
        sides[5][1] = tempSides[1]
        sides[5][2] = tempSides[2]

        turnInSideСlockwise(0)
    }
    fun turnU2(){
        var tempSides = listOf(sides[1][0],sides[1][1],sides[1][2])
        sides[1][0] = sides[4][0]
        sides[1][1] = sides[4][1]
        sides[1][2] = sides[4][2]
        sides[4][0] = tempSides[0]
        sides[4][1] = tempSides[1]
        sides[4][2] = tempSides[2]
        tempSides = listOf(sides[3][0],sides[3][1],sides[3][2])
        sides[3][0] = sides[5][0]
        sides[3][1] = sides[5][1]
        sides[3][2] = sides[5][2]
        sides[5][0] = tempSides[0]
        sides[5][1] = tempSides[1]
        sides[5][2] = tempSides[2]

        turnInSideDouble(0)
    }
    fun turnInverseU(){
        var tempSides = listOf(sides[1][0],sides[1][1],sides[1][2])
        sides[1][0] = sides[5][0]
        sides[1][1] = sides[5][1]
        sides[1][2] = sides[5][2]
        sides[5][0] = sides[4][0]
        sides[5][1] = sides[4][1]
        sides[5][2] = sides[4][2]
        sides[4][0] = sides[3][0]
        sides[4][1] = sides[3][1]
        sides[4][2] = sides[3][2]
        sides[3][0] = tempSides[0]
        sides[3][1] = tempSides[1]
        sides[3][2] = tempSides[2]

        turnInSideCounterСlockwise(0)
    }
    fun turnD(){
        var tempSides = listOf(sides[1][6],sides[1][7],sides[1][8])
        sides[1][6] = sides[5][6]
        sides[1][7] = sides[5][7]
        sides[1][8] = sides[5][8]
        sides[5][6] = sides[4][6]
        sides[5][7] = sides[4][7]
        sides[5][8] = sides[4][8]
        sides[4][6] = sides[3][6]
        sides[4][7] = sides[3][7]
        sides[4][8] = sides[3][8]
        sides[3][6] = tempSides[0]
        sides[3][7] = tempSides[1]
        sides[3][8] = tempSides[2]

        turnInSideСlockwise(2)
    }
    fun turnD2(){
        var tempSides = listOf(sides[1][6],sides[1][7],sides[1][8])
        sides[1][6] = sides[4][6]
        sides[1][7] = sides[4][7]
        sides[1][8] = sides[4][8]
        sides[4][6] = tempSides[0]
        sides[4][7] = tempSides[1]
        sides[4][8] = tempSides[2]
        tempSides = listOf(sides[3][6],sides[3][7],sides[3][8])
        sides[3][6] = sides[5][6]
        sides[3][7] = sides[5][7]
        sides[3][8] = sides[5][8]
        sides[5][6] = tempSides[0]
        sides[5][7] = tempSides[1]
        sides[5][8] = tempSides[2]

        turnInSideDouble(2)
    }
    fun turnInverseD(){
        var tempSides = listOf(sides[1][6],sides[1][7],sides[1][8])
        sides[1][6] = sides[3][6]
        sides[1][7] = sides[3][7]
        sides[1][8] = sides[3][8]
        sides[3][6] = sides[4][6]
        sides[3][7] = sides[4][7]
        sides[3][8] = sides[4][8]
        sides[4][6] = sides[5][6]
        sides[4][7] = sides[5][7]
        sides[4][8] = sides[5][8]
        sides[5][6] = tempSides[0]
        sides[5][7] = tempSides[1]
        sides[5][8] = tempSides[2]

        turnInSideCounterСlockwise(2)
    }
    fun turnF(){
        var tempSides = listOf(sides[0][6],sides[0][7],sides[0][8])
        sides[0][6] = sides[5][8]
        sides[0][7] = sides[5][5]
        sides[0][8] = sides[5][2]
        sides[5][2] = sides[2][0]
        sides[5][5] = sides[2][1]
        sides[5][8] = sides[2][2]
        sides[2][0] = sides[3][6]
        sides[2][1] = sides[3][3]
        sides[2][2] = sides[3][0]
        sides[3][0] = tempSides[0]
        sides[3][3] = tempSides[1]
        sides[3][6] = tempSides[2]

        turnInSideСlockwise(1)
    }
    fun turnF2(){
        var tempSides = listOf(sides[0][6],sides[0][7],sides[0][8])
        sides[0][6] = sides[2][2]
        sides[0][7] = sides[2][1]
        sides[0][8] = sides[2][0]
        sides[2][0] = tempSides[2]
        sides[2][1] = tempSides[1]
        sides[2][2] = tempSides[0]
        tempSides = listOf(sides[3][0],sides[3][3],sides[3][6])
        sides[3][0] = sides[5][8]
        sides[3][3] = sides[5][5]
        sides[3][6] = sides[5][2]
        sides[5][2] = tempSides[2]
        sides[5][5] = tempSides[1]
        sides[5][8] = tempSides[0]

        turnInSideDouble(1)
    }
    fun turnInverseF(){
        var tempSides = listOf(sides[0][6],sides[0][7],sides[0][8])
        sides[0][6] = sides[3][0]
        sides[0][7] = sides[3][3]
        sides[0][8] = sides[3][6]
        sides[3][0] = sides[2][2]
        sides[3][3] = sides[2][1]
        sides[3][6] = sides[2][0]
        sides[2][0] = sides[5][2]
        sides[2][1] = sides[5][5]
        sides[2][2] = sides[5][8]
        sides[5][2] = tempSides[2]
        sides[5][5] = tempSides[1]
        sides[5][8] = tempSides[0]

        turnInSideCounterСlockwise(1)
    }
    fun turnB(){
        var tempSides = listOf(sides[0][0],sides[0][1],sides[0][2])
        sides[0][0] = sides[3][2]
        sides[0][1] = sides[3][5]
        sides[0][2] = sides[3][8]
        sides[3][2] = sides[2][8]
        sides[3][5] = sides[2][7]
        sides[3][8] = sides[2][6]
        sides[2][6] = sides[5][0]
        sides[2][7] = sides[5][3]
        sides[2][8] = sides[5][6]
        sides[5][0] = tempSides[2]
        sides[5][3] = tempSides[1]
        sides[5][6] = tempSides[0]

        turnInSideСlockwise(4)
    }
    fun turnB2(){
        var tempSides = listOf(sides[0][0],sides[0][1],sides[0][2])
        sides[0][0] = sides[2][8]
        sides[0][1] = sides[2][7]
        sides[0][2] = sides[2][6]
        sides[2][6] = tempSides[2]
        sides[2][7] = tempSides[1]
        sides[2][8] = tempSides[0]
        tempSides = listOf(sides[3][2],sides[3][5],sides[3][8])
        sides[3][2] = sides[5][6]
        sides[3][5] = sides[5][3]
        sides[3][8] = sides[5][0]
        sides[5][0] = tempSides[2]
        sides[5][3] = tempSides[1]
        sides[5][6] = tempSides[0]

        turnInSideDouble(4)
    }
    fun turnInverseB(){
        var tempSides = listOf(sides[0][0],sides[0][1],sides[0][2])
        sides[0][0] = sides[5][6]
        sides[0][1] = sides[5][3]
        sides[0][2] = sides[5][0]
        sides[5][0] = sides[2][6]
        sides[5][3] = sides[2][7]
        sides[5][6] = sides[2][8]
        sides[2][6] = sides[3][8]
        sides[2][7] = sides[3][5]
        sides[2][8] = sides[3][2]
        sides[3][2] = tempSides[0]
        sides[3][5] = tempSides[1]
        sides[3][8] = tempSides[2]

        turnInSideCounterСlockwise(4)
    }
}