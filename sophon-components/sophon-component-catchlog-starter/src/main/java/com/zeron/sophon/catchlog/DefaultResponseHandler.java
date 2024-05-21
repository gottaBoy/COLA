package com.zeron.sophon.catchlog;


import com.zeron.sophon.dto.Response;
import com.zeron.sophon.exception.BaseException;
import lombok.extern.slf4j.Slf4j;

/**
 * ResponseHandler
 */
@Slf4j
public class DefaultResponseHandler implements ResponseHandlerI{

    @Override
    public  Object handle(Class returnType, String errCode, String errMsg){
        if (isSophonResponse(returnType)){
            return handlesophonResponse(returnType, errCode, errMsg);
        }
        return null;
    }

    public  Object handle(Class returnType, BaseException e){
        return handle(returnType, e.getErrCode(), e.getMessage());
    }


    private static Object handlesophonResponse(Class returnType, String errCode, String errMsg) {
        try {
            Response response = (Response)returnType.newInstance();
            response.setSuccess(false);
            response.setErrCode(errCode);
            response.setErrMessage(errMsg);
            return response;
        }
        catch (Exception ex){
            log.error(ex.getMessage(), ex);
            return  null;
        }
    }

    private static boolean isSophonResponse(Class returnType) {
        return  returnType == Response.class || returnType.getGenericSuperclass() == Response.class;
    }
}
