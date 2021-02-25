package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SO {
	public SO() {
		super();
	}
	public String os() {
		String os = System.getProperty("os.name");
		return os ;
	}
	public String osTask(String sis) {
		if(sis == "Windows 10") {
			String process = "ps -ef";
			return process;
		}else {
			String process = "TASKLIST /FO TABLE";
			return process;
		}
	}
	public void readProcess(String process, String os) {
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void killProcess(String param, String os) {
		if(os == "Windows 10") {
		String cmdPid = "kill -9";
		String cmdNome = "pkill -f";
		int pid = 0;
		StringBuffer buffer = new StringBuffer();
		try {
		pid = Integer.parseInt(param);
		buffer.append(cmdPid);
		buffer.append(" ");
		buffer.append(pid);
		}catch(NumberFormatException e){
			buffer.append(cmdNome);
			buffer.append(" ");
			buffer.append(param);
		}
		callProcess(buffer.toString()); // chama o processo call para passar o parametro dessa função
	}else{
		String cmdPid = "TASKKILL /PID";
		String cmdNome = "TASKKILL /IM";
		int pid = 0;
		StringBuffer buffer = new StringBuffer();
		try {
		pid = Integer.parseInt(param);
		buffer.append(cmdPid);
		buffer.append(" ");
		buffer.append(pid);
		}catch(NumberFormatException e){
			buffer.append(cmdNome);
			buffer.append(" ");
			buffer.append(param);
		}
		callProcess(buffer.toString());
	}}
	public void callProcess(String process) {
			try {
			Runtime.getRuntime().exec(process);	
		} catch (Exception e) {
			String msgErro = e.getMessage(); 
			if(msgErro.contains("740")) {
				// cmd /c caminho_do_processo
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c");
				buffer.append(" ");
				buffer.append(process);
				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}else {
				System.err.println(msgErro); // System.err printa a mensagem em vermelho
			}
		}
			}
}

