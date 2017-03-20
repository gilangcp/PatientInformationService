
/**
 * PatientServiceRpcCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.4  Built on : Dec 28, 2015 (10:03:39 GMT)
 */

    package patientservice;

    /**
     *  PatientServiceRpcCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class PatientServiceRpcCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public PatientServiceRpcCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public PatientServiceRpcCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getPrescriptionAndDiagnosisDetail method
            * override this method for handling normal response from getPrescriptionAndDiagnosisDetail operation
            */
           public void receiveResultgetPrescriptionAndDiagnosisDetail(
                    invoiceservice.GetPrescriptionAndDiagnosisDetailResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getPrescriptionAndDiagnosisDetail operation
           */
            public void receiveErrorgetPrescriptionAndDiagnosisDetail(java.lang.Exception e) {
            }
                


    }
    