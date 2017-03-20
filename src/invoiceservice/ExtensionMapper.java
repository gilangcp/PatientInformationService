
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.4  Built on : Dec 28, 2015 (10:04:10 GMT)
 */

        
            package invoiceservice;
        
            /**
            *  ExtensionMapper class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "PrescriptionDiagnoseTypes".equals(namespaceURI) &&
                  "PrescriptionList".equals(typeName)){
                   
                            return  prescriptiondiagnosetypes.PrescriptionList.Factory.parse(reader);
                        

                  }

              
                  if (
                  "PrescriptionDiagnoseTypes".equals(namespaceURI) &&
                  "Diagnose".equals(typeName)){
                   
                            return  prescriptiondiagnosetypes.Diagnose.Factory.parse(reader);
                        

                  }

              
                  if (
                  "PrescriptionDiagnoseTypes".equals(namespaceURI) &&
                  "DiagnoseList".equals(typeName)){
                   
                            return  prescriptiondiagnosetypes.DiagnoseList.Factory.parse(reader);
                        

                  }

              
                  if (
                  "PrescriptionDiagnoseTypes".equals(namespaceURI) &&
                  "Prescription".equals(typeName)){
                   
                            return  prescriptiondiagnosetypes.Prescription.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    