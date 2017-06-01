package com.site.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FTPUtil {
	private static final String IP_FTP_PRODUCAO = "172.16.0.28";
	private static final String IP_FTP_DESENVOLVIMENTO = "172.16.0.153";
	private static final String URL_FTP = IP_FTP_PRODUCAO;




	public  InputStream  downloadArquivoFinger(String nomeArquivo, String nomePasta) throws Exception{
		FTPClient ftp = new FTPClient();  
		InputStream  in = null;
		ByteArrayOutputStream baos = null;
		try{
			ftp.connect( URL_FTP,10021 );   
			if( FTPReply.isPositiveCompletion( ftp.getReplyCode() ) ) {  
				ftp.login( "finger", "tce!@123" );  
			} else {  
				ftp.disconnect();  
				throw new Exception("Não Foi Possível Estabelecer Uma Conexão com o Servidor de Arquivos!!");
			}  
			boolean exists =  ftp.changeWorkingDirectory (nomePasta); 
			if(exists){  
				ftp.setFileType( FTPClient.BINARY_FILE_TYPE );  
				baos = new ByteArrayOutputStream();  
				ftp.retrieveFile(nomeArquivo, baos); 
				in = new ByteArrayInputStream (baos.toByteArray());	
				ftp.logout();
			}else{
				throw new Exception("erro no download!");
			}
		}finally{
			if(baos != null){
				baos.close();
			}
			if(in != null){
				in.close();
			}
			ftp.disconnect();
		}
		return in;
	}

	public InputStream downloadArquivo(String nomeArquivo) {
		
		InputStream in = null;

		FTPClient client = new FTPClient();
		try {
		
			client.connect("172.16.0.28", 10021);
			client.login("sacop", "tce!@123");
			client.setFileType(FTP.BINARY_FILE_TYPE);
			
			System.out.println("realizou a conexão com o servidor");
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			client.retrieveFile(nomeArquivo, baos);
			 in = new ByteArrayInputStream(baos.toByteArray());
			client.logout();
			
			System.out.println("puxou o arquivo e desconectou do cliente");
			
			
		} catch (IOException e) {
			e.printStackTrace();

		}
		return in;
	}
	
	
	
	
	public InputStream downloadArquivo2(String nomeArquivo, String nomePasta) {

		FTPClient client = new FTPClient();
		InputStream in= null;
		try {
			client.connect("172.16.0.28", 10021);
			//client.connect("172.16.0.153", 10021);

			client.login("sacop", "tce!@123");

			client.changeWorkingDirectory(nomePasta);

			client.setFileType(FTP.BINARY_FILE_TYPE);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			client.retrieveFile(nomeArquivo, baos);
			in = new ByteArrayInputStream(baos.toByteArray());
			client.logout();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return in;
	}

	
	

}
