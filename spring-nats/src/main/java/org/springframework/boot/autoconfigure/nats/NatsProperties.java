/*
 * Copyright 2017-2019 the original author or authors.
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

package org.springframework.boot.autoconfigure.nats;

import io.nats.client.Options;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConditionalOnClass({ Options.class })
@ConfigurationProperties(prefix = "spring.nats")
public class NatsProperties {

	private String server;

	public NatsProperties() {
	}

	public String getServer() {
		return this.server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public NatsProperties server(String server) {
		this.server = server;
		return this;
	}

	public Options toOptions() {
		return (new Options.Builder()).server(this.server).build();
	}

	@Override
	public String toString() {
		return "{" +
			" server='" + getServer() + "'" +
			"}";
	}
}