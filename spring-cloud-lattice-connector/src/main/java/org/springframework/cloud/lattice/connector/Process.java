/*
 * Copyright 2013-2015 the original author or authors.
 *
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
 */

package org.springframework.cloud.lattice.connector;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import org.springframework.util.Assert;

import io.pivotal.receptor.commands.ActualLRPResponse;
import io.pivotal.receptor.commands.DesiredLRPResponse;

/**
 * @author Spencer Gibb
 */
@Data
public class Process {
	private final DesiredLRPResponse desired;
	private final List<ActualLRPResponse> actuals = new ArrayList<>();

	public ActualLRPResponse getFirstActual() {
		Assert.notEmpty(actuals, "empty actuals");
		return actuals.get(0);
	}

	public String getProcessGuid() {
		return desired.getProcessGuid();
	}

	public void add(ActualLRPResponse actual) {
		actuals.add(actual);
	}
}
