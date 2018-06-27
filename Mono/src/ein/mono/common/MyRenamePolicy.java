package ein.mono.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyRenamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File oldFile) {
		//long time = System.currentTimeMillis();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMDDhhmmss");
		
		int random = (int) (Math.random() * 10000);
		
		String name = oldFile.getName();
		String fileName = "";
		String ext = "";
		int pointIdx = name.lastIndexOf(".");
		
		if(-1 != pointIdx) {
			// 마지막 인덱스는 포함 x ( . 전까지만)
			fileName = name.substring(0, pointIdx);
			// 해당 인덱스 글자 포함. (. 부터~)
			ext = name.substring(pointIdx);
		} else {
			fileName = name;
		}
		
		// 새로운 파일 이름 정의
		String newFileName = sdf.format(date) + random + ext;
		File newFile = new File(oldFile.getParent(), newFileName);

		return newFile;
	}

}
