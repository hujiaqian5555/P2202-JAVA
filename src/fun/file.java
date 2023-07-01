package fun;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class file {

    /**
     * 文件复制
     *
     * @param srcPath  源文件
     * @param destPath 目标文件
     * @return boolean 是否成功
     */
    public static boolean filecopy(String srcPath,String destPath){

        BufferedInputStream bis=null;
        BufferedOutputStream bos=null;
               try{
                   bis=new BufferedInputStream(Files.newInputStream(Paths.get(srcPath)));
                   bos=new BufferedOutputStream(Files.newOutputStream(Paths.get(destPath)));
                   byte[] buff=new byte[1024];
                   int readLen=0;
                   while((readLen=bis.read(buff))!=-1){
                       bos.write(buff,0,readLen);
                   }
                   System.out.println("File has copied");
                   return true;
               }catch(IOException e){
                   e.printStackTrace();
               }finally {
                   try{
                       if(bis!=null){
                           bis.close();
                       }
                       if(bos!=null){
                           bos.close();
                       }
                   }
                   catch(IOException e){
                       e.printStackTrace();
                   }
               }
               return false;
    }

    /**
     * 显示文件选择窗口后复制
     *
     * @param destPath 目标路径
     * @return boolean 是否成功
     */
    public static boolean filecopy(String destPath){
        JFileChooser Chooser = new JFileChooser();
        Chooser.showOpenDialog(null);
        File f = Chooser.getSelectedFile();
        boolean flag= filecopy(f.getPath(),destPath);
        return flag;
    }

}
