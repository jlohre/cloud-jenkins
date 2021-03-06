package com.sap.hana.cloud.samples.jenkins.storage;

/*
 * #%L
 * SAP HANA Cloud Platform Samples - Cloud Jenkins
 * %%
 * Copyright (C) 2013 SAP AG
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.sap.ecm.api.EcmService;

public class StorageFactory {
    public static Storage createStorage() {
        try {
            final EcmService ecmService = (EcmService) new InitialContext().lookup("java:comp/env/EcmService");
            return new EcmStorage(ecmService);
        } catch (final NamingException e) {
            return new FileStorage();
        }
    }
}
