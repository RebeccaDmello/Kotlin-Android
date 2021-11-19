package com.example.simplerecylerviewjson

import java.util.*

class SampleDataProvider {

    companion object{
        private val sampleText1 = "A simple note"
        private val sampleText2 = "A note a\n line feed"
        private val sampleText3 = " Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque finibus, magna eget ullamcorper eleifend, neque justo cursus nibh, sit amet fermentum nisi dui sed justo. Nulla ac nisl ut nulla euismod mollis. Aenean ullamcorper eu odio a rutrum. Mauris eu augue tortor. Pellentesque erat justo, gravida sed maximus eu, faucibus at justo. Aliquam ut nulla consectetur odio vestibulum vulputate vel id est. Aliquam erat volutpat.\n" +
                "\n" +
                "            Fusce maximus sagittis dolor in tempor. Duis vehicula congue lectus eu lobortis. Integer pla"
        private fun getDate(diff: Long): Date{
            return Date(Date().time + diff)
        }

        fun getNotes() = arrayListOf(
            DataEntity(getDate(0), sampleText1),
            DataEntity(getDate(1), sampleText2),
            DataEntity(getDate(2), sampleText3)
        )
    }
}