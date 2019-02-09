package com.github.andrewgazelka.twelvedaysofchristmas

fun main() {
    val listOf = listOf(
        "Partridge in a Pear Tree",
        "Turtle Doves",
        "French Hens",
        "Calling Birds",
        "Golden Rings",
        "Geese a Laying",
        "Swans a Swimming",
        "Maids a Milking",
        "Ladies Dancing",
        "Lords a-leaping",
        "Pipers Piping",
        "Drummers Drumming"
    )

    (0 until listOf.size).map { i ->

        val day = i+1

        val sliced = listOf.slice(0..i)
        buildString {
            append("On the ${day.ith()} day of Christmas my true love sent to me ")

            if(sliced.isEmpty()) append("a ${sliced.last()}")
            else append(sliced.reversed().mapIndexed { j, s ->
                val num = i - j + 1
                if(num == 1) return@mapIndexed "and a $s"
                return@mapIndexed "$num $s"
            }.joinToString())
        }
    }.forEach { println(it) }
}

fun Int.ith(): String {
    return "$this" + when(this % 10 ){
        1 -> "st"
        2 -> "nd"
        3 -> "rd"
        else -> "th"
    }
}
