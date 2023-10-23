package com.example.simpletimetable.timetable


enum class TimetableViewType {
    StudyPair,
    DaySeparator
}


data class TimetableItemData(
    val dataType: TimetableViewType,
    val startTime: String?,
    val endTime: String?,
    val subjectName: String?,
    val classroom: String?,
    val teachers: String?,
    val weekNumber: Int?,

    val weekDayTitle: String?,
    val pairsSubtitle: String?
) {
    constructor(
        startTime: String,
        endTime: String,
        subjectName: String,
        classroom: String,
        teachers: String,
        weekNumber: Int) : this(

        TimetableViewType.StudyPair,
        startTime,
        endTime,
        subjectName,
        classroom,
        teachers,
        weekNumber,
        null,
        null)
    constructor(
        weekDayTitle: String,
        pairsSubtitle: String) : this(

        TimetableViewType.DaySeparator,
        null,
        null,
        null,
        null,
        null,
        null,
        weekDayTitle,
        pairsSubtitle)
}
