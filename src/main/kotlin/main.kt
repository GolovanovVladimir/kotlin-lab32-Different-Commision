package ru.netology

val minAmount = 0


fun main() {
    var flag = -1
    var typeCard = "VK Pay"

    println("Программа расчета при переводе")
    while (flag == -1) {
        println("Выберите сумму операции текущей операции в рублях: ")
        println("0-Выход из программы")

        var input = readLine()!!
        when (input) {
            "0" -> {
                flag = 0; break
            }
        }
        var amountCurrent: Double = input.toDouble()

        println("Выберите тип карты: ")
        println("1-MASTER / MAESTRO")
        println("2-VISA / МИР")
        println("3-VK Pay (по умолчанию)")
        println("0-Выход из программы")

        input = readLine()!!
        when (input) {
            "0" -> {
                flag = 0; break
            }
            "1" -> typeCard = "MASTER / MAESTRO"
            "2" -> typeCard = "VISA / МИР"
            "3" -> typeCard = "VK Pay"
        }


        calculateCommission(typeCard, 37_000.0 , amountCurrent)

    }
 println("Программа расчета процентов закончила свою работу.")
}

fun calculateCommission(cardType :String = "VK Pay", amountsPrevious : Double = 0.0 ,amountCurrent: Double ) {
    var minMasterLimit = 300
    var maxMasterLimit = 75_000
    var percentMasterCommission = 0.6
    var amountMasterCommission = 20.0
    var amountCommission = 0.0
    var minVisaLimit = 35.0
    var percentVisaCommission = 0.75
    var maxVKPayOperation = 15_000
    var maxVKPayMonthOperation = 40_000
    var limitOperation = 150_000.0
    var limitMonth = 600_000.0
    var flag = 0

    when (cardType) {
        "MASTER / MAESTRO" -> {
            if ((amountCurrent < minMasterLimit) || (amountCurrent > maxMasterLimit)) {
                amountCommission = amountCurrent / 100 * percentMasterCommission + amountMasterCommission
            } else {
                amountCommission = 0.0
            }
        }

        "VISA / МИР" -> {
            if (amountCurrent > minVisaLimit) {
                amountCommission = amountCurrent / 100 * percentVisaCommission
            } else {
                println("Операция невозможна : операция меньше $minVisaLimit по карте $cardType!")
                flag = 2
            }
        }

        else -> amountCommission =0.0
   }

    if (cardType == "MASTER / MAESTRO"){
        if (limitOperation > amountCurrent) {
            if (limitMonth > (amountCurrent + amountsPrevious)) {
                println("В планируете перечислить с карты $cardType сумму $amountCurrent  руб., ранее перечисляли $amountsPrevious руб.")
                println("Комиссия по операции $amountCommission руб.")
                println("")
            } else println("Операция невозможна : превышен лимит по месяцу по карте $cardType!")
        } else println("Операция невозможна : превышен лимит на операцию по карте $cardType!")
    }

    if ((cardType == "VISA / МИР")&& (flag!=2)){
        if (limitOperation > amountCurrent) {
            if (limitMonth > (amountCurrent + amountsPrevious)) {
                println("В планируете перечислить с карты $cardType сумму $amountCurrent  руб., ранее перечисляли $amountsPrevious руб.")
                println("Комиссия по операции $amountCommission руб.")
                println("")
            } else println("Операция невозможна : превышен лимит по месяцу по карте $cardType!")
        } else println("Операция невозможна : превышен лимит на операцию по карте $cardType!")
    }


        if (cardType == "VK Pay") {
            if (maxVKPayOperation > amountCurrent) {
                if (maxVKPayMonthOperation > (amountCurrent+amountsPrevious)) {
                    println("В планируете перечислить с карты $cardType сумму $amountCurrent  руб., ранее перечисляли $amountsPrevious руб.")
                    println("Комиссия по операции $amountCommission руб.")
                    println("")
                }
                else println("Операция невозможна : превышена макс.сумма по месяцу по карте $cardType!")
            }
            else println("Операция невозможна : превышена макс.сумма на операцию по карте $cardType!")
        }
}
