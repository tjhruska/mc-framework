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

import javax.validation.Valid
import javax.validation.constraints.NotNull

import org.hibernate.validator.constraints.NotEmpty


@Canonical (excludes=[])
@ToString (includeNames = true, includeSuper=true, includePackage=false)
/**
 * An entry into the set of values define for an enumeration.
 */
public class EnumerationValue extends BaseDomain {


  /**
   * Link back to parent enumeration definition.
   */
  @NotNull
  Enumeration enumeration

  /**
   * Name of the enumeration instance for this value.
   */
  @NotEmpty
  String name

  /**
   * Description for this value.
   */
  @NotEmpty
  String description

  /**
   * Sequence within the enuemration/class for this value.
   */
  Short sequence

  /**
   * Value for column/field.
   */
  String column1Value

  /**
   * Value for column/field.
   */
  String column2Value

  /**
   * Value for column/field.
   */
  String column3Value

  /**
   * Value for column/field.
   */
  String column4Value

  /**
   * Value for column/field.
   */
  String column5Value

}