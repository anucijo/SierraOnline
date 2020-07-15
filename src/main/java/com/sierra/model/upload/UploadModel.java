package com.sierra.model.upload;

public class UploadModel {
	private String videoName;
	private String directory;
	private byte[] fileBytes;
	public byte[] getFileBytes() {
		return fileBytes;
	}
	public void setFileBytes(byte[] fileBytes) {
		this.fileBytes = fileBytes;
	}
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public String getDirectory() {
		return directory;
	}
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	

}
