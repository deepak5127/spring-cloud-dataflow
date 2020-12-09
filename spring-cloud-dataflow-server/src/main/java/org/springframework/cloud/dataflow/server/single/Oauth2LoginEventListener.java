/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.dataflow.server.single;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.dataflow.audit.service.AuditRecordService;
import org.springframework.cloud.dataflow.core.AuditActionType;
import org.springframework.cloud.dataflow.core.AuditOperationType;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

/**
 * Event Listener class to log Login audit events.
 *
 * @author Deepak Gunasekaran
 * 
 */
@Component
public class Oauth2LoginEventListener {

	@Autowired
	private AuditRecordService auditRecordService;

	@EventListener
	public void handleOAuth2AuthenticationSuccessEvent(
			InteractiveAuthenticationSuccessEvent authenticationSuccessEvent) {
		this.auditRecordService.populateAndSaveAuditRecord(AuditOperationType.LOGIN, AuditActionType.LOGIN_SUCCESS,
				"Login",
				"Successful login", null);

	}

}
