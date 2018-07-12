package com.guthub.yangm.fastdfs.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.tobato.fastdfs.domain.MataData;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.proto.storage.DownloadFileWriter;
import com.github.tobato.fastdfs.service.AppendFileStorageClient;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.github.tobato.fastdfs.service.TrackerClient;

/**   
 * 
 * 功能描述：
 * @Package: com.guthub.yangm.fastdfs.service 
 * @author: yangm
 * @date: 2018年7月11日
 * @email：1169290944@qq.com
 */
@Service
public class FdfsService {
	
	private static final Logger log = LoggerFactory.getLogger(FdfsService.class);

	//TrackerServer接口
	@Autowired
	TrackerClient trackerClient;
	
	//为方便项目开发集成的简单接口(StorageServer接口)
	@Autowired
	FastFileStorageClient fastFileStorageClient;
	
	//支持文件续传操作的接口 (StorageServer接口)
	@Autowired
	AppendFileStorageClient appendFileStorageClient;
	
    /**
     * 上传文件
     * @param sourceFile "C:\\Users\\Administrator\\Desktop\\TIM截图20180709110310.png"
     * @return
     */
    public StorePath uploadFile(String sourceFile){
        File file = new File(sourceFile);
        String fileExtName = FilenameUtils.getExtension(file.getName());
        // Metadata
        Set<MataData> metaDataSet = new HashSet<MataData>();
        metaDataSet.add(new MataData("author", "yangm"));
        InputStream in = null;
        StorePath path = null;
        try {
			in = new FileInputStream(file);
			// 上传文件和Metadata
			path = fastFileStorageClient.uploadFile(in, file.length(), fileExtName,metaDataSet);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return path;
    }
    
    /**
     * 
     * @param groupName group1
     * @param path  M00/00/00/3roiqFtHCiqAElWOAACSbvzSPwk512.png
     * @param downLoadTarget  D:\\tup.png
     */
    public void downLoad(String groupName,String path,String downLoadTarget){
    	DownloadFileWriter downloadFileWriter = new DownloadFileWriter(downLoadTarget);
    	String downloadFile = fastFileStorageClient.downloadFile(groupName, path, downloadFileWriter);
    	log.info("downloadFile:"+downloadFile);
    }
    
    
    
    /**
     * 获取文件InputStream
     * 
     * @param path
     * @return
     * @throws FileNotFoundException
     */
    public static InputStream getFileInputStream(String path) throws FileNotFoundException {
        return new FileInputStream(getFile(path));
    }

    /**
     * 获取文件
     * 
     * @param path
     * @return
     */
    public static File getFile(String path) {
        URL url = FdfsService.class.getResource(path);
        File file = new File(url.getFile());
        return file;
    }
	
}
