<%@page import="Main.ExecutaCodigo"%>
<%@page import="java.io.IOException"%>
<%@page language="java" import="org.apache.commons.fileupload.*, java.util.*, java.io.*" %>
<%@page contentType="text/html" import="java.util.*, java.text.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Grafos</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style type="text/css">
            @import url("estilo.css");
        </style>

    </head>    
    <body>
    	<h1>Biblioteca-Grafos</h1>
        <div class="Janela">
            <h2>Grafo</h2>
            	<tr>	
            		<form method="post" enctype="multipart/form-data">    
            			<td><iframe 
                			sandbox="allow-scripts allow-forms allow-same-origin" 
                			src="janela.html" 
                			marginwidth="0" 
                			marginheight="0" 
                			scrolling="no" 
                			height="300" 
               				width="600">
            			</iframe></td>	
            		</form> 
            	</tr>		   
        </div>
        <div class="Arquivo">
				<h2>Selecione o arquivo de entrada:</h2>
				<form method="post" ENCTYPE="multipart/form-data">
					<input type="file" name="arquivo" id="arquivo">
					<input type="submit" value="Enviar">
				</form>
				<p>
			<%
		String caminhoTemp = getServletContext().getRealPath("/");
		String pasta = getServletContext().getRealPath("/");
 
		if (FileUpload.isMultipartContent(request)){
			DiskFileUpload upload = new DiskFileUpload();
			upload.setRepositoryPath(caminhoTemp);
 
			try{
				List items = upload.parseRequest(request);
				Iterator iter = items.iterator();
				
					while (iter.hasNext()) {
						FileItem item = (FileItem) iter.next();

							if (!item.isFormField()) {
								String nome=item.getName().toString();
								String nomeArquivo=nome.substring(nome.lastIndexOf("\\")+1);
 
								out.write("Nome do arquivo: " + nomeArquivo + "<br>");
								out.write("Arquivo(s)<b> " +item.getName() +"</b> transferido(s)<br>");
 
								File arquivo = new File(pasta+nomeArquivo);
								item.write(arquivo);
							}
						}
					}catch(FileUploadException e){
						out.write("Não foi possível efetivar o upload do arquivo - segue a causa do erro" + "<br>" + e.getMessage());
						e.printStackTrace();
					}
				}
			%>
			</p>	
        </div>
        <div>
        	<%
				String dir = getServletContext().getRealPath("/");
				String arquivo = "entrada.txt";
				ExecutaCodigo ler = new ExecutaCodigo(dir,arquivo);
				ler.Grafo();
        	%>
        </div>
	</body>
</html>