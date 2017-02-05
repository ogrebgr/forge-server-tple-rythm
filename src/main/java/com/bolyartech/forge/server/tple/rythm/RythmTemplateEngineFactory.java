package com.bolyartech.forge.server.tple.rythm;

import com.bolyartech.forge.server.misc.TemplateEngine;
import com.bolyartech.forge.server.misc.TemplateEngineFactory;
import org.rythmengine.Rythm;
import org.rythmengine.RythmEngine;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class RythmTemplateEngineFactory implements TemplateEngineFactory {
    private final String mTemplatePathPrefix;
    private final RythmEngine mRythmEngine;


    public RythmTemplateEngineFactory(String templatePathPrefix, RythmEngine rythmEngine) {
        mTemplatePathPrefix = templatePathPrefix;
        mRythmEngine = rythmEngine;
    }


    public RythmTemplateEngineFactory(String templatePathPrefix) {
        if (templatePathPrefix.startsWith(File.separator)) {
            templatePathPrefix = templatePathPrefix.substring(1);
        }
        mTemplatePathPrefix = templatePathPrefix;

        Map<String, Object> confs = new HashMap<>();
        confs.put("home.template.dir", mTemplatePathPrefix);
        Rythm.init(confs);
        mRythmEngine = Rythm.engine();
    }


    @Override
    public TemplateEngine createNew() {
        return new RythmTemplateEngine(mRythmEngine);
    }
}
