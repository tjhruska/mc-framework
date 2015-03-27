/**
Copyright 2011-2015 Timothy James Hruska (tjhruska@yahoo.com)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
  
package com.tjhruska.mc.domain.system


import com.tjhruska.mc.database.BaseDomain
import com.tjhruska.mc.domain.system.Enumeration

import groovy.transform.ToString
import groovy.transform.Canonical


@Canonical (excludes=[])
@ToString (includeNames = true, includeSuper=true, includePackage=false)
public class EnumerationValue extends BaseDomain {

  Enumeration enumeration
  String name
  String description
  Short sequence
  String column1Value
  String column2Value
  String column3Value
  String column4Value
  String column5Value

}