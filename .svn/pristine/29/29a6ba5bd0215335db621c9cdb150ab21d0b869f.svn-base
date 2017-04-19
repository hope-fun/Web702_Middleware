/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.utils;   
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

/**
 * 
 * @author zhang_kun1
 *
 */
public class FtpUtils {

    private FTPClient ftp;

    /**
     * 
     * @param path 上传到ftp服务器哪个路径下
     * @param addr 地址
     * @param port 端口号
     * @param username 用户名
     * @param password 密码
     * @return
     * @throws Exception
     */
    private boolean connect(String path, String addr, int port, String username, String password)
            throws Exception {
        boolean result = false;
        ftp = new FTPClient();
        int reply;
        ftp.connect(addr, port);
        ftp.login(username, password);
        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
        reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            return result;
        }
        ftp.changeWorkingDirectory(path);
        result = true;
        return result;
    }

    /**
     * 
     * @param file 上传的文件或文件夹
     * @throws Exception
     */
    private void upload(File file) throws Exception {
        if (file.isDirectory()) {
            ftp.makeDirectory(file.getName());
            ftp.changeWorkingDirectory(file.getName());
            String[] files = file.list();
            for (int i = 0; i < files.length; i++) {
                File file1 = new File(file.getPath() + "\\" + files[i]);
                if (file1.isDirectory()) {
                    upload(file1);
                    ftp.changeToParentDirectory();
                } else {
                    File file2 = new File(file.getPath() + "\\" + files[i]);
                    FileInputStream input = new FileInputStream(file2);
                    ftp.storeFile(file2.getName(), input);
                    input.close();
                }
            }
        } else {
            File file2 = new File(file.getPath());
            FileInputStream input = new FileInputStream(file2);
            ftp.storeFile(file2.getName(), input);
            input.close();
        }
    }
    
    
    /** 
     * 删除远程FTP文件 
     *  
     * @param remote 
     *            远程文件路径 
     * @return 
     * @throws IOException 
     */  
	public FTPStatus delete(String remote) throws IOException {
		ftp.enterLocalPassiveMode();
		ftp.setFileType(FTP.BINARY_FILE_TYPE);
		FTPStatus result = null;
		FTPFile[] files = ftp.listFiles(remote);
		if (files.length == 1) {
			boolean status = ftp.deleteFile(remote);
			result = status ? FTPStatus.DELETE_REMOTE_SUCCESS
					: FTPStatus.DELETE_REMOTE_FAILED;
		} else {
			result = FTPStatus.FILE_NOT_EXIST;
		}
		// Log.getLogger(this.getClass()).info("FTP服务器文件删除标识："+result);
		return result;
	}  
    
    /** 
     * 重命名远程FTP文件 
     * @param name 
     *            新远程文件名称(路径-必须保证在同一路径下) 
     * @param remote 
     *            远程文件路径 
     * @return  是否成功 
     * @throws IOException 
     */  
    public FTPStatus rename(String name,String remote) throws IOException  
    {  
        ftp.enterLocalPassiveMode();  
  
        ftp.setFileType(FTP.BINARY_FILE_TYPE);  
  
        FTPStatus result = null;  
  
        FTPFile[] files = ftp.listFiles(remote);  
        if (files.length == 1)  
        {  
            boolean status = ftp.rename(remote, name);  
            result = status ? FTPStatus.RENAME_REMOTE_SUCCESS : FTPStatus.RENAME_REMOTE_FAILED;  
        }  
        else  
        {  
            result = FTPStatus.FILE_NOT_EXIST;  
        }  
//        Log.getLogger(this.getClass()).info("FTP服务器文件名更新标识："+result);  
        return result;  
    }  
      
    public void list(String remote) throws IOException {
		ftp.enterLocalPassiveMode();
		ftp.setFileType(FTP.BINARY_FILE_TYPE);
		FTPFile[] files = ftp.listFiles(remote);
		if (files != null && files.length > 0) {
			for (FTPFile item : files) {
				System.out.println(item.getName());
			}
		}
	}  
    

    public static void main(String[] args) throws Exception {
        FtpUtils fu = new FtpUtils();
        fu.connect("/home/shuma/www/static/test/", "10.20.0.70", 21, "shuma", "root123");
        File file = new File("d:\\1.3.1/cxtql-logical-service.log");
        fu.list("/home/shuma/www/static/Android/1.1.1/OtherImage/");
        
        fu.delete("");
    }
}  