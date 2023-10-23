package com.example.simpletimetable

import com.example.simpletimetable.timetable.TimetableItemData

object TimetableStorage {

    val today_pairs = listOf(
        TimetableItemData(
            weekDayTitle = "Monday",
            pairsSubtitle = "2 pairs from 11:20 to 14:45"),
        TimetableItemData(
            startTime = "11:20",
            endTime = "12:50",
            subjectName = "Title 1",
            classroom = "Classroom 1",
            teachers = "Teacher",
            weekNumber = 1),
        TimetableItemData(
            startTime = "13:15",
            endTime = "14:45",
            subjectName = "Title 2",
            classroom = "Classroom 2",
            teachers = "Teacher",
            weekNumber = 1)
    )

    val all_pairs = listOf(
        TimetableItemData(
            weekDayTitle = "Monday",
            pairsSubtitle = "2 pairs from 11:20 to 14:45"),
        TimetableItemData(
            startTime = "11:20",
            endTime = "12:50",
            subjectName = "Title 1",
            classroom = "Classroom 1",
            teachers = "Teacher",
            weekNumber = 1),
        TimetableItemData(
            startTime = "13:15",
            endTime = "14:45",
            subjectName = "Title 2",
            classroom = "Classroom 2",
            teachers = "Teacher",
            weekNumber = 1),
        TimetableItemData(
            weekDayTitle = "Tuesday",
            pairsSubtitle = "3 pairs from 9:40 to 14:45"),
        TimetableItemData(
            startTime = "9:40",
            endTime = "11:10",
            subjectName = "Title 1",
            classroom = "Classroom 1",
            teachers = "Teacher",
            weekNumber = 1),
        TimetableItemData(
            startTime = "11:20",
            endTime = "12:50",
            subjectName = "Title 2",
            classroom = "Classroom 2",
            teachers = "Teacher",
            weekNumber = 1),
        TimetableItemData(
            startTime = "13:15",
            endTime = "14:45",
            subjectName = "Title 3",
            classroom = "Classroom 3",
            teachers = "Teacher",
            weekNumber = 1)
    )
}

