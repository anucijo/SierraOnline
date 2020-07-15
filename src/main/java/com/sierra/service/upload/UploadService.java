package com.sierra.service.upload;

import java.io.IOException;

import com.sierra.model.upload.UploadModel;

public interface UploadService {
public void uploadToFolder(UploadModel uploadModel) throws IOException;

}
