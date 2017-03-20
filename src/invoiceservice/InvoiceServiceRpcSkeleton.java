
/**
 * InvoiceServiceRpcSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.4  Built on : Dec 28, 2015 (10:03:39 GMT)
 */
    package invoiceservice;

import java.util.Random;

/**
     *  InvoiceServiceRpcSkeleton java skeleton for the axisService
     */
    public class InvoiceServiceRpcSkeleton{
   	 	private Random rand= new Random();

         
        /**
         * Auto generated method signature
         * 
                                     * @param createTransaction 
             * @return createTransactionResponse 
         */
        
                 public invoiceservice.CreateTransactionResponse createTransaction
                  (
                  invoiceservice.CreateTransaction createTransaction
                  )
            {
                 	int randomNumber=rand.nextInt(1000000);
                 	
                 	CreateTransactionResponse res = new CreateTransactionResponse();
                 	res.setTransactionId(randomNumber);     	
                 	return res;
            }
     
    }
    