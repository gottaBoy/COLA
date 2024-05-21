package com.zeron.sophon.extension;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * ExtensionRepository
 */
@Component
public class ExtensionRepository {

    public Map<ExtensionCoordinate, ExtensionPointI> getExtensionRepo() {
        return extensionRepo;
    }

    private Map<ExtensionCoordinate, ExtensionPointI> extensionRepo = new HashMap<>();


}
