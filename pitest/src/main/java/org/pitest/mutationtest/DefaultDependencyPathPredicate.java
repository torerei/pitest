/*
 * Copyright 2011 Henry Coles
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and limitations under the License. 
 */
package org.pitest.mutationtest;

import org.pitest.functional.predicate.Predicate;
import org.pitest.internal.classloader.ClassPathRoot;

public class DefaultDependencyPathPredicate implements Predicate<ClassPathRoot> {

  DefaultDependencyPathPredicate() {

  }

  public Boolean apply(final ClassPathRoot a) {
    return a.cacheLocation().hasSome()
        && isADependencyPath(a.cacheLocation().value());
  }

  private boolean isADependencyPath(final String path) {
    final String lowerCasePath = path.toLowerCase();
    return lowerCasePath.endsWith(".jar") || lowerCasePath.endsWith(".zip");
  }

}