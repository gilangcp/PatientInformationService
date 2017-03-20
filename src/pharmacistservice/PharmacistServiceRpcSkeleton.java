
/**
 * PharmacistServiceRpcSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.4  Built on : Dec 28, 2015 (10:03:39 GMT)
 */
    package pharmacistservice;

import java.util.concurrent.TimeUnit;

/**
     *  PharmacistServiceRpcSkeleton java skeleton for the axisService
     */
    public class PharmacistServiceRpcSkeleton{
        
         
        /**
         * Auto generated method signature
         * 
                                     * @param requestMedicine 
             * @return requestMedicineResponse 
         */
        
                 public pharmacistservice.RequestMedicineResponse requestMedicine
                  (
                  pharmacistservice.RequestMedicine requestMedicine
                  )
            {
                 	try {
 						TimeUnit.SECONDS.sleep(5);
 					} catch (InterruptedException e) {
 						// TODO Auto-generated catch block
 						e.printStackTrace();
 					}

                 	RequestMedicineResponse res = new RequestMedicineResponse();
                 	res.setPatientId(requestMedicine.getPatientId());
                 	return res;
            
            }
     
    }
    