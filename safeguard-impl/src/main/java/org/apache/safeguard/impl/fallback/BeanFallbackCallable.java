/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.apache.safeguard.impl.fallback;

import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;

import java.util.concurrent.Callable;

public class BeanFallbackCallable<T> implements Callable<T> {

    private final FallbackHandler<T> delegate;
    private final ExecutionContext executionContext;

    public BeanFallbackCallable(FallbackHandler<T> delegate, ExecutionContext executionContext) {
        this.delegate = delegate;
        this.executionContext = executionContext;
    }

    @Override
    public T call() throws Exception {
        return delegate.handle(executionContext);
    }
}
