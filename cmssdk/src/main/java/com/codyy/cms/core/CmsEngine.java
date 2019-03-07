package com.codyy.cms.core;

public class CmsEngine {
    private static volatile CmsEngine cmsEngineInstance;
    public static CmsEngine getInstance(){
        if(cmsEngineInstance==null){
            synchronized (CmsEngine.class){
                if(cmsEngineInstance==null){
                    cmsEngineInstance=new CmsEngine();
                }
            }
        }
        return cmsEngineInstance;
    }
}
