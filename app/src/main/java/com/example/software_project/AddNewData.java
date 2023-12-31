package com.example.software_project;

import java.util.ArrayList;
import java.util.List;


public class AddNewData {
    public List<MedicalReportModel> records = new ArrayList<>(); //a list of type "Medical Report Model" is declared

    /**
     * this method is used to add any new data
     * if data already exists,it will throw an exception
     * @param data a new record
     */
    public void addData(MedicalReportModel data)
    {
        if(records.contains(data))
        {
            throw new IllegalArgumentException();
        }
        records.add(data);
    }

    /**
     * this method returns an instance of sorted record list
     * sort is based on first attribute by default
     * @return a list of data
     */

    public List<MedicalReportModel> getData()
    {
        return records;
    }

    public MedicalReportModel getData(int x)
    {
       return records.get(x);
    }

    /**
     * this method is used for deleting a particular data
     * if the data doesnt exist,it will throw an exception
     * @param data a data that need to be deleted
     */
    public void deleteData(MedicalReportModel data)
    {
        List<MedicalReportModel> dataList = records;
        if(dataList.contains(data)){
            records.remove(data);
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }
<<<<<<< HEAD
//    public void edit(int pos, MedicalReportModel data)
//    {
//        records.set(pos,data);
//    }

=======
    public void edit(int pos, MedicalReportModel data)
    {
        records.set(pos,data);
    }
>>>>>>> e230d85d0656b7dfa71c465d8ed2bc641e0c066d
    /**
     * this method returns the size of list
     * @return int
     */
    public int countData()
    {
        return records.size();
    }
}
