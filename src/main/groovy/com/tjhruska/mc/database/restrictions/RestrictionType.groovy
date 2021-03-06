/**
 * Copyright 2011-2015 Timothy James Hruska (tjhruska@yahoo.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tjhruska.mc.database.restrictions

import groovy.transform.ToString

import java.util.Map


@ToString (includeNames = true, includePackage=false, includeFields=true)
public enum RestrictionType {
  ALL_EQ (null),
  AND (null),
  BETWEEN (null),
  EQUALS ("="),
  GREATER_THAN_OR_EQUALS (">="),
  GREATER_THAN (">"),
  INSENSITIVE_CASE_LIKE (null),
  IN ("("),
  IS_NOT_NULL ("isNotNull"),
  IS_NULL ("isNull"),
  LESS_THAN_OR_EQUALS ("<="),
  LIKE (null),
  LESS_THAN ("<"),
  NOT_EQUALS ("!="),
  NOT (null),
  OR (null)

  private String operator

  public String getOperator(){
    return operator
  }

  private RestrictionType(String operator){
    this.operator = operator
    if (operator != null){
      RestrictionTypeHelper.getRestrictionTypeHelper().lookupMap.put(operator, this)
    }
  }

  public static RestrictionType parseURLRestrictionType(String urlValue){
    Map<String,RestrictionType> lookupMap = RestrictionTypeHelper.getRestrictionTypeHelper().lookupMap
    if (urlValue == null){
      return null
    } else if (urlValue.length() >= 9 && lookupMap.containsKey(urlValue.substring(0, 9))){
      return lookupMap.get(urlValue.substring(0, 9))
    } else if (urlValue.length() >= 6 && lookupMap.containsKey(urlValue.substring(0, 6))){
      return lookupMap.get(urlValue.substring(0, 6))
    } else if (urlValue.length() >= 2 && lookupMap.containsKey(urlValue.substring(0, 2))){
      return lookupMap.get(urlValue.substring(0, 2))
    } else if (urlValue.length() >= 1 && lookupMap.containsKey(urlValue.substring(0, 1))){
      return lookupMap.get(urlValue.substring(0, 1))
    } else {
      return null
    }
  }
}