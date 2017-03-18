package com.yinzitech.onlineparking.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

//import com.fh.util.PageData;
/**
 * 
 * ClassName: ObjectExcelView <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:导出excel
 * date: 2015年11月26日 下午6:53:41 <br/>
 *
 * @author xumingyue
 * @version 
 * @since JDK 1.8u60
 */
public class ObjectExcelView extends AbstractExcelView{

	@SuppressWarnings("deprecation")
	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Date date = new Date();
		String filename = date2Str(date, "yyyyMMddHHmmss");
		HSSFSheet sheet;
		HSSFCell cell;
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename="+filename+".xls");
		sheet = workbook.createSheet("sheet1");
		
		@SuppressWarnings("unchecked")
		List<String> titles = (List<String>) model.get("titles");
		int len = titles.size();
		HSSFCellStyle headerStyle = workbook.createCellStyle(); //标题样式
		headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		headerStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		HSSFFont headerFont = workbook.createFont();	//标题字体
		headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		headerFont.setFontHeightInPoints((short)11);
		headerStyle.setFont(headerFont);
		short width = 20,height=25*20;
		sheet.setDefaultColumnWidth(width);
		for(int i=0; i<len; i++){ //设置标题
			String title = titles.get(i);
			cell = getCell(sheet, 0, i);
			cell.setCellStyle(headerStyle);
			setText(cell,title);
		}
		sheet.getRow(0).setHeight(height);
		
		HSSFCellStyle contentStyle = workbook.createCellStyle(); //内容样式
		contentStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		@SuppressWarnings("unchecked")
		List<Map<String,String>> varList = (List<Map<String,String>>) model.get("varList");
		int varCount = varList.size();
		int costAll = 0 ; //统计总金额
		double carsAll = 0 ; //统计总金额
		for(int i=0; i<varCount; i++){
			Map<String,String> vpd = varList.get(i);
			for(int j=0;j<len;j++){
				String varstr = vpd.get("var"+(j+1)) != null ? vpd.get("var"+(j+1)) : "";
				if(j+1==4){
					costAll += Integer.valueOf(varstr) ;
				}
				if(j+1==5){
					carsAll += Double.parseDouble(varstr) ;
				}
				cell = getCell(sheet, i+1, j);
				cell.setCellStyle(contentStyle);
				setText(cell,varstr);
			}
			
		}
		 
        // 创建最后一列的合计列  
		HSSFRow row3 = sheet.createRow(varCount+2);
		 HSSFCell row3Cell = null;  
        row3Cell = row3.createCell(0);  
        row3Cell.setCellStyle(headerStyle);  
        row3Cell.setCellValue(new HSSFRichTextString("合计"));  
        row3Cell = row3.createCell(3);  
        row3Cell.setCellStyle(headerStyle);  
        row3Cell.setCellValue(new HSSFRichTextString(costAll+"")); 
        row3Cell = row3.createCell(4);  
        row3Cell.setCellStyle(headerStyle);  
        row3Cell.setCellValue(new HSSFRichTextString(carsAll+"")); 
	}
	
	/**
	 * 按照参数format的格式，日期转字符串
	 * @param date
	 * @param format
	 * @return
	 */
	public static String date2Str(Date date,String format){
		if(date!=null){
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		}else{
			return "";
		}
	}

}
