package br.com.gilson.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Gilson Maciel on 18/10/2015.
 */
public class DateUtil {
    companion object Util {
        fun dayOfWeek(date: Date): String {
            val formatter = SimpleDateFormat("E");
            return formatter.format(date)
        }
    }
}

