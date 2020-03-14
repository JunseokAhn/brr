package global.sesoc.brr.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

/**
 * ?��?�� �??�� ?��?��
 * ?��로드?�� ?��?��?�� ???�� & ?��버에 ???��?�� ?��?�� ?��?�� ?��?�� 기능 ?���?
 */
public class FileService {

	/**
	 * ?��로드 ?�� ?��?��?�� �??��?�� 경로?�� ???��?���?, ???��?�� ?��?��명을 리턴
	 * @param mfile ?��로드?�� ?��?��
	 * @param path ???��?�� 경로
	 * @return ???��?�� ?��?���?
	 */
	public static String saveFile(MultipartFile mfile, String uploadPath) {
		//?��로드?�� ?��?��?�� ?��거나 ?��기�? 0?���? ???��?���? ?���? null?�� 리턴
		if (mfile == null || mfile.isEmpty() || mfile.getSize() == 0) {
			return null;
		}
		
		//???�� ?��?���? ?��?���? ?��?��
		File path = new File(uploadPath);
		if (!path.isDirectory()) {
			path.mkdirs();
		}
		
		//?���? ?��?���?
		String originalFilename = mfile.getOriginalFilename();
		
		//???��?�� ?��?��명을 ?��?�� ?��짜의 ?��?��?���? ?��?��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String savedFilename = sdf.format(new Date());
		
		//?���? ?��?��?�� ?��?��?��
		String ext;
		int lastIndex = originalFilename.lastIndexOf('.');
		//?��?��?���? ?��?�� 경우
		if (lastIndex == -1) {
			ext = "";
		}
		//?��?��?���? ?��?�� 경우
		else {
			ext = "." + originalFilename.substring(lastIndex + 1);
		}

		//???��?�� ?���? 경로�? ?��?��?�� File 객체
		File serverFile = null;
		
		//같�? ?��름의 ?��?��?�� ?��?�� 경우?�� 처리
		while (true) {
			serverFile = new File(uploadPath + "/" + savedFilename + ext);
			//같�? ?��름의 ?��?��?�� ?��?���? ?���?.
			if ( !serverFile.isFile()) break;	
			//같�? ?��름의 ?��?��?�� ?��?���? ?���? ?��?�� long ???��?�� ?��간정보�?? ?��붙임.
			savedFilename = savedFilename + new Date().getTime();	
		}		
		
		//?��?�� ???��
		try {
			mfile.transferTo(serverFile);
		} catch (Exception e) {
			savedFilename = null;
			e.printStackTrace();
		}
		
		return savedFilename + ext;
	}
	
	/**
	 * ?��버에 ???��?�� ?��?��?�� ?���? 경로�? ?��?��받아, ?��?�� ?��?��?�� ?��?��
	 * @param fullpath ?��?��?�� ?��?��?�� 경로
	 * @return ?��?�� ?���?
	 */
	public static boolean deleteFile(String fullpath) {
		//?��?�� ?��?�� ?���?�? 리턴?�� �??��
		boolean result = false;
		
		//?��?��?�� ?���? 경로�? File객체 ?��?��
		File delFile = new File(fullpath);
		
		//?��?�� ?��?��?�� 존재?���? ?��?��
		if (delFile.isFile()) {
			delFile.delete();
			result = true;
		}
		
		return result;
	}
}
