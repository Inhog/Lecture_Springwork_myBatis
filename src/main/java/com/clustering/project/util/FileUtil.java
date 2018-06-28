package com.clustering.project.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Component
public class FileUtil {

	@Autowired
	private CommonUtil commonUtil;
	public String getNewFileName(String filename) {
		String multiFileName = filename;
		
		return multiFileName;
	}
	
	public List<Object> setMultipartList(MultipartHttpServletRequest multipartRequest){
		List<Object> fileList = new ArrayList<Object>();
		Iterator<String> multiFileList = multipartRequest.getFileNames();
		while(multiFileList.hasNext()) {
			Map<Object,Object> fileMap = new HashMap<Object, Object>();
			String fileName = multiFileList.next();
			if(fileName == null) continue;
			MultipartFile multiFile = multipartRequest.getFile(fileName);
			String multiFileName = getNewFileName(multiFile.getOriginalFilename());
			String attachFileName = "C:\\Users\\student\\git\\SanghunOh\\Lecture_SpringFramework\\src\\main\\webapp\\resources\\uploads\\" + multiFileName;
			String fileSize = multiFile.getSize() + "";
			String fileContentType = multiFile.getContentType();
			try {
				multiFile.transferTo(new File(attachFileName));
				fileMap.put("ATTACHFILE_SEQ",commonUtil.getUniqueSequence());
				fileMap.put("SOURCE_UNIQUE_SEQ","aaaa");
				fileMap.put("ATTACHFILE_TYPE",fileContentType);
				fileMap.put("ORGINALFILE_NAME",fileName);
				fileMap.put("PHYSICALFILE_NAME",multiFileName);
				fileMap.put("ATTACHFILE_PATH","C:\\Users\\student\\git\\SanghunOh\\Lecture_SpringFramework\\src\\main\\webapp\\resources\\uploads\\");
				fileMap.put("ATTACHFILE_SIZE",fileSize);
				fileMap.put("ATTACHFILE_HEIGHT",500);
				fileMap.put("ATTACHFILE_WIDTH",500);
				fileMap.put("REGISTER_SEQ", "UUID-1111-1111111");
				fileMap.put("MODIFIER_SEQ", "UUID-1111-1111111");
				fileList.add(fileMap);
			}catch(Exception e) {
				File file = new File(attachFileName);
				file.delete();
				e.printStackTrace();
			}
		}
		return fileList;
	}
	
}
