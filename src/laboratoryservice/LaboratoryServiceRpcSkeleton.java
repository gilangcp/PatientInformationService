/**
 * LaboratoryServiceRpcSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.4  Built on : Dec 28, 2015 (10:03:39 GMT)
 */
    package laboratoryservice;

import java.util.Random;

import prescriptiondiagnosetypes.Diagnose;
import prescriptiondiagnosetypes.DiagnoseList;
import prescriptiondiagnosetypes.Prescription;
import prescriptiondiagnosetypes.PrescriptionList;

/**
     *  LaboratoryServiceRpcSkeleton java skeleton for the axisService
     */
    public class LaboratoryServiceRpcSkeleton{
    	private Random rand = new Random();
    	public String[] diagnoseName= new String[]{
    			"X-Rays",
    			"Blood Test",
    			"Stool Exam",
    			"Urine Test",
    			"TBC Exam",
    			"Cancer Test"    	
    	};
         
        /**
         * Auto generated method signature
         * 
                                     * @param getDiagnoseDetail 
             * @return getDiagnoseDetailResponse 
         */
        
                 public laboratoryservice.GetDiagnoseDetailResponse getDiagnoseDetail
                  (
                  laboratoryservice.GetDiagnoseDetail getDiagnoseDetail
                  )
            {
                     //Randomize the number of prescription
                  	 int diagnoseCount = rand.nextInt((5 - 1) + 1) + 1;
                  	 DiagnoseList diaglist = new DiagnoseList();
                  	 
                  	 for (int w=0; w < diagnoseCount; w++){
                  		 Diagnose p = new Diagnose();
                    	 int typeIndex = rand.nextInt(6);
  	                	 p.setDescription(diagnoseName[typeIndex]);
  	                	 p.setQuantity(1);
  	                	 diaglist.addDiagnoseItem(p);
  	                }
                  	GetDiagnoseDetailResponse res = new GetDiagnoseDetailResponse();
                  	res.setDiagnoseList(diaglist);
                  	return res;
             }
     
    }