/*
 * Licensed to David Pilato (the "Author") under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. Author licenses this
 * file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package fr.pilato.elasticsearch.crawler.fs.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.pilato.elasticsearch.crawler.fs.meta.MetaParser;
import org.apache.logging.log4j.LogManager;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

@Provider
public class RestJsonProvider implements ContextResolver<ObjectMapper> {

    // We initialize the object mapper depending on debug mode
    private static final ObjectMapper mapper = LogManager.getLogger(RestJsonProvider.class).isDebugEnabled() ?
            MetaParser.prettyMapper : MetaParser.mapper;

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return mapper;
    }
}
