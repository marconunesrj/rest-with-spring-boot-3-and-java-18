package br.com.xmrtecnologia.restwithspringboot3java18.app.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.xmrtecnologia.restwithspringboot3java18.app.data.vo.v1.UploadFileResponseVO;
import br.com.xmrtecnologia.restwithspringboot3java18.app.services.FileStorageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;

@Tag(name = "File Endpoint")
@RestController
@RequestMapping("/api/file/v1")
public class FileController {
	
	private Logger logger = Logger.getLogger(FileController.class.getName());
	
	@Autowired
	private FileStorageService service;
	
    @PostMapping(value = "/uploadFile")
    @Operation(summary = "Upload One File",
        description = "Upload One File!",
        tags = {"Upload"},
        responses = {
            @ApiResponse(description = "Success", responseCode = "200"),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
        }
    )
	public UploadFileResponseVO uploadFile(@RequestParam("file") MultipartFile file) {
		logger.info("Storing file to disk");
		
		var filename = service.storeFile(file);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
			.path("/api/file/v1/downloadFile/")
			.path(filename)
			.toUriString();
		
		return
			new UploadFileResponseVO(
				filename, fileDownloadUri, file.getContentType(), file.getSize());
	}
	
    @PostMapping(value = "/uploadMultipleFiles")
    @Operation(summary = "Upload Mutiple Files",
        description = "Upload Mutiple Files!",
        tags = {"Upload"},
        responses = {
            @ApiResponse(description = "Success", responseCode = "200"),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
        }
    )
	public List<UploadFileResponseVO> uploadMultipleFiles(
		@RequestParam("files") MultipartFile[] files) {
		logger.info("Storing files to disk");
		
		return Arrays.asList(files)
			.stream()
			.map(file -> uploadFile(file))
			.collect(Collectors.toList());
	}
	
	//MY_file.txt
    @GetMapping(value = "/downloadFile/{filename:.+}")
    @Operation(summary = "Download File", description = "Download File",
        tags = {"Download"},
        responses = {
            @ApiResponse(description = "Success", responseCode = "200"),
            @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
        }
    )
	public ResponseEntity<Resource> downloadFile(
		@PathVariable String filename, HttpServletRequest request) {
		
		logger.info("Reading a file on disk");
		
		Resource resource = service.loadFileAsResource(filename);
		String contentType = "";
		
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (Exception e) {
			logger.info("Could not determine file type!");
		}
		
		if (contentType.isBlank()) contentType = "application/octet-stream";
		
		return ResponseEntity.ok()
			.contentType(org.springframework.http.MediaType.parseMediaType(contentType))
			.header(
				HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + resource.getFilename() + "\"")
			.body(resource);
	}
}
