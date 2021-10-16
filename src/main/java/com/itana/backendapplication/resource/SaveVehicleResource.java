package com.itana.backendapplication.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

/**
* SaveVehicleResource
*/
@Data
public class SaveVehicleResource {	

	@NotNull
	@NotBlank(message = "year required")
	@Size(max=70)
	private String year;

	@NotNull
	@NotBlank(message = "category required")
	@Size(max=70)
	private String category;

	@NotNull
	@NotBlank(message = "type required")
	@Size(max=70)
	private String type;

	@NotNull
	private Long number;
}
