
/**
 * PricingServiceRpcSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.4  Built on : Dec 28, 2015 (10:03:39 GMT)
 */
    package pricingservice;

import java.util.HashMap;

import prescriptiondiagnosetypes.Diagnose;
import prescriptiondiagnosetypes.DiagnoseList;
import prescriptiondiagnosetypes.Prescription;
import prescriptiondiagnosetypes.PrescriptionList;
import pricingtypes.Price;
import pricingtypes.PriceList;

/**
     *  PricingServiceRpcSkeleton java skeleton for the axisService
     */
    public class PricingServiceRpcSkeleton{

    	public HashMap<String,Double> medicinePriceMap = new HashMap<>();
    	public HashMap<String,Double> diagnosePriceMap = new HashMap<>();

    	
        /**
         * Auto generated method signature
         * 
                                     * @param getPrices 
             * @return getPricesResponse 
         */
        
                 public pricingservice.GetPricesResponse getPrices
                  (
                  pricingservice.GetPrices getPrices
                  )
            {
                	 //Initialize medicine database
                	 medicinePriceMap.put("decitabine",(double) 1);
                	 medicinePriceMap.put("bromfenac",(double)4);
                	 medicinePriceMap.put("dexpemedolac",(double)3);
                	 medicinePriceMap.put("seractide",(double)9);
                	 medicinePriceMap.put("tazadolene",(double)4);
                	 medicinePriceMap.put("spiradolene",(double)3);
                	 medicinePriceMap.put("levonantradol",(double)2);
                	 medicinePriceMap.put("alprafenone",(double)3);
                	 medicinePriceMap.put("dabuzalgron",(double)3);
                	 medicinePriceMap.put("labetalol",(double)3);
                	 medicinePriceMap.put("semaxanib",(double)3);  
                	 
                	 //Initialize diagnose database
                	 diagnosePriceMap.put("X-Rays",(double)3);
                	 diagnosePriceMap.put("Blood Test",(double)6);
                	 diagnosePriceMap.put("Stool Exam",(double)4);
                	 diagnosePriceMap.put("Urine Test",(double)4);
                	 diagnosePriceMap.put("TBC Exam",(double)5);
                	 diagnosePriceMap.put("Cancer Test",(double)5);              
                                	 
                	 //Get the prescription list
                	 PrescriptionList preslist = getPrices.getPrescriptionList();
                	 DiagnoseList diagnoseList = getPrices.getExaminationList();
                	 
                	 //Create the priceList array
                	 PriceList priceList = new PriceList();
                	 double totalCost = 0;
                	 
                	 //Parse prescription list
                	 for(Prescription pres : preslist.getPrescriptionItem()){
                		 String lines[] = pres.getDescription().split("\\r?\\n");
                		 
                		 for (String medicineAndQuantity : lines){
                			 if(medicineAndQuantity.contains("--")) break;
                			 medicineAndQuantity = medicineAndQuantity.replace("ml", "");
                			 Price price = new Price();
                			 
                			 //[0] will contain the name of the medicine
                			 //[1] will contain the quantity
                			 String parsed[] = medicineAndQuantity.split("-");
                			 price.setProductIdentifier(parsed[0]);
                			 price.setQuantity(Double.valueOf(parsed[1]));
                			 
                			 //Find the price
                			 double prc = medicinePriceMap.get(parsed[0]);
                			 price.setPrice(prc);
                			 price.setTotalPrice(Double.valueOf(parsed[1]) * prc);
                			 priceList.addPriceItem(price);
                			 totalCost+=Double.valueOf(parsed[1]) * prc;
                		} 
                	 }
                	 
                	 //Parse diagnose list
                	 for(Diagnose diag : diagnoseList.getDiagnoseItem()){
            			 Price price = new Price();
                		 String examName = diag.getDescription();
                		 int qty = diag.getQuantity();
                		 double prc = diagnosePriceMap.get(examName);
                		 price.setProductIdentifier(examName);
                		 price.setQuantity(qty);
                		 price.setPrice(prc);
                		 price.setTotalPrice(prc*qty);
                		 priceList.addPriceItem(price);
                		 totalCost+=prc*qty;
                	}
                	                 	 
                	 GetPricesResponse res = new GetPricesResponse();
                	 res.setPriceList(priceList);
                	 res.setTotalCost(totalCost);
                	 return res;
            
            }
     
    }
    