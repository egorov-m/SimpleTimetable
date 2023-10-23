package com.example.simpletimetable.timetable

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.simpletimetable.databinding.DailyTimetableItemBinding
import com.example.simpletimetable.databinding.DaySeparatorBinding

class TimetableAdapter : RecyclerView.Adapter<TimetableAdapter.TimetableViewHolder>() {

    private val timetable: MutableList<TimetableItemData> = mutableListOf()

    override fun getItemViewType(position: Int): Int {
        return timetable[position].dataType.ordinal
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimetableViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            TimetableViewType.StudyPair.ordinal -> {
                val binding = DailyTimetableItemBinding.inflate(inflater, parent, false)
                StudyPairViewHolder(binding)
            }

            TimetableViewType.DaySeparator.ordinal -> {
                val binding = DaySeparatorBinding.inflate(inflater, parent, false)
                DaySeparatorViewHolder(binding)
            }

            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemCount(): Int = timetable.size

    override fun onBindViewHolder(holder: TimetableViewHolder, position: Int) {
        holder.onBind(timetable[position])
    }

    fun submitList(list: List<TimetableItemData>) {
        timetable.addAll(list)
    }

    abstract class TimetableViewHolder(
        binding: ViewBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        abstract fun onBind(item: TimetableItemData)
    }

    class StudyPairViewHolder(
        private val binding: DailyTimetableItemBinding
    ) : TimetableViewHolder(binding) {
        override fun onBind(item: TimetableItemData) = with(binding) {
            dailyTimetableListItemStartTime.text = item.startTime
            dailyTimetableListItemEndTime.text = item.endTime
            dailyTimetableListItemSubjectName.text = item.subjectName
            dailyTimetableListItemClassroom.text = item.classroom
            dailyTimetableListItemTeachers.text = item.teachers
        }
    }

    class DaySeparatorViewHolder(
        private val binding: DaySeparatorBinding
    ) : TimetableViewHolder(binding) {
        override fun onBind(item: TimetableItemData) = with(binding) {
            dailyTimetableWeekDay.text = item.weekDayTitle
            dailyTimetableDayPairs.text = item.pairsSubtitle
        }
    }
}
