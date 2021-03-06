package com.analytic.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.analytic.dao.RefineryDAO;
import com.google.gson.JsonObject;
@Service
public class RefineryService {

	@Autowired
	RefineryDAO refineryDAO;

	public String fetchData(String level, String type) throws JSONException {
		/*try {*/
			return refineryDAO.fetchData(level, type);
	/*	} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;*/
	}

	public String fetchRecord(String level, String type, String columnName, String columnValue) throws JSONException {
		return refineryDAO.fetchRecord(level, type, columnName,columnValue);
	}

	public String updateRecord(String level, String type,String keyName, String keyValue, String columnName, String columnValue) throws Exception {
		return refineryDAO.updateRecord(level, type,  keyName,keyValue,columnName,columnValue);
	}
	
	
	public String updateRecord(String level, String type,JsonObject refineryData) throws Exception {
		return refineryDAO.updateRecord(level, type, refineryData);
	}

	public String updateData(String level, String type, MultipartFile path) throws FileNotFoundException {
	    File convFile = new File( path.getOriginalFilename());
		FileInputStream fis = new FileInputStream(convFile);

	    
		return refineryDAO.updateData(level, type,fis);
	}

	public String  deleteData(String level, String type) {
		return refineryDAO.deleteData(level, type);
	}

	public String deleteRecord(String level, String type, String keyName, String keyValue) {
		return refineryDAO.deleteRecord(level, type,keyName,keyValue);
		
	}

	public String saveData(MultipartFile testfile, MultipartFile trainfile) throws Exception {
	    /*File convFile = new File(testfile.getOriginalFilename());
		FileInputStream fis = new FileInputStream(convFile);
*/
		return refineryDAO.saveExcels(testfile,trainfile);
	}
	
/*	public String saveData(String testPath, String trainPath) throws FileNotFoundException {
	    File convFile = new File(testPath);
		FileInputStream fis = new FileInputStream(convFile);

		return refineryDAO.saveExcels(testPath, trainPath);
	}*/

}
