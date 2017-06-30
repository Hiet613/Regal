package jp.co.regal.controller;

import java.util.HashMap;
import java.util.Map;

import jp.co.regal.form.FirstForm;
import net.sf.jasperreports.engine.JRDataSource;

public class MyCreatePdf {
	 void createPdf(FirstForm form){

	        MyJasperGenerator gen = new MyJasperGenerator();

	        //JRDataSourceに詰める
	        JRDataSource dataSource = gen.makeBeansDataSource(form);

	        //１で作ったjrxmlファイルのパス
	        String jrxmlFilePath = "C:\\Users\\kawase.hitoshi\\workspace\\Regal\\src\\main\\resources\\jaspertmpl\\sample.jrxml";

	        //jrxmlからコンパイルするjasperファイルの出力先
	        String jasperFilePath= "C:\\Users\\kawase.hitoshi\\workspace\\Regal\\src\\main\\resources\\jaspertmpl\\sample.jasper";

	        //作成するpdfファイルの出力先
	        String outputPdfPath= "C:\\Users\\kawase.hitoshi\\workspace\\Regal\\src\\main\\resources\\jaspertmpl\\sample.pdf";

	        Map<String,Object> params = new HashMap<String,Object>();//とりあえず今回は使いません。


	        //作成実行
	        gen.outputPdf(jrxmlFilePath, jasperFilePath, params, dataSource, outputPdfPath);
	    }

}
