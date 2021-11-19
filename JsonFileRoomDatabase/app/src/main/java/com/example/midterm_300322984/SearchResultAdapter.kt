package com.example.midterm_300322984

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.midterm_300322984.databinding.ListItemBinding
import com.example.midterm_300322984.db.JobEntity

class SearchResultAdapter(private val jobList: List<JobEntity>?) : RecyclerView.Adapter<SearchResultAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ListItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return SearchResultAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchResultAdapter.ViewHolder, position: Int) {
        val job = jobList?.get(position)
        with(holder.binding) {
            if (job != null) {
               // title.setText(job.JobId.toString() + job.JobDescription + job.JobCategory + job.FtPt)
                title.setText("Job ID: " + job.JobId.toString() + "\nAgency: " + job.Agency + "\nPosting Type: " + job.PostingType +
                        "\n# of Pos: " + job.NoOfPos + "\nBusiness Title: " + job.BusinessTitle + "\nCivil Service Title: " + job.CivilServiceTitle+
                        "\nJob Category: " + job.JobCategory+ "\nFull-Time/Part-Time indicator: " + job.FtPt + "\nSalary Range: " + job.SalaryF+ "-" +
                        job.SalaryT+ "\nWork Location: " + job.WorkLocation+ "\nDivision/Work Unit: " + job.WorkUnit+ "\nJob Description: " + job.JobDescription.substring(0,80)+
                        "\nPosting Date: " + job.PostingDate)
            }
        }
    }

    override fun getItemCount(): Int {
        if (jobList != null) {
            return jobList.size
        }
        return 0;
    }
}
