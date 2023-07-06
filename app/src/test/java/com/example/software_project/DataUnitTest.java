package com.example.software_project;

import java.util.Calendar;
import java.util.Date;

        import static org.junit.Assert.assertEquals;
        import static org.junit.Assert.assertFalse;
        import static org.junit.Assert.assertThrows;
        import static org.junit.Assert.assertTrue;

        import org.junit.Test;

public class DataUnitTest {


    String curr_date = "13/05/2023";
    /**
     * testing addData method
     */
    @Test
    public void testAddData() {

        AddNewData dataList = new AddNewData();
        MedicalReportModel data1 = new MedicalReportModel("Mahi", curr_date, "12 : 30 PM", "120", "90", "85", "Dead");
        dataList.addData(data1);
        assertEquals(1, dataList.getData().size());

        MedicalReportModel data2 = new MedicalReportModel("Anisa", curr_date, "04 : 10 PM", "130", "87", "89", "Not Dead");
        dataList.addData(data2);
        assertEquals(2, dataList.getData().size());

        assertTrue(dataList.getData().contains(data1));
        assertTrue(dataList.getData().contains(data2));
    }

    /**
     * testing deleteData method
     */
    @Test
    public void testDeleteData() {


        AddNewData dataList = new AddNewData();
        MedicalReportModel data1 = new MedicalReportModel("Mahi", curr_date, "12 : 30 PM", "120", "90", "85", "Dead");
        dataList.addData(data1);
        assertEquals(1, dataList.getData().size());

        MedicalReportModel data2 = new MedicalReportModel("Anisa", curr_date, "04 : 10 PM", "130", "87", "89", "Not Dead");
        dataList.addData(data2);
        assertEquals(2, dataList.getData().size());

        assertTrue(dataList.getData().contains(data1));
        assertTrue(dataList.getData().contains(data2));

        dataList.deleteData(data1);
        assertEquals(1, dataList.getData().size());
        assertFalse(dataList.getData().contains(data1));

        dataList.deleteData(data2);
        assertEquals(0, dataList.getData().size());
        assertFalse(dataList.getData().contains(data2));
    }

    /**
     * testing addData method for exceptions
     */
    @Test
    public void testAddRecordException() {
        AddNewData dataList = new AddNewData();
        MedicalReportModel data1 = new MedicalReportModel("Mahi", curr_date, "12 : 30 PM", "120", "90", "85", "Dead");
        dataList.addData(data1);

        assertThrows(IllegalArgumentException.class, () -> dataList.addData(data1));
    }

    /**
     * testing deleteData method for exceptions
     */
    @Test
    public void testDeleteRecordException() {


        AddNewData dataList = new AddNewData();
        MedicalReportModel data1 = new MedicalReportModel("Mahi", curr_date, "12 : 30 PM", "120", "90", "85", "Dead");
        dataList.addData(data1);

        dataList.deleteData(data1);

        assertThrows(IllegalArgumentException.class, () -> dataList.deleteData(data1));
    }


}
