package com.clubmanage.ClubDemo.Pojo;

public class ConvertResponse {
  private boolean endConvert;
  private String fileUrl;
  private int percent;

  public ConvertResponse() {}

  public ConvertResponse(boolean endConvert, String fileUrl, int percent) {
    this.endConvert = endConvert;
    this.fileUrl = fileUrl;
    this.percent = percent;
  }

  public boolean isEndConvert() {
    return endConvert;
  }

  public void setEndConvert(boolean endConvert) {
    this.endConvert = endConvert;
  }

  public String getFileUrl() {
    return fileUrl;
  }

  public void setFileUrl(String fileUrl) {
    this.fileUrl = fileUrl;
  }

  public int getPercent() {
    return percent;
  }

  public void setPercent(int percent) {
    this.percent = percent;
  }
}
