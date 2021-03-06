/**
Copyright 2015-2015 Timothy James Hruska (tjhruska@yahoo.com)

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

import org.springframework.context.annotation.Lazy
import org.springframework.beans.factory.annotation.Autowired
import static org.junit.Assert.*
import org.junit.Before

import groovy.util.logging.Slf4j

import com.tjhruska.mc.database.BaseDomain
import com.tjhruska.mc.database.DaoDomain
import com.tjhruska.mc.database.test.GeneratedDomainAndDaoTestIface
       
import static com.tjhruska.mc.enums.Datatype.*

import com.tjhruska.mc.database.test.GeneratedDomainAndDaoTest
import com.tjhruska.mc.enums.Datatype
import com.tjhruska.mc.util.Solo
import java.util.List
import java.util.Map
  

@Slf4j
class JsonExampleTestImpl extends GeneratedDomainAndDaoTest implements JsonExampleTest {
  
  @Autowired
  DaoDomain<JsonExample> jsonExampleDao

  @Override
  public DaoDomain getDao() {
    jsonExampleDao
  }


  @Override
  public BaseDomain getTestObject(Integer number, Integer sequence, Boolean addChildrenFlag) {
    JsonExample jsonExample = new JsonExample()
    
    jsonExample.setJsonFoo(new java.util.ArrayList())
    jsonExample.setJsonBar(new java.util.HashMap<String,Integer>())
    jsonExample.setJsonBaz(['bazzy' : new Solo(42)])
    jsonExample.setJsonList([DATE, JSON])
    
    jsonExample
  }

  @Override
  public BaseDomain updateDomainObject(Integer number, BaseDomain domain) {
    JsonExample source = getTestObject(number, 0)
    JsonExample target = (JsonExample)domain
    target.setJsonFoo(source.getJsonFoo())
    target.setJsonBar(source.getJsonBar())
    target.setJsonBaz(source.getJsonBaz())
    target.setJsonList(source.getJsonList())

    return source
  }

  @Override
  public void assertDomainUpdates(BaseDomain expected, BaseDomain actual) {
    JsonExample expectedD = (JsonExample)expected
    JsonExample actualD = (JsonExample)actual
    assertEquals("jsonFoo is different than expected", expectedD.getJsonFoo(), actualD.getJsonFoo())
    assertEquals("jsonBar is different than expected", expectedD.getJsonBar(), actualD.getJsonBar())
    assertEquals("jsonBaz is different than expected", expectedD.getJsonBaz(), actualD.getJsonBaz())
    assertEquals("jsonList is different than expected", expectedD.getJsonList(), actualD.getJsonList())
  }
  
  @Override
  void deleteObject(BaseDomain domain) {
    if (domain == null) {
      return
    }
    JsonExample target = (JsonExample)domain

    jsonExampleDao.delete(target)
    jsonExampleDao.flush()
    jsonExampleDao.evict(target)
  }
}