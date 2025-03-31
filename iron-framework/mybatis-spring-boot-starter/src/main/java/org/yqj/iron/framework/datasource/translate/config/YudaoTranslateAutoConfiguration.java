package org.yqj.iron.framework.datasource.translate.config;

import com.fhs.trans.service.impl.TransService;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.yqj.iron.framework.datasource.translate.core.TranslateUtils;

@AutoConfiguration
public class YudaoTranslateAutoConfiguration {

    @Bean
    @SuppressWarnings({"InstantiationOfUtilityClass", "SpringJavaInjectionPointsAutowiringInspection"})
    public TranslateUtils translateUtils(TransService transService) {
        TranslateUtils.init(transService);
        return new TranslateUtils();
    }

}
