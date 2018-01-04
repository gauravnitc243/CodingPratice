package com.oracle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CreatePOWS
{
	int totalLines =15 ;
	String webServiceDestinationLocation = "C:\\Users\\jjikumar\\Desktop\\ws\\createCOWebRequest.xml";
	
	/*Header Information*/
	long DocumentStyleId = 1L;
	long ProcurementBUId = 204L;
	long RequisitioningBUId = 204L;
	long BuyerId = 100010026863783L;
	long SupplierId = 12L;
	long SupplierSiteId=2444L;
	String SoldToLegalEntity = "Vision Operations";
	String InterfaceSourceCode = "Goods";
	String ApprovalActionCode = "SUBMIT";
	String DocumentDescription ="Purchase Order with "+ totalLines +" lines";
	
	/*line Information*/
	long LineTypeId = 1L;
	long ItemId=606L;
	long Quantity=2L;
	String UnitOfMeasureCode="Ea";
	
	

	/*Schedule Information*/

    long ShipToLocationId = 300100025284030L;
    long ShipToOrganizationId=204L;
    String NeedByDate="2020-12-27";

    
    /* WS variables */
    String headerStart = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"
    					 +"<soap:Body>"
    					 +"<ns1:createPurchaseOrder xmlns:ns1=\"http://xmlns.oracle.com/apps/prc/po/editDocument/purchaseOrderServiceV2/types/\">"
				         +"<ns1:createOrderEntry xmlns:ns2=\"http://xmlns.oracle.com/apps/prc/po/editDocument/purchaseOrderServiceV2/\">"
				         +"<ns2:DocumentStyleId>"+DocumentStyleId+"</ns2:DocumentStyleId>"
				         +"<ns2:ProcurementBUId>"+ProcurementBUId+"</ns2:ProcurementBUId>"
				         +"<ns2:RequisitioningBUId>"+RequisitioningBUId+"</ns2:RequisitioningBUId>"
				         +"<ns2:SoldToLegalEntity>"+SoldToLegalEntity+"</ns2:SoldToLegalEntity>"
				         +"<ns2:BuyerId>"+BuyerId+"</ns2:BuyerId>"
				         +"<ns2:SupplierId>"+SupplierId+"</ns2:SupplierId>"
				         +"<ns2:SupplierSiteId>"+SupplierSiteId+"</ns2:SupplierSiteId>"
				         +"<ns2:InterfaceSourceCode>"+InterfaceSourceCode+"</ns2:InterfaceSourceCode>"
				         +"<ns2:DocumentDescription>"+DocumentDescription+"</ns2:DocumentDescription>"
         			     +"<ns2:ApprovalActionCode>"+ApprovalActionCode+"</ns2:ApprovalActionCode>";
    String headerEnd =  "</ns1:createOrderEntry>"
    					 +"</ns1:createPurchaseOrder>"
    					 +"</soap:Body>"
    					 +"</soap:Envelope>";
    String lineStart =   "<ns2:PurchaseOrderEntryLine>"
    					 +"<ns2:LineNumber>";
    String lineEndCOM 	="</ns2:LineNumber>"
    					 +"<ns2:LineTypeId>"+LineTypeId+"</ns2:LineTypeId>"
    					 +"<ns2:ItemId>"+ItemId+"</ns2:ItemId>"
    					 +"<ns2:Quantity>"+Quantity+"</ns2:Quantity>"
    					 +"<ns2:UnitOfMeasureCode>"+UnitOfMeasureCode+"</ns2:UnitOfMeasureCode>";
    String lineEnd = "</ns2:PurchaseOrderEntryLine>";
    
    String scheduleStart = "<ns2:PurchaseOrderEntrySchedule>"
	                  	 +"<ns2:ShipToLocationId>"+ShipToLocationId+"</ns2:ShipToLocationId>"
	                  	 +"<ns2:ShipToOrganizationId>"+ShipToOrganizationId+"</ns2:ShipToOrganizationId>"
	                  	 +"<ns2:NeedByDate>"+NeedByDate+"</ns2:NeedByDate>";
    String scheduleEnd = "</ns2:PurchaseOrderEntrySchedule>";
    String distirbuitionStart = "<ns2:PurchaseOrderEntryDistribution>";
    String distirbuitionEnd = "</ns2:PurchaseOrderEntryDistribution>";
	public static void main(String[] args)
	{
		CreatePOWS cp = new CreatePOWS();
		try
		{
			cp.createCOWebRequest();
		}
		catch(Exception e)
		{
			System.out.println("There was some problem while creating web request . Please refer to the below error :");
			e.printStackTrace();
		}

	}
	
	public  void createCOWebRequest() throws Exception
	{
		  File file =new File(webServiceDestinationLocation);
	   	  if(!file.exists())
	   	 	file.createNewFile();
	  	  FileWriter fw = new FileWriter(file,true);
	  	  BufferedWriter bw = new BufferedWriter(fw);
	  	  PrintWriter pw = new PrintWriter(bw);
	  	  pw.println(headerStart);
	  	  for(int i =1;i<=totalLines;i++)
	  	  {
		       	pw.println(lineStart);
		       	pw.println(Integer.toString(i));
		       	pw.println(lineEndCOM);
		       	pw.println(scheduleStart);
		       	pw.println(distirbuitionStart);
		       	pw.println(distirbuitionEnd);
		       	pw.println(scheduleEnd);
		       	pw.println(lineEnd);	
	  	  }
	  	  pw.append(headerEnd);
	  	  pw.flush();
	  	  pw.close();
	  	  System.out.println("Request Created Successfully:)");
	}
}

