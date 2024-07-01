package com.abdurrahmanbulut.justlearn.di

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import java.nio.charset.StandardCharsets


class CustomHttpLoggingInterceptor : Interceptor {

    private val logger = HttpLoggingInterceptor.Logger.DEFAULT

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        logRequest(request)
        val response = chain.proceed(request)
        return logAndCloneResponse(response)
    }

    private fun logRequest(request: Request) {
        logger.log("REQUEST:")
        logger.log("${request.method} ${request.url}")
        request.headers.forEach { header ->
            logger.log("${header.first}: ${header.second}")
        }
        request.body?.let { body ->
            logger.log("Body: ${bodyToString(body)}")
        }
        logger.log("END REQUEST")
    }

    private fun logAndCloneResponse(response: Response): Response {
        val responseBody = response.body
        val responseBodyString = responseBody?.string()

        logger.log("RESPONSE:")
        logger.log("${response.code} ${response.message} ${response.request.url}")
        response.headers.forEach { header ->
            logger.log("${header.first}: ${header.second}")
        }
        responseBodyString?.let {
            logger.log("Body: $it")
        }
        logger.log("END RESPONSE")

        // Rebuild the response before returning it because response.body().string() closes the response
        return response.newBuilder()
            .body(ResponseBody.create(responseBody?.contentType(), responseBodyString ?: ""))
            .build()
    }

    private fun bodyToString(requestBody: RequestBody): String {
        return try {
            val buffer = okio.Buffer()
            requestBody.writeTo(buffer)
            buffer.readString(StandardCharsets.UTF_8)
        } catch (e: Exception) {
            "Couldn't parse request body"
        }
    }
}