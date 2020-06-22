package basic;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CommandLine {
	public static void main(String[] args) throws IOException {
		
		String ans = printTasklist("ls", "-l", "./TEXT/");
		System.out.println("[ANS]" + ans);
		
	}
	
	public static String printTasklist(String exeCmd, String param, String folder) {
		// 실행할 명령
		List<String> command = new ArrayList<>();
		command.add(exeCmd);
		command.add(param);
		
		// 프로세스 객체 생성
		ProcessBuilder pb = new ProcessBuilder();
		pb.redirectErrorStream(true);
		pb.command(command);
		
		pb.directory(new File(folder));
		
		int result = 0;
		String ans = null;
		
		try {
			Process proc = pb.start();
			
			try(BufferedReader buffReader = new BufferedReader(new InputStreamReader(proc.getInputStream()))){
				String tmpLine = null;
				
				while((tmpLine = buffReader.readLine())!=null){
					System.out.println(tmpLine);
					if (tmpLine.contains("test") ) {
						ans = tmpLine;
					}
				}
			}
			
			proc.waitFor();
			result = proc.exitValue();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			result = -1;
		}
		System.out.println("[Exit] "+result);
		return ans;
	}
}
