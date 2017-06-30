package jp.co.regal.controller;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class MyJasperGenerator{


	 public JRDataSource makeBeansDataSource(Object dataSourceBean) {

	        List<?> dataSourceList = Arrays.asList(dataSourceBean);
	        JRDataSource res = new JRBeanCollectionDataSource(dataSourceList);
	        return res;
	    }
	    /**
	     * jasperReportsを使用してjdfファイルを作成する。
	     *
	     * @param jrxmlFilePath
	     * @param jasperFilePath
	     * @param params
	     * @param dataSource
	     * @param destPath
	     */
	    public void outputPdf(
	            String jrxmlFilePath,
	            String jasperFilePath,
	            Map<String,Object> params,
	            JRDataSource dataSource,
	            String outputPdfPath){

	        if(!new File(jasperFilePath).exists()) {
	            //jrxmlファイルをコンパイルする。
	            complieJasperReports(jrxmlFilePath, jasperFilePath);
	        }

	        try{

	            //抽象レポートを生成する。
	            JasperPrint basePrint = JasperFillManager.fillReport(jasperFilePath, params, dataSource);
	            //PDFファイルに出力する。
	            JasperExportManager.exportReportToPdfFile(basePrint, outputPdfPath);
	        }catch(Exception e){
	            throw new RuntimeException(e);
	        }
	    }

	    /**
	     * jrxmlファイルをコンパイルする。
	     *
	     * @param jrxmlFilePath
	     * @param jasperFileName
	     */
	    private void complieJasperReports(String jrxmlFilePath,String jasperFileName){

	        //jrxmlファイルを読み込む
	        try {
	            //コンパイル実行
	            JasperCompileManager.compileReportToFile(jrxmlFilePath,jasperFileName);

	        }catch(Exception e){
	            throw new RuntimeException(e);
	        }
	    }
}
