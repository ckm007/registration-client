package io.mosip.kernel.masterdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.mosip.kernel.masterdata.dto.DocumentTypeDto;
import io.mosip.kernel.masterdata.dto.ValidDocumentTypeResponseDto;
import io.mosip.kernel.masterdata.service.DocumentTypeService;
import io.swagger.annotations.ApiOperation;

/**
 * document type controller with api to get list of valid document types
 * best on document category code type and language code
 * 
 * 
 * @author Uday Kumar
 * @since 1.0.0
 *
 */
@RestController
public class DocumentTypeController {
	@Autowired
	DocumentTypeService documentTypeService;

	@ApiOperation(value = "fetch all the  valid doucment type avialbale for specific document category code ")
	@GetMapping("/documenttypes/{documentcategoryCode}/{langCode}/")
	public ValidDocumentTypeResponseDto getDoucmentTypesForDocumentCategoryAndLangCode(
			@PathVariable("langCode") String langCode,
			@PathVariable("documentcategoryCode") String documentcategoryCode) {
		List<DocumentTypeDto> validDocumentTypes = documentTypeService.getAllValidDocumentType(documentcategoryCode,
				langCode);
		return new ValidDocumentTypeResponseDto(validDocumentTypes);

	}
}
