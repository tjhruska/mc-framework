
package com.tjhruska.mc.domain.system;

import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;

import com.tjhruska.mc.database.BaseDomain
import com.tjhruska.mc.database.DaoDomain;
import com.tjhruska.mc.database.test.GeneratedDomainAndDaoTest;
import com.tjhruska.mc.domain.system.Column;
import com.tjhruska.mc.domain.system.Index;
import com.tjhruska.mc.enums.TableCreationRule
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.tjhruska.mc.domain.system.Column;
import com.tjhruska.mc.domain.system.ColumnTest;
import com.tjhruska.mc.domain.system.Index;
import com.tjhruska.mc.domain.system.IndexTest;
  

//    Class contains database constraints which can't be accomadated in autogenerated code.
//    To activate test: extend test class, and tweak fields with constraints to match database expectations.
//    (Extended class won't be wiped out on regeneration, and must continue to match database expectations.)
@Ignore 
class TableTest extends GeneratedDomainAndDaoTest {
  
  @Autowired
  DaoDomain<Table> tableDao

  @Autowired
  DaoDomain<Column> columnDao
  ColumnTest columnTest

  @Autowired
  DaoDomain<Index> indexDao
  IndexTest indexTest

  @Before
  public void setup() {
    columnTest = new ColumnTest()
    columnTest.columnDao = columnDao

    indexTest = new IndexTest()
    indexTest.indexDao = indexDao
  }

  @Override
  public DaoDomain getDao() {
    tableDao
  }


  @Override
  public BaseDomain getTestObject(Integer number, Integer sequence) {
    Table table = new Table()
    
    table.setSystemNoModifyFlag(3%number == 0)
    table.setName("name${number}")
    table.setDescription("description${number}")
    table.setNameCamelCase("name_camel_case${number}")
    table.setTableCreationRule(TableCreationRule.getTableCreationRuleBySequence(1))
    table.setSuppressTableChangesFlag(8%number == 0)
    table.setCreateIUDTableFlag(9%number == 0)
    table.setSchemaName("schema_name${number}")
    table.setWithinCreateSQL("within_create_sql${number}")
    table.setPostCreateSQL("post_create_sql${number}")
    table.setCreatePOJOFlag(13%number == 0)
    table.setSrcFolderTag("src_folder_tag${number}")
    table.setSuppressPOJOChangesFlag(15%number == 0)
    table.setJavaPackage("java_package${number}")
    table.setJavaFullyQualifiedSuperClass("java_fq_superclass${number}")
    table.setConstructorFromFieldsFlag(18%number == 0)
    table.setExtraJavaCode("extra_java_code${number}")
    table.setCreateORMFlag(20%number == 0)
    table.setSuppressORMChangesFlag(21%number == 0)
    table.setExtraORMCode("extra_orm_code${number}")
    table.setOrmDiscriminatorColumnId(number)
    table.setCreateGUIDataServiceFlag(24%number == 0)
    table.setSuppressGUIDataServiceChangesFlag(25%number == 0)
    table.setGuiPagifyFlag(26%number == 0)
    table.setGuiRecordsPerPage((Short)(27 * number))
    table.setGuiPickerDescriptionColumnId(number)
    
    List<Column> columns = new ArrayList()
    if (columnTest != null) {
      columnTest.table = table
      (1..(10-number)).each { i ->
      columns.add(columnTest.getTestObject(i, i-1))
      }
    }
    table.setColumns(columns)

    Set<Index> indexes = new HashSet()
    if (indexTest != null) {
      indexTest.table = table
      (1..(10-number)).each { i ->
      indexes.add(indexTest.getTestObject(i, i-1))
      }
    }
    table.setIndexes(indexes)

    table
  }

  @Override
  public BaseDomain updateDomainObject(Integer number, BaseDomain domain) {
    Table source = getTestObject(number, 0)
    Table target = (Table)domain
    target.setSystemNoModifyFlag(source.getSystemNoModifyFlag())
    target.setName(source.getName())
    target.setDescription(source.getDescription())
    target.setNameCamelCase(source.getNameCamelCase())
    target.setTableCreationRule(source.getTableCreationRule())
    target.setSuppressTableChangesFlag(source.getSuppressTableChangesFlag())
    target.setCreateIUDTableFlag(source.getCreateIUDTableFlag())
    target.setSchemaName(source.getSchemaName())
    target.setWithinCreateSQL(source.getWithinCreateSQL())
    target.setPostCreateSQL(source.getPostCreateSQL())
    target.setCreatePOJOFlag(source.getCreatePOJOFlag())
    target.setSrcFolderTag(source.getSrcFolderTag())
    target.setSuppressPOJOChangesFlag(source.getSuppressPOJOChangesFlag())
    target.setJavaPackage(source.getJavaPackage())
    target.setJavaFullyQualifiedSuperClass(source.getJavaFullyQualifiedSuperClass())
    target.setConstructorFromFieldsFlag(source.getConstructorFromFieldsFlag())
    target.setExtraJavaCode(source.getExtraJavaCode())
    target.setCreateORMFlag(source.getCreateORMFlag())
    target.setSuppressORMChangesFlag(source.getSuppressORMChangesFlag())
    target.setExtraORMCode(source.getExtraORMCode())
    target.setOrmDiscriminatorColumnId(source.getOrmDiscriminatorColumnId())
    target.setCreateGUIDataServiceFlag(source.getCreateGUIDataServiceFlag())
    target.setSuppressGUIDataServiceChangesFlag(source.getSuppressGUIDataServiceChangesFlag())
    target.setGuiPagifyFlag(source.getGuiPagifyFlag())
    target.setGuiRecordsPerPage(source.getGuiRecordsPerPage())
    target.setGuiPickerDescriptionColumnId(source.getGuiPickerDescriptionColumnId())

    target.columns.each {
      columnTest.getDao().delete(it)
    }
    target.columns.clear()
    source.columns.each {
      it.table = target
    }
    target.columns.addAll(source.columns)
    target.indexes.each {
      indexTest.getDao().delete(it)
    }
    target.indexes.clear()
    source.indexes.each {
      it.table = target
    }
    target.indexes.addAll(source.indexes)

    return source
  }

  @Override
  public void assertDomainUpdates(BaseDomain expected, BaseDomain actual) {
    Table expectedD = (Table)expected
    Table actualD = (Table)actual
    assertEquals("systemNoModifyFlag is different than expected", expectedD.getSystemNoModifyFlag(), actualD.getSystemNoModifyFlag())
    assertEquals("name is different than expected", expectedD.getName(), actualD.getName())
    assertEquals("description is different than expected", expectedD.getDescription(), actualD.getDescription())
    assertEquals("nameCamelCase is different than expected", expectedD.getNameCamelCase(), actualD.getNameCamelCase())
    assertEquals("tableCreationRule is different than expected", expectedD.getTableCreationRule(), actualD.getTableCreationRule())
    assertEquals("suppressTableChangesFlag is different than expected", expectedD.getSuppressTableChangesFlag(), actualD.getSuppressTableChangesFlag())
    assertEquals("createIUDTableFlag is different than expected", expectedD.getCreateIUDTableFlag(), actualD.getCreateIUDTableFlag())
    assertEquals("schemaName is different than expected", expectedD.getSchemaName(), actualD.getSchemaName())
    assertEquals("withinCreateSQL is different than expected", expectedD.getWithinCreateSQL(), actualD.getWithinCreateSQL())
    assertEquals("postCreateSQL is different than expected", expectedD.getPostCreateSQL(), actualD.getPostCreateSQL())
    assertEquals("createPOJOFlag is different than expected", expectedD.getCreatePOJOFlag(), actualD.getCreatePOJOFlag())
    assertEquals("srcFolderTag is different than expected", expectedD.getSrcFolderTag(), actualD.getSrcFolderTag())
    assertEquals("suppressPOJOChangesFlag is different than expected", expectedD.getSuppressPOJOChangesFlag(), actualD.getSuppressPOJOChangesFlag())
    assertEquals("javaPackage is different than expected", expectedD.getJavaPackage(), actualD.getJavaPackage())
    assertEquals("javaFullyQualifiedSuperClass is different than expected", expectedD.getJavaFullyQualifiedSuperClass(), actualD.getJavaFullyQualifiedSuperClass())
    assertEquals("constructorFromFieldsFlag is different than expected", expectedD.getConstructorFromFieldsFlag(), actualD.getConstructorFromFieldsFlag())
    assertEquals("extraJavaCode is different than expected", expectedD.getExtraJavaCode(), actualD.getExtraJavaCode())
    assertEquals("createORMFlag is different than expected", expectedD.getCreateORMFlag(), actualD.getCreateORMFlag())
    assertEquals("suppressORMChangesFlag is different than expected", expectedD.getSuppressORMChangesFlag(), actualD.getSuppressORMChangesFlag())
    assertEquals("extraORMCode is different than expected", expectedD.getExtraORMCode(), actualD.getExtraORMCode())
    assertEquals("ormDiscriminatorColumn is different than expected", expectedD.getOrmDiscriminatorColumnId(), actualD.getOrmDiscriminatorColumnId())
    assertEquals("createGUIDataServiceFlag is different than expected", expectedD.getCreateGUIDataServiceFlag(), actualD.getCreateGUIDataServiceFlag())
    assertEquals("suppressGUIDataServiceChangesFlag is different than expected", expectedD.getSuppressGUIDataServiceChangesFlag(), actualD.getSuppressGUIDataServiceChangesFlag())
    assertEquals("guiPagifyFlag is different than expected", expectedD.getGuiPagifyFlag(), actualD.getGuiPagifyFlag())
    assertEquals("guiRecordsPerPage is different than expected", expectedD.getGuiRecordsPerPage(), actualD.getGuiRecordsPerPage())
    assertEquals("guiPickerDescriptionColumn is different than expected", expectedD.getGuiPickerDescriptionColumnId(), actualD.getGuiPickerDescriptionColumnId())
    assertEquals("size of columns is different than expected", expectedD.columns.size(), actualD.columns.size())
    assertEquals("size of indexes is different than expected", expectedD.indexes.size(), actualD.indexes.size())
  }

  @Override
  public void deleteChildrenIfNeeded(BaseDomain domain) {
    Table target = (Table)domain
    target.columns.each {
      columnTest.getDao().delete(it)
    }
    target.indexes.each {
      indexTest.getDao().delete(it)
    }
  }
}