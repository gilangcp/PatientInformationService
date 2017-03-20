
/**
 * PharmacistServiceRpcSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.4  Built on : Dec 28, 2015 (10:03:39 GMT)
 */
    package pharmacistservice;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import cashierservice.NotifyMedicineReady;
import cashierserviceclient.CashierServiceRpcStub;

/**
     *  PharmacistServiceRpcSkeleton java skeleton for the axisService
     */
    public class PharmacistServiceRpcSkeleton{
        
         
        /**
         * Auto generated method signature
         * 
                                     * @param requestMedicine 
             * @return  
         */
        
                 public void requestMedicine
                  (
                  pharmacistservice.RequestMedicine requestMedicine
                  )
            {
                	 //Simulating long running medicine making using Thread & sleep
                	 new Thread(new Runnable() {
						@Override
						public void run() {
							  try {
								    Thread.sleep(1000);
								    
								    //Calling Cashier Service
								    try {
										cashierserviceclient.CashierServiceRpcStub client = new cashierserviceclient.CashierServiceRpcStub();
										cashierserviceclient.CashierServiceRpcStub.NotifyMedicineReady nm = new cashierserviceclient.CashierServiceRpcStub.NotifyMedicineReady();
										nm.setPatientId(Integer.valueOf(requestMedicine.getPatientId()));
										client.notifyMedicineReady(nm);
								    } catch (AxisFault e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (RemoteException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								    
								  } catch(InterruptedException ex) {
										ex.printStackTrace();
								  }
						}
                	}).start();
                
        }
     
    }
    