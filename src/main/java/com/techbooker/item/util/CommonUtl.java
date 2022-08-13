package com.techbooker.item.util;

import com.sun.codemodel.JCodeModel;
import com.techbooker.item.annotation.JsonToPojoCustomAnnotator;
import lombok.extern.slf4j.Slf4j;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Slf4j
@Component
public class CommonUtl {
    public static void convertJsonToPojoClass(String json, String packageName, String javaClassName, File outputPojoDirectory) {
        GenerationConfig config = jsonToPojoCustomConfig();

        SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
        try {
            JCodeModel jcodeModel = new JCodeModel();
            mapper.generate(jcodeModel, javaClassName, packageName, json);
            jcodeModel.build(outputPojoDirectory);
        } catch (IOException ioe) {
            log.error("Encountered issue while converting to pojo: {}", ioe.getMessage());
        }
    }

    private static GenerationConfig jsonToPojoCustomConfig() {
        return new DefaultGenerationConfig() {
            @Override
            public boolean isGenerateBuilders() {
                return true;
            }

            @Override
            public SourceType getSourceType() {
                return SourceType.JSON;
            }

            @Override
            public boolean isIncludeDynamicBuilders() {
                return true;
            }

            @Override
            public boolean isIncludeGetters() {
                return true;
            }

            @Override
            public boolean isIncludeSetters() {
                return true;
            }

            @Override
            public Class<? extends Annotator> getCustomAnnotator() {
                return JsonToPojoCustomAnnotator.class;
            }
        };
    }


}
