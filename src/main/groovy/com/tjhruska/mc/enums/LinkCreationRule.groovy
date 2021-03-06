/**
Copyright 2007-2015 Timothy James Hruska (tjhruska@yahoo.com)

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
  
package com.tjhruska.mc.enums

import groovy.transform.ToString

import java.util.HashSet
import java.util.Set

import com.tjhruska.mc.enums.EnumerationNotUnique


@ToString (includeNames = true, includePackage=false, includeFields=true)
enum LinkCreationRule {
    N_TO_N(29, "N_TO_N", "N to N", 1, "Will Create Linking Table"),
    N_TO_ONE(30, "N_TO_ONE", "N to 1", 2, "Table A has FK Column to B"),
    ONE_TO_N(31, "ONE_TO_N", "1 to N", 3, "Table B has FK Column to A")

    final static int enumerationId = 7
    final static String idColumnName = "linkCreationRule_ev_id"
    final static LinkCreationRuleHelper linkCreationRuleHelper = LinkCreationRuleHelper.getLinkCreationRuleHelper()
    
    final int linkCreationRuleEvId
    final String name
    final String description
    final Integer sequence
    final String databaseNote
    
    private LinkCreationRule(
        int linkCreationRuleEvId, String name, String description, Integer sequence
        , String databaseNote)
    {
        this.linkCreationRuleEvId = linkCreationRuleEvId
        this.name = name
        this.description = description
        this.sequence = sequence
        this.databaseNote = databaseNote
        LinkCreationRuleHelper.getLinkCreationRuleHelper().loadLinkCreationRule(
            this, linkCreationRuleEvId, name, description, sequence
            , databaseNote)
    }
    
    /**
     * @param id
     * @return LinkCreationRule that is mapped to by the input parameter
     * @throws EnumerationNotUnique if the input parameter mapps to multiple values
     */
    static LinkCreationRule getLinkCreationRuleById(int id){
        Set<LinkCreationRule> linkCreationRules = linkCreationRuleHelper.idToLinkCreationRule.get(id)
        if (linkCreationRules == null) return null
        if (linkCreationRules.size() > 1)
            throw new EnumerationNotUnique("id " + id 
                + " has " + linkCreationRules.size() + " elements")
        return linkCreationRules.iterator().next()
    }
    
    /**
     * @param id
     * @return LinkCreationRule that is mapped to by the input parameter
     */
    static Set<LinkCreationRule> getLinkCreationRuleSetById(int id){
        return new HashSet<LinkCreationRule>(linkCreationRuleHelper.idToLinkCreationRule.get(id))
    }
    
    /**
     * @param name
     * @return LinkCreationRule that is mapped to by the input parameter
     * @throws EnumerationNotUnique if the input parameter mapps to multiple values
     */
    static LinkCreationRule getLinkCreationRuleByName(String name){
        Set<LinkCreationRule> linkCreationRules = linkCreationRuleHelper.nameToLinkCreationRule.get(name)
        if (linkCreationRules == null) return null
        if (linkCreationRules.size() > 1)
            throw new EnumerationNotUnique("name " + name 
                + " has " + linkCreationRules.size() + " elements")
        return linkCreationRules.iterator().next()
    }
    
    /**
     * @param name
     * @return LinkCreationRule that is mapped to by the input parameter
     */
    static Set<LinkCreationRule> getLinkCreationRuleSetByName(String name){
        return new HashSet<LinkCreationRule>(linkCreationRuleHelper.nameToLinkCreationRule.get(name))
    }
    
    /**
     * @param description
     * @return LinkCreationRule that is mapped to by the input parameter
     * @throws EnumerationNotUnique if the input parameter mapps to multiple values
     */
    static LinkCreationRule getLinkCreationRuleByDescription(String description){
        Set<LinkCreationRule> linkCreationRules = linkCreationRuleHelper.descriptionToLinkCreationRule.get(description)
        if (linkCreationRules == null) return null
        if (linkCreationRules.size() > 1)
            throw new EnumerationNotUnique("description " + description 
                + " has " + linkCreationRules.size() + " elements")
        return linkCreationRules.iterator().next()
    }
    
    /**
     * @param description
     * @return LinkCreationRule that is mapped to by the input parameter
     */
    static Set<LinkCreationRule> getLinkCreationRuleSetByDescription(String description){
        return new HashSet<LinkCreationRule>(linkCreationRuleHelper.descriptionToLinkCreationRule.get(description))
    }
    
    /**
     * @param sequence
     * @return LinkCreationRule that is mapped to by the input parameter
     * @throws EnumerationNotUnique if the input parameter mapps to multiple values
     */
    static LinkCreationRule getLinkCreationRuleBySequence(Integer sequence){
        Set<LinkCreationRule> linkCreationRules = linkCreationRuleHelper.sequenceToLinkCreationRule.get(sequence)
        if (linkCreationRules == null) return null
        if (linkCreationRules.size() > 1)
            throw new EnumerationNotUnique("sequence " + sequence 
                + " has " + linkCreationRules.size() + " elements")
        return linkCreationRules.iterator().next()
    }
    
    /**
     * @param sequence
     * @return LinkCreationRule that is mapped to by the input parameter
     */
    static Set<LinkCreationRule> getLinkCreationRuleSetBySequence(Integer sequence){
        return new HashSet<LinkCreationRule>(linkCreationRuleHelper.sequenceToLinkCreationRule.get(sequence))
    }
    /**
     * @param databaseNote
     * @return LinkCreationRule that is mapped to by the input parameter
     * @throws EnumerationNotUnique if the input parameter mapps to multiple values
     */
    static LinkCreationRule getLinkCreationRuleByDatabaseNote(String databaseNote){
        Set<LinkCreationRule> linkCreationRules = linkCreationRuleHelper.databaseNoteToLinkCreationRule.get(databaseNote)
        if (linkCreationRules == null) return null
        if (linkCreationRules.size() > 1)
            throw new EnumerationNotUnique("databaseNote " + databaseNote 
                + " has " + linkCreationRules.size() + " elements")
        return linkCreationRules.iterator().next()
    }
    
    /**
     * @param databaseNote
     * @return LinkCreationRule that is mapped to by the input parameter
     */
    static Set<LinkCreationRule> getLinkCreationRuleSetByDatabaseNote(String databaseNote){
        return new HashSet<LinkCreationRule>(linkCreationRuleHelper.databaseNoteToLinkCreationRule.get(databaseNote))
    }
}