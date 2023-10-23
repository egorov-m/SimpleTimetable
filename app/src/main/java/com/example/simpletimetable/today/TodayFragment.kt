package com.example.simpletimetable.today

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
import com.example.simpletimetable.databinding.FragmentTodayBinding
import com.example.simpletimetable.TimetableStorage
import com.example.simpletimetable.timetable.TimetableAdapter

class TodayFragment : Fragment() {

    private var binding: FragmentTodayBinding? = null
    private var adapter: TimetableAdapter = TimetableAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter.submitList(TimetableStorage.today_pairs)
        with(binding?.todayTimetableRecyclerView) {
            this ?: return
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@TodayFragment.adapter
            addItemDecoration(createItemDecorator())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTodayBinding.inflate(inflater, container, false)
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
            TodayFragment().apply {

            }
    }
}
