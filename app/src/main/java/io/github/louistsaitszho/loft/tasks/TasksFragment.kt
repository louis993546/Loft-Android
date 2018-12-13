/*
 * This file is part of Loft Android Client.

 * Loft Android Client is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * Loft Android Client is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with Loft Android Client.  If not, see <https://www.gnu.org/licenses/>.
 */
package io.github.louistsaitszho.loft.tasks

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.louistsaitszho.loft.R
import kotlinx.android.synthetic.main.fragment_tasks.*
import org.koin.android.viewmodel.ext.android.viewModel

class TasksFragment : Fragment() {
    private val vm: TasksViewModel by viewModel()
    private val adapter: TaskAdapter by lazy { TaskAdapter() }
    private val layoutManager: RecyclerView.LayoutManager by lazy {
        LinearLayoutManager(requireContext())
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_tasks, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_view_tasks.layoutManager = layoutManager
        recycler_view_tasks.adapter = adapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        vm.tasksListLiveData.observe(viewLifecycleOwner, Observer {
            adapter.updateTaskList(it.orEmpty())
        })
        vm.triggerTaskListFetching()
    }
}