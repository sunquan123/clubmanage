package com.clubmanage.ClubDemo.Pojo;

public class ConvertParams {
  private boolean async;
  private int codePage;
  private int delimiter;
  private String filetype;
  private String key;
  private String outputtype;
  private String password;
  private Thumbnail thumbnail;
  private String title;
  private String url;

  public ConvertParams() {}

  public ConvertParams(
      boolean async, String filetype, String key, String outputtype, String password, String url) {
    this.async = async;
    this.filetype = filetype;
    this.key = key;
    this.outputtype = outputtype;
    this.password = password;
    this.url = url;
  }

  public boolean isAsync() {
    return async;
  }

  public void setAsync(boolean async) {
    this.async = async;
  }

  public int getCodePage() {
    return codePage;
  }

  public void setCodePage(int codePage) {
    this.codePage = codePage;
  }

  public int getDelimiter() {
    return delimiter;
  }

  public void setDelimiter(int delimiter) {
    this.delimiter = delimiter;
  }

  public String getFiletype() {
    return filetype;
  }

  public void setFiletype(String filetype) {
    this.filetype = filetype;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getOutputtype() {
    return outputtype;
  }

  public void setOutputtype(String outputtype) {
    this.outputtype = outputtype;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Thumbnail getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(Thumbnail thumbnail) {
    this.thumbnail = thumbnail;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public class Thumbnail {
    private int aspect;
    private boolean first;
    private int height;
    private int width;

    public Thumbnail(int aspect, boolean first, int height, int width) {
      this.aspect = aspect;
      this.first = first;
      this.height = height;
      this.width = width;
    }

    public Thumbnail() {}

    public int getAspect() {
      return aspect;
    }

    public void setAspect(int aspect) {
      this.aspect = aspect;
    }

    public boolean isFirst() {
      return first;
    }

    public void setFirst(boolean first) {
      this.first = first;
    }

    public int getHeight() {
      return height;
    }

    public void setHeight(int height) {
      this.height = height;
    }

    public int getWidth() {
      return width;
    }

    public void setWidth(int width) {
      this.width = width;
    }
  }
}
