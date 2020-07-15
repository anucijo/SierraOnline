package com.sierra.service.upload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sierra.dao.upload.FileUploadRepository;
import com.sierra.entity.upload.ContenTable;
import com.sierra.model.upload.UploadModel;
@Service
public class UploadServiceImpl implements UploadService{
	@Autowired
	private FileUploadRepository fileUploadRepository;

	@Override
	public void uploadToFolder(UploadModel uploadModel) throws IOException {
		// TODO Auto-generated method stub
		
		
		
		String fileName = uploadModel.getVideoName();
		String directory = uploadModel.getDirectory();
		byte[] bytes = uploadModel.getFileBytes();
		
		
		System.out.println("In Upload folder ");

		
		try(OutputStream out = new FileOutputStream(directory+fileName)){	
			ContenTable saveContent = new ContenTable();
			saveContent.setName(fileName);
			saveContent.setDirectory(directory+fileName);
			
			//saveFileToFolder(file.getBytes(), name);

			// Save the records into the database
			fileUploadRepository.save(saveContent);
		
			out.write(bytes);
			}
	 catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	}

}
