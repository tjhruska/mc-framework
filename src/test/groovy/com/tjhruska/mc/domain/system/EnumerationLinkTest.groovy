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

import com.tjhruska.mc.database.test.GeneratedDomainAndDaoTestIface
import com.tjhruska.mc.domain.system.Enumeration

  
interface EnumerationLinkTest extends GeneratedDomainAndDaoTestIface {
  Enumeration getEnumerationA()
  void setEnumerationA(Enumeration enumerationA)
  Enumeration getEnumerationB()
  void setEnumerationB(Enumeration enumerationB)
}