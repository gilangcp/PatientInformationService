
/**
 * PatientServiceRpcSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.4  Built on : Dec 28, 2015 (10:03:39 GMT)
 */
    package patientservice;

import java.util.Random;

import invoiceservice.GetPrescriptionAndDiagnosisDetailResponse;
import prescriptiondiagnosetypes.Prescription;
import prescriptiondiagnosetypes.PrescriptionList;

/**
     *  PatientServiceRpcSkeleton java skeleton for the axisService
     */
    public class PatientServiceRpcSkeleton{
    	
    	
    	private Random rand = new Random();
    	public String[] medicineName= new String[]{
    			"decitabine",
    			"bromfenac",
    			"dexpemedolac",
    			"seractide",
    			"tazadolene",
    			"spiradolene",
    			"levonantradol",
    			"alprafenone",
    			"dabuzalgron",
    			"labetalol",
    			"semaxanib"
    	};
    	
    	public String[] ml = new String[]{
    			"10",
    			"20",
    			"30",
    			"40",
    			"50"
    	};

         
        /**
         * Auto generated method signature
         * 
                                     * @param getPrescriptionAndDiagnosisDetail 
             * @return getPrescriptionAndDiagnosisDetailResponse 
         */
        
                 public invoiceservice.GetPrescriptionAndDiagnosisDetailResponse getPrescriptionAndDiagnosisDetail
                  (
                  invoiceservice.GetPrescriptionAndDiagnosisDetail getPrescriptionAndDiagnosisDetail
                  )
            {

                     //Randomize the number of prescription
                	 int prescriptionCount = rand.nextInt((5 - 1) + 1) + 1;
                	 PrescriptionList presList = new PrescriptionList();
                	 for (int w=0; w < prescriptionCount; w++){
                		 Prescription p = new Prescription();
                		 
	                	 //Randomize the quantity of the medicine
	                	 int medicineCount = rand.nextInt((10 - 1) + 1) + 1;
	                	 
	                	 String description ="";
	                	 
	                	 for(int x=0 ; x < medicineCount; x++){
	                		 //Randomize the type of the medicine
	                    	 int typeIndex = rand.nextInt(11);
	                    	 int mlIndex = rand.nextInt(4);
	                    	 description+= medicineName[typeIndex]+"-"+ml[mlIndex]+"ml\n";
	                	 }
	
	                	 description+="--\n";
	                	 
	                	 //Randomize the daily intake
	                	 int dailyIntake = rand.nextInt((3 - 1) + 1) + 1;
	                	 description+=dailyIntake + "x daily\n";
	                	 
	                	 //Randomize the quantity
	                	 int quantity = rand.nextInt((7 - 1) + 1) + 1;
	                	 p.setDescription(description);
	                	 p.setQuantity(quantity);
	                	 presList.addPrescriptionItem(p);  
	                }
                	 
                	 GetPrescriptionAndDiagnosisDetailResponse res = new GetPrescriptionAndDiagnosisDetailResponse();
                	 res.setPrescription(presList);
                	 return res;
        }
     
    }
    