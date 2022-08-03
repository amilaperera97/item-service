package com.techbooker.item.annotation;

import com.fasterxml.jackson.databind.JsonNode;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JFieldVar;
import lombok.Builder;
import org.jsonschema2pojo.AbstractAnnotator;

public class JsonToPojoCustomAnnotator extends AbstractAnnotator {
    @Override
    public void propertyField(JFieldVar field, JDefinedClass clazz, String propertyName, JsonNode propertyNode) {
        super.propertyField(field, clazz, propertyName, propertyNode);
        field.annotate(Builder.class);
    }
}
