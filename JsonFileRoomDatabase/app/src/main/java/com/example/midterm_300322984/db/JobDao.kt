package com.example.midterm_300322984.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.squareup.moshi.Json

@Dao
interface JobDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE) // it performs an update if it exists
    fun insertJob(job: JobEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(jobs: List<JobEntity>)

    @Query("SELECT * FROM jobDataCollections")
    fun getAll(): LiveData<List<JobEntity>>

    @Query("DELETE from jobDataCollections")
    fun deleteAll()

    @Query("SELECT * FROM jobDataCollections WHERE JobId = :JobId") // :id refers to the parameter //Unique
    fun getJobByJobId(JobId: Int): JobEntity?

    @Query("SELECT * FROM jobDataCollections WHERE Agency = :Agency") // :id refers to the parameter //Unique
    fun getJobByAgency(Agency: String): JobEntity?

    @Query("SELECT * FROM jobDataCollections WHERE PostingType = :PostingType") // :id refers to the parameter
    fun getJobByPostingType(PostingType: String): List<JobEntity>

    @Query("SELECT * FROM jobDataCollections WHERE NoOfPos = :NoOfPos") // :id refers to the parameter
    fun getJobByNoOfPos(NoOfPos: Int): List<JobEntity>

    @Query("SELECT * FROM jobDataCollections WHERE BusinessTitle = :BusinessTitle") // :id refers to the parameter
    fun getJobByBusinessTitle(BusinessTitle: String): List<JobEntity>

    @Query("SELECT * FROM jobDataCollections WHERE CivilServiceTitle = :CivilServiceTitle") // :id refers to the parameter
    fun getJobByServiceTitle(CivilServiceTitle: String): List<JobEntity>

    @Query("SELECT * FROM jobDataCollections WHERE JobCategory = :JobCategory") // :id refers to the parameter
    fun getJobByJobCategory(JobCategory: String): List<JobEntity>

    @Query("SELECT * FROM jobDataCollections WHERE FtPt = :FtPt") // :id refers to the parameter
    fun getJobByFtPt(FtPt: String): List<JobEntity>

    @Query("SELECT * FROM jobDataCollections WHERE SalaryF = :SalaryF") // :id refers to the parameter
    fun getJobBySalaryF(SalaryF: Int): List<JobEntity>

    @Query("SELECT * FROM jobDataCollections WHERE SalaryT = :SalaryT") // :id refers to the parameter
    fun getJobBySalaryT(SalaryT: Int): List<JobEntity>

    @Query("SELECT * FROM jobDataCollections WHERE WorkLocation = :WorkLocation") // :id refers to the parameter
    fun getJobByWorkLocation(WorkLocation: String): List<JobEntity>

    @Query("SELECT * FROM jobDataCollections WHERE WorkUnit = :WorkUnit") // :id refers to the parameter
    fun getJobByWorkUnit(WorkUnit: String): List<JobEntity>

    @Query("SELECT * FROM jobDataCollections WHERE JobDescription = :JobDescription") // :id refers to the parameter
    fun getJobByJobDescription(JobDescription: String): List<JobEntity>

    @Query("SELECT * FROM jobDataCollections WHERE PostingDate = :PostingDate") // :id refers to the parameter
    fun getJobByPostingDate(PostingDate: String): List<JobEntity>
//    @Query("SELECT * FROM jobDataCollections WHERE jobId = :jobid") // :id refers to the parameter //Unique
//    fun getJobByJobId(jobid: Int): JobEntity?

}

//@Json(name = "Agency") var Agency : String,
//@Json(name = "Posting Type") var PostingType : String,
//@Json(name = "# Of Positions") var NoOfPos : Int,
//@Json(name = "Business Title") var BusinessTitle : String,
//@Json(name = "Civil Service Title") var CivilServiceTitle : String,
//@Json(name = "Job Category") var JobCategory : String, //date parsing
//@Json(name = "Full-Time/Part-Time indicator") var FtPt : String,
//@Json(name = "Salary Range From") var SalaryF : Int,
//@Json(name = "Salary Range To") var SalaryT : Int,
//@Json(name = "Work Location") var WorkLocation : String,
//@Json(name = "Division/Work Unit") var WorkUnit : String, //date parsing
//@Json(name = "Job Description") var JobDescription : String,
//@Json(name = "Posting Date") var PostingDate : String