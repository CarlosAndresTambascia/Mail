package com.api.mail.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BorrarMensajeRequest {
	
	@JsonProperty
    protected Boolean deleted;

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}


}
