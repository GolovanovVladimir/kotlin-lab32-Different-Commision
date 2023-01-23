package ru.netology

fun main() {
    var flag = -1
    var percentCommission = 0.75
    val minAmount = 35
//    var input : String

    println("Программа расчета при переводе")
    while (flag == -1) {
        println("Выберите сумму операции в рублях: ")
        println("0-Выход из программы")

        var input = readLine()!!
        when (input) {
            "0" -> {
                flag = 0; break
            }
        }
        var amount: Int = input.toInt()
        println("В планируете перечислить $amount  руб.")
        if (amount >= minAmount) println("Комиссия банка составит ${amount /100 * percentCommission} руб.")
        else {
            println("Операция невозможна: сумма меньше минимума")
        }
        println("")
    }
 println("Программа расчета процентов закончила свою работу.")
}
