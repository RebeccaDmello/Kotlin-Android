package com.example.midterm_300322984.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "jobDataCollections")
class JobEntity (
//    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @PrimaryKey
    @Json(name = "Job ID") var JobId : Int,
    @Json(name = "Agency") var Agency : String,
    @Json(name = "Posting Type") var PostingType : String,
    @Json(name = "# Of Positions") var NoOfPos : Int,
    @Json(name = "Business Title") var BusinessTitle : String,
    @Json(name = "Civil Service Title") var CivilServiceTitle : String,
    @Json(name = "Job Category") var JobCategory : String, //date parsing
    @Json(name = "Full-Time/Part-Time indicator") var FtPt : String,
    @Json(name = "Salary Range From") var SalaryF : Int,
    @Json(name = "Salary Range To") var SalaryT : Int,
    @Json(name = "Work Location") var WorkLocation : String,
    @Json(name = "Division/Work Unit") var WorkUnit : String, //date parsing
    @Json(name = "Job Description") var JobDescription : String,
    @Json(name = "Posting Date") var PostingDate : String

/*{
    "Job ID": 425076,
    "Agency": "DISTRICT ATTORNEY RICHMOND COU",
    "Posting Type": "Internal",
    "# Of Positions": 1,
    "Business Title": "Administrative Supervisor",
    "Civil Service Title": "COMMUNITY COORDINATOR",
    "Job Category": "Administration & Human Resources",
    "Full-Time/Part-Time indicator": "F",
    "Salary Range From": 70000,
    "Salary Range To": 77000,
    "Work Location": "130 Stuyvesant Place, S.I.",
    "Division/Work Unit": "Human Capital",
    "Job Description": "RICHMOND COUNTY DISTRICT ATTORNEY  The men and women of the Richmond County District Attorneyâ€™s office work each day in partnership with Law Enforcement and the people of Staten Island to pursue justice for victims of crime, to prevent crime in all its forms, and to promote the safety and well-being of all citizens of our Borough.  THE BUREAU Human Capital serves as a strategic partner to the Richmond County District Attorney's Office through core HR, talent/workforce management and employee engagement. We cultivate an organizational environment that promotes change and business improvement.  THE ROLE Under the direct supervision of the Director of Operations, the candidate will be responsible for but are not limited to, the following: \tProvide coverage/back-up for court parts.  â€¢\tOversee the day to day functions of recruitment and employee information, i.e. postings, preprocessing, onboarding, documentation, managing employee files/electronic profiles â€¢\tSupervise timekeeper; reviewing all submitted timekeeping reports and flagging issues for further discussion â€¢\tManage data spreadsheets that are developed for tracking â€¢\tProcessing the bi-weekly payroll and distributing paychecks and pay stubs to employees. â€¢\tReviewing and reconciling details from the 160/161 reports before the close of paycalc. â€¢\tProcess stop-payments, EFT reversals, supplemental payroll and one-time payments. â€¢\tGenerate payroll reports for oversight agencyâ€™s approval   \t â€¢\tConduct monthly and annual reviews of agency credit card and checking account expenses.  \t â€¢\tResearching and processing longevity differentials, service increments, and recurring increments payments; managerial/contractual salary changes based on collective bargaining/mayoral agreements; managerial lump sums and taxable fringe calculations, etc. â€¢\tHR data entry of personnel transactions utilizing City systems â€¢\tSupport all onboarding functions including document preparation, employee orientation and maintaining personnel records. â€¢\tOther duties as assigned by Supervisor\tOther general clerical duties as assigned.",
    "Posting Date": "2019-12-06T00:00:00.000"
},*/
//    @PrimaryKey
//    var title : String,
    //@PrimaryKey(autoGenerate = true) var id: Int = 0,
    //@Json(name = "title") var title : String,
//    @Json(name = "Author") var author : String,
//    @Json(name = "User Rating") var rating : Float,
//    @Json(name = "Reviews") var reviews : Int,
//    @Json(name = "Price") var price : Float,
//    @Json(name = "Year") var year : Int,
//    @Json(name = "Genre") var genre : String

)

