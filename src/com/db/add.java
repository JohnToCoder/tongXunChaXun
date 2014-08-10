package com.db;
import java.io.*;
import com.model.namelist;
import com.model.voiceList;
import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.*;

public class add {
	public boolean inputExecl(String excelStyle,String excelName,String excelPath){
	 Workbook workBook = null;
	 String type1="Voice";
	 String type2="Message";
	 String type3="Gprs";
	  try {
				try {
					//��ù�����
				workBook = Workbook.getWorkbook(new java.io.File(excelPath));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		//��ù�����
		 jxl.Sheet sheet=workBook.getSheet(0);
		 int rowSize = sheet.getRows();
		 //��ʼ��������
			 if(type1.equals(excelStyle)==true){
						 for(int i=1;i<rowSize;i++){
							 //��ȡexeclÿ�е�ֵ
							 String datetime=sheet.getCell(0,i).getContents();
							 String longth=sheet.getCell(1,i).getContents();
							 String style=sheet.getCell(2,i).getContents();
							 String toNum=sheet.getCell(3,i).getContents();
							 String place=sheet.getCell(4,i).getContents();
							 String toll=sheet.getCell(5,i).getContents();
							 System.out.println(datetime);
							 System.out.println(longth);
							 System.out.println(style);
							 System.out.println(toNum);
							 System.out.println(place);
							 System.out.println(toll);
							//ʵ��������
							 voiceList voicelist = new voiceList();
							 voicelist.setName(excelName);
							 voicelist.setDatetime(datetime);
							 voicelist.setLongth(longth);
							 voicelist.setStyle(style);
							 voicelist.setToNum(toNum);
							 voicelist.setPlace(place);
							 voicelist.setToll(toll);
							 //��Ϣ���
							 DB db = new DB();
							 if(db.addVoiceInfo(voicelist)){
								 System.out.print("�ѳɹ������"+i+"����¼");
						   }
						 }}
			 			return true;
	  				}
					catch (BiffException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			 }
	  return false;
	  }		 
		
	/*
	public static void main(String[] args) {
		add t = new add();
		t.inputExecl();
	}*/
}
