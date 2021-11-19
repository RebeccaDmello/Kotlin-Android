package com.example.midterm_300322984

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.midterm_300322984.databinding.ListItemBinding
import com.example.midterm_300322984.db.JobEntity

class JobAdapter(private val jobList: List<JobEntity>?, private val listener: ListItemListener) : RecyclerView.Adapter<JobAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ListItemBinding.bind(itemView)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: JobAdapter.ViewHolder, position: Int) {
        val job = jobList?.get(position)
        with(holder.binding) {
            if (job != null) {
                //Setting of main content of recyclerView, add more fields by "+"
                title.setText(job.JobId.toString() + " | " + job.SalaryF + "-" + job.SalaryT + " | " +job.NoOfPos + " | " + job.BusinessTitle + " | " + job.JobDescription.substring(0, 20))
            }
            root.setOnClickListener {
                if (job != null) {
                    listener.itemClicked(job.JobId)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        if (jobList != null) {
            return jobList.size
        }
        return 0;
    }

    // implemented in MainFragment
    interface ListItemListener {
        fun itemClicked(JobId: Int)
    }
}