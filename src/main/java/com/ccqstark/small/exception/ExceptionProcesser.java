package com.ccqstark.small.exception;

import com.ccqstark.small.common.CommonResult;
import com.ccqstark.small.common.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * @author ccqstark
 * @description 错误捕获类
 * @date 2021/2/20 8:30 下午
 */
@Slf4j
@RestControllerAdvice
public class ExceptionProcesser extends ResponseEntityExceptionHandler {

    /**
     * 处理上传文件过大错误
     */
    @ExceptionHandler(MultipartException.class)
    public CommonResult<String> handleUploadFileTooLargeError() {
        return CommonResult.failed(ResultCode.FILE_TOO_BIG);
    }

    /**
     * 全局异常捕获入日志
     */
    @ExceptionHandler(value = Exception.class)
    public CommonResult<String> defaultErrorHandler(Exception e) {
        log.error("defaultErrorHandler:", e);
        return CommonResult.failed("系统出错，请联系开发者");
    }

}