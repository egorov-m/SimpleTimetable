package com.example.simpletimetable.week

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simpletimetable.R
import com.example.simpletimetable.databinding.FragmentWeekBinding
import com.example.simpletimetable.TimetableStorage
import com.example.simpletimetable.timetable.TimetableAdapter

class WeekFragment : Fragment() {

    private var binding: FragmentWeekBinding? = null
    private var adapter: TimetableAdapter = TimetableAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter.submitList(TimetableStorage.all_pairs)
        with(binding?.weekTimetableRecyclerView) {
            this ?: return
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@WeekFragment.adapter
            addItemDecoration(createItemDecorator())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeekBinding.inflate(inflater, container, false)
        return binding?.root
    }

    private fun createItemDecorator() =
        DividerItemDecoration(requireContext(), RecyclerView.VERTICAL).apply {
            ContextCompat.getDrawable(requireContext(), R.drawable.pairs_item_decorator)
                ?.let { this@apply.setDrawable(it) }
        }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            WeekFragment().apply {

            }
    }
}