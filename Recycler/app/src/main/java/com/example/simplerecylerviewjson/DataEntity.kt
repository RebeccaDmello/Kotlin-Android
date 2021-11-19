package com.example.simplerecylerviewjson

import java.util.*

data class DataEntity (
    var id: Int,
    var date: Date,
    var text: String
){
    constructor() : this(1, Date(),"")
    constructor(date: Date, text: String) : this(1, date, text)
}