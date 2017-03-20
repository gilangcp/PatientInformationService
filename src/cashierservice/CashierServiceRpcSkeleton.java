
/**
 * CashierServiceRpcSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.4  Built on : Dec 28, 2015 (10:03:39 GMT)
 */
    package cashierservice;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import invoiceserviceclient.InvoiceServiceRpcStub;
import laboratoryserviceclient.LaboratoryServiceRpcStub;
import laboratoryserviceclient.LaboratoryServiceRpcStub.GetDiagnoseDetail;
import patientserviceclient.PatientServiceRpcStub.GetPrescriptionDetail;
import patientserviceclient.PatientServiceRpcStub.GetPrescriptionDetailResponse;
import patientserviceclient.PatientServiceRpcStub.Prescription;
import pharmacistserviceclient.PharmacistServiceRpcCallbackHandler;
import pharmacistserviceclient.PharmacistServiceRpcStub;
import pharmacistserviceclient.PharmacistServiceRpcStub.RequestMedicine;

/**
     *  CashierServiceRpcSkeleton java skeleton for the axisService
     */
    public class CashierServiceRpcSkeleton{
        
         
        /**
         * Auto generated method signature
         * 
                                     * @param doPayment 
             * @return doPaymentResponse 
         */
        
                 public cashierservice.DoPaymentResponse doPayment
                  (
                  cashierservice.DoPayment doPayment
                  )
            {

           //Query Patient Information Service
            GetPrescriptionDetailResponse prescriptionDetail = null;
	        try {
				patientserviceclient.PatientServiceRpcStub PatientService =new patientserviceclient.PatientServiceRpcStub();
				GetPrescriptionDetail request = new GetPrescriptionDetail();
				request.setPatientID(doPayment.getPatientId());
				prescriptionDetail = PatientService.getPrescriptionDetail(request);	        
	        } catch (AxisFault e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                           	 
           //Query Laboratory Service
	        laboratoryserviceclient.LaboratoryServiceRpcStub.GetDiagnoseDetailResponse diagnoseDetail = null;
	        try {
				laboratoryserviceclient.LaboratoryServiceRpcStub laboratoryService = new LaboratoryServiceRpcStub();
				GetDiagnoseDetail request= new GetDiagnoseDetail();
				request.setPatientID(doPayment.getPatientId());
				diagnoseDetail = laboratoryService.getDiagnoseDetail(request);				
	        } catch (AxisFault e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        	        
           //Notify Pharmacist Asynchronously
           try {
			pharmacistserviceclient.PharmacistServiceRpcStub pharmacistService = new PharmacistServiceRpcStub();
			RequestMedicine request = new RequestMedicine();
			request.setPatientId(doPayment.getPatientId());
			
			patientserviceclient.PatientServiceRpcStub.PrescriptionList l = prescriptionDetail.getPrescription();
			
			//Convert Prescription list to target type
			PharmacistServiceRpcStub.PrescriptionList nl = new PharmacistServiceRpcStub.PrescriptionList();
			for(Prescription p : l.getPrescriptionItem()){
				PharmacistServiceRpcStub.Prescription pres = new PharmacistServiceRpcStub.Prescription();
				pres.setDescription(p.getDescription());
				pres.setQuantity(p.getQuantity());
				nl.addPrescriptionItem(pres);
			}			
						
			request.setPrescriptionList(nl);
			pharmacistService.startrequestMedicine(request, new PharmacistServiceRpcCallbackHandler() {
			});
			
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           
           //Get Pricing from price service
           pricingserviceclient.PricingServiceRpcStub.GetPricesResponse prices = null;
           try {
			pricingserviceclient.PricingServiceRpcStub pricingService = new pricingserviceclient.PricingServiceRpcStub();
			pricingserviceclient.PricingServiceRpcStub.GetPrices  request = new pricingserviceclient.PricingServiceRpcStub.GetPrices();
			
			//Convert Prescription list to target type
			patientserviceclient.PatientServiceRpcStub.PrescriptionList l = prescriptionDetail.getPrescription();
			pricingserviceclient.PricingServiceRpcStub.PrescriptionList pl = new pricingserviceclient.PricingServiceRpcStub.PrescriptionList();
			
			for(Prescription p : l.getPrescriptionItem()){
				pricingserviceclient.PricingServiceRpcStub.Prescription pres = new pricingserviceclient.PricingServiceRpcStub.Prescription();
				pres.setDescription(p.getDescription());
				pres.setQuantity(p.getQuantity());
				pl.addPrescriptionItem(pres);
			}			

			//Convert Description list to target type
			LaboratoryServiceRpcStub.DiagnoseList d = diagnoseDetail.getDiagnoseList();
			pricingserviceclient.PricingServiceRpcStub.DiagnoseList dl = new pricingserviceclient.PricingServiceRpcStub.DiagnoseList();

			for(LaboratoryServiceRpcStub.Diagnose p : d.getDiagnoseItem()){
				pricingserviceclient.PricingServiceRpcStub.Diagnose diag = new pricingserviceclient.PricingServiceRpcStub.Diagnose();
				diag.setDescription(p.getDescription());
				diag.setQuantity(p.getQuantity());
				dl.addDiagnoseItem(diag);
			}			
			
			request.setExaminationList(dl);
			request.setPrescriptionList(pl);
			
			prices = pricingService.getPrices(request);
			
           } catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           
           //Create new transaction through invoice service
           invoiceserviceclient.InvoiceServiceRpcStub.CreateTransactionResponse transactionResponse = null;
           try {
			InvoiceServiceRpcStub invoiceService = new InvoiceServiceRpcStub();	
			invoiceserviceclient.InvoiceServiceRpcStub.PriceList pl = new invoiceserviceclient.InvoiceServiceRpcStub.PriceList();
			
			
			//Convert Price list to target type
			for (pricingserviceclient.PricingServiceRpcStub.Price l : prices.getPriceList().getPriceItem()){
				invoiceserviceclient.InvoiceServiceRpcStub.Price price = new invoiceserviceclient.InvoiceServiceRpcStub.Price();
				price.setPrice(l.getPrice());
				price.setProductIdentifier(l.getProductIdentifier());
				price.setQuantity(l.getQuantity());
				price.setTotalPrice(l.getTotalPrice());
				pl.addPriceItem(price);
			}
			
			invoiceserviceclient.InvoiceServiceRpcStub.CreateTransaction request =new invoiceserviceclient.InvoiceServiceRpcStub.CreateTransaction();
			request.setTotalCost(prices.getTotalCost());
			request.setPriceList(pl);
			request.setPatientID(doPayment.getPatientId());
			
			transactionResponse = invoiceService.createTransaction(request);
			
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           
           //If the pharmacist done doing it's job; return receipt to patient 
           //We need to pretty print the prices Total cost and transaction ID
           
           String receipt = "\n";
           receipt+="Receipt Id: "+ transactionResponse.getTransactionId()+"\n";
           receipt+="-------------\n";
           receipt+="Components \n";
           receipt+="-------------\n";

			for (pricingserviceclient.PricingServiceRpcStub.Price l : prices.getPriceList().getPriceItem()){
				receipt+=l.getProductIdentifier()+"\t"+l.getQuantity()+"ml\t"+"€"+l.getPrice()+"\t"+l.getTotalPrice()+"\n";
			}
           
           receipt+="-------------\n";
           receipt+="Total Price : "+prices.getTotalCost()+"\n";
           receipt+="-------------\n";

                      
           	DoPaymentResponse resp = new cashierservice.DoPaymentResponse();  	 
            resp.setReceipt(receipt);
                       
            return resp;
            }
     
    }
    