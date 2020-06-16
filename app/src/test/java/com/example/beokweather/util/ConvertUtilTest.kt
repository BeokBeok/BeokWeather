package com.example.beokweather.util

import com.example.beokweather.main.model.Forecast
import com.example.beokweather.main.model.ListItem
import com.example.beokweather.main.model.Main
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ConvertUtilTest {

    private val itemList = mutableListOf<Forecast>()

    @Before
    fun setUp() {
        itemList.add(
            Forecast(
                name = "Bucheon-si",
                list = listOf(
                    ListItem(
                        dtTxt = "Today",
                        icon = "04n",
                        main = Main(temp = "23°", tempMin = "25°", tempMax = "22°")
                    )
                )
            )
        )
        itemList.add(
            Forecast(
                name = "Bucheon-si",
                list = listOf(
                    ListItem(
                        dtTxt = "2021-06-16 15:00:00",
                        icon = "04n",
                        main = Main(temp = "23°", tempMin = "23°", tempMax = "23°")
                    ),
                    ListItem(
                        dtTxt = "2021-06-16 18:00:00",
                        icon = "04n",
                        main = Main(temp = "23°", tempMin = "23°", tempMax = "23°")
                    ),
                    ListItem(
                        dtTxt = "2021-06-16 21:00:00",
                        icon = "04n",
                        main = Main(temp = "23°", tempMin = "23°", tempMax = "23°")
                    ),
                    ListItem(
                        dtTxt = "2021-06-17 15:00:00",
                        icon = "04n",
                        main = Main(temp = "23°", tempMin = "23°", tempMax = "23°")
                    ),
                    ListItem(
                        dtTxt = "2021-06-17 18:00:00",
                        icon = "04n",
                        main = Main(temp = "23°", tempMin = "23°", tempMax = "23°")
                    ),
                    ListItem(
                        dtTxt = "2021-06-17 21:00:00",
                        icon = "04n",
                        main = Main(temp = "23°", tempMin = "23°", tempMax = "23°")
                    )
                )
            )
        )
    }

    @Test
    fun `날씨 리스트를 일 단위로 묶은 리스트로 변환하기`() {
        val convertList = ConvertUtil.convertToWeatherItem(itemList)
        assertEquals(convertList.size, 3)
    }
}