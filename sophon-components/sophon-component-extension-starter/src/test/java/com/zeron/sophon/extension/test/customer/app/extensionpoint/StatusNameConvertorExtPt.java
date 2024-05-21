package com.zeron.sophon.extension.test.customer.app.extensionpoint;

import com.zeron.sophon.extension.ExtensionPointI;

public interface StatusNameConvertorExtPt extends ExtensionPointI {
    String statusNameConvertor(Integer statusCode);
}
