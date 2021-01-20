package com.clubmanage.ClubDemo.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableConfigurationProperties({com.clubmanage.ClubDemo.config.Config.class})
class ConfigTest {
  @Autowired private com.clubmanage.ClubDemo.config.Config config;

  @Test
  void contextLoads() {
    System.out.println("convertServer:" + config.getConvertServer());
  }


  public Set<String> NON_WORDS=new HashSet<String>(){{
    add("the");add("a");add("and");add("all");add("of");add("to");add("i");add("it"); add("in");add("or");add("so");add("but");add("be");}};

  /**
   * 词频统计
   * */
  @Test
  public void wordFre(){
    String words="apple banana";
    TreeMap<String,Integer> treeMap= new TreeMap<>();
    this.regexToList(words,"\\w+").stream().map(w->w.toLowerCase()).filter(x->!NON_WORDS.contains(x)).forEach(x->treeMap.put(x,treeMap.getOrDefault(x,0)+1));
    treeMap.forEach((x,y)->System.out.println("word:"+x+",fre:"+y));
    Assert.assertEquals("q","q");
  }

  private List<String> regexToList(String word,String regex){
    List<String> wordList= Lists.newArrayList();
    Matcher m= Pattern.compile(regex).matcher(word);
    if (m.find())
      wordList.add(m.group());
    return wordList;
  }

  /**
   * 测试poi加密文件
   * */
  @Test
  void testPOIEncrypt() {
    String filename = "/Users/sunquan/Desktop/工作簿1.xlsx";

    XSSFWorkbook workbook = new XSSFWorkbook();
    Sheet sheet = workbook.createSheet("sheet" + 1);
    Row headRow = sheet.createRow(0);
    headRow.createCell(0).setCellValue("one");
    headRow.createCell(1).setCellValue("two");
    headRow.createCell(2).setCellValue("three");
    headRow.createCell(3).setCellValue("four");

    Row firstRow = sheet.createRow(1);
    firstRow.createCell(0).setCellValue("1");
    firstRow.createCell(1).setCellValue("2");
    firstRow.createCell(2).setCellValue("3");
    firstRow.createCell(3).setCellValue("4");

    FileOutputStream fos = null;
    try {
      // 保存此XSSFWorkbook对象为xlsx文件
      workbook.write(new FileOutputStream(filename));

      POIFSFileSystem fs = new POIFSFileSystem();
      EncryptionInfo info = new EncryptionInfo(EncryptionMode.standard);
      Encryptor enc = info.getEncryptor();
      // 设置密码
      enc.confirmPassword("zmf");
      // 加密文件
      OPCPackage opc = OPCPackage.open(new File(filename), PackageAccess.READ_WRITE);
      OutputStream os = enc.getDataStream(fs);
      opc.save(os);
      opc.close();

      // 把加密后的文件写回到流
      fos = new FileOutputStream(filename);
      fs.writeFilesystem(fos);

      fos.flush();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        fos.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    System.out.println("over");
  }
}
