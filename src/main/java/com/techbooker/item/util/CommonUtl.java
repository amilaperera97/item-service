package com.techbooker.item.util;

import com.sun.codemodel.JCodeModel;
import com.techbooker.item.annotation.JsonToPojoCustomAnnotator;
import com.techbooker.item.dto.ParamDataDto;
import com.techbooker.item.dto.internal.InternalParam;
import com.techbooker.item.dto.internal.InternalParamNamesDto;
import lombok.extern.slf4j.Slf4j;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Map;

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


    public void responseReader(InternalParamNamesDto internalParamNamesValue, JSONObject response, Map<String, ParamDataDto> responseParam) {
        responseParam.forEach((externalParam, data) -> {
            try {
                InternalParam internalParam = InternalParam.valueOf(data.getInternalParam().getParamName().toUpperCase());
                switch (internalParam) {
                    case PRICE:
                        internalParamNamesValue.setPrice(String.valueOf(response.get(data.getExternalParamName())));
                        break;
                    case USERNAME:
                        internalParamNamesValue.setUsername(String.valueOf(response.get(data.getExternalParamName())));
                        break;
                    case ROLE:
                        internalParamNamesValue.setRole(String.valueOf(response.get(data.getExternalParamName())));
                        break;
                    case BARCODE:
                        internalParamNamesValue.setBarcode(String.valueOf(response.get(data.getExternalParamName())));
                        break;
                }
            } catch (JSONException e) {
                log.error("Unable to get response value : {}", e.getMessage());
            } catch (IllegalArgumentException iae) {
                log.error("Invalid internal param Id : {}", data.getInternalParam().getParamName().toUpperCase());
            }
        });
    }
}
