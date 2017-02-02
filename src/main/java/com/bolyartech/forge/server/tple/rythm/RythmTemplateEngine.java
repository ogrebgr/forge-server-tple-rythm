package com.bolyartech.forge.server.tple.rythm;

import com.bolyartech.forge.server.misc.TemplateEngine;
import org.rythmengine.RythmEngine;

import java.util.HashMap;
import java.util.Map;


public class RythmTemplateEngine implements TemplateEngine {
    private final RythmEngine mRythmEngine;
    private final Map<String, Object> mAttributes = new HashMap<>();


    public RythmTemplateEngine(RythmEngine rythmEngine) {
        mRythmEngine = rythmEngine;
    }


    @Override
    public void assign(String varName, Object object) {
        mAttributes.put(varName, object);
    }


    @Override
    public String render(String templateName) {
        return mRythmEngine.render(templateName, mAttributes);
    }
}
